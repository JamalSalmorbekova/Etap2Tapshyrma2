package com.company.exceptions;

import static com.company.repositories.TruckRepository.truck;

public class InvalidStartRepairException extends RuntimeException{
    public InvalidStartRepairException() {
    }

    public InvalidStartRepairException(String message) {

    }
}
