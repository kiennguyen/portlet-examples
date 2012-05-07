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
package org.exoplatform.example.video.controller;

import org.exoplatform.example.video.model.Video;
import org.juzu.Path;
import org.juzu.View;

import javax.inject.Inject;
import javax.portlet.PortletPreferences;

/**
 * @author <a href="kienna@exoplatform.com">Kien Nguyen</a>
 * @version $Revision$
 */
public class VideoApplication
{
   @Inject @Path("player.gtmpl")
   org.exoplatform.example.video.templates.player playerGtmpl;
   
   @Inject
   PortletPreferences preferences;
   
   @View
   public void index()
   {
      String url = preferences.getValue("url", "http://player.vimeo.com/video/6438918");
      String width = preferences.getValue("width", "100%");
      String height = preferences.getValue("height", "100%");
      Video video = new Video(url);
      video.setWidth(width);
      video.setHeight(height);
      
      playerGtmpl.with().video(video).render();
   }
}
