package commands;

import collection.CommandName;
import input_output.Message2;
import server_kernel.Invoker;
import server_kernel.Receiver;
import server_kernel.CollectionManager;
import collection.MusicBand;

import java.util.EnumMap;

public class RemoveByIdCommand extends Command {

    Receiver receiver;

    public RemoveByIdCommand(Receiver receiver){
        setName(CommandName.REMOVE_BY_ID);
        setDescription("удалить элемент из коллекции по его id");
        this.receiver = receiver;
    }

    @Override
    public Message2 execute(EnumMap<CommandName,Command> map, CollectionManager collectionManager, Invoker invoker, MusicBand musicBand, String... args){
        int key = Integer.parseInt(args[0]);
       return receiver.removeByID(collectionManager,musicBand,key);
    }
}
