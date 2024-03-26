package XXLChess;

import processing.core.PImage;

import java.util.ArrayList;
import java.util.List;

/**
 * The PawnChess class represents a pawn chess piece in the game.
 * It extends the Chess class and inherits its properties and methods.
 */
public class PawnChess extends Chess {

  /**
   * Constructs a PawnChess object with the specified x and y coordinates, color, and image.
   *
   * @param x     The x-coordinate of the pawn.
   * @param y     The y-coordinate of the pawn.
   * @param color The color of the pawn.
   * @param image The image representing the pawn.
   */
  public PawnChess(int x, int y, int color, PImage image) {
    super(x, y, color, image);
  }

  /**
   * Returns a list of possible locations where the pawn can move to.
   *
   * @return A list of Location objects representing the possible move locations.
   */
  @Override
  public List<Location> enbleMoveList() {
    List<Location> res = new ArrayList<>();
    int x = location.x;
    int y = location.y;
    if (color == App.COLOR_PLAYER_BLACK && y + 1 < App.BOARD_WIDTH && App.getChess(x, y + 1) == null) {
      res.add(App.getLocation(x, y + 1));
      if (firstMove && y + 2 < App.BOARD_WIDTH && App.getChess(x, y + 2) == null) {
        res.add(App.getLocation(x, y + 2));
      }
    } else if (color == App.COLOR_PLAYER_WHITE && y - 1 >= 0 && App.getChess(x, y - 1) == null) {
      res.add(App.getLocation(x, y - 1));
      if (firstMove && y - 2 >= 0 && App.getChess(x, y - 2) == null) {
        res.add(App.getLocation(x, y - 2));
      }
    }
    return res;
  }

  /**
   * Returns a list of possible locations where the pawn can eat other chess pieces.
   *
   * @return A list of Location objects representing the possible eat locations.
   */
  @Override
  public List<Location> enbleEatList() {
    List<Location> res = new ArrayList<>();
    int x = location.x;
    int y = location.y;
    Chess chess;
    if (color == App.COLOR_PLAYER_BLACK && y + 1 < App.BOARD_WIDTH) {
      if (x + 1 < App.BOARD_WIDTH) {
        chess = App.getChess(x + 1, y + 1);
        if (chess != null && chess.color != color) {
          res.add(App.getLocation(x + 1, y + 1));
        }
      }
      if (x - 1 >= 0) {
        chess = App.getChess(x - 1, y + 1);
        if (chess != null && chess.color != color) {
          res.add(App.getLocation(x - 1, y + 1));
        }
      }
    } else if (color == App.COLOR_PLAYER_WHITE && y - 1 >= 0) {
      if (x + 1 < App.BOARD_WIDTH) {
        chess = App.getChess(x + 1, y - 1);
        if (chess != null && chess.color != color) {
          res.add(App.getLocation(x + 1, y - 1));
        }
      }
      if (x - 1 >= 0) {
        chess = App.getChess(x - 1, y - 1);
        if (chess != null && chess.color != color) {
          res.add(App.getLocation(x - 1, y - 1));
        }
      }
    }
    return res;
  }

  /**
   * Moves the pawn to the target location.
   * If the pawn reaches the opposite end of the board, it is promoted to a queen.
   *
   * @param location The target location to move the pawn to.
   */
  @Override
  public void moveToTargetLocation(Location location) {
    super.moveToTargetLocation(location);
    if (color == App.COLOR_PLAYER_BLACK && location.y >= App.BOARD_WIDTH / 2) {
      App.toBeQueen(this);
    } else if (color == App.COLOR_PLAYER_WHITE && location.y < App.BOARD_WIDTH / 2) {
      App.toBeQueen(this);
    }
  }
}
