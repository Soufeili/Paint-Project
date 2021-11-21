package com.company;

import java.awt.Color;


public class Circle extends Ellipse {


    public Circle(Integer px, Integer py, Color c) {
        super(px, py, c);
        setBoundingBox(0,0);
    }


    @Override
    public void setBoundingBox(Integer heightBB, Integer widthBB) {
        super.setBoundingBox(heightBB, widthBB);
        this.semiAxysX = Math.min(widthBB/2, heightBB/2);
        this.semiAxysY = Math.min(widthBB/2, heightBB/2);
    }

    @Override
    public void setBoundingBox(Point a, Point b) {
        if (a.getX() < b.getX() & a.getY() < b.getY()) {
            super.origin = new Point(a.getX(), a.getY());
            Integer widthBB = (b.getX() - a.getX())/2;
            Integer heightBB = (b.getY() - a.getY())/2;
            this.semiAxysX = Math.max(widthBB/2, heightBB/2);
            this.semiAxysY = Math.max(widthBB/2, heightBB/2);
        } else if (a.getX() < b.getX() & a.getY() > b.getY()) {
            super.origin = new Point(a.getX(), b.getY());
            Integer widthBB = (b.getX() - a.getX())/2;
            Integer heightBB = (a.getY() - a.getY())/2;
            this.semiAxysX = Math.max(widthBB/2, heightBB/2);
            this.semiAxysY = Math.max(widthBB/2, heightBB/2);
        } else if (a.getX() > b.getX() & a.getY() < b.getY()) {
            super.origin = new Point(b.getX(), a.getY());
            Integer widthBB = (a.getX() - b.getX())/2;
            Integer heightBB = (b.getY() - a.getY())/2;
            this.semiAxysX= Math.max(widthBB/2, heightBB/2);
            this.semiAxysY= Math.max(widthBB/2, heightBB/2);
        } else if (a.getX() > b.getX() & a.getY() > b.getY()) {
            super.origin = new Point(b.getX(), b.getY());
            Integer widthBB = (a.getX() - b.getX())/2;
            Integer heightBB = (a.getY() - b.getY())/2;
            this.semiAxysX = Math.max(widthBB/2, heightBB/2);
            this.semiAxysY = Math.max(widthBB/2, heightBB/2);
        }
    }

    // public void draw(Graphics g) {
        // g.setColor(color);
        // g.drawOval(origin.getX(), origin.getY(), semiAxysX*2, semiAxysY*2);
        // g.fillOval(origin.getX(), origin.getY(), semiAxysX*2, semiAxysY*2);
    // }

    public Integer getSemiAxysX() {
        return this.semiAxysX;
    }
    public void setSemiAxysX(Integer semiAxysX) {
        this.semiAxysX = semiAxysX;
    }

    public Integer getSemiAxysY() {
        return this.semiAxysY;
    }                     //Useless
    public void setSemiAxysY(Integer semiAxysY) {
        this.semiAxysY = semiAxysY;
    }    //Useless


    @Override
    public String toString() {
        System.out.println("Rayon=" + this.getSemiAxysX() + " Origine=(" + this.origin.getX() + "," + this.origin.getY() + ") Couleur=" + this.getColor());
        return null;
    }


    public static void main(String[] args) {
        Circle circle1;
        circle1 = new Circle(0, 0, Color.blue);
        circle1.setBoundingBox(15, 10);
        circle1.toString();
    }

}