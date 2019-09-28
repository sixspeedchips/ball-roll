package edu.cnm.deepdive.view;

import static javafx.scene.input.KeyEvent.*;

import edu.cnm.deepdive.controller.Controller;
import edu.cnm.deepdive.model.Ball;
import javafx.application.Application;
import javafx.geometry.BoundingBox;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class View extends Application {

  @Override
  public void start(Stage stage) {
    Ball ball = new Ball();
    stage.setScene(createScene(new Surface(500,500, ball)));
    Controller controller = new Controller(ball);
    stage.getScene().addEventHandler(KEY_PRESSED, controller);
    ball.start();
    stage.show();

  }

  private Scene createScene(Node ...children){
    StackPane root = new StackPane();
    root.getChildren().addAll(children);
    Scene scene = new Scene(root,500,500);
    scene.getStylesheets().add("style_1.css");
    return scene;
  }

}
