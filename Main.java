import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
* This program creates vehicle objects by reading information from
* a text file.
*
* @author Layla Michel
* @version 1.0
* @since 2022-05-20
*/

final class Main {
    /**
    * Index of vehicle type.
    */
    static final int VEHICLE_TYPE_INDEX = 0;

    /**
    * Index of vehicle number.
    */
    static final int VEHICLE_NUM_INDEX = 1;

    /**
    * Index of license plate.
    */
    static final int LICENSE_INDEX = 2;

    /**
    * Index of vehicle colour.
    */
    static final int COLOUR_INDEX = 3;

    /**
    * Index of vehicle door number.
    */
    static final int DOORS_NUM_INDEX = 4;

    /**
    * Index of vehicle speed.
    */
    static final int SPEED_INDEX = 5;

    /**
    * Index of vehicle max speed.
    */
    static final int MAX_SPEED_INDEX = 6;

    /**
    * Index of truck wheel number.
    */
    static final int TRUCK_WHEELS_NUM_INDEX = 5;

    /**
    * Index of truck length.
    */
    static final int TRUCK_LENGTH = 6;

    /**
    * Index of truck speed.
    */
    static final int TRUCK_SPEED_INDEX = 7;

    /**
    * Index of truck max speed.
    */
    static final int TRUCK_MAX_SPEED_INDEX = 8;

    /**
    * Index of bike colour.
    */
    static final int BIKE_COLOUR_INDEX = 2;

    /**
    * Index of bike wheel number.
    */
    static final int BIKE_WHEELS_NUM_INDEX = 3;

    /**
    * Index of bike seats number.
    */
    static final int BIKE_SEATS_NUM_INDEX = 4;

    /**
    * Index of bike speed.
    */
    static final int BIKE_SPEED_INDEX = 5;

    /**
    * Index of bike max speed.
    */
    static final int BIKE_MAX_SPEED_INDEX = 6;

    /**
    * String "0".
    */
    static final String STRING_ZERO = "0";

    /**
    * String "10".
    */
    static final String STRING_TEN = "10";

    /**
    * String "10".
    */
    static final String STRING_FIVE = "5";

    /**
    * String "null".
    */
    static final String STRING_NULL = "null";

    /**
    * Array of vehicle info.
    */
    private static String[] vehicleInfoArray;

    /**
    * Default constructor.
    */
    private Main() { }

