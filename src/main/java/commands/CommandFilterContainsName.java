package commands;

import managers.CollectionManager;

/**
 * Класс команды фильтра по имени
 * @author Андрей
 * */
public class CommandFilterContainsName extends Command {

    /**
     * Конструктор
     * @param collectionManager - класс управляющий коллекцией
     * */
    public CommandFilterContainsName(CollectionManager collectionManager) {
        super(collectionManager);
    }

    /**
     * Метод реализующий исполнение команды
     * @param args - массив аргументов команды
     * */
    @Override
    public void execute(Object[] args) {
        String name = (String) args[0];
        collectionManager.filterContainsName(name);
    }

    /**
     * Метод возвращающий информацию о команде
     * @return String info
     * */
    @Override
    public String getInfo() {
        return "Вывести элементы, значение поля name которых содержит заданную подстроку: filter_contains_name name";
    }
}
