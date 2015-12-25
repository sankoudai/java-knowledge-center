package com.sankoudai.java.apix.integrate;

import com.sankoudai.java.apix.integrate.entity.TestObject;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.StaxDriver;
import junit.framework.TestCase;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.*;

/**
 * Created by xuliufeng on 2015/12/20.
 */
public class Test extends TestCase {
    public void test() throws UnsupportedEncodingException, DocumentException {
        SAXReader saxReader = new SAXReader();
        Document document = saxReader.read(exampleReader());
        Element root = document.getRootElement();
        Element trade = (Element) root.selectSingleNode("*/trade");
        System.out.println(trade.asXML());

        XStream xStream = new XStream(new StaxDriver());
        xStream.alias( "trade", TestObject.class);
        TestObject testObject = (TestObject) xStream.fromXML(trade.asXML());
        System.out.println(testObject);
    }

    private BufferedReader exampleReader() throws UnsupportedEncodingException {
        InputStream is = getClass().getResourceAsStream("/integrate/test.xml");
        BufferedReader reader = new BufferedReader(new InputStreamReader(is, "utf-8"));

        return reader;
    }
}
