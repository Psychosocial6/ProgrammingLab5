package utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import managers.CollectionManager;

/**
 * Утилитный класс для сериализации xml
 * @author Андрей
 * */
public class XMLSerializer {

    /**
     * Метод для сериализации коллекци в формате XML
     * @param collectionManager - Коллекция для сериализации
     * @return String xml - сериализованный объект
     */
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
