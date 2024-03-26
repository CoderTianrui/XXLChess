package XXLChess;


import processing.core.PApplet;
import processing.core.PImage;
import processing.data.JSONObject;
import processing.event.MouseEvent;

import java.io.File;
import java.util.*;
import java.util.List;

/**
 * The main class for the XXLChess application.
 */
public class App extends PApplet {

  /**
   * The size of each cell on the chessboard.
   */
  public static final int CELLSIZE = 48;

  /**
   * The width of the sidebar.
   */
  public static final int SIDEBAR = 120;

  /**
   * The width of the chessboard.
   */
  public static final int BOARD_WIDTH = 14;

  /**
   * The frames per second for the application.
   */
  public static final int FPS = 60;

  /**
   * The width of the application window.
   */
  public static int WIDTH = CELLSIZE * BOARD_WIDTH + SIDEBAR;

  /**
   * The height of the application window.
   */
  public static int HEIGHT = BOARD_WIDTH * CELLSIZE;

  //color
  /**
   * Color constant for the black player.
   */
  public static final int COLOR_PLAYER_BLACK = 0;

  /**
   * Color constant for the white player.
   */
  public static final int COLOR_PLAYER_WHITE = 1;

  /**
   * Color constant for the light blue color.
   */
  public static final int COLOR_BLUE_LIGHT = 2;

  /**
   * Color constant for the dark blue color.
   */
  public static final int COLOR_BLUE_DARK = 3;

  /**
   * Color constant for the light red color.
   */
  public static final int COLOR_LIGHT_RED = 4;

  /**
   * Color constant for the green color.
   */
  public static final int COLOR_GREEN = 5;

  /**
   * Color constant for the yellow color.
   */
  public static final int COLOR_YELLOW = 6;

  /**
   * Color constant for the dark red color.
   */
  public static final int COLOR_DARK_RED = 7;

  /**
   * Color constant for the white block color.
   */
  public static final int COLOR_BLOCK_WHITE = 8;

  /**
   * Color constant for the black block color.
   */
  public static final int COLOR_BLOCK_BLACK = 9;

  /**
   * Color constant for the background color.
   */
  public static final int COLOR_BACKGROUND = 10;

  /**
   * Color constant for the white color.
   */
  public static final int COLOR_WHITE = 11;

  //image
  /**
   * Array of images for the Amazon chess piece.
   */
  public static PImage[] AmazonImage;

  /**
   * Array of images for the Archbishop chess piece.
   */
  public static PImage[] ArchbishopImage;

  /**
   * Array of images for the Bishop chess piece.
   */
  public static PImage[] BishopImage;

  /**
   * Array of images for the Camel chess piece.
   */
  public static PImage[] CamelImage;

  /**
   * Array of images for the Chancellor chess piece.
   */
  public static PImage[] ChancellorImage;

  /**
   * Array of images for the General chess piece.
   */
  public static PImage[] GeneralImage;

  /**
   * Array of images for the King chess piece.
   */
  public static PImage[] KingImage;

  /**
   * Array of images for the Knight chess piece.
   */
  public static PImage[] KnightImage;

  /**
   * Array of images for the Pawn chess piece.
   */
  public static PImage[] PawnImage;

  /**
   * Array of images for the Queen chess piece.
   */
  public static PImage[] QueenImage;

  /**
   * Array of images for the Rook chess piece.
   */
  public static PImage[] RookImage;

  //config.json
  /**
   * The path to the config.json file.
   */
  public String configPath;

  /**
   * The layout configuration string.
   */
  public static String layout;

  /**
   * The time controls for the player in seconds.
   */
  public static int time_controls_player_seconds;

  /**
   * The time increment for the player in seconds.
   */
  public static int time_controls_player_increment;

  /**
   * The time controls for the CPU in seconds.
   */
  public static int time_controls_cpu_seconds;

  /**
   * The time increment for the CPU in seconds.
   */
  public static int time_controls_cpu_increment;

  /**
   * The color of the player (COLOR_PLAYER_BLACK or COLOR_PLAYER_WHITE).
   */
  public static int player_colour;

  /**
   * The movement speed of the chess pieces.
   */
  public static float piece_movement_speed;

  /**
   * The maximum movement time for a chess piece.
   */
  public static int max_movement_time;

  /**
   * The maximum movement frames per second for a chess piece.
   */
  public static int max_movement_fps;

