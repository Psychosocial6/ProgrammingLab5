package commands;

import managers.CollectionManager;

public class CommandRemoveKey extends Command {

    public CommandRemoveKey(CollectionManager collectionManager) {
        super(collectionManager);
    }

    @Override
    public void execute(Object[] args) {
        String key = (String) args[0];
        collectionManager.removeByKey(key);
    }

    @Override
    public String getInfo() {
        return "Удалить элемент из коллекции по его ключу: remove_key null";
    }
}
