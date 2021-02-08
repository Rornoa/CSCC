package commands;

import collection.CommandName;
import server_kernel.Invoker;
import server_kernel.Receiver;
import server_kernel.CollectionManager;

public class PrintFieldAscendingLabelCommand extends Command {

    private Receiver receiver;

    public PrintFieldAscendingLabelCommand(Receiver receiver) {
        this.receiver = receiver;
        setName(CommandName.PRINT_FIELD_ASCENDING_LABEL);
        setDescription("вывести значения поля label всех элементов в порядке возрастания");
    }

    @Override
    public void execute(CollectionManager collectionManager, Invoker commandManager) {
        receiver.printFiledAscendingLabelCommand();
    }
}
