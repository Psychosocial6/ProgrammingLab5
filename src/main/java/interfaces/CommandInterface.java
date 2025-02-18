package interfaces;

import collectionElements.Vehicle;

public interface CommandInterface {
    void execute(Object[] args);
    String getInfo();
}
