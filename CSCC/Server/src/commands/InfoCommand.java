package commands;

import collection.CommandName;
import input_output.Message2;
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
    public Message2 execute(CollectionManager repositoryOfCity) {
       return receiver.info(repositoryOfCity);
    }
}
