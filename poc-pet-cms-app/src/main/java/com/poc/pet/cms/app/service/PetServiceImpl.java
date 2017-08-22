/**
 * 
 */
package com.poc.pet.cms.app.service;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poc.pet.cms.app.model.Pet;
import com.poc.pet.cms.app.repository.PetRepository;

/**
 * @author Eraine
 *
 */
@Service
@Transactional(rollbackOn = Exception.class)
public class PetServiceImpl implements PetService {

	private final static Logger logger = LoggerFactory.getLogger(PetServiceImpl.class);
	
	@Autowired
	private PetRepository petRepository;

	@Override
	public void save(Pet pet) {
		pet.setStatus("active");
		pet.setDateAdded(new Date());
		logger.info(".....PET: " + pet.toString());
		petRepository.save(pet);
	}

	@Override
	public void update(Pet pet) {
		save(pet);
	}

	@Override
	public void delete(Pet pet) {
		Pet localPet = findById(pet.getId());
		localPet.setStatus("deleted");
	}

	@Override
	public Pet findById(Long id) {
		return petRepository.findOne(id);
	}

	@Override
	public List<Pet> findAll() {
		return petRepository.findAll();
	}

	@Override
	public boolean isPetExisting(Pet pet) {
		if (pet != null) {
			Pet petFromRepo = findById(pet.getId());

			if (petFromRepo != null) {
				return true;
			}
		}

		return false;
	}

	@Override
	public Pet findByName(String name) {
		return petRepository.findByName(name);
	}

}
