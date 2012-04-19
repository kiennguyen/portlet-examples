package com.minhthuong.pfi.dao;

import com.minhthuong.pfi.model.Membership;

import com.minhthuong.pfi.model.People;

import java.util.List;
 
public interface MembershipDao{
 
	void addMembership(Membership people);
	
	List<Membership> findAllMembership();
 
}