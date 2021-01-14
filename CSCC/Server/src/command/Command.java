package command;

/**
 * Абсрактный класс Команды. Содержит в себе название, описание команды и ее аргументы и выполение
 * Описывает выполнение общего "интерфейса" команд для общения получателя и отправителя.
 */

public abstract class Command {

        private CommandName name;
        private String description;
        private String args="";

        @Override
        public void execute(){

        }

}
