package cs3500.marblesolitaire.model.hw04;

import cs3500.marblesolitaire.model.hw02.GameSpace;

/**
 * Class representing the Model functionality of a European Solitaire game. The game must be
 * constructed with an odd positive integer for the arm length, and with a valid open space to begin
 * with. The game board is made up of {@code GameSpace}'s. The default active game board is made up
 * of Marbles in the shape of an Octagon with a side length of three.
 */
public class EuropeanSolitaireModelImpl extends AbstractSolitaireModel {

  /**
   * Constructs the default European Solitaire game. The default board size is a 7 x 7 grid, with an
   * octagon of marbles with a side length of three. The open space remains in the center at (3,3).
   */
  public EuropeanSolitaireModelImpl() {
    super(3, 3, 3);
  }

  /**
   * Constructs a European Solitaire board game with the given arm size for the board. The center
   * remains at the default (3,3).
   *
   * @param armSize must not be even or negative
   * @throws IllegalArgumentException if the arm size is not a positive odd integer
   */
  public EuropeanSolitaireModelImpl(int armSize) {
    super(armSize, ((armSize + (2 * (armSize - 1))) - 1) / 2,
        ((armSize + (2 * (armSize - 1))) - 1) / 2);
  }

  /**
   * Constructs a European Solitaire game of the default board size with a given open space to
   * start.
   *
   * @param sRow the row of the given open space
   * @param sCol the column of the given open space
   * @throws IllegalArgumentException if the given coordinate is outside the active game board.
   */
  public EuropeanSolitaireModelImpl(int sRow, int sCol) {
    super(3, sRow, sCol);
  }

  /**
   * Constructs a European Solitaire game with the specified armSize and open space. Arm size must
   * be a positive odd integer and the given row and column must be within the active playing field
   * according to the size of the board.
   *
   * @param armSize length of the arms of the board
   * @param sRow    row of the given open space
   * @param sCol    column of the given open space
   * @throws IllegalArgumentException if armSize is even or negative or if sRow or sCol are not
   *                                  within the bounds of our board
   */
  public EuropeanSolitaireModelImpl(int armSize, int sRow, int sCol) {
    super(armSize, sRow, sCol);
  }

  /**
   * Method to build a Marble Solitaire Board implemented to reduce duplicate code within the
   * constructors.
   *
   * @param sRow row for the free space
   * @param sCol column for the free space
   * @return the game board to be set as a field by the constructor.
   */
  public GameSpace[][] buildMarbleBoard(int armSize, int sRow,
      int sCol) {
    if (armSize % 2 == 0 || armSize < 3) {
      throw new IllegalArgumentException("Arm thickness must be a positive odd integer!");
    }

    int bound = armSize - 1;
    int boardSize = armSize + (2 * bound);
    int upperBound = boardSize - armSize;

    if (sRow < 0 || sCol < 0 || sRow >= boardSize
        || sCol >= boardSize) {
      throw new IllegalArgumentException(
          "Invalid empty cell position (" + sRow + "," + sCol + ")");
    }

    GameSpace[][] marbleBoard = new GameSpace[boardSize][boardSize];
    int counter = bound - 1;

    for (int i = 0; i < marbleBoard.length; i++) {
      for (int j = 0; j < marbleBoard[i].length; j++) {

        if (i < bound && j < bound - i) {
          marbleBoard[i][j] = GameSpace.Invalid;
        } else if (i < bound && j > upperBound + i) {
          marbleBoard[i][j] = GameSpace.Invalid;
        } else if (i > upperBound && j < bound - counter) {
          marbleBoard[i][j] = GameSpace.Invalid;
        } else if (i > upperBound && j > upperBound + counter) {
          marbleBoard[i][j] = GameSpace.Invalid;

          if (j == marbleBoard[i].length - 1) {
            counter--;
          } else if (marbleBoard[i][j + 1] == GameSpace.Invalid && counter > 0) {
            counter--;
          }
        } else {
          marbleBoard[i][j] = GameSpace.Marble;
        }
      }
    }

    if (marbleBoard[sRow][sCol] != GameSpace.Marble) {
      throw new IllegalArgumentException(
          "Invalid empty cell position (" + sRow + "," + sCol
              + ")");
    } else {
      marbleBoard[sRow][sCol] = GameSpace.Empty;
    }

    return marbleBoard;
  }
}
