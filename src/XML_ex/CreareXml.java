package XML_ex;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;

public class CreareXml {
    public static void main(String[] args) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.newDocument();

            Element rootElement = doc.createElement("inventory");
            doc.appendChild(rootElement);

            Element item1 = doc.createElement("item");
            rootElement.appendChild(item1);
            item1.setAttribute("id", "P1001");

            Element name1 = doc.createElement("name");
            Text nameText1 = doc.createTextNode("Laptop");
            name1.appendChild(nameText1);
            item1.appendChild(name1);

            Element qty1 = doc.createElement("quantity");
            Text qtyText1 = doc.createTextNode("50");
            qty1.appendChild(qtyText1);
            item1.appendChild(qty1);

            Element item2 = doc.createElement("item");
            rootElement.appendChild(item2);
            item2.setAttribute("id", "P1002");

            Element name2 = doc.createElement("name");
            Text nameText2 = doc.createTextNode("Smartphone");
            name2.appendChild(nameText2);
            item2.appendChild(name2);

            Element qty2 = doc.createElement("quantity");
            Text qtyText2 = doc.createTextNode("120");
            qty2.appendChild(qtyText2);
            item2.appendChild(qty2);

            Element item3 = doc.createElement("item");
            rootElement.appendChild(item3);
            item3.setAttribute("id", "P1003");

            Element name3 = doc.createElement("name");
            Text nameText3 = doc.createTextNode("Keyboard");
            name3.appendChild(nameText3);
            item3.appendChild(name3);

            Element qty3 = doc.createElement("quantity");
            Text qtyText3 = doc.createTextNode("35");
            qty3.appendChild(qtyText3);
            item3.appendChild(qty3);

            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();

            transformer.setOutputProperty(javax.xml.transform.OutputKeys.INDENT, "yes");
            transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");

            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File("inventory.xml"));

            transformer.transform(source, result);

            System.out.println("XML generat cu succes!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
