package utils;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import managers.CollectionManager;

import java.io.IOException;

/**
 * Утилитный класс для десериализации XML
 * @author Андрей
 * */
public class XMLDeserializer {

    /**
     * Метод преобразующий xml файл в коллекцию Vehicle
     * @param XMLLine - строка xml
     * @return - Класс управляющий коллекций
     */
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
