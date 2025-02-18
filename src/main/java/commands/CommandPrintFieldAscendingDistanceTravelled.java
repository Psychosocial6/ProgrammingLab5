package commands;

import managers.CollectionManager;

/**
 * Класс команды вывода полей distanceTravelled
 * @author Андрей
 * */
public class CommandPrintFieldAscendingDistanceTravelled extends  Command {

    /**
     * Конструктор
     * @param collectionManager - класс управляющий коллекцией
     * */
    public CommandPrintFieldAscendingDistanceTravelled(CollectionManager collectionManager) {
        super(collectionManager);
    }

    /**
     * Метод реализующий исполнение команды
     * @param args - массив аргументов команды
     * */
    @Override
    public void execute(Object[] args) {
        collectionManager.printFieldAscendingDistanceTravelled();
    }

    /**
     * Метод возвращающий информацию о команде
     * @return String info
     * */
    @Override
    public String getInfo() {
        return "вывести значения поля distanceTravelled всех элементов в порядке возрастания: print_field_ascending_distance_travelled";
    }
}
