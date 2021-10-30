package com.company;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.regex.Pattern;


public class Drawing extends JPanel {
    public java.awt.Color color;
    public ArrayList<Figure> list;
    public String nameFigure;
    public Integer x;
    public Integer y;


    public Drawing () {
        this.color=Color.BLACK;
        // this.Figure=Rectangle;

        this.setBackground(Color.white);
    }

    public void addFigure1 (Ellipse ellipse) { list.add(ellipse); }
    public void addFigure2 (Circle circle) { list.add(circle); }
    public void addFigure3 (Rectangle rectangle) { list.add(rectangle); }
    public void addFigure4 (Square carre) { list.add(carre); }


    public ArrayList<Figure> getList() { return this.list; }

    public java.awt.Color getColor() { return this.color; }
    public void setColor(java.awt.Color c) {
        this.color=c;
    }

    public String getNameFigure() { return this.nameFigure; }
    public void setNameFigure(String n) {
        this.nameFigure=n;
    }

    public ArrayList<Figure> getFigure() { return this.list; }
    public void setFigure(ArrayList l) {
        this.list=l;
    }

    //private ArrayList<Figure> list = new ArrayList<>();

    public static void main (String[] args) {


    }

}
