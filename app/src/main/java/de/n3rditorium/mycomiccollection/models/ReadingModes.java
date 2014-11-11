package de.n3rditorium.mycomiccollection.models;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

@JsonInclude (JsonInclude.Include.NON_NULL)
@JsonPropertyOrder ({"text", "image"})
public class ReadingModes implements Serializable {

   @JsonProperty ("text")
   private Boolean text;
   @JsonProperty ("image")
   private Boolean image;
   @JsonIgnore
   private Map<String, Object> additionalProperties = new HashMap<String, Object>();

   /**
    * @return The text
    */
   @JsonProperty ("text")
   public Boolean getText() {
      return text;
   }

   /**
    * @param text The text
    */
   @JsonProperty ("text")
   public void setText(Boolean text) {
      this.text = text;
   }

   /**
    * @return The image
    */
   @JsonProperty ("image")
   public Boolean getImage() {
      return image;
   }

   /**
    * @param image The image
    */
   @JsonProperty ("image")
   public void setImage(Boolean image) {
      this.image = image;
   }

   @JsonAnyGetter
   public Map<String, Object> getAdditionalProperties() {
      return this.additionalProperties;
   }

   @JsonAnySetter
   public void setAdditionalProperty(String name, Object value) {
      this.additionalProperties.put(name, value);
   }
}