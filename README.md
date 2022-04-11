# Paint Clone

This project aims to reproduce basic features of the famous Paint software.

## Setup
Minimum Java version: Java 8 <br>
Used Java version: 11.0.13

## Running the program
The program can be run by executing `paint_clone.jar` (in `./build/`) with *Java platform SE binary*.

Otherwise, it can be run in the terminal (example on Windows).
```
cd .\build\
java Main
```
## How the program is build
* `Main.java` is the main file which call the `Window` class constructor to create the window with all its functionalities.
* `Window.java`: the class `Window` inherits from JFrame. It displays the window with the drawing environment. A menu bar at the top, buttons to choose colors and a shapes and the bottom, and in the center a white space to draw on.<br>
This class also handles the ActionEvents (i.e. selected commands).

<p align="center">
 <img src="https://github.com/Ouss98/paint_clone/blob/main/readme_img.png" width="700">
<p/>

* `Drawing.java`: handles the drawing of the shapes by using MouseListener methods. Also, handles exporting and importing of the drawings.
* `Point.java`: is used to create points of specific coordinates or get the coordinates of existing points.
* `Shape.java`: handles common attribtes of all shapes, i.e. the origin, the color, perimeter, surface, bounding box, and drawing method.
  * `Rectangle.java`: inherits from `Shape`. Is used to create a Rectangle with specific origin, color, and dimensions.<br> * `Square.java`: inherits from `Rectangle`. Is used to create a Square with same attributes.
  * `Ellipse.java`: Is used to create a Ellipse with specific origin, color, and dimensions.<br> * `Circle.java`: inherits from `Ellipse`. Is used to create a Circle with same attributes.
