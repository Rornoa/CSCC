package commands;

import collection.CommandName;
import server_kernel.Invoker;
import server_kernel.Receiver;
import server_kernel.CollectionManager;

public class RemoveLowerCommand extends Command {

    private Receiver receiver;

    public RemoveLowerCommand(Receiver receiver) {
        this.receiver = receiver;
        setName(CommandName.REMOVE_LOWER);
        setDescription("удалить из коллекции все элементы, меньшие, чем заданный");
    }

    @Override
    public void execute(CollectionManager collectionManager, Invoker commandManager) {
        receiver.removeLowerCommand();
    }

}
