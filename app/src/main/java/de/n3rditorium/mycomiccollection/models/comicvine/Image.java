package de.n3rditorium.mycomiccollection.models.comicvine;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

@JsonInclude (JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties (ignoreUnknown = true)
public class Image implements Serializable {

   @JsonProperty ("icon_url")
   private String iconUrl;
   @JsonProperty ("medium_url")
   private String mediumUrl;
   @JsonProperty ("screen_url")
   private String screenUrl;
   @JsonProperty ("small_url")
   private String smallUrl;
   @JsonProperty ("super_url")
   private String superUrl;
   @JsonProperty ("thumb_url")
   private String thumbUrl;
   @JsonProperty ("tiny_url")
   private String tinyUrl;

   /**
    * @return The iconUrl
    */
   public String getIconUrl() {
      return iconUrl;
   }

   /**
    * @param iconUrl The icon_url
    */
   public void setIconUrl(String iconUrl) {
      this.iconUrl = iconUrl;
   }

   /**
    * @return The mediumUrl
    */
   public String getMediumUrl() {
      return mediumUrl;
   }

   /**
    * @param mediumUrl The medium_url
    */
   public void setMediumUrl(String mediumUrl) {
      this.mediumUrl = mediumUrl;
   }

   /**
    * @return The screenUrl
    */
   public String getScreenUrl() {
      return screenUrl;
   }

   /**
    * @param screenUrl The screen_url
    */
   public void setScreenUrl(String screenUrl) {
      this.screenUrl = screenUrl;
   }

   /**
    * @return The smallUrl
    */
   public String getSmallUrl() {
      return smallUrl;
   }

   /**
    * @param smallUrl The small_url
    */
   public void setSmallUrl(String smallUrl) {
      this.smallUrl = smallUrl;
   }

   /**
    * @return The superUrl
    */
   public String getSuperUrl() {
      return superUrl;
   }

   /**
    * @param superUrl The super_url
    */
   public void setSuperUrl(String superUrl) {
      this.superUrl = superUrl;
   }

   /**
    * @return The thumbUrl
    */
   public String getThumbUrl() {
      return thumbUrl;
   }

   /**
    * @param thumbUrl The thumb_url
    */
   public void setThumbUrl(String thumbUrl) {
      this.thumbUrl = thumbUrl;
   }

   /**
    * @return The tinyUrl
    */
   public String getTinyUrl() {
      return tinyUrl;
   }

   /**
    * @param tinyUrl The tiny_url
    */
   public void setTinyUrl(String tinyUrl) {
      this.tinyUrl = tinyUrl;
   }
}