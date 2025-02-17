package commands;

import interfaces.CommandInterface;
import managers.CollectionManager;

public abstract class Command implements CommandInterface {

    protected static CollectionManager collectionManager;

    public Command(CollectionManager collectionManager) {
        Command.collectionManager = collectionManager;
    }
}
