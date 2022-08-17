import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

// ContainerPanel class for CE203 Assignment to use and modify if needed
// Date: 12/10/2021
// Author: F. Doctor

public class ContainerPanel extends JPanel {

    CuboidContainer cuboid; // Cuboid container object instance
    private final ArrayList<CuboidContainer> cuboidContainers = new ArrayList<>(); // Cuboid container object instance
    private final Set<Integer> existindID = new HashSet<>(); // A set of the used IDs for checking against when adding new
                                                          // cuboids

    /*
     * public ContainerPanel() {
     * 
     * // When you modify the Cuboid container constructor this line will need to be
     * changed // The values for the width/height and length of the cuboid are hard
     * coded below // These should be input from the application text fields where
     * the user would type them in. cuboid = new CuboidContainer(100, 200); }
     */
    //adds cuboid to data
    public boolean addCuboid(int id, int cWidthHeight, int cLength, Color c) {
        if (existindID.contains(id)) {System.out.println( id + " already exists! Enter a new one."); return false;} //returns an error if user input already exist

        cuboidContainers.add(new CuboidContainer(id, cWidthHeight, cLength, c));
        existindID.add(id);
        System.out.println("Cuboid '" + id + "' has been added to the list.");
        searchCuboid(id);
        return true; //returns true when the id has been successfully added
    }

    public CuboidContainer displayCuboid(int id) {
        if (existindID.contains(id)) {
            for (CuboidContainer cuboid : cuboidContainers) {
                if (cuboid.getID() == id)
                    return cuboid;
            }
        }
        return null;
    }

    public void listCuboids() { //display the list of cuboids add to the array
        System.out.print("List of Cuboid IDs: \n");
        for (CuboidContainer c : cuboidContainers) { System.out.print(c.getID() + "\n"); }
    }

    //sorts the cuboid data in a readable way
    public void sortCuboids()
    {
        Collections.sort(cuboidContainers);
        System.out.println("Cuboid list sorted:");
        System.out.println(cuboidContainers);
    }

    public boolean searchCuboid(int id)  //search for id in data
    {
        CuboidContainer search = displayCuboid(id);
        if (search == null) {
            System.out.println(id + " is invalid, the current cuboid cannot be found");
            return false;
        }
        cuboid = search;
        updateUI();
        return true;
    }

    @Override
    protected void paintComponent(Graphics g) { super.paintComponent(g); if (cuboid != null)  cuboid.drawCuboid(g);}
}
