package com.lil.spring_demo.factory;

public class Dog implements Pet{

    private String name;
    private boolean hungry;

    public Dog(){
        hungry = true;
    }

    @Override
    public void setName(String name) {
        this.name = name;

    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public boolean isHungry() {
        return hungry;
    }

    @Override
    public void feed() {
        hungry = false;

    }

    @Override
    public String getType() {
        return "DOG";
    }
}
