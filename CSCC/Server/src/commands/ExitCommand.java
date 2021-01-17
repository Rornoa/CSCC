package commands;

import server_kernel.Invoker;
import server_kernel.Receiver;
import server_kernel.RepositoryOfMusicBand;

public class ExitCommand extends Command {

    private Receiver receiver;

    public ExitCommand(Receiver receiver) {
        this.receiver = receiver;
        setName(CommandName.EXIT);
        setDescription("завершить программу (без сохранения в файл)");
    }

    @Override
    public void execute(RepositoryOfMusicBand repositoryOfMusicBand, Invoker commandManager) {
        receiver.exit();
    }
}
