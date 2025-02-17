package utils;

import commands.*;
import managers.CollectionManager;

import java.util.HashMap;

public class Invoker {

    private HashMap<String, Command> commands;
    private CollectionManager collectionManager;

    public Invoker(CollectionManager collectionManager) {
        this.collectionManager = collectionManager;
        commands = new HashMap<>();
        commands.put("help", new CommandHelp(collectionManager));
        commands.put("info", new CommandInfo(collectionManager));
        commands.put("show", new CommandShow(collectionManager));
        commands.put("inset", new CommandInsert(collectionManager));
        commands.put("update", new CommandUpdate(collectionManager));
        commands.put("remove_key", new CommandRemoveKey(collectionManager));
        commands.put("clear", new CommandClear(collectionManager));
        commands.put("save", new CommandSave(collectionManager));
        commands.put("execute_script", new CommandExecute(collectionManager));
        commands.put("exit", new CommandExit(collectionManager));
        commands.put("remove_lower", new CommandRemoveLower(collectionManager));
        commands.put("replace_if_greater", new CommandReplaceIfGreater(collectionManager));
        commands.put("replace_if_lower", new CommandReplaceIfLower(collectionManager));
        commands.put("filter_contains_name", new CommandFilterContainsName(collectionManager));
        commands.put("filter_starts_with_name", new CommandFilterStartsWithName(collectionManager));
        commands.put("print_field_ascending_distance_travelled", new CommandPrintFieldAscendingDistanceTravelled(collectionManager));
    }

    public void readConsole() {

        while (true) {

        }
    }
}
