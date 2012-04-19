package com.minhthuong.pfi.model;

import java.util.Date;

public class Group implements java.io.Serializable
{

   private long id;

   private String name;

   private String description;

   private Date createdDate;

   public Group()
   {
   }

   public Group(long id, String name, String description, Date createdDate)
   {
      this.id = id;
      this.name = name;
      this.description = description;
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

   public String getDescription()
   {
      return this.description;
   }

   public void setDescription(String description)
   {
      this.description = description;
   }

   public Date getCreatedDate()
   {
      return this.createdDate;
   }

   public void setCreatedDate(Date createdDate)
   {
      this.createdDate = createdDate;
   }

}
