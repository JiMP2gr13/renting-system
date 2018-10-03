package com.skteam.rentingsystem.dao;

import com.skteam.rentingsystem.entity.Category;
import com.skteam.rentingsystem.entity.RentDetails;

public interface RentDetailsDAO {
    public void saveRentDetails(RentDetails rentDetails);

    public RentDetails getRentDetails(int id);

    public void deleteRentDetails(int id);
}
