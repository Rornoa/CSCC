package commands;

import server_kernel.Invoker;
import server_kernel.Receiver;
import server_kernel.RepositoryOfMusicBand;

public class ExecuteScriptCommand extends Command {

    private Receiver receiver;

    public ExecuteScriptCommand(Receiver receiver) {
        this.receiver = receiver;
        setName(CommandName.EXECUTE_SCRIPT);
        setDescription("считать и исполнить скрипт из указанного файла. В скрипте содержатся команды в таком же виде, в котором их вводит пользователь в интерактивном режиме.");
    }

    @Override
    public void execute(RepositoryOfMusicBand repositoryOfMusicBand, Invoker commandManager) {
        receiver.executeScriptCommand();
    }
}
