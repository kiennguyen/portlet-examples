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
package com.minhthuong.pfi.validator;

import com.minhthuong.pfi.form.AddPeopleForm;

import com.minhthuong.pfi.model.People;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import java.util.logging.Logger;

/**
 * @author <a href="kienna@exoplatform.com">Kien Nguyen</a>
 * @version $Revision$
 */

public class PeopleValidator implements Validator
{
   private static Logger log = Logger.getLogger("PeopleValidator");
   
   /**
    * @see org.springframework.validation.Validator#supports(java.lang.Class)
    */
   public boolean supports(Class<?> clazz)
   {
      return People.class.isAssignableFrom(clazz);
   }

   /**
    * @see org.springframework.validation.Validator#validate(java.lang.Object, org.springframework.validation.Errors)
    */
   public void validate(Object target, Errors errors)
   {
      log.info("validator object");
      AddPeopleForm form = (AddPeopleForm) target;
      ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "NotEmpty.people.name");
      ValidationUtils.rejectIfEmptyOrWhitespace(errors, "address", "NotEmpty.people.address");
      String name = form.getName();
      if(name.length() > 100 || name.length() < 10) {
         errors.rejectValue("name", "fieldLength");
      }
   }

}
