package utils;

import collectionElements.Vehicle;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import managers.CollectionManager;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;

public class XMLReader {

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
