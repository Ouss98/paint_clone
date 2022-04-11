import java.awt.*;

public class Circle extends Ellipse {

    /**
    * Constructor
    * Constructs a circle with origin at p
    *
    * @param p : point origin
    */
    public Circle(Point p) {
        super(p);
    }

    /**
    * Constructor
    * Constructs a c colored circle with origin at (px, py)
    *
    * @param px : origin abscissa
    * @param py : origin ordinate
    * @param c : shape color
    */
    public Circle(int px, int py, Color co) {
        super(px, py, co);
        setShortAxis(0); /* Sets radius to 0 */
    }

    /**
    * Constructor
    * Constructs a circle with specific radius
    *
    * @param side : circle radius
    */
    public Circle(int radius) {
        super(radius, radius);
    }

    /**
    * Set radius by doing long axis = short axis = radius
    */
    public void setLongAxis(int radius) {
        super.setLongAxis(radius);
        super.setShortAxis(radius);
    }

    /**
    * Set radius by doing long axis = short axis = radius
    */
    public void setShortAxis(int radius) {
        this.setLongAxis(radius); // refers to setLongAxis() method defined above
    }

    /**
    * Override Shape class setBoundingBox() method
    * to set radius of circle equal to widthBB
    */
    @Override
    void setBoundingBox(int heightBB, int widthBB) {
        setShortAxis(widthBB);
    }

}
