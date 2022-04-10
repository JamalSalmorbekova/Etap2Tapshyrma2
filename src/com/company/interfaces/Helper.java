package com.company.interfaces;

import com.company.models.Driver;
import com.company.models.Truck;

import java.util.Arrays;

public interface Helper {
     static void printAllInformation(Truck[] trucks, Driver[] drivers) {
        System.out.println("-----------------------------");
        Arrays.stream(trucks).forEach(System.out::println);
        System.out.println("---------------------------------------");
        Arrays.stream(drivers).forEach(System.out::println);
     }
     static void instruction(){
         System.out.println("Press 1 to change Driver");
         System.out.println("Press 2 to send to the Route");
         System.out.println("Press 3 ot send to the Repairing");
     }
}
