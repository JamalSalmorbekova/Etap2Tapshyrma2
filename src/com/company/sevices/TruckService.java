package com.company.sevices;

import com.company.models.Truck;
import com.company.repositories.DriverRepository;
import com.company.repositories.TruckRepository;

import java.util.List;

import static com.company.enums.State.BASE;

public class TruckService {
    private TruckRepository truckRepository=new TruckRepository();


    public void writeTrucks(){
        truckRepository.writeTrucks(TruckRepository.trucks);
    }
}
