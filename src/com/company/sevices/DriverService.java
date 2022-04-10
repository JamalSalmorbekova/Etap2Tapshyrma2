package com.company.sevices;

import com.company.models.Driver;
import com.company.models.Truck;
import com.company.repositories.DriverRepository;

import java.util.List;

import static com.company.enums.State.BASE;

public class DriverService {
    private DriverRepository driverRepository=new DriverRepository();


    public void writeDrivers(){
        driverRepository.writeDrivers(DriverRepository.drivers);
    }

}
