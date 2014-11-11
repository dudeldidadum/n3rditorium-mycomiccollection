package de.n3rditorium.mycomiccollection.models;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.HashMap;
import java.util.Map;

@JsonInclude (JsonInclude.Include.NON_NULL)
@JsonPropertyOrder ({"isAvailable"})
public class Epub {

   @JsonProperty ("isAvailable")
   private Boolean isAvailable;
   @JsonIgnore
   private Map<String, Object> additionalProperties = new HashMap<String, Object>();

   /**
    * @return The isAvailable
    */
   @JsonProperty ("isAvailable")
   public Boolean getIsAvailable() {
      return isAvailable;
   }

   /**
    * @param isAvailable The isAvailable
    */
   @JsonProperty ("isAvailable")
   public void setIsAvailable(Boolean isAvailable) {
      this.isAvailable = isAvailable;
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