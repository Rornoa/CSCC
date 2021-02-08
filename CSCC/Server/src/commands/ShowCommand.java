package commands;

import collection.CommandName;
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
    public void execute(CollectionManager collectionManager, Invoker commandManager) {
        receiver.show(collectionManager);
    }
}
