import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
* This program checks and displays the truck's info and can alter its
* speed and display it to an output text file.
*
* @author Layla Michel
* @version 1.0
* @since 2022-05-20
*/

public class Truck extends AbstractVehicle {
    /**
    * License plate property.
    */
    private String _licensePlate;

    /**
    * Number of doors property.
    */
    private String _doorsNum;

    /**
    * Number of wheels property.
    */
    private String _wheelsNum;

    /**
    * Truck length property.
    */
    private String _length;

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
    * @param licensePlate as String
    * @param colour as String
    * @param doorsNum as String
    * @param wheelsNum as String
    * @param length as String
    * @param speed as String
    * @param maxSpeed as String
    */
    public Truck(String vehicleNum, String licensePlate,
        String colour, String doorsNum, String wheelsNum,
        String length, String speed, String maxSpeed) {
        super(vehicleNum, licensePlate, colour,
            doorsNum, speed, maxSpeed);
        _vehicleNum = vehicleNum;
        _licensePlate = licensePlate;
        _colour = colour;
        _doorsNum = doorsNum;
        _wheelsNum = wheelsNum;
        _length = length;
        _speed = speed;
        _maxSpeed = maxSpeed;
    }

    /**
    * This method displays the truck's current speed to the output text file.
    *
    * @throws IOException if no file is passed in.
    */
    protected void getSpeed() {
        // Creating string containing the truck's current speed
        final String string = "The current speed of truck "
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
            System.out.println("Truck " + _vehicleNum
                + "'s current speed is displayed" + " to 'output.txt'");
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    /**
    * This method displays the truck's max speed to the output text file.
    */
    protected void getMaxSpeed() {
        // Creating string containing the truck's max speed
        final String string = "The max speed of truck "
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
            System.out.println("Truck " + _vehicleNum
                + "'s max speed is displayed to 'output.txt'");
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    /**
    * This method displays the truck's information to the output text file.
    */
    protected void getInfo() {
        // Adding truck's information to an array
        strList.add("Truck " + _vehicleNum + "'s info");
        strList.add("License plate: " + _licensePlate);
        strList.add("Colour: " + _colour);
        strList.add("Number of doors: " + _doorsNum);
        strList.add("Number of wheels: " + _wheelsNum);
        strList.add("Length: " + _length);
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
            System.out.println("Truck " + _vehicleNum
                + "'s information is displayed "
                + "to 'output.txt'");
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }
}
