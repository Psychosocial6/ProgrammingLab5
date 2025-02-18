package utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import managers.CollectionManager;

public class XMLWriter {

    public static String serializeToXML(CollectionManager collectionManager) {
        XmlMapper xmlMapper = new XmlMapper();
        String xml = "";
        try {
            xml = xmlMapper.writeValueAsString(collectionManager);
        } catch (JsonProcessingException e) {
            System.out.println("Error while serialization");
        }
        return xml;
    }
}
