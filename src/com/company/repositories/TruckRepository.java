package com.company.repositories;

import com.company.exceptions.JsonFileNotFoundException;
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

import static com.company.enums.State.BASE;

public class TruckRepository {
    private static Map<Integer, Truck> truckMap = new HashMap<>();

    public static final GsonBuilder GSON_BUILDER = new GsonBuilder();
    public static final Gson GSON = GSON_BUILDER.setPrettyPrinting().create();
    public static final Truck truck = new Truck(1, "Renault agnum", "       ", BASE);
    public static final Truck truck1 = new Truck(2, "Volvo         ", "       ", BASE);
    public static final Truck truck2 = new Truck(3, "DAF XT        ", "       ", BASE);
    public static final Truck[] trucks = {truck, truck1, truck2};




    public  void writeTrucks(Truck[]trucks) {
        String jsonTrucks = GSON.toJson(trucks);
        try {
            Path path = Paths.get("trucks.json");
            Files.writeString(path, jsonTrucks, StandardOpenOption.WRITE, StandardOpenOption.CREATE);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void readTrucks(){
        JsonReader jsonReader= null;
        try {
            jsonReader = new JsonReader(new FileReader("resources/trucks.json"));
        } catch (FileNotFoundException e) {
            throw new JsonFileNotFoundException("trucks.json does not exist");
        }
        Truck[]trucks=GSON.fromJson(jsonReader, Driver[].class);
        for (Truck truck:trucks) {
            truckMap.put(truck.getId(),truck );

        }

    }
    public List<Truck> getAllTrucks(){
        return truckMap.values().stream().toList();
    }

    public Map<Integer, Truck> getTrucksMap() {
        return truckMap;
    }

}
