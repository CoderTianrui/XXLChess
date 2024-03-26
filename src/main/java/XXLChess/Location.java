package XXLChess;

import java.util.Objects;

/**
 * The Location class represents a location on a chessboard.
 * It stores the x and y coordinates of the location and the corresponding x and y positions.
 */
public class Location {
  public int x;
  public int y;
  public float xPos;
  public float yPos;

  /**
   * Constructs a Location object with the specified x and y coordinates.
   * The x and y positions are calculated based on the given coordinates and the cell size defined in the App class.
   *
   * @param x The x-coordinate of the location.
   * @param y The y-coordinate of the location.
   */
  public Location(int x, int y) {
    this.x = x;
    this.y = y;
    this.xPos = x * App.CELLSIZE;
    this.yPos = y * App.CELLSIZE;
  }

  /**
   * Returns a string representation of the Location object.
   *
   * @return A string containing the x and y coordinates, as well as the x and y positions of the location.
   */
  @Override
  public String toString() {
    return "Location{" +
            "x=" + x +
            ", y=" + y +
            ", xPos=" + xPos +
            ", yPos=" + yPos +
            '}';
  }

  /**
   * Returns the hash code value for the Location object.
   *
   * @return The hash code value based on the x and y coordinates of the location.
   */
  @Override
  public int hashCode() {
    return Objects.hash(x, y);
  }

  /**
   * Checks if this Location object is equal to the specified object.
   * Two Location objects are considered equal if they have the same x and y coordinates.
   *
   * @param o The object to compare this Location against.
   * @return true if the objects are equal, false otherwise.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Location location = (Location) o;
    return x == location.x && y == location.y;
  }

  /**
   * Resets the x and y positions of the Location object based on the current x and y coordinates and the cell size defined in the App class.
   */
  public void reset() {
    xPos = x * App.CELLSIZE;
    yPos = y * App.CELLSIZE;
  }
}
