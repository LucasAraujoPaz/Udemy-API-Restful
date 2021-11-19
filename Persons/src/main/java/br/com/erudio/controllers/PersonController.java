package br.com.erudio.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.erudio.services.PersonService;
import br.com.erudio.vo.PersonVO;

@RestController
@RequestMapping("/person")
public class PersonController {

	@Autowired
	private PersonService personService;
	
	@PostMapping
	public PersonVO createPerson(@RequestBody PersonVO person) {
		
		return personService.createPerson(person);
		
	}
	
	@GetMapping("/{id}")
	public PersonVO findPersonById(@PathVariable("id") Long id) {
		
		return personService.findPersonById(id);
		
	}

	@GetMapping
	public List<PersonVO> findAllPersons() {
		
		return personService.findAllPersons();
		
	}
	
	@PutMapping
	public PersonVO updatePerson(@RequestBody PersonVO person) {
		
		return personService.updatePerson(person);
		
	}
	

	@DeleteMapping("/{id}")
	public void deletePerson(@PathVariable Long id) {
		
		personService.deletePerson(id);
		
	}
	
}
