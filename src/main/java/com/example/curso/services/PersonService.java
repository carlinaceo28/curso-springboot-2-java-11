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
	
}
