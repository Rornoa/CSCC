package commands;

import collection.CommandName;
import input_output.Message2;
import server_kernel.Invoker;
import server_kernel.Receiver;
import server_kernel.CollectionManager;

public class ExecuteScriptCommand extends Command {

    private Receiver receiver;

    public ExecuteScriptCommand(Receiver receiver) {
        this.receiver = receiver;
        setName(CommandName.EXECUTE_SCRIPT);
        setDescription("считать и исполнить скрипт из указанного файла. В скрипте содержатся команды в таком же виде, в котором их вводит пользователь в интерактивном режиме.");
    }

    @Override
    public Message2 execute(CollectionManager collectionManager, Invoker commandManager) {
       return receiver.executeScriptCommand();
    }
}
