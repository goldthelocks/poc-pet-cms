/**
 * 
 */
package com.poc.pet.cms.app.service;

import java.util.List;

import com.poc.pet.cms.app.model.Pet;

/**
 * @author Eraine
 *
 */
public interface PetService {

	void save(Pet pet);
	
	void update(Pet pet);
	
	void delete(Pet pet);
	
	Pet findById(Long id);
	
	Pet findByName(String name);
	
	List<Pet> findAll();
	
	boolean isPetExisting(Pet pet);
}
