package com.example.curso.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.curso.entities.Person;
import com.example.curso.repositories.PersonRepository;

@Service
public class PersonService {

	@Autowired
	private PersonRepository repository;

	public List<Person> findAll() {
		return repository.findAll();
	}

	public Person findById(Long id) {
	Optional<Person> obj = repository.findById(id);
	return obj.get();
	}

	public Person insert(Person obj) {
		return repository.save(obj);
	}
	
	public void delete(Long id) {
		repository.deleteById(id);
	}
	
	public Person update(Long id,Person obj) {
		Person entity = repository.getOne(id);
		updateData(entity,obj);
		return repository.save(entity);
	}

	private void updateData(Person entity, Person obj) {
		entity.setName(obj.getName());
		entity.setEmail(obj.getEmail());
		entity.setPhone(obj.getPhone());
		
	}
	
}
