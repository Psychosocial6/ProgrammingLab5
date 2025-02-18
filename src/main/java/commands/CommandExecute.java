package commands;

import managers.CollectionManager;
import utils.Invoker;
import utils.ScriptExecutor;

import java.io.File;

public class CommandExecute extends Command {
    private Invoker invoker;

    public CommandExecute(CollectionManager collectionManager, Invoker invoker) {
        super(collectionManager);
        this.invoker = invoker;
    }

    @Override
    public void execute(Object[] args) {
        File file = new File((String) args[0]);
        collectionManager.executeScript(file, invoker);
    }

    @Override
    public String getInfo() {
        return "Считать и исполнить скрипт из указанного файла: execute_script file_name";
    }
}
