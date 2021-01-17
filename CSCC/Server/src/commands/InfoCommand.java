package commands;

import server_kernel.Invoker;
import server_kernel.Receiver;
import server_kernel.RepositoryOfMusicBand;

public class InfoCommand extends Command {

    private Receiver receiver;

    public InfoCommand(Receiver receiver) {
        setName(CommandName.INFO);
        setDescription("вывести справку по доступным командам");
        this.receiver = receiver;
    }

    @Override
    public void execute(RepositoryOfMusicBand repositoryOfCity,
                        Invoker commandManager, String... args) {
        receiver.info(repositoryOfCity);
    }
}
