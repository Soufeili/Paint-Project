package com.company;

import java.awt.Color;


public class Square extends Rectangle{


    public Square(Integer px, Integer py, Color c) {
        super(px, py, c);
        setBoundingBox(0, 0);
    }


    @Override
    public void setBoundingBox(Integer heightBB, Integer widthBB) {
        super.setBoundingBox(heightBB, widthBB);
        length = Math.min(heightBB, widthBB);
        width = Math.min(heightBB, widthBB);
    }

    @Override
    public void setBoundingBox(Point a, Point b) {
        if (a.getX() < b.getX() & a.getY() < b.getY()) {
            super.origin = new Point(a.getX(), a.getY());
            Integer heightBB = (b.getX() - a.getX());
            Integer widthBB = (b.getY()-a.getY());
            length = Math.min(heightBB, widthBB);
            width = Math.min(heightBB, widthBB);
        } else if (a.getX() < b.getX() & a.getY() > b.getY()) {
            super.origin = new Point(a.getX(), b.getY());
            Integer heightBB = (b.getX() - a.getX());
            Integer widthBB = (a.getY() - a.getY());
            length = Math.max(heightBB, widthBB);
            width = Math.max(heightBB, widthBB);
        } else if (a.getX() > b.getX() & a.getY() < b.getY()) {
            super.origin = new Point(b.getX(), a.getY());
            Integer heightBB = (a.getX() - b.getX());
            Integer widthBB = (b.getY() - a.getY());
            length = Math.max(heightBB, widthBB);
            width = Math.max(heightBB, widthBB);
        } else if (a.getX() > b.getX() & a.getY() > b.getY()) {
            super.origin = new Point(b.getX(), b.getY());
            Integer heightBB = (a.getX() - b.getX());
            Integer widthBB = (a.getY() - b.getY());
            length = Math.max(heightBB, widthBB);
            width = Math.max(heightBB, widthBB);
        }
    }

    // public void draw(Graphics g) {
        // g.setColor(color);
        // g.drawRect(origin.getX(),origin.getY(),width,length);
        // g.fillRect(origin.getX(),origin.getY(),width,length);
    // }

    public Integer getLength() {
        return this.length;
    }
    public void setLength(Integer length) {
        this.length = length;
    }

    public Integer getWidth() {
        return this.width;
    }              //Useless
    public void setWidth(Integer width) {
        this.width = width;
    }     //Useless



    @Override
    public String toString() {
        System.out.println("Longueur=" + this.getLength() + " Origine=(" + this.origin.getX() + "," + this.origin.getY() + ") Couleur=" + this.getColor());
        return null;
    }


    public static void main(String[] args) {
        Square carre1;
        carre1 = new Square(8, 11, Color.blue);
        carre1.setBoundingBox(10, 7);
        carre1.toString();
    }

}
