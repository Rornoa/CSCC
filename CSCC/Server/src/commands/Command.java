package commands;

import server_kernel.Invoker;
import server_kernel.RepositoryOfMusicBand;
import collection.MusicBand;

import java.io.IOException;
import java.util.EnumMap;

/**
 * Абсрактный класс Команды. Содержит в себе название, описание команды и ее аргументы и выполение
 */

public abstract class Command {

    private CommandName name;
    private String description;
    private String args = "";

    public void execute(EnumMap<CommandName, Command> map, RepositoryOfMusicBand repositoryOfMusicBand,
                        Invoker invoker, String... args) throws IOException {
    }
    public void execute(EnumMap<CommandName, Command> map, RepositoryOfMusicBand repositoryOfMusicBand,
                        Invoker invoker){
    }

    public void execute(EnumMap<CommandName, Command> map, RepositoryOfMusicBand repositoryOfMusicBand,
                        Invoker invoker, MusicBand musicBand){
    }

    public void execute(EnumMap<CommandName, Command> map, RepositoryOfMusicBand repositoryOfCity,
                        Invoker invoker, MusicBand musicBand, String... args) throws IOException {
    }

    public void execute(EnumMap<CommandName, Command> map, CommandName commandName, RepositoryOfMusicBand repositoryOfMusicBand){

    }

    public void execute(RepositoryOfMusicBand repositoryOfMusicBand, Invoker commandManager){}

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
        this.name = name;
    }

    public CommandName getName() {
        return name;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
