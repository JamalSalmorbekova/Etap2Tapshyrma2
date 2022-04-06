package com.company;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.*;

import static com.company.State.*;

public class Main {
    public static final GsonBuilder GSON_BUILDER = new GsonBuilder();
    public static final Gson GSON = GSON_BUILDER.setPrettyPrinting().create();
    public static final Path PATH = Paths.get("./truck.json");
    public static final Path PATH1 = Paths.get("./driver.json");

    public static void main(String[] args) {

        Truck truck = new Truck(1, "Renault Magnum", "       ", BASE);
        Truck truck1 = new Truck(2, "Volvo         ", "       ", BASE);
        Truck truck2 = new Truck(3, "DAF XT        ", "       ", BASE);
        Truck[] trucks = {truck, truck1, truck2};

        Driver driver = new Driver(1, "Victor ", "               ");
        Driver driver1 = new Driver(2, "Vasiliy", "               ");
        Driver driver2 = new Driver(3, "Nikolay", "               ");
        Driver[] drivers = {driver, driver2, driver1};


        Arrays.stream(trucks).forEach(System.out::println);

        while (true) {
            Scanner scanner = new Scanner(System.in);

            System.out.println("ENTER ID OF TRUCK TO SEE ALL INFORMATION ABOUT IT: ");
            int a = scanner.nextInt();

            for (Truck t : trucks) {
                if (a == t.getId()) {
                    System.out.println("N  : " + t.getId());
                    System.out.println("Truck : " + t.getName());
                    System.out.println("Driver : " + t.getDriver());
                    System.out.println("Truck State: " + t.getState());


                    System.out.println("Press 1 to change Driver");
                    System.out.println("Press 2 to send to the Route");
                    System.out.println("Press 3 ot send to the Repairing");
                    int input = scanner.nextInt();
                    try {
                        if (input == 1) {
                            Truck.changeDriver(t, drivers);
                            System.out.println("-----------------------------");
                            System.out.println("Driver changed successfully");
                            printAllInformation(trucks, drivers);
                        } else if (input == 2) {
                            Truck.startDriving(t);
                            System.out.println("-----------------------------");
                            System.out.println("You have successfully entered the route");
                            printAllInformation(trucks, drivers);
                        } else if (input == 3) {
                            Truck.startRepair(t);

                            System.out.println("-----------------------------");
                            System.out.println("you have successfully sent for repair");
                            printAllInformation(trucks, drivers);
                        } else {
                            throw new InvalidChangeAttemptException();
                        }
                    } catch (InvalidChangeAttemptException e) {
                        System.err.println("WE COULD NOT FIND THIS NUMBER");
                    }
                }
            }

            String json = GSON.toJson(trucks);
            write(json);

            String json1 = GSON.toJson(drivers);
            writeDrivers(json1);
        }

    }

    public static void write(String o) {
        try {
            Path path = Paths.get(String.valueOf(PATH));
            Files.writeString(path, o, StandardOpenOption.WRITE, StandardOpenOption.CREATE);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void writeDrivers(String o) {
        try {
            Path path = Paths.get(String.valueOf(PATH1));
            Files.writeString(path, o, StandardOpenOption.WRITE, StandardOpenOption.CREATE);
        } catch (IOException e) {
            e.printStackTrace();

        }

    }

    public static void printAllInformation(Truck[] trucks, Driver[] drivers) {
        System.out.println("-----------------------------");
        Arrays.stream(trucks).forEach(System.out::println);
        System.out.println("---------------------------------------");
        Arrays.stream(drivers).forEach(System.out::println);


    }
}
