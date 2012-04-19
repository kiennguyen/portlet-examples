/**
 * Copyright (C) 2012 eXo Platform SAS.
 *
 * This is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation; either version 2.1 of
 * the License, or (at your option) any later version.
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this software; if not, write to the Free
 * Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
 * 02110-1301 USA, or see the FSF site: http://www.fsf.org.
 */
package com.minhthuong.pfi.model;

import java.util.Date;

/**
 * Indicate membership between people with a specified group
 * Example: Mr A is "father" membership in group "family"
 * 
 * @author <a href="kienna@exoplatform.com">Kien Nguyen</a>
 * @version $Revision$
 */

public class Membership
{
   private long id;

   private String name;
   
   private String group;
   
   private String people;

   private Date createdDate;

   public Membership()
   {
   }

   public Membership(long id, String name, String group, String people, Date createdDate)
   {
      this.id = id;
      this.name = name;
      this.setGroup(group);
      this.setPeople(people);
      this.createdDate = createdDate;
   }

   public long getId()
   {
      return this.id;
   }

   public void setId(long id)
   {
      this.id = id;
   }

   public String getName()
   {
      return this.name;
   }

   public void setName(String name)
   {
      this.name = name;
   }

   public Date getCreatedDate()
   {
      return this.createdDate;
   }

   public void setCreatedDate(Date createdDate)
   {
      this.createdDate = createdDate;
   }

   public String getGroup()
   {
      return group;
   }

   public void setGroup(String group)
   {
      this.group = group;
   }

   public String getPeople()
   {
      return people;
   }

   public void setPeople(String people)
   {
      this.people = people;
   }
}
