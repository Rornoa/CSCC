package commands;

import server_kernel.Invoker;
import server_kernel.Receiver;
import server_kernel.RepositoryOfMusicBand;

public class SaveCommand extends Command {

    private Receiver receiver;

    public SaveCommand(Receiver receiver) {
        this.receiver = receiver;
        setName(CommandName.SAVE);
        setDescription("сохранить коллекцию");
    }

    @Override
    public void execute(RepositoryOfMusicBand repositoryOfMusicBand, Invoker commandManager) {
        receiver.save();
    }
}
