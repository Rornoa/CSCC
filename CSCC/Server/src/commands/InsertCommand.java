package commands;

import server_kernel.Invoker;
import server_kernel.Receiver;
import server_kernel.RepositoryOfMusicBand;

public class InsertCommand extends Command{

    private Receiver receiver;

    public InsertCommand(Receiver receiver) {
        this.receiver = receiver;
        setName(CommandName.INSERT_AT);
        setDescription("вывести справку по доступным командам");
    }

    @Override
    public void execute(RepositoryOfMusicBand repositoryOfMusicBand, Invoker commandManager) {
      //  receiver.insert();
    }
}
