package commands;

import collection.CommandName;
import input_output.Message2;
import server_kernel.Invoker;
import server_kernel.Receiver;
import server_kernel.CollectionManager;

public class ClearCommand extends Command {

    private Receiver receiver;

    public ClearCommand(Receiver receiver) {
        this.receiver = receiver;
        setName(CommandName.CLEAR);
        setDescription("очистить коллекцию");
    }

    @Override
    public Message2 execute(CollectionManager collectionManager, Invoker commandManager) {
       return receiver.clear();
    }

}
