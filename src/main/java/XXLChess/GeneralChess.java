package XXLChess;

import processing.core.PImage;

import java.util.List;

/**
 * The GeneralChess class represents a general chess piece in the game.
 * It extends the Chess class and inherits its properties and methods.
 * The general can move and eat in any direction, including in an L-shaped pattern.
 */
public class GeneralChess extends Chess {
  public GeneralChess(int x, int y, int color, PImage image) {
    super(x, y, color, image);
    destination = new int[][]{
            {2, 1}, {2, -1}, {-2, 1}, {-2, -1},
            {1, 2}, {1, -2}, {-1, 2}, {-1, -2},
            {1, 1}, {1, 0}, {1, -1}, {0, 1}, {0, -1}, {-1, 1}, {-1, 0}, {-1, -1}
    };
  }

  /**
   * Returns a list of possible locations where the general can move to.
   * The general can move in any direction, including in an L-shaped pattern.
   *
   * @return A list of Location objects representing the possible move locations.
   */
  @Override
  public List<Location> enbleMoveList() {
    return enbleMoveListByDes();
  }

  /**
   * Returns a list of possible locations where the general can eat other chess pieces.
   * The general can eat in any direction, including in an L-shaped pattern.
   *
   * @return A list of Location objects representing the possible eat locations.
   */
  @Override
  public List<Location> enbleEatList() {
    return enbleEatListByDes();
  }
}
