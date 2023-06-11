package cs3500.marblesolitaire.model.hw02;

/**
 * Represents a space in the Marble Solitaire Board.
 */
public enum GameSpace {
  Marble('O'), Empty('_'), Invalid(' ');

  private final char state;

  /**
   * Constructs a GameSpace either as a marble, empty, or invalid space.
   * @param state Character representing the state of a GameSpace
   */
  GameSpace(char state) {
    this.state = state;
  }

  /**
   * Gets the state of this GameSpace as a {@code char}.
   * @return the state of this GameSpace as a {@code char}.
   */
  public char getState() {
    return this.state;
  }

  /**
   * Overrides toString method to return the state of this GameSpace as a string.
   * @return the state of this GameSpace as a string.
   */
  @Override
  public String toString() {
    return this.state + "";
  }
}
