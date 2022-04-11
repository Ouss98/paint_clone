import java.awt.*;
import java.io.Serializable;

public abstract class Shape implements Serializable {

    protected Point origin = new Point();
    protected Color color;

    /**
    * Constructor
    * Constructs a shape with p as origin
    *
    * @param p : point origin
    */
    public Shape(Point p) {
        this.origin = p;
    }

    /**
    * Constructor
    * Constructs a c coloured shape with p as origin
    *
    * @param p : point origin
    * @param c : shape color
    */
    public Shape(Point p, Color c) {
        this.origin = p;
        this.color = c;
    }

    /**
    * Constructor
    * Constructs a c coloured shape with origin at (px, py)
    *
    * @param px : origin abscissa
    * @param py : origin ordinate
    * @param c : shape color
    */
    public Shape(int px, int py, Color c) {
        Point point = new Point(px, py);
        this.origin = point;
        this.color = c;
    }

    /**
    * Gets shape perimeter
    */
    public abstract double getPerimeter();

    /**
    * Gets shpae surface
    */
    public abstract double getSurface();

    /**
    * Sets shape bounding box
    * @param heightBB : height of bounding box
    * @param widthBB : width of bounding box
    */
    abstract void setBoundingBox(int heightBB, int widthBB);

    /**
    * Draw shape
    * @param g : referecence of Graphics object
    */
    abstract void draw(Graphics g);
}
