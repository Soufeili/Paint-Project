package com.company;


import javax.swing.*;
import javax.swing.JPanel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.ArrayList;


public class Window extends JFrame implements ActionListener {
    private Drawing d1;


    public Window(String Title, Integer x, Integer y) {
        super(Title);
        this.setSize(x,y);
        this.setVisible(true);                 // afficher la fenêtre
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);       //fermer la fenêtre quand je quittte
        this.setLocationRelativeTo(null);                 //centrer la fenêtre
        this.d1=new Drawing();


        JMenuBar m = new JMenuBar();        // Creer Barre de menu

        JMenu menu1=new JMenu("File");           //Creer menu
        JMenu menu2= new JMenu("A propos");      //Creer menu

        JMenuItem new1 = new JMenuItem("New");                  //Creer element de menu
        new1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, KeyEvent.CTRL_DOWN_MASK));
        JMenuItem open = new JMenuItem("Open");                 //Creer element de menu
        open.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, KeyEvent.CTRL_DOWN_MASK));
        JMenuItem save = new JMenuItem("Save");                 //Creer element de menu
        save.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, KeyEvent.CTRL_DOWN_MASK));
        JMenuItem quit = new JMenuItem("Quit");                 //Creer element de menu
        quit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q, KeyEvent.CTRL_DOWN_MASK));
        JMenuItem authors = new JMenuItem("About / Authors ...");
        authors.addActionListener(this::menuNewListener);

        menu1.add(new1);    //Ajouter éléments au menu
        //menu1.addSeparator();
        menu1.add(open);    //Ajouter éléments au menu
        //menu1.addSeparator();
        menu1.add(save);    //Ajouter éléments au menu
        menu1.addSeparator();
        menu1.add(quit);    //Ajouter éléments au menu

        menu2.add(authors);

        m.add(menu1);       //Ajouter le menu a la barre de menu
        m.add(menu2);

        this.setJMenuBar(m);


        Container contentPanel = this.getContentPane() ;
        contentPanel.add(d1,"Center");

        JButton OkButton1 = new JButton("Noir");
        OkButton1.setBackground(Color.BLACK);
        OkButton1.setForeground(Color.WHITE);
        JButton OkButton2 = new JButton("Rouge");
        OkButton2.setBackground(Color.RED);
        JButton OkButton3 = new JButton("Vert");
        OkButton3.setBackground(Color.GREEN);
        JButton OkButton4 = new JButton("Bleu");
        OkButton4.setBackground(Color.BLUE);
        OkButton4.setForeground(Color.WHITE);
        JButton OkButton5 = new JButton("Jaune");
        OkButton5.setBackground(Color.YELLOW);
        JButton OkButton6 = new JButton("Rose");
        OkButton6.setBackground(Color.PINK);
        JButton OkButton7 = new JButton("Magenta");
        OkButton7.setBackground(Color.MAGENTA);
        JButton OkButton8 = new JButton("Orange");
        OkButton8.setBackground(Color.ORANGE);
        JButton OkButton9 = new JButton("paintPackage.Ellipse");
        JButton OkButton10 = new JButton("paintPackage.Cercle");
        JButton OkButton11 = new JButton("paintPackage.Rectangle");
        JButton OkButton12 = new JButton("paintPackage.Carre");

        JPanel southPanel1 = new JPanel();
        southPanel1.setLayout(new GridLayout(1,2));

        JPanel southPanel2 = new JPanel();
        southPanel2.setLayout(new GridLayout(2,4));
        southPanel2.add(OkButton1);
        southPanel2.add(OkButton2);
        southPanel2.add(OkButton3);
        southPanel2.add(OkButton4);
        southPanel2.add(OkButton5);
        southPanel2.add(OkButton6);
        southPanel2.add(OkButton7);
        southPanel2.add(OkButton8);
        contentPanel.add(southPanel2,BorderLayout.SOUTH);

        JPanel southPanel3 = new JPanel();
        southPanel3.setLayout(new GridLayout(2,2));
        southPanel3.add(OkButton9);
        southPanel3.add(OkButton10);
        southPanel3.add(OkButton11);
        southPanel3.add(OkButton12);
        contentPanel.add(southPanel3,BorderLayout.SOUTH);

        southPanel1.add(southPanel2);
        southPanel1.add(southPanel3);

        OkButton1.addActionListener(this);
        OkButton2.addActionListener(this);
        OkButton3.addActionListener(this);
        OkButton4.addActionListener(this);
        OkButton5.addActionListener(this);
        OkButton6.addActionListener(this);
        OkButton7.addActionListener(this);
        OkButton8.addActionListener(this);
        OkButton9.addActionListener(this);
        OkButton10.addActionListener(this);
        OkButton11.addActionListener(this);
        OkButton12.addActionListener(this);
        new1.addActionListener(this);
        open.addActionListener(this);
        save.addActionListener(this);
        quit.addActionListener(this);


        contentPanel.add(southPanel1,BorderLayout.SOUTH);


        this.setVisible(true);    //Fait apparaître la fenêtre
    }


    public static void main (String args[]) {
        Window win = new Window("Paint", 800, 600);
    }

    private void menuNewListener (ActionEvent event) {
        JOptionPane info = new JOptionPane();
        info.showInternalMessageDialog(info, "Authors : Insert your name", "information", JOptionPane.INFORMATION_MESSAGE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String cmd=e.getActionCommand();

        switch (cmd) {
            case "Noir" :
                d1.setColor(Color.BLACK);
                System.out.println("Noir have been cliked !");
                break;
            case "Rouge" :
                d1.setColor(Color.RED);
                System.out.println("Rouge have been cliked !");
                break;
            case "Vert" :
                d1.setColor(Color.GREEN);
                System.out.println("Vert have been cliked !");
                break;
            case "Bleu" :
                d1.setColor(Color.BLUE);
                System.out.println("Bleu have been cliked !");
                break;
            case "Jaune" :
                d1.setColor(Color.YELLOW);
                System.out.println("Jaune have been cliked !");
                break;
            case "Rose" :
                d1.setColor(Color.PINK);
                System.out.println("Rose have been cliked !");
                break;
            case "Magenta" :
                d1.setColor(Color.MAGENTA);
                System.out.println("Magenta have been cliked !");
                break;
            case "Orange" :
                d1.setColor(Color.ORANGE);
                System.out.println("Orange have been cliked !");
                break;
            case "paintPackage.Ellipse" :
                d1.nameFigure="paintPackage.Ellipse";
                System.out.println("Ellipse have been cliked !");
                break;
            case "paintPackage.Cercle" :
                d1.nameFigure="paintPackage.Cercle";
                System.out.println("Cercle have been cliked !");
                break;
            case "paintPackage.Rectangle" :
                d1.nameFigure="paintPackage.Rectangle";
                System.out.println("Rectangle have been cliked !");
                break;
            case "paintPackage.Carre" :
                d1.nameFigure="paintPackage.Carre";
                System.out.println("Carre have been cliked !");
                break;
            case "New" :
                System.out.println("New have been cliked !");
                d1.setList(new ArrayList<>());
                break;
            case "Open" :
                System.out.println("Open have been cliked !");
                break;
            case "Save" :
                System.out.println("Save have been cliked !");
                break;
            case "Quit" :
                System.out.println("Quit have been cliked !");
                System.exit(0);
                break;
        }
    }

}