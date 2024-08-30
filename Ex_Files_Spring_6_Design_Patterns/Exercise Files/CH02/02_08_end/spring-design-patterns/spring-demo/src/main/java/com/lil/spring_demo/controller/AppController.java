package com.lil.spring_demo.controller;

import com.lil.spring_demo.builder.Contact;
import com.lil.spring_demo.builder.Contact.ContactBuilder;
import com.lil.spring_demo.factory.Pet;
import com.lil.spring_demo.factory.PetFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppController {

  private final PetFactory petFactory;

  public AppController(PetFactory petFactory) {
    this.petFactory = petFactory;
  }

  @PostMapping("adoptPet/{type}/{name}")
  public Pet adoptPet(@PathVariable String type, @PathVariable String name){
    Pet pet = this.petFactory.createPet(type);
    pet.setName(name);
    pet.feed();
    return pet;
  }

  @PostMapping("contact")
  public Contact createContact(@RequestParam(required = false)String firstName,
      @RequestParam(required = false) String lastName,
      @RequestParam(required = false) String emailAddress){
    return ContactBuilder.getInstance().setFirstName(firstName).setLastName(lastName)
        .setEmailAddress(emailAddress).build();
  }
}
