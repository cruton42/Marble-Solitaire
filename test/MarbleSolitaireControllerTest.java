import static org.junit.Assert.assertEquals;

import cs3500.marblesolitaire.controller.MarbleSolitaireController;
import cs3500.marblesolitaire.controller.MarbleSolitaireControllerImpl;
import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModel;
import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModelImpl;
import cs3500.marblesolitaire.model.hw02.MockMarbleSolitaireModel;
import java.io.StringReader;
import org.junit.Test;

/**
 * Test class for MarbleSolitaireController and its implementation.
 */
public class MarbleSolitaireControllerTest {

  @Test
  public void testConfirmMoveInputs() {
    StringReader in = new StringReader("4 2 4 4");
    StringBuilder out = new StringBuilder();

    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(in, out);
    StringBuilder log = new StringBuilder();
    MarbleSolitaireModel mockModel = new MockMarbleSolitaireModel(log);

    try {
      controller.playGame(mockModel);
    } catch (IllegalStateException ise) {
      assertEquals("fromRow = 3, fromCol = 1, toRow = 3, toCol = 3\n", log.toString());
    }
  }

  @Test
  public void testConfirmMoveInputs2() {
    StringReader in = new StringReader("5 3 5 1");
    StringBuilder out = new StringBuilder();

    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(in, out);
    StringBuilder log = new StringBuilder();
    MarbleSolitaireModel mockModel = new MockMarbleSolitaireModel(log);

    try {
      controller.playGame(mockModel);
    } catch (IllegalStateException ise) {
      assertEquals("fromRow = 4, fromCol = 2, toRow = 4, toCol = 0\n", log.toString());
    }
  }

  @Test
  public void testWinningGame() {
    MarbleSolitaireModel m = new MarbleSolitaireModelImpl();
    StringReader input = new StringReader(
        "4 6 4 4 2 5 4 5 3 7 3 5 5 7 3 7 3 4 3 6 3 7 3 5 3 2 3 4 1 3 3 3 1 5 1 3 4 3 2 3 1 3 3 3"
            + " 6 3 4 3 5 1 5 3 3 1 5 1 5 4 5 2 5 1 5 3 5 6 5 4 7 5 5 5 7 3 7 5 4 5 6 5 7 5 5 5 4 3"
            + " 2 3 2 3 2 5 2 5 4 5 4 5 6 5 6 5 6 3 6 3 4 3 4 4 2 4 4 2 4 4 5 4 3 4 2 4 4 4");
    StringBuilder gameLog = new StringBuilder();
    MarbleSolitaireController c = new MarbleSolitaireControllerImpl(input, gameLog);
    c.playGame(m);
    String[] lines = gameLog.toString().split("\n");
    assertEquals(257, lines.length);
    assertEquals("Game over!", lines[lines.length - 9]);
    assertEquals("Score: 1", lines[lines.length - 1]);
  }

  @Test
  public void testQuitBeforeWinningGame() {
    MarbleSolitaireModel m = new MarbleSolitaireModelImpl();
    StringReader input = new StringReader(
        "4 6 4 4 2 5 4 5 3 7 3 5 5 7 3 7 3 4 3 6 3 7 3 5 3 2 3 4 1 3 3 3 1 5 1 3 4 3 2 3 1 3 3 3"
            + " 6 3 4 3 5 1 5 3 3 1 5 1 5 4 5 2 5 1 5 3 5 6 5 4 7 5 5 5 7 3 7 5 4 5 6 5 7 5 5 5 4 3"
            + " 2 3 2 3 2 5 2 5 4 5 4 5 6 5 6 5 6 3 6 3 4 3 4 4 2 4 4 2 4 4 5 4 3 4 2 4 4 q 4");
    StringBuilder gameLog = new StringBuilder();
    MarbleSolitaireController c = new MarbleSolitaireControllerImpl(input, gameLog);
    c.playGame(m);
    String[] lines = gameLog.toString().split("\n");
    assertEquals(258, lines.length);
    assertEquals("Game quit!", lines[lines.length - 10]);
    assertEquals("State of game when quit:", lines[lines.length - 9]);
    assertEquals("Score: 2", lines[lines.length - 1]);
  }

  /**
   * Should have same results as {@code testWinningGame()} because the controller should not parse
   * the last {@code 'q'}.
   */
  @Test
  public void testQuitAfterWinningGame() {
    MarbleSolitaireModel m = new MarbleSolitaireModelImpl();
    StringReader input = new StringReader(
        "4 6 4 4 2 5 4 5 3 7 3 5 5 7 3 7 3 4 3 6 3 7 3 5 3 2 3 4 1 3 3 3 1 5 1 3 4 3 2 3 1 3 3 3"
            + " 6 3 4 3 5 1 5 3 3 1 5 1 5 4 5 2 5 1 5 3 5 6 5 4 7 5 5 5 7 3 7 5 4 5 6 5 7 5 5 5 4 3"
            + " 2 3 2 3 2 5 2 5 4 5 4 5 6 5 6 5 6 3 6 3 4 3 4 4 2 4 4 2 4 4 5 4 3 4 2 4 4 4 q");
    StringBuilder gameLog = new StringBuilder();
    MarbleSolitaireController c = new MarbleSolitaireControllerImpl(input, gameLog);
    c.playGame(m);
    String[] lines = gameLog.toString().split("\n");
    assertEquals(257, lines.length);
    assertEquals("Game over!", lines[lines.length - 9]);
    assertEquals("Score: 1", lines[lines.length - 1]);
  }

