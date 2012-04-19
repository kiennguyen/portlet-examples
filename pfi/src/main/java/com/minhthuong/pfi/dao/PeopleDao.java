package com.minhthuong.pfi.dao;

import com.minhthuong.pfi.model.People;

import java.util.List;
 
public interface PeopleDao{
 
	void addPeople(People people);
	
	People getPeople(Long id);
	
	void removePeople(Long id);
	
	List<People> findAllPeople();
 
}