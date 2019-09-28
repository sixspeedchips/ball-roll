package edu.cnm.deepdive.controller;

import edu.cnm.deepdive.model.Ball;
import javafx.event.EventHandler;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class Controller implements EventHandler<KeyEvent> {

  final private Ball ball;

  public Controller(Ball ball) {
    this.ball = ball;
  }


  @Override
  public void handle(KeyEvent keyEvent) {
    KeyCode kc = keyEvent.getCode();
    if ( kc == KeyCode.A || kc == KeyCode.LEFT) {
      ball.updatePos(-1D, 0D);
    } else if (kc == KeyCode.S|| kc == KeyCode.DOWN) {
      ball.updatePos(0D, 1D);
    } else if (kc == KeyCode.D|| kc == KeyCode.RIGHT) {
      ball.updatePos(1D, 0D);
    } else if (kc == KeyCode.W|| kc == KeyCode.UP) {
      ball.updatePos(0D, -1D);
    } else if (kc == KeyCode.SPACE) {
      ball.resetMovement();
    }
  }



}
