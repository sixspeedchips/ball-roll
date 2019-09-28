package edu.cnm.deepdive.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;

public class Ball {


  private final Position current;

  public DoubleProperty xPosProperty() {
    return current.xPosProperty();
  }

  public DoubleProperty yPosProperty() {
    return current.yPosProperty();
  }

  public void updatePos(Double x, Double y){
    System.out.println("direction was: " + x +","+y);
  }

  public Ball() {
    current = new Position();

  }

  private static class Position{

    private final DoubleProperty xPos;
    private final DoubleProperty yPos;
    private final DoubleProperty angle;
    private final DoubleProperty velocity;

    private Position() {
      xPos = new SimpleDoubleProperty(100);
      yPos = new SimpleDoubleProperty(100);
      velocity = new SimpleDoubleProperty(0);
      angle = new SimpleDoubleProperty(0);
    }

    public double getxPos() {
      return xPos.get();
    }

    public DoubleProperty xPosProperty() {
      return xPos;
    }

    public double getyPos() {
      return yPos.get();
    }

    public DoubleProperty yPosProperty() {
      return yPos;
    }



  }
}
