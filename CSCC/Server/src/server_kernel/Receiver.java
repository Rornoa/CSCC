package server_kernel;


import collection.MusicBand;
import commands.Command;
import collection.CommandName;
import input_output.ConsoleReader;
import input_output.XMLWriter;

import java.util.EnumMap;
import java.util.Map;

/**
 * Класс, который обеспечивает выполнение команд
 */

public class Receiver {

    XMLWriter xmlWriter;
    ConsoleReader input;

    public Receiver(){
        input = new ConsoleReader();
        xmlWriter = new XMLWriter();
    }


    public void info(CollectionManager collectionManager){
        collectionManager.info();
    }

    public void help(EnumMap<CommandName, Command> map ) {
        System.out.println("Справка по командам:");
        System.lineSeparator();
        for(Map.Entry<CommandName, Command> entry : map.entrySet()){
            System.out.println(entry.getKey() + " - "+ entry.getValue().getArgs()+" "+entry.getValue().getDescription()+System.lineSeparator());
        }
        System.out.println("*: если в описании команды имеется '[key]', значит у неё есть аругмент. "+ System.lineSeparator()+
                "*: команда 'execute_script' имеет аргумент [file name] - название файла.");
    }

    public void add(CollectionManager collectionManager, MusicBand musicBand) {
        collectionManager.add(musicBand);
    }

    public void updateId(CollectionManager collectionManager, MusicBand musicBand, Long id){
        collectionManager.updateId(musicBand,id);
    }

    public void removeByID(CollectionManager collectionManager, MusicBand musicBand, Integer id){
        collectionManager.removeByID(id);
    }

    public void printFiledAscendingLabelCommand() {
    }

    public void show(CollectionManager collectionManager) {
        collectionManager.show();
    }

    public void save(CollectionManager collectionManager) {
        xmlWriter.write(collectionManager.getMusicBandCollection());
    }

    public void removeLowerCommand() {
    }

    public void removeFirstCommand() {
    }

    /**
     * Обеспечивает добавление элемента с заданным id
     *
     * @param collectionManager коллекция, которая хранит города
     * @param key              ключ,уникальный id, по по которому будет добавлен элемент
     *      * @see RepositoryOfCity#insert(int)
     */

    public void insert(CollectionManager collectionManager, MusicBand musicBand, Integer key) {
        collectionManager.insert(musicBand,key);
    }

    public void filterStartsWithName() {
    }

    /**
     * Обеспечивает завершение приложения
     */

    public void exit() {
        System.out.println("System exited");
        System.exit(0);
    }

    public void executeScriptCommand() {
    }

    public void countLessThanGenreCommand() {
    }

    public void clear() {
    }
}
