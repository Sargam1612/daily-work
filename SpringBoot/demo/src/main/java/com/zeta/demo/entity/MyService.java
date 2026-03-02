package com.zeta.demo.entity;

import com.zeta.demo.repository.MyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


//@Scope("prototype")
//@Component
@Service
public class MyService {
    @Autowired
    MyRepository repository;// dependency

    public void addOrder() {
        // BL
        repository.saveOrder();
        System.out.println("saved");
    }

    public void deleteOrder() {
        // BL
        repository.deleteOrder();
        System.out.println("saved");
    }
}