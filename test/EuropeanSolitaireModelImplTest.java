import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModel;
import cs3500.marblesolitaire.model.hw04.EuropeanSolitaireModelImpl;
import org.junit.Test;

/**
 * Test class for European Solitaire Model and its methods.
 */
public class EuropeanSolitaireModelImplTest {

  private final MarbleSolitaireModel msm1 = new EuropeanSolitaireModelImpl();
  private final MarbleSolitaireModel msm2 = new EuropeanSolitaireModelImpl(4, 2);
  private final MarbleSolitaireModel msm3 = new EuropeanSolitaireModelImpl(5);
  private final MarbleSolitaireModel msm4 = new EuropeanSolitaireModelImpl(5, 4, 4);
  private final MarbleSolitaireModel msmdefault = new EuropeanSolitaireModelImpl(3);
  private final MarbleSolitaireModel msmdefault2 = new EuropeanSolitaireModelImpl(3, 3, 3);

  @Test
  public void testInvalidArmSizeConstructor() {
    try {
      MarbleSolitaireModel test = new EuropeanSolitaireModelImpl(2);
      fail("Invalid constructor should have thrown exception");
    } catch (IllegalArgumentException iae) {
      assertEquals("Arm thickness must be a positive odd integer!", iae.getMessage());
      assertTrue(iae.getMessage().length() > 0);
    }
    try {
      MarbleSolitaireModel test = new EuropeanSolitaireModelImpl(4);
      fail("Invalid constructor should have thrown exception");
    } catch (IllegalArgumentException iae) {
      assertEquals("Arm thickness must be a positive odd integer!", iae.getMessage());
      assertTrue(iae.getMessage().length() > 0);
    }
    try {
      MarbleSolitaireModel test = new EuropeanSolitaireModelImpl(0);
      fail("Invalid constructor should have thrown exception");
    } catch (IllegalArgumentException iae) {
      assertEquals("Arm thickness must be a positive odd integer!", iae.getMessage());
      assertTrue(iae.getMessage().length() > 0);
    }
    try {
      MarbleSolitaireModel test = new EuropeanSolitaireModelImpl(-1);
      fail("Invalid constructor should have thrown exception");
    } catch (IllegalArgumentException iae) {
      assertEquals("Arm thickness must be a positive odd integer!", iae.getMessage());
      assertTrue(iae.getMessage().length() > 0);
    }
  }

  @Test
  public void testInvalidArmRowColConstructor() {
    try {
      MarbleSolitaireModel test = new EuropeanSolitaireModelImpl(5, 0, 0);
      fail("Invalid constructor should have thrown exception");
    } catch (IllegalArgumentException iae) {
      assertEquals("Invalid empty cell position (0,0)", iae.getMessage());
      assertTrue(iae.getMessage().length() > 0);
    }
    try {
      MarbleSolitaireModel test = new EuropeanSolitaireModelImpl(5, 0, 13);
      fail("Invalid constructor should have thrown exception");
    } catch (IllegalArgumentException iae) {
      assertEquals("Invalid empty cell position (0,13)", iae.getMessage());
      assertTrue(iae.getMessage().length() > 0);
    }
    try {
      MarbleSolitaireModel test = new EuropeanSolitaireModelImpl(5, 14, 0);
      fail("Invalid constructor should have thrown exception");
    } catch (IllegalArgumentException iae) {
      assertEquals("Invalid empty cell position (14,0)", iae.getMessage());
      assertTrue(iae.getMessage().length() > 0);
    }
    try {
      MarbleSolitaireModel test = new EuropeanSolitaireModelImpl(5, 13, 14);
      fail("Invalid constructor should have thrown exception");
    } catch (IllegalArgumentException iae) {
      assertEquals("Invalid empty cell position (13,14)", iae.getMessage());
      assertTrue(iae.getMessage().length() > 0);
    }
    try {
      MarbleSolitaireModel test = new EuropeanSolitaireModelImpl(2, 6, 6);
      fail("Invalid constructor should have thrown exception");
    } catch (IllegalArgumentException iae) {
      assertEquals("Arm thickness must be a positive odd integer!", iae.getMessage());
      assertTrue(iae.getMessage().length() > 0);
    }
    try {
      MarbleSolitaireModel test = new EuropeanSolitaireModelImpl(0, 6, 6);
      fail("Invalid constructor should have thrown exception");
    } catch (IllegalArgumentException iae) {
      assertEquals("Arm thickness must be a positive odd integer!", iae.getMessage());
      assertTrue(iae.getMessage().length() > 0);
    }
    try {
      MarbleSolitaireModel test = new EuropeanSolitaireModelImpl(-1, 6, 6);
      fail("Invalid constructor should have thrown exception");
    } catch (IllegalArgumentException iae) {
      assertEquals("Arm thickness must be a positive odd integer!", iae.getMessage());
      assertTrue(iae.getMessage().length() > 0);
    }
    try {
      MarbleSolitaireModel test = new EuropeanSolitaireModelImpl(1, 6, 6);
      fail("Invalid constructor should have thrown exception");
    } catch (IllegalArgumentException iae) {
      assertEquals("Arm thickness must be a positive odd integer!", iae.getMessage());
      assertTrue(iae.getMessage().length() > 0);
    }
    try {
      MarbleSolitaireModel test = new EuropeanSolitaireModelImpl(2, 6, 6);
      fail("Invalid constructor should have thrown exception");
    } catch (IllegalArgumentException iae) {
      assertEquals("Arm thickness must be a positive odd integer!", iae.getMessage());
      assertTrue(iae.getMessage().length() > 0);
    }
  }

