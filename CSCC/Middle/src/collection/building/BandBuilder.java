package collection.building;

import exceptions.*;
import collection.*;

import java.util.Scanner;

public class BandBuilder implements IMusicBandBuilder, IMassages{

    private BandCoordinatesBuilder bandCoordinateBuilder;
    private Coordinates coordinates;

    private long numberOfParticipants;
    private Label label;
    private MusicGenre musicGenre;
    private String name;
    private Scanner scanner;

    public BandBuilder(Scanner scanner){
        this.scanner=scanner;
        this.bandCoordinateBuilder=new BandCoordinatesBuilder(scanner);

    }

    @Override
    public void setName() {
        while (true) {
            System.out.println("Выведите название музыкальной группы значение типа 'String' [не менее 3-х букв и не более 20-ти]");
            String readLine = scanner.nextLine().trim();
            System.out.println(readLine);
            if (readLine.length() == 0) {
                System.out.println(messageOfEmptyFormatError);
                continue;
            }

            if (readLine.length() > 3 && readLine.length() < 20) {
                name =(readLine).trim();
                break;
            } else
                System.out.println(messageOfInputValueError);
        }
    }

    @Override
    public void setCoordinates() {coordinates = bandCoordinateBuilder.create();
    }

    @Override
    public void setNumberOfParticipants() {
        while (true) {
            System.out.println("Введите колличество участников музыкальной группы");
            try {
                String readLine = scanner.nextLine().trim();
                if (readLine.length() == 0) {
                    System.out.println(messageOfEmptyFormatError);
                    continue;
                }

                if (readLine.length() > 3) {
                    System.out.println(messageOfInputValueError);
                    continue;
                }

                int parsedLine = Integer.parseInt(readLine);
                    numberOfParticipants = Integer.parseInt(readLine);
                    break;
            } catch(NumberFormatException e){
                System.out.println(messageOfInputValueError);
            }
        }
    }

    @Override
    public void setGenre() {
        while (true) {
        System.out.println("Выберите жанр для группы из доступных: ");
        MusicGenre.printAllGenres();
        System.out.println("Для этого введите соответствующий порядковый номер");
            try {
        String readLine = scanner.nextLine().trim();
                if (readLine.length() == 0) {
                    System.out.println(messageOfEmptyFormatError);
                    continue;
                }

                if (Integer.parseInt(readLine.trim()) == MusicGenre.POP.getNumber()) {
                    musicGenre = MusicGenre.POP;
                    System.out.println("Жарн группы успешно выбран: " + musicGenre.getName());
                    break;
                } else if (Integer.parseInt(readLine.trim()) == MusicGenre.RAP.getNumber()) {
                    musicGenre = MusicGenre.RAP;
                    System.out.println("Жарн группы успешно выбран: " + musicGenre.getName());
                    break;
                } else if (Integer.parseInt(readLine.trim()) == MusicGenre.ROCK.getNumber()) {
                    musicGenre = MusicGenre.ROCK;
                    System.out.println("Жарн группы успешно выбран: " + musicGenre.getName());
                    break;
                } else if (Integer.parseInt(readLine.trim()) == MusicGenre.POST_PUNK.getNumber()) {
                    musicGenre = MusicGenre.POST_PUNK;
                    System.out.println("Жарн группы успешно выбран: " + musicGenre.getName());
                    break;
                } else if (Integer.parseInt(readLine.trim()) == MusicGenre.PSYCHEDELIC_ROCK.getNumber()) {
                    musicGenre = MusicGenre.PSYCHEDELIC_ROCK;
                    System.out.println("Жарн группы успешно выбран: " + musicGenre.getName());
                    break;
                }else if (Integer.parseInt(readLine.trim()) == MusicGenre.JAZZ.getNumber()) {
                    musicGenre = MusicGenre.JAZZ;
                    System.out.println("Жарн группы успешно выбран: " + musicGenre.getName());
                    break;
                }
                else {
                    System.out.println(System.lineSeparator() + messageOfInputFormatError);

                }
            }catch (NumberFormatException e) {
                System.out.println(messageOfInputFormatError);
            }
        }
    }

    @Override
    public void setLabel() {
        while (true) {
            System.out.println("Введите название лейбла группы");
            String readLine = scanner.nextLine().trim();
            if (readLine.length() == 0) {
                System.out.println(messageOfEmptyFormatError);
                continue;
            }
            label = new Label(readLine);
            break;
        }

    }

    @Override
    public MusicBand create() {
        System.out.println(System.lineSeparator()+"Начинается инициализация группы:");
        setName();
        setCoordinates();
        setNumberOfParticipants();
        setGenre();
        setLabel();
        System.out.println("Группа была успешно создана");
        return new MusicBand(name,coordinates,numberOfParticipants,musicGenre,label);

    }

}
