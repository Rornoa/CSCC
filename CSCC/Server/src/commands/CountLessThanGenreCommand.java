package commands;

import server_kernel.Invoker;
import server_kernel.Receiver;
import server_kernel.RepositoryOfMusicBand;

public class CountLessThanGenreCommand extends Command{

    private Receiver receiver;

    public CountLessThanGenreCommand(Receiver receiver) {
        this.receiver = receiver;
        setName(CommandName.COUNT_LESS_THAN_GENRE);
        setDescription("вывести количество элементов, значение поля genre которых меньше заданного");
    }

    @Override
    public void execute(RepositoryOfMusicBand repositoryOfMusicBand, Invoker commandManager) {
        receiver.countLessThanGenreCommand();
    }

}
