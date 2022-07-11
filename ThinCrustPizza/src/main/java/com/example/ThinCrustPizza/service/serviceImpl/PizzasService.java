package com.example.ThinCrustPizza.service.serviceImpl;

import com.example.ThinCrustPizza.model.Pizza;
import com.example.ThinCrustPizza.repository.PizzasRepository;
import com.example.ThinCrustPizza.service.PizzasServiceInt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PizzasService implements PizzasServiceInt {

    @Autowired
    PizzasRepository pizzasRepository;

    @Override
    public List<Pizza> findAll() {
        return pizzasRepository.findAll();
    }

    @Override
    public Pizza findById(Long id) {
        return pizzasRepository.findById(id).get();
    }

    @Override
    public Pizza save(Pizza pizza) {
        return pizzasRepository.save(pizza);
    }

    public void delete(Pizza pizza) {
        pizzasRepository.delete(pizza);
    }
}
