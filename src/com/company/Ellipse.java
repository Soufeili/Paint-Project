package com.company;

import java.awt.*;

public class Ellipse  extends Figure {
    public static Integer semiAxysX;
    public static Integer semiAxysY;


    public Ellipse (Integer px, Integer py, Color c) {
        super(new Point(px,py), c);
        this.semiAxysX=0;
        this.semiAxysY=0;
    }


    public void setBoundingBox(Integer heightBB, Integer widthBB) {
        this.semiAxysX=heightBB/2;
        this.semiAxysY=widthBB/2;
    }
    public void draw(Graphics g) {
        g.setColor(color);
        // g.drawOval(origin.getX(),origin.getY(),semiAxysX*2,semiAxysY*2);
        g.fillOval(origin.getX(),origin.getY(),semiAxysX*2,semiAxysY*2);
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
