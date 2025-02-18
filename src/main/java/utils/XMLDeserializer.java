package utils;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import managers.CollectionManager;

import java.io.IOException;

public class XMLDeserializer {

    public static CollectionManager deserializeFromXML(String XMLLine) {
        XmlMapper xmlMapper = new XmlMapper();
        CollectionManager collection = null;
        try {
            collection = xmlMapper.readValue(XMLLine, CollectionManager.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return collection;
    }
}
