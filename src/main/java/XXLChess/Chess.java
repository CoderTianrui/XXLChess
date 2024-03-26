package XXLChess;

import processing.core.PImage;

import java.util.ArrayList;
import java.util.List;

/**
 * The Chess class represents a chess piece in the game.
 */
public abstract class Chess {
  public Location location;
  public int color;
  public PImage image;

  int[][] destination;
  int[][] direction;

  public Location targetLocation;
  public boolean isMoving;

  public boolean firstMove;
  public boolean lastMove;

  /**
   * Constructs a Chess object with the specified coordinates, color, and image.
   *
   * @param x     the x-coordinate of the chess piece
   * @param y     the y-coordinate of the chess piece
   * @param color the color of the chess piece
   * @param image the image of the chess piece
   */
  public Chess(int x, int y, int color, PImage image) {
    this.location = App.getLocation(x, y);
    this.color = color;
    this.image = image;
    this.firstMove = true;
  }

  /**
   * Returns a list of locations that the chess piece can move to.
   *
   * @return a list of locations that the chess piece can move to
   */
  public abstract List<Location> enbleMoveList();

  /**
   * Returns a list of locations that the chess piece can eat.
   *
   * @return a list of locations that the chess piece can eat
   */
  public abstract List<Location> enbleEatList();

  /**
   * Returns a list of locations that the chess piece can move to based on the destination array.
   *
   * @return a list of locations that the chess piece can move to
   */
  public List<Location> enbleMoveListByDes() {
    List<Location> res = new ArrayList<>();
    int x = location.x;
    int y = location.y;
    for (int i = 0; i < destination.length; i++) {
      int destinationX = x + destination[i][0];
      int destinationY = y + destination[i][1];
      if (App.isLegal(destinationX, destinationY) && App.getChess(destinationX, destinationY) == null) {
        res.add(App.getLocation(destinationX, destinationY));
      }
    }
    return res;
  }

  /**
   * Returns a list of locations that the chess piece can move to based on the direction array.
   *
   * @return a list of locations that the chess piece can move to
   */
  public List<Location> enbleMoveListByDir() {
    List<Location> res = new ArrayList<>();
    int x = location.x;
    int y = location.y;
    for (int i = 0; i < direction.length; i++) {
      int destinationX = x + direction[i][0];
      int destinationY = y + direction[i][1];
      while (App.isLegal(destinationX, destinationY) && App.getChess(destinationX, destinationY) == null) {
        res.add(App.getLocation(destinationX, destinationY));
        destinationX += direction[i][0];
        destinationY += direction[i][1];
      }
    }
    return res;
  }

  /**
   * Returns a list of locations that the chess piece can eat based on the destination array.
   *
   * @return a list of locations that the chess piece can eat
   */
  public List<Location> enbleEatListByDes() {
    List<Location> res = new ArrayList<>();
    int x = location.x;
    int y = location.y;
    for (int i = 0; i < destination.length; i++) {
      int destinationX = x + destination[i][0];
      int destinationY = y + destination[i][1];
      if (App.isLegal(destinationX, destinationY)) {
        Chess chess = App.getChess(destinationX, destinationY);
        if (chess != null && chess.color != color) {
          res.add(App.getLocation(destinationX, destinationY));
        }
      }
    }
    return res;
  }

  /**
   * Returns a list of locations that the chess piece can eat based on the direction array.
   *
   * @return a list of locations that the chess piece can eat
   */
  public List<Location> enbleEatListByDir() {
    List<Location> res = new ArrayList<>();
    int x = location.x;
    int y = location.y;
    for (int i = 0; i < direction.length; i++) {
      int destinationX = x + direction[i][0];
      int destinationY = y + direction[i][1];
      while (App.isLegal(destinationX, destinationY)) {
        Chess chess = App.getChess(destinationX, destinationY);
        if (chess != null) {
          if (chess.color != color) {
            res.add(App.getLocation(destinationX, destinationY));
          }
          break;
        }
        destinationX += direction[i][0];
        destinationY += direction[i][1];
      }
    }
    return res;
  }

  /**
   * Checks if the chess piece is in a check position.
   *
   * @return {@code true} if the chess piece is in a check position, {@code false} otherwise
   */
  public boolean inCheck() {
    for (int i = 0; i < App.BOARD_WIDTH; i++) {
      for (int j = 0; j < App.BOARD_WIDTH; j++) {
        Chess chess = App.getChess(i, j);
        if (chess != null && chess.color != color && chess.enbleEatList().contains(this.location)) {
          return true;
        }
      }
    }
    return false;
  }

  /**
   * Moves the chess piece.
   */
  public void move() {
    location.xPos += App.xSpeed;
    location.yPos += App.ySpeed;
  }

  /**
   * Checks if the chess piece has reached the target location.
   *
   * @return {@code true} if the chess piece has reached the target location, {@code false} otherwise
   */
  public boolean reachTargetLocationtion() {
    return Math.abs(targetLocation.xPos - location.xPos) <= App.CELLSIZE / 4 && Math.abs(targetLocation.yPos - location.yPos) <= App.CELLSIZE / 4;
  }

  /**
   * Stops the chess piece from moving.
   */
  public void stopMoving() {
    isMoving = false;
    location.reset();
    location = targetLocation;
  }

  /**
   * Moves the chess piece to the target location.
   *
   * @param location the target location to move to
   */
  public void moveToTargetLocation(Location location) {
    targetLocation = location;
    isMoving = true;
    lastMove = firstMove;
    firstMove = false;
  }

  /**
   * Moves the chess piece back to its original location.
   */
  public void moveBack() {
    targetLocation = null;
    isMoving = false;
    firstMove = lastMove;
  }
}
