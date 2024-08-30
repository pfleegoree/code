package com.lil.spring_demo.factory;

import org.springframework.util.StringUtils;
import org.springframework.stereotype.Component;


@Component
public class PetFactory {
    public Pet createPet(String animalType){
        if (!StringUtils.hasLength(animalType)){
           throw new UnsupportedOperationException("Animal type must have type");
        }
        switch(animalType.toLowerCase()){
            case "dog":
                return new Dog();
            default:
                throw new UnsupportedOperationException("unknown animal type");
        }
    }

}
