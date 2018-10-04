package com.skteam.rentingsystem.service;

import com.skteam.rentingsystem.dao.RentDetailsDAO;
import com.skteam.rentingsystem.entity.RentDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RentDetailsServiceImpl implements RentDetailsService {

    @Autowired
    RentDetailsDAO rentDetailsDAO;

    @Transactional
    @Override
    public void saveRentDetails(RentDetails rentDetails) {
        rentDetailsDAO.saveRentDetails(rentDetails);
    }

    @Transactional
    @Override
    public RentDetails getRentDetails(int id) {
        return rentDetailsDAO.getRentDetails(id);
    }

    @Transactional
    @Override
    public void deleteRentDetails(int id) {
        rentDetailsDAO.deleteRentDetails(id);
    }
}
