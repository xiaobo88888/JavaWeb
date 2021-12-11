package clazz;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.junit.Test;

import java.awt.print.Book;
import java.lang.annotation.Documented;
import java.math.BigDecimal;
import java.util.List;

public class dom4jTest {
    @Test
    public void test1() throws Exception {
        //创建一个SaxReader输入流，去读取xml配置文件，生成document对象
        SAXReader saxReader = new SAXReader();

        try {
            Document document = saxReader.read("src/books.xml");

            System.out.println(document);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /*
        读取book.xml文件生成book对象
     */
    @Test
    public void test2() throws DocumentException {
        //1.创建SAXReader输入流，读取xml配置文件，生成document对象
        SAXReader saxReader = new SAXReader();
        Document document = saxReader.read("src/books.xml");
        //2.通过document对象查找根元素
        Element rootElement = document.getRootElement();
        //3.通过根元素获取标签对象
        //element(),elements()都是通过标签名查找子元素
        List<Element> books = rootElement.elements();
        //4.遍历，处理每个标签对象为book类
        for(Element book : books){
            //asXML()是把标签对象转换成标签字符串
            //System.out.println(book.asXML());
            Element nameElement = book.element("name");
            //getText()可以获取标签中的文本内容
            String nameText = nameElement.getText();

            //elementText()可以直接指定标签名的文本内容
            String priceText = book.elementText("price");
            String author = book.elementText("author");

            //获取指定标签的属性值
            String snValue = book.attributeValue("sn");

            System.out.println(new books(snValue, nameText, BigDecimal.valueOf(Double.valueOf(priceText)), author));
        }
    }
}
