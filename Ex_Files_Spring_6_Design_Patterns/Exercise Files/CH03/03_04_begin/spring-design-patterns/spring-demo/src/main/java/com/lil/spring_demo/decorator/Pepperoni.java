package com.lil.spring_demo.decorator;

import java.math.BigDecimal;

public class Pepperoni extends PizzaIngredient {

    private Pizza pizza;
    public Pepperoni(Pizza pizza){
        super();
        this.pizza = pizza;
    }

    @Override
    public String getDescription() {
        return this.pizza.getDescription() + " + pepperoni";
    }

    @Override
    public BigDecimal getCost() {
        return BigDecimal.valueOf(1.5).add(this.pizza.getCost());
    }
}
