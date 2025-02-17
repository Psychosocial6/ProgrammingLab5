package commands;

import collectionElements.Vehicle;
import managers.CollectionManager;

public class CommandUpdate extends Command {

    public CommandUpdate(CollectionManager collectionManager) {
        super(collectionManager);
    }

    @Override
    public void execute(Object[] args) {
        int id = (int) args[0];
        Vehicle element = (Vehicle) args[1];
        collectionManager.updateById(id, element);
    }

    @Override
    public String getInfo() {
        return "Обновить значение элемента коллекции, id которого равен заданному: update id {element}";
    }
}
