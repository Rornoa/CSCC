package collection.generators;

import java.util.Vector;

public class idGenerator {

    /**
     * Множество, в котором хранятся id всех элементов коллекции
     */

    private static Vector<Integer> idSet = new Vector<>();

    /**
     * Счетчик. Нужен для генерации уникального id
     */

    private static Integer count = 1;

    /**
     * Метод,который обеспечивает уникальность id каждому элементу.
     * При каждом вызове метода, счетчик увеличивается на 1.
     * @return возвращает уникальный id
     * @throws StackOverflowError ошбика переполнения множества
     *
     */

    public static int generate() throws StackOverflowError {
        while (idSet.contains(count)) {
            if (count == Integer.MAX_VALUE) {
                throw new StackOverflowError();
            } else {
                count++;
            }
        }
        put(count);
        return count;
    }

    public static void put(Integer id) {
        idSet.add(count);
    }

    public static void remove(Integer id) {
        idSet.remove(id);
        count = Math.min(id, count);
    }

    public static void clear() {
        idSet.clear();
        count = 1;
    }

    public static Vector<Integer> getIdSet() {
        return idSet;
    }

}
