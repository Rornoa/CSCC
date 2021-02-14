package commands;

import collection.CommandName;
import input_output.Message2;
import server_kernel.Invoker;
import server_kernel.Receiver;
import server_kernel.CollectionManager;

public class InsertCommand extends Command{

    private Receiver receiver;

    public InsertCommand(Receiver receiver) {
        this.receiver = receiver;
        setName(CommandName.INSERT_AT);
        setDescription("вывести справку по доступным командам");
    }

    @Override
    public Message2 execute(CollectionManager collectionManager, Invoker commandManager) {
     // return   receiver.insert();
        return null;
    }
}
