@Application(defaultController = org.exoplatform.example.imagegallery.ImageGalleryApplication.class)
@Assets(
   scripts = {
      @Script(id = "jquery", src = "/js/jquery.js"),
      @Script(src = "/js/bootstrap-carousel.js"),
      @Script(src = "/js/gallery.js")
   },
   stylesheets = {
      @Stylesheet(src = "/css/bootstrap.css"),
      @Stylesheet(src = "/css/gallery.css")
   }
)
package org.exoplatform.example.imagegallery;

import org.juzu.Application;
import org.juzu.plugin.asset.Assets;
import org.juzu.plugin.asset.Script;
import org.juzu.plugin.asset.Stylesheet;