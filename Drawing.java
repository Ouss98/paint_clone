import java.awt.*;
import javax.swing.*;
import java.util.*;
import java.awt.event.*;
import java.io.*;
import java.beans.XMLEncoder;
import java.awt.Desktop;

/**
 * Drawing
 */
public class Drawing extends JPanel implements MouseMotionListener, MouseListener {

    ArrayList<Shape> drawingList; // List of drawings
    Color c; // shape color
    String nameShape; // name of shape

    // ArrayList<String> figList = new ArrayList<String>();

    /* Coordinates of mouse position */
    private int x;
    private int y;

    /**
    * Contructor
    * Construct a drawing object initialized as a black Rectangle
    * Also initialize drawingList, MouseMotionListener, and MouseListener
    */
    public Drawing() {
        super();
        this.c = Color.black;
        this.nameShape = "Rectangle";
        this.drawingList = new ArrayList<Shape>();
        this.addMouseMotionListener(this);
        this.addMouseListener(this);
    }

    /**
    * Set color c
    */
    public void setC(Color c) {
        this.c = c;
    }

    /**
    * Set name of shape nameShape
    */
    public void setNameShape(String nameShape) {
        this.nameShape = nameShape;
    }

    /**
    * Get list of drawings drawingList
    */
    public ArrayList<Shape> getDrawingList() {
        return drawingList;
    }

    /**
    * Override mouseDragged method in order to compute 
    * movement according to x-axis and y-axis and 
    * set dimensions of bounding box of shape accordingly
    * @param e : MouseEvent
    */
    @Override
    public void mouseDragged(MouseEvent e) {
        int dx = e.getX() - x;
        int dy = e.getY() - y ;

        int i=0;
        for(Shape s : drawingList) {
            i++;
        }
        drawingList.get(i-1).setBoundingBox(dx, dy);
        repaint(); // repaint after each shape
    }

    /* Override MouseListener methods as Drawing class implents MouseListener */
    @Override
    public void mouseMoved(MouseEvent e) {
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    /**
    * Override mousePressed method 
    * to add the selected shape (with origin(x, y) and color c)
    * into drawingList 
    * @param e : MouseEvent
    */
    @Override
    public void mousePressed(MouseEvent e) {
        x = e.getX();
        y = e.getY();
        if(nameShape.equals("Rectangle")) {
            drawingList.add(new Rectangle(x,y,c));
        }
        else if(nameShape.equals("Square")) {
            drawingList.add(new Square(x,y,c));
        }
        else if(nameShape.equals("Ellipse")) {
            drawingList.add(new Ellipse(x,y,c));
        }
        else if(nameShape.equals("Circle")) {
            drawingList.add(new Circle(x,y,c));
        }
    }

    /**
    * Override mouseReleased method 
    * @param e : MouseEvent
    */
    @Override
    public void mouseReleased(MouseEvent e) {
        x = e.getX();
        y = e.getY();
        int dx = e.getX() - x;
        int dy = e.getY() - y;
        repaint();
    }


    /**
    * Paint drawing:
    * set background color to white
    * draw shapes in drawingList
    * @param g : Graphics object
    */
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        this.setBackground(Color.white);
        for(Shape s : drawingList) {
            s.draw(g);
        }
    }

    /* Export drawing in the current working folder as "myDrawing.ser" */
    public void exportDrawing() {
        try {
            FileOutputStream fos = new FileOutputStream("myDrawing.ser");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(drawingList);
            oos.close();
        }
        catch(Exception err) {
            err.printStackTrace();
            System.out.println("Export failed");
        }
    }

    /* Import "myDrawing.ser" drawing in the current working folder */
    public void importDrawing() {
        try {
            FileInputStream fis = new FileInputStream("myDrawing.ser");
            ObjectInputStream ois = new ObjectInputStream(fis);
            drawingList = (ArrayList<Shape>)ois.readObject();
            repaint();
            ois.close();
        }
        catch(Exception err) {
            err.printStackTrace();
            System.out.println("Import failed");
        }
    }

}
