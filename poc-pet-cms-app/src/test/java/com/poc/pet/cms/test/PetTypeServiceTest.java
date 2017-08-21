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
	
	public void testSave() {
		PetType petType = new PetType();
		petType.setName("dog");
		
		petTypeService.savePetType(petType);
	}
}