  @Test
  public void testLosingGame() {
    MarbleSolitaireModel m = new MarbleSolitaireModelImpl();
    StringReader input = new StringReader(
        "4 6 4 4 2 5 4 5 3 7 3 5 5 7 3 7 3 4 3 6 3 7 3 5 3 2 3 4 1 3 3 3 1 5 1 3 4 3 2 3 1 3 3 3"
            + " 6 3 4 3 5 1 5 3 3 1 5 1 5 4 5 2 5 1 5 3 5 6 5 4 7 5 5 5 7 3 7 5 4 5 6 5 7 5 5 5 4 3"
            + " 2 3 2 3 2 5 2 5 4 5 4 5 6 5 6 5 6 3 6 3 4 3 4 3 4 5");
    StringBuilder gameLog = new StringBuilder();
    MarbleSolitaireController c = new MarbleSolitaireControllerImpl(input, gameLog);
    c.playGame(m);
    String[] lines = gameLog.toString().split("\n");
    assertEquals(233, lines.length);
    assertEquals("Game over!", lines[lines.length - 9]);
    assertEquals("Score: 4", lines[lines.length - 1]);
  }

  @Test
  public void testQuitBeforeLosingGame() {
    MarbleSolitaireModel m = new MarbleSolitaireModelImpl();
    StringReader input = new StringReader(
        "4 6 4 4 2 5 4 5 3 7 3 5 5 7 3 7 3 4 3 6 3 7 3 5 3 2 3 4 1 3 3 3 1 5 1 3 4 3 2 3 1 3 3 3"
            + " 6 3 4 3 5 1 5 3 3 1 5 1 5 4 5 2 5 1 5 3 5 6 5 4 7 5 5 5 7 3 7 5 4 5 6 5 7 5 5 5 4 3"
            + " 2 3 2 3 2 5 2 5 4 5 4 5 6 5 6 5 6 3 6 3 4 3 4 3 4 q 5");
    StringBuilder gameLog = new StringBuilder();
    MarbleSolitaireController c = new MarbleSolitaireControllerImpl(input, gameLog);
    c.playGame(m);
    String[] lines = gameLog.toString().split("\n");
    assertEquals(234, lines.length);
    assertEquals("Game quit!", lines[lines.length - 10]);
    assertEquals("State of game when quit:", lines[lines.length - 9]);
    assertEquals("Score: 5", lines[lines.length - 1]);
  }

  /**
   * Should have same results as {@code testWinningGame()} because the controller should not parse
   * the last {@code 'q'}.
   */
  @Test
  public void testQuitAfterLosingGame() {
    MarbleSolitaireModel m = new MarbleSolitaireModelImpl();
    StringReader input = new StringReader(
        "4 6 4 4 2 5 4 5 3 7 3 5 5 7 3 7 3 4 3 6 3 7 3 5 3 2 3 4 1 3 3 3 1 5 1 3 4 3 2 3 1 3 3 3"
            + " 6 3 4 3 5 1 5 3 3 1 5 1 5 4 5 2 5 1 5 3 5 6 5 4 7 5 5 5 7 3 7 5 4 5 6 5 7 5 5 5 4 3"
            + " 2 3 2 3 2 5 2 5 4 5 4 5 6 5 6 5 6 3 6 3 4 3 4 3 4 5 q");
    StringBuilder gameLog = new StringBuilder();
    MarbleSolitaireController c = new MarbleSolitaireControllerImpl(input, gameLog);
    c.playGame(m);
    String[] lines = gameLog.toString().split("\n");
    assertEquals(233, lines.length);
    assertEquals("Game over!", lines[lines.length - 9]);
    assertEquals("Score: 4", lines[lines.length - 1]);
  }

  @Test
  public void testQuitNewGame() {
    MarbleSolitaireModel m = new MarbleSolitaireModelImpl();
    StringReader input = new StringReader("q");
    StringBuilder gameLog = new StringBuilder();
    MarbleSolitaireController c = new MarbleSolitaireControllerImpl(input, gameLog);
    c.playGame(m);
    String[] lines = gameLog.toString().split("\n");
    assertEquals("    O O O\n"
        + "    O O O\n"
        + "O O O O O O O\n"
        + "O O O _ O O O\n"
        + "O O O O O O O\n"
        + "    O O O\n"
        + "    O O O\n"
        + "Score: 32\n"
        + "Game quit!\n"
        + "State of game when quit:\n"
        + "    O O O\n"
        + "    O O O\n"
        + "O O O O O O O\n"
        + "O O O _ O O O\n"
        + "O O O O O O O\n"
        + "    O O O\n"
        + "    O O O\n"
        + "Score: 32\n", gameLog.toString());
    assertEquals("Score: 32", lines[lines.length - 1]);
  }

