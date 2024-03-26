package XXLChess;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import processing.core.PImage;

import java.util.List;

public class SampleTest {


    @BeforeAll
    public static void chessMapTest() {
        App app = new App();
        App.layout = "level1.txt";
        App.AmazonImage = new PImage[2];
        App.ArchbishopImage = new PImage[2];
        App.BishopImage = new PImage[2];
        App.CamelImage = new PImage[2];
        App.ChancellorImage = new PImage[2];
        App.GeneralImage = new PImage[2];
        App.KingImage = new PImage[2];
        App.KnightImage = new PImage[2];
        App.PawnImage = new PImage[2];
        App.QueenImage = new PImage[2];
        App.RookImage = new PImage[2];
        App.xSpeed = 6.0f;
        App.ySpeed = 6.0f;
        app.loadLevel();
        assert App.chessMap[0][0] instanceof RookChess && App.chessMap[0][0].location.equals(new Location(0, 0));
        assert App.chessMap[1][0] instanceof KnightChess && App.chessMap[1][0].location.equals(new Location(1, 0));
        assert App.chessMap[2][0] instanceof BishopChess && App.chessMap[2][0].location.equals(new Location(2, 0));
        assert App.chessMap[3][0] instanceof ArchbishopChess && App.chessMap[3][0].location.equals(new Location(3, 0));
        assert App.chessMap[4][0] instanceof CamelChess && App.chessMap[4][0].location.equals(new Location(4, 0));
        assert App.chessMap[5][0] instanceof GeneralChess && App.chessMap[5][0].location.equals(new Location(5, 0));
        assert App.chessMap[6][0] instanceof AmazonChess && App.chessMap[6][0].location.equals(new Location(6, 0));
        assert App.chessMap[7][0] instanceof KingChess && App.chessMap[7][0].location.equals(new Location(7, 0));
        assert App.chessMap[8][0] instanceof GeneralChess && App.chessMap[8][0].location.equals(new Location(8, 0));
        assert App.chessMap[9][0] instanceof CamelChess && App.chessMap[9][0].location.equals(new Location(9, 0));
        assert App.chessMap[10][0] instanceof ChancellorChess && App.chessMap[10][0].location.equals(new Location(10, 0));
        assert App.chessMap[11][0] instanceof BishopChess && App.chessMap[11][0].location.equals(new Location(11, 0));
        assert App.chessMap[12][0] instanceof KnightChess && App.chessMap[12][0].location.equals(new Location(12, 0));
        assert App.chessMap[13][0] instanceof RookChess && App.chessMap[13][0].location.equals(new Location(13, 0));

        assert App.chessMap[0][13] instanceof RookChess && App.chessMap[0][13].location.equals(new Location(0, 13));
        assert App.chessMap[1][13] instanceof KnightChess && App.chessMap[1][13].location.equals(new Location(1, 13));
        assert App.chessMap[2][13] instanceof BishopChess && App.chessMap[2][13].location.equals(new Location(2, 13));
        assert App.chessMap[3][13] instanceof ArchbishopChess && App.chessMap[3][13].location.equals(new Location(3, 13));
        assert App.chessMap[4][13] instanceof CamelChess && App.chessMap[4][13].location.equals(new Location(4, 13));
        assert App.chessMap[5][13] instanceof GeneralChess && App.chessMap[5][13].location.equals(new Location(5, 13));
        assert App.chessMap[6][13] instanceof AmazonChess && App.chessMap[6][13].location.equals(new Location(6, 13));
        assert App.chessMap[7][13] instanceof KingChess && App.chessMap[7][13].location.equals(new Location(7, 13));
        assert App.chessMap[8][13] instanceof GeneralChess && App.chessMap[8][13].location.equals(new Location(8, 13));
        assert App.chessMap[9][13] instanceof CamelChess && App.chessMap[9][13].location.equals(new Location(9, 13));
        assert App.chessMap[10][13] instanceof ChancellorChess && App.chessMap[10][13].location.equals(new Location(10, 13));
        assert App.chessMap[11][13] instanceof BishopChess && App.chessMap[11][13].location.equals(new Location(11, 13));
        assert App.chessMap[12][13] instanceof KnightChess && App.chessMap[12][13].location.equals(new Location(12, 13));
        assert App.chessMap[13][13] instanceof RookChess && App.chessMap[13][13].location.equals(new Location(13, 13));

        for (int i = 0; i < App.BOARD_WIDTH; i++) {
            for (int j = 0; j < App.BOARD_WIDTH; j++) {
                App.setLocation(i, j, new Location(i, j));
                assert App.locationMap[i][j].equals(new Location(i, j));
            }
        }
    }

