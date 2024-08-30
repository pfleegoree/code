package com.lil.spring_demo.factory;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

@Component
public class PetFactory {

  public Pet createPet(String animalType){
    if (!StringUtils.hasLength(animalType)){
      throw new UnsupportedOperationException("animal type must be specified");
    }
    switch(animalType.toLowerCase()){
      case "dog":
        return new Dog();
      default:
        throw new UnsupportedOperationException("unknown animal type");
    }
  }
}
