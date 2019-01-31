package com.aia.dao.impl;

import com.aia.dao.CustomerDao;
import org.springframework.stereotype.Repository;

@Repository
public class CustomerDaoImpl2 implements CustomerDao {

    @Override
    public void saveCustomer() {
        System.out.println("持久层2");
    }
}
