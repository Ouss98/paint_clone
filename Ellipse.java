import java.lang.Math.*;
import java.awt.*;

public class Ellipse extends Shape {

    private int longAxis;
    private int shortAxis;

    /**
    * Constructor
    * Constructs an ellipse with origin at p
    *
    * @param p : point origin
    */
    public Ellipse(Point p) {
        super(p);
    }

    /**
    * Constructor
    * Constructs a c colored ellipse with origin at (px, py)
    *
    * @param px : origin abscissa
    * @param py : origin ordinate
    * @param c : shape color
    */
    public Ellipse(int px, int py, Color c) {
        super(px, py, c);
        setShortAxis(0);
        setLongAxis(0);
    }

    /**
    * Constructor
    * Constructs an ellipse with long axis l and short axis s
    *
    * @param l : long axis
    * @param s : short axis
    */
    public Ellipse(int l, int s) {
        super(new Point());
        this.longAxis = l;
        this.shortAxis = s;
    }

    /**
    * Get long axis
    */
    public int getLongAxis() {
        return longAxis;
    }

    /**
    * Get short axis
    */
    public int getShortAxis() {
        return shortAxis;
    }

    /**
    * Get ellipse surface
    */
    public double getSurface() {
        return Math.PI*longAxis*shortAxis/4;
    }

    /**
    * Get ellipse perimeter
    */
    public double getPerimeter() {
        return 2*Math.PI*Math.sqrt((Math.pow(longAxis, 2) + Math.pow(shortAxis, 2))/2);
    }

    /**
    * Set long axis
    */
    public void setLongAxis(int l) {
        this.longAxis = l;
    }

    /**
    * Set short axis
    */
    public void setShortAxis(int s) {
        this.shortAxis = s;
    }

    /**
    * Override Shape class setBoundingBox() method
    * to set the long axis and short axis of ellipse
    * equal to heightBB and widthBB (resp.)
    */
    @Override
    void setBoundingBox(int heightBB, int widthBB) {
        setLongAxis(heightBB);
        setShortAxis(widthBB);
    }

    /**
    * Override Shape class draw() method
    * and passes the color, origin and dimensions
    * to the Graphics object
    */
    @Override
    public void draw(Graphics g) {
        g.setColor(color);
        g.fillOval(origin.x, origin.y, longAxis, shortAxis);
    }

}
