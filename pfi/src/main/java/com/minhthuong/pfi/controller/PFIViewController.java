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
package com.minhthuong.pfi.controller;

import com.minhthuong.pfi.form.AddPeopleForm;

import com.minhthuong.pfi.model.People;
import com.minhthuong.pfi.service.PeopleService;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.portlet.bind.annotation.ActionMapping;
import org.springframework.web.portlet.bind.annotation.RenderMapping;
import org.w3c.dom.Element;

import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.portlet.ActionResponse;
import javax.portlet.MimeResponse;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

/**
 * @author <a href="kienna@exoplatform.com">Kien Nguyen</a>
 * @version $Revision$
 */
@Controller(value = "pfiController")
@RequestMapping(value = "VIEW")
public class PFIViewController
{
   private static Logger log = Logger.getLogger("PFIViewController");

   @Autowired
   @Qualifier("peopleService")
   private PeopleService peopleService;

   @Autowired
   private Validator peopleValidator;
   
   private void addHeaders(RenderRequest request, RenderResponse response)
   {
      log.log(Level.INFO, "show.edit.START");
      
      Element cssElement = response.createElement("link");
      cssElement.setAttribute("rel", "stylesheet");
      cssElement.setAttribute("type", "text/css");
      //cssElement.setAttribute("href",
      //response.encodeURL("http://twitter.github.com/bootstrap/1.4.0/bootstrap.min.css"));
      cssElement.setAttribute("href", response.encodeURL(request.getContextPath() + "/bootstrap/bootstrap.css"));
      response.addProperty(MimeResponse.MARKUP_HEAD_ELEMENT, cssElement);
      
      cssElement = response.createElement("link");
      cssElement.setAttribute("rel", "stylesheet");
      cssElement.setAttribute("type", "text/css");
      cssElement.setAttribute("href", response.encodeURL((request.getContextPath() + "/css/list.css")));
      response.addProperty(MimeResponse.MARKUP_HEAD_ELEMENT, cssElement);
      
      Element jsElement = response.createElement("script");
      jsElement.setAttribute("src", response.encodeURL((request.getContextPath() + "/js/jquery.js")));
      response.addProperty(MimeResponse.MARKUP_HEAD_ELEMENT, jsElement);
      
      jsElement = response.createElement("script");
      jsElement.setAttribute("src", response.encodeURL((request.getContextPath() + "/js/jquery.dataTables.js")));
      response.addProperty(MimeResponse.MARKUP_HEAD_ELEMENT, jsElement);
      
      jsElement = response.createElement("script");
      jsElement.setAttribute("type", "text/javascript");
      jsElement.setAttribute("src", response.encodeURL((request.getContextPath() + "/js/list.js")));
      response.addProperty(MimeResponse.MARKUP_HEAD_ELEMENT, jsElement);
   }
   
   @RenderMapping
   public String show(RenderRequest request, RenderResponse response)
   {
      log.log(Level.INFO, "show.START");
      addHeaders(request, response);
      return "list_people";
   }

   @RenderMapping(params = "show=add_people")
   public String showPeopleForm(RenderRequest request, RenderResponse response)
   {
      log.log(Level.INFO, "ShowAddPeopleForm.START");
      addHeaders(request, response);
      return "add_people";
   }

   @RenderMapping(params = "show=list_people")
   public String showListPeople(RenderRequest request, RenderResponse response)
   {
      log.log(Level.INFO, "showListPeople.START");
      addHeaders(request, response);
      return "list_people";
   }

   @ActionMapping(params = "action=addPeople")
   public void addPeople(ActionResponse response) throws IOException
   {      
      response.setRenderParameter("show", "add_people");
   }
   
   @ActionMapping(params = "action=removePeople")
   public void removePeople(ActionResponse response, @RequestParam Long id) throws IOException
   {
      log.log(Level.INFO, "removePeople id: " + id);
      peopleService.removePeople(id);
   }

   @ModelAttribute("people_form")
   public AddPeopleForm getPeopleForm()
   {
      log.log(Level.INFO, "getPeopleForm.START");
      AddPeopleForm formBean = new AddPeopleForm();
      return formBean;
   }

   @ModelAttribute("list")
   public List<People> getList()
   {
      log.log(Level.INFO, "getList.START");
      return peopleService.findAllPeople();
   }

   @ActionMapping(params = "action=submitPeople")
   public void submitPeople(AddPeopleForm formBean, BindingResult result, SessionStatus status, ActionResponse response)
   {
      log.log(Level.INFO, "submitPeople.START");
      peopleValidator.validate(formBean, result);
      if (!result.hasErrors())
      {
         try
         {
            People people = new People();
            BeanUtils.copyProperties(people, formBean);
            peopleService.addPeople(people);
         }
         catch (Exception e)
         {
            log.log(Level.SEVERE, "Error during saving people");
         }

         // Prepare parameter to render phase  
         response.setRenderParameter("show", "list_people");
      }
      else
      {
         log.log(Level.INFO, "Error in binding result:" + result.getErrorCount());
         response.setRenderParameter("show", "add_people");
      }
   }
}
