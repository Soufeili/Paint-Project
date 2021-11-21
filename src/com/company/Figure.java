package com.company;

import java.awt.Graphics;
import java.io.Serializable;


public abstract class Figure implements Serializable {
     public java.awt.Color color;
     public Point origin;


     public Figure (java.awt.Color c, Point point) {
          color = c;
          origin = point;
     }

     //public Figure () {
     //     color = new Color(255, 255, 255);
     //     origin = new Point(0,0);
     //}


     public abstract void setBoundingBox(Integer heightBB, Integer widthBB);
     public abstract void setBoundingBox(Point a, Point b);
     public abstract void draw(Graphics g);

     public java.awt.Color getColor() {
          return this.color;
     }
     public void setColor(java.awt.Color color) {
          this.color = color;
     }

     public Point getOrigin() {
          return this.origin;
     }
     public void setOrigin(Point origin) {
          this.origin = origin;
     }


     @Override
     public String toString() {
          System.out.println("Color :" + this.getColor() + "  Origin :(" + this.getOrigin() + ")");
          return null;
     }

}