  @Test
  public void testTooSmallConstructor() {
    try {
      MarbleSolitaireModel test = new EuropeanSolitaireModelImpl(1);
      fail("Invalid constructor should have thrown exception");
    } catch (IllegalArgumentException iae) {
      assertTrue(iae.getMessage().length() > 0);
    }
    try {
      MarbleSolitaireModel test = new EuropeanSolitaireModelImpl(0);
      fail("Invalid constructor should have thrown exception");
    } catch (IllegalArgumentException iae) {
      assertTrue(iae.getMessage().length() > 0);
    }
    try {
      MarbleSolitaireModel test = new EuropeanSolitaireModelImpl(2);
      fail("Invalid constructor should have thrown exception");
    } catch (IllegalArgumentException iae) {
      assertTrue(iae.getMessage().length() > 0);
    }
    try {
      MarbleSolitaireModel test = new EuropeanSolitaireModelImpl(1);
      fail("Invalid constructor should have thrown exception");
    } catch (IllegalArgumentException iae) {
      assertTrue(iae.getMessage().length() > 0);
    }
  }

  @Test
  public void testInvalidRowColConstructor() {
    try {
      MarbleSolitaireModel test = new EuropeanSolitaireModelImpl(0, 0);
      fail("Invalid constructor should have thrown exception");
    } catch (IllegalArgumentException iae) {
      assertEquals("Invalid empty cell position (0,0)", iae.getMessage());
      assertTrue(iae.getMessage().length() > 0);
    }
    try {
      MarbleSolitaireModel test = new EuropeanSolitaireModelImpl(0, 5);
      fail("Invalid constructor should have thrown exception");
    } catch (IllegalArgumentException iae) {
      assertEquals("Invalid empty cell position (0,5)", iae.getMessage());
      assertTrue(iae.getMessage().length() > 0);
    }
    try {
      MarbleSolitaireModel test = new EuropeanSolitaireModelImpl(6, 0);
      fail("Invalid constructor should have thrown exception");
    } catch (IllegalArgumentException iae) {
      assertEquals("Invalid empty cell position (6,0)", iae.getMessage());
      assertTrue(iae.getMessage().length() > 0);
    }
    try {
      MarbleSolitaireModel test = new EuropeanSolitaireModelImpl(5, 6);
      fail("Invalid constructor should have thrown exception");
    } catch (IllegalArgumentException iae) {
      assertEquals("Invalid empty cell position (5,6)", iae.getMessage());
      assertTrue(iae.getMessage().length() > 0);
    }
  }

  @Test
  public void testInvalidRowColConstructorNeg() {
    try {
      MarbleSolitaireModel test = new EuropeanSolitaireModelImpl(-1, 3);
      fail("Invalid constructor should have thrown exception");
    } catch (IllegalArgumentException iae) {
      assertEquals("Invalid empty cell position (-1,3)", iae.getMessage());
      assertTrue(iae.getMessage().length() > 0);
    }
    try {
      MarbleSolitaireModel test = new EuropeanSolitaireModelImpl(3, -2);
      fail("Invalid constructor should have thrown exception");
    } catch (IllegalArgumentException iae) {
      assertEquals("Invalid empty cell position (3,-2)", iae.getMessage());
      assertTrue(iae.getMessage().length() > 0);
    }
  }

  @Test
  public void testRecreateDefaultConstructor() {
    //test pre-conditions
    assertEquals("    O O O\n"
        + "  O O O O O\n"
        + "O O O O O O O\n"
        + "O O O _ O O O\n"
        + "O O O O O O O\n"
        + "  O O O O O\n"
        + "    O O O", msmdefault.getGameState());
    assertFalse(msmdefault.isGameOver());
    assertEquals(36, msmdefault.getScore());

    msmdefault.move(1, 3, 3, 3);

    //test post-conditions
    assertEquals("    O O O\n"
        + "  O O _ O O\n"
        + "O O O _ O O O\n"
        + "O O O O O O O\n"
        + "O O O O O O O\n"
        + "  O O O O O\n"
        + "    O O O", msmdefault.getGameState());
    assertFalse(msmdefault.isGameOver());
    assertEquals(35, msmdefault.getScore());

    //test pre-conditions
    assertEquals("    O O O\n"
        + "  O O O O O\n"
        + "O O O O O O O\n"
        + "O O O _ O O O\n"
        + "O O O O O O O\n"
        + "  O O O O O\n"
        + "    O O O", msmdefault2.getGameState());
    assertFalse(msmdefault2.isGameOver());
    assertEquals(36, msmdefault2.getScore());

    msmdefault2.move(1, 3, 3, 3);

    //test post-conditions
    assertEquals("    O O O\n"
        + "  O O _ O O\n"
        + "O O O _ O O O\n"
        + "O O O O O O O\n"
        + "O O O O O O O\n"
        + "  O O O O O\n"
        + "    O O O", msmdefault2.getGameState());
    assertFalse(msmdefault2.isGameOver());
    assertEquals(35, msmdefault2.getScore());
  }

