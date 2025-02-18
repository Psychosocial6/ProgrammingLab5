package commands;

import managers.CollectionManager;

/**
 * Класс команды удаления по ключу
 * @author Андрей
 * */
public class CommandRemoveKey extends Command {

    /**
     * Конструктор
     * @param collectionManager - класс управляющий коллекцией
     * */
    public CommandRemoveKey(CollectionManager collectionManager) {
        super(collectionManager);
    }

    /**
     * Метод реализующий исполнение команды
     * @param args - массив аргументов команды
     * */
    @Override
    public void execute(Object[] args) {
        String key = (String) args[0];
        collectionManager.removeByKey(key);
    }

    /**
     * Метод возвращающий информацию о команде
     * @return String info
     * */
    @Override
    public String getInfo() {
        return "Удалить элемент из коллекции по его ключу: remove_key null";
    }
}
