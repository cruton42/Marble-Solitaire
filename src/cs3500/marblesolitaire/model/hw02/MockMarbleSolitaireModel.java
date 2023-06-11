package cs3500.marblesolitaire.model.hw02;

import java.util.Objects;

/**
 * Mock class used to confirm inputs given to a real model by a MarbleSolitaireController.
 */
public class MockMarbleSolitaireModel implements MarbleSolitaireModel {

  private final StringBuilder log;

  /**
   * Constructs a MockMarbleSolitaireModel.
   *
   * @param log appendable log to be compared to an expected result
   */
  public MockMarbleSolitaireModel(StringBuilder log) {
    this.log = Objects.requireNonNull(log);
  }

  /**
   * Appends received inputs to the log so that it can be compared in the test class.
   *
   * @param fromRow the row number of the position to be moved from (starts at 0)
   * @param fromCol the column number of the position to be moved from (starts at 0)
   * @param toRow   the row number of the position to be moved to (starts at 0)
   * @param toCol   the column number of the position to be moved to (starts at 0)
   */
  @Override
  public void move(int fromRow, int fromCol, int toRow, int toCol) {
    log.append(String.format("fromRow = %d, fromCol = %d, toRow = %d, toCol = %d\n",
        fromRow, fromCol, toRow, toCol));
  }

  /**
   * Does nothing in mock model.
   *
   * @return false
   */
  @Override
  public boolean isGameOver() {
    return false;
  }

  /**
   * Does nothing in mock model.
   *
   * @return null
   */
  @Override
  public String getGameState() {
    return null;
  }

  /**
   * Does nothing in mock model.
   *
   * @return 0
   */
  @Override
  public int getScore() {
    return 0;
  }
}
