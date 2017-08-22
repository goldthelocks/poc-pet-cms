/**
 * 
 */
package com.poc.pet.cms.app.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.poc.pet.cms.app.model.Pet;
import com.poc.pet.cms.app.service.PetService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * @author Eraine
 *
 */
@RestController
@Api(value = "PetControllerAPI", produces = MediaType.APPLICATION_JSON_VALUE)
public class PetAPIController {

	@Autowired
	private PetService petService;

	private final static Logger logger = LoggerFactory.getLogger(PetAPIController.class);

	@GetMapping("/api/pet/all")
	@ApiOperation("Get all pets")
	public ResponseEntity<List<Pet>> listAllPets() {
		List<Pet> petList = petService.findAll();
		if (petList.isEmpty()) {
			return new ResponseEntity<List<Pet>>(HttpStatus.NO_CONTENT);
		}

		for (Pet pet : petList) {
			logger.info(pet.toString());
		}

		return new ResponseEntity<List<Pet>>(petList, HttpStatus.OK);
	}

	@GetMapping("/api/pet/{id}")
	@ApiOperation("Get one pet")
	public ResponseEntity<Pet> findById(@PathVariable("id") Long id) {
		Pet pet = petService.findById(id);

		if (pet == null) {
			return new ResponseEntity<Pet>(HttpStatus.NO_CONTENT);
		}

		return new ResponseEntity<Pet>(pet, HttpStatus.OK);
	}

	@PostMapping("/api/pet/new")
	@ApiOperation("Add new pet")
	public ResponseEntity<CustomApiResponse> newPet(@RequestBody Pet pet) {
		Pet tempPet = petService.findByName(pet.getPetDetails().getName());

		try {
			if (tempPet != null) {
				return new ResponseEntity<CustomApiResponse>(new CustomApiResponse("Pet already exists!"),
						HttpStatus.CONFLICT);
			}

			petService.save(pet);

		} catch (Exception e) {
			return new ResponseEntity<CustomApiResponse>(new CustomApiResponse("Failed to add pet!"),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return new ResponseEntity<CustomApiResponse>(new CustomApiResponse("Successfully added pet!"), HttpStatus.OK);
	}

	@DeleteMapping("/api/pet/delete/{id}")
	@ApiOperation("Delete a pet")
	public ResponseEntity<?> deletePet(@PathVariable("id") Long id) {
		Pet pet = petService.findById(id);

		if (!petService.isPetExisting(pet)) {
			return new ResponseEntity<>("Pet not found", HttpStatus.NO_CONTENT);
		}

		petService.delete(pet);

		return new ResponseEntity<>(HttpStatus.OK);
	}

	@PutMapping("/api/pet/update/{id}")
	@ApiOperation("Update a pet")
	public ResponseEntity<?> updatePet(@PathVariable("id") Long id, @RequestBody Pet pet) {
		Pet petFromRepo = petService.findById(id);

		if (!petService.isPetExisting(petFromRepo)) {
			return new ResponseEntity<>("Pet not found", HttpStatus.NO_CONTENT);
		}

		petService.update(pet);

		return new ResponseEntity<>(HttpStatus.OK);
	}

}
