package utils;

import commands.*;
import exceptions.CommandTokenException;
import exceptions.ExecutionException;
import managers.CollectionManager;

import java.util.HashMap;
import java.util.Scanner;

public class Invoker {

    private HashMap<String, Command> commands;

    public Invoker(CollectionManager collectionManager) {
        commands = new HashMap<>();
        commands.put("help", new CommandHelp(collectionManager));
        commands.put("info", new CommandInfo(collectionManager));
        commands.put("show", new CommandShow(collectionManager));
        commands.put("insert", new CommandInsert(collectionManager));
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

    public HashMap<String, Command> getCommands() {
        return commands;
    }

    public void executeCommandUsingToken(String token, Object[]args) throws ExecutionException {
        try {
            commands.get(token).execute(args);
        }
        catch (Exception e) {
            throw new ExecutionException(String.format("Command %s's execution failed", token));
        }
    }
}
