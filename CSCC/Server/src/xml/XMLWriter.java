package xml;

import collection.MusicBand;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Vector;

public class XMLWriter {

        private static String texttoWriteIn;
        private static String fileName;

    public static void writeInFile()  {
        fileName = "C:\\Users\\User\\IdeaProjects\\Lab5VT\\Server\\src\\goups.txt";
        texttoWriteIn = "";
        File file = new File(fileName);

        if (!file.exists()){
            System.out.println("Файла не существует, создадим новый");

        }
        if (!file.isFile()) System.out.println("это не файл");

        if (!file.canWrite()) {
            System.out.println("Доступ для записи в файл запрещен");

        } else {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(file, true))) {
                writer.write(texttoWriteIn);
                System.out.println("\nКоллекция сохранена в файл");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
    public void write(Vector<MusicBand> musicBandCollection) {
    }
}

