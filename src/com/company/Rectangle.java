package com.company;

import java.awt.*;

public class Rectangle extends Figure {
    public static Integer length;
    public static Integer width;


    public Rectangle(Integer px, Integer py, Color c) {
        super(new Point(px, py), c);
        this.length = 0;
        this.width = 0;
    }


    public void setBoundingBox(Integer heightBB, Integer widthBB) {
        this.length = heightBB;
        this.width = widthBB;
    }
    public void draw(Graphics g) {}

    public Integer getLength() { return this.length; }
    public Integer getWidth() { return this.width; }


    @Override
    public String toString() {
        System.out.println("Longeur="+this.getLength()+" Largeur="+this.getWidth()+" Origine=("+this.origin.getX()+","+this.origin.getY()+") Couleur="+this.getColor());
        return null;
    }


    public static void main(String[] args) {
        Rectangle rec1;
        rec1 =new Rectangle(5,2,Color.blue);
        rec1.setBoundingBox(10,5);
        rec1.toString();
    }

}