  @Test
  public void testArmRowColConstructor() {
    //test pre-conditions
    assertEquals("        O O O O O\n"
        + "      O O O O O O O\n"
        + "    O O O O O O O O O\n"
        + "  O O O O O O O O O O O\n"
        + "O O O O _ O O O O O O O O\n"
        + "O O O O O O O O O O O O O\n"
        + "O O O O O O O O O O O O O\n"
        + "O O O O O O O O O O O O O\n"
        + "O O O O O O O O O O O O O\n"
        + "  O O O O O O O O O O O\n"
        + "    O O O O O O O O O\n"
        + "      O O O O O O O\n"
        + "        O O O O O", msm4.getGameState());
    assertFalse(msm4.isGameOver());
    assertEquals(128, msm4.getScore());

    msm4.move(4, 2, 4, 4);

    //test post-conditions
    assertEquals("        O O O O O\n"
        + "      O O O O O O O\n"
        + "    O O O O O O O O O\n"
        + "  O O O O O O O O O O O\n"
        + "O O _ _ O O O O O O O O O\n"
        + "O O O O O O O O O O O O O\n"
        + "O O O O O O O O O O O O O\n"
        + "O O O O O O O O O O O O O\n"
        + "O O O O O O O O O O O O O\n"
        + "  O O O O O O O O O O O\n"
        + "    O O O O O O O O O\n"
        + "      O O O O O O O\n"
        + "        O O O O O", msm4.getGameState());
    assertFalse(msm4.isGameOver());
    assertEquals(127, msm4.getScore());
  }

  @Test
  public void testArmSizeConstructor() {
    //test pre-conditions
    assertEquals("        O O O O O\n"
        + "      O O O O O O O\n"
        + "    O O O O O O O O O\n"
        + "  O O O O O O O O O O O\n"
        + "O O O O O O O O O O O O O\n"
        + "O O O O O O O O O O O O O\n"
        + "O O O O O O _ O O O O O O\n"
        + "O O O O O O O O O O O O O\n"
        + "O O O O O O O O O O O O O\n"
        + "  O O O O O O O O O O O\n"
        + "    O O O O O O O O O\n"
        + "      O O O O O O O\n"
        + "        O O O O O", msm3.getGameState());
    assertFalse(msm3.isGameOver());
    assertEquals(128, msm3.getScore());

    msm3.move(4, 6, 6, 6);

    //test post-conditions
    assertEquals("        O O O O O\n"
        + "      O O O O O O O\n"
        + "    O O O O O O O O O\n"
        + "  O O O O O O O O O O O\n"
        + "O O O O O O _ O O O O O O\n"
        + "O O O O O O _ O O O O O O\n"
        + "O O O O O O O O O O O O O\n"
        + "O O O O O O O O O O O O O\n"
        + "O O O O O O O O O O O O O\n"
        + "  O O O O O O O O O O O\n"
        + "    O O O O O O O O O\n"
        + "      O O O O O O O\n"
        + "        O O O O O", msm3.getGameState());
    assertFalse(msm3.isGameOver());
    assertEquals(127, msm3.getScore());
  }

  @Test
  public void testRowColConstructor() {
    //test pre-conditions
    assertEquals("    O O O\n"
        + "  O O O O O\n"
        + "O O O O O O O\n"
        + "O O O O O O O\n"
        + "O O _ O O O O\n"
        + "  O O O O O\n"
        + "    O O O", msm2.getGameState());
    assertFalse(msm2.isGameOver());
    assertEquals(36, msm2.getScore());

    msm2.move(6, 2, 4, 2);

    //test post-conditions
    assertEquals("    O O O\n"
        + "  O O O O O\n"
        + "O O O O O O O\n"
        + "O O O O O O O\n"
        + "O O O O O O O\n"
        + "  O _ O O O\n"
        + "    _ O O", msm2.getGameState());
    assertFalse(msm2.isGameOver());
    assertEquals(35, msm2.getScore());
  }

  @Test
  public void testDiagonalMove() {
    //test pre-conditions
    assertEquals("    O O O\n"
        + "  O O O O O\n"
        + "O O O O O O O\n"
        + "O O O O O O O\n"
        + "O O _ O O O O\n"
        + "  O O O O O\n"
        + "    O O O", msm2.getGameState());
    assertFalse(msm2.isGameOver());
    assertEquals(36, msm2.getScore());

    try {
      msm1.move(2, 4, 4, 2);
      fail("Invalid move should have thrown exception");
    } catch (IllegalArgumentException iae) {
      assertTrue(iae.getMessage().length() > 0);
    }

    //test post-conditions
    assertEquals("    O O O\n"
        + "  O O O O O\n"
        + "O O O O O O O\n"
        + "O O O O O O O\n"
        + "O O _ O O O O\n"
        + "  O O O O O\n"
        + "    O O O", msm2.getGameState());
    assertFalse(msm2.isGameOver());
    assertEquals(36, msm2.getScore());
  }

