package br.com.erudio.adapters;

import br.com.erudio.models.Person;
import br.com.erudio.models.Person.MaleOrFemale;
import br.com.erudio.vo.PersonVO;

public abstract class PersonAdapter {
	
	private PersonAdapter() {}
	
	public static PersonVO adaptPersonToPersonVO(Person person, PersonVO personVO) {
		personVO.setAdress(person.getAdress());
		personVO.setId(person.getId());
		personVO.setName(person.getName());
		personVO.setSex( (person.getSex() == 'm') ? MaleOrFemale.MALE : MaleOrFemale.FEMALE);
		
		return personVO;
	}
	
	public static Person adaptPersonVOToPerson(PersonVO personVO, Person person) {
		person.setAdress(personVO.getAdress());
		person.setId(personVO.getId());
		person.setName(personVO.getName());
		person.setSex( (personVO.getSex() == 'm') ? MaleOrFemale.MALE : MaleOrFemale.FEMALE);
		
		return person;
	}
	
}