  //game params
  /**
   * The current turn color (COLOR_PLAYER_BLACK or COLOR_PLAYER_WHITE).
   */
  public volatile int turning;

  /**
   * The 2D array representing the chessboard with Chess objects.
   */
  public static Chess[][] chessMap;

  /**
   * Array containing the kings (black and white) Chess objects.
   */
  public static Chess[] kings;

  /**
   * 2D array representing the location map with Location objects.
   */
  public static Location[][] locationMap;

  /**
   * Array containing the previous locations (from and to) for a move.
   */
  public Location[] preLocations;

  /**
   * Array containing the current locations (from and to) for a move.
   */
  public Location[] curLocations;

  /**
   * Array containing the current chess pieces involved in a move.
   */
  public Chess[] curChess;

  /**
   * List of enabled move locations.
   */
  public List<Location> enableMoveList;

  /**
   * List of enabled eat locations.
   */
  public List<Location> enableEatList;

  //move
  /**
   * Flag indicating if a chess piece is currently moving.
   */
  public static volatile boolean isMoving;

  /**
   * The speed of the chess piece movement on the x-axis.
   */
  public static float xSpeed;

  /**
   * The speed of the chess piece movement on the y-axis.
   */
  public static float ySpeed;

  //left seconds
  /**
   * The remaining seconds for the player.
   */
  public int playerSeconds;

  /**
   * The remaining seconds for the CPU.
   */
  public int cpuSeconds;

  //king in check
  /**
   * The maximum frames per second for the "king in check" effect.
   */
  public static final int IN_CHECK_MAX_FPS = FPS * 5 / 2;

  /**
   * The number of frames per second for the "king in check" effect.
   */
  public static final int IN_CHECK_PER_FPS = FPS / 2;

  /**
   * Array indicating if each king is in check.
   */
  public boolean[] kingsInCheck;

  /**
   * The current frames per second for the "king in check" effect.
   */
  public int fpsInCheck;

  //game is over
  /**
   * Flag indicating if the game is over.
   */
  public volatile boolean isOver;

  /**
   * Flag indicating if the player is the winner.
   */
  public boolean isPlayerWinner;

  /**
   * The game over condition: 1 represents cannot move, 2 represents time has ended.
   */
  public int way;

  //drag move
  /**
   * Flag indicating if a chess piece is being dragged.
   */
  public boolean isDraging;

  /**
   * The chess piece being dragged.
   */
  public Chess dragChess;

  /**
   * The location from which the chess piece is being dragged.
   */
  public Location dragLocation;



  public App() {
    configPath = "config.json";

    turning = COLOR_PLAYER_WHITE;
    chessMap = new Chess[BOARD_WIDTH][BOARD_WIDTH];
    kings = new Chess[2];
    locationMap = new Location[BOARD_WIDTH][BOARD_WIDTH];

    preLocations=new Location[2];
    curLocations=new Location[2];
    curChess=new Chess[2];
    enableMoveList =new ArrayList<>();
    enableEatList =new ArrayList<>();

    kingsInCheck=new boolean[2];
    fpsInCheck=0;
    for (int i = 0; i < BOARD_WIDTH; i++) {
      for (int j = 0; j < BOARD_WIDTH; j++) {
        setLocation(i,j,new Location(i,j));
      }
    }
  }

  public static void main(String[] args) {
    PApplet.main("XXLChess.App");
  }

  /** Initialise the setting of the window size. */
  public void settings() {
    size(WIDTH, HEIGHT);
  }

