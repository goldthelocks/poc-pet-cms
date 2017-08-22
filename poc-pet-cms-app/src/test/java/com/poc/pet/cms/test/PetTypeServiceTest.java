/**
 * 
 */
package com.poc.pet.cms.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.poc.pet.cms.app.Application;
import com.poc.pet.cms.app.model.PetType;
import com.poc.pet.cms.app.service.PetTypeService;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * @author Eraine
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class PetTypeServiceTest {

	@Autowired
	private PetTypeService petTypeService;
	
	@Test
	public void testSave() {
		List<PetType> petTypes = new ArrayList<>();
		
		PetType cat = new PetType();
		cat.setName("cat");
		
		PetType dog = new PetType();
		dog.setName("dog");		
		
		petTypes.add(cat);
		petTypes.add(dog);
		
		for (PetType pt : petTypes) {
			petTypeService.savePetType(pt);
		}
		
	}
}
