package XXLChess;

import processing.core.PImage;

import java.util.List;

/**
 * The QueenChess class represents a queen chess piece in the game.
 * It extends the Chess class and inherits its properties and methods.
 * The queen can move and eat in any direction: horizontally, vertically, and diagonally.
 */
public class QueenChess extends Chess {

  public boolean toBeQueenAndFirstStep;

  /**
   * Constructs a QueenChess object with the specified x and y coordinates, color, and image.
   *
   * @param x     The x-coordinate of the queen.
   * @param y     The y-coordinate of the queen.
   * @param color The color of the queen.
   * @param image The image representing the queen.
   */
  public QueenChess(int x, int y, int color, PImage image) {
    super(x, y, color, image);
    direction = new int[][]{
            {1, 1}, {1, -1}, {-1, 1}, {-1, -1},
            {1, 0}, {0, 1}, {0, -1}, {-1, 0}
    };
    toBeQueenAndFirstStep = false;
  }

  /**
   * Returns a list of possible locations where the queen can move to.
   * The queen can move in any direction: horizontally, vertically, and diagonally.
   *
   * @return A list of Location objects representing the possible move locations.
   */
  @Override
  public List<Location> enbleMoveList() {
    // Bishop + Rook
    return enbleMoveListByDir();
  }

  /**
   * Returns a list of possible locations where the queen can eat other chess pieces.
   * The queen can eat in any direction: horizontally, vertically, and diagonally.
   *
   * @return A list of Location objects representing the possible eat locations.
   */
  @Override
  public List<Location> enbleEatList() {
    // Bishop + Rook
    return enbleEatListByDir();
  }
}
