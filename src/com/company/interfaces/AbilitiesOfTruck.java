package com.company.interfaces;

import com.company.enums.State;
import com.company.exceptions.InvalidChangeAttemptException;
import com.company.exceptions.InvalidChangeDriverException;
import com.company.exceptions.InvalidStartDrivingException;
import com.company.exceptions.InvalidStartRepairException;
import com.company.models.Driver;
import com.company.models.Truck;

public interface AbilitiesOfTruck {
     static void changeDriver(Truck truck, Driver[] drivers) throws InvalidChangeDriverException {
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
            throw new InvalidChangeDriverException();
        }
        try {
            if (truck.getState().equals(State.REPAIR)) {
                throw new InvalidChangeAttemptException();
            }
        } catch (InvalidChangeAttemptException e) {
            System.err.printf("YOU CAN'T CHANGE DRIVER, BECAUSE THE TRUCK[%S] ON THE REPAIR\n", truck.getName());
            throw new InvalidChangeDriverException();
        }


    }

     static void startDriving(Truck truck) throws InvalidStartDrivingException {
        if (truck.getState().equals(State.BASE)) {
            truck.setState(State.ROUTE);
        }
        try {
            if (truck.getDriver().matches("[^a-zA-Z]*")) {
                throw new InvalidChangeAttemptException();
            }
        } catch (InvalidChangeAttemptException e) {
            System.err.printf("THE TRUCK[%S] HAVE NOT A DRIVER\n", truck.getName());
            throw new InvalidStartDrivingException();
        }
        try {
            if (truck.getState().equals(State.REPAIR)) {
                throw new InvalidChangeAttemptException();
            }
        } catch (InvalidChangeAttemptException e) {
            System.err.printf("YOU CAN'T COMMENCE TO DRIVE , BECAUSE THE TRUCK[%S] ON THE REPAIR\n", truck.getName());
            throw new InvalidStartDrivingException();
        }
    }

     static void startRepair(Truck truck) throws InvalidStartRepairException{
        try {
            if (truck.getState().equals(State.REPAIR)) {
                throw new InvalidChangeAttemptException();
            }
        } catch (InvalidChangeAttemptException e) {
            System.err.printf("THIS TRUCK[%S] ALREADY ON THE REPAIR\n", truck.getName());
            throw new InvalidStartRepairException();
        }
        try {
            if (truck.getState().equals(State.ROUTE)) {
                throw new InvalidChangeAttemptException();
            }
        } catch (InvalidChangeAttemptException e) {
            System.err.printf("YOU CAN'T START REPAIRING , BECAUSE TRUCK[%S] ON THE ROUTE \n", truck.getName());
            throw new InvalidStartRepairException();
        }
        if (truck.getState().equals(State.BASE)) {
            truck.setState(State.REPAIR);
        }
    }
}
