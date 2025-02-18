package managers;

import collectionElements.Vehicle;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import exceptions.ScriptExecutionException;
import utils.FileWriter;
import utils.Invoker;
import utils.ScriptExecutor;
import utils.XMLSerializer;

import java.io.File;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Hashtable;


public class CollectionManager {
    @JacksonXmlElementWrapper(useWrapping = false)
    private Hashtable<String, Vehicle> collection;
    @JsonIgnore
    private final ZonedDateTime initializationDate;

    public CollectionManager() {
        this.collection = new Hashtable<>();
        initializationDate = ZonedDateTime.now();
    }

    public CollectionManager(Hashtable<String, Vehicle> collection) {
        this.collection = collection;
        initializationDate = ZonedDateTime.now();
    }

    public void info() {
        System.out.println("----------");
        System.out.println(String.format("Дата создания: %s", initializationDate));
        System.out.println(String.format("Размер коллекции: %d", collection.size()));
        System.out.println(String.format("Тип коллекции: %s", collection.getClass()));
        System.out.println("----------");
    }

    public void show() {
        if (collection.isEmpty()) {
            System.out.println("Collection is empty");
        }
        else {
            System.out.println("----------");
            for (String key : collection.keySet()) {
                System.out.println(String.format("%s : %s", key, collection.get(key)));
                System.out.println("----------");
            }
        }

    }

    public void insert(String key, Vehicle element) {
        collection.put(key, element);
    }

    public void updateById(int id, Vehicle element) {
        for (String key : collection.keySet()) {
            if (collection.get(key).getId() == id) {
                collection.put(key, element);
            }
        }
    }

    public void removeByKey(String key) {
        collection.remove(key);
        System.out.println(String.format("Elem with key {%s} removed", key));
    }

    public void clear() {
        collection.clear();
        System.out.println("Collection cleared");
    }

    public void save(File file) {
        FileWriter.writeIntoFile(file, XMLSerializer.serializeToXML(this));
    }

    public void executeScript(File file, Invoker invoker) {
        ScriptExecutor executor = new ScriptExecutor(invoker);
        try {
            executor.executeScript(file);
        } catch (ScriptExecutionException e) {
            System.out.println(e.getMessage());
        }
    }

    public void exit() {
        System.exit(0);
    }

    public void removeIfLower(Vehicle element) {
        Hashtable<String, Vehicle> collection2 = (Hashtable<String, Vehicle>) collection.clone();
        for (String key : collection.keySet()) {
            if (collection.get(key).compareTo(element) < 0) {
                collection2.remove(key);
            }
        }
        collection = collection2;
    }

    public void replaceIfLower(String key, Vehicle element) {
        if (collection.get(key).compareTo(element) < 0) {
            collection.put(key, element);
        }
    }

    public void replaceIfGreater(String key, Vehicle element) {
        if (collection.get(key).compareTo(element) > 0) {
            collection.put(key, element);
        }
    }

    public void filterContainsName(String name) {
        System.out.println(String.format("Name contains %s", name));
        for (String key: collection.keySet()) {
            if (collection.get(key).getName().contains(name)) {
                System.out.println(collection.get(key));
            }
        }
    }

    public void filterStartsWithName(String name) {
        System.out.println(String.format("Name starts with %s", name));
        for (String key: collection.keySet()) {
            if (collection.get(key).getName().startsWith(name)) {
                System.out.println(collection.get(key));
            }
        }
    }

    public void printFieldAscendingDistanceTravelled() {
        ArrayList<Long> distances = new ArrayList<>();
        for (String key : collection.keySet()) {
            distances.add(collection.get(key).getDistanceTravelled());
        }
        Collections.sort(distances);
        System.out.println("Field distanceTravelled:");
        for (Long dist : distances) {
            System.out.println(dist);
        }
    }

    public Hashtable<String, Vehicle> getCollection() {
        return collection;
    }

    public void setCollection(Hashtable<String, Vehicle> collection) {
        this.collection = collection;
    }

    public ZonedDateTime getInitializationDate() {
        return initializationDate;
    }
}
