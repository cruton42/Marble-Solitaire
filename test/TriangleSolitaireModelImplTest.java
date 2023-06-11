import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModel;
import cs3500.marblesolitaire.model.hw04.TriangleSolitaireModelImpl;
import org.junit.Test;

/**
 * Test class for Triangle Solitaire Model and its methods.
 */
public class TriangleSolitaireModelImplTest {

  private final MarbleSolitaireModel msm1 = new TriangleSolitaireModelImpl();
  private final MarbleSolitaireModel msm2 = new TriangleSolitaireModelImpl(4, 2);
  private final MarbleSolitaireModel middleSpace = new TriangleSolitaireModelImpl(3, 1);
  private final MarbleSolitaireModel msm3 = new TriangleSolitaireModelImpl(8);
  private final MarbleSolitaireModel msm4 = new TriangleSolitaireModelImpl(5, 4, 4);

  @Test
  public void testGameWin() {
    //test pre-conditions
    assertEquals("    _\n"
        + "   O O\n"
        + "  O O O\n"
        + " O O O O\n"
        + "O O O O O", msm1.getGameState());
    assertFalse(msm1.isGameOver());
    assertEquals(14, msm1.getScore());

    msm1.move(2, 0, 0, 0);
    assertFalse(msm1.isGameOver());
    msm1.move(2, 2, 2, 0);
    assertFalse(msm1.isGameOver());
    msm1.move(0, 0, 2, 2);
    assertFalse(msm1.isGameOver());
    msm1.move(3, 0, 1, 0);
    assertFalse(msm1.isGameOver());
    msm1.move(4, 2, 2, 0);
    assertFalse(msm1.isGameOver());
    msm1.move(3, 3, 3, 1);
    assertFalse(msm1.isGameOver());
    msm1.move(1, 0, 3, 0);
    assertFalse(msm1.isGameOver());
    msm1.move(3, 0, 3, 2);
    assertFalse(msm1.isGameOver());
    msm1.move(4, 4, 4, 2);
    assertFalse(msm1.isGameOver());
    msm1.move(4, 1, 4, 3);
    assertFalse(msm1.isGameOver());
    msm1.move(2, 2, 4, 2);
    assertFalse(msm1.isGameOver());
    msm1.move(4, 3, 4, 1);
    assertFalse(msm1.isGameOver());
    msm1.move(4, 0, 4, 2);
    assertTrue(msm1.isGameOver());

    //test post-conditions
    assertEquals("    _\n"
        + "   _ _\n"
        + "  _ _ _\n"
        + " _ _ _ _\n"
        + "_ _ O _ _", msm1.getGameState());
    assertTrue(msm1.isGameOver());
    assertEquals(1, msm1.getScore());
  }

  @Test
  public void testInvalidArmSizeConstructor() {
    try {
      MarbleSolitaireModel test = new TriangleSolitaireModelImpl(0);
      fail("Invalid constructor should have thrown exception");
    } catch (IllegalArgumentException iae) {
      assertEquals("Cannot have a game with dimensions < 1.", iae.getMessage());
      assertTrue(iae.getMessage().length() > 0);
    }
    try {
      MarbleSolitaireModel test = new TriangleSolitaireModelImpl(-1);
      fail("Invalid constructor should have thrown exception");
    } catch (IllegalArgumentException iae) {
      assertEquals("Cannot have a game with dimensions < 1.", iae.getMessage());
      assertTrue(iae.getMessage().length() > 0);
    }
    try {
      MarbleSolitaireModel test = new TriangleSolitaireModelImpl(-5);
      fail("Invalid constructor should have thrown exception");
    } catch (IllegalArgumentException iae) {
      assertEquals("Cannot have a game with dimensions < 1.", iae.getMessage());
      assertTrue(iae.getMessage().length() > 0);
    }
    try {
      MarbleSolitaireModel test = new TriangleSolitaireModelImpl(-2);
      fail("Invalid constructor should have thrown exception");
    } catch (IllegalArgumentException iae) {
      assertEquals("Cannot have a game with dimensions < 1.", iae.getMessage());
      assertTrue(iae.getMessage().length() > 0);
    }
  }

