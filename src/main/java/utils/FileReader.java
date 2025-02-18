package utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileReader {

    public static String readFile(File file) throws FileNotFoundException {
        StringBuilder fileString = new StringBuilder();
        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNext()) {
                fileString.append(scanner.nextLine());
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            throw new FileNotFoundException(String.format("File %s not found", file));
        }
        return fileString.toString();
    }
}
