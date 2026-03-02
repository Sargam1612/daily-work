package com.zeta.demo.repository;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
public class MyRepository {
    public void saveOrder(){
        System.out.println("saved");
    }

    public void deleteOrder() {
        System.out.println("deleted");
    }
}

