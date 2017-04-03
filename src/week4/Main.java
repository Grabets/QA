package week4;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by bogdan on 4/3/2017.
 */
public class Main {
    public static void main(String[] args) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        DocumentBuilder builder;
        Document doc = null;

        try{
            builder = factory.newDocumentBuilder();
            doc = builder.parse("src/week4/books.xml");

            // Create XPathFactory object
            XPathFactory xpathFactory = XPathFactory.newInstance();

            // Create XPath object
            XPath xpath = xpathFactory.newXPath();

            System.out.println("1.Information about computers books:");
            getFullInformationOfComputerBooks(doc, xpath);

            System.out.println("2. Title books which cost greater then 5");
            System.out.println(Arrays.toString(getTitleOfBookWithPriceGreaterFive(doc, xpath).toArray()));

            System.out.println("3. Authors which publish in November");
            System.out.println(getAuthorWhichPublishInNovember(doc, xpath).toString());

            System.out.println("5.Information about book which has id=bk112 and contains word 'Windows' in description:");
            getFullInformationOfWindowsAndIdBook(doc, xpath);

        } catch (ParserConfigurationException | SAXException | IOException e){
            e.printStackTrace();
        }
    }

    private static void getFullInformationOfComputerBooks (Document doc, XPath xpath){
        try{
            XPathExpression expr = xpath.compile("//book[genre='Computer']");
            NodeList nodeList = (NodeList) expr.evaluate(doc,XPathConstants.NODESET);
            for (int i = 0; i < nodeList.getLength(); i++) {
                System.out.println("Book N"+i+":");
                System.out.println(nodeList.item(i).getTextContent());
            }
        } catch (XPathExpressionException e) {
            e.printStackTrace();
        }
    }

    private static List<String> getTitleOfBookWithPriceGreaterFive(Document doc, XPath xpath){
        List<String> list = new ArrayList<>();
        try{
            XPathExpression expr = xpath.compile("//book[price>5]/title/text()");
            NodeList nodeList = (NodeList) expr.evaluate(doc,XPathConstants.NODESET);
            for (int i = 0; i < nodeList.getLength(); i++) {
                list.add(nodeList.item(i).getNodeValue());
            }
        } catch (XPathExpressionException e) {
            e.printStackTrace();
        }
        return list;
    }

    private static List<String> getAuthorWhichPublishInNovember(Document doc, XPath xpath){
        List<String> list = new ArrayList<>();
        try{
            XPathExpression expr = xpath.compile("//book/*[contains(text(),'11')]/parent::book/author/text()");
            NodeList nodeList = (NodeList) expr.evaluate(doc,XPathConstants.NODESET);
            for (int i = 0; i < nodeList.getLength(); i++) {
                list.add(nodeList.item(i).getNodeValue());
            }
        } catch (XPathExpressionException e) {
            e.printStackTrace();
        }
        return list;
    }

    private static void getFullInformationOfWindowsAndIdBook (Document doc, XPath xpath){
        try{
            XPathExpression expr = xpath.compile("//book/description[contains(text(),\"Microsoft\")]/parent::book[@id=\"bk112\"]");
            NodeList nodeList = (NodeList) expr.evaluate(doc,XPathConstants.NODESET);
            for (int i = 0; i < nodeList.getLength(); i++) {
                System.out.println(nodeList.item(i).getTextContent());
            }
        } catch (XPathExpressionException e) {
            e.printStackTrace();
        }
    }

    /*
    * NodeList nodeList = (NodeList) expr.evaluate(doc,XPathConstants.NODESET);
            for (int i = 0; i < nodeList.getLength(); i++) {
                Element element = (Element) nodeList.item(i);
                System.out.println(element.getAttributes().item(0).getTextContent());
                System.out.println(element.getElementsByTagName("title").item(0).getTextContent());
            }
    *
    * */
}
