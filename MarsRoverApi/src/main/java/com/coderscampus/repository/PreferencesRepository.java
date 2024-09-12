package com.coderscampus.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.coderscampus.dto.HomeDto;

public interface PreferencesRepository extends JpaRepository<HomeDto, Long>{

//  @Query(value="select * from mars_api_preferences where user_id = :userId", nativeQuery=true)
	HomeDto findByUserId(Long userId);

}
