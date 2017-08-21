/**
 * 
 */
package com.poc.pet.cms.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author Eraine
 *
 */
@Controller
public class PetController {

	@GetMapping(value = {"/"})
	public ModelAndView homePage() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("title", "Pet Listing");
		mav.setViewName("index");
		return mav;
	}
}
