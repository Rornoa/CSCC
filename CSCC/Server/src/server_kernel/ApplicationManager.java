package server_kernel;

import commands.*;
import input_output.ConsoleReader;
import input_output.XMLReader;
import server_kernel.network.ClientHandler;

public class ApplicationManager {

    private Invoker invoker;
    private CollectionManager collectionManager;
    private Receiver receiver;
    private ConsoleReader consoleReader;
    private String line ="";
    public static String path ="";
    private XMLReader xmlReaderClass;
    private ClientHandler clientHandler;

    {
        receiver = new Receiver();
        collectionManager = new CollectionManager();
        invoker = new Invoker();
        consoleReader = new ConsoleReader();
        xmlReaderClass = new XMLReader();
    }

    public ApplicationManager(){
        String directory = System.getenv("INPUT_LAB");
        directory = "/Users/antondzubak/Documents/JavaApp/src/csvFiles/file";
        if (directory == null || directory.equals("")) {
            System.out.println("Ошибка! Проверьте, инициализирована ли переменная окружения 'INPUT_LAB'" + System.lineSeparator()
                    + "Она указывает на файл, хранящий коллекцию, в формате 'csv' - пр. INPUT_LAB='/home/s284728/programming/lab5/resources/files/cities.csv");
            System.out.println("Исправьте значение переменной окружения. Приложение не сможет сохранять объекты, поэтому оно экстренно закрылось ");
            System.exit(0);
        } else {
            path = directory;
        }
    }

    public void initialize(){
        //repositoryOfMusicBand.getMusicBandCollection().putAll(xmlReaderClass.parseXML());
        System.out.println("______________________________________________________________");
        System.out.println();

        Command help = new HelpCommand(receiver);
        Command info = new InfoCommand(receiver);
        Command show = new ShowCommand(receiver);
        Command add = new AddCommand(receiver);
        Command updateId = new UpdateIdCommand(receiver);
        Command removeByID = new RemoveByIdCommand(receiver);
        Command clear = new ClearCommand(receiver);
        Command save = new SaveCommand(receiver);
        Command executeScript = new ExecuteScriptCommand(receiver);
        Command exit = new ExitCommand(receiver);
        Command insert = new InsertCommand(receiver);
        Command removeFirst = new RemoveFirstCommand(receiver);
        Command removeLower = new RemoveLowerCommand(receiver);
        Command countLessThanGenre = new CountLessThanGenreCommand(receiver);
        Command filterStartsWithName = new FilterStartsWithNameCommand(receiver);
        Command printFieldAscendingLabel = new PrintFieldAscendingLabelCommand(receiver);

        invoker.put(help.getName(), help);
        invoker.put(info.getName(), info);
        invoker.put(show.getName(), show);
        invoker.put(add.getName(), add);
        invoker.put(updateId.getName(), updateId);
        invoker.put(removeByID.getName(), removeByID);
        invoker.put(clear.getName(), clear);
        invoker.put(save.getName(), save);
        invoker.put(executeScript.getName(), executeScript);
        invoker.put(exit.getName(), exit);
        invoker.put(insert.getName(), insert);
        invoker.put(removeFirst.getName(), removeFirst);
        invoker.put(removeLower.getName(), removeLower);
        invoker.put(countLessThanGenre.getName(), countLessThanGenre);
        invoker.put(filterStartsWithName.getName(), filterStartsWithName);
        invoker.put(printFieldAscendingLabel.getName(), printFieldAscendingLabel);

    }

    public void serverStarter(){
            while (true) {
                clientHandler = new ClientHandler(invoker);
                clientHandler.waitRequest();
                new Thread(clientHandler::waitRequest).start();
            }
    }
}
