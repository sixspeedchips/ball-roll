package edu.cnm.deepdive.controller;

import edu.cnm.deepdive.model.Ball;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.TimeUnit;
import javafx.animation.AnimationTimer;
import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;

public class Controller implements EventHandler<KeyEvent> {

  final private Ball ball;

  public Controller(Ball ball) {
    this.ball = ball;

  }


  @Override
  public void handle(KeyEvent keyEvent) {
    switch (keyEvent.getCode()){

      case A:
        ball.updatePos(-1D,0D);
        break;
      case S:
        ball.updatePos(0D,-1D);
        break;
      case D:
        ball.updatePos(1D,0D);
        break;
      case W:
        ball.updatePos(0D,1D);
        break;

    }
  }



}
