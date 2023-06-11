package cs3500.marblesolitaire.model.hw04;

import cs3500.marblesolitaire.model.hw02.GameSpace;

/**
 * Class representing the Model functionality of a European Solitaire game. The game must be
 * constructed with a positive integer for the dimensions, and with a valid open space to begin
 * with. The game board is made up of {@code GameSpace}'s.
 */
public class TriangleSolitaireModelImpl extends AbstractSolitaireModel {

  /**
   * A default constructor that creates a 5-row game with the empty slot at (0,0).
   */
  public TriangleSolitaireModelImpl() {
    super(5, 0, 0);
  }

  /**
   * Constructs a Triangle Solitaire game with the given length for the bottom row.
   *
   * @param dimensions length of the longest row in the game
   */
  public TriangleSolitaireModelImpl(int dimensions) {
    super(dimensions, 0, 0);

  }

  /**
   * Constructs a Triangle Solitaire game with the given starting position.
   *
   * @param sRow row of starting position
   * @param sCol column of starting position
   */
  public TriangleSolitaireModelImpl(int sRow, int sCol) {
    super(5, sRow, sCol);
  }

  /**
   * Constructs a Triangle Solitaire game with the given length for the bottom row and the given
   * starting position.
   *
   * @param dimensions length of the longest row in the game
   * @param sRow       row of starting position
   * @param sCol       column of starting position
   */
  public TriangleSolitaireModelImpl(int dimensions, int sRow, int sCol) {
    super(dimensions, sRow, sCol);
  }

