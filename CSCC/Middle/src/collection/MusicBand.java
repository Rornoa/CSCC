package collection;

import java.time.ZonedDateTime;


public class MusicBand implements Comparable<MusicBand> {
    static long ID = 1;
    private Long id; //Поле не может быть null, Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    private String name; //Поле не может быть null, Строка не может быть пустой
    private Coordinates coordinates; //Поле не может быть null
    private ZonedDateTime creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически
    private long numberOfParticipants; //Значение поля должно быть больше 0
    private MusicGenre genre; //Поле не может быть null
    private Label label; //Поле не может быть null

    public MusicBand(){
        id = ID++;
        this.creationDate = ZonedDateTime.now();
    }

    public MusicBand(String name, Coordinates coordinates, long numberOfParticipants, MusicGenre genre, Label label) {
        id = ID++;
        this.creationDate = ZonedDateTime.now();
        this.name = name;
        this.coordinates = coordinates;
        this.numberOfParticipants = numberOfParticipants;
        this.genre = genre;
        this.label = label;
        System.out.println("Музыкальная группа "+name + " успешно инициализирована.");
    }

    @Override
    public String toString() {
        return "MusicBand{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", coordinates=" + coordinates +
                ", creationDate=" + creationDate +
                ", numberOfParticipants=" + numberOfParticipants +
                ", genre=" + genre +
                ", label=" + label +
                '}';
    }

    public String getName(){ return name; }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public ZonedDateTime getCreationDate() {
        return creationDate;
    }

    public long getNumberOfParticipants() {
        return numberOfParticipants;
    }

    public MusicGenre getGenre() {
        return genre;
    }

    public Long getId() {
        return id; }

    public Label getLabel() {
        return label;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    public void setNumberOfParticipants(long numberOfParticipants) {
        this.numberOfParticipants = numberOfParticipants;
    }

    public void setGenre(MusicGenre genre) {
        this.genre = genre;
    }

    public void setLabel(String label) {

        this.label =new Label(label);
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int compareTo(MusicBand o) {
        return this.name.compareTo(o.name);
    }
}


