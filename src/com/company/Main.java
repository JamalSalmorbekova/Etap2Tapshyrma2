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
        final DriverService driverService = new DriverService();
        final TruckService truckService=new TruckService();

//        Truck truck = new Truck(1, "Renault agnum", "       ", BASE);
//        Truck truck1 = new Truck(2, "Volvo         ", "       ", BASE);
//        Truck truck2 = new Truck(3, "DAF XT        ", "       ", BASE);
//        Truck[] trucks = {truck, truck1, truck2};
//
//        Driver driver = new Driver(1, "Victor ", "               ");
//        Driver driver1 = new Driver(2, "Vasiliy", "               ");
//        Driver driver2 = new Driver(3, "Nikolay", "               ");
//        Driver[] drivers = {driver, driver2, driver1};
//
//        System.out.println(truckService.findAllDrivers());
//        Arrays.stream(trucks).forEach(System.out::println);

//        while (true) {
//            Scanner scanner = new Scanner(System.in);
//
//            System.out.println("ENTER ID OF TRUCK TO SEE ALL INFORMATION ABOUT IT: ");
//            int a = scanner.nextInt();
//
//            for (Truck t : trucks) {
//                if (a == t.getId()) {
//                    System.out.println("N  : " + t.getId());
//                    System.out.println("Truck : " + t.getName());
//                    System.out.println("Driver : " + t.getDriver());
//                    System.out.println("Truck State: " + t.getState());
//
//
//                    Helper.instruction();
//                    int input = scanner.nextInt();
//                    try {
//                        if (input == 1) {
//                            Truck.changeDriver(t, drivers);
//                            System.out.println("-----------------------------");
//                            System.out.println("Driver changed successfully");
//                            Helper.printAllInformation(trucks, drivers);
//                        } else if (input == 2) {
//                            Truck.startDriving(t);
//                            System.out.println("-----------------------------");
//                            System.out.println("You have successfully entered the route");
//                            Helper.printAllInformation(trucks, drivers);
//                        } else if (input == 3) {
//                            Truck.startRepair(t);
//
//                            System.out.println("-----------------------------");
//                            System.out.println("you have successfully sent for repair");
//                            Helper.printAllInformation(trucks, drivers);
//                        } else {
//                            throw new InvalidChangeAttemptException();
//                        }
//                    } catch (InvalidChangeAttemptException e) {
//                        System.err.println("WE COULD NOT FIND THIS NUMBER");
//                    }
//                }
//            }
            driverService.writeDrivers();
            truckService.writeTrucks();
//            TruckRepository.writeTrucks(trucks);
//            DriverRepository.writeDrivers(drivers);


        }

    }

//}
