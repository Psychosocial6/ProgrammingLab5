package commands;

import collectionElements.Vehicle;
import managers.CollectionManager;

/**
 * Класс команды удаления элементов меньше данного
 * @author Андрей
 * */
public class CommandRemoveLower extends Command {

    /**
     * Конструктор
     * @param collectionManager - класс управляющий коллекцией
     * */
    public CommandRemoveLower(CollectionManager collectionManager) {
        super(collectionManager);
        requiresVehicleObject = true;
    }

    /**
     * Метод реализующий исполнение команды
     * @param args - массив аргументов команды
     * */
    @Override
    public void execute(Object[] args) {
        Vehicle element = (Vehicle) args[0];
        collectionManager.removeIfLower(element);
    }

    /**
     * Метод возвращающий информацию о команде
     * @return String info
     * */
    @Override
    public String getInfo() {
        return "Удалить из коллекции все элементы, меньшие, чем заданный: remove_lower {element}";
    }
}
