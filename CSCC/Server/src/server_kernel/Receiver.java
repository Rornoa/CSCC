package server_kernel;

import collection.MusicBand;
import collection.CommandName;
import input_output.ConsoleReader;
import input_output.Message2;

/**
 * Класс, который обеспечивает выполнение команд
 */

public class Receiver {

    MusicBand musicBand;
    ConsoleReader input;
    String stringMassageToClient;

    public Receiver() {
        input = new ConsoleReader();
    }

    public Message2 info(CollectionManager collectionManager) {
        collectionManager.info();
        return null;
    }

    public Message2 help() {
          return new Message2( "Доступные команды" + "\n" +
                        "help : вывести справку по доступным командам\n" +
                        "info : вывести в стандартный поток вывода информацию о коллекции (тип, дата инициализации, количество элементов и т.д.)\n" +
                        "show : вывести в стандартный поток вывода все элементы коллекции в строковом представлении\n" +
                        "add {element} : добавить новый элемент в коллекцию\n" +
                        "update id {element} : обновить значение элемента коллекции, id которого равен заданному\n" +
                        "remove_by_id id : удалить элемент из коллекции по его id\n" +
                        "clear : очистить коллекцию\n" +
                        "save : сохранить коллекцию в файл\n" +
                        "execute_script file_name : считать и исполнить скрипт из указанного файла. В скрипте содержатся команды в таком же виде, в котором их вводит пользователь в интерактивном режиме.\n" +
                        "exit : завершить программу (без сохранения в файл)\n" +
                        "insert_at index {element} : добавить новый элемент в заданную позицию\n" +
                        "remove_first : удалить первый элемент из коллекции\n" +
                        "remove_lower {element} : удалить из коллекции все элементы, меньшие, чем заданный\n" +
                        "count_less_than_genre genre : вывести количество элементов, значение поля genre которых меньше заданного\n" +
                        "filter_starts_with_name name : вывести элементы, значение поля name которых начинается с заданной подстроки\n" +
                        "print_field_ascending_label : вывести значения поля label всех элементов в порядке возрастания);");
    }

    public Message2 add(CollectionManager collectionManager, MusicBand musicBand) {
        collectionManager.add(musicBand);
        return null;
    }

    public Message2 updateId(CollectionManager collectionManager, MusicBand musicBand, Long id) {
        collectionManager.updateId(musicBand, id);
        return null;
    }

    public Message2 removeByID(CollectionManager collectionManager, MusicBand musicBand, Integer id) {
        collectionManager.removeByID(id);
        return null;
    }

    public Message2 printFiledAscendingLabelCommand() {
        return null;
    }

    public Message2 show(CollectionManager collectionManager) {
        collectionManager.show();
        return null;
    }

    public Message2 save(CollectionManager collectionManager) {
        //xmlWriter.write(collectionManager.getMusicBandCollection());
        return null;
    }

    public Message2 removeLowerCommand() {
        return null;
    }

    public Message2 removeFirstCommand() {
        return null;
    }

    /**
     * Обеспечивает добавление элемента с заданным id
     *
     * @param collectionManager коллекция, которая хранит города
     * @param key               ключ,уникальный id, по по которому будет добавлен элемент
     *                          * @see RepositoryOfCity#insert(int)
     */

    public Message2 insert(CollectionManager collectionManager, MusicBand musicBand, Integer key) {
        collectionManager.insert(musicBand, key);
        return null;
    }

    public Message2 filterStartsWithName() {
        return null;
    }

    /**
     * Обеспечивает завершение приложения
     */

    public Message2 exit() {
        System.out.println("System exited");
        System.exit(0);
        return  null;
    }

    public Message2 executeScriptCommand() {
        return null;
    }

    public Message2 countLessThanGenreCommand() {
        return null;
    }

    public Message2 clear() {
        return null;
    }
}