  @Test
  public void testQuitNewGameBigQ() {
    MarbleSolitaireModel m = new MarbleSolitaireModelImpl();
    StringReader input = new StringReader("Q");
    StringBuilder gameLog = new StringBuilder();
    MarbleSolitaireController c = new MarbleSolitaireControllerImpl(input, gameLog);
    c.playGame(m);
    String[] lines = gameLog.toString().split("\n");
    assertEquals("    O O O\n"
        + "    O O O\n"
        + "O O O O O O O\n"
        + "O O O _ O O O\n"
        + "O O O O O O O\n"
        + "    O O O\n"
        + "    O O O\n"
        + "Score: 32\n"
        + "Game quit!\n"
        + "State of game when quit:\n"
        + "    O O O\n"
        + "    O O O\n"
        + "O O O O O O O\n"
        + "O O O _ O O O\n"
        + "O O O O O O O\n"
        + "    O O O\n"
        + "    O O O\n"
        + "Score: 32\n", gameLog.toString());
    assertEquals("Score: 32", lines[lines.length - 1]);
  }

  @Test
  public void testQuitInvalidMoveFromPos() {
    MarbleSolitaireModel m = new MarbleSolitaireModelImpl();
    StringReader input = new StringReader("4 4 4 2 q");
    StringBuilder gameLog = new StringBuilder();
    MarbleSolitaireController c = new MarbleSolitaireControllerImpl(input, gameLog);
    c.playGame(m);
    String[] lines = gameLog.toString().split("\n");
    assertEquals("    O O O\n"
        + "    O O O\n"
        + "O O O O O O O\n"
        + "O O O _ O O O\n"
        + "O O O O O O O\n"
        + "    O O O\n"
        + "    O O O\n"
        + "Score: 32\n"
        + "Invalid move. Play again. The from position is not valid!\n"
        + "Game quit!\n"
        + "State of game when quit:\n"
        + "    O O O\n"
        + "    O O O\n"
        + "O O O O O O O\n"
        + "O O O _ O O O\n"
        + "O O O O O O O\n"
        + "    O O O\n"
        + "    O O O\n"
        + "Score: 32\n", gameLog.toString());
    assertEquals("Score: 32", lines[lines.length - 1]);
  }

  @Test
  public void testQuitInvalidMoveFromPos2() {
    MarbleSolitaireModel m = new MarbleSolitaireModelImpl();
    StringReader input = new StringReader("4 2 4 4 4 2 4 4 q");
    StringBuilder gameLog = new StringBuilder();
    MarbleSolitaireController c = new MarbleSolitaireControllerImpl(input, gameLog);
    c.playGame(m);
    String[] lines = gameLog.toString().split("\n");
    assertEquals("    O O O\n"
        + "    O O O\n"
        + "O O O O O O O\n"
        + "O O O _ O O O\n"
        + "O O O O O O O\n"
        + "    O O O\n"
        + "    O O O\n"
        + "Score: 32\n"
        + "    O O O\n"
        + "    O O O\n"
        + "O O O O O O O\n"
        + "O _ _ O O O O\n"
        + "O O O O O O O\n"
        + "    O O O\n"
        + "    O O O\n"
        + "Score: 31\n"
        + "Invalid move. Play again. The from position is not valid!\n"
        + "Game quit!\n"
        + "State of game when quit:\n"
        + "    O O O\n"
        + "    O O O\n"
        + "O O O O O O O\n"
        + "O _ _ O O O O\n"
        + "O O O O O O O\n"
        + "    O O O\n"
        + "    O O O\n"
        + "Score: 31\n", gameLog.toString());
    assertEquals("Score: 31", lines[lines.length - 1]);
  }

  @Test
  public void testQuitInvalidMoveToPos() {
    MarbleSolitaireModel m = new MarbleSolitaireModelImpl();
    StringReader input = new StringReader("4 3 4 5 q");
    StringBuilder gameLog = new StringBuilder();
    MarbleSolitaireController c = new MarbleSolitaireControllerImpl(input, gameLog);
    c.playGame(m);
    String[] lines = gameLog.toString().split("\n");
    assertEquals("    O O O\n"
        + "    O O O\n"
        + "O O O O O O O\n"
        + "O O O _ O O O\n"
        + "O O O O O O O\n"
        + "    O O O\n"
        + "    O O O\n"
        + "Score: 32\n"
        + "Invalid move. Play again. The to position is not valid!\n"
        + "Game quit!\n"
        + "State of game when quit:\n"
        + "    O O O\n"
        + "    O O O\n"
        + "O O O O O O O\n"
        + "O O O _ O O O\n"
        + "O O O O O O O\n"
        + "    O O O\n"
        + "    O O O\n"
        + "Score: 32\n", gameLog.toString());
    assertEquals("Score: 32", lines[lines.length - 1]);
  }

