package XXLChess;

import processing.core.PImage;

import java.util.List;

/**
 * The RookChess class represents a rook chess piece in the game.
 * It extends the Chess class and inherits its properties and methods.
 * The rook can move and eat horizontally and vertically.
 */
public class RookChess extends Chess {

  /**
   * Constructs a RookChess object with the specified x and y coordinates, color, and image.
   *
   * @param x     The x-coordinate of the rook.
   * @param y     The y-coordinate of the rook.
   * @param color The color of the rook.
   * @param image The image representing the rook.
   */
  public RookChess(int x, int y, int color, PImage image) {
    super(x, y, color, image);
    direction = new int[][]{{1, 0}, {0, 1}, {0, -1}, {-1, 0}};
  }

  /**
   * Returns a list of possible locations where the rook can move to.
   * The rook can move horizontally and vertically.
   *
   * @return A list of Location objects representing the possible move locations.
   */
  @Override
  public List<Location> enbleMoveList() {
    return enbleMoveListByDir();
  }

  /**
   * Returns a list of possible locations where the rook can eat other chess pieces.
   * The rook can eat horizontally and vertically.
   *
   * @return A list of Location objects representing the possible eat locations.
   */
  @Override
  public List<Location> enbleEatList() {
    return enbleEatListByDir();
  }
}