  @Test
  public void testInvalidArmRowColConstructor() {
    try {
      MarbleSolitaireModel test = new TriangleSolitaireModelImpl(1, 4, 4);
      fail("Invalid constructor should have thrown exception");
    } catch (IllegalArgumentException iae) {
      assertEquals("Invalid empty cell position (4,4)", iae.getMessage());
      assertTrue(iae.getMessage().length() > 0);
    }
    try {
      MarbleSolitaireModel test = new TriangleSolitaireModelImpl(5, 0, 13);
      fail("Invalid constructor should have thrown exception");
    } catch (IllegalArgumentException iae) {
      assertEquals("Invalid empty cell position (0,13)", iae.getMessage());
      assertTrue(iae.getMessage().length() > 0);
    }
    try {
      MarbleSolitaireModel test = new TriangleSolitaireModelImpl(5, 14, 0);
      fail("Invalid constructor should have thrown exception");
    } catch (IllegalArgumentException iae) {
      assertEquals("Invalid empty cell position (14,0)", iae.getMessage());
      assertTrue(iae.getMessage().length() > 0);
    }
    try {
      MarbleSolitaireModel test = new TriangleSolitaireModelImpl(5, 13, 14);
      fail("Invalid constructor should have thrown exception");
    } catch (IllegalArgumentException iae) {
      assertEquals("Invalid empty cell position (13,14)", iae.getMessage());
      assertTrue(iae.getMessage().length() > 0);
    }
    try {
      MarbleSolitaireModel test = new TriangleSolitaireModelImpl(2, 6, 6);
      fail("Invalid constructor should have thrown exception");
    } catch (IllegalArgumentException iae) {
      assertEquals("Invalid empty cell position (6,6)", iae.getMessage());
      assertTrue(iae.getMessage().length() > 0);
    }
    try {
      MarbleSolitaireModel test = new TriangleSolitaireModelImpl(0, 6, 6);
      fail("Invalid constructor should have thrown exception");
    } catch (IllegalArgumentException iae) {
      assertEquals("Cannot have a game with dimensions < 1.", iae.getMessage());
      assertTrue(iae.getMessage().length() > 0);
    }
    try {
      MarbleSolitaireModel test = new TriangleSolitaireModelImpl(-1, 6, 6);
      fail("Invalid constructor should have thrown exception");
    } catch (IllegalArgumentException iae) {
      assertEquals("Cannot have a game with dimensions < 1.", iae.getMessage());
      assertTrue(iae.getMessage().length() > 0);
    }
    try {
      MarbleSolitaireModel test = new TriangleSolitaireModelImpl(1, 8, 7);
      fail("Invalid constructor should have thrown exception");
    } catch (IllegalArgumentException iae) {
      assertEquals("Invalid empty cell position (8,7)", iae.getMessage());
      assertTrue(iae.getMessage().length() > 0);
    }
    try {
      MarbleSolitaireModel test = new TriangleSolitaireModelImpl(2, 6, 6);
      fail("Invalid constructor should have thrown exception");
    } catch (IllegalArgumentException iae) {
      assertEquals("Invalid empty cell position (6,6)", iae.getMessage());
      assertTrue(iae.getMessage().length() > 0);
    }
  }

  @Test
  public void testTooSmallConstructor() {
    try {
      MarbleSolitaireModel test = new TriangleSolitaireModelImpl(0);
      fail("Cannot have a game with dimensions < 1.");
    } catch (IllegalArgumentException iae) {
      assertTrue(iae.getMessage().length() > 0);
    }
    try {
      MarbleSolitaireModel test = new TriangleSolitaireModelImpl(-1);
      fail("Cannot have a game with dimensions < 1.");
    } catch (IllegalArgumentException iae) {
      assertTrue(iae.getMessage().length() > 0);
    }
    try {
      MarbleSolitaireModel test = new TriangleSolitaireModelImpl(-3);
      fail("Cannot have a game with dimensions < 1.");
    } catch (IllegalArgumentException iae) {
      assertTrue(iae.getMessage().length() > 0);
    }
    try {
      MarbleSolitaireModel test = new TriangleSolitaireModelImpl(-1000);
      fail("Cannot have a game with dimensions < 1.");
    } catch (IllegalArgumentException iae) {
      assertTrue(iae.getMessage().length() > 0);
    }
  }

