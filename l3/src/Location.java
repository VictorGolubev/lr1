import java.util.Objects;

public class Location
{
    public int xCoord;
    public int yCoord;

    public Location(int x, int y)
    {
        xCoord = x;
        yCoord = y;
    }

    public Location() {
        this(0, 0);
    }

    //Сравнение классов Location (по их содержимому, координаты x и y)
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Location location = (Location) o;
        return xCoord == location.xCoord &&
                yCoord == location.yCoord;
    }

    public int hashCode() {
        return Objects.hash(xCoord, yCoord);
    }
}