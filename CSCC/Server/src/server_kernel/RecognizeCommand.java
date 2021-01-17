package server_kernel;

import collection.MusicBand;
import commands.AddCommand;
import commands.Command;
import commands.CommandName;
import commands.InfoCommand;

import java.util.EnumMap;
import java.util.Scanner;

public class RecognizeCommand {

    public RepositoryOfMusicBand repositoryOfMusicBand;
    public Invoker invoker;
    public MusicBand musicBand;
    public Scanner scanner;
    String request;

    public RecognizeCommand(){ }

    public void runTea(EnumMap<CommandName, Command> map, MusicBand musicBand){
        while (true) {
            String[] parts = request.split(" ");
            String nameOfCommand = parts[0];
            String elementForCommand = parts[1];

            switch(nameOfCommand){
                case "add" :
                    System.out.println("add command executed");
                    AddCommand addCommand = (AddCommand) map.get(CommandName.ADD);
                    addCommand.setArgs(elementForCommand);
                    invoker.executeCommand(map, CommandName.ADD, repositoryOfMusicBand);
                case "info" :
                    System.out.println("info command executed");
                    InfoCommand infoCommand = (InfoCommand) map.get(CommandName.INFO);
                    invoker.executeCommand(map, CommandName.INFO, repositoryOfMusicBand);
                case "help" :
                    System.out.println("help command executed");
                    invoker.executeCommand(map, CommandName.HELP, repositoryOfMusicBand );
                case "clear" :
                    System.out.println("clear command executed");
                    invoker.executeCommand(map, CommandName.CLEAR,repositoryOfMusicBand);






            }
            }

        }


}
