package com.company;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;

import static com.company.State.*;

public class Main {
    public static final GsonBuilder GSON_BUILDER = new GsonBuilder();
    public static final Gson GSON = GSON_BUILDER.setPrettyPrinting().create();
    public static final Path PATH = Paths.get("./truck.json");
    public static final Path PATH1 = Paths.get("./driver.json");

    public static void main(String[] args) {
        Truck[] trucks = {
                Truck.makeATruck(1, "Renault Magnum", "       ", BASE),
                Truck.makeATruck(2, "Volvo         ", "       ", REPAIR),
                Truck.makeATruck(3, "DAF XT        ", "       ", ROUTE)
        };
        String json= GSON.toJson(trucks);
        write(json);
        Truck[]trucks1=GSON.fromJson(read(), Truck[].class);
        System.out.println("#   |      Bus     |  Driver   |    State    ");
        System.out.println("====+==============+===========+=============");

        for (Truck t:trucks1) {
            System.out.println(t);

        }
        Driver[]drivers={
                Driver.driver(1, "Victor ", "               "),
                Driver.driver(2, "Vasiliy", "               "),
                Driver.driver(3, "Nikolay", "               ")


        };

        System.out.println();

        String json1=GSON.toJson(drivers);
        write(json);
        Driver[]drivers1=GSON.fromJson(read(), Driver[].class);
        System.out.println("#   |   Driver     |  Bus      ");
        System.out.println("====+==============+============");

        for (Driver d:drivers) {
            System.out.println(d);

        }
    }

    public static void write(String o) {
        try {
            Path path = Paths.get(String.valueOf(PATH));
            Files.writeString(path, o, StandardOpenOption.WRITE, StandardOpenOption.CREATE);
        } catch (IOException e) {
            e.printStackTrace();

        }

    }
    public static void writeDrivers(String o) {
        try {
            Path path = Paths.get(String.valueOf(PATH1));
            Files.writeString(path, o, StandardOpenOption.WRITE, StandardOpenOption.CREATE);
        } catch (IOException e) {
            e.printStackTrace();

        }

    }
    public static String read(){
        String json="";
        try{
            int a;
            FileReader fileReader=new FileReader(String.valueOf(PATH));
            while((a= fileReader.read())!=-1){
                json+=(char)a;
            }
        }catch (IOException e){
            e.printStackTrace();
        }return json;
    }
    public static String readDriver(){
        String json="";
        try{
            int a;
            FileReader fileReader=new FileReader(String.valueOf(PATH1));
            while((a= fileReader.read())!=-1){
                json+=(char)a;
            }
        }catch (IOException e){
            e.printStackTrace();
        }return json;
    }
}