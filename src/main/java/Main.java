import collectionElements.Coordinates;
import collectionElements.FuelType;
import collectionElements.Vehicle;
import managers.CollectionManager;
import managers.ConsoleManager;
import utils.FileReader;
import utils.Invoker;
import utils.XMLDeserializer;

import java.io.File;
import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) {
        //execute_script src/main/java/files/script.txt
        File inputFile = new File("src/main/java/files/input.xml");
        CollectionManager collectionManager = new CollectionManager();
        try {
             collectionManager = XMLDeserializer.deserializeFromXML(FileReader.readFile(inputFile));
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
        Invoker invoker = new Invoker(collectionManager);
        ConsoleManager consoleManager = new ConsoleManager(invoker);
        consoleManager.readConsole();
    }
}
