package org.exoplatform.example;

import org.juzu.Param;
import org.juzu.SessionScoped;

import javax.inject.Named;

@Param
@Named("people")
@SessionScoped
public class People
{
   private String name;

   public String getName()
   {
      return name;
   }

   public void setName(String name)
   {
      this.name = name;
   }
}