    @Test
    public void simpleTest() {

    }

    @Test
    public void isLegalTest() {
        boolean legal = App.isLegal(0, 0);
        assert legal;
        legal = App.isLegal(0, 14);
        assert !legal;
        legal = App.isLegal(-1, 13);
        assert !legal;
        legal = App.isLegal(1, 13);
        assert legal;
    }

    @Test
    public void RookChessTest() {
        Chess chess = App.getChess(0, 0);
        assert chess.color == 0;
        assert chess.location.equals(new Location(0, 0));
    }

    @Test
    public void RookChessSpeedTest() {
        Chess chess = App.getChess(0, 0);

        assert chess.location.xPos == 0.0f;
        assert chess.location.yPos == 0.0f;

        chess.move();

        assert chess.location.xPos == 6.0f;
        assert chess.location.yPos == 6.0f;

        chess.move();

        assert chess.location.xPos == 12.0f;
        assert chess.location.yPos == 12.0f;
    }

    @Test
    public void RookChessMoveTest() {
        Chess chess = App.getChess(0, 0);
        List<Location> locations = chess.enbleMoveList();
        int[][] arr = new int[][]{
        };
        for (int i = 0; i < arr.length; i++) {
            assert locations.contains(App.getLocation(arr[i][0], arr[i][1]));
        }
    }

    @Test
    public void KnightChessTest() {
        Chess chess = App.getChess(1, 0);
        assert chess.color == 0;
        assert chess.location.equals(new Location(1, 0));
    }

    @Test
    public void KnightChessSpeedTest() {
        Chess chess = App.getChess(1, 0);

        assert chess.location.xPos == 0.0f + App.CELLSIZE;
        assert chess.location.yPos == 0.0f;

        chess.move();

        assert chess.location.xPos == 6.0f + App.CELLSIZE;
        assert chess.location.yPos == 6.0f;

        chess.move();

        assert chess.location.xPos == 12.0f + App.CELLSIZE;
        assert chess.location.yPos == 12.0f;
    }

    @Test
    public void KnightChessMoveTest() {
        Chess chess = App.getChess(1, 0);
        List<Location> locations = chess.enbleMoveList();
        int[][] arr = new int[][]{
                {2, 2}, {0, 2}
        };
        for (int i = 0; i < arr.length; i++) {
            assert locations.contains(App.getLocation(arr[i][0], arr[i][1]));
        }
    }

    @Test
    public void BishopChessTest() {
        Chess chess = App.getChess(2, 0);
        assert chess.color == 0;
        assert chess.location.equals(new Location(2, 0));
    }

    @Test
    public void BishopChessSpeedTest() {
        Chess chess = App.getChess(2, 0);

        assert chess.location.xPos == 0.0f + App.CELLSIZE * 2;
        assert chess.location.yPos == 0.0f;

        chess.move();

        assert chess.location.xPos == 6.0f + App.CELLSIZE * 2;
        assert chess.location.yPos == 6.0f;

        chess.move();

        assert chess.location.xPos == 12.0f + App.CELLSIZE * 2;
        assert chess.location.yPos == 12.0f;
    }

    @Test
    public void BishopChessMoveTest() {
        Chess chess = App.getChess(2, 0);
        List<Location> locations = chess.enbleMoveList();
        int[][] arr = new int[][]{
        };
        for (int i = 0; i < arr.length; i++) {
            assert locations.contains(App.getLocation(arr[i][0], arr[i][1]));
        }
    }

