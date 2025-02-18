package commands;

import collectionElements.Vehicle;
import managers.CollectionManager;

public class CommandUpdate extends Command {

    public CommandUpdate(CollectionManager collectionManager) {
        super(collectionManager);
        requiresVehicleObject = true;
    }

    @Override
    public void execute(Object[] args) {
        int id = Integer.parseInt((String)args[0]);
        Vehicle element = (Vehicle) args[1];
        collectionManager.updateById(id, element);
    }

    @Override
    public String getInfo() {
        return "Обновить значение элемента коллекции, id которого равен заданному: update id {element}";
    }
}
