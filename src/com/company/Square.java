package com.company;

import java.awt.*;

public class Square extends Rectangle{


    public Square(Integer px, Integer py, Color c) {
        super(px, py, c);
        this.length=0;
        this.width=0;
    }


    public void setBoundingBox(Integer heightBB, Integer widthBB) {
        this.length = Math.min(heightBB,widthBB);
        this.width = Math.min(heightBB,widthBB);
    }
    public void draw(Graphics g) {}

    public Integer getLength() { return this.length; }
    public Integer getWidth() { return this.width; }     //Useless


    @Override
    public String toString() {
        System.out.println("Longueur="+this.getLength()+" Origine=("+this.origin.getX()+","+this.origin.getY()+") Couleur="+this.getColor());
        return null;
    }


    public static void main(String[] args) {
        Square carre1;
        carre1 =new Square(8,11,Color.blue);
        carre1.setBoundingBox(10,7);
        carre1.toString();
    }

}
