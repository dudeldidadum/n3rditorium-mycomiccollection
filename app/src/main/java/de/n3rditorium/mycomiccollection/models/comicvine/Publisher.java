package de.n3rditorium.mycomiccollection.models.comicvine;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

@JsonInclude (JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties (ignoreUnknown = true)
public class Publisher implements Serializable {

   @JsonProperty ("api_detail_url")
   private String apiDetailUrl;
   @JsonProperty ("id")
   private Integer id;
   @JsonProperty ("name")
   private String name;
   @JsonIgnore
   private Map<String, Object> additionalProperties = new HashMap<String, Object>();

   /**
    * @return The apiDetailUrl
    */
   @JsonProperty ("api_detail_url")
   public String getApiDetailUrl() {
      return apiDetailUrl;
   }

   /**
    * @param apiDetailUrl The api_detail_url
    */
   @JsonProperty ("api_detail_url")
   public void setApiDetailUrl(String apiDetailUrl) {
      this.apiDetailUrl = apiDetailUrl;
   }

   /**
    * @return The id
    */
   @JsonProperty ("id")
   public Integer getId() {
      return id;
   }

   /**
    * @param id The id
    */
   @JsonProperty ("id")
   public void setId(Integer id) {
      this.id = id;
   }

   /**
    * @return The name
    */
   @JsonProperty ("name")
   public String getName() {
      return name;
   }

   /**
    * @param name The name
    */
   @JsonProperty ("name")
   public void setName(String name) {
      this.name = name;
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