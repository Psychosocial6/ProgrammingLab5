package commands;

import managers.CollectionManager;

import java.io.File;

public class CommandExecute extends Command {

    public CommandExecute(CollectionManager collectionManager) {
        super(collectionManager);
    }

    @Override
    public void execute(Object[] args) {
        File file = (File) args[0];
        collectionManager.executeScript(file);
    }

    @Override
    public String getInfo() {
        return "Считать и исполнить скрипт из указанного файла: execute_script file_name";
    }
}
