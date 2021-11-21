package com.company;

import java.io.Serializable;


public class Point implements Serializable {
    private Integer X;
    private Integer Y;


    public Point(Integer a, Integer b) {
        X = a;
        Y = b;
    }


    // public Point() {
    //     this.X = 0;
    //     this.Y = 0;
    // }

    public Integer getX() {
        return X;
    }
    public void setX(Integer a) {
        this.X = a;
    }

    public Integer getY() {
        return Y;
    }
    public void setY(Integer b) {
        this.Y = b;
    }


    @Override
    public String toString() {
        System.out.println("(" + this.getX() + "," + this.getY() + ")");
        return null;
    }


    public static void main(String[] args) {
    Point p1;
    // Point p2;
    p1 = new Point(1, 2);
    // p2 = new Point();
    p1.toString();
    // p2.toString();
    }

}


