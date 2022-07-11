package com.example.ThinCrustPizza.controller;

import com.example.ThinCrustPizza.model.Pizza;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

public class PedidoController {

    @Autowired
    PizzaController pizzaController;

    @RequestMapping(value = "/pedido", method = RequestMethod.POST)
    public ModelAndView fazerPedido(@PathVariable("id")Long id) {
        ModelAndView mv = new ModelAndView("pedido");
        mv.addObject("pedido");
        return mv;
    }
}