  @Test
  public void testMoveFromTopLeftCorner() {

    MarbleSolitaireModel temp = new EuropeanSolitaireModelImpl(1, 3);
    //test pre-conditions
    assertEquals("    O O O\n"
        + "  O O _ O O\n"
        + "O O O O O O O\n"
        + "O O O O O O O\n"
        + "O O O O O O O\n"
        + "  O O O O O\n"
        + "    O O O", temp.getGameState());
    assertFalse(temp.isGameOver());
    assertEquals(36, temp.getScore());

    temp.move(1, 1, 1, 3);

    //test post-conditions
    assertEquals("    O O O\n"
        + "  _ _ O O O\n"
        + "O O O O O O O\n"
        + "O O O O O O O\n"
        + "O O O O O O O\n"
        + "  O O O O O\n"
        + "    O O O", temp.getGameState());
    assertFalse(temp.isGameOver());
    assertEquals(35, temp.getScore());
  }

  @Test
  public void testMoveFromTopRightCorner() {

    MarbleSolitaireModel temp = new EuropeanSolitaireModelImpl(1, 3);
    //test pre-conditions
    assertEquals("    O O O\n"
        + "  O O _ O O\n"
        + "O O O O O O O\n"
        + "O O O O O O O\n"
        + "O O O O O O O\n"
        + "  O O O O O\n"
        + "    O O O", temp.getGameState());
    assertFalse(temp.isGameOver());
    assertEquals(36, temp.getScore());

    temp.move(1, 5, 1, 3);

    //test post-conditions
    assertEquals("    O O O\n"
        + "  O O O _ _\n"
        + "O O O O O O O\n"
        + "O O O O O O O\n"
        + "O O O O O O O\n"
        + "  O O O O O\n"
        + "    O O O", temp.getGameState());
    assertFalse(temp.isGameOver());
    assertEquals(35, temp.getScore());
  }

  @Test
  public void testMoveFromBottomLeftCorner() {

    MarbleSolitaireModel temp = new EuropeanSolitaireModelImpl(5, 3);
    //test pre-conditions
    assertEquals("    O O O\n"
        + "  O O O O O\n"
        + "O O O O O O O\n"
        + "O O O O O O O\n"
        + "O O O O O O O\n"
        + "  O O _ O O\n"
        + "    O O O", temp.getGameState());
    assertFalse(temp.isGameOver());
    assertEquals(36, temp.getScore());

    temp.move(5, 1, 5, 3);

    //test post-conditions
    assertEquals("    O O O\n"
        + "  O O O O O\n"
        + "O O O O O O O\n"
        + "O O O O O O O\n"
        + "O O O O O O O\n"
        + "  _ _ O O O\n"
        + "    O O O", temp.getGameState());
    assertFalse(temp.isGameOver());
    assertEquals(35, temp.getScore());
  }

  @Test
  public void testMoveFromBottomRightCorner() {

    MarbleSolitaireModel temp = new EuropeanSolitaireModelImpl(5, 3);
    //test pre-conditions
    assertEquals("    O O O\n"
        + "  O O O O O\n"
        + "O O O O O O O\n"
        + "O O O O O O O\n"
        + "O O O O O O O\n"
        + "  O O _ O O\n"
        + "    O O O", temp.getGameState());
    assertFalse(temp.isGameOver());
    assertEquals(36, temp.getScore());

    temp.move(5, 5, 5, 3);

    //test post-conditions
    assertEquals("    O O O\n"
        + "  O O O O O\n"
        + "O O O O O O O\n"
        + "O O O O O O O\n"
        + "O O O O O O O\n"
        + "  O O O _ _\n"
        + "    O O O", temp.getGameState());
    assertFalse(temp.isGameOver());
    assertEquals(35, temp.getScore());
  }


  @Test
  public void testMoveToTopLeftCorner() {

    MarbleSolitaireModel temp = new EuropeanSolitaireModelImpl(1, 1);
    //test pre-conditions
    assertEquals("    O O O\n"
        + "  _ O O O O\n"
        + "O O O O O O O\n"
        + "O O O O O O O\n"
        + "O O O O O O O\n"
        + "  O O O O O\n"
        + "    O O O", temp.getGameState());
    assertFalse(temp.isGameOver());
    assertEquals(36, temp.getScore());

    temp.move(1, 3, 1, 1);

    //test post-conditions
    assertEquals("    O O O\n"
        + "  O _ _ O O\n"
        + "O O O O O O O\n"
        + "O O O O O O O\n"
        + "O O O O O O O\n"
        + "  O O O O O\n"
        + "    O O O", temp.getGameState());
    assertFalse(temp.isGameOver());
    assertEquals(35, temp.getScore());
  }

  @Test
  public void testMoveToTopRightCorner() {

    MarbleSolitaireModel temp = new EuropeanSolitaireModelImpl(1, 5);
    //test pre-conditions
    assertEquals("    O O O\n"
        + "  O O O O _\n"
        + "O O O O O O O\n"
        + "O O O O O O O\n"
        + "O O O O O O O\n"
        + "  O O O O O\n"
        + "    O O O", temp.getGameState());
    assertFalse(temp.isGameOver());
    assertEquals(36, temp.getScore());

    temp.move(1, 3, 1, 5);

    //test post-conditions
    assertEquals("    O O O\n"
        + "  O O _ _ O\n"
        + "O O O O O O O\n"
        + "O O O O O O O\n"
        + "O O O O O O O\n"
        + "  O O O O O\n"
        + "    O O O", temp.getGameState());
    assertFalse(temp.isGameOver());
    assertEquals(35, temp.getScore());
  }

