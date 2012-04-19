package com.minhthuong.pfi.dao;

import com.minhthuong.pfi.model.Group;
import com.minhthuong.pfi.model.Membership;

import com.minhthuong.pfi.model.People;

import java.util.Date;
import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class PeopleDaoImpl extends HibernateDaoSupport implements PeopleDao, GroupDao, MembershipDao
{

   public void addPeople(People people)
   {
      people.setCreatedDate(new Date());
      getHibernateTemplate().save(people);
   }
   
   public People getPeople(Long id)
   {
      return getHibernateTemplate().get(People.class, id);
   }
   
   public void removePeople(Long id)
   {
      People p = getPeople(id);
      if (p != null)
      {
         getHibernateTemplate().delete(p);
      }
   }

   public List<People> findAllPeople()
   {
      return getHibernateTemplate().find("from People");
   }

   public void addMembership(Membership people)
   {
      // TODO Auto-generated method stub
      
   }

   public List<Membership> findAllMembership()
   {
      // TODO Auto-generated method stub
      return null;
   }

   public void addGroup(Group group)
   {
      // TODO Auto-generated method stub
      
   }

   public List<Group> findAllGroup()
   {
      // TODO Auto-generated method stub
      return null;
   }
}