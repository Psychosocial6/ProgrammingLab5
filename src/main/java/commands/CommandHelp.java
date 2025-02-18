package commands;

import managers.CollectionManager;

/**
 * Класс команды помощи
 * @author Андрей
 * */
public class CommandHelp extends Command{

    /**
     * Конструктор
     * @param collectionManager - класс управляющий коллекцией
     * */
    public CommandHelp(CollectionManager collectionManager) {
        super(collectionManager);
    }

    /**
     * Метод реализующий исполнение команды
     * @param args - массив аргументов команды
     * */
    @Override
    public void execute(Object[] args) {
        for (Object command: args) {
            System.out.println(((Command) command).getInfo());
        }
    }

    /**
     * Метод возвращающий информацию о команде
     * @return String info
     * */
    @Override
    public String getInfo() {
        return "Вывести справку по доступным командам: help";
    }
}
