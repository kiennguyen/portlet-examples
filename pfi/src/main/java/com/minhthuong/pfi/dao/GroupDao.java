package com.minhthuong.pfi.dao;

import com.minhthuong.pfi.model.Group;

import com.minhthuong.pfi.model.People;

import java.util.List;
 
public interface GroupDao{
 
	void addGroup(Group group);
	
	List<Group> findAllGroup();
 
}