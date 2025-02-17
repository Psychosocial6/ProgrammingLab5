package commands;

import managers.CollectionManager;

public class CommandFilterStartsWithName extends Command {

    public CommandFilterStartsWithName(CollectionManager collectionManager) {
        super(collectionManager);
    }

    @Override
    public void execute(Object[] args) {
        String name = (String) args[0];
        collectionManager.filterStartsWithName(name);
    }

    @Override
    public String getInfo() {
        return "вывести элементы, значение поля name которых начинается с заданной подстроки: filter_starts_with_name name";
    }
}
