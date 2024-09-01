package com.lil.spring_demo.adapter;

public class AppleAdapter implements Apple{
    private final Orange orange;

    public AppleAdapter(Orange orange){
        this.orange = orange;
    }

    @Override
    public void eat() {
        orange.peel();
        orange.eat();

    }

    @Override
    public String getVariety() {
        return this.orange.getVariety();
    }
}
