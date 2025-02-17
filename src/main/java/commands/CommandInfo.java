package commands;

import managers.CollectionManager;

public class CommandInfo extends Command {


    public CommandInfo(CollectionManager collectionManager) {
        super(collectionManager);
    }

    @Override
    public void execute(Object[] args) {
        collectionManager.info();
    }

    @Override
    public String getInfo() {
        return "Вывести в стандартный поток вывода информацию о коллекции: info";
    }
}