  @Test
  public void testValidMoveAfterInvalid() {
    MarbleSolitaireModel m = new MarbleSolitaireModelImpl();
    StringReader input = new StringReader("4 6 4 4 2 5 5 5 2 5 4 5");
    StringBuilder gameLog = new StringBuilder();
    MarbleSolitaireController c = new MarbleSolitaireControllerImpl(input, gameLog);
    try {
      c.playGame(m);
    } catch (IllegalStateException ise) {
      //Asserts that we are getting the correct ISE so that we can test unfinished games
      assertEquals("Readable is out of inputs", ise.getMessage());
      String[] lines = gameLog.toString().split("\n");
      assertEquals("    O O O\n"
          + "    O O O\n"
          + "O O O O O O O\n"
          + "O O O _ O O O\n"
          + "O O O O O O O\n"
          + "    O O O\n"
          + "    O O O\n"
          + "Score: 32\n"
          + "    O O O\n"
          + "    O O O\n"
          + "O O O O O O O\n"
          + "O O O O _ _ O\n"
          + "O O O O O O O\n"
          + "    O O O\n"
          + "    O O O\n"
          + "Score: 31\n"
          + "Invalid move. Play again. The to position is not valid!\n"
          + "    O O O\n"
          + "    O O _\n"
          + "O O O O _ O O\n"
          + "O O O O O _ O\n"
          + "O O O O O O O\n"
          + "    O O O\n"
          + "    O O O\n"
          + "Score: 30\n", gameLog.toString());
      assertEquals("Score: 30", lines[lines.length - 1]);
    }
  }

  @Test
  public void testValidMoveAfterTwoInvalid() {
    MarbleSolitaireModel m = new MarbleSolitaireModelImpl();
    StringReader input = new StringReader("4 6 4 4 2 5 5 5 5 5 2 5 2 5 4 5");
    StringBuilder gameLog = new StringBuilder();
    MarbleSolitaireController c = new MarbleSolitaireControllerImpl(input, gameLog);
    try {
      c.playGame(m);
    } catch (IllegalStateException ise) {
      //Asserts that we are getting the correct ISE so that we can test unfinished games
      assertEquals("Readable is out of inputs", ise.getMessage());
      String[] lines = gameLog.toString().split("\n");
      assertEquals("    O O O\n"
          + "    O O O\n"
          + "O O O O O O O\n"
          + "O O O _ O O O\n"
          + "O O O O O O O\n"
          + "    O O O\n"
          + "    O O O\n"
          + "Score: 32\n"
          + "    O O O\n"
          + "    O O O\n"
          + "O O O O O O O\n"
          + "O O O O _ _ O\n"
          + "O O O O O O O\n"
          + "    O O O\n"
          + "    O O O\n"
          + "Score: 31\n"
          + "Invalid move. Play again. The to position is not valid!\n"
          + "Invalid move. Play again. The to position is not valid!\n"
          + "    O O O\n"
          + "    O O _\n"
          + "O O O O _ O O\n"
          + "O O O O O _ O\n"
          + "O O O O O O O\n"
          + "    O O O\n"
          + "    O O O\n"
          + "Score: 30\n", gameLog.toString());
      assertEquals("Score: 30", lines[lines.length - 1]);
    }
  }

  @Test
  public void testValidMoveOutOfArray() {
    MarbleSolitaireModel m = new MarbleSolitaireModelImpl();
    StringReader input = new StringReader("-1 4 1 4 q");
    StringBuilder gameLog = new StringBuilder();
    MarbleSolitaireController c = new MarbleSolitaireControllerImpl(input, gameLog);
    try {
      c.playGame(m);
    } catch (IllegalStateException ise) {
      //Asserts that we are getting the correct ISE so that we can test unfinished games
      assertEquals("Readable is out of inputs", ise.getMessage());
      String[] lines = gameLog.toString().split("\n");
      assertEquals("    O O O\n"
          + "    O O O\n"
          + "O O O O O O O\n"
          + "O O O _ O O O\n"
          + "O O O O O O O\n"
          + "    O O O\n"
          + "    O O O\n"
          + "Score: 32\n"
          + "Invalid move. Play again. You're numbers aren't within our array index!\n"
          + "Game quit!\n"
          + "State of game when quit:\n"
          + "    O O O\n"
          + "    O O O\n"
          + "O O O O O O O\n"
          + "O O O _ O O O\n"
          + "O O O O O O O\n"
          + "    O O O\n"
          + "    O O O\n"
          + "Score: 32\n", gameLog.toString());
      assertEquals("Score: 32", lines[lines.length - 1]);
    }
  }

  @Test
  public void testValidMoveOutOfArrayTo() {
    MarbleSolitaireModel m = new MarbleSolitaireModelImpl();
    StringReader input = new StringReader("4 2 1 20");
    StringBuilder gameLog = new StringBuilder();
    MarbleSolitaireController c = new MarbleSolitaireControllerImpl(input, gameLog);
    try {
      c.playGame(m);
    } catch (IllegalStateException ise) {
      //Asserts that we are getting the correct ISE so that we can test unfinished games
      assertEquals("Readable is out of inputs", ise.getMessage());
      String[] lines = gameLog.toString().split("\n");
      assertEquals("    O O O\n"
              + "    O O O\n"
              + "O O O O O O O\n"
              + "O O O _ O O O\n"
              + "O O O O O O O\n"
              + "    O O O\n"
              + "    O O O\n"
              + "Score: 32\n"
              + "Invalid move. Play again. You're numbers aren't within our array index!\n",
          gameLog.toString());
      assertEquals("Invalid move. Play again. "
              + "You're numbers aren't within our array index!",
          lines[lines.length - 1]);
    }
  }

