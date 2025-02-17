package utils;

import collectionElements.Vehicle;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import managers.CollectionManager;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class XMLReader {

    public static CollectionManager deserializeFromXML() {
        try {
            XmlMapper xmlMapper = new XmlMapper();
            CollectionManager collection = xmlMapper.readValue(new File("input.xml"), CollectionManager.class);

            return collection;
        }
        catch (IOException) {
            System.out.println("XML reading error");
        }

    }

}
