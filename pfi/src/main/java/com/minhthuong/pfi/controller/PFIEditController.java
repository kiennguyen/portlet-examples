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

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.w3c.dom.Element;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.portlet.MimeResponse;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

/**
 * @author <a href="kienna@exoplatform.com">Kien Nguyen</a>
 * @version $Revision$
 */
@Controller
@RequestMapping(value = "EDIT")
public class PFIEditController
{
   private static Logger log = Logger.getLogger("PFIEditController");
   
   protected void doHeaders(RenderRequest request, RenderResponse response)
   {
      log.log(Level.INFO, "doHeaders.START");
      
      Element cssElement = response.createElement("link");
      cssElement.setAttribute("href",
      response.encodeURL("http://twitter.github.com/bootstrap/1.4.0/bootstrap.min.css"));

      Element jsElement = response.createElement("script");
      jsElement.setAttribute("src",
      response.encodeURL((request.getContextPath()
      + "/js/jquery.js")));
      response.addProperty(MimeResponse.MARKUP_HEAD_ELEMENT, jsElement);
      
      jsElement = response.createElement("script");
      jsElement.setAttribute("src",
      response.encodeURL((request.getContextPath()
      + "/js/jquery.dataTables.js")));
      response.addProperty(MimeResponse.MARKUP_HEAD_ELEMENT, jsElement);
   }

   @RequestMapping
   public String show(RenderRequest request, RenderResponse response)
   {
      log.log(Level.INFO, "show.edit.START");
      
      Element cssElement = response.createElement("link");
      cssElement.setAttribute("href",
      response.encodeURL("http://twitter.github.com/bootstrap/1.4.0/bootstrap.min.css"));

      Element jsElement = response.createElement("script");
      jsElement.setAttribute("src",
      response.encodeURL((request.getContextPath()
      + "/js/jquery.js")));
      response.addProperty(MimeResponse.MARKUP_HEAD_ELEMENT, jsElement);
      
      jsElement = response.createElement("script");
      jsElement.setAttribute("src",
      response.encodeURL((request.getContextPath()
      + "/js/jquery.dataTables.js")));
      response.addProperty(MimeResponse.MARKUP_HEAD_ELEMENT, jsElement);
      
      return "edit";
   }
}
