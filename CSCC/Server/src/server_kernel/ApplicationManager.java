package server_kernel;

import commands.*;
import input_output.ConsoleReader;
import input_output.XMLReader;

import java.io.IOException;

/**
 * Class wherein describes initialize method of objects which responsible for application work.
 *
 * @see ApplicationManager#initialize()
 */

public class ApplicationManager {

    private Invoker invoker;
    private RepositoryOfMusicBand repositoryOfMusicBand;
    private Receiver receiver;
    private ConsoleReader consoleReader;
    private String line ="";
    public static String path ="";
    private XMLReader xmlReaderClass;

    {
        receiver = new Receiver();
        repositoryOfMusicBand = new RepositoryOfMusicBand();
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

    /**
     * This method is responsible for creationg all commands of application.
     * Here describes the separation of commands with and without arguments, as well as sending them for execution.
     *
     * @throws IOException error of input/output, can be found here
     */

    public void initialize(){
        repositoryOfMusicBand.getMusicBandCollection().putAll(xmlReaderClass.parseXML());
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

        invoker.setCommandMap(help.getName(), help);
        invoker.setCommandMap(info.getName(), info);
        invoker.setCommandMap(show.getName(), show);
        invoker.setCommandMap(add.getName(), add);
        invoker.setCommandMap(updateId.getName(), updateId);
        invoker.setCommandMap(removeByID.getName(), removeByID);
        invoker.setCommandMap(clear.getName(), clear);
        invoker.setCommandMap(save.getName(), save);
        invoker.setCommandMap(executeScript.getName(), executeScript);
        invoker.setCommandMap(exit.getName(), exit);
        invoker.setCommandMap(insert.getName(), insert);
        invoker.setCommandMap(removeFirst.getName(), removeFirst);
        invoker.setCommandMap(removeLower.getName(), removeLower);
        invoker.setCommandMap(countLessThanGenre.getName(), countLessThanGenre);
        invoker.setCommandMap(filterStartsWithName.getName(), filterStartsWithName);
        invoker.setCommandMap(printFieldAscendingLabel.getName(), printFieldAscendingLabel);
    }

    public String mainMassage(){
        return "Welcome to console base builder. v1.0" + System.lineSeparator() + "© Developed by Nik in 2020. All rights reserved." + System.lineSeparator() + System.lineSeparator() + "Enter 'help' to see legend.";
    }
}