  @Test
  public void testQuitFromRow() {
    MarbleSolitaireModel m = new MarbleSolitaireModelImpl();
    StringReader input = new StringReader("4 6 4 4 q 2 5 4");
    StringBuilder gameLog = new StringBuilder();
    MarbleSolitaireController c = new MarbleSolitaireControllerImpl(input, gameLog);
    c.playGame(m);
    String[] lines = gameLog.toString().split("\n");
    assertEquals("    O O O\n"
        + "    O O O\n"
        + "O O O O O O O\n"
        + "O O O _ O O O\n"
        + "O O O O O O O\n"
        + "    O O O\n"
        + "    O O O\n"
        + "Score: 32\n"
        + "    O O O\n"
        + "    O O O\n"
        + "O O O O O O O\n"
        + "O O O O _ _ O\n"
        + "O O O O O O O\n"
        + "    O O O\n"
        + "    O O O\n"
        + "Score: 31\n"
        + "Game quit!\n"
        + "State of game when quit:\n"
        + "    O O O\n"
        + "    O O O\n"
        + "O O O O O O O\n"
        + "O O O O _ _ O\n"
        + "O O O O O O O\n"
        + "    O O O\n"
        + "    O O O\n"
        + "Score: 31\n", gameLog.toString());
    assertEquals("Score: 31", lines[lines.length - 1]);
  }

  @Test
  public void testQuitFromCol() {
    MarbleSolitaireModel m = new MarbleSolitaireModelImpl();
    StringReader input = new StringReader("4 6 4 4 2 q 4 5");
    StringBuilder gameLog = new StringBuilder();
    MarbleSolitaireController c = new MarbleSolitaireControllerImpl(input, gameLog);
    c.playGame(m);
    String[] lines = gameLog.toString().split("\n");
    assertEquals("    O O O\n"
        + "    O O O\n"
        + "O O O O O O O\n"
        + "O O O _ O O O\n"
        + "O O O O O O O\n"
        + "    O O O\n"
        + "    O O O\n"
        + "Score: 32\n"
        + "    O O O\n"
        + "    O O O\n"
        + "O O O O O O O\n"
        + "O O O O _ _ O\n"
        + "O O O O O O O\n"
        + "    O O O\n"
        + "    O O O\n"
        + "Score: 31\n"
        + "Game quit!\n"
        + "State of game when quit:\n"
        + "    O O O\n"
        + "    O O O\n"
        + "O O O O O O O\n"
        + "O O O O _ _ O\n"
        + "O O O O O O O\n"
        + "    O O O\n"
        + "    O O O\n"
        + "Score: 31\n", gameLog.toString());
    assertEquals("Score: 31", lines[lines.length - 1]);
  }

  @Test
  public void testQuitToRow() {
    MarbleSolitaireModel m = new MarbleSolitaireModelImpl();
    StringReader input = new StringReader("4 6 4 4 2 5 q 5");
    StringBuilder gameLog = new StringBuilder();
    MarbleSolitaireController c = new MarbleSolitaireControllerImpl(input, gameLog);
    c.playGame(m);
    String[] lines = gameLog.toString().split("\n");
    assertEquals("    O O O\n"
        + "    O O O\n"
        + "O O O O O O O\n"
        + "O O O _ O O O\n"
        + "O O O O O O O\n"
        + "    O O O\n"
        + "    O O O\n"
        + "Score: 32\n"
        + "    O O O\n"
        + "    O O O\n"
        + "O O O O O O O\n"
        + "O O O O _ _ O\n"
        + "O O O O O O O\n"
        + "    O O O\n"
        + "    O O O\n"
        + "Score: 31\n"
        + "Game quit!\n"
        + "State of game when quit:\n"
        + "    O O O\n"
        + "    O O O\n"
        + "O O O O O O O\n"
        + "O O O O _ _ O\n"
        + "O O O O O O O\n"
        + "    O O O\n"
        + "    O O O\n"
        + "Score: 31\n", gameLog.toString());
    assertEquals("Score: 31", lines[lines.length - 1]);
  }

  @Test
  public void testQuitToCol() {
    MarbleSolitaireModel m = new MarbleSolitaireModelImpl();
    StringReader input = new StringReader("4 6 4 4 2 5 4 q");
    StringBuilder gameLog = new StringBuilder();
    MarbleSolitaireController c = new MarbleSolitaireControllerImpl(input, gameLog);
    c.playGame(m);
    String[] lines = gameLog.toString().split("\n");
    assertEquals("    O O O\n"
        + "    O O O\n"
        + "O O O O O O O\n"
        + "O O O _ O O O\n"
        + "O O O O O O O\n"
        + "    O O O\n"
        + "    O O O\n"
        + "Score: 32\n"
        + "    O O O\n"
        + "    O O O\n"
        + "O O O O O O O\n"
        + "O O O O _ _ O\n"
        + "O O O O O O O\n"
        + "    O O O\n"
        + "    O O O\n"
        + "Score: 31\n"
        + "Game quit!\n"
        + "State of game when quit:\n"
        + "    O O O\n"
        + "    O O O\n"
        + "O O O O O O O\n"
        + "O O O O _ _ O\n"
        + "O O O O O O O\n"
        + "    O O O\n"
        + "    O O O\n"
        + "Score: 31\n", gameLog.toString());
    assertEquals("Score: 31", lines[lines.length - 1]);
  }

