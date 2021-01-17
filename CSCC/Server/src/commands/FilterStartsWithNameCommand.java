package commands;

import server_kernel.Invoker;
import server_kernel.Receiver;
import server_kernel.RepositoryOfMusicBand;

public class FilterStartsWithNameCommand extends Command {

    private Receiver receiver;

    public FilterStartsWithNameCommand(Receiver receiver) {
        this.receiver = receiver;
        setName(CommandName.FILTER_STARTS_WITH_NAME);
        setDescription("вывести элементы, значение поля name которых начинается с заданной подстроки");
    }

    @Override
    public void execute(RepositoryOfMusicBand repositoryOfMusicBand, Invoker commandManager) {
        receiver.filterStartsWithName();
    }
}
