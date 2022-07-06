package com.example.curso.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.curso.entities.Person;


public interface PersonRepository extends JpaRepository<Person, Long> {

}
