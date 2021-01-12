package collection.building;

import exceptions.*;
import collection.Coordinates;

import java.util.Scanner;

public class BandCoordinatesBuilder implements ICoordinateBuilder, IMassages {
    private Scanner scanner;
    private Coordinates coordinates;

    public BandCoordinatesBuilder(Scanner scanner){
        coordinates=new Coordinates();
        this.scanner = scanner;
    }

    @Override
    public void setX() {
        while (true) {
            System.out.println("Введите координату Х ");
            try {
                String readLine = scanner.nextLine().trim();
                if (readLine.length() == 0) {
                    System.out.println(messageOfEmptyFormatError);
                    continue;
                }

                if(readLine.length()==5){
                    System.out.println(messageOfInputValueError);
                    continue;
                }

                long parsedLine = Long.parseLong(readLine);
                coordinates.setX(parsedLine);
                break;

            } catch (NumberFormatException e) {
                System.out.println(messageOfInputValueError);
            }
        }
    }

    @Override
    public void setY() {
        while (true) {
            System.out.println("Введите координату Y ");
            try {
                String readLine = scanner.nextLine().trim();
                if (readLine.length() == 0) {
                    System.out.println(messageOfEmptyFormatError);
                    continue;
                }

                if(readLine.length()==5){
                    System.out.println(messageOfInputValueError);
                    continue;
                }

                double parsedLine = Double.parseDouble(readLine);
                coordinates.setY(parsedLine);
                    break;
            } catch (NumberFormatException e) {
                System.out.println(messageOfInputValueError);
            }
        }
    }

    @Override
    public Coordinates create() {
        System.out.println("Введите координаты");
        setX();
        setY();
        return coordinates;
    }
}
