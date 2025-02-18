package commands;

import collectionElements.Vehicle;
import managers.CollectionManager;

public class CommandRemoveLower extends Command {

    public CommandRemoveLower(CollectionManager collectionManager) {
        super(collectionManager);
        requiresVehicleObject = true;
    }

    @Override
    public void execute(Object[] args) {
        Vehicle element = (Vehicle) args[0];
        collectionManager.removeIfLower(element);
    }

    @Override
    public String getInfo() {
        return "Удалить из коллекции все элементы, меньшие, чем заданный: remove_lower {element}";
    }
}