  @Test
  public void testInvalidFromRow() {
    MarbleSolitaireModel m = new MarbleSolitaireModelImpl();
    StringReader input = new StringReader("!#$ 4 2 4 4");
    StringBuilder gameLog = new StringBuilder();
    MarbleSolitaireController c = new MarbleSolitaireControllerImpl(input, gameLog);
    try {
      c.playGame(m);
    } catch (IllegalStateException ise) {
      //Asserts that we are getting the correct ISE so that we can test unfinished games
      assertEquals("Readable is out of inputs", ise.getMessage());
      String[] lines = gameLog.toString().split("\n");
      assertEquals("    O O O\n"
          + "    O O O\n"
          + "O O O O O O O\n"
          + "O O O _ O O O\n"
          + "O O O O O O O\n"
          + "    O O O\n"
          + "    O O O\n"
          + "Score: 32\n"
          + "Please enter a positive integer:\n"
          + "    O O O\n"
          + "    O O O\n"
          + "O O O O O O O\n"
          + "O _ _ O O O O\n"
          + "O O O O O O O\n"
          + "    O O O\n"
          + "    O O O\n"
          + "Score: 31\n", gameLog.toString());
      assertEquals("Score: 31", lines[lines.length - 1]);
    }
  }

  @Test
  public void testManyInvalidFromRow() {
    StringReader in = new StringReader("!#$ kGb def 5 3 5 1");
    StringBuilder out = new StringBuilder();

    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(in, out);
    StringBuilder log = new StringBuilder();
    MarbleSolitaireModel mockModel = new MockMarbleSolitaireModel(log);

    try {
      controller.playGame(mockModel);
    } catch (IllegalStateException ise) {
      assertEquals("fromRow = 4, fromCol = 2, toRow = 4, toCol = 0\n", log.toString());
    }
  }

  @Test
  public void testInvalidFromCol() {
    MarbleSolitaireModel m = new MarbleSolitaireModelImpl();
    StringReader input = new StringReader("4 !#$ 2 4 4");
    StringBuilder gameLog = new StringBuilder();
    MarbleSolitaireController c = new MarbleSolitaireControllerImpl(input, gameLog);
    try {
      c.playGame(m);
    } catch (IllegalStateException ise) {
      //Asserts that we are getting the correct ISE so that we can test unfinished games
      assertEquals("Readable is out of inputs", ise.getMessage());
      String[] lines = gameLog.toString().split("\n");
      assertEquals("    O O O\n"
          + "    O O O\n"
          + "O O O O O O O\n"
          + "O O O _ O O O\n"
          + "O O O O O O O\n"
          + "    O O O\n"
          + "    O O O\n"
          + "Score: 32\n"
          + "Please enter a positive integer:\n"
          + "    O O O\n"
          + "    O O O\n"
          + "O O O O O O O\n"
          + "O _ _ O O O O\n"
          + "O O O O O O O\n"
          + "    O O O\n"
          + "    O O O\n"
          + "Score: 31\n", gameLog.toString());
      assertEquals("Score: 31", lines[lines.length - 1]);
    }
  }

  @Test
  public void testManyInvalidFromCol() {
    StringReader in = new StringReader("5 !#$ kGb def 3 5 1");
    StringBuilder out = new StringBuilder();

    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(in, out);
    StringBuilder log = new StringBuilder();
    MarbleSolitaireModel mockModel = new MockMarbleSolitaireModel(log);

    try {
      controller.playGame(mockModel);
    } catch (IllegalStateException ise) {
      assertEquals("fromRow = 4, fromCol = 2, toRow = 4, toCol = 0\n", log.toString());
    }
  }

  @Test
  public void testInvalidToRow() {
    MarbleSolitaireModel m = new MarbleSolitaireModelImpl();
    StringReader input = new StringReader("4 2 !#$ 4 4");
    StringBuilder gameLog = new StringBuilder();
    MarbleSolitaireController c = new MarbleSolitaireControllerImpl(input, gameLog);
    try {
      c.playGame(m);
    } catch (IllegalStateException ise) {
      //Asserts that we are getting the correct ISE so that we can test unfinished games
      assertEquals("Readable is out of inputs", ise.getMessage());
      String[] lines = gameLog.toString().split("\n");
      assertEquals("    O O O\n"
          + "    O O O\n"
          + "O O O O O O O\n"
          + "O O O _ O O O\n"
          + "O O O O O O O\n"
          + "    O O O\n"
          + "    O O O\n"
          + "Score: 32\n"
          + "Please enter a positive integer:\n"
          + "    O O O\n"
          + "    O O O\n"
          + "O O O O O O O\n"
          + "O _ _ O O O O\n"
          + "O O O O O O O\n"
          + "    O O O\n"
          + "    O O O\n"
          + "Score: 31\n", gameLog.toString());
      assertEquals("Score: 31", lines[lines.length - 1]);
    }
  }

  @Test
  public void testManyInvalidToRow() {
    StringReader in = new StringReader("5 3 !#$ kGb def 5 1");
    StringBuilder out = new StringBuilder();

    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(in, out);
    StringBuilder log = new StringBuilder();
    MarbleSolitaireModel mockModel = new MockMarbleSolitaireModel(log);

    try {
      controller.playGame(mockModel);
    } catch (IllegalStateException ise) {
      assertEquals("fromRow = 4, fromCol = 2, toRow = 4, toCol = 0\n", log.toString());
    }
  }

