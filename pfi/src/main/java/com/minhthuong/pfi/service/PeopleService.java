package com.minhthuong.pfi.service;

import com.minhthuong.pfi.model.People;

import java.util.List;
 
public interface PeopleService{
 
	void addPeople(People people);
	
	People getPeople(Long id);
	
	void removePeople(Long id);
	
	List<People> findAllPeople();
 
}