  /**
   * Populates a 2d array for the Triangle Marble Solitaire game.
   *
   * @param armSize dimensions of the array
   * @param sRow    row of starting position
   * @param sCol    column of starting position
   * @return 2d array containing the contents of triangle solitaire
   */
  public GameSpace[][] buildMarbleBoard(int armSize, int sRow,
      int sCol) {
    if (armSize < 1) {
      throw new IllegalArgumentException("Cannot have a game with dimensions < 1.");
    }

    if (sRow < 0 || sCol < 0 || sRow >= armSize
        || sCol >= armSize) {
      throw new IllegalArgumentException(
          "Invalid empty cell position (" + sRow + "," + sCol + ")");
    }

    GameSpace[][] marbleBoard = new GameSpace[armSize][armSize];

    for (int i = 0; i < marbleBoard.length; i++) {
      for (int j = 0; j < marbleBoard[i].length; j++) {
        if (j > i) {
          marbleBoard[i][j] = GameSpace.Invalid;
        } else if (i == sRow && j == sCol) {
          if (marbleBoard[sRow][sCol] == GameSpace.Invalid) {
            throw new IllegalArgumentException(
                "Invalid empty cell position (" + sRow + "," + sCol
                    + ")");
          }
          marbleBoard[i][j] = GameSpace.Empty;
        } else {
          marbleBoard[i][j] = GameSpace.Marble;
        }
      }
    }
    if (marbleBoard[sRow][sCol] == GameSpace.Invalid) {
      throw new IllegalArgumentException(
          "Invalid empty cell position (" + sRow + "," + sCol
              + ")");
    }
    return marbleBoard;
  }

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
    if (fromRow < 0 || fromCol < 0 || toRow < 0 || toCol < 0 || fromRow >= armSize
        || fromCol >= armSize || toRow >= armSize || toCol >= armSize) {
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
    } else if (fromRow == toRow - 2 && fromCol == toCol - 2) {
      if (marbleBoard[fromRow + 1][fromCol + 1] != GameSpace.Marble) {
        throw new IllegalArgumentException("You must jump over a marble!");
      }
    } else if (fromRow == toRow + 2 && fromCol == toCol + 2) {
      if (marbleBoard[fromRow - 1][fromCol - 1] != GameSpace.Marble) {
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
    } else if (fromRow == toRow - 2 && fromCol == toCol - 2) {
      updateBoard(fromRow, fromCol, toRow, toCol, fromRow + 1, fromCol + 1);
    } else if (fromRow == toRow + 2 && fromCol == toCol + 2) {
      updateBoard(fromRow, fromCol, toRow, toCol, fromRow - 1, fromCol - 1);
    } else {
      throw new IllegalArgumentException("This move is not valid!");
    }
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
          if (checkValidMove(i, j)) {
            return false;
          }
        }
      }
    }

    return true;
  }

  /**
   * Method to check if a valid move can be made by the GamePiece at the given coordinates.
   *
   * @param row row of the GamePiece
   * @param col column of the GamePiece
   * @return true if a valid move can be made, false otherwise
   */
  private boolean checkValidMove(int row, int col) {
    if (marbleBoard[row][col] != GameSpace.Marble) {
      return false;
    }

    if (row > marbleBoard.length - 3 && row >= 2) {
      if (col < 2 && marbleBoard.length > 3) {
        return checkMoveUpRight(row, col) || checkMoveRight(row, col);
      } else if (col > marbleBoard[row].length - 3) {
        return checkMoveUpLeft(row, col) || checkMoveLeft(row, col);
      } else if (col == marbleBoard[row].length - 3) {
        return checkMoveUpRight(row, col) || checkMoveRight(row, col);
      } else if (marbleBoard.length > 3) {
        return checkMoveUpRight(row, col) || checkMoveRight(row, col)
            || checkMoveUpLeft(row, col) || checkMoveLeft(row, col);
      } else {
        return false;
      }

    } else if (col < 2 && row <= marbleBoard.length - 3) {

      if (row < 2) {
        return checkMoveDownLeft(row, col) || checkMoveDownRight(row, col);
      } else if (row > marbleBoard.length - 3) {
        return checkMoveUpRight(row, col) || checkMoveRight(row, col);
      } else {
        return checkMoveUpRight(row, col) || checkMoveRight(row, col)
            || checkMoveDownLeft(row, col);
      }

    } else if ((marbleBoard[row][col + 1] == GameSpace.Invalid
        || marbleBoard[row][col + 2] == GameSpace.Invalid)
        && row <= marbleBoard.length - 3
        && row >= 2) {

      if (row > marbleBoard.length - 3) {
        return checkMoveUpLeft(row, col) || checkMoveLeft(row, col);
      } else {
        return checkMoveUpLeft(row, col) || checkMoveLeft(row, col)
            || checkMoveDownRight(row, col);
      }

    } else if (!(marbleBoard[row][col + 1] == GameSpace.Invalid
        || marbleBoard[row][col + 2] == GameSpace.Invalid) && row <= marbleBoard.length - 3
        && row >= 2) {
      return checkMoveDownLeft(row, col) || checkMoveDownRight(row, col) || checkMoveUpLeft(row,
          col)
          || checkMoveUpRight(row, col) || checkMoveLeft(row, col) || checkMoveRight(row, col);
    } else {
      return false;
    }
  }

  /**
   * Checks if a move can be made to the right.
   *
   * @param row row of the GamePiece
   * @param col column of the GamePiece
   * @return true if a valid move can be made, false otherwise
   */
  private boolean checkMoveRight(int row, int col) {
    return (marbleBoard[row][col + 1] == GameSpace.Marble
        && marbleBoard[row][col + 2] == GameSpace.Empty);
  }

  /**
   * Checks if a move can be made to the left.
   *
   * @param row row of the GamePiece
   * @param col column of the GamePiece
   * @return true if a valid move can be made, false otherwise
   */
  private boolean checkMoveLeft(int row, int col) {
    return (marbleBoard[row][col - 1] == GameSpace.Marble
        && marbleBoard[row][col - 2] == GameSpace.Empty);
  }

  /**
   * Checks if a move can be made up and to the right.
   *
   * @param row row of the GamePiece
   * @param col column of the GamePiece
   * @return true if a valid move can be made, false otherwise
   */
  private boolean checkMoveUpRight(int row, int col) {
    return (marbleBoard[row - 1][col] == GameSpace.Marble
        && marbleBoard[row - 2][col] == GameSpace.Empty);
  }

  /**
   * Checks if a move can be made up and to the left.
   *
   * @param row row of the GamePiece
   * @param col column of the GamePiece
   * @return true if a valid move can be made, false otherwise
   */
  private boolean checkMoveUpLeft(int row, int col) {
    return (marbleBoard[row - 1][col - 1] == GameSpace.Marble
        && marbleBoard[row - 2][col - 2] == GameSpace.Empty);
  }

  /**
   * Checks if a move can be made down and to the right.
   *
   * @param row row of the GamePiece
   * @param col column of the GamePiece
   * @return true if a valid move can be made, false otherwise
   */
  private boolean checkMoveDownRight(int row, int col) {
    return (marbleBoard[row + 1][col + 1] == GameSpace.Marble
        && marbleBoard[row + 2][col + 2] == GameSpace.Empty);
  }

  /**
   * Checks if a move can be made down and to the left.
   *
   * @param row row of the GamePiece
   * @param col column of the GamePiece
   * @return true if a valid move can be made, false otherwise
   */
  private boolean checkMoveDownLeft(int row, int col) {
    return (marbleBoard[row + 1][col] == GameSpace.Marble
        && marbleBoard[row + 2][col] == GameSpace.Empty);
  }

  /**
   * Return a string that represents the current state of the board. The string should have one line
   * per row of the game board. Each slot on the game board is a single GameSpace. Slots in a row
   * should be separated by a space.
   *
   * @return the game state as a string
   */
  @Override
  public String getGameState() {

    StringBuilder result = new StringBuilder();
    int countDown = armSize - 1;

    for (int i = 0; i < marbleBoard.length; i++) {

      result.append(" ".repeat(Math.max(0, countDown)));
      for (int j = 0; j < marbleBoard[i].length; j++) {
        if (i == marbleBoard.length - 1 && j == marbleBoard[i].length - 1) {
          result.append(marbleBoard[i][j].getState());
        } else if (marbleBoard[i][j + 1] == GameSpace.Invalid) {
          result.append(marbleBoard[i][j].getState()).append("\n");
          j = marbleBoard[i].length;
        } else {
          result.append(marbleBoard[i][j].getState()).append(" ");
        }
      }
      countDown--;
    }

    return result.toString();
  }
}
