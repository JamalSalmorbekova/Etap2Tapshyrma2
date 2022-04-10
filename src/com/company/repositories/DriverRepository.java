package com.company.repositories;
import com.company.models.Driver;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;


public class DriverRepository {

    public static final GsonBuilder GSON_BUILDER = new GsonBuilder();
    public static final Gson GSON = GSON_BUILDER.setPrettyPrinting().create();
    public static Driver driver = new Driver(1, "Victor ", "               ");
    public static Driver driver1 = new Driver(2, "Vasiliy", "               ");
    public static Driver driver2 = new Driver(3, "Nikolay", "               ");
    public static Driver[] drivers = new Driver[]{driver, driver2, driver1};

    public void writeDrivers(Driver[] drivers) {
        String jsonDrivers = GSON.toJson(drivers);
        try {
            Path path = Paths.get("./drivers.json");
            Files.writeString(path, jsonDrivers, StandardOpenOption.WRITE, StandardOpenOption.CREATE);
        } catch (IOException e) {
            e.printStackTrace();

        }
    }

    public void readDrivers() {
        String json = "";
        try {
            FileReader fileReader = new FileReader("./drivers.json");
            int a;
            while ((a = fileReader.read()) != -1) {
                json += (char) a;
            }
            Driver[] drivers = GSON.fromJson(json, Driver[].class);
            for (Driver driver : drivers) {
                System.out.println(driver);

            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
