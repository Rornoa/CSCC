package commands;

import server_kernel.Invoker;
import server_kernel.Receiver;
import server_kernel.RepositoryOfMusicBand;

public class HelpCommand extends Command{

    private Receiver receiver;

    public HelpCommand(Receiver receiver) {
        this.receiver = receiver;
        setName(CommandName.HELP);
        setDescription("вывести справку по доступным командам");
    }

    @Override
    public void execute(RepositoryOfMusicBand repositoryOfMusicBand, Invoker commandManager) {
        //receiver.help();
    }
}
