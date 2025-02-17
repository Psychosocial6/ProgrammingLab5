package commands;

import managers.CollectionManager;

public class CommandShow extends  Command {


    public CommandShow(CollectionManager collectionManager) {
        super(collectionManager);
    }

    @Override
    public void execute(Object[] args) {
        collectionManager.show();
    }

    @Override
    public String getInfo() {
        return "вывести в стандартный поток вывода все элементы коллекции в строковом представлении: show";
    }
}
