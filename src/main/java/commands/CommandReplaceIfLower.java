package commands;

import collectionElements.Vehicle;
import managers.CollectionManager;

public class CommandReplaceIfLower extends Command {

    public CommandReplaceIfLower(CollectionManager collectionManager) {
        super(collectionManager);
        requiresVehicleObject = true;
    }

    @Override
    public void execute(Object[] args) {
        String key = (String) args[0];
        Vehicle element = (Vehicle) args[1];
        collectionManager.replaceIfLower(key, element);
    }

    @Override
    public String getInfo() {
        return "Заменить значение по ключу, если новое значение меньше старого: replace_if_lower null {element}";
    }
}
