import java.awt.*;

public class Rectangle extends Shape {

    protected int length;
    protected int width;

    /**
    * Constructor
    * Constructs a rectangle with origin at p
    *
    * @param p : origin point
    */
    public Rectangle(Point p) {
        super(p); // reference to Shape class
    }

    /**
    * Constructor
    * Constructs a c colored rectangle with origin at (px, py)
    *
    * @param px : origin abscissa
    * @param py : origin ordinate
    * @param c : shape color
    */
    public Rectangle(int px, int py, Color c) {
        super(px, py, c);
        setWidth(0);
        setLength(0);
    }

    /**
    * Constructor
    * Constructs a rectangle with width w and length l
    *
    * @param l : rectangle length
    * @param w : rectangle width
    */
    public Rectangle(int l, int w) {
        super(new Point());
        this.length = l;
        this.width = w;
    }

    /**
    * Get rectangle length
    */
    public int getLength() {
        return length;
    }

    /**
    * Get rectangle width
    */
    public int getWidth() {
        return width;
    }

    /**
    * Get rectangle perimeter
    */
    public double getPerimeter() {
        return 2*(length + width);
    }

    /**
    * Get rectangle surface
    */
    public double getSurface() {
        return length*width;
    }

    /**
    * Set rectangle length
    */
    public void setLength(int l) {
        this.length = l;
    }

    /**
    * Set rectangle width
    */
    public void setWidth(int w) {
        this.width = w;
    }

    /**
    * Override Shape class setBoundingBox() method
    * to set the length and width of rectangle
    * equal to heightBB and widthBB (resp.)
    */
    @Override
    void setBoundingBox(int heightBB, int widthBB) {
        setWidth(widthBB);
        setLength(heightBB);
    }

    /**
    * Override Shape class draw() method
    * and passes the color, origin and dimensions
    * to the Graphics object
    */
    @Override
    public void draw(Graphics g) {
        g.setColor(color);
        g.fillRect(origin.x, origin.y, length, width);
    }

}
