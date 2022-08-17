import javax.swing.*;
import java.awt.*;
import java.util.Arrays;

// ContainerFrame class for CE203 Assignment to use and modify if needed
// Date: 12/10/2021
// Author: F. Doctor

// A skeleton JFrame class has been provided which you would need to modifiy to include the other GUI components
// and functionality specified in the assignment specification
public class ContainerFrame extends JFrame {

    private JTextField Input_ID;
    private JTextField Input_COLOUR;
    private JTextField Input_WIDTHHEIGHT;
    private JTextField Input_LENGHT;


    public void createComponents() {

        // Create Panels for Inputs, Cuboids and Panels
        JPanel panelInput = new JPanel(new GridLayout(2, 5));
        ContainerPanel panel = new ContainerPanel();
        JPanel btnPanel = new JPanel();

        panelInput.setPreferredSize(new Dimension(10,60));

        //create buttons
        JButton addBtn = new JButton("Add Cuboid");
        JButton displayBtn = new JButton("Display Cuboid data");
        JButton searchBtn = new JButton("Recall Cuboid with ID");
        JButton sortBtn = new JButton("Sort cuboids by ID");

        //add action listeners to the buttons
        addBtn.addActionListener(e -> {
            boolean add = true;
            if (getID() < 0 | getHeight_Width() == null | getColor() == null)
                add = false;
            if (add) { int[] dimensions = getHeight_Width(); panel.addCuboid(getID(), dimensions[0], dimensions[1],getColor());}
            else {

            }
        });

        //user inputs
        Input_ID = new JTextField();
        Input_COLOUR = new JTextField();
        Input_WIDTHHEIGHT = new JTextField();
        Input_LENGHT = new JTextField();




        displayBtn.addActionListener(e -> { panel.listCuboids(); }); //lists cuboids
        searchBtn.addActionListener(e -> { panel.searchCuboid(getID()); }); //search for cuboid id inputted and displays if found
        sortBtn.addActionListener(e -> { panel.sortCuboids(); }); //action listener to sort the cuboids



        //adds label to the user input buttons
        panelInput.add(new JLabel(" ID:"));
        panelInput.add(Input_ID);
        panelInput.add(new JLabel(" Color:"));
        panelInput.add(Input_COLOUR);
        panelInput.add(new JLabel(" Height/Width:"));
        panelInput.add(Input_WIDTHHEIGHT);
        panelInput.add(new JLabel(" Length:"));
        panelInput.add(Input_LENGHT);

        //adds the buttons to the panel
        btnPanel.add(addBtn);
        btnPanel.add(displayBtn);
        btnPanel.add(searchBtn);
        btnPanel.add(sortBtn);

        //add the button color
        addBtn.setBackground(Color.GRAY);
        displayBtn.setBackground(Color.GRAY);
        searchBtn.setBackground(Color.GRAY);
        sortBtn.setBackground(Color.GRAY);

        //adds a panels for the buttons
        add(panelInput, BorderLayout.NORTH);
        add(panel, BorderLayout.CENTER);
        add(btnPanel, BorderLayout.SOUTH);

        //sets the
        setSize(800, 400);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Close action.

    }
    
    private int getID() {
        // Returns the ID of the Input_ID textfield as an int
        try {
            int returnVal = Integer.parseInt(Input_ID.getText().replace(" ", ""));
            if (returnVal < 100000 || returnVal > 999999) throw new Error();
            else return returnVal;
        } catch (NumberFormatException | Error ex) {
            System.out.println("Cuboid ID was not added to the list as it was an invalid id");
            return -1;
        }
    }

    private Color getColor() {
        try {
            //split the users colour inputs with commas
            String[] colorVals = Input_COLOUR.getText().replace(" ", "").split(",");
            //returns an error the inputs is not equals to 3
            if (colorVals.length != 3) throw new Error();
            //takes the users rgb inputs into an int array
            int[] rgb = new int[]{
                    Integer.parseInt(colorVals[0]),
                    Integer.parseInt(colorVals[1]),
                    Integer.parseInt(colorVals[2]),
            };
            // Return the color that has been parsed
            return new Color(rgb[0], rgb[1], rgb[2]);
        } catch (NumberFormatException | Error ex) {
            System.out.println("The color input is invalid!");
            return null;
        }
    }

    private int[] getHeight_Width() {
        try {
            // Return an int array that uses the height/width and length inputs as values
            return new int[]{
                    Integer.parseInt(Input_WIDTHHEIGHT.getText().replace(" ", "")),
                    Integer.parseInt(Input_LENGHT.getText().replace(" ", ""))
            };
        } catch (NumberFormatException nfe) {
            System.out.println("The height/width and/or length input is invalid!");
            return null;
        }
    }

    public static void main(String[] args) {

        ContainerFrame cFrame = new ContainerFrame();
        cFrame.createComponents();
    }

}
