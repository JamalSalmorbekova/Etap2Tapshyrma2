package com.company.repositories;

import com.company.exceptions.InvalidChangeAttemptException;
import com.company.exceptions.JsonFileNotFoundException;
import com.company.interfaces.AbilitiesOfTruck;
import com.company.interfaces.Helper;
import com.company.models.Driver;
import com.company.models.Truck;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.stream.JsonReader;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import static com.company.enums.State.BASE;

public class TruckRepository {
    private static Map<Integer, Truck> truckMap = new HashMap<>();

    public static final GsonBuilder GSON_BUILDER = new GsonBuilder();
    public static final Gson GSON = GSON_BUILDER.setPrettyPrinting().create();
    public static final Truck truck = new Truck(1, "Renault Magnum", "       ", BASE);
    public static final Truck truck1 = new Truck(2, "Volvo         ", "       ", BASE);
    public static final Truck truck2 = new Truck(3, "DAF XT        ", "       ", BASE);
    public static final Truck[] trucks = {truck, truck1, truck2};
    public static final Scanner scanner = new Scanner(System.in);


    public void writeTrucks(Truck[] trucks) {
        String jsonTrucks = GSON.toJson(trucks);
        try {
            Path path = Paths.get("trucks.json");
            Files.writeString(path, jsonTrucks, StandardOpenOption.WRITE, StandardOpenOption.CREATE);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void readTrucks() {
//        JsonReader jsonReader= null;
//        try {
//            jsonReader = new JsonReader(new FileReader("trucks.json"));
//        } catch (FileNotFoundException e) {
//            throw new JsonFileNotFoundException("trucks.json does not exist");
//        }
//        Truck[]trucks=GSON.fromJson(jsonReader, Driver[].class);
//        for (Truck truck:trucks) {
//            truckMap.put(truck.getId(),truck );
//
//        }
        String json = "";
        try {
            FileReader fileReader = new FileReader("./trucks.json");
            int a;
            while ((a = fileReader.read()) != -1) {
                json += (char) a;
            }
            Truck[] drivers = GSON.fromJson(json, Truck[].class);
            for (Truck driver : drivers) {
                System.out.println(driver);

            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public  void Operations() {


        System.out.println("ENTER ID OF TRUCK TO SEE ALL INFORMATION ABOUT IT: ");
        int a = scanner.nextInt();

        for (Truck t : trucks) {
            if (a == t.getId()) {
                Helper.findTruckById(t);
                Helper.instruction();
                int input = scanner.nextInt();
                try {
                    if (input == 1) {
                        AbilitiesOfTruck.changeDriver(t, DriverRepository.drivers);
                        System.out.println("-----------------------------");
                        System.out.println("Driver changed successfully");
                        Helper.printAllInformation(trucks, DriverRepository.drivers);
                    } else if (input == 2) {
                        AbilitiesOfTruck.startDriving(t);
                        System.out.println("-----------------------------");
                        System.out.println("You have successfully entered the route");
                        Helper.printAllInformation(trucks, DriverRepository.drivers);
                    } else if (input == 3) {
                        AbilitiesOfTruck.startRepair(t);

                        System.out.println("-----------------------------");
                        System.out.println("you have successfully sent for repair");
                        Helper.printAllInformation(trucks, DriverRepository.drivers);
                    } else {
                        throw new InvalidChangeAttemptException();
                    }
                } catch (InvalidChangeAttemptException e) {
                    System.err.println("WE COULD NOT FIND THIS NUMBER");
                }
            }
        }

//        public List<Truck> getAllTrucks () {
//            return truckMap.values().stream().toList();
//        }
//
//        public Map<Integer, Truck> getTrucksMap () {
//            return truckMap;
//        }

    }
}
