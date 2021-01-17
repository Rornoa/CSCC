package server_kernel;

import collection.building.BandBuilder;
import collection.MusicBand;

import java.time.format.DateTimeFormatter;
import java.util.Vector;

/**
 * Класс, который хранит в себе коллекцию объектов и хранит реализациюю некоторых команд, связанных с коллекцией напрямую
 */

public class RepositoryOfMusicBand {

    private final Vector<MusicBand> musicBandCollection = new Vector<>();
    private BandBuilder bandBuilder;
    private MusicBand musicBand;
    //private LocalDateTime birthYearOfTreemap;

    public RepositoryOfMusicBand(){
            this.bandBuilder = new BandBuilder();
    }

    public Vector<MusicBand> getMusicBandCollection(){
        return musicBandCollection;}

    /**
     * Реализация добавления объекта в коллекцию
     */

    public void add(MusicBand musicBand){
     try{musicBandCollection.addElement(musicBand);
         System.out.println("Обьект был добавлен в коллекцию, не забудьте сохранить его в коллекции!");
     }catch(StackOverflowError e){
         System.out.println("Коллекция переполнена, вы не можете добавить коллекцию");
     }
    }

    /**
     * Реализация удаления объекта из коллекции по заданному id
     *
     * @param id значение id элемента, который хотим удалить
     */

    public void removeByID(int id){
        if(!musicBandCollection.isEmpty()){
            if(musicBandCollection.get(id)!= null){
                musicBandCollection.remove(id);
                System.out.println("Объект "+getMusicBandCollection().get(id).getName()+" удален");
            }
            else{ System.out.println("Обьект с таким id не найден"); }
        }
        else { System.out.println("Коллекция пуста. Невозможно удалить сто-либо"); }
    }

    /**
     * Реализация получение объекта из коллекции по id
     *
     * @param id значение id объекта, который хотим получить
     * @return возвращает объект, если в коллекции он присутстывует; иначе - сообщение об его отсутствии
     */

    public MusicBand getObjectOfCollection(int id){
        if(musicBandCollection.get(id) !=null){
            return musicBandCollection.get(id);
        }
        else{ System.out.println("В коллекции не найден обьект с заданным ключем");
            return null;
        }
    }

   //public void setMusicBandPath(){}

    public void getSizeOfCollection(){}

    public void clearCollection(){
        if(!musicBandCollection.isEmpty()){
            musicBandCollection.clear();
            System.out.println("Коллекция успешно очищена");
        }
        else System.out.println("Коллекция уже пуста");
    }

    public void showCollection(){}

    public void removeGreaterElement(){}

    public void removeLowerElement(){}

    public void info(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
    }

    public void updateId(MusicBand musicBand, Long id) {
        if(!musicBandCollection.isEmpty()){
            for(int i=0;i<musicBandCollection.size();i++){
                if(id==musicBand.getId()){
                    musicBandCollection.set(i,musicBand);
                    musicBand.setId(id);
                }else{ System.out.println("Поле id не совпадает со своим элементом коллекции"); }
            }
        }
        else{ System.out.println("Коллекция пуста."); }
    }

    public void insert(MusicBand musicBand, int key) {}

    public void replaceIfGreater(MusicBand musicBand, int key) {}

    /*public void removeByID(MusicBand musicBand, Integer id) {
    }*/

    public void show() {
        if(getMusicBandCollection().isEmpty()){
            System.out.println("Коллекция пуста");
        } else {

        }
    }
}
