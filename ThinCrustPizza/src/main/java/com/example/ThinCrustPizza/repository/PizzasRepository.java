package com.example.ThinCrustPizza.repository;

import com.example.ThinCrustPizza.model.Pizza;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PizzasRepository extends JpaRepository<Pizza, Long> {

}
