package de.n3rditorium.mycomiccollection.content.volume;

import java.io.Serializable;

import de.n3rditorium.mycomiccollection.models.comicvine.Image;

public class VolumePresenterModel implements Serializable {

   private Integer id;
   private String name;
   private Image imageLinks;

   public VolumePresenterModel() {
      // nothing to do here at the moment
   }

   public Integer getId() {
      return id;
   }

   public void setId(Integer id) {
      this.id = id;
   }

   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }

   public Image getImageLinks() {
      return imageLinks;
   }

   public void setImageLinks(Image imageLinks) {
      this.imageLinks = imageLinks;
   }

   public static VolumePresenterModel buildPresenterModel(Integer id, String name,
         Image imageLinks) {
      VolumePresenterModel model = new VolumePresenterModel();
      model.setId(id);
      model.setName(name);
      model.setImageLinks(imageLinks);

      return model;
   }
}
