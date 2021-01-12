package collection;

public enum MusicGenre {
    PSYCHEDELIC_ROCK("Психоделический рок", 1),
    RAP("Рэп",2),
    POP("Попса",3),
    POST_PUNK("Пост-панк",4),
    ROCK("Рок",5),
    JAZZ("Джазз",6);


    private String name;
    final private int number;

    MusicGenre(String russianName, int number) {
        this.name = russianName;
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    public String getName() {
        return name;
    }

    public static void printAllGenres(){
        System.out.println(PSYCHEDELIC_ROCK.getNumber()+ " - " + PSYCHEDELIC_ROCK.getName()+"\n"
                        + RAP.getNumber()+ " - " + RAP.getName()+"\n"
                        + POP.getNumber() + " - " + POP.getName()+"\n"
                        + POST_PUNK.getNumber() + " - " + POST_PUNK.getName()+"\n"
                        + ROCK.getNumber() + " - " + ROCK.getName()+"\n"
                        + JAZZ.getNumber() + " - " + JAZZ.getName()+"\n");
    }

}
