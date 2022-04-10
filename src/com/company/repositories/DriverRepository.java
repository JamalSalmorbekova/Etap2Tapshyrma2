package com.company.repositories;

import com.company.models.Driver;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DriverRepository {
    private static Map<Integer, Driver> driverMap = new HashMap<>();

    public static final GsonBuilder GSON_BUILDER = new GsonBuilder();
    public static final Gson GSON = GSON_BUILDER.setPrettyPrinting().create();
    public static final Driver driver = new Driver(1, "Victo ", "               ");
    public static final Driver driver1 = new Driver(2, "Vasiliy", "               ");
    public static final Driver driver2 = new Driver(3, "Nikolay", "               ");
    public static final Driver[] drivers = new Driver[]{driver, driver2, driver1};

    public  void writeDrivers(Driver[]drivers) {
        String jsonDrivers = GSON.toJson(drivers);
        try {
            Path path = Paths.get("./drivers.json");
            Files.writeString(path, jsonDrivers, StandardOpenOption.WRITE, StandardOpenOption.CREATE);
        } catch (IOException e) {
            e.printStackTrace();

        }

    }

    public  List<Driver>getAllDrivers(){
        return driverMap.values().stream().toList();
    }

    public  Map<Integer, Driver> getDriverMap() {
        return driverMap;
    }


}
