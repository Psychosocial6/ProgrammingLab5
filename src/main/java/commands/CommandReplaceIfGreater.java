package commands;

import collectionElements.Vehicle;
import managers.CollectionManager;

/**
 * Класс команды замены элемента на данный, если изначальный больше
 * @author Андрей
 * */
public class CommandReplaceIfGreater extends Command {

    /**
     * Конструктор
     * @param collectionManager - класс управляющий коллекцией
     * */
    public CommandReplaceIfGreater(CollectionManager collectionManager) {
        super(collectionManager);
        requiresVehicleObject = true;
    }

    /**
     * Метод реализующий исполнение команды
     * @param args - массив аргументов команды
     * */
    @Override
    public void execute(Object[] args) {
        String key = (String) args[0];
        Vehicle element = (Vehicle) args[1];
        collectionManager.replaceIfGreater(key, element);
    }

    /**
     * Метод возвращающий информацию о команде
     * @return String info
     * */
    @Override
    public String getInfo() {
        return "Заменить значение по ключу, если новое значение больше старого: replace_if_greater null {element}";
    }
}
