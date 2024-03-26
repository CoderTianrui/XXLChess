package XXLChess;

import processing.core.PImage;

import java.util.List;

/**
 * The ArchbishopChess class represents an archbishop chess piece in the game.
 * It extends the Chess class and inherits its properties and methods.
 * The archbishop combines the movement of a knight and a bishop.
 */
public class ArchbishopChess extends Chess {

  /**
   * Constructs an ArchbishopChess object with the specified x and y coordinates, color, and image.
   *
   * @param x     The x-coordinate of the archbishop.
   * @param y     The y-coordinate of the archbishop.
   * @param color The color of the archbishop.
   * @param image The image representing the archbishop.
   */
  public ArchbishopChess(int x, int y, int color, PImage image) {
    super(x, y, color, image);
    destination = new int[][]{
            {2, 1}, {2, -1}, {-2, 1}, {-2, -1},
            {1, 2}, {1, -2}, {-1, 2}, {-1, -2}
    };
    direction = new int[][]{
            {1, 1}, {1, -1}, {-1, 1}, {-1, -1},
    };
  }

  /**
   * Returns a list of possible locations where the archbishop can move to.
   * The archbishop combines the movement of a knight and a bishop.
   *
   * @return A list of Location objects representing the possible move locations.
   */
  @Override
  public List<Location> enbleMoveList() {
    // Knight
    List<Location> res = enbleMoveListByDes();
    // Bishop
    res.addAll(enbleMoveListByDir());
    return res;
  }

  /**
   * Returns a list of possible locations where the archbishop can eat other chess pieces.
   * The archbishop combines the movement of a knight and a bishop.
   *
   * @return A list of Location objects representing the possible eat locations.
   */
  @Override
  public List<Location> enbleEatList() {
    // Knight
    List<Location> res = enbleEatListByDes();
    // Bishop
    res.addAll(enbleEatListByDir());
    return res;
  }
}
