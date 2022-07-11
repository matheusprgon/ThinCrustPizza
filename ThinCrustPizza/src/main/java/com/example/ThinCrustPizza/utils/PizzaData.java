package com.example.ThinCrustPizza.utils;

import com.example.ThinCrustPizza.model.Pizza;
import com.example.ThinCrustPizza.repository.PizzasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
public class PizzaData {

    @Autowired
    PizzasRepository pizzasRepository;

//    @PostConstruct
    public void savePizzas() {
        List<Pizza> pizzaList = new ArrayList<>();
        Pizza pizza1 = new Pizza();
        pizza1.setSabor("Calabresa");
        pizza1.setTamanho("Família");
        pizza1.setIngredientes("Molho de Tomate, Queijo Mussarela, Calabresa Fatiada");
//        pizza1.setValor(45.0);
        pizza1.setData(LocalDate.now());

        Pizza pizza2 = new Pizza();
        pizza2.setSabor("Quatro queijos");
        pizza2.setTamanho("Grande");
        pizza2.setIngredientes("Molho de Tomate, Queijo Mussarela, Queijo Provolone, Queijo Gorgonzola, Queijo Parmesão");
//        pizza2.setValor(30.0);
        pizza2.setData(LocalDate.now());

        Pizza pizza3 = new Pizza();
        pizza3.setSabor("Peperoni");
        pizza3.setTamanho("Média");
        pizza3.setIngredientes("Molho de Tomate, Queijo Mussarela, Peperoni Fatiado");
//        pizza3.setValor(25.0);
        pizza3.setData(LocalDate.now());

        pizzaList.add(pizza1);
        pizzaList.add(pizza2);
        pizzaList.add(pizza3);

        for (Pizza pizza : pizzaList) {
            Pizza pizzaSaved = pizzasRepository.save(pizza);
            System.out.println(pizzaSaved.getId());
        }
    }
}
