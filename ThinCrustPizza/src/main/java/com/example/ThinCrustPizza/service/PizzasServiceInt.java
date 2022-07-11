package com.example.ThinCrustPizza.service;

import com.example.ThinCrustPizza.model.Pizza;

import java.util.List;

public interface PizzasServiceInt {

    List<Pizza> findAll();
    Pizza findById(Long id);
    Pizza save(Pizza pizza);

}
