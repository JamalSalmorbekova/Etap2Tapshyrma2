package com.company;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
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
        Truck truck1 = new Truck(2, "Volvo         ", "       ", REPAIR);
        Truck truck2 = new Truck(3, "DAF XT        ", "       ", ROUTE);
        Truck[] trucks = {truck, truck1, truck2};

        Driver driver = new Driver(1, "Victor ", "               ");
        Driver driver1 = new Driver(2, "Vasiliy", "               ");
        Driver driver2 = new Driver(3, "Nikolay", "               ");
        Driver[] drivers = {driver, driver2, driver1};

        Scanner scanner = new Scanner(System.in);

        System.out.println("ENTER ID OF TRUCK TO SEE ALL INFORMATION ABOUT IT: ");
        int a = scanner.nextInt();

        for (Truck t : trucks) {
            if (a == t.getId()) {
                System.out.println("N  : " + t.getId());
                System.out.println("Truck : " + t.getName());
                System.out.println("Driver : " + t.getDriver());
                System.out.println("Truck State: " + t.getState());
            }
        }
        


//        Truck.changeDriver(truck, driver);
//        Truck.startDriving(truck);
//        Truck.changeDriver(truck, driver1);
//
//        Truck.changeDriver(truck, driver);

        String json = GSON.toJson(trucks);
        write(json);

        String json1 = GSON.toJson(drivers);
        writeDrivers(json1);

//        System.out.println("#   |      Bus     |  Driver   |    State    ");
//        System.out.println("====+==============+===========+=============");
//
//        Arrays.stream(trucks).forEach(System.out::println);

//        System.out.println();
//
//        System.out.println("#   |   Driver     |  Bus      ");
//        System.out.println("====+==============+============");
//
//        Arrays.stream(drivers).forEach(System.out::println);
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
}
