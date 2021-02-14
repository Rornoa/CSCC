package commands;

import collection.CommandName;
import input_output.Message2;
import server_kernel.Invoker;
import server_kernel.Receiver;
import server_kernel.CollectionManager;

public class RemoveFirstCommand extends Command{

    private Receiver receiver;

    public RemoveFirstCommand(Receiver receiver) {
        this.receiver = receiver;
        setName(CommandName.REMOVE_FIRST);
        setDescription("удалить первый элемент из коллекции");
    }

    @Override
    public Message2 execute(CollectionManager collectionManager, Invoker commandManager) {
      return   receiver.removeFirstCommand();
    }
}
