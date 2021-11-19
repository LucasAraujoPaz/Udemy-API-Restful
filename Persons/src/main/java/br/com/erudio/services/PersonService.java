package br.com.erudio.services;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.erudio.adapters.PersonAdapter;
import br.com.erudio.exceptions.NoSuchPersonException;
import br.com.erudio.models.Person;
import br.com.erudio.repositories.PersonRepository;
import br.com.erudio.vo.PersonVO;

@Service
public class PersonService {

	@Autowired
	PersonRepository repository;
	
	public PersonService() {}

	public PersonVO createPerson(PersonVO personVO) {
		
		Person entity = PersonAdapter.adaptPersonVOToPerson(personVO, new Person());
		entity = repository.save(entity);
		personVO = PersonAdapter.adaptPersonToPersonVO(entity, personVO);
		
		return personVO;
	}
		
	public PersonVO findPersonById(Long id) {
		
		Person entity = repository.findById(id)
				.orElseThrow( () -> new NoSuchPersonException("Person Not Found.") );
		
		PersonVO personVO = PersonAdapter.adaptPersonToPersonVO(entity, new PersonVO());
		
		return personVO;
	}

	public List<PersonVO> findAllPersons() {
		
		List<Person> allPersons = repository.findAll();
		List<PersonVO> allPersonVOs = new LinkedList<>();
		
		allPersons.forEach( (entity) -> {
			PersonVO newPersonVO = PersonAdapter.adaptPersonToPersonVO(entity, new PersonVO());
			allPersonVOs.add(newPersonVO); 
		});
		
		return allPersonVOs;
	}
	
	public PersonVO updatePerson(PersonVO personVO) {
		
		Person entity = repository.findById(personVO.getId())
				.orElseThrow( () -> new NoSuchPersonException("Person Not Found.") );
		
		entity = PersonAdapter.adaptPersonVOToPerson(personVO, entity);
		entity = repository.save(entity); 
		
		personVO = PersonAdapter.adaptPersonToPersonVO(entity, personVO);
		
		return personVO;
	}

	public void deletePerson(Long id) {
		
		repository.deleteById(id);
		
	}

	
}
