package XXLChess;

import processing.core.PImage;

import java.util.List;

/**
 * The KnightChess class represents a knight chess piece in the game.
 * It extends the Chess class and inherits its properties and methods.
 * The knight can move and eat in an L-shaped pattern.
 */
public class KnightChess extends Chess {

  /**
   * Constructs a KnightChess object with the specified x and y coordinates, color, and image.
   *
   * @param x     The x-coordinate of the knight.
   * @param y     The y-coordinate of the knight.
   * @param color The color of the knight.
   * @param image The image representing the knight.
   */
  public KnightChess(int x, int y, int color, PImage image) {
    super(x, y, color, image);
    destination = new int[][]{
            {2, 1}, {2, -1},
            {-2, 1}, {-2, -1},
            {1, 2}, {1, -2},
            {-1, 2}, {-1, -2}
    };
  }

  /**
   * Returns a list of possible locations where the knight can move to.
   * The knight moves in an L-shaped pattern.
   *
   * @return A list of Location objects representing the possible move locations.
   */
  @Override
  public List<Location> enbleMoveList() {
    return enbleMoveListByDes();
  }

  /**
   * Returns a list of possible locations where the knight can eat other chess pieces.
   * The knight eats in an L-shaped pattern.
   *
   * @return A list of Location objects representing the possible eat locations.
   */
  @Override
  public List<Location> enbleEatList() {
    return enbleEatListByDes();
  }
}