  @Test
  public void testInvalidRowColConstructor() {
    try {
      MarbleSolitaireModel test = new TriangleSolitaireModelImpl(6, 7);
      fail("Invalid constructor should have thrown exception");
    } catch (IllegalArgumentException iae) {
      assertEquals("Invalid empty cell position (6,7)", iae.getMessage());
      assertTrue(iae.getMessage().length() > 0);
    }
    try {
      MarbleSolitaireModel test = new TriangleSolitaireModelImpl(-1, 3);
      fail("Invalid constructor should have thrown exception");
    } catch (IllegalArgumentException iae) {
      assertEquals("Invalid empty cell position (-1,3)", iae.getMessage());
      assertTrue(iae.getMessage().length() > 0);
    }
    try {
      MarbleSolitaireModel test = new TriangleSolitaireModelImpl(3, -1);
      fail("Invalid constructor should have thrown exception");
    } catch (IllegalArgumentException iae) {
      assertEquals("Invalid empty cell position (3,-1)", iae.getMessage());
      assertTrue(iae.getMessage().length() > 0);
    }
    try {
      MarbleSolitaireModel test = new TriangleSolitaireModelImpl(9, 8);
      fail("Invalid constructor should have thrown exception");
    } catch (IllegalArgumentException iae) {
      assertEquals("Invalid empty cell position (9,8)", iae.getMessage());
      assertTrue(iae.getMessage().length() > 0);
    }
    try {
      MarbleSolitaireModel test = new TriangleSolitaireModelImpl(15, 7);
      fail("Invalid constructor should have thrown exception");
    } catch (IllegalArgumentException iae) {
      assertEquals("Invalid empty cell position (15,7)", iae.getMessage());
      assertTrue(iae.getMessage().length() > 0);
    }
    try {
      MarbleSolitaireModel test = new TriangleSolitaireModelImpl(3, 10);
      fail("Invalid constructor should have thrown exception");
    } catch (IllegalArgumentException iae) {
      assertEquals("Invalid empty cell position (3,10)", iae.getMessage());
      assertTrue(iae.getMessage().length() > 0);
    }
  }

  @Test
  public void testInvalidRowColConstructorNeg() {
    try {
      MarbleSolitaireModel test = new TriangleSolitaireModelImpl(-1, 3);
      fail("Invalid constructor should have thrown exception");
    } catch (IllegalArgumentException iae) {
      assertEquals("Invalid empty cell position (-1,3)", iae.getMessage());
      assertTrue(iae.getMessage().length() > 0);
    }
    try {
      MarbleSolitaireModel test = new TriangleSolitaireModelImpl(3, -2);
      fail("Invalid constructor should have thrown exception");
    } catch (IllegalArgumentException iae) {
      assertEquals("Invalid empty cell position (3,-2)", iae.getMessage());
      assertTrue(iae.getMessage().length() > 0);
    }
  }

  @Test
  public void testArmRowColConstructor() {
    //test pre-conditions
    assertEquals("    O\n"
        + "   O O\n"
        + "  O O O\n"
        + " O O O O\n"
        + "O O O O _", msm4.getGameState());
    assertFalse(msm4.isGameOver());
    assertEquals(14, msm4.getScore());

    msm4.move(4, 2, 4, 4);

    //test post-conditions
    assertEquals("    O\n"
        + "   O O\n"
        + "  O O O\n"
        + " O O O O\n"
        + "O O _ _ O", msm4.getGameState());
    assertFalse(msm4.isGameOver());
    assertEquals(13, msm4.getScore());
  }

  @Test
  public void testArmSizeConstructor() {
    //test pre-conditions
    assertEquals("       _\n"
        + "      O O\n"
        + "     O O O\n"
        + "    O O O O\n"
        + "   O O O O O\n"
        + "  O O O O O O\n"
        + " O O O O O O O\n"
        + "O O O O O O O O", msm3.getGameState());
    assertFalse(msm3.isGameOver());
    assertEquals(35, msm3.getScore());

    msm3.move(2, 0, 0, 0);

    //test post-conditions
    assertEquals("       O\n"
        + "      _ O\n"
        + "     _ O O\n"
        + "    O O O O\n"
        + "   O O O O O\n"
        + "  O O O O O O\n"
        + " O O O O O O O\n"
        + "O O O O O O O O", msm3.getGameState());
    assertFalse(msm3.isGameOver());
    assertEquals(34, msm3.getScore());
  }

