package commands;

import collection.CommandName;
import input_output.Message2;
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
    public Message2 execute(CollectionManager collectionManager, Invoker commandManager) {
       return receiver.exit();
    }
}
