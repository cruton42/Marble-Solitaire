package cs3500.marblesolitaire.model.hw04;

import cs3500.marblesolitaire.model.hw02.GameSpace;
import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModel;

/**
 * Abstract implementation for multiple model versions of Solitaire.
 */
public abstract class AbstractSolitaireModel implements MarbleSolitaireModel {

  protected GameSpace[][] marbleBoard;
  protected int armSize;

  /**
   * Constructs an Abstract Solitaire Model, calling the inherited buildMarbleBoard method of each
   * class.
   *
   * @param armSize arm size to give dimensions of game board
   * @param sRow    row of starting slot
   * @param sCol    column of starting slot
   */
  public AbstractSolitaireModel(int armSize, int sRow, int sCol) {
    this.armSize = armSize;
    marbleBoard = buildMarbleBoard(armSize, sRow, sCol);
  }

  /**
   * Method to construct the 2d-array for our Marble Board.
   *
   * @param armSize arm size to give dimensions of game board
   * @param sRow    row of starting slot
   * @param sCol    column of starting slot
   * @return the Game Board
   */
  protected abstract GameSpace[][] buildMarbleBoard(int armSize, int sRow, int sCol);


  /**
   * Move a single marble from a given position to another given position. A move is valid only if
   * the from and to positions are valid. Specific implementations may place additional constraints
   * on the validity of a move.
   *
   * @param fromRow the row number of the position to be moved from (starts at 0)
   * @param fromCol the column number of the position to be moved from (starts at 0)
   * @param toRow   the row number of the position to be moved to (starts at 0)
   * @param toCol   the column number of the position to be moved to (starts at 0)
   * @throws IllegalArgumentException if the game is not over, if the fromRow, fromCol, toRow, or
   *                                  toCol values are outside the active playable game board, or if
   *                                  the move is not exactly 2 spaces away, from an occupied space
   *                                  to an empty space and over an occupied space
   */
  @Override
  public void move(int fromRow, int fromCol, int toRow, int toCol) {
    if (isGameOver()) {
      throw new IllegalStateException("Game Over!");
    }
    int boardSize = armSize + (2 * (armSize - 1));
    if (fromRow < 0 || fromCol < 0 || toRow < 0 || toCol < 0 || fromRow >= boardSize
        || fromCol >= boardSize || toRow >= boardSize || toCol >= boardSize) {
      throw new IllegalArgumentException("You're numbers aren't within our array index!");
    }
    if (marbleBoard[fromRow][fromCol] != GameSpace.Marble) {
      throw new IllegalArgumentException("The from position is not valid!");
    }
    if (marbleBoard[toRow][toCol] != GameSpace.Empty) {
      throw new IllegalArgumentException("The to position is not valid!");
    }

    if (fromRow == toRow && fromCol < toCol) {
      if (marbleBoard[fromRow][fromCol + 1] != GameSpace.Marble) {
        throw new IllegalArgumentException("You must jump over a marble!");
      }
    } else if (fromRow == toRow && fromCol > toCol) {
      if (marbleBoard[fromRow][fromCol - 1] != GameSpace.Marble) {
        throw new IllegalArgumentException("You must jump over a marble!");
      }
    } else if (fromCol == toCol && fromRow < toRow) {
      if (marbleBoard[fromRow + 1][fromCol] != GameSpace.Marble) {
        throw new IllegalArgumentException("You must jump over a marble!");
      }
    } else if (fromCol == toCol && fromRow > toRow) {
      if (marbleBoard[fromRow - 1][fromCol] != GameSpace.Marble) {
        throw new IllegalArgumentException("You must jump over a marble!");
      }
    }

    if (Math.abs(toRow - fromRow) == 2 && toCol == fromCol) {
      if ((toRow - fromRow == 2 && marbleBoard[fromRow + 1][fromCol].getState() == 'O')) {
        updateBoard(fromRow, fromCol, toRow, toCol, fromRow + 1, fromCol);
      } else if (toRow - fromRow == -2 && marbleBoard[fromRow - 1][fromCol].getState() == 'O') {
        updateBoard(fromRow, fromCol, toRow, toCol, fromRow - 1, fromCol);
      }
    } else if (toRow == fromRow && Math.abs(toCol - fromCol) == 2) {
      if ((toCol - fromCol == 2 && marbleBoard[fromRow][fromCol + 1].getState() == 'O')) {
        updateBoard(fromRow, fromCol, toRow, toCol, fromRow, fromCol + 1);
      } else if (toCol - fromCol == -2 && marbleBoard[fromRow][fromCol - 1].getState() == 'O') {
        updateBoard(fromRow, fromCol, toRow, toCol, fromRow, fromCol - 1);
      }
    } else {
      throw new IllegalArgumentException("This move is not valid!");
    }
  }

