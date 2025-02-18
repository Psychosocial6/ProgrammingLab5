package commands;

import collectionElements.Vehicle;
import managers.CollectionManager;

/**
 * Класс команды замены элемента с заданным id
 * @author Андрей
 * */
public class CommandUpdate extends Command {

    /**
     * Конструктор
     * @param collectionManager - класс управляющий коллекцией
     * */
    public CommandUpdate(CollectionManager collectionManager) {
        super(collectionManager);
        requiresVehicleObject = true;
    }

    /**
     * Метод реализующий исполнение команды
     * @param args - массив аргументов команды
     * */
    @Override
    public void execute(Object[] args) {
        int id = Integer.parseInt((String)args[0]);
        Vehicle element = (Vehicle) args[1];
        collectionManager.updateById(id, element);
    }

    /**
     * Метод возвращающий информацию о команде
     * @return String info
     * */
    @Override
    public String getInfo() {
        return "Обновить значение элемента коллекции, id которого равен заданному: update id {element}";
    }
}
