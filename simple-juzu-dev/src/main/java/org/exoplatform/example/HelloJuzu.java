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

import org.juzu.Path;
import org.juzu.View;
import org.juzu.template.Template;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

/**
 * @author <a href="kienna@exoplatform.com">Kien Nguyen</a>
 * @version $Revision$
 */
public class HelloJuzu
{
   @Path("index.gtmpl")
   @Inject
   Template index;
   
   @View
   public void index()
   {
      Map<String, Object> parameters = new HashMap<String, Object>();
      parameters.put("city", "Ha Noi");
      parameters.put("state", "Dong da");
      index.render();
   }
}
