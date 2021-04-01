import java.util.*;

//Суть работы дописать 5 методов в готовом коде
public class AStarState
{
    private Map2D map;
    //нестатическое поле для "открытых вершин"
    private Map<Location, Waypoint> Opened = new java.util.HashMap<Location, Waypoint>();
    //нестатическое поле для "закрытых вершин"
    private Map<Location, Waypoint> Closed = new java.util.HashMap<Location, Waypoint>();

    public AStarState(Map2D map)
    {
        if (map == null)
            throw new NullPointerException("map cannot be null");
        this.map = map;
    }

    public Map2D getMap()
    {
        return map;
    }

    //1)
    //возвращает количество точек в наборе открытых вершин
    public int numOpenWaypoints()
    {
        // у мапы (коллекции) метод size возвращает кол-во элементов
        return Opened.size();
    }

    //2)
    //проверить все вершины в наборе открытых вершин, и после этого возвращает ссылку на вершину с наименьшей общей стоимостью.
    public Waypoint getMinOpenWaypoint()
    {
        if (Opened.size() == 0) return null;
        // получаем массив из вершин
        ArrayList<Waypoint> waypoints = new ArrayList<Waypoint>(Opened.values());
        float mincost = waypoints.get(0).getTotalCost();
        Waypoint min = waypoints.get(0);
        // поиск минимального элемента в массиве
        for (int i = 1; i < waypoints.size(); i++) {
            if (waypoints.get(i).getTotalCost() < mincost) {
                min = waypoints.get(i);
                mincost = min.getTotalCost();
            }
        }
        //возврат вершины с минимальным значением
        return min;
    }

    //3)
    //добавлять указанную вершину только в том случае, если существующая вершина хуже новой.
    public boolean addOpenWaypoint(Waypoint newWP)
    {
        if (Opened.get(newWP.getLocation()) == null ) {
            Opened.put(newWP.getLocation(), newWP);
            return true;
        }
        else
        {
            if (Opened.get(newWP.getLocation()).getPreviousCost() >
                    newWP.getPreviousCost()) {
                Opened.put(newWP.getLocation(), newWP);
                return true;
            }
        }
        return false;
    }

    //4)
    //возвращать значение true, если указанное местоположение встречается в наборе закрытых вершин
    public boolean isLocationClosed(Location loc)
    {
        if (Closed.containsKey(loc)) return true;
        return false;
    }

    //5)
    //перемещает вершину из набора «открытых вершин» в набор «закрытых вершин»
    public void closeWaypoint(Location loc)
    {
        Closed.put(loc, Opened.remove(loc));
    }
}