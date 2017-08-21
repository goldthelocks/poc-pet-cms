/**
 * 
 */
package com.poc.pet.cms.app.service;

import java.util.List;

import com.poc.pet.cms.app.model.PetType;

/**
 * @author Eraine
 *
 */
public interface PetTypeService {

	List<PetType> findAll();
	
	PetType findById(Long id);
	
	void savePetType(PetType petType);
}
