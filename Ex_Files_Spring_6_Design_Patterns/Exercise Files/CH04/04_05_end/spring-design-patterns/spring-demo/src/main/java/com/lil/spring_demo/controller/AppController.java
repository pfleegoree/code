package com.lil.spring_demo.controller;

import com.lil.spring_demo.builder.Contact;
import com.lil.spring_demo.builder.Contact.ContactBuilder;
import com.lil.spring_demo.factory.Pet;
import com.lil.spring_demo.factory.PetFactory;
import com.lil.spring_demo.repository.PresidentEntity;
import com.lil.spring_demo.repository.PresidentRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class AppController {

  private final PetFactory petFactory;
  private final PresidentRepository presidentRepository;
  private final RestTemplate restTemplate;

  public AppController(PetFactory petFactory, PresidentRepository presidentRepository,
      RestTemplate restTemplate) {
    this.petFactory = petFactory;
    this.presidentRepository = presidentRepository;
    this.restTemplate = restTemplate;
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

  @GetMapping("presidents/{id}")
  public PresidentEntity findPresidentById(@PathVariable Long id){
    return this.presidentRepository.findById(id).get();
  }

  @GetMapping("presidentContact/{id}")
  public Contact getPresidentContactById(@PathVariable Long id){
    PresidentEntity president = this.restTemplate.getForEntity("http://localhost:8080/presidents/{id}", PresidentEntity.class, id).getBody();
    return ContactBuilder.getInstance().setFirstName(president.getFirstName()).setLastName(
        president.getLastName()).setEmailAddress(president.getEmailAddress()).build();


  }
}
