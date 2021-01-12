package input_output;

import collection.MusicBand;

import java.io.Serializable;

public class Message implements Serializable {
    private String commandName;
    private String commandArgs;
    private MusicBand band;

    public Message(String commandName){
        this.commandName=commandName;
    }

    public Message(String commandName, String commandArgs){
        this.commandName = commandName;
        this.commandArgs = commandArgs;
    }

    public Message(String commandName, MusicBand musicBand){
        this.commandName = commandName;
        band = musicBand;
    }

    public Message(String commandName,String commandArgs,MusicBand musicBand){
        this.commandName = commandName;
        this.commandArgs = commandArgs;
        band = musicBand;
    }

    public String getCommandName(){
        return commandName;
    }

    public String getCommandArgs(){
        return commandArgs;
    }

    public MusicBand getMusicBand(){
        return band;
    }

    @Override
    public String toString(){
        return "RequestCommand{" +
                "commandName='"+ commandName + '\'' +
                ", commandArgs='" + commandArgs + '\'' +
                ", band=" + band +'}';
    }
















}
