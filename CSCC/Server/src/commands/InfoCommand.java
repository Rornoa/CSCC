package commands;

import collection.CommandName;
import server_kernel.Receiver;
import server_kernel.CollectionManager;

public class InfoCommand extends Command {

    private Receiver receiver;

    public InfoCommand(Receiver receiver) {
        this.receiver = receiver;
        setDescription("вывести справку по доступным командам");
        setName(CommandName.INFO);
    }

    @Override
    public void execute(CollectionManager repositoryOfCity) {
        receiver.info(repositoryOfCity);
    }
}
