/**
 * 
 */
package com.poc.pet.cms.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poc.pet.cms.app.model.PetType;
import com.poc.pet.cms.app.repository.PetTypeRepository;

/**
 * @author Eraine
 *
 */
@Service
public class PetTypeServiceImpl implements PetTypeService {

	@Autowired
	private PetTypeRepository petTypeRepository;

	@Override
	public List<PetType> findAll() {
		return petTypeRepository.findAll();
	}

	@Override
	public void savePetType(PetType petType) {
		petTypeRepository.save(petType);
	}

	@Override
	public PetType findById(Long id) {
		return petTypeRepository.findOne(id);
	}

}
