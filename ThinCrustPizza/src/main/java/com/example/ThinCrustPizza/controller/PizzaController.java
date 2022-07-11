package com.example.ThinCrustPizza.controller;

import com.example.ThinCrustPizza.model.Pizza;
import com.example.ThinCrustPizza.service.PizzasServiceInt;
import com.example.ThinCrustPizza.service.serviceImpl.PizzasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Controller
public class PizzaController {

    @Autowired
    PizzasService pizzasService;

    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public ModelAndView getHome() {
        ModelAndView mv = new ModelAndView("home");
//        List<Pizza> home = pizzasServiceInt.findAll();
        mv.addObject("home");
        return mv;
    }

    @RequestMapping(value = "/pizzas", method = RequestMethod.GET)
    public ModelAndView getPizzas() {
        ModelAndView mv = new ModelAndView("pizzas");
        List<Pizza> pizzas = pizzasService.findAll();
        mv.addObject("pizzas", pizzas);
        return mv;
    }

    @RequestMapping(value = "/pizzas/{id}", method = RequestMethod.GET)
    public ModelAndView getPizzaDetails(@PathVariable("id") Long id) {
        ModelAndView mv = new ModelAndView("pizzaDetails");
        Pizza pizza = pizzasService.findById(id);
        mv.addObject("pizza", pizza);
        return mv;
    }

    @RequestMapping(value = "/newpizza", method = RequestMethod.GET)
    public String getPizzaForm() {
        return "pizzaForm";
    }

    @RequestMapping(value = "/newpizza", method = RequestMethod.POST)
    public String savePizza(@Valid Pizza pizza, BindingResult result, RedirectAttributes attributes) {
        if (result.hasErrors()) {
            attributes.addFlashAttribute("mensagem", "Verifique se os campos obrigatórios foram preenchidos");
            return "redirect:/newpizza";
        }
        pizza.setData(LocalDate.now());
        pizzasService.save(pizza);
        return "redirect:/pizzas";
    }

    @RequestMapping(value = "/pizzas/{id}", method = RequestMethod.DELETE)
    public String delete(@PathVariable (value = "id") Long id) {
        pizzasService.delete(pizzasService.findById(id));
        return "redirect:/pizzas";

    }


    @RequestMapping(value = "/pizza/{id}", method = RequestMethod.PUT)
    public ModelAndView showEditPizzaPage(@PathVariable(value = "id") Long id) {
        ModelAndView editView = new ModelAndView("pizzaUpdateForm");
        Pizza pizza = pizzasService.findById(id);
        editView.addObject("pizza", pizza);

        return editView;
    }

}