    @Test
    public void ArchbishopChessTest() {
        Chess chess = App.getChess(3, 0);
        assert chess.color == 0;
        assert chess.location.equals(new Location(3, 0));
    }

    @Test
    public void ArchbishopChessSpeedTest() {
        Chess chess = App.getChess(3, 0);

        assert chess.location.xPos == 0.0f + App.CELLSIZE * 3;
        assert chess.location.yPos == 0.0f;

        chess.move();

        assert chess.location.xPos == 6.0f + App.CELLSIZE * 3;
        assert chess.location.yPos == 6.0f;

        chess.move();

        assert chess.location.xPos == 12.0f + App.CELLSIZE * 3;
        assert chess.location.yPos == 12.0f;
    }

    @Test
    public void ArchbishopChessMoveTest() {
        Chess chess = App.getChess(3, 0);
        List<Location> locations = chess.enbleMoveList();
        int[][] arr = new int[][]{
                {4, 2}, {2, 2}
        };
        for (int i = 0; i < arr.length; i++) {
            assert locations.contains(App.getLocation(arr[i][0], arr[i][1]));
        }
    }

    @Test
    public void CamelChessTest() {
        Chess chess = App.getChess(4, 0);
        assert chess.color == 0;
        assert chess.location.equals(new Location(4, 0));
    }

    @Test
    public void CamelChessSpeedTest() {
        Chess chess = App.getChess(4, 0);

        assert chess.location.xPos == 0.0f + App.CELLSIZE * 4;
        assert chess.location.yPos == 0.0f;

        chess.move();

        assert chess.location.xPos == 6.0f + App.CELLSIZE * 4;
        assert chess.location.yPos == 6.0f;

        chess.move();

        assert chess.location.xPos == 12.0f + App.CELLSIZE * 4;
        assert chess.location.yPos == 12.0f;
    }

    @Test
    public void CamelChessMoveTest() {
        Chess chess = App.getChess(4, 0);
        List<Location> locations = chess.enbleMoveList();
        int[][] arr = new int[][]{
                {5, 3}, {3, 3}
        };
        for (int i = 0; i < arr.length; i++) {
            assert locations.contains(App.getLocation(arr[i][0], arr[i][1]));
        }
    }

    @Test
    public void GeneralChessTest() {
        Chess chess = App.getChess(5, 0);
        assert chess.color == 0;
        assert chess.location.equals(new Location(5, 0));
    }

    @Test
    public void GeneralChessSpeedTest() {
        Chess chess = App.getChess(5, 0);

        assert chess.location.xPos == 0.0f + App.CELLSIZE * 5;
        assert chess.location.yPos == 0.0f;

        chess.move();

        assert chess.location.xPos == 6.0f + App.CELLSIZE * 5;
        assert chess.location.yPos == 6.0f;

        chess.move();

        assert chess.location.xPos == 12.0f + App.CELLSIZE * 5;
        assert chess.location.yPos == 12.0f;
    }

    @Test
    public void GeneralChessMoveTest() {
        Chess chess = App.getChess(5, 0);
        List<Location> locations = chess.enbleMoveList();
        int[][] arr = new int[][]{
                {6, 2}, {4, 2}
        };
        for (int i = 0; i < arr.length; i++) {
            assert locations.contains(App.getLocation(arr[i][0], arr[i][1]));
        }
    }

    @Test
    public void AmazonChessTest() {
        Chess chess = App.getChess(6, 0);
        assert chess.color == 0;
        assert chess.location.equals(new Location(6, 0));
    }

    @Test
    public void AmazonChessSpeedTest() {
        Chess chess = App.getChess(6, 0);

        assert chess.location.xPos == 0.0f + App.CELLSIZE * 6;
        assert chess.location.yPos == 0.0f;

        chess.move();

        assert chess.location.xPos == 6.0f + App.CELLSIZE * 6;
        assert chess.location.yPos == 6.0f;

        chess.move();

        assert chess.location.xPos == 12.0f + App.CELLSIZE * 6;
        assert chess.location.yPos == 12.0f;
    }