  @Test
  public void testMoveToBottomLeftCorner() {

    MarbleSolitaireModel temp = new EuropeanSolitaireModelImpl(5, 1);
    //test pre-conditions
    assertEquals("    O O O\n"
        + "  O O O O O\n"
        + "O O O O O O O\n"
        + "O O O O O O O\n"
        + "O O O O O O O\n"
        + "  _ O O O O\n"
        + "    O O O", temp.getGameState());
    assertFalse(temp.isGameOver());
    assertEquals(36, temp.getScore());

    temp.move(5, 3, 5, 1);

    //test post-conditions
    assertEquals("    O O O\n"
        + "  O O O O O\n"
        + "O O O O O O O\n"
        + "O O O O O O O\n"
        + "O O O O O O O\n"
        + "  O _ _ O O\n"
        + "    O O O", temp.getGameState());
    assertFalse(temp.isGameOver());
    assertEquals(35, temp.getScore());
  }

  @Test
  public void testMoveToBottomRightCorner() {

    MarbleSolitaireModel temp = new EuropeanSolitaireModelImpl(5, 5);
    //test pre-conditions
    assertEquals("    O O O\n"
        + "  O O O O O\n"
        + "O O O O O O O\n"
        + "O O O O O O O\n"
        + "O O O O O O O\n"
        + "  O O O O _\n"
        + "    O O O", temp.getGameState());
    assertFalse(temp.isGameOver());
    assertEquals(36, temp.getScore());

    temp.move(5, 3, 5, 5);

    //test post-conditions
    assertEquals("    O O O\n"
        + "  O O O O O\n"
        + "O O O O O O O\n"
        + "O O O O O O O\n"
        + "O O O O O O O\n"
        + "  O O _ _ O\n"
        + "    O O O", temp.getGameState());
    assertFalse(temp.isGameOver());
    assertEquals(35, temp.getScore());
  }

  @Test
  public void testMove() {
    //test pre-conditions
    assertEquals("    O O O\n"
        + "  O O O O O\n"
        + "O O O O O O O\n"
        + "O O O _ O O O\n"
        + "O O O O O O O\n"
        + "  O O O O O\n"
        + "    O O O", msm1.getGameState());
    assertFalse(msm1.isGameOver());
    assertEquals(36, msm1.getScore());

    msm1.move(1, 3, 3, 3);

    //test post-conditions
    assertEquals("    O O O\n"
        + "  O O _ O O\n"
        + "O O O _ O O O\n"
        + "O O O O O O O\n"
        + "O O O O O O O\n"
        + "  O O O O O\n"
        + "    O O O", msm1.getGameState());
    assertFalse(msm1.isGameOver());
    assertEquals(35, msm1.getScore());
  }

  @Test
  public void testMoveUp() {
    //test pre-conditions
    assertEquals("    O O O\n"
        + "  O O O O O\n"
        + "O O O O O O O\n"
        + "O O O _ O O O\n"
        + "O O O O O O O\n"
        + "  O O O O O\n"
        + "    O O O", msm1.getGameState());
    assertFalse(msm1.isGameOver());
    assertEquals(36, msm1.getScore());

    msm1.move(5, 3, 3, 3);

    //test post-conditions
    assertEquals("    O O O\n"
        + "  O O O O O\n"
        + "O O O O O O O\n"
        + "O O O O O O O\n"
        + "O O O _ O O O\n"
        + "  O O _ O O\n"
        + "    O O O", msm1.getGameState());
    assertFalse(msm1.isGameOver());
    assertEquals(35, msm1.getScore());
  }

  @Test
  public void testMoveRight() {
    //test pre-conditions
    assertEquals("    O O O\n"
        + "  O O O O O\n"
        + "O O O O O O O\n"
        + "O O O _ O O O\n"
        + "O O O O O O O\n"
        + "  O O O O O\n"
        + "    O O O", msm1.getGameState());
    assertFalse(msm1.isGameOver());
    assertEquals(36, msm1.getScore());

    msm1.move(3, 1, 3, 3);

    //test post-conditions
    assertEquals("    O O O\n"
        + "  O O O O O\n"
        + "O O O O O O O\n"
        + "O _ _ O O O O\n"
        + "O O O O O O O\n"
        + "  O O O O O\n"
        + "    O O O", msm1.getGameState());
    assertFalse(msm1.isGameOver());
    assertEquals(35, msm1.getScore());
  }

  @Test
  public void testMoveLeft() {
    //test pre-conditions
    assertEquals("    O O O\n"
        + "  O O O O O\n"
        + "O O O O O O O\n"
        + "O O O _ O O O\n"
        + "O O O O O O O\n"
        + "  O O O O O\n"
        + "    O O O", msm1.getGameState());
    assertFalse(msm1.isGameOver());
    assertEquals(36, msm1.getScore());

    msm1.move(3, 5, 3, 3);

    //test post-conditions
    assertEquals("    O O O\n"
        + "  O O O O O\n"
        + "O O O O O O O\n"
        + "O O O O _ _ O\n"
        + "O O O O O O O\n"
        + "  O O O O O\n"
        + "    O O O", msm1.getGameState());
    assertFalse(msm1.isGameOver());
    assertEquals(35, msm1.getScore());
  }

