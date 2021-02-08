package commands;

import collection.CommandName;
import server_kernel.Invoker;
import server_kernel.Receiver;
import server_kernel.CollectionManager;
import collection.MusicBand;

import java.util.EnumMap;

public class AddCommand extends Command {
    private Receiver receiver;

    public AddCommand(Receiver receiver) {
        setName(CommandName.ADD);
        setDescription("add a new element in collection");
        this.receiver = receiver;
    }

    @Override
    public void execute(EnumMap<CommandName, Command> map, CollectionManager collectionManager,
                        Invoker invoker, MusicBand musicBand) {
        receiver.add(collectionManager, musicBand);
    }
}
