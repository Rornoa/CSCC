package server_kernel;


import collection.MusicBand;
import commands.Command;
import commands.CommandName;
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


    public void info(RepositoryOfMusicBand repositoryOfMusicBand){
        repositoryOfMusicBand.info();
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

    public void add(RepositoryOfMusicBand repositoryOfMusicBand, MusicBand musicBand) {
        repositoryOfMusicBand.add(musicBand);
    }

    public void updateId(RepositoryOfMusicBand repositoryOfMusicBand, MusicBand musicBand, Long id){
        repositoryOfMusicBand.updateId(musicBand,id);
    }

    public void removeByID(RepositoryOfMusicBand repositoryOfMusicBand, MusicBand musicBand, Integer id){
        repositoryOfMusicBand.removeByID(id);
    }

    public void printFiledAscendingLabelCommand() {
    }

    public void show(RepositoryOfMusicBand repositoryOfMusicBand) {
        repositoryOfMusicBand.show();
    }

    public void save(RepositoryOfMusicBand repositoryOfMusicBand) {
        xmlWriter.write(repositoryOfMusicBand.getMusicBandCollection());
    }

    public void removeLowerCommand() {
    }

    public void removeFirstCommand() {
    }

    /**
     * Обеспечивает добавление элемента с заданным id
     *
     * @param repositoryOfMusicBand коллекция, которая хранит города
     * @param key              ключ,уникальный id, по по которому будет добавлен элемент
     *      * @see RepositoryOfCity#insert(int)
     */

    public void insert(RepositoryOfMusicBand repositoryOfMusicBand, MusicBand musicBand, Integer key) {
        repositoryOfMusicBand.insert(musicBand,key);
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
