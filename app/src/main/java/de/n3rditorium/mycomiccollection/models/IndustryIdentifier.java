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
@JsonPropertyOrder ({"type", "identifier"})
public class IndustryIdentifier implements Serializable {

   @JsonProperty ("type")
   private String type;
   @JsonProperty ("identifier")
   private String identifier;
   @JsonIgnore
   private Map<String, Object> additionalProperties = new HashMap<String, Object>();

   /**
    * @return The type
    */
   @JsonProperty ("type")
   public String getType() {
      return type;
   }

   /**
    * @param type The type
    */
   @JsonProperty ("type")
   public void setType(String type) {
      this.type = type;
   }

   /**
    * @return The identifier
    */
   @JsonProperty ("identifier")
   public String getIdentifier() {
      return identifier;
   }

   /**
    * @param identifier The identifier
    */
   @JsonProperty ("identifier")
   public void setIdentifier(String identifier) {
      this.identifier = identifier;
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