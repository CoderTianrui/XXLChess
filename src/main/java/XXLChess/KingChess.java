package XXLChess;

import processing.core.PImage;

import java.util.List;

/**
 * The KingChess class represents a king chess piece in the game.
 * It extends the Chess class and inherits its properties and methods.
 * The king can move and eat in any direction, but only one step at a time.
 * The king can also perform castling if certain conditions are met.
 */
public class KingChess extends Chess {

  /**
   * Constructs a KingChess object with the specified x and y coordinates, color, and image.
   *
   * @param x     The x-coordinate of the king.
   * @param y     The y-coordinate of the king.
   * @param color The color of the king.
   * @param image The image representing the king.
   */
  public KingChess(int x, int y, int color, PImage image) {
    super(x, y, color, image);
    destination = new int[][]{{1, 1}, {1, 0}, {1, -1}, {0, 1}, {0, -1}, {-1, 1}, {-1, 0}, {-1, -1}};
  }

  /**
   * Returns a list of possible locations where the king can move to.
   * The king can move in any direction, but only one step at a time.
   * The king can also perform castling if certain conditions are met.
   *
   * @return A list of Location objects representing the possible move locations.
   */
  @Override
  public List<Location> enbleMoveList() {
    List<Location> res = enbleMoveListByDes();
    int x = location.x;
    int y = location.y;
    if (firstMove) { // castling
      for (int i = 0; i < App.BOARD_WIDTH; i++) {
        Chess chess = App.getChess(i, y);
        if (chess != null && chess.color == color && chess instanceof RookChess && chess.firstMove) {
          if (chess.location.x < x
                  && App.getChess(x - 1, y) == null
                  && App.getChess(x - 2, y) == null) { // left
            res.add(App.getLocation(x - 2, y));
          } else if (chess.location.x > x
                  && App.getChess(x + 1, y) == null
                  && App.getChess(x + 2, y) == null) { // right
            res.add(App.getLocation(x + 2, y));
          }
        }
      }
    }
    return res;
  }

  /**
   * Returns a list of possible locations where the king can eat other chess pieces.
   * The king can eat in any direction, but only one step at a time.
   * The king can also perform castling if certain conditions are met.
   *
   * @return A list of Location objects representing the possible eat locations.
   */
  @Override
  public List<Location> enbleEatList() {
    List<Location> res = enbleEatListByDes();
    int x = location.x;
    int y = location.y;
    if (firstMove) { // castling
      for (int i = 0; i < App.BOARD_WIDTH; i++) {
        Chess chess = App.getChess(i, y);
        if (chess != null && chess.color == color && chess instanceof RookChess && chess.firstMove) {
          if (chess.location.x < x
                  && App.getChess(x - 1, y) == null
                  && App.getChess(x - 2, y) != null
                  && App.getChess(x - 2, y).color != color) { // left
            res.add(App.getLocation(x - 2, y));
          } else if (chess.location.x > x
                  && App.getChess(x + 1, y) == null
                  && App.getChess(x + 2, y) != null
                  && App.getChess(x + 2, y).color != color) { // right
            res.add(App.getLocation(x + 2, y));
          }
        }
      }
    }
    return res;
  }
}
