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
package org.exoplatform.example.imagegallery;

import org.exoplatform.example.imagegallery.model.Image;
import org.exoplatform.example.imagegallery.model.ImageGallery;
import org.exoplatform.example.imagegallery.model.Setting;
import org.juzu.Action;
import org.juzu.Path;
import org.juzu.Response;
import org.juzu.View;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.portlet.PortletPreferences;

/**
 * @author <a href="kienna@exoplatform.com">Kien Nguyen</a>
 * @version $Revision$
 */
public class ImageGalleryApplication
{
   @Path("gallery.gtmpl")
   @Inject
   org.exoplatform.example.imagegallery.templates.gallery galleryGtmpl;
   
   @Path("setting.gtmpl")
   @Inject
   org.exoplatform.example.imagegallery.templates.setting settingGtmpl;
   
   @Inject
   PortletPreferences preferences;
   
   @View
   public void index()
   {
      //boolean settingView = Boolean.parseBoolean(preferences.getValue("settingView", "false"));
      
      galleryGtmpl.with().gallery(new ImageGallery(getImages(null))).render();
   }
   
   @View
   public void setting()
   {
      settingGtmpl.render();
   }
   
   @Action
   public Response viewSettingAction()
   {
      return ImageGalleryApplication_.setting();
   }
   
   @Action
   public Response saveSetting(Setting setting)
   {
      System.out.println("Image path: " + setting.getPath());
      return ImageGalleryApplication_.index();
   }
   
   private List<Image> getImages(String folder)
   {
      List<Image> filenames = new ArrayList<Image>();
      filenames.add(new Image("http://localhost:8080/image-gallery/img/1.jpg"));
      filenames.add(new Image("http://localhost:8080/image-gallery/img/2.jpg"));
      filenames.add(new Image("http://localhost:8080/image-gallery/img/3.jpg"));
      filenames.add(new Image("http://localhost:8080/image-gallery/img/4.jpg"));
      filenames.add(new Image("http://localhost:8080/image-gallery/img/5.jpg"));
      return filenames;
   }
}