  @Test
  public void testInvalidToCol() {
    MarbleSolitaireModel m = new MarbleSolitaireModelImpl();
    StringReader input = new StringReader("4 2 4 !#$ 4");
    StringBuilder gameLog = new StringBuilder();
    MarbleSolitaireController c = new MarbleSolitaireControllerImpl(input, gameLog);
    try {
      c.playGame(m);
    } catch (IllegalStateException ise) {
      //Asserts that we are getting the correct ISE so that we can test unfinished games
      assertEquals("Readable is out of inputs", ise.getMessage());
      String[] lines = gameLog.toString().split("\n");
      assertEquals("    O O O\n"
          + "    O O O\n"
          + "O O O O O O O\n"
          + "O O O _ O O O\n"
          + "O O O O O O O\n"
          + "    O O O\n"
          + "    O O O\n"
          + "Score: 32\n"
          + "Please enter a positive integer:\n"
          + "    O O O\n"
          + "    O O O\n"
          + "O O O O O O O\n"
          + "O _ _ O O O O\n"
          + "O O O O O O O\n"
          + "    O O O\n"
          + "    O O O\n"
          + "Score: 31\n", gameLog.toString());
      assertEquals("Score: 31", lines[lines.length - 1]);
    }
  }

  @Test
  public void testManyInvalidToCol() {
    StringReader in = new StringReader("5 3 5 !#$ kGb def 1");
    StringBuilder out = new StringBuilder();

    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(in, out);
    StringBuilder log = new StringBuilder();
    MarbleSolitaireModel mockModel = new MockMarbleSolitaireModel(log);

    try {
      controller.playGame(mockModel);
    } catch (IllegalStateException ise) {
      assertEquals("fromRow = 4, fromCol = 2, toRow = 4, toCol = 0\n", log.toString());
    }
  }

  @Test
  public void testManyInvalidPrintErrors() {
    MarbleSolitaireModel m = new MarbleSolitaireModelImpl();
    StringReader input = new StringReader("4 2 4 !#$ kGb def 4");
    StringBuilder gameLog = new StringBuilder();
    MarbleSolitaireController c = new MarbleSolitaireControllerImpl(input, gameLog);
    try {
      c.playGame(m);
    } catch (IllegalStateException ise) {
      //Asserts that we are getting the correct ISE so that we can test unfinished games
      assertEquals("Readable is out of inputs", ise.getMessage());
      String[] lines = gameLog.toString().split("\n");
      assertEquals("    O O O\n"
          + "    O O O\n"
          + "O O O O O O O\n"
          + "O O O _ O O O\n"
          + "O O O O O O O\n"
          + "    O O O\n"
          + "    O O O\n"
          + "Score: 32\n"
          + "Please enter a positive integer:\n"
          + "Please enter a positive integer:\n"
          + "Please enter a positive integer:\n"
          + "    O O O\n"
          + "    O O O\n"
          + "O O O O O O O\n"
          + "O _ _ O O O O\n"
          + "O O O O O O O\n"
          + "    O O O\n"
          + "    O O O\n"
          + "Score: 31\n", gameLog.toString());
      assertEquals("Score: 31", lines[lines.length - 1]);
    }
  }

  @Test
  public void testQuitAfterInvalidFromRow() {
    MarbleSolitaireModel m = new MarbleSolitaireModelImpl();
    StringReader input = new StringReader("!#$ q 4 2 4 4");
    StringBuilder gameLog = new StringBuilder();
    MarbleSolitaireController c = new MarbleSolitaireControllerImpl(input, gameLog);
    c.playGame(m);
    String[] lines = gameLog.toString().split("\n");
    assertEquals("    O O O\n"
        + "    O O O\n"
        + "O O O O O O O\n"
        + "O O O _ O O O\n"
        + "O O O O O O O\n"
        + "    O O O\n"
        + "    O O O\n"
        + "Score: 32\n"
        + "Please enter a positive integer:\n"
        + "Game quit!\n"
        + "State of game when quit:\n"
        + "    O O O\n"
        + "    O O O\n"
        + "O O O O O O O\n"
        + "O O O _ O O O\n"
        + "O O O O O O O\n"
        + "    O O O\n"
        + "    O O O\n"
        + "Score: 32\n", gameLog.toString());
    assertEquals("Score: 32", lines[lines.length - 1]);
  }

  @Test
  public void testQuitAfterInvalidFromCol() {
    MarbleSolitaireModel m = new MarbleSolitaireModelImpl();
    StringReader input = new StringReader("4 !#$ q 2 4 4");
    StringBuilder gameLog = new StringBuilder();
    MarbleSolitaireController c = new MarbleSolitaireControllerImpl(input, gameLog);
    c.playGame(m);
    String[] lines = gameLog.toString().split("\n");
    assertEquals("    O O O\n"
        + "    O O O\n"
        + "O O O O O O O\n"
        + "O O O _ O O O\n"
        + "O O O O O O O\n"
        + "    O O O\n"
        + "    O O O\n"
        + "Score: 32\n"
        + "Please enter a positive integer:\n"
        + "Game quit!\n"
        + "State of game when quit:\n"
        + "    O O O\n"
        + "    O O O\n"
        + "O O O O O O O\n"
        + "O O O _ O O O\n"
        + "O O O O O O O\n"
        + "    O O O\n"
        + "    O O O\n"
        + "Score: 32\n", gameLog.toString());
    assertEquals("Score: 32", lines[lines.length - 1]);
  }

