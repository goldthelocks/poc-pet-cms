/**
 * 
 */
package com.poc.pet.cms.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.poc.pet.cms.app.model.PetType;
import com.poc.pet.cms.app.service.PetTypeService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * @author Eraine
 *
 */
@RestController
@Api(value = "PetTypeControllerAPI", produces = MediaType.APPLICATION_JSON_VALUE)
public class PetTypeApiController {

	@Autowired
	private PetTypeService petTypeService;
	
	@GetMapping("/api/pettype/all")
	@ApiOperation("Get all pet types")
	public ResponseEntity<List<PetType>> listAllTypes() {
		List<PetType> petTypeList = petTypeService.findAll();
		
		if (petTypeList.isEmpty()) {
			return new ResponseEntity<List<PetType>>(HttpStatus.NO_CONTENT);
		}
		
		return new ResponseEntity<List<PetType>>(petTypeList, HttpStatus.OK);
	}
	
}
