package com.sankoudai.java.apix.xstream;

import com.sankoudai.java.apix.xstream.entity.Address;
import com.sankoudai.java.apix.xstream.entity.AnnotatedAddress;
import com.sankoudai.java.apix.xstream.entity.AnnotatedStudent;
import com.sankoudai.java.apix.xstream.entity.Student;
import com.sun.xml.internal.bind.api.impl.NameConverter;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.converters.SingleValueConverter;
import com.thoughtworks.xstream.io.xml.StaxDriver;
import junit.framework.TestCase;
import org.xml.sax.InputSource;

import javax.xml.transform.OutputKeys;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.sax.SAXSource;
import javax.xml.transform.sax.SAXTransformerFactory;
import javax.xml.transform.stream.StreamResult;
import java.io.*;
import java.util.Arrays;

/**
 * Created by xuliufeng on 2015/12/20.
 */
public class TestXStream extends TestCase {
    public void testConverter() {
        AnnotatedStudent student = exampleAnnotatedStudent();

        XStream xStream = new XStream(new StaxDriver());
        xStream.autodetectAnnotations(true);
        xStream.registerConverter(new AddressConverter());
        String xml = xStream.toXML(student);
        System.out.println(formatXml(xml));
    }

    public void testAnnotation() {
        AnnotatedStudent student = exampleAnnotatedStudent();

        //显示指定使用的标记
        XStream xStream = new XStream(new StaxDriver());
        xStream.processAnnotations(AnnotatedStudent.class);
        xStream.processAnnotations(AnnotatedAddress.class);
        String xml = xStream.toXML(student);
        System.out.println(formatXml(xml));
        System.out.println();

        //默认开启标记侦测
        xStream = new XStream(new StaxDriver());
        xStream.autodetectAnnotations(true);
        xml = xStream.toXML(student);
        System.out.println(formatXml(xml));
        System.out.println();

        //不开启标记
        xStream = new XStream(new StaxDriver());
        xml = xStream.toXML(student);
        System.out.println(formatXml(xml));
    }

    public void testAlias() {
        Student student = exampleStudent();

        //class alias
        XStream xStream = new XStream(new StaxDriver());
        xStream.alias("student", Student.class);
        String xml = xStream.toXML(student);
        System.out.println(formatXml(xml));
        System.out.println();

        //field alias
        xStream = new XStream(new StaxDriver());
        xStream.aliasField("row", Student.class, "rowNo");
        xml = xStream.toXML(student);
        System.out.println(formatXml(xml));
        System.out.println();

        //attribute alias
        xStream = new XStream(new StaxDriver());
        xStream.useAttributeFor(Student.class, "rowNo");
        xml = xStream.toXML(student);
        System.out.println(formatXml(xml));
        System.out.println();
    }

    public void testToXml() {
        XStream xStream = new XStream(new StaxDriver());

        Student student = exampleStudent();

        String xml = xStream.toXML(student);
        System.out.println(formatXml(xml));
    }

    public void testFromXml() throws UnsupportedEncodingException {
        XStream xStream = new XStream(new StaxDriver());

        Reader reader = exampleReader();

        Student student = (Student) xStream.fromXML(reader);

        System.out.println(student);
    }


    /*----辅助方法----*/
    AnnotatedStudent exampleAnnotatedStudent() {
        AnnotatedStudent student = new AnnotatedStudent();

        student.setFirstName("Mahesh");
        student.setLastName("Parashar");
        student.setRowNo(1);
        student.setClassName("1st");

        AnnotatedAddress address = new AnnotatedAddress();
        address.setArea("Preet Vihar.");
        address.setCity("Delhi");

        student.setAddresses(Arrays.asList(address));
        return student;
    }

    Student exampleStudent() {
        Student student = new Student();
        student.setFirstName("Mahesh");
        student.setLastName("Parashar");
        student.setRowNo(1);
        student.setClassName("1st");

        Address address = new Address();
        address.setArea("H.No. 16/3, Preet Vihar.");
        address.setCity("Delhi");
        address.setState("Delhi");
        address.setCountry("India");
        address.setPincode(110012);

        student.setAddress(address);
        return student;
    }

    private BufferedReader exampleReader() throws UnsupportedEncodingException {
        InputStream is = getClass().getResourceAsStream("/xstream/student.xml");
        BufferedReader reader = new BufferedReader(new InputStreamReader(is, "utf-8"));

        return reader;
    }

    private String formatXml(String xml) {
        try {
            Transformer serializer = SAXTransformerFactory.newInstance().newTransformer();

            serializer.setOutputProperty(OutputKeys.INDENT, "yes");
            serializer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");

            Source xmlSource = new SAXSource(new InputSource(new ByteArrayInputStream(xml.getBytes())));
            StreamResult res = new StreamResult(new ByteArrayOutputStream());

            serializer.transform(xmlSource, res);

            return new String(((ByteArrayOutputStream) res.getOutputStream()).toByteArray());

        } catch (Exception e) {
            return xml;
        }
    }


    public static class AddressConverter implements SingleValueConverter {
        @Override
        public String toString(Object o) {
            if (o == null) {
                return null;
            }
            AnnotatedAddress address = (AnnotatedAddress) o;
            return address.getCity() + "," + address.getArea();
        }

        @Override
        public Object fromString(String s) {
            if(s == null){
                return null;
            }
            String[] addressDetail = s.split(",");

            AnnotatedAddress address = new AnnotatedAddress();
            address.setCity(addressDetail[0]);
            address.setArea(addressDetail[1]);
            return address;
        }

        @Override
        public boolean canConvert(Class type) {
            return AnnotatedAddress.class.equals(type);
        }
    }
}
