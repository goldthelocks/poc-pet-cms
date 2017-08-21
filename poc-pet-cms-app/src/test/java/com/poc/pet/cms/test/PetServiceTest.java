/**
 * 
 */
package com.poc.pet.cms.test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.poc.pet.cms.app.Application;
import com.poc.pet.cms.app.model.Pet;
import com.poc.pet.cms.app.model.PetType;
import com.poc.pet.cms.app.service.PetService;
import com.poc.pet.cms.app.service.PetTypeService;

/**
 * @author Eraine
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class PetServiceTest {

	@Autowired
	private PetService petService;
	
	@Autowired
	private PetTypeService petTypeService;
	
	@Test
	public void testFindAll() {
		List<Pet> pets = petService.findAll();
	}
	
	public void testSave() {
		Pet pet = petService.findById(3L);
		System.out.println(pet.toString());
		
		PetType petType = petTypeService.findById(2L);
		pet.setPetType(petType);
		
		petService.save(pet);
		
		System.out.println("saved!");
	}
}