  @Test
  public void testInvalidMoveOverEmptySpace() {
    //test pre-conditions
    assertEquals("    O O O\n"
        + "  O O O O O\n"
        + "O O O O O O O\n"
        + "O O O _ O O O\n"
        + "O O O O O O O\n"
        + "  O O O O O\n"
        + "    O O O", msm1.getGameState());
    assertFalse(msm1.isGameOver());
    assertEquals(36, msm1.getScore());

    msm1.move(1, 3, 3, 3);

    //test post-conditions
    assertEquals("    O O O\n"
        + "  O O _ O O\n"
        + "O O O _ O O O\n"
        + "O O O O O O O\n"
        + "O O O O O O O\n"
        + "  O O O O O\n"
        + "    O O O", msm1.getGameState());
    assertFalse(msm1.isGameOver());
    assertEquals(35, msm1.getScore());

    try {
      msm1.move(0, 3, 2, 3);
      fail("Invalid move should have thrown exception");
    } catch (IllegalArgumentException iae) {
      //assertEquals("Position occupied", iae.getMessage());
      assertTrue(iae.getMessage().length() > 0);
    }

    assertEquals("    O O O\n"
        + "  O O _ O O\n"
        + "O O O _ O O O\n"
        + "O O O O O O O\n"
        + "O O O O O O O\n"
        + "  O O O O O\n"
        + "    O O O", msm1.getGameState());
    assertFalse(msm1.isGameOver());
    assertEquals(35, msm1.getScore());
  }

  @Test
  public void testFullGameLose() {
    //test pre-conditions
    assertEquals("    O O O\n"
        + "  O O O O O\n"
        + "O O O O O O O\n"
        + "O O O _ O O O\n"
        + "O O O O O O O\n"
        + "  O O O O O\n"
        + "    O O O", msm1.getGameState());
    assertFalse(msm1.isGameOver());
    assertEquals(36, msm1.getScore());

    msm1.move(3, 5, 3, 3);
    assertFalse(msm1.isGameOver());
    assertEquals(35, msm1.getScore());
    msm1.move(1, 4, 3, 4);
    assertFalse(msm1.isGameOver());
    assertEquals(34, msm1.getScore());
    msm1.move(2, 6, 2, 4);
    assertFalse(msm1.isGameOver());
    assertEquals(33, msm1.getScore());
    msm1.move(4, 6, 2, 6);
    assertFalse(msm1.isGameOver());
    assertEquals(32, msm1.getScore());
    msm1.move(2, 3, 2, 5);
    assertFalse(msm1.isGameOver());
    assertEquals(31, msm1.getScore());
    msm1.move(2, 6, 2, 4);
    assertFalse(msm1.isGameOver());
    assertEquals(30, msm1.getScore());
    msm1.move(2, 1, 2, 3);
    assertFalse(msm1.isGameOver());
    assertEquals(29, msm1.getScore());
    msm1.move(0, 2, 2, 2);
    assertFalse(msm1.isGameOver());
    assertEquals(28, msm1.getScore());
    msm1.move(0, 4, 0, 2);
    assertFalse(msm1.isGameOver());
    assertEquals(27, msm1.getScore());
    msm1.move(3, 2, 1, 2);
    assertFalse(msm1.isGameOver());
    assertEquals(26, msm1.getScore());
    msm1.move(0, 2, 2, 2);
    assertFalse(msm1.isGameOver());
    assertEquals(25, msm1.getScore());
    msm1.move(5, 2, 3, 2);
    assertFalse(msm1.isGameOver());
    assertEquals(24, msm1.getScore());
    msm1.move(4, 0, 4, 2);
    assertFalse(msm1.isGameOver());
    assertEquals(23, msm1.getScore());
    msm1.move(2, 0, 4, 0);
    assertFalse(msm1.isGameOver());
    assertEquals(22, msm1.getScore());
    msm1.move(4, 3, 4, 1);
    assertFalse(msm1.isGameOver());
    assertEquals(21, msm1.getScore());
    msm1.move(4, 0, 4, 2);
    assertFalse(msm1.isGameOver());
    assertEquals(20, msm1.getScore());
    msm1.move(4, 5, 4, 3);
    assertFalse(msm1.isGameOver());
    assertEquals(19, msm1.getScore());
    msm1.move(6, 4, 4, 4);
    assertFalse(msm1.isGameOver());
    assertEquals(18, msm1.getScore());
    msm1.move(6, 2, 6, 4);
    assertFalse(msm1.isGameOver());
    assertEquals(17, msm1.getScore());
    msm1.move(3, 4, 5, 4);
    assertFalse(msm1.isGameOver());
    assertEquals(16, msm1.getScore());
    msm1.move(6, 4, 4, 4);
    assertFalse(msm1.isGameOver());
    assertEquals(15, msm1.getScore());
    msm1.move(3, 2, 1, 2);
    assertFalse(msm1.isGameOver());
    assertEquals(14, msm1.getScore());
    msm1.move(1, 2, 1, 4);
    assertFalse(msm1.isGameOver());
    assertEquals(13, msm1.getScore());
    msm1.move(1, 4, 3, 4);
    assertFalse(msm1.isGameOver());
    assertEquals(12, msm1.getScore());
    msm1.move(3, 4, 5, 4);
    assertFalse(msm1.isGameOver());
    assertEquals(11, msm1.getScore());
    msm1.move(5, 4, 5, 2);
    assertFalse(msm1.isGameOver());
    assertEquals(10, msm1.getScore());
    msm1.move(5, 2, 3, 2);
    assertFalse(msm1.isGameOver());
    assertEquals(9, msm1.getScore());
    msm1.move(3, 3, 1, 3);
    assertFalse(msm1.isGameOver());
    assertEquals(8, msm1.getScore());
    msm1.move(3, 1, 3, 3);
    assertFalse(msm1.isGameOver());
    assertEquals(7, msm1.getScore());
    msm1.move(4, 3, 2, 3);
    assertFalse(msm1.isGameOver());
    assertEquals(6, msm1.getScore());
    msm1.move(1, 3, 3, 3);

    //test post-conditions
    assertEquals("    _ _ _\n"
        + "  O _ _ _ O\n"
        + "_ _ _ _ _ _ _\n"
        + "_ _ _ O _ _ _\n"
        + "_ _ _ _ _ _ _\n"
        + "  O _ _ _ O\n"
        + "    _ _ _", msm1.getGameState());
    assertTrue(msm1.isGameOver());
    assertEquals(5, msm1.getScore());
  }

