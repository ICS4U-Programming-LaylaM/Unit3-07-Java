import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
* This program checks and displays the bike's info and can alter its
* speed and display it to an output text file.
*
* @author Layla Michel
* @version 1.0
* @since 2022-05-20
*/

public class Bike extends Vehicle {
    /**
    * Number of wheels property.
    */
    private String _wheelsNum;

    /**
    * Number of seats property.
    */
    private String _seatsNum;

    /**
    * Array of strings property.
    */
    private final List<String> strList = new ArrayList<String>();

    /**
    * Newline property.
    */
    private final String newLine = "\n";

    /**
    * Output path property.
    */
    private final String outputPath = "/home/runner/Unit3-07-Java/output.txt";

    /**
    * Constructor.
    *
    * @param vehicleNum as String
    * @param colour as String
    * @param wheelsNum as String
    * @param seatsNum as String
    * @param speed as String
    * @param maxSpeed as String
    */
    public Bike(String vehicleNum, String colour,
        String wheelsNum, String seatsNum,
        String speed, String maxSpeed) {
        super(vehicleNum, colour, speed, maxSpeed);
        _vehicleNum = vehicleNum;
        _colour = colour;
        _wheelsNum = wheelsNum;
        _seatsNum = seatsNum;
        _speed = speed;
        _maxSpeed = maxSpeed;
    }

    /**
    * This method displays the bike's current speed to the output text file.
    *
    * @throws IOException if no file is passed in.
    */
    protected void getSpeed() {
        // Creating string containing the bike's current speed
        final String string = "The current speed of bike "
            + _vehicleNum + " is: " + _speed + " km/h.";

        try {
            // Build a string containing that string
            final StringBuilder builder = new StringBuilder();
            builder.append(string);
            builder.append(newLine);

            // Create new file called "output.txt"
            final FileWriter fileWriter = new FileWriter(outputPath, true);

            // Add the string to the output.txt file
            final BufferedWriter writer = new BufferedWriter(fileWriter);
            writer.append(builder.toString());
            writer.append(newLine);
            writer.close();

            // Displayed to the console
            System.out.println("Bike " + _vehicleNum
                + "'s current speed is displayed" + " to 'output.txt'");
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    /**
    * This method displays the bike's max speed to the output text file.
    */
    protected void getMaxSpeed() {
        // Creating string containing the bike's max speed
        final String string = "The max speed of bike "
            + _vehicleNum + " is: " + _maxSpeed + " km/h.";

        try {
            // Build a string containing that string
            final StringBuilder builder = new StringBuilder();
            builder.append(string);
            builder.append(newLine);

            // Create new file called "output.txt"
            final FileWriter fileWriter = new FileWriter(outputPath, true);

            // Add the information to the output.txt file
            final BufferedWriter writer = new BufferedWriter(fileWriter);
            writer.append(builder.toString());
            writer.append(newLine);
            writer.close();

            // Displayed to the console
            System.out.println("Bike " + _vehicleNum
                + "'s max speed is displayed to 'output.txt'");
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    /**
    * This method displays the bike's information to the output text file.
    */
    protected void getInfo() {
        // Adding bike's information to an array
        strList.add("Bike " + _vehicleNum + "'s info");
        strList.add("Colour: " + _colour);
        strList.add("Number of wheels: " + _wheelsNum);
        strList.add("Number of seats: " + _seatsNum);
        strList.add("Speed: " + _speed);
        strList.add("Max speed: " + _maxSpeed);

        try {
            // Build a string containing the elements
            // of the array
            final StringBuilder builder = new StringBuilder();
            for (int counter = 0; counter < strList.size(); counter++) {
                builder.append(strList.get(counter));
                builder.append(newLine);
            }

            // Create new file called "output.txt"
            final FileWriter fileWriter = new FileWriter(outputPath, true);

            // Add the information to the output.txt file
            final BufferedWriter writer = new BufferedWriter(fileWriter);
            writer.append(builder.toString());
            writer.append(newLine);
            writer.close();

            // Displayed to the console
            System.out.println("Bike " + _vehicleNum
                + "'s information is displayed "
                + "to 'output.txt'");
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }
}
