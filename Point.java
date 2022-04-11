import java.io.Serializable;

public class Point implements Serializable {

    protected int x;
    protected int y;

    /**
    * Constructor
    * Constructs a point with coordinates (a, b)
    *
    * @param a : point abscissa
    * @param b : point ordinate
    */
    public Point(int a, int b) {
        x = a;
        y = b;
    }

    /**
    * Constructor
    * Constructs a point with coordinates (0, 0)
    */
    public Point() {
        this(0, 0);
    }

    /**
    * Returns the abscissa of the point
    * @param x : point abscissa
    */
    public int getX() {
        return x;
    }

    /**
    * Returns the ordinate of the point
    * @param y : point ordinate
    */
    public int getY() {
        return y;
    }

    /**
    * Sets the abscissa of the point
    * @param x : point abscissa
    */
    public void setX(int x) {
        this.x = x;
    }

    /**
    * Sets the ordinate of the point
    * @param y : point ordinate
    */
    public void setY(int y) {
        this.y = y;
    }

}
