package XXLChess;

import processing.core.PImage;

import java.util.List;

/**
 * The CamelChess class represents a camel chess piece in the game.
 * It extends the Chess class and inherits its properties and methods.
 * The camel can move in an L-shaped pattern, taking 3 steps in one direction and 1 step in the perpendicular direction.
 */
public class CamelChess extends Chess {

  /**
   * Constructs a CamelChess object with the specified x and y coordinates, color, and image.
   *
   * @param x     The x-coordinate of the camel.
   * @param y     The y-coordinate of the camel.
   * @param color The color of the camel.
   * @param image The image representing the camel.
   */
  public CamelChess(int x, int y, int color, PImage image) {
    super(x, y, color, image);
    destination = new int[][]{
            {3, 1}, {3, -1},
            {-3, 1}, {-3, -1},
            {1, 3}, {1, -3},
            {-1, 3}, {-1, -3}
    };
  }

  /**
   * Returns a list of possible locations where the camel can move to.
   * The camel can move in an L-shaped pattern, taking 3 steps in one direction and 1 step in the perpendicular direction.
   *
   * @return A list of Location objects representing the possible move locations.
   */
  @Override
  public List<Location> enbleMoveList() {
    return enbleMoveListByDes();
  }

  /**
   * Returns a list of possible locations where the camel can eat other chess pieces.
   * The camel can move in an L-shaped pattern, taking 3 steps in one direction and 1 step in the perpendicular direction.
   *
   * @return A list of Location objects representing the possible eat locations.
   */
  @Override
  public List<Location> enbleEatList() {
    return enbleEatListByDes();
  }
}
