import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;

public class JsonToXmlConverter {
    public static void main(String[] args) {
        try {
            // 读取JSON文件
            File jsonFile = new File("uml.json");
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode rootNode = objectMapper.readTree(jsonFile);

            // 创建XML文档对象
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
            Document doc = docBuilder.newDocument();

            // 转换JSON为XML
            Element rootElement = convertJsonNodeToXmlElement(rootNode, doc);
            doc.appendChild(rootElement);

            // 将XML文档保存为文件
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File("output.xml"));
            transformer.transform(source, result);

            System.out.println("XML 文件已保存！");
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

                if (fieldValue.isObject() || fieldValue.isArray()) {
                    // 递归处理对象和数组类型的节点
                    Element childElement = convertJsonNodeToXmlElement(fieldValue, doc);
                    element.appendChild(childElement);
                } else {
                    // 处理其他类型的节点
                    Element childElement = doc.createElement(fieldName);
                    childElement.setTextContent(fieldValue.asText());
                    element.appendChild(childElement);
                }
            });
        } else if (jsonNode.isArray()) {
            ArrayNode arrayNode = (ArrayNode) jsonNode;
            arrayNode.forEach(item -> {
                // 创建数组元素的父级元素
                Element arrayElement = doc.createElement(jsonNode.getNodeName());

                if (item.isObject() || item.isArray()) {
                    // 递归处理对象和数组类型的节点
                    Element childElement = convertJsonNodeToXmlElement(item, doc);
                    arrayElement.appendChild(childElement);
                } else {
                    // 处理其他类型的节点
                    Element childElement = doc.createElement(jsonNode.getNodeName());
                    childElement.setTextContent(item.asText());
                    arrayElement.appendChild(childElement);
                }

                element.appendChild(arrayElement);
            });
        } else {
            element = doc.createElement(jsonNode.getNodeName());
            element.setTextContent(jsonNode.asText());
        }

        return element;
    }
}