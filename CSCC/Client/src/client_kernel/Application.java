package client_kernel;

import collection.CommandName;
import collection.building.BandBuilder;
import input_output.Message;
import java.util.Scanner;

class Application {

    private CommandArgumentHandler commandArgumentHandler;

    Application(){
        this.commandArgumentHandler = new CommandArgumentHandler();
        CollectionManager collectionManager = new CollectionManager(this);
    }

    Message validate(Scanner scanner) {

        System.out.println("Добро пожаловать в музыкальный блокнот!\n" + "Для того чтобы ознакомиться с возможными командами введите help\n");
        String defaultConsoleSymbol = ">>";
        System.out.print(defaultConsoleSymbol);
        BandBuilder bandBuilder = new BandBuilder(scanner);
        boolean needExit = false;
        while (!needExit) {
                String command = scanner.nextLine().trim();
            if (command.length()==0)
                break;
            String[] request = command.split(" ");
            String commandName = request[0].toLowerCase();

                switch (commandName) {
                    case "show":
                        System.out.println("Команда  была вызвана");
                        return new Message(CommandName.SHOW);
                        //collectionManager.show();
                    case "info":
                        System.out.println("Команда  была вызвана");
                        return new Message(CommandName.INFO);
                        //collectionManager.info();
                    case "help":
                        System.out.println("Команда  была вызвана");
                        return new Message(CommandName.HELP);
                        //collectionManager.help();
                    case "clear":
                        System.out.println("Команда  была вызвана");
                        return new Message(CommandName.CLEAR);
                        //collectionManager.clear();
                    case "save":
                        System.out.println("Команда  была вызвана");
                        return new Message(CommandName.SAVE);
                        //collectionManager.save();
                    case "remove_first":
                        System.out.println("Команда  была вызвана");
                        return new Message(CommandName.REMOVE_FIRST);
                        //collectionManager.removeFirst();
                    case "exit":
                        System.out.println("Команда  была вызвана");
                        return new Message(CommandName.EXIT);
                        //collectionManager.exit();
                    case "print_field_ascending_label":
                        System.out.println("Команда  была вызвана");
                        return new Message(CommandName.PRINT_FIELD_ASCENDING_LABEL);
                        //collectionManager.printFieldAscendingLabel();
                    case "add" :
                        System.out.println("Команда  была вызвана");
                        return new Message(CommandName.ADD,bandBuilder.create());
                        //collectionManager.add(bandBuilder.create());
                    case "remove_by_id":
                        System.out.println("Команда  была вызвана");
                        return new Message(CommandName.REMOVE_BY_ID,commandArgumentHandler.treatmentInt());
                        //collectionManager.removeById(commandArgumentHandler.treatmentInt());
                    case "remove_lower":
                        System.out.println("Команда  была вызвана");
                        return new Message(CommandName.REMOVE_LOWER,bandBuilder.create());
                        //collectionManager.removeLower(bandBuilder.create());
                    case "update":
                        System.out.println("Команда  была вызвана");
                        return new Message(CommandName.UPDATE,commandArgumentHandler.treatmentInt(),bandBuilder.create());
                        //collectionManager.update((long)commandArgumentHandler.treatmentInt(),bandBuilder.create());
                    case "insert_at_index":
                        System.out.println("Команда  была вызвана");
                        return new Message(CommandName.INSERT_AT,commandArgumentHandler.treatmentInt(),bandBuilder.create());
                        //collectionManager.insertAtIndex(commandArgumentHandler.treatmentInt(),bandBuilder.create());
                    case "filter_starts_with_name":
                        System.out.println("Команда  была вызвана");
                        return new Message(CommandName.FILTER_STARTS_WITH_NAME,commandArgumentHandler.treatmentString());
                        //collectionManager.filterStartsWithName(commandArgumentHandler.treatmentString());
                    case "count_less_than_genre":
                        System.out.println("Команда  была вызвана");
                        //collectionManager.coutLessThanGanre(commandArgumentHandler.treatmentString());
                        return new Message(CommandName.COUNT_LESS_THAN_GENRE,commandArgumentHandler.treatmentString());
                    case "execute_script":
                        System.out.println("Команда  была вызвана");
                        //collectionManager.executeScript();
                        return new Message(CommandName.EXECUTE_SCRIPT);
                    default:
                        System.out.println(" Такой команды нет, попытайтесть ввести еще раз. При необходимости воспользуйтесь командой help");
                }
        }
        return null;
    }
}



