package commands;

import managers.CollectionManager;

public class CommandFilterContainsName extends Command {

    public CommandFilterContainsName(CollectionManager collectionManager) {
        super(collectionManager);
    }

    @Override
    public void execute(Object[] args) {
        String name = (String) args[0];
        collectionManager.filterContainsName(name);
    }

    @Override
    public String getInfo() {
        return "Вывести элементы, значение поля name которых содержит заданную подстроку: filter_contains_name name";
    }
}
