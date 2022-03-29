package com.company;

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
    public static Truck makeATruck(int id, String name, String driver, State state){
        Truck truck=new Truck();
        truck.id=id;
        truck.name=name;
        truck.driver=driver;
        truck.state=state;
        return truck;
    }
    public static void changeDriver(Truck truck, Driver driver) {


        if (truck.state.equals(State.BASE)) {
            truck.setDriver(driver.getName());
        }
        try {
            if (truck.state.equals(State.ROUTE)) {
                throw new InvalidChangeAttemptException();
            }
        } catch (InvalidChangeAttemptException e) {
            System.err.printf("YOU CAN'T CHANGE DRIVER, BECAUSE THE TRUCK[%S] ON THE ROUTE", truck.getName());
        }
        try {
            if (truck.state.equals(State.REPAIR)) {
                throw new InvalidChangeAttemptException();
            }
        } catch (InvalidChangeAttemptException e) {
            System.err.printf("YOU CAN'T CHANGE DRIVER, BECAUSE THE TRUCK[%S] ON THE REPAIR", truck.getName());
        }


    }

    public static void startDriving(Truck truck) {
        if (truck.state.equals(State.BASE)) {
            truck.setState(State.ROUTE);
//            System.out.printf("TRUCK [%S] IS ON ROUTE", truck.getName());
        }
        try {
            if (truck.getDriver() == null) {
                throw new InvalidChangeAttemptException();
            }

        } catch (InvalidChangeAttemptException e) {
            System.err.printf("THE TRUCK[%S] HAVE NOT A DRIVER", truck.getName());
        }
        try {
            if (truck.state.equals(State.REPAIR)) {
                throw new InvalidChangeAttemptException();
            }
        } catch (InvalidChangeAttemptException e) {
            System.err.printf("YOU CAN'T COMMENCE TO DRIVE , BECAUSE THE TRUCK[%S] ON THE REPAIR", truck.getName());
        }
    }

    public static void startRepair(Truck truck) {
        try {
            if (truck.state.equals(State.REPAIR)) {
                throw new InvalidChangeAttemptException();
            }
        }catch (InvalidChangeAttemptException e){
            System.err.printf("THIS TRUCK[%S] ON THE REPAIR", truck.getName());
        }
    }




    @Override
    public String toString() {
        return id+"   |"+name+"|  " +driver+"  |    "+ state +'\n';

    }
}
