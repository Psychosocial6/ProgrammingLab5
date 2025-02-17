package commands;

import managers.CollectionManager;

public class CommandPrintFieldAscendingDistanceTravelled extends  Command {

    public CommandPrintFieldAscendingDistanceTravelled(CollectionManager collectionManager) {
        super(collectionManager);
    }

    @Override
    public void execute(Object[] args) {
        collectionManager.printFieldAscendingDistanceTravelled();
    }

    @Override
    public String getInfo() {
        return "вывести значения поля distanceTravelled всех элементов в порядке возрастания: print_field_ascending_distance_travelled";
    }
}
