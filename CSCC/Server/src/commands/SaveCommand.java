package commands;

import collection.CommandName;
import input_output.Message2;
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
    public Message2 execute(CollectionManager collectionManager, Invoker commandManager) {
       return receiver.save(collectionManager);
    }
}
