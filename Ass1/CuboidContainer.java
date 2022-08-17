import java.awt.*;

// Incomplete CuboidContainer class for CE203 Assignment
// Date: 12/10/2021
// Author: F. Doctor

public class CuboidContainer implements Comparable<CuboidContainer> {

    //int id = 000000; // Cuboid id should be a six digit non-negative integer with no leading 0s
    int x = 25; // x pixel position of top left point of the first face of the cuboid (hardcode not set by user)
    int y = 25; // y pixel position of top left point of the first face of the cuboid (hardcoded not set by user)
    int widthHelight; // Width and height of the cuboid where width = height (each face is a square)
    int length; // Length of cuboid in pixels

    Point[] faceOnePoints; // Points array used to store vertices (points) of first face of the cuboid
    Point[] faceTwoPoints; // Points array used to store vertices (points) of second face of the cuboid
    private final Color c;
    // constructor currently set the dimensions of the cuboid to be drawn. This should be modified
    // to set the Id field and the colour. You might need to also include a handle to the top level
    private final int id;

    // returns the id in the data
    public int getID() { return id; }

    // JFrame object see examples in Unit 2
    public CuboidContainer(int id ,int cWidthHeight, int cLength, Color c) {
        this.id = id;
        this.x = x;
        this.y = y;
        this.c = c;
        this.widthHelight = cWidthHeight;
        this.length = cLength;
        faceOnePoints = getCubeOnePoints();
        faceTwoPoints = getCubeTwoPoints();
    }

    // used to populate the points array with the vertices (corners/points) of first
    // face of the cuboid
    private Point[] getCubeOnePoints() {
        Point[] points = new Point[4];
            points[0] = new Point(x, y);
            points[1] = new Point(x + widthHelight, y);
            points[2] = new Point(x + widthHelight, y + widthHelight);
            points[3] = new Point(x, y + widthHelight);
            return points;
    }

    // used to populate the points array with the vertices of the second face of the
    // cuboid
    // using the example of the first face complete the remainder of the code to
    // produce an
    // output cuboid as shown in the assignment script
    private Point[] getCubeTwoPoints() {
        int newX = x + length;
        int newY = y + length;

        // to complete...

        return new Point[]{
            new Point(newX, newY),
            new Point(newX + widthHelight, newY),
            new Point(newX + widthHelight, newY + widthHelight),
            new Point(newX, newY + widthHelight)
        };
    }

    // You will need to modify this method to set the colour of the Cuboid to be
    // drawn
    // you will also need to complete the For loop to draw the lines connecting each
    // face of the cuboid
    public void drawCuboid(Graphics g) {

        g.setColor(c);
        g.drawRect(x, y, widthHelight, widthHelight);
        g.drawRect(x + length, y + length, widthHelight, widthHelight);
        //g.fillRect(x + length, y + length, widthHelight, widthHelight);
        // to complete..., draw connecting lines by looping through both points arrays and using the graphics drawline() method

        for (int i = 0; i < 4; i++) { g.drawLine(faceOnePoints[i].x, faceOnePoints[i].y, faceTwoPoints[i].x, faceTwoPoints[i].y); }

    }

    @Override
    // method used for comparing Cuboid Container objects based on stored ids, you
    // need to complete the method
    public int compareTo(CuboidContainer o) { return id - o.getID(); }

    // outputs a string representation of the cuboid container object which can be
    // used for testing
    public String toString()
    {
        return "Cuboid Data:" + "\n" + "Cuboid ID: " +id + "\n" + "Width/height: " + widthHelight + "\n" + "Length: " + length + "\n" + "Colour: " + c.toString() + "\n";
    }

    public String toStringSplit(String txt){
        return txt.replace("[]", "");
    }
}
