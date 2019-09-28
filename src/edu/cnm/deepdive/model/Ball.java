package edu.cnm.deepdive.model;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import javafx.application.Platform;
import javafx.beans.binding.Bindings;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.geometry.Bounds;

public class Ball{

  private final static ScheduledExecutorService ses =
      Executors.newSingleThreadScheduledExecutor();

  private final Double modifier;
  private final Double decay;
  private final Position position;
  private final BooleanProperty collided;
  private DoubleProperty radius;
  private Bounds bounds;

  public Ball() {
    radius = new SimpleDoubleProperty();
    position = new Position();
    modifier = .2;
    decay = .8;
    collided = new SimpleBooleanProperty(false);
  }

  public DoubleProperty xPosProperty() {
    return position.xPosProperty();
  }

  public DoubleProperty yPosProperty() {
    return position.yPosProperty();
  }

  public void updatePos(Double x, Double y){
    position.update(x*modifier,y*modifier);
  }

  public void start(){
    ses.scheduleAtFixedRate(position,0,10, TimeUnit.MILLISECONDS);
  }

  public void resetMovement() {
    position.reset();
  }

  public void setBounds(Bounds bounds) {
    this.bounds = bounds;
  }

  public DoubleProperty radiusProperty() {
    return radius;
  }

  public void setRadius(Double radius) {
    this.radius.set(radius);
  }

  public BooleanProperty hasCollided() {
    return collided;
  }


  private void checkCollision(Double nextX, Double nextY) {
    if(nextX+radius.get()>bounds.getMaxX()){
      position.xVect.set(-position.xVect.get()*decay);
      collided.set(true);
    }
    if(nextX-radius.get()<bounds.getMinX()){
      position.xVect.set(-position.xVect.get()*decay);
      collided.set(true);

    }
    if(nextY+radius.get()>bounds.getMaxY()){
      position.yVect.set(-position.yVect.get()*decay);
      collided.set(true);

    }
    if(nextY-radius.get()<bounds.getMinY()){
      position.yVect.set(-position.yVect.get()*decay);
      collided.set(true);

    }
  }

  private Double decay(){

    return Math.abs(1-Math.exp(-position.speed.get()));

  }

  private class Position implements Runnable{

    private final DoubleProperty xPos;
    private final DoubleProperty yPos;
    private final DoubleProperty xVect;
    private final DoubleProperty yVect;
    private final DoubleProperty speed;
    private Position() {
      xPos = new SimpleDoubleProperty(100);
      yPos = new SimpleDoubleProperty(100);
      xVect = new SimpleDoubleProperty(0);
      yVect = new SimpleDoubleProperty(0);
      speed = new SimpleDoubleProperty(0);
    }

    @Override
    public void run() {
      if(collided.get()){
        collided.set(false);
      }
      Platform.runLater(()->{
        checkCollision(xPos.get() + xVect.get(),yPos.get() + yVect.get());
        xPos.set(xPos.get() + xVect.get());
        yPos.set(yPos.get() + yVect.get());

        speed.set(Math.sqrt(Math.pow(xVect.get(), 2) + Math.pow(yVect.get(), 2)));
      });


    }

    private void reset(){
      xVect.set(0);
      yVect.set(0);
    }

    public DoubleProperty xPosProperty() {
      return xPos;
    }

    public DoubleProperty yPosProperty() {
      return yPos;
    }

    private void update(Double x, Double y){
      xVect.set(xVect.get()+x);
      yVect.set(yVect.get()+y);

    }

  }
}
