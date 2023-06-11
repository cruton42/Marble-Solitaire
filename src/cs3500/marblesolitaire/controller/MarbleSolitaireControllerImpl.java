package cs3500.marblesolitaire.controller;

import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModel;
import java.io.IOException;
import java.util.Scanner;

/**
 * Class representing a Console Controller for the MarbleSolitaireModel. Must be provided a non-null
 * readable and appendable type.
 */
public class MarbleSolitaireControllerImpl implements MarbleSolitaireController {

  private final Readable in;
  private final Appendable out;

  /**
   * Constructs a controller for the Marble Solitaire game Model.
   *
   * @param rd input stream from which the controller reads values to play the game
   * @param ap output stream on which the controller appends the gameLog
   * @throws IllegalArgumentException if the provided readable or appendable are null
   */
  public MarbleSolitaireControllerImpl(Readable rd, Appendable ap) throws IllegalArgumentException {
    if (rd == null || ap == null) {
      throw new IllegalArgumentException("Readable and appendable must not be null!");
    }

    this.in = rd;
    this.out = ap;
  }

  /**
   * Plays a game of Marble Solitaire using the given model.
   *
   * @param model the MarbleSolitaireModel from which to play the game
   * @throws IllegalArgumentException if the provided model is null
   * @throws IllegalStateException    only if the controller is unable to successfully receive input
   *                                  or transmit output
   * @throws IllegalStateException    if there is any issue reading {@code this.in} or appending
   *                                  {@code this.out}
   */
  @Override
  public void playGame(MarbleSolitaireModel model) {
    if (model == null) {
      throw new IllegalArgumentException("Given model was null.");
    }
    try {
      this.out.append(model.getGameState()).append("\n");
      this.out.append("Score: ").append(String.valueOf(model.getScore())).append("\n");
    } catch (IOException e) {
      throw new IllegalStateException("Could not write to output.");
    }

    Scanner scan = new Scanner(this.in);

    while (!model.isGameOver()) {
      int fromRow = -1;
      boolean gotFromRow = false;
      int fromCol = -1;
      boolean gotFromCol = false;
      int toRow = -1;
      boolean gotToRow = false;
      int toCol = -1;
      boolean gotToCol = false;

      if (!scan.hasNext()) {
        break;
      }

      if (scan.hasNext("q") || scan.hasNext("Q")) {
        try {
          this.out.append("Game quit!\n");
          this.out.append("State of game when quit:\n");
          this.out.append(model.getGameState()).append("\n");
          this.out.append("Score: ").append(String.valueOf(model.getScore())).append("\n");
        } catch (IOException ioe) {
          throw new IllegalStateException("Append failed", ioe);
        }
        break;
      }

      while (!(gotFromRow && gotFromCol && gotToRow && gotToCol)) {
        if (scan.hasNext("q") || scan.hasNext("Q")) {
          break;
        } else if (!scan.hasNextInt()) {
          if (!scan.hasNext()) {
            break;
          }
          try {
            this.out.append("Please enter a positive integer:\n");
          } catch (IOException ioe) {
            throw new IllegalStateException("Append failed", ioe);
          }
          scan.next();
        } else if (!gotFromRow) {
          fromRow = scan.nextInt();
          gotFromRow = true;
        } else if (!gotFromCol) {
          fromCol = scan.nextInt();
          gotFromCol = true;
        } else if (!gotToRow) {
          toRow = scan.nextInt();
          gotToRow = true;
        } else if (!gotToCol) {
          toCol = scan.nextInt();
          gotToCol = true;

          try {
            model.move(fromRow - 1, fromCol - 1, toRow - 1, toCol - 1);
          } catch (IllegalArgumentException iae) {
            try {
              out.append("Invalid move. Play again. ").append(iae.getMessage()).append("\n");
              break;
            } catch (IOException ioe) {
              throw new IllegalStateException("Append failed", ioe);
            }
          }

          if (model.isGameOver()) {
            try {
              this.out.append("Game over!\n");
              this.out.append(model.getGameState()).append("\n");
              this.out.append("Score: ").append(String.valueOf(model.getScore())).append("\n");
            } catch (IOException e) {
              throw new IllegalStateException("Could not write to output.");
            }
            break;
          } else {
            try {
              this.out.append(model.getGameState()).append("\n");
              this.out.append("Score: ").append(String.valueOf(model.getScore())).append("\n");
            } catch (IOException e) {
              throw new IllegalStateException("Could not write to output.");
            }

            if (scan.hasNext()) {
              gotFromRow = false;
              gotFromCol = false;
              gotToRow = false;
              gotToCol = false;
            }
          }
        }
      }
    }

    if (model.isGameOver()) {
      // This is left empty to ensure that the console is not left
      // waiting for an input if the game is over.
    } else if (!scan.hasNext()) {
      throw new IllegalStateException("Readable is out of inputs");
    }
  }
}
