package com.example.curso.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.curso.entities.Person;
import com.example.curso.services.PersonService;

@RestController
@RequestMapping(value = "/users")
public class PersonResource {
	
	@Autowired
	private PersonService service;
	
	@GetMapping
	public ResponseEntity<List<Person>> findAll(){
		List<Person> list = service.findAll();
		
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Person> findById(@PathVariable Long id){
			Person obj = service.findById(id);
			return ResponseEntity.ok().body(obj);

}
	@PostMapping
	public ResponseEntity<Person> insert(@RequestBody Person obj){
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).body(obj);
	}
	
}