  @Test
  public void testGameLose() {
    //test pre-conditions
    assertEquals("    O O O\n"
        + "  O O O O O\n"
        + "O O O O O O O\n"
        + "O O O _ O O O\n"
        + "O O O O O O O\n"
        + "  O O O O O\n"
        + "    O O O", msm1.getGameState());
    assertFalse(msm1.isGameOver());
    assertEquals(36, msm1.getScore());

    msm1.move(3, 5, 3, 3);
    msm1.move(1, 4, 3, 4);
    msm1.move(2, 6, 2, 4);
    msm1.move(4, 6, 2, 6);
    msm1.move(2, 3, 2, 5);
    msm1.move(2, 6, 2, 4);
    msm1.move(2, 1, 2, 3);
    msm1.move(0, 2, 2, 2);
    msm1.move(0, 4, 0, 2);
    msm1.move(3, 2, 1, 2);
    msm1.move(0, 2, 2, 2);
    msm1.move(5, 2, 3, 2);
    msm1.move(4, 0, 4, 2);
    msm1.move(2, 0, 4, 0);
    msm1.move(4, 3, 4, 1);
    msm1.move(4, 0, 4, 2);
    msm1.move(4, 5, 4, 3);
    msm1.move(6, 4, 4, 4);
    msm1.move(6, 2, 6, 4);
    msm1.move(3, 4, 5, 4);
    msm1.move(6, 4, 4, 4);
    msm1.move(3, 2, 1, 2);
    msm1.move(1, 2, 1, 4);
    msm1.move(1, 4, 3, 4);
    msm1.move(3, 4, 5, 4);
    msm1.move(5, 4, 5, 2);
    msm1.move(5, 2, 3, 2);
    msm1.move(3, 2, 3, 4);

    //test post-conditions
    assertEquals("    _ _ _\n"
        + "  O _ _ _ O\n"
        + "_ _ _ O _ _ _\n"
        + "_ O _ _ O _ _\n"
        + "_ _ _ O _ _ _\n"
        + "  O _ _ _ O\n"
        + "    _ _ _", msm1.getGameState());
    assertTrue(msm1.isGameOver());
    assertEquals(8, msm1.getScore());
  }

  @Test
  public void testMoveAfterGameOver() {
    //test pre-conditions
    assertEquals("    O O O\n"
        + "  O O O O O\n"
        + "O O O O O O O\n"
        + "O O O _ O O O\n"
        + "O O O O O O O\n"
        + "  O O O O O\n"
        + "    O O O", msm1.getGameState());
    assertFalse(msm1.isGameOver());
    assertEquals(36, msm1.getScore());

    msm1.move(3, 5, 3, 3);
    msm1.move(1, 4, 3, 4);
    msm1.move(2, 6, 2, 4);
    msm1.move(4, 6, 2, 6);
    msm1.move(2, 3, 2, 5);
    msm1.move(2, 6, 2, 4);
    msm1.move(2, 1, 2, 3);
    msm1.move(0, 2, 2, 2);
    msm1.move(0, 4, 0, 2);
    msm1.move(3, 2, 1, 2);
    msm1.move(0, 2, 2, 2);
    msm1.move(5, 2, 3, 2);
    msm1.move(4, 0, 4, 2);
    msm1.move(2, 0, 4, 0);
    msm1.move(4, 3, 4, 1);
    msm1.move(4, 0, 4, 2);
    msm1.move(4, 5, 4, 3);
    msm1.move(6, 4, 4, 4);
    msm1.move(6, 2, 6, 4);
    msm1.move(3, 4, 5, 4);
    msm1.move(6, 4, 4, 4);
    msm1.move(3, 2, 1, 2);
    msm1.move(1, 2, 1, 4);
    msm1.move(1, 4, 3, 4);
    msm1.move(3, 4, 5, 4);
    msm1.move(5, 4, 5, 2);
    msm1.move(5, 2, 3, 2);
    msm1.move(3, 2, 3, 4);
    try {
      msm1.move(3, 1, 3, 3);
      fail("Invalid move should have thrown exception");
    } catch (IllegalStateException iae) {
      //assertEquals("Position occupied", iae.getMessage());
      assertTrue(iae.getMessage().length() > 0);
    }

    //test post-conditions
    assertEquals("    _ _ _\n"
        + "  O _ _ _ O\n"
        + "_ _ _ O _ _ _\n"
        + "_ O _ _ O _ _\n"
        + "_ _ _ O _ _ _\n"
        + "  O _ _ _ O\n"
        + "    _ _ _", msm1.getGameState());
    assertTrue(msm1.isGameOver());
    assertEquals(8, msm1.getScore());
  }

