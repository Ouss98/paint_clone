import java.awt.*;

public class Square extends Rectangle {

    /**
    * Constructor
    * Constructs a square with origin at p
    *
    * @param p : origin point
    */
    public Square(Point p) {
        super(p);
    }

    /**
    * Constructor
    * Constructs a c colored square with origin at (px, py)
    *
    * @param px : origin abscissa
    * @param py : origin ordinate
    * @param c : shape color
    */
    public Square(int px, int py, Color c) {
        super(px, py, c);
        setWidth(0); /* Sets side to 0 */
    }

    /**
    * Constructor
    * Constructs a square with specific side length
    *
    * @param side : square side
    */
    public Square(int side) {
        super(side, side); // A square's length and width are the same
    }

    /**
    * Set side length by doing length = width = side
    */
    public void setLength(int side) {
        super.setLength(side);
        super.setWidth(side);
    }

    /**
    * Set side length by doing length = width = side
    */
    public void setWidth(int side) {
        this.setLength(side); // refers to setLength() method defined above
    }

    /**
    * Override Shape class setBoundingBox() method
    * to set side of square equal to widthBB
    */
    @Override
    void setBoundingBox(int heightBB, int widthBB) {
        setWidth(widthBB);
    }

}
