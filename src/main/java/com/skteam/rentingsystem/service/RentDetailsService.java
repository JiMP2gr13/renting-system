package com.skteam.rentingsystem.service;

import com.skteam.rentingsystem.entity.RentDetails;

public interface RentDetailsService {
    public void saveRentDetails(RentDetails rentDetails);

    public RentDetails getRentDetails(int id);

    public void deleteRentDetails(int id);
}