  @Test
  public void testArmSizeConstructorSmall() {
    MarbleSolitaireModel msm3 = new TriangleSolitaireModelImpl(3);
    //test pre-conditions
    assertEquals("  _\n"
        + " O O\n"
        + "O O O", msm3.getGameState());
    assertFalse(msm3.isGameOver());
    assertEquals(5, msm3.getScore());

    msm3.move(2, 0, 0, 0);

    //test post-conditions
    assertEquals("  O\n"
        + " _ O\n"
        + "_ O O", msm3.getGameState());
    assertFalse(msm3.isGameOver());
    assertEquals(4, msm3.getScore());
  }

  @Test
  public void testRowColConstructor() {
    //test pre-conditions
    assertEquals("    O\n"
        + "   O O\n"
        + "  O O O\n"
        + " O _ O O\n"
        + "O O O O O", middleSpace.getGameState());
    assertFalse(middleSpace.isGameOver());
    assertEquals(14, middleSpace.getScore());

    middleSpace.move(1, 1, 3, 1);

    //test post-conditions
    assertEquals("    O\n"
        + "   O _\n"
        + "  O _ O\n"
        + " O O O O\n"
        + "O O O O O", middleSpace.getGameState());
    assertFalse(middleSpace.isGameOver());
    assertEquals(13, middleSpace.getScore());
  }

  @Test
  public void testMoveUpLeft() {
    //test pre-conditions
    assertEquals("    _\n"
        + "   O O\n"
        + "  O O O\n"
        + " O O O O\n"
        + "O O O O O", msm1.getGameState());
    assertFalse(msm1.isGameOver());
    assertEquals(14, msm1.getScore());

    msm1.move(2, 2, 0, 0);

    //test post-conditions
    assertEquals("    O\n"
        + "   O _\n"
        + "  O O _\n"
        + " O O O O\n"
        + "O O O O O", msm1.getGameState());
    assertFalse(msm1.isGameOver());
    assertEquals(13, msm1.getScore());
  }

  @Test
  public void testMoveUpRight() {
    //test pre-conditions
    assertEquals("    _\n"
        + "   O O\n"
        + "  O O O\n"
        + " O O O O\n"
        + "O O O O O", msm1.getGameState());
    assertFalse(msm1.isGameOver());
    assertEquals(14, msm1.getScore());

    msm1.move(2, 0, 0, 0);

    //test post-conditions
    assertEquals("    O\n"
        + "   _ O\n"
        + "  _ O O\n"
        + " O O O O\n"
        + "O O O O O", msm1.getGameState());
    assertFalse(msm1.isGameOver());
    assertEquals(13, msm1.getScore());
  }

  @Test
  public void testMoveRight() {
    //test pre-conditions
    assertEquals("    O\n"
        + "   O O\n"
        + "  O O O\n"
        + " O O O O\n"
        + "O O _ O O", msm2.getGameState());
    assertFalse(msm2.isGameOver());
    assertEquals(14, msm2.getScore());

    msm2.move(4, 0, 4, 2);

    //test post-conditions
    assertEquals("    O\n"
        + "   O O\n"
        + "  O O O\n"
        + " O O O O\n"
        + "_ _ O O O", msm2.getGameState());
    assertFalse(msm2.isGameOver());
    assertEquals(13, msm2.getScore());
  }

  @Test
  public void testMoveLeft() {
    //test pre-conditions
    assertEquals("    O\n"
        + "   O O\n"
        + "  O O O\n"
        + " O O O O\n"
        + "O O _ O O", msm2.getGameState());
    assertFalse(msm2.isGameOver());
    assertEquals(14, msm2.getScore());

    msm2.move(4, 4, 4, 2);

    //test post-conditions
    assertEquals("    O\n"
        + "   O O\n"
        + "  O O O\n"
        + " O O O O\n"
        + "O O O _ _", msm2.getGameState());
    assertFalse(msm2.isGameOver());
    assertEquals(13, msm2.getScore());
  }

  @Test
  public void testMoveDownRight() {
    //test pre-conditions
    assertEquals("    O\n"
        + "   O O\n"
        + "  O O O\n"
        + " O O O O\n"
        + "O O _ O O", msm2.getGameState());
    assertFalse(msm2.isGameOver());
    assertEquals(14, msm2.getScore());

    msm2.move(2, 0, 4, 2);

    //test post-conditions
    assertEquals("    O\n"
        + "   O O\n"
        + "  _ O O\n"
        + " O _ O O\n"
        + "O O O O O", msm2.getGameState());
    assertFalse(msm2.isGameOver());
    assertEquals(13, msm2.getScore());
  }

