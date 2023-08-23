import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import java.io.File;

public class JSONtoXMLConverter {
    public static void main(String[] args) {
        try {
            // 读取JSON文件
            File jsonFile = new File("input.json");
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode rootNode = objectMapper.readTree(jsonFile);

            // 创建XML文档对象
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
            Document doc = docBuilder.newDocument();

            // 将JSON节点转换为XML元素
            Element rootElement = convertJsonNodeToXmlElement(rootNode, doc);
            doc.appendChild(rootElement);

            // 保存为XML文件
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File("output.xml"));
            transformer.transform(source, result);

            System.out.println("XML file saved!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static Element convertJsonNodeToXmlElement(JsonNode jsonNode, Document doc) {
        Element element = null;

        if (jsonNode.isObject()) {
            element = doc.createElement(jsonNode.getNodeName());
            ObjectNode objectNode = (ObjectNode) jsonNode;

            objectNode.fields().forEachRemaining(entry -> {
                String fieldName = entry.getKey();
                JsonNode fieldValue = entry.getValue();
                Element childElement = convertJsonNodeToXmlElement(fieldValue, doc);
                element.appendChild(childElement);
            });
        } else if (jsonNode.isArray()) {
            element = doc.createElement(jsonNode.getNodeName());
            ArrayNode arrayNode = (ArrayNode) jsonNode;

            arrayNode.forEach(item -> {
                Element childElement = convertJsonNodeToXmlElement(item, doc);
                element.appendChild(childElement);
            });
        } else {
            element = doc.createElement(jsonNode.getNodeName());
            element.setTextContent(jsonNode.asText());
        }

        return element;
    }
}