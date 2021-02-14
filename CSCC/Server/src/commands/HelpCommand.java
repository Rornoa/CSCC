package commands;
import collection.CommandName;
import input_output.Message2;
import server_kernel.Invoker;
import server_kernel.Receiver;
import server_kernel.CollectionManager;

public class HelpCommand extends Command{

    private Receiver receiver;

    public HelpCommand(Receiver receiver) {
        this.receiver = receiver;
        setName(CommandName.HELP);
        setDescription("вывести справку по доступным командам");
    }

    @Override
    public Message2 execute(CollectionManager collectionManager) {
       return receiver.help();
    }
}
