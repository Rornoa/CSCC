package commands;

import server_kernel.Invoker;
import server_kernel.Receiver;
import server_kernel.RepositoryOfMusicBand;

public class ClearCommand extends Command {

    private Receiver receiver;

    public ClearCommand(Receiver receiver) {
        this.receiver = receiver;
        setName(CommandName.CLEAR);
        setDescription("очистить коллекцию");
    }

    @Override
    public void execute(RepositoryOfMusicBand repositoryOfMusicBand, Invoker commandManager) {
        receiver.clear();
    }

}
