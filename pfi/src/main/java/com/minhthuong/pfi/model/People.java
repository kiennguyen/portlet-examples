package com.minhthuong.pfi.model;

import java.util.Date;

public class People implements java.io.Serializable
{

   private long id;

   private String name;

   private String address;

   private Date createdDate;

   public People()
   {
   }

   public People(long id, String name, String address, Date createdDate)
   {
      this.id = id;
      this.name = name;
      this.address = address;
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

   public String getAddress()
   {
      return this.address;
   }

   public void setAddress(String address)
   {
      this.address = address;
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
