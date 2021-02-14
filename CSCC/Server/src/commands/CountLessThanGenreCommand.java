package commands;

import collection.CommandName;
import input_output.Message2;
import server_kernel.Invoker;
import server_kernel.Receiver;
import server_kernel.CollectionManager;

public class CountLessThanGenreCommand extends Command{

    private Receiver receiver;

    public CountLessThanGenreCommand(Receiver receiver) {
        this.receiver = receiver;
        setName(CommandName.COUNT_LESS_THAN_GENRE);
        setDescription("вывести количество элементов, значение поля genre которых меньше заданного");
    }

    @Override
    public Message2 execute(CollectionManager collectionManager, Invoker commandManager) {
       return receiver.countLessThanGenreCommand();
    }

}
