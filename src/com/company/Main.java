package com.company;

import com.company.exceptions.InvalidChangeAttemptException;
import com.company.interfaces.Helper;
import com.company.models.Driver;
import com.company.models.Truck;
import com.company.repositories.DriverRepository;
import com.company.repositories.TruckRepository;
import com.company.sevices.DriverService;
import com.company.sevices.TruckService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.*;

import static com.company.enums.State.*;

public class Main {


    public static void main(String[] args) {

        final TruckService truckService = new TruckService();
        truckService.writeTrucks();
        truckService.findAllTrucks();
        while (true) {
            truckService.run();
        }

    }

}