  /**
   * Updates the board when a move is made.
   *
   * @param fromRow row of the from position
   * @param fromCol column of the from position
   * @param toRow   row of the to position
   * @param toCol   column of the to position
   * @param midRow  row of the middle position
   * @param midCol  column of the middle position
   */
  protected void updateBoard(int fromRow, int fromCol, int toRow, int toCol, int midRow,
      int midCol) {
    marbleBoard[fromRow][fromCol] = GameSpace.Empty;
    marbleBoard[toRow][toCol] = GameSpace.Marble;
    marbleBoard[midRow][midCol] = GameSpace.Empty;
  }

  /**
   * Determine if the game is over or not. A game is over if no more moves can be made.
   *
   * @return true if the game is over, false otherwise
   */
  @Override
  public boolean isGameOver() {
    if (getScore() == 1) {
      return true;
    }

    for (int i = 0; i < marbleBoard.length; i++) {
      for (int j = 0; j < marbleBoard[i].length; j++) {
        if (marbleBoard[i][j] == GameSpace.Marble) {
          if (j == marbleBoard[i].length - 1 || j == marbleBoard[i].length - 2) {
            if ((marbleBoard[i + 1][j] == GameSpace.Marble
                && marbleBoard[i + 2][j] == GameSpace.Empty)
                || (marbleBoard[i - 1][j] == GameSpace.Marble
                && marbleBoard[i - 2][j] == GameSpace.Empty)
                || (marbleBoard[i][j - 1] == GameSpace.Marble
                && marbleBoard[i][j - 2] == GameSpace.Empty)) {
              return false;
            }
          } else if (i == marbleBoard[i].length - 1 || i == marbleBoard[i].length - 2) {
            if ((marbleBoard[i - 1][j] == GameSpace.Marble
                && marbleBoard[i - 2][j] == GameSpace.Empty)
                || (marbleBoard[i][j + 1] == GameSpace.Marble
                && marbleBoard[i][j + 2] == GameSpace.Empty)
                || (marbleBoard[i][j - 1] == GameSpace.Marble
                && marbleBoard[i][j - 2] == GameSpace.Empty)) {
              return false;
            }
          } else if (i == 0 || i == 1) {
            if ((marbleBoard[i + 1][j] == GameSpace.Marble
                && marbleBoard[i + 2][j] == GameSpace.Empty)
                || (marbleBoard[i][j + 1] == GameSpace.Marble
                && marbleBoard[i][j + 2] == GameSpace.Empty)
                || (marbleBoard[i][j - 1] == GameSpace.Marble
                && marbleBoard[i][j - 2] == GameSpace.Empty)) {
              return false;
            }
          } else if (j == 0 || j == 1) {
            if ((marbleBoard[i + 1][j] == GameSpace.Marble
                && marbleBoard[i + 2][j] == GameSpace.Empty)
                || (marbleBoard[i - 1][j] == GameSpace.Marble
                && marbleBoard[i - 2][j] == GameSpace.Empty)
                || (marbleBoard[i][j + 1] == GameSpace.Marble
                && marbleBoard[i][j + 2] == GameSpace.Empty)) {
              return false;
            }
          } else if ((marbleBoard[i + 1][j] == GameSpace.Marble
              && marbleBoard[i + 2][j] == GameSpace.Empty)
              || (marbleBoard[i - 1][j] == GameSpace.Marble
              && marbleBoard[i - 2][j] == GameSpace.Empty)
              || (marbleBoard[i][j + 1] == GameSpace.Marble
              && marbleBoard[i][j + 2] == GameSpace.Empty)
              || (marbleBoard[i][j - 1] == GameSpace.Marble
              && marbleBoard[i][j - 2] == GameSpace.Empty)) {
            return false;
          }
        }
      }
    }
    return true;
  }

  /**
   * Return a string that represents the current state of the board. The string should have one line
   * per row of the game board. Each slot on the game board is a single GameSpace. Slots in a row
   * should be separated by a space. Each row has no space before the first slot and after the last
   * slot.
   *
   * @return the game state as a string
   */
  @Override
  public String getGameState() {
    String result = "";
    int upperBound = (2 * (armSize - 1));

    for (int i = 0; i < marbleBoard.length; i++) {
      for (int j = 0; j < marbleBoard[i].length; j++) {
        if (j == upperBound && i == marbleBoard.length - 1) {
          return result + marbleBoard[i][j];
        } else if (j == marbleBoard[i].length - 1) {
          result = result + marbleBoard[i][j] + "\n";
        } else if (j >= upperBound && marbleBoard[i][j + 1] == GameSpace.Invalid) {
          result = result + marbleBoard[i][j] + "\n";
          j = marbleBoard[i].length;
        } else {
          result = result + marbleBoard[i][j] + " ";
        }
      }
    }

    return result;
  }

  /**
   * Return the number of marbles currently on the board.
   *
   * @return the number of marbles currently on the board
   */
  @Override
  public int getScore() {
    int score = 0;

    for (int i = 0; i < marbleBoard.length; i++) {
      for (int j = 0; j < marbleBoard[i].length; j++) {
        if (marbleBoard[i][j] == GameSpace.Marble) {
          score++;
        }
      }
    }
    return score;
  }
}
