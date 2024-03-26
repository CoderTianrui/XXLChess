package XXLChess;

import processing.core.PImage;

import java.util.List;

// Knight + Rook
public class ChancellorChess extends Chess {


  public ChancellorChess(int x, int y, int color, PImage image) {
    super(x, y, color, image);
    destination = new int[][] {
            {2, 1}, {2, -1},
            {-2, 1}, {-2, -1},
            {1, 2}, {1, -2},
            {-1, 2}, {-1, -2}
    };

    direction =
            new int[][] {
                    {1, 0}, {0, 1}, {0, -1}, {-1, 0}
            };
  }

  @Override
  public List<Location> enbleMoveList() {
    // Knight
    List<Location> res = enbleMoveListByDes();
    // Rook
    res.addAll(enbleMoveListByDir());
    return res;
  }

  @Override
  public List<Location> enbleEatList() {
    // Knight
    List<Location> res = enbleEatListByDes();
    // Rook
    res.addAll(enbleEatListByDir());
    return res;
  }
}
