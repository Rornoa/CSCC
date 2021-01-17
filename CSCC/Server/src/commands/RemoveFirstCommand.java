package commands;

import server_kernel.Invoker;
import server_kernel.Receiver;
import server_kernel.RepositoryOfMusicBand;

public class RemoveFirstCommand extends Command{

    private Receiver receiver;

    public RemoveFirstCommand(Receiver receiver) {
        this.receiver = receiver;
        setName(CommandName.REMOVE_FIRST);
        setDescription("удалить первый элемент из коллекции");
    }

    @Override
    public void execute(RepositoryOfMusicBand repositoryOfMusicBand, Invoker commandManager) {
        receiver.removeFirstCommand();
    }
}
