package com.lil.spring_demo.repository;

import org.springframework.data.repository.CrudRepository;

public interface PresidentRepository extends CrudRepository<PresidentEntity, Long> {

  PresidentEntity findByEmailAddress(String emailAddress);

}
