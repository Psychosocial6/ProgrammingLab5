package commands;

import collectionElements.Vehicle;
import managers.CollectionManager;

public class CommandInsert extends Command {

    public CommandInsert(CollectionManager collectionManager) {
        super(collectionManager);
    }

    @Override
    public void execute(Object[] args) { //key, elem
        String key = (String) args[0];
        Vehicle value = (Vehicle) args[1];
        collectionManager.insert(key, value);
    }

    @Override
    public String getInfo() {
        return "Добавить в коллекцию новый элемент с заданным ключом: insert null {element}";
    }
}
