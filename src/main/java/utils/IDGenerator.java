package utils;

public class IDGenerator {
    private static int id = 0;

    public static int getNewID() {
        id++;
        return id;
    }
}
