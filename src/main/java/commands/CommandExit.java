package commands;

import managers.CollectionManager;

public class CommandExit extends Command {

    public CommandExit(CollectionManager collectionManager) {
        super(collectionManager);
    }

    @Override
    public void execute(Object[] args) {
        collectionManager.exit();
    }

    @Override
    public String getInfo() {
        return "Завершить программу (без сохранения в файл): exit";
    }
}
