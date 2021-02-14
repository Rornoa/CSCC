package input_output;

import collection.MusicBand;

import collection.CommandName;
import collection.MusicBand;
import org.omg.PortableServer.ServantRetentionPolicy;

import java.io.Serializable;

public class Message2 implements Serializable {

    private MusicBand musicBand;
    private CommandName commandName;
    private static String stringMassageToClient;
    private long longArgs;

    public Message2(String stringMassageToClient){
        this.stringMassageToClient = stringMassageToClient;
    }

    public void setCommandName(CommandName commandName) {
        this.commandName = commandName;
    }

    public void setLongArgs(long longArgs) {
        this.longArgs = longArgs;
    }

    public void setMusicBand(MusicBand musicBand) {
        this.musicBand = musicBand;
    }

    public void setStringMessageToClient(String strMTC){
        this.stringMassageToClient = strMTC;
    }

    public CommandName getCommandName() {
        return commandName;
    }

    public long getLongArgs() {
        return longArgs;
    }

    public MusicBand getMusicBand() {
        return musicBand;
    }

    public static String getStringMassageToClient() {
        return stringMassageToClient;
    }

    public void setStringMassageToClient(String stringMassageToClient) {
        this.stringMassageToClient = stringMassageToClient;
    }
}
