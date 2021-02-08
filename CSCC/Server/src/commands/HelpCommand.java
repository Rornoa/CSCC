package commands;
import collection.CommandName;
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
    public void execute(CollectionManager collectionManager, Invoker commandManager) {
        //receiver.help();
    }
}
