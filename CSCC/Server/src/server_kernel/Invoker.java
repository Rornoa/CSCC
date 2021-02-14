package server_kernel;

import commands.Command;
import collection.CommandName;
import input_output.Message2;

import java.util.EnumMap;

/**
 * В инвокере унифицированно определяем метод выполнения комманды для любой команды "execute"
 * В метод экзекьют инвокера подается имя команды "collection.CommandName" по которому он находит обьект класса команды,
 * он вызывает у этого обьекта метод экзекьют, который в свою очередь определен для каждой команды отдельно в абстрактном классе "Command"
 * и далее переовпределяется в классе каждой команды
 */

public class Invoker {

    private final EnumMap<CommandName, Command> commandMap = new EnumMap<>(CommandName.class);
    private final CollectionManager collectionManager = new CollectionManager();

    public void setCommandMap(CommandName commandName, Command command){
        commandMap.put(commandName,command);
    }

    public EnumMap<CommandName, Command> getCommandMap(){return commandMap;}

    public Message2 executeCommand(CommandName commandName){
        Command command = commandMap.get(commandName);
       return command.execute(collectionManager);
    }
}
