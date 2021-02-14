package commands;

import collection.CommandName;
import input_output.Message2;
import server_kernel.Invoker;
import server_kernel.CollectionManager;
import collection.MusicBand;

import java.io.IOException;
import java.util.EnumMap;

/**
 * Абсрактный класс Команды. Содержит в себе название, описание команды и ее аргументы и выполение
 */

public class Command {

    private CommandName name;
    private String description;
    private String args = "";

    public Message2 execute(EnumMap<CommandName, Command> map, CollectionManager collectionManager,
                            Invoker invoker, String... args) throws IOException{
        return null;
    }


    public Message2 execute(EnumMap<CommandName, Command> map, CollectionManager collectionManager,
                                     Invoker invoker){
        return null;
    }

    public Message2 execute(EnumMap<CommandName, Command> map, CollectionManager collectionManager,
                                     Invoker invoker, MusicBand musicBand){
        return null;
    }

    public Message2 execute(EnumMap<CommandName, Command> map, CollectionManager repositoryOfCity,
                                     Invoker invoker, MusicBand musicBand, String... args) throws IOException {
        return null;
    }
    public Message2 execute(EnumMap<CommandName, Command> map, CommandName commandName, CollectionManager collectionManager){
        return null;
    }

    public Message2 execute(CollectionManager collectionManager, Invoker invoker){
        return null;
    }

    public Message2 execute(CollectionManager collectionManager){
        return null;
    }

    public String getArgs() {
        return args;
    }

    public String getDescription() {
        return description;
    }

    public void setArgs(String args) {
        this.args = args;
    }

    public void setName(CommandName commandName) {
        this.name = commandName;
    }

    public CommandName getName() {
        return name;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
