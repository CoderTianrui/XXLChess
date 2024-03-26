package XXLChess;

import processing.core.PImage;

import java.util.List;

/**
 * The BishopChess class represents a bishop chess piece in the game.
 * It extends the Chess class and inherits its properties and methods.
 * The bishop can move and eat diagonally.
 */
public class BishopChess extends Chess {

  /**
   * Constructs a BishopChess object with the specified x and y coordinates, color, and image.
   *
   * @param x     The x-coordinate of the bishop.
   * @param y     The y-coordinate of the bishop.
   * @param color The color of the bishop.
   * @param image The image representing the bishop.
   */
  public BishopChess(int x, int y, int color, PImage image) {
    super(x, y, color, image);
    direction = new int[][]{
            {1, 1}, {1, -1}, {-1, 1}, {-1, -1}
    };
  }

  /**
   * Returns a list of possible locations where the bishop can move to.
   * The bishop can move diagonally.
   *
   * @return A list of Location objects representing the possible move locations.
   */
  @Override
  public List<Location> enbleMoveList() {
    return enbleMoveListByDir();
  }

  /**
   * Returns a list of possible locations where the bishop can eat other chess pieces.
   * The bishop can eat diagonally.
   *
   * @return A list of Location objects representing the possible eat locations.
   */
  @Override
  public List<Location> enbleEatList() {
    return enbleEatListByDir();
  }
}
