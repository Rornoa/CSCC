package commands;

import collection.CommandName;
import server_kernel.Invoker;
import server_kernel.Receiver;
import server_kernel.CollectionManager;
import collection.MusicBand;

import java.util.EnumMap;

public class UpdateIdCommand extends Command{

    private Receiver receiver;

    public UpdateIdCommand(Receiver receiver) {
        setName(CommandName.UPDATE);
        setDescription("обновить значение элемента коллекции, id которого равен заданному");
        this.receiver = receiver;
    }


    public void execute(EnumMap<CommandName, Command> map, CollectionManager collectionManager,
                        Invoker commandManager, MusicBand musicBand, String... args) {
        long id = Integer.parseInt(args[0]);
        receiver.updateId(collectionManager,musicBand, id);
    }
}
