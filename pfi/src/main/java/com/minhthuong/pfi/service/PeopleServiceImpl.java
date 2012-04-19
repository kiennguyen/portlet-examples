package com.minhthuong.pfi.service;

import org.springframework.stereotype.Service;

import com.minhthuong.pfi.dao.PeopleDao;
import com.minhthuong.pfi.model.People;

import java.util.List;

@Service("peopleService")
public class PeopleServiceImpl implements PeopleService
{

   PeopleDao peopleDao;

   public void setPeopleDao(PeopleDao peopleDao)
   {
      this.peopleDao = peopleDao;
   }

   public void addPeople(People people)
   {
      peopleDao.addPeople(people);
   }
   
   public People getPeople(Long id)
   {
      return peopleDao.getPeople(id);
   }
   
   public void removePeople(Long id)
   {
      peopleDao.removePeople(id);
   }

   public List<People> findAllPeople()
   {
      return peopleDao.findAllPeople();
   }

}