package edu.cnm.deepdive.view;

import edu.cnm.deepdive.model.Ball;
import java.util.concurrent.TimeUnit;
import javafx.animation.StrokeTransition;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

public class Surface extends Pane {

  private BallView ballView;

  public Surface(int width, int height, Ball ball) {

    getChildren().add(new Rectangle(width,height));
    getChildren().add(new BallView(ball));
    ball.setBounds(getBoundsInParent());
    ball.setRadius(getBoundsInParent().getWidth()/20);

    setStyle("-fx-background-color: #2f2f2f;"
        + "-fx-padding: 10");



  }


  private class BallView extends Circle {

    private Color ballColor = Color.DEEPSKYBLUE;
    private Color collisionColor = Color.GREENYELLOW;

    public BallView(Ball ball) {
      this.setFill(ballColor);
      centerXProperty().bind(ball.xPosProperty());
      centerYProperty().bind(ball.yPosProperty());
      radiusProperty().bind(ball.radiusProperty());
      setStroke(ballColor);
      setStrokeWidth(10);
      ball.hasCollided().addListener(observable -> {
        if(ball.hasCollided().getValue()){
          new StrokeTransition(Duration.seconds(1),this,collisionColor,ballColor).play();
        }
      });
    }
  }

}
