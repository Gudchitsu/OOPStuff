package Map;

import java.util.HashMap;
import java.util.Map;

/**
 * This class stores the basic state necessary for the A* algorithm to compute a path across a map.
 * This state includes a collection of "open waypoints" and another collection of "closed
 * waypoints."  In addition, this class provides the basic operations that the A* pathfinding
 * algorithm needs to perform its processing.
 **/
public class AStarState {

  // Набор открытых вершин
  private HashMap<Location, Waypoint> openWaypoint;
  // Набор закрытых вершин
  private HashMap<Location, Waypoint> closeWaypoint;
  /**
   * This is a reference to the map that the A* algorithm is navigating.
   **/
  private Map2D map;


  /**
   * Initialize a new state object for the A* pathfinding algorithm to use.
   **/
  public AStarState(Map2D map) {
    if (map == null) {
      throw new NullPointerException("map cannot be null");
    }
    openWaypoint = new HashMap<>();
    closeWaypoint = new HashMap<>();
    this.map = map;
  }

  /**
   * Returns the map that the A* pathfinder is navigating.
   **/
  public Map2D getMap() {
    return map;
  }

  /**
   * This method scans through all open waypoints, and returns the waypoint with the minimum total
   * cost.  If there are no open waypoints, this method returns <code>null</code>.
   **/
  public Waypoint getMinOpenWaypoint() {
    // Если вершин нет
    if (openWaypoint.isEmpty()) {
      return null; // Возвращаем null
    }
    Waypoint min = null; // Инициализируем Waypoint
    float temp = Float.MAX_VALUE; // Максимальное значение float
    // Проходим по всем вершинам
    for (Map.Entry<Location, Waypoint> entry : openWaypoint.entrySet()) {
      // Получаем вершину
      Waypoint value = entry.getValue();
      // Сравниваем её общую стоимость с temp
      if (value.getTotalCost() < temp) {
        temp = value.getTotalCost(); // Записываем значение в temp
        min = value; // Запоминаем эту вершину
      }
    }
    return min; // Возвращаем Waypoint с минимальной общей стоимостью
  }

  /**
   * This method adds a waypoint to (or potentially updates a waypoint already in) the "open
   * waypoints" collection.  If there is not already an open waypoint at the new waypoint's location
   * then the new waypoint is simply added to the collection.  However, if there is already a
   * waypoint at the new waypoint's location, the new waypoint replaces the old one <em>only if</em>
   * the new waypoint's "previous cost" value is less than the current waypoint's "previous cost"
   * value.
   **/
  public boolean addOpenWaypoint(Waypoint newWP) {
    Location newLocation = newWP.getLocation(); // Получаем Location newWP
    // Проходим по всем Location в openWaypoint
    for(Location location: openWaypoint.keySet())
    {
      // Если в наборе уже есть такая Location
      if(newLocation.equals(location))
      {
        // Сравниваем стоимость путей, если у новой вершины путь меньше чем у старой
        if(openWaypoint.get(location).getPreviousCost() < newWP.getPreviousCost())
        {
          openWaypoint.put(newLocation,newWP); // Добавляем новую вершину
          return true; // Возвращаем true
        }
        // Иначе возвращаем false
        return false;
      }
    }
    // В наборе нет такого значения, просто добавляем его
    openWaypoint.put(newLocation,newWP);
    return true;
  }


  /**
   * Returns the current number of open waypoints.
   **/
  public int numOpenWaypoints() {
    return openWaypoint.size(); // Количество точек
  }


  /**
   * This method moves the waypoint at the specified location from the open list to the closed
   * list.
   **/
  public void closeWaypoint(Location loc) {
    closeWaypoint.put(loc, openWaypoint.remove(loc)); //Добавляем в closeWaypoint вершину из openWaypoint по loc
  }

  /**
   * Returns true if the collection of closed waypoints contains a waypoint for the specified
   * location.
   **/
  public boolean isLocationClosed(Location loc) {
    return  (closeWaypoint.containsKey(loc)); // Провереям есть ли loc в closeWaypoint
  }
}

