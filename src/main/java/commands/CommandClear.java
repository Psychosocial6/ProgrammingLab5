package commands;

import managers.CollectionManager;

public class CommandClear extends Command {

    public CommandClear(CollectionManager collectionManager) {
        super(collectionManager);
    }

    @Override
    public void execute(Object[] args) {
        collectionManager.clear();
    }

    @Override
    public String getInfo() {
        return "Очистить коллекцию: clear";
    }
}