    /**
    * Creating main function.
    *
    * @param args nothing passed in
    * @throws IOException if no file is passed in
    */
    public static void main(String[] args)
            throws IOException {
        // Create list to get the strings
        final List<String> listVehicleInfo =
            new ArrayList<String>();

        BufferedReader buffer = null;
        try {
            // Check if there are some arguments
            if (null != args[0]
                // Length > 4 because a.txt will be shortest filename
                && args[0].length() > 4
                // Check if arguments have the correct file extension
                && args[0].endsWith(".txt")) {
                buffer = new BufferedReader(new FileReader(args[0]));
            }
        } catch (IOException exception) {
            exception.printStackTrace();
        }

        String line = buffer.readLine();

        // Add file elements to list
        while (line != null) {
            listVehicleInfo.add(line);
            line = buffer.readLine();
        }

        // Create array of vehicle info of the size of the list
        vehicleInfoArray = listVehicleInfo.toArray(new String[0]);

        for (int counter = 0; counter < vehicleInfoArray.length; counter++) {
            final List<String> list = new ArrayList<String>(Arrays.asList(
                vehicleInfoArray[counter].split(" ")));

            if ("truck".equals(list.get(VEHICLE_TYPE_INDEX).toLowerCase())) {
                for (int counter2 = 0; counter2 < list.size(); counter2++) {
                    if (counter2 == VEHICLE_NUM_INDEX) {
                        try {
                            // Check if the truck number is an integer
                            Integer.parseInt(list.toArray(
                                new String[0])[counter2]);
                        } catch (NumberFormatException exception) {
                            // Set the truck number value to null if
                            // the input is invalid
                            list.set(counter2, STRING_NULL);
                        }
                    } else if (counter2 == LICENSE_INDEX) {
                        // Check if a license plate was written
                        if (list.toArray(new String[0])
                            [counter2] == null) {
                            // Set the license plate to XXX XXX
                            // if the field is empty
                            list.set(counter2, "XXX XXX");
                        }
                    } else if (counter2 == DOORS_NUM_INDEX) {
                        try {
                            // Check if the number of doors is an integer
                            Integer.parseInt(list.toArray(
                                new String[0])[counter2]);
                        } catch (NumberFormatException exception) {
                            // Set the door number value to "0"
                            // if the input is invalid
                            list.set(counter2, STRING_ZERO);
                        }
                    } else if (counter2 == TRUCK_WHEELS_NUM_INDEX) {
                        try {
                            // Check if the number of doors is an integer
                            Integer.parseInt(list.toArray(
                                new String[0])[counter2]);
                        } catch (NumberFormatException exception) {
                            // Set the door number value to "0"
                            // if the input is invalid
                            list.set(counter2, STRING_ZERO);
                        }
                    } else if (counter2 == TRUCK_LENGTH) {
                        try {
                            // Check if the number of doors is an integer
                            Integer.parseInt(list.toArray(
                                new String[0])[counter2]);
                        } catch (NumberFormatException exception) {
                            // Set the door number value to "0"
                            // if the input is invalid
                            list.set(counter2, STRING_ZERO);
                        }
                    } else if (counter2 == TRUCK_SPEED_INDEX) {
                        try {
                            // Check if the speed is an integer
                            Integer.parseInt(list.toArray(
                                new String[0])[counter2]);
                        } catch (NumberFormatException exception) {
                            // Set the speed value to "0"
                            // if the input is invalid
                            list.set(counter2, STRING_ZERO);
                        }
                    } else if (counter2 == TRUCK_MAX_SPEED_INDEX) {
                        try {
                            // Check if the max speed is an integer
                            Integer.parseInt(list.toArray(
                                new String[0])[counter2]);
                        } catch (NumberFormatException exception) {
                            // Set the max speed value to "0"
                            // if the input is invalid
                            list.set(counter2, STRING_ZERO);
                        }
                    }
                }

                // Create aVehicle object containing the information
                // of each string
                final Truck aTruck = new Truck(
                    list.toArray(new String[0])[VEHICLE_NUM_INDEX],
                    list.toArray(new String[0])[LICENSE_INDEX],
                    list.toArray(new String[0])[COLOUR_INDEX],
                    list.toArray(new String[0])[DOORS_NUM_INDEX],
                    list.toArray(new String[0])[TRUCK_WHEELS_NUM_INDEX],
                    list.toArray(new String[0])[TRUCK_LENGTH],
                    list.toArray(new String[0])[TRUCK_SPEED_INDEX],
                    list.toArray(new String[0])[TRUCK_MAX_SPEED_INDEX]);

                // Get the current speed of the truck
                aTruck.getSpeed();

                // Get the max speed of the truck
                aTruck.getMaxSpeed();

                // Accelerate the truck by 10 km/h
                aTruck.accelerate(STRING_TEN);

                // Deceleration the truck by 10 km/h
                aTruck.brake(STRING_FIVE);

                // Get the truck's information
                aTruck.getInfo();
            } else if ("bike".equals(list.get(VEHICLE_TYPE_INDEX
                ).toLowerCase())) {
                for (int counter2 = 0; counter2 < list.size(); counter2++) {
                    if (counter2 == VEHICLE_NUM_INDEX) {
                        try {
                            // Check if the bike number is an integer
                            Integer.parseInt(list.toArray(
                                new String[0])[counter2]);
                        } catch (NumberFormatException exception) {
                            // Set the bike number value to null if
                            // the input is invalid
                            list.set(counter2, STRING_NULL);
                        }
                    } else if (counter2 == BIKE_WHEELS_NUM_INDEX) {
                        try {
                            // Check if the number of doors is an integer
                            Integer.parseInt(list.toArray(
                                new String[0])[counter2]);
                        } catch (NumberFormatException exception) {
                            // Set the door number value to "0"
                            // if the input is invalid
                            list.set(counter2, STRING_ZERO);
                        }
                    } else if (counter2 == BIKE_SEATS_NUM_INDEX) {
                        try {
                            // Check if the number of doors is an integer
                            Integer.parseInt(list.toArray(
                                new String[0])[counter2]);
                        } catch (NumberFormatException exception) {
                            // Set the door number value to "0"
                            // if the input is invalid
                            list.set(counter2, STRING_ZERO);
                        }
                    } else if (counter2 == BIKE_SPEED_INDEX) {
                        try {
                            // Check if the speed is an integer
                            Integer.parseInt(list.toArray(
                                new String[0])[counter2]);
                        } catch (NumberFormatException exception) {
                            // Set the speed value to "0"
                            // if the input is invalid
                            list.set(counter2, STRING_ZERO);
                        }
                    } else if (counter2 == BIKE_MAX_SPEED_INDEX) {
                        try {
                            // Check if the max speed is an integer
                            Integer.parseInt(list.toArray(
                                new String[0])[counter2]);
                        } catch (NumberFormatException exception) {
                            // Set the max speed value to "0"
                            // if the input is invalid
                            list.set(counter2, STRING_ZERO);
                        }
                    }
                }

                // Create aVehicle object containing the information
                // of each string
                final Bike aBike = new Bike(
                    list.toArray(new String[0])[VEHICLE_NUM_INDEX],
                    list.toArray(new String[0])[BIKE_COLOUR_INDEX],
                    list.toArray(new String[0])[BIKE_WHEELS_NUM_INDEX],
                    list.toArray(new String[0])[BIKE_SEATS_NUM_INDEX],
                    list.toArray(new String[0])[BIKE_SPEED_INDEX],
                    list.toArray(new String[0])[BIKE_MAX_SPEED_INDEX]);

                // Get the current speed of the bike
                aBike.getSpeed();

                // Get the max speed of the bike
                aBike.getMaxSpeed();

                // Accelerate the bike by 10 km/h
                aBike.accelerate(STRING_TEN);

                // Deceleration the bike by 10 km/h
                aBike.brake(STRING_FIVE);

                // Get the bike's information
                aBike.getInfo();
            } else {
                for (int counter2 = 0; counter2 < list.size(); counter2++) {
                    if (counter2 == VEHICLE_NUM_INDEX) {
                        try {
                            // Check if the vehicle number is an integer
                            Integer.parseInt(list.toArray(
                                new String[0])[counter2]);
                        } catch (NumberFormatException exception) {
                            // Set the vehicle number value to null if
                            // the input is invalid
                            list.set(counter2, STRING_NULL);
                        }
                    } else if (counter2 == LICENSE_INDEX) {
                        // Check if a license plate was written
                        if (list.toArray(new String[0])
                            [counter2] == null) {
                            // Set the license plate to XXX XXX
                            // if the field is empty
                            list.set(counter2, "XXX XXX");
                        }
                    } else if (counter2 == DOORS_NUM_INDEX) {
                        try {
                            // Check if the number of doors is an integer
                            Integer.parseInt(list.toArray(
                                new String[0])[counter2]);
                        } catch (NumberFormatException exception) {
                            // Set the door number value to "0"
                            // if the input is invalid
                            list.set(counter2, STRING_ZERO);
                        }
                    } else if (counter2 == SPEED_INDEX) {
                        try {
                            // Check if the speed is an integer
                            Integer.parseInt(list.toArray(
                                new String[0])[counter2]);
                        } catch (NumberFormatException exception) {
                            // Set the speed value to "0"
                            // if the input is invalid
                            list.set(counter2, STRING_ZERO);
                        }
                    } else if (counter2 == MAX_SPEED_INDEX) {
                        try {
                            // Check if the max speed is an integer
                            Integer.parseInt(list.toArray(
                                new String[0])[counter2]);
                        } catch (NumberFormatException exception) {
                            // Set the max speed value to "0"
                            // if the input is invalid
                            list.set(counter2, STRING_ZERO);
                        }
                    }
                }

                // Create aVehicle object containing the information
                // of each string
                final Vehicle aVehicle = new Vehicle(
                    list.toArray(new String[0])[VEHICLE_NUM_INDEX],
                    list.toArray(new String[0])[LICENSE_INDEX],
                    list.toArray(new String[0])[COLOUR_INDEX],
                    list.toArray(new String[0])[DOORS_NUM_INDEX],
                    list.toArray(new String[0])[SPEED_INDEX],
                    list.toArray(new String[0])[MAX_SPEED_INDEX]);

                // Get the current speed of the vehicle
                aVehicle.getSpeed();

                // Get the max speed of the vehicle
                aVehicle.getMaxSpeed();

                // Accelerate the vehicle by 10 km/h
                aVehicle.accelerate(STRING_TEN);

                // Deceleration the vehicle by 10 km/h
                aVehicle.brake(STRING_FIVE);

                // Get the vehicle's information
                aVehicle.getInfo();
            }
        }
    }
}
