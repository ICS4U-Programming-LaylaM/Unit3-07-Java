import java.io.IOException;
/**
* This program checks and displays the vehicle's info and can alter its
* speed and display it to an output text file.
*
* @author Layla Michel
* @version 1.0
* @since 2022-05-20
*/

public abstract class AbstractVehicle {
    /**
    * AbstractVehicle number property.
    */
    protected static String _vehicleNum;

    /**
    * AbstractVehicle colour property.
    */
    protected static String _colour;

    /**
    * AbstractVehicle speed property.
    */
    protected static String _speed;

    /**
    * AbstractVehicle max speed property.
    */
    protected static String _maxSpeed;

    /**
    * License plate property.
    */
    private static String _licensePlate;

    /**
    * Number of doors property.
    */
    private static String _doorsNum;

    /**
    * Constructor.
    *
    * @param vehicleNum as String
    * @param licensePlate as String
    * @param colour as String
    * @param doorsNum as String
    * @param speed as String
    * @param maxSpeed as String
    */
    public AbstractVehicle(String vehicleNum, String licensePlate,
                           String colour, String doorsNum, String speed,
                           String maxSpeed) {
        _vehicleNum = vehicleNum;
        _licensePlate = licensePlate;
        _colour = colour;
        _doorsNum = doorsNum;
        _speed = speed;
        _maxSpeed = maxSpeed;
    }

    /**
    * Constructor.
    *
    * @param vehicleNum as String
    * @param colour as String
    * @param speed as String
    * @param maxSpeed as String
    */
    public AbstractVehicle(String vehicleNum, String colour,
        String speed, String maxSpeed) {
        _vehicleNum = vehicleNum;
        _colour = colour;
        _speed = speed;
        _maxSpeed = maxSpeed;
    }

    /**
    * This method accelerates the vehicle by a specified km/h.
    *
    * @param acceleration as String
    */
    protected void accelerate(String acceleration) {
        final int accelerationInt = Integer.parseInt(acceleration);
        int speedInt = Integer.parseInt(_speed);

        // Sets new speed value
        speedInt += accelerationInt;
        _speed = Integer.toString(speedInt);
    }

    /**
    * This method slows the vehicle by a specified km/h.
    *
    * @param deceleration as String
    */
    protected void brake(String deceleration) {
        final int decelerationInt = Integer.parseInt(deceleration);
        int speedInt = Integer.parseInt(_speed);

        // Sets new speed value
        speedInt -= decelerationInt;
        _speed = Integer.toString(speedInt);
    }

    /**
    * This method displays the vehicle's current speed to the output text file.
    *
    * @throws IOException if no file is passed in.
    */
    protected abstract void getSpeed();

    /**
    * This method displays the vehicle's max speed to the output text file.
    */
    protected abstract void getMaxSpeed();

    /**
    * This method displays the vehicle's information to the output text file.
    */
    protected abstract void getInfo();
}
