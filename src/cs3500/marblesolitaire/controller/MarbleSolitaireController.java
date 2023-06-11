package cs3500.marblesolitaire.controller;

import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModel;

/**
 * Interface representing the controller for a Marble Solitaire game. Receives user inputs and plays
 * through the game.
 */
public interface MarbleSolitaireController {

  /**
   * Plays a new game of Marble Solitaire using the provided model.
   *
   * @param model the MarbleSolitaireModel from which to play the game
   * @throws IllegalArgumentException if the provided model is null
   * @throws IllegalStateException    only if the controller is unable to successfully receive input
   *                                  or transmit output
   */
  void playGame(MarbleSolitaireModel model);
}
