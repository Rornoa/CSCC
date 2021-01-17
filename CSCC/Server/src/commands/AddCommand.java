package commands;

import server_kernel.Invoker;
import server_kernel.Receiver;
import server_kernel.RepositoryOfMusicBand;
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
    public void execute(EnumMap<CommandName, Command> map, RepositoryOfMusicBand repositoryOfMusicBand,
                        Invoker invoker, MusicBand musicBand) {
        receiver.add(repositoryOfMusicBand, musicBand);
    }
}
