package xml;

import collection.MusicBand;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;

public class XMLReader {
    public static String fileName;

    public static void readAllFromFile() {
        fileName = "C:\\Users\\23\\IdeaProjects\\Lab5VT\\src\\goups";
        File file = new File(fileName);
        try (InputStreamReader reader = new InputStreamReader(new FileInputStream(file))) {

            while (true) {
                int x = reader.read();
                char b = (char) x;
                System.out.println(b);
            }
        } catch (IOException e) { System.out.println(e.getMessage()); }

    }

    public Map<? extends Integer,? extends MusicBand> parseXML() {


        return null;
    }
}
