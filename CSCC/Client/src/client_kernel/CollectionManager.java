package client_kernel;

import collection.building.*;
import collection.Coordinates;
import collection.MusicBand;
import collection.MusicGenre;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collections;
import java.util.Date;
import java.util.Scanner;
import java.util.Vector;

public class CollectionManager {

    public static String filePathToWriteName;

    private Application app;
    private Date initialisationDate;
    private Vector<MusicBand> vector;

    public CollectionManager(Application application) {
        this.app = application;
        this.initialisationDate = new Date();
        vector = new Vector<MusicBand>();
    }

    void info() {
        System.out.println("Коллекция Vector хранит обьекты музыкальных групп MusicBand");
        System.out.println("Коллекция была проинициализирована: " + initialisationDate);
        System.out.println("Коллекция содержит: " + vector.size() + " элементов");
    }

    void help() {
        System.out.println("Доступные команды" + "\n" +
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
                "print_field_ascending_label : вывести значения поля label всех элементов в порядке возрастания");
    }

    void clear() {
        vector.removeAllElements();
        System.out.println("Коллекция была очищена.");
    }

    void save() {
        System.out.println("Комманда save была вызвана");
        filePathToWriteName = "C:\\Users\\User\\IdeaProjects\\CommandConsole\\resources\\groups.xml";
        String texttoWriteIn = "<Objects>\n";
        for (MusicBand musicBand : vector) {
            Coordinates coordinates = musicBand.getCoordinates();
            texttoWriteIn += "    <MusicBand>\n" +
                    "        <name>" + musicBand.getName() + "</name>\n" +
                    "        <label>\n" +
                    "\t        <name>" + musicBand.getLabel().toString() + "</name>\n" +
                    "        </label>\n" +
                    "        <coordinate>\n" +
                    "\t        <x>" + coordinates.getX() + "</x>\n" +
                    "\t        <y>" + coordinates.getY() + "</y>\n" +
                    "        </coordinate>\n" +
                    "        <id>" + musicBand.getId() + "</id>\n" +
                    "        <numberOfParticipiants>" + musicBand.getNumberOfParticipants() + "</numberOfParticipiants >\n" +
                    "        <genre>" + musicBand.getGenre() + "</genre>\n" +
                    "        <creationDate>" + musicBand.getCreationDate() + "</creationDate>\n" +
                    "    </MusicBand>\n";
        }
        texttoWriteIn += "</Objects>";
        File file = new File(filePathToWriteName);
        System.out.println(file.getAbsolutePath());
        try {

            System.out.println(file.createNewFile());


            if (!file.isFile()) {
                System.out.println("это не файл");
                return;
            }

            if (!file.canWrite()) {
                System.out.println("Доступ для записи в файл запрещен");
                return;
            }
            BufferedWriter writer = new BufferedWriter(new FileWriter(file, false));
            writer.write(texttoWriteIn);
            writer.close();
            System.out.println("\nКоллекция сохранена в файл");


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    void removeFirst() {
        System.out.println("Комманда remove_first была вызвана");
        if (vector.isEmpty()) System.out.println("Коллекция пуста!");
        else {
            vector.remove(vector.firstElement());
            System.out.println("Первый элемент коллекции был удален");
        }
    }

    void exit() {
        System.out.println("Комманда exit была вызвана");
        System.exit(0);
    }

    void show() {
        System.out.println("Комманда show была вызвана");
        System.out.println("Все элементы коллекции в строковом представлении:  \n");
        for (MusicBand band : vector) System.out.println(band.toString());
    }

    void add(MusicBand musicBand) {
        vector.add(musicBand);
        System.out.println("Только что созданная музыкальная группа была добавлена в коллекцию");
    }

    void printFieldAscendingLabel() {
        System.out.println("Комманда print_field_ascending_label была вызвана");
        Collections.sort(vector);
        for (MusicBand band : vector) {
            System.out.println(band.getLabel().getName());
        }
        System.out.println("Значения поля label всех элементов в порядке возрастания были выведены");
    }

    void removeById(int key) {
        System.out.println("Комманда remove_by_id была вызвана");
        if (vector.contains(vector.elementAt(key))) {
            vector.remove(key);
            System.out.println("Элемент " + key + " удален");
        } else System.out.println("Такого элемента нет в коллекции");
    }

    void update(Long id, MusicBand musicBand) {
        System.out.println("Комманда update была вызвана");
        for (int i = 0; i < vector.size(); i++) {
            if (id.equals(vector.get(i).getId())) {
                musicBand.setId(id);
                vector.set(i, musicBand);
                return;
            }
        }
        System.out.println("Не найден элемент с id " + id);
    }

    void insertAtIndex(Integer index, MusicBand musicBand) {
        System.out.println("Комманда insertt_at была вызвана");
        vector.insertElementAt(musicBand, index);
        System.out.println("Элемент " + musicBand + " был добавлен в позицию " + index + " коллекции");
    }

    void removeLower(MusicBand musicBand) {
        System.out.println("Комманда remove_lower была вызвана");
        vector.removeIf(band -> band.compareTo(musicBand) < 0);
    }

    void filterStartsWithName(String name) {
        System.out.println("Комманда filter_starts_with_name была вызвана");
        for (MusicBand band : vector) {
            if (band.getName().startsWith(name)) System.out.println(band.getName() + System.lineSeparator());
            else return;
        }
        System.out.println("Элементов, значение поля name которых начинается с подстроки: " + name + " нет в коллекции");
    }

    void coutLessThanGanre(String name) {
        System.out.println("Комманда count_less_than_genre была вызвана");
        int k = 0;
        try {
            MusicGenre musicGenre = MusicGenre.valueOf(name);
            for (MusicBand band : vector) {
                if (musicGenre.ordinal() < band.getGenre().ordinal()) k++;
            }
            System.out.println("Колличество элементов, значение поля: " + k);
        } catch (IllegalArgumentException e) {
            System.out.println("Такого жанра не существует");
        }

    }

    void executeScript() {
        System.out.println("Комманда execute_script была вызвана");
        String fileName = "C:\\Users\\User\\IdeaProjects\\CommandConsole\\resources\\script.txt";
        File file = new File(fileName);
        Scanner scanner;
        try {
            scanner = new Scanner(file);
            app.go(scanner);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
