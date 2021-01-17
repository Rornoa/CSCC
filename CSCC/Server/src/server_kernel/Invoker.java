package server_kernel;

import commands.Command;
import commands.CommandName;

import java.util.EnumMap;

/**
 * В инвокере унифицированно определяем метод выполнения комманды для любой команды "execute"
 * В метод экзекьют инвокера подается имя команды "CommandName" по которому он находит обьект класса команды,
 * он вызывает у этого обьекта метод экзекьют, который в свою очередь определен для каждой команды отдельно в абстрактном классе "Command"
 * и далее переовпределяется в классе каждой команды
 */

public class Invoker {

    private final EnumMap<CommandName, Command> commandMap = new EnumMap<>(CommandName.class);

    public void setCommandMap(CommandName commandName, Command command){
        commandMap.put(commandName,command);
    }

    public EnumMap<CommandName, Command> getCommandMap(){return commandMap;}

    public void executeCommand(EnumMap<CommandName, Command> map, CommandName commandName, RepositoryOfMusicBand repositoryOfMusicBand){
        Command command = map.get(commandName);
        command.execute(map,commandName ,repositoryOfMusicBand);
    }
}
