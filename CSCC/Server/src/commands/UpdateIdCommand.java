package commands;

import collection.CommandName;
import input_output.Message2;
import server_kernel.Invoker;
import server_kernel.Receiver;
import server_kernel.CollectionManager;
import collection.MusicBand;

import java.util.EnumMap;

public class UpdateIdCommand extends Command{

    private Receiver receiver;

    public UpdateIdCommand(Receiver receiver) {
        setName(CommandName.UPDATE);
        setDescription("обновить значение элемента коллекции, id которого равен заданному");
        this.receiver = receiver;
    }


    public Message2 execute(EnumMap<CommandName, Command> map, CollectionManager collectionManager,
                            Invoker commandManager, MusicBand musicBand, String... args) {
        long id = Integer.parseInt(args[0]);
      return   receiver.updateId(collectionManager,musicBand, id);
    }
}