    @Test
    public void AmazonChessMoveTest() {
        Chess chess = App.getChess(6, 0);
        List<Location> locations = chess.enbleMoveList();
        int[][] arr = new int[][]{
                {7, 2}, {5, 2}
        };
        for (int i = 0; i < arr.length; i++) {
            assert locations.contains(App.getLocation(arr[i][0], arr[i][1]));
        }
    }

    @Test
    public void KingChessTest() {
        Chess chess = App.getChess(7, 0);
        assert chess.color == 0;
        assert chess.location.equals(new Location(7, 0));
    }

    @Test
    public void KingChessSpeedTest() {
        Chess chess = App.getChess(7, 0);

        assert chess.location.xPos == 0.0f + App.CELLSIZE * 7;
        assert chess.location.yPos == 0.0f;

        chess.move();

        assert chess.location.xPos == 6.0f + App.CELLSIZE * 7;
        assert chess.location.yPos == 6.0f;

        chess.move();

        assert chess.location.xPos == 12.0f + App.CELLSIZE * 7;
        assert chess.location.yPos == 12.0f;
    }

    @Test
    public void KingChessMoveTest() {
        Chess chess = App.getChess(7, 0);
        List<Location> locations = chess.enbleMoveList();
        int[][] arr = new int[][]{
        };
        for (int i = 0; i < arr.length; i++) {
            assert locations.contains(App.getLocation(arr[i][0], arr[i][1]));
        }
    }

    @Test
    public void GeneralChess2Test() {
        Chess chess = App.getChess(8, 0);
        assert chess.color == 0;
        assert chess.location.equals(new Location(8, 0));
    }

    @Test
    public void GeneralChess2SpeedTest() {
        Chess chess = App.getChess(8, 0);

        assert chess.location.xPos == 0.0f + App.CELLSIZE * 8;
        assert chess.location.yPos == 0.0f;

        chess.move();

        assert chess.location.xPos == 6.0f + App.CELLSIZE * 8;
        assert chess.location.yPos == 6.0f;

        chess.move();

        assert chess.location.xPos == 12.0f + App.CELLSIZE * 8;
        assert chess.location.yPos == 12.0f;
    }

    @Test
    public void GeneralChess2MoveTest() {
        Chess chess = App.getChess(8, 0);
        List<Location> locations = chess.enbleMoveList();
        int[][] arr = new int[][]{
                {9, 2}, {7, 2}
        };
        for (int i = 0; i < arr.length; i++) {
            assert locations.contains(App.getLocation(arr[i][0], arr[i][1]));
        }
    }

    @Test
    public void CamelChess2Test() {
        Chess chess = App.getChess(9, 0);
        assert chess.color == 0;
        assert chess.location.equals(new Location(9, 0));
    }

    @Test
    public void CamelChess2SpeedTest() {
        Chess chess = App.getChess(9, 0);

        assert chess.location.xPos == 0.0f + App.CELLSIZE * 9;
        assert chess.location.yPos == 0.0f;

        chess.move();

        assert chess.location.xPos == 6.0f + App.CELLSIZE * 9;
        assert chess.location.yPos == 6.0f;

        chess.move();

        assert chess.location.xPos == 12.0f + App.CELLSIZE * 9;
        assert chess.location.yPos == 12.0f;
    }

    @Test
    public void CamelChess2MoveTest() {
        Chess chess = App.getChess(9, 0);
        List<Location> locations = chess.enbleMoveList();
        int[][] arr = new int[][]{
                {10, 3}, {8, 3}
        };
        for (int i = 0; i < arr.length; i++) {
            assert locations.contains(App.getLocation(arr[i][0], arr[i][1]));
        }
    }

    @Test
    public void ChancellorChessTest() {
        Chess chess = App.getChess(10, 0);
        assert chess.color == 0;
        assert chess.location.equals(new Location(10, 0));
    }

