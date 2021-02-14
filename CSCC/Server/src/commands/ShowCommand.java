package commands;

import collection.CommandName;
import input_output.Message2;
import server_kernel.Invoker;
import server_kernel.Receiver;
import server_kernel.CollectionManager;

public class ShowCommand extends Command {

    private Receiver receiver;

    public ShowCommand(Receiver receiver) {
        this.receiver = receiver;
        setName(CommandName.SHOW);
        setDescription("вывести в стандартный поток вывода все элементы коллекции в строковом представлении");
    }
    @Override
    public Message2 execute(CollectionManager collectionManager, Invoker commandManager) {
       return receiver.show(collectionManager);
    }
}