  @Test
  public void testMoveDownLeft() {
    //test pre-conditions
    assertEquals("    O\n"
        + "   O O\n"
        + "  O O O\n"
        + " O O O O\n"
        + "O O _ O O", msm2.getGameState());
    assertFalse(msm2.isGameOver());
    assertEquals(14, msm2.getScore());

    msm2.move(2, 2, 4, 2);

    //test post-conditions
    assertEquals("    O\n"
        + "   O O\n"
        + "  O O _\n"
        + " O O _ O\n"
        + "O O O O O", msm2.getGameState());
    assertFalse(msm2.isGameOver());
    assertEquals(13, msm2.getScore());
  }

  @Test
  public void testInvalidMoveOverEmptySpace() {
    //test pre-conditions
    assertEquals("    _\n"
        + "   O O\n"
        + "  O O O\n"
        + " O O O O\n"
        + "O O O O O", msm1.getGameState());
    assertFalse(msm1.isGameOver());
    assertEquals(14, msm1.getScore());

    msm1.move(2, 0, 0, 0);

    //test post-conditions
    assertEquals("    O\n"
        + "   _ O\n"
        + "  _ O O\n"
        + " O O O O\n"
        + "O O O O O", msm1.getGameState());
    assertFalse(msm1.isGameOver());
    assertEquals(13, msm1.getScore());

    try {
      msm1.move(3, 0, 1, 0);
      fail("Invalid move should have thrown exception");
    } catch (IllegalArgumentException iae) {
      assertTrue(iae.getMessage().length() > 0);
    }

    assertEquals("    O\n"
        + "   _ O\n"
        + "  _ O O\n"
        + " O O O O\n"
        + "O O O O O", msm1.getGameState());
    assertFalse(msm1.isGameOver());
    assertEquals(13, msm1.getScore());
  }

  @Test
  public void testGameLose() {
    //test pre-conditions
    assertEquals("    _\n"
        + "   O O\n"
        + "  O O O\n"
        + " O O O O\n"
        + "O O O O O", msm1.getGameState());
    assertFalse(msm1.isGameOver());
    assertEquals(14, msm1.getScore());

    msm1.move(2, 0, 0, 0);
    assertFalse(msm1.isGameOver());
    msm1.move(2, 2, 2, 0);
    assertFalse(msm1.isGameOver());
    msm1.move(3, 0, 1, 0);
    assertFalse(msm1.isGameOver());
    msm1.move(4, 2, 2, 0);
    assertFalse(msm1.isGameOver());
    msm1.move(4, 3, 2, 1);
    assertFalse(msm1.isGameOver());
    msm1.move(2, 0, 2, 2);
    assertFalse(msm1.isGameOver());
    msm1.move(0, 0, 2, 0);
    assertFalse(msm1.isGameOver());
    msm1.move(2, 2, 0, 0);
    assertFalse(msm1.isGameOver());
    msm1.move(4, 0, 4, 2);
    assertFalse(msm1.isGameOver());
    msm1.move(4, 4, 2, 2);

    //test post-conditions
    assertEquals("    O\n"
        + "   _ _\n"
        + "  O _ O\n"
        + " _ _ _ _\n"
        + "_ _ O _ _", msm1.getGameState());
    assertTrue(msm1.isGameOver());
    assertEquals(4, msm1.getScore());
  }

  @Test
  public void testMoveAfterGameOver() {
    //test pre-conditions
    assertEquals("    _\n"
        + "   O O\n"
        + "  O O O\n"
        + " O O O O\n"
        + "O O O O O", msm1.getGameState());
    assertFalse(msm1.isGameOver());
    assertEquals(14, msm1.getScore());

    msm1.move(2, 0, 0, 0);
    assertFalse(msm1.isGameOver());
    msm1.move(2, 2, 2, 0);
    assertFalse(msm1.isGameOver());
    msm1.move(3, 0, 1, 0);
    assertFalse(msm1.isGameOver());
    msm1.move(4, 2, 2, 0);
    assertFalse(msm1.isGameOver());
    msm1.move(4, 3, 2, 1);
    assertFalse(msm1.isGameOver());
    msm1.move(2, 0, 2, 2);
    assertFalse(msm1.isGameOver());
    msm1.move(0, 0, 2, 0);
    assertFalse(msm1.isGameOver());
    msm1.move(2, 2, 0, 0);
    assertFalse(msm1.isGameOver());
    msm1.move(4, 0, 4, 2);
    assertFalse(msm1.isGameOver());
    msm1.move(4, 4, 2, 2);
    assertTrue(msm1.isGameOver());
    try {
      msm1.move(2, 0, 4, 0);
      fail("Invalid move should have thrown exception");
    } catch (IllegalStateException iae) {
      assertTrue(iae.getMessage().length() > 0);
    }

    //test post-conditions
    assertEquals("    O\n"
        + "   _ _\n"
        + "  O _ O\n"
        + " _ _ _ _\n"
        + "_ _ O _ _", msm1.getGameState());
    assertTrue(msm1.isGameOver());
    assertEquals(4, msm1.getScore());
  }