  /**
   * Load all resources such as images. Initialise the elements such as the player, enemies and map
   * elements.
   */
  public void setup() {
    frameRate(FPS);

    // Load images during setup
    String imagePath = "src/main/resources/XXLChess/";
    AmazonImage = new PImage[]{
            loadImage(imagePath + "b-amazon.png"), loadImage(imagePath + "w-amazon.png")
    };
    ArchbishopImage = new PImage[]{
            loadImage(imagePath + "b-archbishop.png"), loadImage(imagePath + "w-archbishop.png")
    };
    BishopImage = new PImage[]{
            loadImage(imagePath + "b-bishop.png"), loadImage(imagePath + "w-bishop.png")
    };
    CamelImage = new PImage[]{
            loadImage(imagePath + "b-camel.png"), loadImage(imagePath + "w-camel.png")
    };
    ChancellorImage = new PImage[]{
            loadImage(imagePath + "b-chancellor.png"), loadImage(imagePath + "w-chancellor.png")
    };
    GeneralImage = new PImage[]{
            loadImage(imagePath + "b-knight-king.png"), loadImage(imagePath + "w-knight-king.png")
    };
    KingImage = new PImage[]{
            loadImage(imagePath + "b-king.png"), loadImage(imagePath + "w-king.png")
    };
    KnightImage = new PImage[]{
            loadImage(imagePath + "b-knight.png"), loadImage(imagePath + "w-knight.png")
    };
    PawnImage = new PImage[]{
            loadImage(imagePath + "b-pawn.png"), loadImage(imagePath + "w-pawn.png")
    };
    QueenImage = new PImage[]{
            loadImage(imagePath + "b-queen.png"), loadImage(imagePath + "w-queen.png")
    };
    RookImage = new PImage[]{
            loadImage(imagePath + "b-rook.png"), loadImage(imagePath + "w-rook.png")
    };

    // load config.json
    loadConfigJson();

    // init left seconds
    playerSeconds = time_controls_player_seconds;
    cpuSeconds = time_controls_cpu_seconds;

    // load level
    loadLevel();

    //cpu thread
    Thread cpuThread = new Thread(this::cpuStart);
    cpuThread.start();

    //time thread
    Thread timeThread = new Thread(this::timeStart);
    timeThread.start();
  }

  /**
   * Loads the configuration from the config.json file.
   */
  public void loadConfigJson() {
    // Load the config.json file
    JSONObject configJson = loadJSONObject(new File(this.configPath));

    // Load the layout configuration
    layout = (String) configJson.get("layout");

    // Load the time controls for the player and CPU
    JSONObject time_controls = (JSONObject) configJson.get("time_controls");
    JSONObject player = (JSONObject) time_controls.get("player");
    JSONObject cpu = (JSONObject) time_controls.get("cpu");
    time_controls_player_seconds = (int) player.get("seconds");
    time_controls_player_increment = (int) player.get("increment");
    time_controls_cpu_seconds = (int) cpu.get("seconds");
    time_controls_cpu_increment = (int) cpu.get("increment");

    // Determine the player color
    player_colour = configJson.get("player_colour").equals("white") ? COLOR_PLAYER_WHITE : COLOR_PLAYER_BLACK;

    // Load the piece movement speed, max movement time, and max movement FPS
    piece_movement_speed = ((Double) configJson.get("piece_movement_speed")).floatValue();
    max_movement_time = (int) configJson.get("max_movement_time");
    max_movement_fps = max_movement_time * FPS;
  }

