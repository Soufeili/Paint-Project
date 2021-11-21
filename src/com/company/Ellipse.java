package com.company;

import java.awt.*;

public class Ellipse  extends Figure {
    public static Integer semiAxysX;
    public static Integer semiAxysY;


    public Ellipse (Integer px, Integer py, Color c) {
        super(c, new Point(px,py));
        setBoundingBox(0,0);
    }


    @Override
    public void setBoundingBox(Integer heightBB, Integer widthBB) {
        this.semiAxysX = heightBB/2;
        this.semiAxysY = widthBB/2;
    }
    @Override
    public void draw(Graphics g) {
        g.setColor(color);
        g.drawOval(origin.getX(), origin.getY(), semiAxysX*2, semiAxysY*2);
        g.fillOval(origin.getX(), origin.getY(), semiAxysX*2, semiAxysY*2);
    }


    public double getSurface() {
        return this.semiAxysX*this.semiAxysY*Math.PI;
    }

    public Integer getSemiAxysX() {
        return this.semiAxysX;
    }
    public void setSemiAxysX(Integer semiAxysX) {
        this.semiAxysX=semiAxysX;
    }

    public Integer getSemiAxysY() {
        return this.semiAxysY;
    }
    public void setSemiAxysY(Integer semiAxysY) {
        this.semiAxysY=semiAxysY;
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
        System.out.println("Longeur="+this.getSemiAxysX()+" Hauteur="+this.getSemiAxysY()+" Origine=("+this.origin.getX()+","+this.origin.getY()+") Couleur="+this.getColor());
        return null;
    }


    public static void main(String[] args) {
        Ellipse ellipse1;
        ellipse1 =new Ellipse(5,2,Color.blue);
        ellipse1.setBoundingBox(20,10);
        ellipse1.toString();
    }

}
