package com.company.interfaces;

import com.company.enums.State;
import com.company.exceptions.InvalidChangeAttemptException;
import com.company.models.Driver;
import com.company.models.Truck;

public interface AbilitiesOfTruck {
     static void changeDriver(Truck truck, Driver[] drivers) throws RuntimeException{
        for (Driver d:drivers) {
            if(d.getBus().matches("[^a-zA-Z]*")){
                truck.setDriver(d.getName());
                d.setBus(truck.getName());
                break;
            }
        }

        try {
            if (truck.getState().equals(State.ROUTE)) {
                throw new InvalidChangeAttemptException();
            }
        } catch (InvalidChangeAttemptException e) {
            System.err.printf("YOU CAN'T CHANGE DRIVER, BECAUSE THE TRUCK[%S] ON THE ROUTE\n", truck.getName());
            throw new RuntimeException();
        }
        try {
            if (truck.getState().equals(State.REPAIR)) {
                throw new InvalidChangeAttemptException();
            }
        } catch (InvalidChangeAttemptException e) {
            System.err.printf("YOU CAN'T CHANGE DRIVER, BECAUSE THE TRUCK[%S] ON THE REPAIR\n", truck.getName());
            throw new RuntimeException();
        }


    }

    public static void startDriving(Truck truck) throws RuntimeException {
        if (truck.getState().equals(State.BASE)) {
            truck.setState(State.ROUTE);
        }
        try {
            if (truck.getDriver().matches("[^a-zA-Z]*")) {
                throw new InvalidChangeAttemptException();
            }
        } catch (InvalidChangeAttemptException e) {
            System.err.printf("THE TRUCK[%S] HAVE NOT A DRIVER\n", truck.getName());
            throw new RuntimeException();
        }
        try {
            if (truck.getState().equals(State.REPAIR)) {
                throw new InvalidChangeAttemptException();
            }
        } catch (InvalidChangeAttemptException e) {
            System.err.printf("YOU CAN'T COMMENCE TO DRIVE , BECAUSE THE TRUCK[%S] ON THE REPAIR\n", truck.getName());
            throw new RuntimeException();
        }
    }

    public static void startRepair(Truck truck) throws RuntimeException{
        try {
            if (truck.getState().equals(State.REPAIR)) {
                throw new InvalidChangeAttemptException();
            }
        } catch (InvalidChangeAttemptException e) {
            System.err.printf("THIS TRUCK[%S] ALREADY ON THE REPAIR\n", truck.getName());
            throw new RuntimeException();
        }
        try {
            if (truck.getState().equals(State.ROUTE)) {
                throw new InvalidChangeAttemptException();
            }
        } catch (InvalidChangeAttemptException e) {
            System.err.printf("YOU CAN'T START REPAIRING , BECAUSE TRUCK[%S] ON THE ROUTE \n", truck.getName());
            throw new RuntimeException();
        }
        if (truck.getState().equals(State.BASE)) {
            truck.setState(State.REPAIR);
        }
    }
}
