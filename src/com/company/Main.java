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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

        Truck.changeDriver(truck, driver);

        String json = GSON.toJson(trucks);
        write(json);

        String json1 = GSON.toJson(drivers);
        writeDrivers(json1);


//        Truck[] trucks1 = GSON.fromJson(read(), Truck[].class);
        System.out.println("#   |      Bus     |  Driver   |    State    ");
        System.out.println("====+==============+===========+=============");



        for (Truck t : trucks) {
            System.out.println(t);

        }


        System.out.println();


//        Driver[] drivers1 = GSON.fromJson(readDriver(), Driver[].class);
        System.out.println("#   |   Driver     |  Bus      ");
        System.out.println("====+==============+============");

        for (Driver d : drivers) {
            System.out.println(d);

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

//    public static String read() {
//        String json = "";
//        try {
//            int a;
//            FileReader fileReader = new FileReader(String.valueOf(PATH));
//            while ((a = fileReader.read()) != -1) {
//                json += (char) a;
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return json;
//    }
//
//    public static String readDriver() {
//        String json = "";
//        try {
//            int a;
//            FileReader fileReader = new FileReader(String.valueOf(PATH1));
//            while ((a = fileReader.read()) != -1) {
//                json += (char) a;
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return json;
    }
