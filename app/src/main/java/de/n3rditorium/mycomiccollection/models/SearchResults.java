package de.n3rditorium.mycomiccollection.models;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@JsonInclude (JsonInclude.Include.NON_NULL)
@JsonPropertyOrder ({"kind", "totalItems", "items"})
public class SearchResults {

   @JsonProperty ("kind")
   private String kind;
   @JsonProperty ("totalItems")
   private Integer totalItems;
   @JsonProperty ("items")
   private List<Item> items = new ArrayList<Item>();
   @JsonIgnore
   private Map<String, Object> additionalProperties = new HashMap<String, Object>();

   /**
    * @return The kind
    */
   @JsonProperty ("kind")
   public String getKind() {
      return kind;
   }

   /**
    * @param kind The kind
    */
   @JsonProperty ("kind")
   public void setKind(String kind) {
      this.kind = kind;
   }

   /**
    * @return The totalItems
    */
   @JsonProperty ("totalItems")
   public Integer getTotalItems() {
      return totalItems;
   }

   /**
    * @param totalItems The totalItems
    */
   @JsonProperty ("totalItems")
   public void setTotalItems(Integer totalItems) {
      this.totalItems = totalItems;
   }

   /**
    * @return The items
    */
   @JsonProperty ("items")
   public List<Item> getItems() {
      return items;
   }

   /**
    * @param items The items
    */
   @JsonProperty ("items")
   public void setItems(List<Item> items) {
      this.items = items;
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