  @Test
  public void testQuitAfterInvalidToRow() {
    MarbleSolitaireModel m = new MarbleSolitaireModelImpl();
    StringReader input = new StringReader("4 2 !#$ q 4 4");
    StringBuilder gameLog = new StringBuilder();
    MarbleSolitaireController c = new MarbleSolitaireControllerImpl(input, gameLog);
    c.playGame(m);
    String[] lines = gameLog.toString().split("\n");
    assertEquals("    O O O\n"
        + "    O O O\n"
        + "O O O O O O O\n"
        + "O O O _ O O O\n"
        + "O O O O O O O\n"
        + "    O O O\n"
        + "    O O O\n"
        + "Score: 32\n"
        + "Please enter a positive integer:\n"
        + "Game quit!\n"
        + "State of game when quit:\n"
        + "    O O O\n"
        + "    O O O\n"
        + "O O O O O O O\n"
        + "O O O _ O O O\n"
        + "O O O O O O O\n"
        + "    O O O\n"
        + "    O O O\n"
        + "Score: 32\n", gameLog.toString());
    assertEquals("Score: 32", lines[lines.length - 1]);
  }

  @Test
  public void testQuitAfterInvalidToCol() {
    MarbleSolitaireModel m = new MarbleSolitaireModelImpl();
    StringReader input = new StringReader("4 2 4 !#$ q 4");
    StringBuilder gameLog = new StringBuilder();
    MarbleSolitaireController c = new MarbleSolitaireControllerImpl(input, gameLog);
    c.playGame(m);
    String[] lines = gameLog.toString().split("\n");
    assertEquals("    O O O\n"
        + "    O O O\n"
        + "O O O O O O O\n"
        + "O O O _ O O O\n"
        + "O O O O O O O\n"
        + "    O O O\n"
        + "    O O O\n"
        + "Score: 32\n"
        + "Please enter a positive integer:\n"
        + "Game quit!\n"
        + "State of game when quit:\n"
        + "    O O O\n"
        + "    O O O\n"
        + "O O O O O O O\n"
        + "O O O _ O O O\n"
        + "O O O O O O O\n"
        + "    O O O\n"
        + "    O O O\n"
        + "Score: 32\n", gameLog.toString());
    assertEquals("Score: 32", lines[lines.length - 1]);
  }

  @Test
  public void testStartingConditions() {
    MarbleSolitaireModel m = new MarbleSolitaireModelImpl();
    StringReader input = new StringReader("");
    StringBuilder gameLog = new StringBuilder();
    MarbleSolitaireController c = new MarbleSolitaireControllerImpl(input, gameLog);
    try {
      c.playGame(m);
    } catch (IllegalStateException ise) {
      String[] lines = gameLog.toString().split("\n");
      assertEquals("    O O O\n"
          + "    O O O\n"
          + "O O O O O O O\n"
          + "O O O _ O O O\n"
          + "O O O O O O O\n"
          + "    O O O\n"
          + "    O O O\n"
          + "Score: 32\n", gameLog.toString());
      assertEquals("Score: 32", lines[lines.length - 1]);
    }
  }

  @Test(expected = IllegalStateException.class)
  public void testFailingAppendable() {
    MarbleSolitaireModel m = new MarbleSolitaireModelImpl();
    StringReader input = new StringReader("4 6 4 4 2 5 4 q");
    Appendable gameLog = new FailingAppendable();
    MarbleSolitaireController c = new MarbleSolitaireControllerImpl(input, gameLog);
    c.playGame(m);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testNullReadable() {
    Appendable gameLog = new StringBuilder();
    MarbleSolitaireController c = new MarbleSolitaireControllerImpl(null, gameLog);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testNullAppendable() {
    StringReader input = new StringReader("4 6 4 4 2 5 4 q");
    MarbleSolitaireController c = new MarbleSolitaireControllerImpl(input, null);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testNullConstructor() {
    MarbleSolitaireController c = new MarbleSolitaireControllerImpl(null, null);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testNullModel() {
    StringReader input = new StringReader("4 6 4 4 2 5 4 q");
    Appendable gameLog = new StringBuilder();
    MarbleSolitaireController c = new MarbleSolitaireControllerImpl(input, gameLog);
    c.playGame(null);
  }

  @Test(expected = IllegalStateException.class)
  public void testReadableOutOfInputs() {
    MarbleSolitaireModel m = new MarbleSolitaireModelImpl();
    StringReader input = new StringReader("4 6 4 4 2 5 4 5");
    Appendable gameLog = new StringBuilder();
    MarbleSolitaireController c = new MarbleSolitaireControllerImpl(input, gameLog);
    c.playGame(m);
  }

  @Test
  public void testReadableRunOut() {
    MarbleSolitaireModel m = new MarbleSolitaireModelImpl();
    StringReader input = new StringReader("4 6 4 4 2 5 4 5");
    StringBuilder gameLog = new StringBuilder();
    MarbleSolitaireController c = new MarbleSolitaireControllerImpl(input, gameLog);
    try {
      c.playGame(m);
    } catch (IllegalStateException ise) {
      assertEquals("Readable is out of inputs", ise.getMessage().toString());
    }
  }
}