  /**
   * Loads the level layout from the specified file.
   */
  public void loadLevel() {
    File file = new File(layout);
    Scanner scanner;
    try {
      scanner = new Scanner(file);
      int row = 0;
      while (scanner.hasNextLine()) {
        String s = scanner.nextLine();
        for (int col = 0; col < s.length(); col++) {
          char ch = s.charAt(col);
          int color = COLOR_PLAYER_BLACK;
          if (ch >= 'a' && ch <= 'z') {
            color = COLOR_PLAYER_WHITE;
            ch = (char) (ch - 'a' + 'A');
          }
          Chess chess;
          // Create the appropriate chess object based on the character
          if (ch == 'A') {
            chess = new AmazonChess(col, row, color, AmazonImage[color]);
          } else if (ch == 'H') {
            chess = new ArchbishopChess(col, row, color, ArchbishopImage[color]);
          } else if (ch == 'B') {
            chess = new BishopChess(col, row, color, BishopImage[color]);
          } else if (ch == 'C') {
            chess = new CamelChess(col, row, color, CamelImage[color]);
          } else if (ch == 'E') {
            chess = new ChancellorChess(col, row, color, ChancellorImage[color]);
          } else if (ch == 'G') {
            chess = new GeneralChess(col, row, color, GeneralImage[color]);
          } else if (ch == 'K') {
            chess = new KingChess(col, row, color, KingImage[color]);
            kings[color] = chess;
          } else if (ch == 'N') {
            chess = new KnightChess(col, row, color, KnightImage[color]);
          } else if (ch == 'P') {
            chess = new PawnChess(col, row, color, PawnImage[color]);
          } else if (ch == 'Q') {
            chess = new QueenChess(col, row, color, QueenImage[color]);
          } else if (ch == 'R') {
            chess = new RookChess(col, row, color, RookImage[color]);
          } else {
            throw new Exception(String.format("load chess map failed:char:%s at row:%d,col:%d is not found", ch, row, col));
          }
          chessMap[col][row] = chess;
        }
        row++;
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * Receives the key pressed signal from the keyboard.
   */
  public void keyPressed() {
    if (keyCode == 'r' || keyCode == 'R') {
      // Restart the game
      PApplet.main("XXLChess.App");
    } else if (keyCode == 'e' || keyCode == 'E') {
      // Exit the game
      System.exit(0);
    }
  }

  /**
   * Receives the key released signal from the keyboard.
   */
  public void keyReleased() {}
  /**
   * Handles mouse press events.
   * If it is the player's turn and the chess piece is not currently moving, processes the mouse click.
   */
  @Override
  public void mousePressed(MouseEvent e) {
    // Check if it is the player's turn and the chess piece is not currently moving
    if (turning == player_colour && !isMoving) {
      int x = e.getX() / CELLSIZE;
      int y = e.getY() / CELLSIZE;
      if (isLegal(e.getX() / CELLSIZE, e.getY() / CELLSIZE)) {
        handleMouseClick(x, y);
      }
    }
  }

  /**
   * Checks if the given coordinates are within the board.
   *
   * @param x the x-coordinate
   * @param y the y-coordinate
   * @return {@code true} if the coordinates are within the board, {@code false} otherwise
   */
  public static boolean isLegal(int x, int y) {
    return x >= 0 && x < BOARD_WIDTH && y >= 0 && y < BOARD_WIDTH;
  }

  /**
   * Returns the location at the specified coordinates.
   *
   * @param x the x-coordinate
   * @param y the y-coordinate
   * @return the location at the specified coordinates
   */
  public static Location getLocation(int x, int y) {
    return locationMap[x][y];
  }

  /**
   * Sets the location at the specified coordinates.
   *
   * @param x  the x-coordinate
   * @param y  the y-coordinate
   * @param pos the location to be set
   */
  public static void setLocation(int x, int y, Location pos) {
    locationMap[x][y] = pos;
  }

  /**
   * Returns the chess piece at the specified coordinates.
   *
   * @param x the x-coordinate
   * @param y the y-coordinate
   * @return the chess piece at the specified coordinates
   */
  public static Chess getChess(int x, int y) {
    return chessMap[x][y];
  }

  /**
   * Sets the chess piece at the specified coordinates.
   *
   * @param x     the x-coordinate
   * @param y     the y-coordinate
   * @param chess the chess piece to be set
   */
  public static void setChess(int x, int y, Chess chess) {
    chessMap[x][y] = chess;
  }

  /**
   * Sets the chess piece at the specified location.
   *
   * @param location the location
   * @param chess    the chess piece to be set
   */
  public static void setChess(Location location, Chess chess) {
    setChess(location.x, location.y, chess);
  }

  /**
   * Handles mouse click events for moving the chess pieces. This function also includes
   * logic for check, castling, and checkmate scenarios in the game.
   *
   * @param x the x-coordinate of the mouse click
   * @param y the y-coordinate of the mouse click
   * @return {@code true} if the mouse click is successfully handled, {@code false} otherwise
   */
  public boolean handleMouseClick(int x, int y) {
    Location location = getLocation(x, y);

    // Second click
    if (curLocations[0] != null && (enableMoveList.contains(location) || enableEatList.contains(location))) {
      curLocations[1] = getLocation(x, y);
      curChess[1] = getChess(x, y);

      // Move to location
      setChess(x, y, curChess[0]);
      setChess(curLocations[0].x, curLocations[0].y, null);
      curChess[0].moveToTargetLocation(curLocations[1]);
      isMoving = true;
      setChessSpeed();

      if (curChess[1] instanceof KingChess) {
        isOver = true;
        isPlayerWinner = turning == player_colour;
        way = 1;
      }

      // A king may perform a 'castling' move if it has not moved before
      int disX = curLocations[1].x - curLocations[0].x;
      if (curChess[0] == kings[turning] && Math.abs(disX) == 2) {
        int locaX = disX > 0 ? BOARD_WIDTH - 1 : 0;
        Chess rock = chessMap[locaX][y];
        int tarX = (curLocations[0].x + curLocations[1].x) / 2;
        setChess(tarX, y, rock);
        rock.location = getLocation(tarX, y);
        rock.firstMove = false;
        setChess(locaX, y, null);
      }

      // Check if the king is in check
      if (kings[turning].inCheck()) {
        // Move back to the original location
        setChess(curLocations[0].x, curLocations[0].y, curChess[0]);
        curChess[0].moveBack();
        setChess(curLocations[1].x, curLocations[1].y, curChess[1]);
        curLocations[1] = null;
        curChess[1] = null;
        isMoving = false;

        kingsInCheck[turning] = true;
        enableMoveList.remove(location);
        enableEatList.remove(location);
        return false;
      }

      // Reduce time
      if (player_colour == turning) {
        playerSeconds += time_controls_player_increment;
      } else {
        cpuSeconds += time_controls_cpu_increment;
      }

      nextTurn();
    } else { // First click
      Chess chess = getChess(x, y);
      if (chess == null || chess.color != turning) return false;
      curLocations[0] = location;
      curChess[0] = chess;
      enableMoveList = chess.enbleMoveList();
      enableEatList = chess.enbleEatList();
    }

    return true;
  }

  /**
   * Handles the computer's turn in the game. This function randomly selects valid moves
   * for the computer and continues until the game is over.
   */
  public void cpuStart() {
    // Loop until the game is over
    while (true) {
      // If it is the computer's turn and there is no piece moving currently
      if(turning != player_colour && !isMoving) {
        // Get all the pieces that belong to the computer
        List<Chess> chessList = getTurningChessList();
        // Shuffle the list to make the decision process random
        Collections.shuffle(chessList);
        boolean flag=false;
        // Loop through each piece
        for (Chess chess : chessList) {
          flag=false;
          // Mimic a mouse click on the current piece
          handleMouseClick(chess.location.x, chess.location.y);
          // Loop until a valid move is made
          while (true) {
            // Create a new list to hold all possible moves and eats for the current piece
            List<Location> list = new ArrayList<>();
            list.addAll(enableMoveList);
            list.addAll(enableEatList);
            // If there are no possible moves or eats, break the loop
            if (list.isEmpty()) {
              break;
            }
            // Choose a random move or eat from the list
            Random random = new Random();
            Location location = list.get(random.nextInt(list.size()));
            // Mimic a mouse click on the selected move or eat
            // If the move or eat is valid, break the loop
            if (handleMouseClick(location.x, location.y)) {
              flag=true;
              break;
            }
          }
          // If a valid move or eat has been made, break the loop
          if(flag){
            break;
          }
        }
        // If no valid move or eat can be made, the game is over and the player wins
        if(!flag){
          isOver=true;
          isPlayerWinner=true;
          way=1;
          return;
        }
      }
    }
  }

  /**
   * Controls the game's timing. Each player's time decreases after their turn.
   * The game ends when one player's time reaches zero.
   */
  public void timeStart() {
    while(true){
      if (!isMoving) {
        try {
          Thread.sleep(1000);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
        if (turning == player_colour) {
          playerSeconds--;
          if(playerSeconds<=0){
            isOver=true;
            isPlayerWinner=false;
            way=2;
          }
        }else{
          cpuSeconds--;
          if(cpuSeconds<=0){
            isOver=true;
            isPlayerWinner=true;
            way=2;
          }
        }
      }
    }
  }
  /**
   * Returns a list of chess pieces that the current player can move.
   *
   * @return a list of chess pieces that the current player can move
   */
  public List<Chess> getTurningChessList() {
    List<Chess> res = new ArrayList<>();

    for (int i = 0; i < BOARD_WIDTH; i++) {
      for (int j = 0; j < BOARD_WIDTH; j++) {
        Chess chess = getChess(i, j);
        if (chess != null && chess.color == turning) {
          res.add(chess);
        }
      }
    }

    return res;
  }

  /**
   * Moves the turn to the next player and resets all temporary variables related to a turn.
   */
  public void nextTurn() {
    turning = turning==COLOR_PLAYER_WHITE?COLOR_PLAYER_BLACK:COLOR_PLAYER_WHITE;
    preLocations[0] = curLocations[0];
    preLocations[1] = curLocations[1];
    curLocations[0] = null;
    curLocations[1] = null;
    curChess[0] = null;
    enableMoveList.clear();
    enableEatList.clear();
  }
  /**
   * Handles mouse release events. If the player has finished dragging a piece to a valid square,
   * the move is made. If the move is not valid, the piece is returned to its original position.
   */
  @Override
  public void mouseReleased(MouseEvent e) {
    // check
    int x = e.getX() / CELLSIZE;
    int y = e.getY() / CELLSIZE;
    if(turning == player_colour && !isMoving && isDraging){
      Location location = getLocation(x,y);
      if (isLegal(y, y) && (enableMoveList.contains(location) || enableEatList.contains(location))){
        handleMouseClick(x,y);
      }
    }
    isDraging=false;
    dragChess=null;
    dragLocation=null;
  }
  /**
   * Handles mouse drag events. The player can select a piece and drag it to a new square.
   * The square is highlighted if the move is valid.
   */
  @Override
  public void mouseDragged(MouseEvent e) {
    // check
    if (turning == player_colour && !isMoving) {
      int x = e.getX() / CELLSIZE;
      int y = e.getY() / CELLSIZE;
      if (isLegal(e.getX() / CELLSIZE, e.getY() / CELLSIZE)) {
        if(!isDraging) {
          Location location = getLocation(x, y);
          Chess chess = getChess(x,y);
          if (chess == null || chess.color != turning) return;
          curLocations[0] = location;
          curChess[0] = chess;
          enableMoveList = chess.enbleMoveList();
          enableEatList = chess.enbleEatList();
          isDraging=true;
          dragChess = chess;
          dragLocation = new Location(location.x,location.y);
        }else{
          dragLocation.xPos=e.getX();
          dragLocation.yPos=e.getY();
          dragLocation.x=x;
          dragLocation.y=y;
        }
      }
    }
  }

  // Add any additional methods or attributes you want. Please put classes in different files.

  /**
   * Draws all elements of the game. This includes the board, pieces, valid moves, time,
   * and any messages that need to be displayed to the player.
   */
  public void draw() {

    background(203,203,203);

    // init bg
    for (int i = 0; i < BOARD_WIDTH; i++) {
      for (int j = 0; j < BOARD_WIDTH; j++) {
        drawRectangle(i,j,(i + j) % 2 == 0?COLOR_BLOCK_WHITE:COLOR_BLOCK_BLACK);
      }
    }

    //draw right
    textSize(28);
    colorFill(COLOR_WHITE);
    if(player_colour==COLOR_PLAYER_BLACK){
      text(String.valueOf(playerSeconds),CELLSIZE * BOARD_WIDTH,0,SIDEBAR,180);
      text(String.valueOf(cpuSeconds),CELLSIZE * BOARD_WIDTH,HEIGHT - 28,SIDEBAR,180);
    }else{
      text(String.valueOf(cpuSeconds),CELLSIZE * BOARD_WIDTH,0,SIDEBAR,180);
      text(String.valueOf(playerSeconds),CELLSIZE * BOARD_WIDTH,HEIGHT - 48,SIDEBAR,180);
    }

    // draw click
    drawRectangle(preLocations[0],COLOR_YELLOW);
    drawRectangle(preLocations[1],COLOR_YELLOW);
    drawRectangle(curLocations[0],COLOR_GREEN);
    for(Location location: enableMoveList){
      int color = COLOR_BLUE_DARK;
      if((location.x+location.y) % 2 == 0){
        color = COLOR_BLUE_LIGHT;
      }
      drawRectangle(location,color);
    }
    for(Location location: enableEatList){
      drawRectangle(location,COLOR_LIGHT_RED);
    }

    // draw bg of King
    for (int i = 0; i <kings.length; i++) {
      Chess chess = kings[i];
      if(kingsInCheck[i]){
        textSize(28);
        colorFill(COLOR_WHITE);
        if(!isOver) {
          text("Check!", CELLSIZE * BOARD_WIDTH, HEIGHT / 2 - 48, SIDEBAR, 180);
        }
        if ((fpsInCheck / IN_CHECK_PER_FPS) % 2 == 0) {
          drawRectangle(chess.location, COLOR_DARK_RED);
        }
        fpsInCheck++;
        if(fpsInCheck==IN_CHECK_MAX_FPS){
          kingsInCheck[i]=false;
          fpsInCheck=0;
        }
      }
    }

    //draw chess
    for (int i = 0; i < BOARD_WIDTH; i++) {
      for (int j = 0; j < BOARD_WIDTH; j++) {
        Chess chess = getChess(i,j);
        if (chess != null) {
          if(chess.isMoving){
            chess.move();
            if(chess.reachTargetLocationtion()){
              isMoving=false;
              xSpeed=0;
              ySpeed=0;
              chess.stopMoving();
            }
            image(chess.image, (float) chess.location.xPos, (float) chess.location.yPos, CELLSIZE, CELLSIZE);
          }else{
            if(isDraging && chess==dragChess){
              image(chess.image, dragLocation.xPos, dragLocation.yPos, CELLSIZE, CELLSIZE);
            }else {
              image(chess, i, j);
            }
          }
        }
      }
    }

    if(isOver && !isMoving){
      textSize(18);
      fill(255,255,255);
      String text;
      if (way == 1) {
        if(isPlayerWinner){
          text = "You won by checkmate! Press 'r' to restart!";
        }else{
          text = "You lost by checkmate! Press 'r' to restart!";
        }
      }else{
        if(isPlayerWinner){
          text = "You won on time! Press 'r' to restart!";
        }else{
          text = "You lost on time! Press 'r' to restart!";
        }
      }
      text(text,CELLSIZE * BOARD_WIDTH,HEIGHT/2-48,SIDEBAR,180);
      noLoop();
    }
  }
  /**
   * Draws a rectangle at the specified location with the specified color.
   *
   * @param location the location at which to draw the rectangle
   * @param color    the color of the rectangle
   */
  public void drawRectangle(Location location, int color) {
    if (location == null) return;
    drawRectangle(location.x, location.y, color);
  }

  /**
   * Draws a rectangle at the specified coordinates with the specified color.
   *
   * @param i     the x-coordinate of the rectangle
   * @param j     the y-coordinate of the rectangle
   * @param color the color of the rectangle
   */
  public void drawRectangle(int i, int j, int color) {
    colorFill(color);
    rect(i * CELLSIZE, j * CELLSIZE, CELLSIZE, CELLSIZE);
  }

  /**
   * Draws a chess piece at the specified coordinates.
   *
   * @param chess the chess piece to be drawn
   * @param i     the x-coordinate of the chess piece
   * @param j     the y-coordinate of the chess piece
   */
  public void image(Chess chess, int i, int j) {
    image(chess.image, i * CELLSIZE, j * CELLSIZE, CELLSIZE, CELLSIZE);
  }

  /**
   * Sets the fill color for drawing shapes.
   *
   * @param color the color to set for filling shapes
   */
  public void colorFill(int color) {
    switch (color) {
      case COLOR_BLUE_LIGHT:
        g.fill(196, 224, 232);
        break;
      case COLOR_BLUE_DARK:
        g.fill(170, 210, 221);
        break;
      case COLOR_LIGHT_RED:
        g.fill(255, 164, 102);
        break;
      case COLOR_GREEN:
        g.fill(105, 138, 76);
        break;
      case COLOR_YELLOW:
        g.fill(170, 162, 58);
        break;
      case COLOR_DARK_RED:
        g.fill(255, 0, 0);
        break;
      case COLOR_BLOCK_WHITE:
        g.fill(240, 217, 181);
        break;
      case COLOR_BLOCK_BLACK:
        g.fill(181, 136, 99);
        break;
      case COLOR_BACKGROUND:
        g.fill(204, 204, 204);
        break;
      case COLOR_WHITE:
        g.fill(255, 255, 255);
        break;
    }
  }

  /**
   * Replaces a pawn with a queen when it reaches the opposite end of the board.
   *
   * @param pawn the pawn to be replaced
   */
  public static void toBeQueen(PawnChess pawn) {
    QueenChess queenChess = new QueenChess(pawn.location.x, pawn.location.y, pawn.color, QueenImage[pawn.color]);
    queenChess.targetLocation = pawn.targetLocation;
    queenChess.isMoving = pawn.isMoving;
    queenChess.firstMove = pawn.firstMove;
    queenChess.lastMove = pawn.lastMove;
    setChess(queenChess.targetLocation, queenChess);
  }

  /**
   * Sets the speed of a piece when it is moving to a new square.
   */
  public void setChessSpeed(){
    float dx=curChess[0].targetLocation.x-curChess[0].location.x;
    float dy=curChess[0].targetLocation.y-curChess[0].location.y;
    float dz= (float) Math.sqrt(dx*dx+dy*dy);
    float zSpeed = piece_movement_speed;
    if(dz>piece_movement_speed*max_movement_fps){
      zSpeed = dz/max_movement_fps;
    }
    xSpeed = zSpeed*dx/dz;
    ySpeed = zSpeed*dy/dz;
  }
}
