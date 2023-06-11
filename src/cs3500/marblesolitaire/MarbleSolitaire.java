package cs3500.marblesolitaire;

import cs3500.marblesolitaire.controller.MarbleSolitaireControllerImpl;
import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModel;
import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModelImpl;
import cs3500.marblesolitaire.model.hw04.EuropeanSolitaireModelImpl;
import cs3500.marblesolitaire.model.hw04.TriangleSolitaireModelImpl;
import java.io.InputStreamReader;

/**
 * Class to act as the main runner for a new MarbleSolitaire game.
 */
public final class MarbleSolitaire {

  /**
   * PSVM method to take in a command line and execute the proper Marble Solitaire game.
   *
   * @param args the command line to be executed
   */
  public static void main(String[] args) {
    MarbleSolitaireModel m;
    String gameMode = "";
    boolean gotSize = false;
    boolean gotHole = false;
    int size = -1;
    int sRow = -1;
    int sCol = -1;

    for (int i = 0; i < args.length; i++) {

      if (args[i].equals("english") || args[i].equals("european")
          || args[i].equals("triangular")) {
        gameMode = args[i];
      }
      else {
        switch (args[i]) {
          case "-hole":
            try {
              sRow = Integer.parseInt(args[i + 1]);
              sCol = Integer.parseInt(args[i + 2]);
            } catch (final NumberFormatException e) {
              break;
            }
            gotHole = true;
            i = i + 2;
            break;
          case "-size":
            try {
              size = Integer.parseInt(args[i + 1]);
            } catch (final NumberFormatException e) {
              break;
            }
            gotSize = true;
            i++;
            break;
          default:
            throw new IllegalArgumentException("Invalid command line.");
        }
      }
    }

    switch (gameMode) {
      case "english":
        if (gotSize && gotHole) {
          m = new MarbleSolitaireModelImpl(size, sRow, sCol);
        } else if (gotSize) {
          m = new MarbleSolitaireModelImpl(size);
        } else if (gotHole) {
          m = new MarbleSolitaireModelImpl(sRow, sCol);
        } else {
          m = new MarbleSolitaireModelImpl();
        }
        break;
      case "european":
        if (gotSize && gotHole) {
          m = new EuropeanSolitaireModelImpl(size, sRow, sCol);
        } else if (gotSize) {
          m = new EuropeanSolitaireModelImpl(size);
        } else if (gotHole) {
          m = new EuropeanSolitaireModelImpl(sRow, sCol);
        } else {
          m = new EuropeanSolitaireModelImpl();
        }
        break;
      case "triangular":
        if (gotSize && gotHole) {
          m = new TriangleSolitaireModelImpl(size, sRow, sCol);
        } else if (gotSize) {
          m = new TriangleSolitaireModelImpl(size);
        } else if (gotHole) {
          m = new TriangleSolitaireModelImpl(sRow, sCol);
        } else {
          m = new TriangleSolitaireModelImpl();
        }
        break;
      default:
        throw new IllegalArgumentException("You didn't pick a game mode.");
    }

    new MarbleSolitaireControllerImpl(new InputStreamReader(System.in), System.out).playGame(m);
  }
}