  @Test
  public void testGetScore() {
    //test pre-conditions
    assertEquals("    _\n"
        + "   O O\n"
        + "  O O O\n"
        + " O O O O\n"
        + "O O O O O", msm1.getGameState());
    assertFalse(msm1.isGameOver());
    assertEquals(14, msm1.getScore());

    msm1.move(2, 0, 0, 0);
    assertFalse(msm1.isGameOver());
    assertEquals(13, msm1.getScore());
    msm1.move(2, 2, 2, 0);
    assertFalse(msm1.isGameOver());
    assertEquals(12, msm1.getScore());
    msm1.move(3, 0, 1, 0);
    assertFalse(msm1.isGameOver());
    assertEquals(11, msm1.getScore());
    msm1.move(4, 2, 2, 0);
    assertFalse(msm1.isGameOver());
    assertEquals(10, msm1.getScore());
    msm1.move(4, 3, 2, 1);
    assertFalse(msm1.isGameOver());
    assertEquals(9, msm1.getScore());
    msm1.move(2, 0, 2, 2);
    assertFalse(msm1.isGameOver());
    assertEquals(8, msm1.getScore());
    msm1.move(0, 0, 2, 0);
    assertFalse(msm1.isGameOver());
    assertEquals(7, msm1.getScore());
    msm1.move(2, 2, 0, 0);
    assertFalse(msm1.isGameOver());
    assertEquals(6, msm1.getScore());
    msm1.move(4, 0, 4, 2);
    assertFalse(msm1.isGameOver());
    assertEquals(5, msm1.getScore());
    msm1.move(4, 4, 2, 2);

    //test post-conditions
    assertEquals("    O\n"
        + "   _ _\n"
        + "  O _ O\n"
        + " _ _ _ _\n"
        + "_ _ O _ _", msm1.getGameState());
    assertTrue(msm1.isGameOver());
    assertEquals(4, msm1.getScore());
  }

  @Test
  public void testIsGameOverFalse() {
    //test pre-conditions
    assertEquals("    _\n"
        + "   O O\n"
        + "  O O O\n"
        + " O O O O\n"
        + "O O O O O", msm1.getGameState());
    assertFalse(msm1.isGameOver());
    assertEquals(14, msm1.getScore());

    msm1.move(2, 0, 0, 0);
    assertFalse(msm1.isGameOver());
    assertEquals(13, msm1.getScore());
    msm1.move(2, 2, 2, 0);
    assertFalse(msm1.isGameOver());
    assertEquals(12, msm1.getScore());
    msm1.move(3, 0, 1, 0);

    assertFalse(msm1.isGameOver());
    assertEquals(11, msm1.getScore());
  }

  @Test
  public void testInvalidMoveUpperLeft() {
    try {
      msm1.move(2, 1, 0, 1);
      fail("Invalid move should have thrown exception");
    } catch (IllegalArgumentException iae) {
      assertTrue(iae.getMessage().length() > 0);
    }
  }

  @Test
  public void testInvalidMoveUpperRight() {
    try {
      msm1.move(2, 6, 0, 6);
      fail("Invalid move should have thrown exception");
    } catch (IllegalArgumentException iae) {
      assertTrue(iae.getMessage().length() > 0);
    }
  }

  @Test
  public void testInvalidMoveLowerLeft() {
    try {
      msm1.move(4, 0, 6, 0);
      fail("Invalid move should have thrown exception");
    } catch (IllegalArgumentException iae) {
      assertTrue(iae.getMessage().length() > 0);
    }
  }

