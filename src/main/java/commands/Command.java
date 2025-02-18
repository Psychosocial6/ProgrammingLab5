package commands;

import interfaces.CommandInterface;
import managers.CollectionManager;

/**
 * Базовый класс для всех команд
 * @author Андрей
 * */
public abstract class Command implements CommandInterface {

    protected static CollectionManager collectionManager;
    public boolean requiresVehicleObject;

    /**
     * Конструктор
     * @param collectionManager - класс, управялющий коллекцией
     * */
    public Command(CollectionManager collectionManager) {
        Command.collectionManager = collectionManager;
        requiresVehicleObject = false;
    }
}
