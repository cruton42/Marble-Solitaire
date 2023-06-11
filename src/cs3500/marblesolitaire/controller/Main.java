package cs3500.marblesolitaire.controller;

import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModelImpl;
import java.io.InputStreamReader;

/**
 * Run a Marble Solitaire game interactively on the console.
 */
public class Main {

  /**
   * Run a Marble Solitaire game interactively on the console.
   */
  public static void main(String[] args) {
    new MarbleSolitaireControllerImpl(new InputStreamReader(System.in),
        System.out).playGame(new MarbleSolitaireModelImpl());
  }
}
