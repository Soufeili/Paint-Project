package com.company;

import java.awt.*;
import java.io.Serializable;

public abstract class Figure implements Serializable {
     public Point origin;
     public java.awt.Color color;


     public Figure (Point origin, java.awt.Color color) {
          this.origin=origin;
          this.color=color;
     }


     public abstract void setBoundingBox(Integer heightBB, Integer widthBB);
     public abstract void draw(Graphics g);

     public java.awt.Color getColor() { return this.color; }
     public Point getOrigin() { return this.origin; }


     @Override
     public String toString() {
          System.out.println("Color :"+this.getColor()+"  Origin :("+this.getOrigin()+")");
          return null;
     }

}