package commands;

import collectionElements.Vehicle;
import managers.CollectionManager;

public class CommandReplaceIfGreater extends Command {

    public CommandReplaceIfGreater(CollectionManager collectionManager) {
        super(collectionManager);
        requiresVehicleObject = true;
    }

    @Override
    public void execute(Object[] args) {
        String key = (String) args[0];
        Vehicle element = (Vehicle) args[1];
        collectionManager.replaceIfGreater(key, element);
    }

    @Override
    public String getInfo() {
        return "Заменить значение по ключу, если новое значение больше старого: replace_if_greater null {element}";
    }
}
