import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;
import java.io.*;

/**
 * Window
 */
public class Window extends JFrame implements ActionListener {


    private Drawing myDrawing;
    private String[] colorButtons = {"Black", "Red", "Green", "Blue", "Yellow", "Pink", "Magenta", "Orange"};
    private String[] shapeButtons = {"Ellipse", "Circle", "Square", "Rectangle"};

    /**
    * Constructor
    * Construct JFrame window
    * @param title : window title
    * @param width : window width
    * @param length : window length
    */
    public Window(String title, int width, int length){
        super(title);
        // Exit program when closed
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocation(0, 200);
        setSize(width, length);
        Container contentPane = getContentPane();

        /* MenuBar */
        JMenuBar menubar = new JMenuBar();

        /* File menu */
        JMenu menu1 = new JMenu("File");
        JMenuItem item1 = new JMenuItem("New");
        JMenuItem item2 = new JMenuItem("Open"); // No action assigned
        JMenuItem item3 = new JMenuItem("Save"); // No action assigned
        item1.addActionListener(this);
        menu1.add(item1);
        item2.addActionListener(this);
        menu1.add(item2);
        item3.addActionListener(this);
        menu1.add(item3);

        /* Shortcut for "New" button */
        item1.setAccelerator(KeyStroke.getKeyStroke('N', Toolkit.getDefaultToolkit().getMenuShortcutKeyMask(), false));
        
        /* Separator */
        menu1.addSeparator();
        JMenuItem quit = new JMenuItem("Quit");
        quit.addActionListener(this);
        menu1.add(quit);
        menubar.add(menu1);
        
        /* About menu */
        JMenu menu2 = new JMenu("About");
        JMenuItem authors = new JMenuItem("Authors");
        authors.addActionListener(this);
        menu2.add(authors);
        menubar.add(menu2);

        /* Import/Export menu */
        JMenu menu3 = new JMenu("Import/Export");
        JMenuItem importDraw = new JMenuItem("Import");
        JMenuItem exportDraw = new JMenuItem("Export");
        importDraw.addActionListener(this);
        exportDraw.addActionListener(this);
        menu3.add(importDraw);
        menu3.add(exportDraw);
        menubar.add(menu3);

        setJMenuBar(menubar);

        /* Drawing box */
        this.myDrawing = new Drawing();
        contentPane.add(this.myDrawing, "Center");

        /* Color panel */
        JPanel pan1 = new JPanel();
        pan1.setLayout(new GridLayout(2,4));

        JButton bBlack = new JButton("Black");
        bBlack.setBackground(Color.black);
        bBlack.addActionListener(this);
        pan1.add(bBlack);

        JButton bRed = new JButton("Red");
        bRed.setBackground(Color.red);
        bRed.addActionListener(this);
        pan1.add(bRed);

        JButton bGreen = new JButton("Green");
        bGreen.setBackground(Color.green);
        bGreen.addActionListener(this);
        pan1.add(bGreen);

        JButton bBlue = new JButton("Blue");
        bBlue.setBackground(Color.blue);
        bBlue.addActionListener(this);
        pan1.add(bBlue);

        JButton bYellow = new JButton("Yellow");
        bYellow.setBackground(Color.yellow);
        bYellow.addActionListener(this);
        pan1.add(bYellow);

        JButton bPink = new JButton("Pink");
        bPink.setBackground(Color.pink);
        bPink.addActionListener(this);
        pan1.add(bPink);

        JButton bMagenta = new JButton("Magenta");
        bMagenta.setBackground(Color.magenta);
        bMagenta.addActionListener(this);
        pan1.add(bMagenta);

        JButton bOrange = new JButton("Orange");
        bOrange.setBackground(Color.orange);
        bOrange.addActionListener(this);
        pan1.add(bOrange);

        /* Tools panel */
        JPanel pan2 = new JPanel();
        pan2.setLayout(new GridLayout(2,2));

        JButton bEllipse = new JButton("Ellipse");
        bEllipse.addActionListener(this);
        pan2.add(bEllipse);

        JButton bCircle = new JButton("Circle");
        bCircle.addActionListener(this);
        pan2.add(bCircle);

        JButton bSquare = new JButton("Square");
        bSquare.addActionListener(this);
        pan2.add(bSquare);

        JButton bRectangle = new JButton("Rectangle");
        bRectangle.addActionListener(this);
        pan2.add(bRectangle);

        /* Entire button panel */
        JPanel panTotal = new JPanel();
        panTotal.setLayout(new GridLayout(1, 2));
        panTotal.add(pan1);
        panTotal.add(pan2);
        contentPane.add(panTotal, "South");

        setVisible(true);
        repaint(); // When window is resized or we want to explicitly redraw our window

    }

    private boolean inList = false;
    /**
    * Verify if valueToCheck is in arr (converted as list)
    *
    * @param arr : input array
    * @param valueToCheck : value to find in arr
    * returns a boolean inList
    */
    private boolean isInList(String[] arr, String valueToCheck) {
        inList = Arrays.asList(arr).contains(valueToCheck);
        return inList;
    }

    /**
    * Handle on click ActionEvent
    *
    * @param e : ActionEvent
    */
    public void actionPerformed(ActionEvent e) {
        String cmd = e.getActionCommand();

        // if the action is different from "Quit"
        if(!cmd.equals("Quit")) {
            /* if the ActionEvent is in the list of color buttons
               set the color of the drawing to the correspong color */
            if(isInList(colorButtons, cmd)) {
                switch(cmd) {
                    case "Red":
                    myDrawing.setC(Color.red);
                    break;
                    case "Black":
                    myDrawing.setC(Color.black);
                    break;
                    case "Blue":
                    myDrawing.setC(Color.blue);
                    break;
                    case "Green":
                    myDrawing.setC(Color.green);
                    break;
                    case "Yellow":
                    myDrawing.setC(Color.yellow);
                    break;
                    case "Pink":
                    myDrawing.setC(Color.pink);
                    break;
                    case "Magenta":
                    myDrawing.setC(Color.magenta);
                    break;
                    case "Orange":
                    myDrawing.setC(Color.orange);
                    break;
                }
            }

            /* if ActionEvent corresponds to a shape
               set drawing shape to it */
            else if(isInList(shapeButtons, cmd)){
                myDrawing.setNameShape(cmd);
            }

            /* if ActionEvent is the "New" command 
               clear drawing list and drawing space */
            else if(cmd.equals("New")) {
                myDrawing.getDrawingList().clear();
                repaint();
            }

            /* if ActionEvent is the "Authors" command
               show new window with some text */
            else if(cmd.equals("Authors")) {
                JOptionPane Authors = new JOptionPane();
                Authors.showMessageDialog( new Frame(), "This \"paint clone\" Oussama Chahboune", "Authors", JOptionPane.PLAIN_MESSAGE);
            }

            /* if ActionEvent is "Import"
               import saved drawing */
            else if(cmd.equals("Import")) {
                myDrawing.importDrawing();
            }

            /* if ActionEvent is "Export"
               export drawing */
            else if(cmd.equals("Export")) {
                myDrawing.exportDrawing();
            }
        }

        /* if ActionEvent is "Quit"
           exit program */
        else if(cmd.equals("Quit")) {
            System.exit(1);
        }

        /* Throw error if command is unknown */
        else {
            System.err.println("Error");
        }
    }

}
