package server_kernel;

import collection.MusicBand;
import commands.*;
import input_output.ConsoleReader;
import input_output.Message1;
import input_output.Message2;
import server_kernel.network.Network;

import java.io.IOException;
import java.util.NoSuchElementException;

/**
    @Allpication - это класс который инициализирует команды, кладет их в мап по ключю и значению
    а также этот класс запускает работу сервера.
 */

public class Application {

    private MusicBand musicBand;
    private final Invoker invoker;
    private CollectionManager collectionManager;
    private final Receiver receiver;
    private ConsoleReader consoleReader;
    private Network network;
    private Message2 message2;

    public Application() {
        receiver = new Receiver();
        collectionManager = new CollectionManager();
        invoker = new Invoker();
        consoleReader = new ConsoleReader();
    }

    public void initializeCommands() {

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
        System.out.println("initialise() - успешно");
    }

    public void startServer() throws IOException {
        try {
            do {
                network = new Network(invoker);
                Message1 message1 = (Message1) network.read();
                invoker.executeCommand(message1.getCommandName());

                network.write(message2);
                network.closeStreams();
            } while (true);

        } catch (NoSuchElementException | ClassNotFoundException ignored) {

        }
    }
}