  @Test
  public void testGetScore() {
    //test pre-conditions
    assertEquals("    O O O\n"
        + "  O O O O O\n"
        + "O O O O O O O\n"
        + "O O O _ O O O\n"
        + "O O O O O O O\n"
        + "  O O O O O\n"
        + "    O O O", msm1.getGameState());
    assertFalse(msm1.isGameOver());
    assertEquals(36, msm1.getScore());

    msm1.move(3, 5, 3, 3);
    msm1.move(1, 4, 3, 4);
    msm1.move(2, 6, 2, 4);
    msm1.move(4, 6, 2, 6);
    msm1.move(2, 3, 2, 5);
    msm1.move(2, 6, 2, 4);
    msm1.move(2, 1, 2, 3);
    msm1.move(0, 2, 2, 2);
    msm1.move(0, 4, 0, 2);
    msm1.move(3, 2, 1, 2);
    msm1.move(0, 2, 2, 2);
    msm1.move(5, 2, 3, 2);

    assertFalse(msm1.isGameOver());
    assertEquals(24, msm1.getScore());
  }

  @Test
  public void testIsGameOverFalse() {
    //test pre-conditions
    assertEquals("    O O O\n"
        + "  O O O O O\n"
        + "O O O O O O O\n"
        + "O O O _ O O O\n"
        + "O O O O O O O\n"
        + "  O O O O O\n"
        + "    O O O", msm1.getGameState());
    assertFalse(msm1.isGameOver());
    assertEquals(36, msm1.getScore());

    msm1.move(3, 5, 3, 3);
    msm1.move(1, 4, 3, 4);
    msm1.move(2, 6, 2, 4);
    msm1.move(4, 6, 2, 6);
    msm1.move(2, 3, 2, 5);

    assertFalse(msm1.isGameOver());
    assertEquals(31, msm1.getScore());
  }

  @Test
  public void testInvalidMoveUpperLeft() {
    try {
      msm1.move(2, 1, 0, 1);
      fail("Invalid move should have thrown exception");
    } catch (IllegalArgumentException iae) {
      //assertEquals("Position occupied", iae.getMessage());
      assertTrue(iae.getMessage().length() > 0);
    }
  }

  @Test
  public void testInvalidMoveUpperRight() {
    try {
      msm1.move(2, 6, 0, 6);
      fail("Invalid move should have thrown exception");
    } catch (IllegalArgumentException iae) {
      //assertEquals("Position occupied", iae.getMessage());
      assertTrue(iae.getMessage().length() > 0);
    }
  }

  @Test
  public void testInvalidMoveLowerLeft() {
    try {
      msm1.move(4, 0, 6, 0);
      fail("Invalid move should have thrown exception");
    } catch (IllegalArgumentException iae) {
      //assertEquals("Position occupied", iae.getMessage());
      assertTrue(iae.getMessage().length() > 0);
    }
  }

  @Test
  public void testInvalidMoveLowerRight() {
    try {
      msm1.move(4, 5, 6, 5);
      fail("Invalid move should have thrown exception");
    } catch (IllegalArgumentException iae) {
      //assertEquals("Position occupied", iae.getMessage());
      assertTrue(iae.getMessage().length() > 0);
    }
  }

  @Test
  public void testInvalidMoveInvalidFrom() {
    try {
      msm1.move(0, 0, 0, 2);
      fail("Invalid move should have thrown exception");
    } catch (IllegalArgumentException iae) {
      //assertEquals("Position occupied", iae.getMessage());
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
      //assertEquals("Position occupied", iae.getMessage());
      assertTrue(iae.getMessage().length() > 0);
    }
    try {
      msm1.move(1, 3, 4, 3);
      fail("Invalid move should have thrown exception");
    } catch (IllegalArgumentException iae) {
      //assertEquals("Position occupied", iae.getMessage());
      assertTrue(iae.getMessage().length() > 0);
    }
    try {
      msm1.move(1, 3, 5, 3);
      fail("Invalid move should have thrown exception");
    } catch (IllegalArgumentException iae) {
      //assertEquals("Position occupied", iae.getMessage());
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