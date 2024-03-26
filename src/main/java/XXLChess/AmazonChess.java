package XXLChess;

import processing.core.PImage;

import java.util.List;

/**
 * The AmazonChess class represents an amazon chess piece in the game.
 * It extends the Chess class and inherits its properties and methods.
 * The amazon combines the movement of a knight, a bishop, and a rook.
 */
public class AmazonChess extends Chess {

  /**
   * Constructs an AmazonChess object with the specified x and y coordinates, color, and image.
   *
   * @param x     The x-coordinate of the amazon.
   * @param y     The y-coordinate of the amazon.
   * @param color The color of the amazon.
   * @param image The image representing the amazon.
   */
  public AmazonChess(int x, int y, int color, PImage image) {
    super(x, y, color, image);
    destination = new int[][]{
            {2, 1}, {2, -1},
            {-2, 1}, {-2, -1},
            {1, 2}, {1, -2},
            {-1, 2}, {-1, -2}
    };

    direction = new int[][]{
            {1, 1}, {1, -1}, {-1, 1}, {-1, -1},
            {1, 0}, {0, 1}, {0, -1}, {-1, 0}
    };
  }

  /**
   * Returns a list of possible locations where the amazon can move to.
   * The amazon combines the movement of a knight, a bishop, and a rook.
   *
   * @return A list of Location objects representing the possible move locations.
   */
  @Override
  public List<Location> enbleMoveList() {
    // Knight
    List<Location> res = enbleMoveListByDes();
    // Bishop + Rook
    res.addAll(enbleMoveListByDir());
    return res;
  }

  /**
   * Returns a list of possible locations where the amazon can eat other chess pieces.
   * The amazon combines the movement of a knight, a bishop, and a rook.
   *
   * @return A list of Location objects representing the possible eat locations.
   */
  @Override
  public List<Location> enbleEatList() {
    // Knight
    List<Location> res = enbleEatListByDes();
    // Bishop + Rook
    res.addAll(enbleEatListByDir());
    return res;
  }
}
