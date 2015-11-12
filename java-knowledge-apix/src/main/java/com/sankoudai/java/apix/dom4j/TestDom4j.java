package com.sankoudai.java.apix.dom4j;

import junit.framework.TestCase;
import org.dom4j.*;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

import java.io.*;
import java.util.List;

/**
 * @author : sankoudai
 * @version : created at 2015/10/25
 */
public class TestDom4j extends TestCase {

    /**
     * SAXReader.read将源文件解析成Document对象
     *
     * @throws IOException
     * @throws DocumentException
     */
    public void testSAXReader() throws IOException, DocumentException {
        /* 获取in */
        BufferedReader in = exampleReader();

        /* reader从in中读取数据解析为doc对象 */
        SAXReader reader = new SAXReader();
        Document document = reader.read(in);
        in.close();

        /* 输出文件中的内容 */
        System.out.println(document.asXML());
    }

    /**
     * Document.getRootElement() : 获取根元素
     * element.elements(): 获取所有子元素
     * element.element("name"): 获取指定名字的子元素, 如果有多个返回第一个
     * element.getTextTrim(): 获取元素的文本内容(去除空格)
     * element.getName(): 获取元素的节点名
     * element.elementTextTrim("name"): 获取指定名字的子元素的文本内容
     *
     * @throws IOException
     * @throws DocumentException
     */
    public void testElement() throws IOException, DocumentException {
        /* 获取in */
        BufferedReader in = exampleReader();

        /*获取 SAXReader */
        SAXReader reader = new SAXReader();

        /* 读取并转换为 Document */
        Document document = reader.read(in);
        in.close();

        /* 获取 root Element */
        Element root = document.getRootElement();

        /* 获取 root的所有子element */
        List<Element> elements = root.elements();

        /* 指定名字的子元素*/
        Element bookElement = elements.get(0);
        Element nameElement = bookElement.element("name");

        /* 获取element的文本内容 */
        String bookName = nameElement.getTextTrim();
        System.out.printf("testElement-bookname =%s, \n", bookName);

        /* 直接获取指定子元素的文本 */
        bookName = bookElement.elementTextTrim("name");
        System.out.printf("testElement-bookname =%s, \n", bookName);

        /* 获取element的名字 */
        String name = bookElement.getName();
        System.out.printf("testElement-name =%s, \n", name);
    }

    /**
     * element.attribute("name"): 获取元素指定名字的属性
     *
     * @throws IOException
     * @throws DocumentException
     */
    public void testAttribute() throws IOException, DocumentException {
        /* 获取Document */
        BufferedReader in = exampleReader();
        SAXReader reader = new SAXReader();
        Document document = reader.read(in);
        in.close();

        /* 获取第一个book 元素 */
        Element aBook = document.getRootElement().element("book");

        /* 获取 book元素的id属性*/
        Attribute id = aBook.attribute("id");
        String attributeName = id.getName();
        String attributeText = id.getText();
        System.out.printf("testAttribute: attribute name=%s, attribute text=%s \n", attributeName, attributeText);
    }

    public void testSelectNodes() throws IOException, DocumentException {
        /* 获取Document */
        BufferedReader in = exampleReader();
        SAXReader reader = new SAXReader();
        Document document = reader.read(in);
        in.close();

        /*使用xpath*/

        /* 根节点-->books-->book元素列表（所有）*/
        String xpath = "/books/book";
        List<Element> elements = document.selectNodes(xpath);
        printXpath(xpath, elements);

        /* 根节点-->books-->book元素(第二个) */
        xpath = "/books/book[2]";
        Element element = (Element) document.selectSingleNode(xpath);
        printXpath(xpath, element);

        /* 获取属于books节点的最后一个book元素 */
        xpath = "/books/book[last()]";
        element = (Element) document.selectSingleNode(xpath);
        printXpath(xpath, element);

        /* 获取属于books节点的倒数第二个book元素 */
        xpath = "/books/book[last() -1 ]";
        element = (Element) document.selectSingleNode(xpath);
        printXpath(xpath, element);

        /* 选取所有 book 子元素的name子元素， 而不管它们在文档中的位置 */
        xpath = "//book/name";
        elements = document.selectNodes(xpath);
        printXpath(xpath, elements);

        /* 选取所有book元素, (要求有值为A3的id属性)*/
        xpath = "//book[@id='A3']";
        elements = document.selectNodes(xpath);
        printXpath(xpath, elements);

        /*选取名为id 的所有属性*/
        xpath = "//@id";
        List<Attribute> attributes = document.selectNodes(xpath);
        printXpath(xpath, attributes);

        /* 选取element下的子元素 */
        System.out.println("----------------------------------");
        Element book = document.getRootElement().element("book");
        /*绝对路径*/
        xpath = "/books/book";
        elements = book.selectNodes(xpath);
        printXpath(xpath, elements);

        /*相对路径： 当前元素的name子元素*/
        xpath = "name";
        elements = book.selectNodes(xpath);
        printXpath(xpath, elements);
    }

    /**
     * element.content()： 获取所有孩子包括元素, text等
     * @throws IOException
     * @throws DocumentException
     */
    public void testContent() throws IOException, DocumentException {
        /* 获取Document */
        BufferedReader in = exampleReader();
        SAXReader reader = new SAXReader();
        Document document = reader.read(in);
        in.close();

        /* 获取一个book元素 */
        Element element = document.getRootElement().element("book");

        /* 获取元素的全部孩子 */
        List<Node> children = element.content();
        System.out.printf("contentTest---children: size=%s\n", children.size());
        for(Node child : children){
            System.out.printf("contentTest---child: nodeType=%s, xml=%s\n", child.getNodeType(), child.asXML());
        }
    }

    /**
     * DocumentHelper.createDocument(): 创建Document对象
     * document.addElement("rootname"): 添加root元素
     * element.addElement("elementName"): 添加子元素
     * element.addAttribute("attrName", "attrValue"): 添加属性
     *
     * XMLWriter.write(document): 将内存中的Document对象写到文件中
     * @throws IOException
     */
    public void testCreate() throws IOException {
        /* 创建Document */
        Document doc = DocumentHelper.createDocument();

        /* 添加根元素 */
        Element root = doc.addElement("database");

        /* 添加属性 */
        root.addAttribute("type", "oracle");

        /* 添加元素 */
        root.addElement("username").addText("sankoudai");
        root.addElement("password").addText("sankoudai");

        /* 写出到文件 */
        Writer out = new OutputStreamWriter(new FileOutputStream("database.xml"), "utf-8");
        OutputFormat fmt = OutputFormat.createPrettyPrint();
        XMLWriter writer = new XMLWriter(out, fmt);

        writer.write(doc);
        writer.close();
    }

    /*-----工具方法--------*/
    private BufferedReader exampleReader() throws UnsupportedEncodingException {
        InputStream is = getClass().getResourceAsStream("/dom4j/books.xml");
        BufferedReader reader = new BufferedReader(new InputStreamReader(is, "utf-8"));

        return reader;
    }

    private void printXpath(String xpath, List nodes) {
        System.out.printf("xpath=%s \n", xpath);
        for (Object node : nodes) {
            Node n = (Node) node;
            System.out.println(n.asXML());
        }
        System.out.println();
    }

    private void printXpath(String xpath, Node node) {
        System.out.printf("xpath=%s \n", xpath);
        System.out.printf("element=\n %s\n", node.asXML());
        System.out.println();
    }
}
