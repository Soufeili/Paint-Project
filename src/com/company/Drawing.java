package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;


public class Drawing extends JPanel implements MouseListener, MouseMotionListener {
    public java.awt.Color color;
    public ArrayList<Figure> list;
    public String nameFigure;
    public Integer x;
    public Integer y;
    public Point mouse1;
    public Point mouse2;
    Figure figure;


    public Drawing() {
        super();
        color = Color.WHITE;
        list = new ArrayList<>();
        nameFigure = null;
        x = 0;
        y = 0;
        this.setBackground(Color.WHITE);
        addMouseListener(this);
        addMouseMotionListener(this);
    }

    // public void creerList() {
    //    list.remove(list.size() - 1);
    //}

    public ArrayList<Figure> getList() {
        return this.list;
    }

    public void setList(ArrayList<Figure> list) {
        this.list = list;
    }

    public java.awt.Color getColor() {
        return this.color;
    }

    public void setColor(java.awt.Color color) {
        this.color = color;
    }

    public String getNameFigure() {
        return this.nameFigure;
    }

    public void setNameFigure(String nameFigure) {
        this.nameFigure = nameFigure;
    }


    @Override
    public void mouseClicked(MouseEvent e) {

        System.out.println("CLiked");               //Useless
    }


    @Override
    public void mousePressed(MouseEvent e) {
        if (color != Color.WHITE) {
            mouse1 = new Point(e.getX(), e.getY());
            switch (nameFigure) {
                case "paintPackage.Rectangle":
                    list.add(figure = new Rectangle(mouse1.getX(), mouse1.getY(), color));
                    break;
                case "paintPackage.Carre":
                    list.add(figure = new Square(mouse1.getX(), mouse1.getY(), color));
                    break;
                case "paintPackage.Ellipse":
                    list.add(figure = new Ellipse(mouse1.getX(), mouse1.getY(), color));
                    break;
                case "paintPackage.Cercle":
                    list.add(figure = new Circle(mouse1.getX(), mouse1.getY(), color));
                    break;
            }
        }
        System.out.println(list);
        repaint();

        System.out.println("Pressed");
    }


    @Override
    public void mouseDragged(MouseEvent e) {
        mouse2 = new Point(e.getX(), e.getY());
        Integer l1 = (mouse2.getX()- mouse1.getX());
        Integer l2 = (mouse2.getY()- mouse1.getY());
        figure.setBoundingBox(l1, l2);

        repaint();

        System.out.println("Dragged"+mouse1.getX() +"et"+mouse1.getY()+" et "+this.figure.getClass());
    }


    @Override
    public void mouseReleased(MouseEvent e) {
        mouse2.setX(e.getX());
        mouse2.setY(e.getY());
        Integer l1 = (mouse2.getX()- mouse1.getX());
        Integer l2 = (mouse2.getY()- mouse1.getY());
        figure.setBoundingBox(l1, l2);
        System.out.println(list);

        repaint();

        System.out.println("Released");
    }


    @Override
    public void mouseEntered(MouseEvent e) {

        System.out.println("Entered");              //Useless
    }


    @Override
    public void mouseExited(MouseEvent e) {

        System.out.println("Exited");               //Usesless
    }


    @Override
    public void mouseMoved(MouseEvent e) {

     //   System.out.println("Moved");                 //Useless
    }


    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        setBackground(Color.WHITE);
        for (Figure f : list) {
            f.draw(g);
            this.repaint();
        }
    }


    public static void main(String[] args) {

    }

}