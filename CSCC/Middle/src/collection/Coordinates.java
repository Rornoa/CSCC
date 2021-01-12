package collection;

public class Coordinates {
    private long x;
    private Double y; //Максимальное значение поля: 302, Поле не может быть null

    public Coordinates() { }

    public long getX() {
        return x;
    }

    public Double getY() {
        return y;
    }

    public void setX(long x) {
        this.x = x;
    }

    public void setY(Double y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return "X = " + x + ", Y = " + y;
    }

}