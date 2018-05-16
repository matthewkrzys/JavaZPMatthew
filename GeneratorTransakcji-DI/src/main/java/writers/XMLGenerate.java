package writers;

import model.JSONData;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;

public class XMLGenerate implements Generatable {

    private String outputDir;
    private String nameJson;
    private static long numberFile = 1;

    public XMLGenerate(String output, String nameJson) {
        this.outputDir = output;
        this.nameJson = nameJson;
    }

    @Override
    public boolean generate(JSONData jsonParse) {
        DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder docBuilder = null;
        Document doc;
        Node personNode;
        Node rootElement;
        Element name;

        try {
            docBuilder = docFactory.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }
        String pathFile = outputDir.replace("./","") + "/" + nameJson + numberFile + ".xml";
        File file = new File(outputDir);
        if (!file.exists()) {
            if (file.mkdir()) {
                System.out.println("Directory is created!");
            } else {
                System.out.println("Failed to create directory!");
            }
        }
        numberFile++;
        doc = docBuilder.newDocument();
        rootElement = doc.createElement("data");
        doc.appendChild(rootElement);
        personNode = doc.createElement("data");
        rootElement.appendChild(personNode);
        name= doc.createElement("id");
        name.appendChild(doc.createTextNode(String.valueOf(jsonParse.id)));
        personNode.appendChild(name);
        name = doc.createElement("timestamp");
        name.appendChild(doc.createTextNode(String.valueOf(jsonParse.timestamp)));
        personNode.appendChild(name);
        name = doc.createElement("customer_id");
        name.appendChild(doc.createTextNode(String.valueOf(jsonParse.customer_id)));
        personNode.appendChild(name);
        name = doc.createElement("items");
        name.appendChild(doc.createTextNode(String.valueOf(jsonParse.items)));
        personNode.appendChild(name);
        name = doc.createElement("sum");
        name.appendChild(doc.createTextNode(String.valueOf(jsonParse.sum)));
        personNode.appendChild(name);
        // write the content into xml file
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = null;
        try {
            transformer = transformerFactory.newTransformer();
        } catch (TransformerConfigurationException e) {
            e.printStackTrace();
        }
        DOMSource source = new DOMSource(doc);
        StreamResult result = new StreamResult(new File(pathFile));
        try {
            transformer.transform(source, result);
        } catch (TransformerException e) {
            e.printStackTrace();
        }

        return true;

    }

}
