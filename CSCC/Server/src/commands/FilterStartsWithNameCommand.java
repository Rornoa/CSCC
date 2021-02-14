package commands;

import collection.CommandName;
import input_output.Message2;
import server_kernel.Invoker;
import server_kernel.Receiver;
import server_kernel.CollectionManager;

public class FilterStartsWithNameCommand extends Command {

    private Receiver receiver;

    public FilterStartsWithNameCommand(Receiver receiver) {
        this.receiver = receiver;
        setName(CommandName.FILTER_STARTS_WITH_NAME);
        setDescription("вывести элементы, значение поля name которых начинается с заданной подстроки");
    }

    @Override
    public Message2 execute(CollectionManager collectionManager, Invoker commandManager) {
       return receiver.filterStartsWithName();
    }
}
