package com.company;

import java.awt.*;

public class Rectangle extends Figure {
    public Integer length;
    public Integer width;


    public Rectangle(Integer px, Integer py, Color c) {
        super(c, new Point(px, py));
        setBoundingBox(0,0);
    }


    @Override
    public void setBoundingBox(Integer heightBB, Integer widthBB) {
        length = widthBB;
        width = heightBB;
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(color);
        g.drawRect(origin.getX(),origin.getY(),width,length);
        g.fillRect(origin.getX(),origin.getY(),width,length);
    }


    public Integer getPerimeter() {
        return 2*this.length + 2*this.width ;
    }

    public Integer getSurface() {
        return this.length*this.width;
    }

    public Integer getLength() {
        return this.length;
    }
    public void setLength(Integer length) {
        this.length = length;
    }

    public Integer getWidth() {
        return this.width;
    }
    public void setWidth(Integer width) {
        this.width = width;
    }

    @Override
    public Point getOrigin() {
        return super.getOrigin();
    }
    @Override
    public void setOrigin(Point origin) {
        super.setOrigin(origin);
    }

    @Override
    public java.awt.Color getColor() {
        return super.getColor();
    }
    @Override
    public void setColor(java.awt.Color color) {
        super.setColor(color);
    }



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