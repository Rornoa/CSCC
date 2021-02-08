package commands;

import collection.CommandName;
import server_kernel.Invoker;
import server_kernel.Receiver;
import server_kernel.CollectionManager;

public class ExitCommand extends Command {

    private Receiver receiver;

    public ExitCommand(Receiver receiver) {
        this.receiver = receiver;
        setName(CommandName.EXIT);
        setDescription("завершить программу (без сохранения в файл)");
    }

    @Override
    public void execute(CollectionManager collectionManager, Invoker commandManager) {
        receiver.exit();
    }
}
