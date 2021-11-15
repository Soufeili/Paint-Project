package com.company;

import java.awt.*;

public class Circle extends Ellipse {


    public Circle(Integer px, Integer py, Color c) {
        super(px, py, c);
        this.semiAxysX=0;
        this.semiAxysY=0;
    }


    public void setBoundingBox(Integer heightBB, Integer widthBB) {
        this.semiAxysX=Math.min(widthBB/2,heightBB/2);
        this.semiAxysY=Math.min(widthBB/2,heightBB/2);
    }
    public void draw(Graphics g) {}

    public Integer getSemiAxysX() {
        return this.semiAxysX;
    }
    public void setSemiAxysX(Integer semiAxysX) {
        this.semiAxysX=semiAxysX;
    }

    public Integer getSemiAxysY() {
        return this.semiAxysY;
    }                     //Useless
    public void setSemiAxysY(Integer semiAxysY) {
        this.semiAxysY=semiAxysY;
    }    //Useless


    @Override
    public String toString() {
        System.out.println("Rayon="+this.getSemiAxysX()+" Origine=("+this.origin.getX()+","+this.origin.getY()+") Couleur="+this.getColor());
        return null;
    }


    public static void main(String[] args) {
        Circle circle1;
        circle1 =new Circle(0,0,Color.blue);
        circle1.setBoundingBox(15,10);
        circle1.toString();
    }

}