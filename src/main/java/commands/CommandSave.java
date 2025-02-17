package commands;

import managers.CollectionManager;

import java.io.File;

public class CommandSave extends Command {

    public CommandSave(CollectionManager collectionManager) {
        super(collectionManager);
    }

    @Override
    public void execute(Object[] args) {
        File file = (File) args[0];
        collectionManager.save(file);
    }

    @Override
    public String getInfo() {
        return "Сохранить коллекцию в файл: save";
    }
}
