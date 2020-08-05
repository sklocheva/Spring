package com.tacos.tacocloud.controller;

import com.tacos.tacocloud.model.Ingredient;
import com.tacos.tacocloud.model.Ingredient.Type;
import com.tacos.tacocloud.model.Order;
import com.tacos.tacocloud.model.Taco;
import com.tacos.tacocloud.repository.IngredientRepository;
import com.tacos.tacocloud.repository.TacoRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Sophia Klocheva
 * on 7/13/2020
 */
@Slf4j
@Controller
@RequestMapping("/design")
@SessionAttributes("order")
/* order attribute is kept in session and available across
multiple requests */
public class DesignTacoController
{
    private final IngredientRepository ingredientRepository;
    private final TacoRepository tacoRepository;

    @Autowired
    public DesignTacoController(IngredientRepository ingredientRepository,
                                TacoRepository tacoRepository)
    {
        this.ingredientRepository = ingredientRepository;
        this.tacoRepository = tacoRepository;
    }

    @ModelAttribute(name = "order")
    public Order order()
    {
        return new Order();
    }

    @ModelAttribute(name = "taco")
    public Taco taco()
    {
        return new Taco();
    }

    @GetMapping
    public String showDesignForm(Model model)
    {
//        List<Ingredient> ingredients = Arrays.asList(
//                new Ingredient("FLTO", "Flour Tortilla", Type.WRAP),
//                new Ingredient("COTO", "Corn Tortilla", Type.WRAP),
//                new Ingredient("GRBF", "Ground Beef", Type.PROTEIN),
//                new Ingredient("CARN", "Carnitas", Type.PROTEIN),
//                new Ingredient("TMTO", "Diced Tomatoes", Type.VEGGIES),
//                new Ingredient("LETC", "Lettuce", Type.VEGGIES),
//                new Ingredient("CHED", "Cheddar", Type.CHEESE),
//                new Ingredient("JACK", "Monterrey Jack", Type.CHEESE),
//                new Ingredient("SLSA", "Salsa", Type.SAUCE),
//                new Ingredient("SRCR", "Sour Cream", Type.SAUCE)
//        );
        List<Ingredient> ingredients = new ArrayList<>();
        ingredientRepository.findAll().forEach(i -> ingredients.add(i));

        Type[] types = Ingredient.Type.values();
        for (Ingredient.Type type : types)
        {
            model.addAttribute(type.toString().toLowerCase(),
                    filterByType(ingredients, type));
        }
        model.addAttribute("design", new Taco());
        return "design";
    }

    @PostMapping
    public String processDesign(@Valid @ModelAttribute("taco") Taco taco, Errors error,
                                @ModelAttribute Order order)
    {
        if (error.hasErrors())
        {
            log.warn(error.getAllErrors().toString());
            return "design";
        }

        Taco savedTaco = tacoRepository.saveTaco(taco);
        List<Taco> tacos = new ArrayList<>();
        tacos.add(savedTaco);
        order.setTacos(tacos);

        log.info("Processing design: " + taco);
        log.info("Processing order: " + order);
        return "redirect:/orders/current";
    }

    private List<Ingredient> filterByType(List<Ingredient> ingredients, Type type)
    {
        return ingredients.stream()
                .filter(x -> x.getType().equals(type))
                .collect(Collectors.toList());
    }

}
