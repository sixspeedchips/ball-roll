package edu.cnm.deepdive.view;

import edu.cnm.deepdive.model.Ball;
import javafx.beans.property.DoubleProperty;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class Surface extends Pane {

  BallView ballView = new BallView();

  public Surface(int width, int height, Ball ball) {
    ballView = new BallView();
    ballView.centerXProperty().bind(ball.xPosProperty());
    ballView.centerYProperty().bind(ball.yPosProperty());
    prefWidth(width);
    prefHeight(height);
    getChildren().add(ballView);

    setStyle("-fx-background-color: #2f2f2f;"
        + "-fx-padding: 10");

  }

  public void update(){

  }



  private class BallView extends Circle {

    BallView() {
      radiusProperty().bind(Surface.this.heightProperty().divide(10));
      this.setFill(Color.RED);
          //setBackground(new Background(new BackgroundFill(Color.RED,null,null)));
    }
  }

}
