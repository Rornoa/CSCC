package commands;

import server_kernel.Invoker;
import server_kernel.Receiver;
import server_kernel.RepositoryOfMusicBand;

public class ShowCommand extends Command {

    private Receiver receiver;

    public ShowCommand(Receiver receiver) {
        this.receiver = receiver;
        setName(CommandName.SHOW);
        setDescription("вывести в стандартный поток вывода все элементы коллекции в строковом представлении");
    }
    @Override
    public void execute(RepositoryOfMusicBand repositoryOfMusicBand, Invoker commandManager) {
        receiver.show();
    }
}
