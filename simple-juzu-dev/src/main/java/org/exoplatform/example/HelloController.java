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
package org.exoplatform.example;

import org.juzu.Action;
import org.juzu.Path;
import org.juzu.Response;
import org.juzu.View;
import org.juzu.impl.request.Request;
import org.juzu.portlet.JuzuPortlet;

import javax.inject.Inject;
import javax.portlet.PortletMode;

/**
 * @author <a href="kienna@exoplatform.com">Kien Nguyen</a>
 * @version $Revision$
 */
public class HelloController
{
   @Path("index.gtmpl")
   @Inject
   org.exoplatform.example.templates.index index;
   
   @Path("edit.gtmpl")
   @Inject
   org.exoplatform.example.templates.edit edit;
   
   @Inject
   People people;
   
   @View
   public void index()
   {
      if (Request.getCurrent().getContext().getProperty(JuzuPortlet.PORTLET_MODE) == PortletMode.VIEW)
      {
         index.with().location("Ha Noi").temperature("30").render();
      }
      else
      {
         edit.render();
      }
   }
   
   @Action
   public Response submit(People p)
   {
      System.out.println(p.getName());
      people.setName(p.getName());
      return HelloController_.index().setProperty(JuzuPortlet.PORTLET_MODE, PortletMode.VIEW);
   }
}