    @Test
    public void ChancellorChessSpeedTest() {
        Chess chess = App.getChess(10, 0);

        assert chess.location.xPos == 0.0f + App.CELLSIZE * 10;
        assert chess.location.yPos == 0.0f;

        chess.move();

        assert chess.location.xPos == 6.0f + App.CELLSIZE * 10;
        assert chess.location.yPos == 6.0f;

        chess.move();

        assert chess.location.xPos == 12.0f + App.CELLSIZE * 10;
        assert chess.location.yPos == 12.0f;
    }

    @Test
    public void ChancellorChessMoveTest() {
        Chess chess = App.getChess(10, 0);
        List<Location> locations = chess.enbleMoveList();
        int[][] arr = new int[][]{
                {11, 2}, {9, 2}
        };
        for (int i = 0; i < arr.length; i++) {
            assert locations.contains(App.getLocation(arr[i][0], arr[i][1]));
        }
    }

    @Test
    public void BishopChess2Test() {
        Chess chess = App.getChess(11, 0);
        assert chess.color == 0;
        assert chess.location.equals(new Location(11, 0));
    }

    @Test
    public void BishopChess2SpeedTest() {
        Chess chess = App.getChess(11, 0);

        assert chess.location.xPos == 0.0f + App.CELLSIZE * 11;
        assert chess.location.yPos == 0.0f;

        chess.move();

        assert chess.location.xPos == 6.0f + App.CELLSIZE * 11;
        assert chess.location.yPos == 6.0f;

        chess.move();

        assert chess.location.xPos == 12.0f + App.CELLSIZE * 11;
        assert chess.location.yPos == 12.0f;
    }

    @Test
    public void BishopChess2MoveTest() {
        Chess chess = App.getChess(11, 0);
        List<Location> locations = chess.enbleMoveList();
        int[][] arr = new int[][]{
        };
        for (int i = 0; i < arr.length; i++) {
            assert locations.contains(App.getLocation(arr[i][0], arr[i][1]));
        }
    }

    @Test
    public void KnightChess2Test() {
        Chess chess = App.getChess(12, 0);
        assert chess.color == 0;
        assert chess.location.equals(new Location(12, 0));
    }

    @Test
    public void KnightChess2SpeedTest() {
        Chess chess = App.getChess(12, 0);

        assert chess.location.xPos == 0.0f + App.CELLSIZE * 12;
        assert chess.location.yPos == 0.0f;

        chess.move();

        assert chess.location.xPos == 6.0f + App.CELLSIZE * 12;
        assert chess.location.yPos == 6.0f;

        chess.move();

        assert chess.location.xPos == 12.0f + App.CELLSIZE * 12;
        assert chess.location.yPos == 12.0f;
    }

    @Test
    public void KnightChess2MoveTest() {
        Chess chess = App.getChess(12, 0);
        List<Location> locations = chess.enbleMoveList();
        int[][] arr = new int[][]{
                {13, 2}, {11, 2}
        };
        for (int i = 0; i < arr.length; i++) {
            assert locations.contains(App.getLocation(arr[i][0], arr[i][1]));
        }
    }

    @Test
    public void RookChess2Test() {
        Chess chess = App.getChess(13, 0);
        assert chess.color == 0;
        assert chess.location.equals(new Location(13, 0));
    }

    @Test
    public void RookChess2SpeedTest() {
        Chess chess = App.getChess(13, 0);

        assert chess.location.xPos == 0.0f + App.CELLSIZE * 13;
        assert chess.location.yPos == 0.0f;

        chess.move();

        assert chess.location.xPos == 6.0f + App.CELLSIZE * 13;
        assert chess.location.yPos == 6.0f;

        chess.move();

        assert chess.location.xPos == 12.0f + App.CELLSIZE * 13;
        assert chess.location.yPos == 12.0f;
    }

    @Test
    public void RookChess2MoveTest() {
        Chess chess = App.getChess(13, 0);
        List<Location> locations = chess.enbleMoveList();
        int[][] arr = new int[][]{
        };
        for (int i = 0; i < arr.length; i++) {
            assert locations.contains(App.getLocation(arr[i][0], arr[i][1]));
        }
    }
}
