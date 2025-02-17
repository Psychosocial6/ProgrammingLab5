package commands;

import managers.CollectionManager;

import java.util.ArrayList;

public class CommandHelp extends Command{

    public CommandHelp(CollectionManager collectionManager) {
        super(collectionManager);
    }

    @Override
    public void execute(Object[] args) {
        for (Object command: args) {
            ((Command) command).getInfo();
        }
    }

    @Override
    public String getInfo() {
        return "Вывести справку по доступным командам: help";
    }
}
