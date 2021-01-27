package client_kernel;

import collection.building.BandBuilder;
import commands.CommandName;
import input_output.Message;
import java.util.Scanner;

public class Application {

    private boolean needExit = false;
    private CollectionManager collectionManager;
    private CommandArgumentHandler commandArgumentHandler;

    Application(){
        this.commandArgumentHandler = new CommandArgumentHandler();
        this.collectionManager = new CollectionManager(this);
    }

    Message go(Scanner scanner) {

        System.out.println("Добро пожаловать в музыкальный блокнот!\n" + "Для того чтобы ознакомиться с возможными командами введите help\n");
        String defaultConsoleSymbol = ">>";
        System.out.print(defaultConsoleSymbol);
        BandBuilder bandBuilder = new BandBuilder(scanner);
        while (!needExit) {
                String command = scanner.nextLine().trim();
                switch (command) {
                    case "show":
                        return new Message(CommandName.SHOW.getCommandName());
                        //collectionManager.show();
                    case "info":
                        return new Message(CommandName.INFO.getCommandName());
                        //collectionManager.info();
                    case "help":
                        return new Message(CommandName.HELP.getCommandName());
                        //collectionManager.help();
                    case "clear":
                        return new Message(CommandName.CLEAR.getCommandName());
                        //collectionManager.clear();
                    case "save":
                        return new Message(CommandName.SAVE.getCommandName());
                        //collectionManager.save();
                    case "remove_first":
                        return new Message(CommandName.REMOVE_FIRST.getCommandName());
                        //collectionManager.removeFirst();
                    case "exit":
                        return new Message(CommandName.EXIT.getCommandName());
                        //collectionManager.exit();
                    case "print_field_ascending_label":
                        return new Message(CommandName.PRINT_FIELD_ASCENDING_LABEL.getCommandName());
                        //collectionManager.printFieldAscendingLabel();
                    case "add" :
                        return new Message(CommandName.ADD.getCommandName());
                        //collectionManager.add(bandBuilder.create());
                    case "remove_by_id":
                        return new Message(CommandName.REMOVE_BY_ID.getCommandName());
                        //collectionManager.removeById(commandArgumentHandler.treatmentInt());
                    case "remove_lower":
                        return new Message(CommandName.REMOVE_LOWER.getCommandName());
                        //collectionManager.removeLower(bandBuilder.create());
                    case "update":
                        return new Message(CommandName.UPDATE.getCommandName());
                        //collectionManager.update((long)commandArgumentHandler.treatmentInt(),bandBuilder.create());
                    case "insert_at_index":
                        return new Message(CommandName.INSERT_AT.getCommandName());
                        //collectionManager.insertAtIndex(commandArgumentHandler.treatmentInt(),bandBuilder.create());
                    case "filter_starts_with_name":
                        return new Message(CommandName.FILTER_STARTS_WITH_NAME.getCommandName());
                        //collectionManager.filterStartsWithName(commandArgumentHandler.treatmentString());
                    case "count_less_than_genre":
                        return new Message(CommandName.COUNT_LESS_THAN_GENRE.getCommandName());
                        //collectionManager.coutLessThanGanre(commandArgumentHandler.treatmentString());
                    case "execute_script":
                        return new Message(CommandName.EXECUTE_SCRIPT.getCommandName());
                        //collectionManager.executeScript();
                    default:
                        System.out.println(" Такой команды нет ");
                }
        }
        return null;
    }
}



