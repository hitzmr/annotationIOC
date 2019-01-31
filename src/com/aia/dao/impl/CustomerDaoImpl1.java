package com.aia.dao.impl;

import com.aia.dao.CustomerDao;
import org.springframework.stereotype.Repository;

@Repository
public class CustomerDaoImpl1 implements CustomerDao {

    @Override
    public void saveCustomer() {
        System.out.println("持久层1");
    }
}
