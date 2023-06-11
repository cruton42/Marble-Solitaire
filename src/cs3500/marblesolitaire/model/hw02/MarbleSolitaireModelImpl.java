package cs3500.marblesolitaire.model.hw02;

import cs3500.marblesolitaire.model.hw04.AbstractSolitaireModel;

/*
 * --IMPORTANT EDIT--
 * The fields and public methods for this class have been abstracted to
 * {@code AbstractSolitaireModel.java} in order to reduce code duplication.
 *
 */

/**
 * Class representing the Model functionality of a Marble Solitaire game. The game must be
 * constructed with an odd positive integer for the arm length, and with a valid open space to begin
 * with. The game board is made up of {@code GameSpace}'s. For example, on a game board of size 7 x
 * 7, the 2 x 2 square in each corner is invalid, and the middle of the board is left open, creating
 * a cross-like structure to the active game board.
 */
public class MarbleSolitaireModelImpl extends AbstractSolitaireModel {

  /**
   * Constructs the default Marble Solitaire game. The default board size is a 7 x 7 grid, with the
   * corner squares omitted, as designated by the lower and upper bounds. The open space remains in
   * the center at (3,3).
   */
  public MarbleSolitaireModelImpl() {
    super(3, 3, 3);
  }

  /**
   * Constructs a Marble Solitaire game of the default board size with a given open space to start.
   *
   * @param sRow the row of the given open space
   * @param sCol the column of the given open space
   * @throws IllegalArgumentException if the given coordinate is outside the active game board.
   */
  public MarbleSolitaireModelImpl(int sRow, int sCol) {
    super(3, sRow, sCol);
  }

  /**
   * Constructs a Marble Solitaire board game with the given arm size for the board. The center
   * remains at the default (3,3)
   *
   * @param armSize must not be even or negative
   * @throws IllegalArgumentException if the arm size is not a positive odd integer
   */
  public MarbleSolitaireModelImpl(int armSize) {
    super(armSize, ((armSize + (2 * (armSize - 1))) - 1) / 2,
        ((armSize + (2 * (armSize - 1))) - 1) / 2);
  }

  /**
   * Constructs a Marble Solitaire game with the specified armSize and open space. Arm size must be
   * a positive odd integer and the given row and column must be within the active playing field
   * according to the size of the board.
   *
   * @param armSize length of the arms of the board
   * @param sRow    row of the given open space
   * @param sCol    column of the given open space
   * @throws IllegalArgumentException if armSize is even or negative or if sRow or sCol are not
   *                                  within the bounds of our board
   */
  public MarbleSolitaireModelImpl(int armSize, int sRow, int sCol) {
    super(armSize, sRow, sCol);
  }

  /**
   * Method to build a Marble Solitaire Board implemented to reduce
   * duplicate code within the constructors.
   * @param sRow row for the free space
   * @param sCol column for the free space
   * @return the game board to be set as a field by the constructor.
   */
  public GameSpace[][] buildMarbleBoard(int armSize, int sRow,
      int sCol) {

    int bound = armSize - 1;
    int boardSize = armSize + (2 * bound);
    int upperBound = boardSize - armSize;

    if (armSize % 2 == 0 || armSize < 3) {
      throw new IllegalArgumentException("Arm thickness must be a positive odd integer!");
    }

    if ((sRow < bound && sCol < bound) || (sRow < bound && sCol > upperBound) || (sRow > upperBound
        && sCol < bound) || (sRow > upperBound
        && sCol > upperBound) || sRow < 0 || sCol < 0 || sRow >= boardSize
        || sCol >= boardSize) {
      throw new IllegalArgumentException(
          "Invalid empty cell position (" + Integer.toString(sRow) + "," + Integer.toString(sCol)
              + ")");
    }

    GameSpace[][] marbleBoard = new GameSpace[boardSize][boardSize];

    for (int i = 0; i < marbleBoard.length; i++) {
      for (int j = 0; j < marbleBoard[i].length; j++) {
        if ((i < bound && j < bound) || (i < bound && j > upperBound) || (i > upperBound
            && j < bound) || (i > upperBound && j > upperBound)) {
          marbleBoard[i][j] = GameSpace.Invalid;
        } else if (i == sRow && j == sCol) {
          marbleBoard[i][j] = GameSpace.Empty;
        } else {
          marbleBoard[i][j] = GameSpace.Marble;
        }
      }
    }

    return marbleBoard;
  }
}
