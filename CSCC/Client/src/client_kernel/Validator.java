package client_kernel;

import collection.CommandName;
import collection.building.BandBuilder;
import input_output.Message1;
import java.util.Scanner;

class Validator {

    private ArgumentHandler argumentHandler;

    Validator(){
        this.argumentHandler = new ArgumentHandler();
        CollectionManager collectionManager = new CollectionManager(this);
    }

    Message1 validate(Scanner scanner) {

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
                        System.out.println("Команда show была вызвана");
                        return new Message1(CommandName.SHOW);
                        //collectionManager.show();
                    case "info":
                        System.out.println("Команда info была вызвана");
                        return new Message1(CommandName.INFO);
                        //collectionManager.info();
                    case "help":
                        System.out.println("Команда help была вызвана");
                        return new Message1(CommandName.HELP);
                        //collectionManager.help();
                    case "clear":
                        System.out.println("Команда clear была вызвана");
                        return new Message1(CommandName.CLEAR);
                        //collectionManager.clear();
                    case "save":
                        System.out.println("Команда save была вызвана");
                        return new Message1(CommandName.SAVE);
                        //collectionManager.save();
                    case "remove_first":
                        System.out.println("Команда remove_first была вызвана");
                        return new Message1(CommandName.REMOVE_FIRST);
                        //collectionManager.removeFirst();
                    case "exit":
                        System.out.println("Команда exit была вызвана");
                        return new Message1(CommandName.EXIT);
                        //collectionManager.exit();
                    case "print_field_ascending_label":
                        System.out.println("Команда print_field_ascending_label была вызвана");
                        return new Message1(CommandName.PRINT_FIELD_ASCENDING_LABEL);
                        //collectionManager.printFieldAscendingLabel();
                    case "add" :
                        System.out.println("Команда add была вызвана");
                        return new Message1(CommandName.ADD,bandBuilder.create());
                        //collectionManager.add(bandBuilder.create());
                    case "remove_by_id":
                        System.out.println("Команда remove_by_id была вызвана");
                        return new Message1(CommandName.REMOVE_BY_ID, argumentHandler.treatmentInt());
                        //collectionManager.removeById(commandArgumentHandler.treatmentInt());
                    case "remove_lower":
                        System.out.println("Команда remove_lower была вызвана");
                        return new Message1(CommandName.REMOVE_LOWER,bandBuilder.create());
                        //collectionManager.removeLower(bandBuilder.create());
                    case "update":
                        System.out.println("Команда update была вызвана");
                        return new Message1(CommandName.UPDATE, argumentHandler.treatmentInt(),bandBuilder.create());
                        //collectionManager.update((long)commandArgumentHandler.treatmentInt(),bandBuilder.create());
                    case "insert_at_index":
                        System.out.println("Команда insert_at_index была вызвана");
                        return new Message1(CommandName.INSERT_AT, argumentHandler.treatmentInt(),bandBuilder.create());
                        //collectionManager.insertAtIndex(commandArgumentHandler.treatmentInt(),bandBuilder.create());
                    case "filter_starts_with_name":
                        System.out.println("Команда filter_starts_with_name была вызвана");
                        return new Message1(CommandName.FILTER_STARTS_WITH_NAME, argumentHandler.treatmentString());
                        //collectionManager.filterStartsWithName(commandArgumentHandler.treatmentString());
                    case "count_less_than_genre":
                        System.out.println("Команда count_less_than_genre была вызвана");
                        //collectionManager.coutLessThanGanre(commandArgumentHandler.treatmentString());
                        return new Message1(CommandName.COUNT_LESS_THAN_GENRE, argumentHandler.treatmentString());
                    case "execute_script":
                        System.out.println("Команда execute_script была вызвана");
                        //collectionManager.executeScript();
                        return new Message1(CommandName.EXECUTE_SCRIPT);
                    default:
                        System.out.println(" Такой команды нет, попытайтесть ввести еще раз. При необходимости воспользуйтесь командой help");
                }
        }
        return null;
    }
}



