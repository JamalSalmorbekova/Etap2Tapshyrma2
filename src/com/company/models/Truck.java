package com.company.models;

import com.company.exceptions.InvalidChangeAttemptException;
import com.company.enums.State;

public class Truck {
    private int id;
    private String name;
    private String driver;
    private State state;


    public Truck() {
    }

    public Truck(int id, String name, String driver, State state) {
        this.id = id;
        this.name = name;
        this.driver = driver;
        this.state = state;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }



    public static void changeDriver(Truck truck, Driver[] drivers) {
        for (Driver d:drivers) {
            if(d.getBus().matches("[^a-zA-Z]*")){
                truck.setDriver(d.getName());
                d.setBus(truck.getName());
                break;
            }
        }

        try {
            if (truck.state.equals(State.ROUTE)) {
                throw new InvalidChangeAttemptException();
            }
        } catch (InvalidChangeAttemptException e) {
            System.err.printf("YOU CAN'T CHANGE DRIVER, BECAUSE THE TRUCK[%S] ON THE ROUTE\n", truck.getName());
        }
        try {
            if (truck.state.equals(State.REPAIR)) {
                throw new InvalidChangeAttemptException();
            }
        } catch (InvalidChangeAttemptException e) {
            System.err.printf("YOU CAN'T CHANGE DRIVER, BECAUSE THE TRUCK[%S] ON THE REPAIR\n", truck.getName());
        }


    }

    public static void startDriving(Truck truck) {
        if (truck.state.equals(State.BASE)) {
            truck.setState(State.ROUTE);
        }
        try {
            if (truck.getDriver().matches("[^a-zA-Z]*")) {
                throw new InvalidChangeAttemptException();
            }
        } catch (InvalidChangeAttemptException e) {
            System.err.printf("THE TRUCK[%S] HAVE NOT A DRIVER\n", truck.getName());
        }
        try {
            if (truck.state.equals(State.REPAIR)) {
                throw new InvalidChangeAttemptException();
            }
        } catch (InvalidChangeAttemptException e) {
            System.err.printf("YOU CAN'T COMMENCE TO DRIVE , BECAUSE THE TRUCK[%S] ON THE REPAIR\n", truck.getName());
        }
    }

    public static void startRepair(Truck truck) {
        try {
            if (truck.state.equals(State.REPAIR)) {
                throw new InvalidChangeAttemptException();
            }
        } catch (InvalidChangeAttemptException e) {
            System.err.printf("THIS TRUCK[%S] ALREADY ON THE REPAIR\n", truck.getName());
        }
        try {
            if (truck.state.equals(State.ROUTE)) {
                throw new InvalidChangeAttemptException();
            }
        } catch (InvalidChangeAttemptException e) {
            System.err.printf("YOU CAN'T START REPAIRING , BECAUSE TRUCK[%S] ON THE ROUTE \n", truck.getName());
        }
        if (truck.state.equals(State.BASE)) {
            truck.state = State.REPAIR;
        }
    }
    @Override
    public String toString() {
        return id + "   |" + name + "|  " + driver + "  |    " + state + '\n';

    }
}
