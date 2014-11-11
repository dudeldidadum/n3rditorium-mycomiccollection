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
@JsonPropertyOrder ({"textSnippet"})
public class SearchInfo {

   @JsonProperty ("textSnippet")
   private String textSnippet;
   @JsonIgnore
   private Map<String, Object> additionalProperties = new HashMap<String, Object>();

   /**
    * @return The textSnippet
    */
   @JsonProperty ("textSnippet")
   public String getTextSnippet() {
      return textSnippet;
   }

   /**
    * @param textSnippet The textSnippet
    */
   @JsonProperty ("textSnippet")
   public void setTextSnippet(String textSnippet) {
      this.textSnippet = textSnippet;
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