  @Test
  public void testInvalidMoveLowerRight() {
    try {
      msm1.move(4, 5, 6, 5);
      fail("Invalid move should have thrown exception");
    } catch (IllegalArgumentException iae) {
      assertTrue(iae.getMessage().length() > 0);
    }
  }

  @Test
  public void testInvalidMoveInvalidFrom() {
    try {
      msm1.move(0, 0, 0, 2);
      fail("Invalid move should have thrown exception");
    } catch (IllegalArgumentException iae) {
      assertTrue(iae.getMessage().length() > 0);
    }
  }

  @Test
  public void testInvalidMoveOpenSpaceFrom() {
    try {
      msm1.move(3, 3, 0, 2);
      fail("Invalid move should have thrown exception");
    } catch (IllegalArgumentException iae) {
      assertTrue(iae.getMessage().length() > 0);
    }
  }

  @Test
  public void testInvalidMoveInvalidTo() {
    try {
      msm1.move(1, 3, 2, 3);
      fail("Invalid move should have thrown exception");
    } catch (IllegalArgumentException iae) {
      assertTrue(iae.getMessage().length() > 0);
    }
    try {
      msm1.move(1, 3, 4, 3);
      fail("Invalid move should have thrown exception");
    } catch (IllegalArgumentException iae) {
      assertTrue(iae.getMessage().length() > 0);
    }
    try {
      msm1.move(1, 3, 5, 3);
      fail("Invalid move should have thrown exception");
    } catch (IllegalArgumentException iae) {
      assertTrue(iae.getMessage().length() > 0);
    }
  }

  @Test
  public void testInvalidMoveSameSpace() {
    try {
      msm1.move(1, 3, 1, 3);
      fail("Invalid move should have thrown exception");
    } catch (IllegalArgumentException iae) {
      assertTrue(iae.getMessage().length() > 0);
    }
  }

  @Test
  public void testInvalidMoveOutOfGrid() {
    try {
      msm1.move(1, 3, -1, 3);
      fail("Invalid move should have thrown exception");
    } catch (IllegalArgumentException iae) {
      assertTrue(iae.getMessage().length() > 0);
    }
    try {
      msm1.move(3, -1, 3, 1);
      fail("Invalid move should have thrown exception");
    } catch (IllegalArgumentException iae) {
      assertTrue(iae.getMessage().length() > 0);
    }
    try {
      msm1.move(3, 7, 3, 5);
      fail("Invalid move should have thrown exception");
    } catch (IllegalArgumentException iae) {
      assertTrue(iae.getMessage().length() > 0);
    }
    try {
      msm1.move(7, 3, 5, 3);
      fail("Invalid move should have thrown exception");
    } catch (IllegalArgumentException iae) {
      assertTrue(iae.getMessage().length() > 0);
    }
    try {
      msm1.move(3, 10, 3, 8);
      fail("Invalid move should have thrown exception");
    } catch (IllegalArgumentException iae) {
      assertTrue(iae.getMessage().length() > 0);
    }
    try {
      msm1.move(10, 3, 8, 3);
      fail("Invalid move should have thrown exception");
    } catch (IllegalArgumentException iae) {
      assertTrue(iae.getMessage().length() > 0);
    }
  }

  @Test
  public void testInvalidMoveOccupiedSpace() {
    try {
      msm1.move(0, 3, 2, 3);
      fail("Invalid move should have thrown exception");
    } catch (IllegalArgumentException iae) {
      assertTrue(iae.getMessage().length() > 0);
    }
  }

  @Test
  public void testInvalidMoveSingleSpace() {
    try {
      msm1.move(2, 3, 3, 3);
      fail("Invalid move should have thrown exception");
    } catch (IllegalArgumentException iae) {
      assertTrue(iae.getMessage().length() > 0);
    }
  }

  @Test
  public void testInvalidMoveDoubleJump() {
    try {
      msm1.move(0, 3, 3, 3);
      fail("Invalid move should have thrown exception");
    } catch (IllegalArgumentException iae) {
      assertTrue(iae.getMessage().length() > 0);
    }
    try {
      msm1.move(3, 0, 3, 3);
      fail("Invalid move should have thrown exception");
    } catch (IllegalArgumentException iae) {
      assertTrue(iae.getMessage().length() > 0);
    }
  }
}