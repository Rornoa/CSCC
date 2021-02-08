package commands;

import collection.CommandName;
import server_kernel.Invoker;
import server_kernel.Receiver;
import server_kernel.CollectionManager;

public class SaveCommand extends Command {

    private Receiver receiver;

    public SaveCommand(Receiver receiver) {
        this.receiver = receiver;
        setName(CommandName.SAVE);
        setDescription("сохранить коллекцию");
    }

    @Override
    public void execute(CollectionManager collectionManager, Invoker commandManager) {
        receiver.save(collectionManager);
    }
}
