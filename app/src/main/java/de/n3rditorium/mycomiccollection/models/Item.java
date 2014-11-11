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
@JsonPropertyOrder (
      {"kind", "id", "etag", "selfLink", "volumeInfo", "saleInfo", "accessInfo", "searchInfo"})
public class Item implements Serializable {

   @JsonProperty ("kind")
   private String kind;
   @JsonProperty ("id")
   private String id;
   @JsonProperty ("etag")
   private String etag;
   @JsonProperty ("selfLink")
   private String selfLink;
   @JsonProperty ("volumeInfo")
   private VolumeInfo volumeInfo;
   @JsonProperty ("saleInfo")
   private SaleInfo saleInfo;
   @JsonProperty ("accessInfo")
   private AccessInfo accessInfo;
   @JsonProperty ("searchInfo")
   private SearchInfo searchInfo;
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
    * @return The id
    */
   @JsonProperty ("id")
   public String getId() {
      return id;
   }

   /**
    * @param id The id
    */
   @JsonProperty ("id")
   public void setId(String id) {
      this.id = id;
   }

   /**
    * @return The etag
    */
   @JsonProperty ("etag")
   public String getEtag() {
      return etag;
   }

   /**
    * @param etag The etag
    */
   @JsonProperty ("etag")
   public void setEtag(String etag) {
      this.etag = etag;
   }

   /**
    * @return The selfLink
    */
   @JsonProperty ("selfLink")
   public String getSelfLink() {
      return selfLink;
   }

   /**
    * @param selfLink The selfLink
    */
   @JsonProperty ("selfLink")
   public void setSelfLink(String selfLink) {
      this.selfLink = selfLink;
   }

   /**
    * @return The volumeInfo
    */
   @JsonProperty ("volumeInfo")
   public VolumeInfo getVolumeInfo() {
      return volumeInfo;
   }

   /**
    * @param volumeInfo The volumeInfo
    */
   @JsonProperty ("volumeInfo")
   public void setVolumeInfo(VolumeInfo volumeInfo) {
      this.volumeInfo = volumeInfo;
   }

   /**
    * @return The saleInfo
    */
   @JsonProperty ("saleInfo")
   public SaleInfo getSaleInfo() {
      return saleInfo;
   }

   /**
    * @param saleInfo The saleInfo
    */
   @JsonProperty ("saleInfo")
   public void setSaleInfo(SaleInfo saleInfo) {
      this.saleInfo = saleInfo;
   }

   /**
    * @return The accessInfo
    */
   @JsonProperty ("accessInfo")
   public AccessInfo getAccessInfo() {
      return accessInfo;
   }

   /**
    * @param accessInfo The accessInfo
    */
   @JsonProperty ("accessInfo")
   public void setAccessInfo(AccessInfo accessInfo) {
      this.accessInfo = accessInfo;
   }

   /**
    * @return The searchInfo
    */
   @JsonProperty ("searchInfo")
   public SearchInfo getSearchInfo() {
      return searchInfo;
   }

   /**
    * @param searchInfo The searchInfo
    */
   @JsonProperty ("searchInfo")
   public void setSearchInfo(SearchInfo searchInfo) {
      this.searchInfo = searchInfo;
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