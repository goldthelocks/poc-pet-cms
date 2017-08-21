/**
 * 
 */
package com.poc.pet.cms.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.poc.pet.cms.app.model.Pet;

/**
 * @author Eraine
 *
 */
public interface PetRepository extends JpaRepository<Pet, Long> {

	@Query("select p from Pet p left join p.petDetails pd where pd.name = :name")
	Pet findByName(@Param("name") String name);
	
}
