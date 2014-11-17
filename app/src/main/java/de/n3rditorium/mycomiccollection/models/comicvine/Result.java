package de.n3rditorium.mycomiccollection.models.comicvine;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

@JsonInclude (JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties (ignoreUnknown = true)
public class Result implements Serializable {

   @JsonProperty ("aliases")
   private Object aliases;
   @JsonProperty ("api_detail_url")
   private String apiDetailUrl;
   @JsonProperty ("count_of_issues")
   private Integer countOfIssues;
   @JsonProperty ("date_added")
   private String dateAdded;
   @JsonProperty ("date_last_updated")
   private String dateLastUpdated;
   @JsonProperty ("deck")
   private Object deck;
   @JsonProperty ("description")
   private String description;
   @JsonProperty ("first_issue")
   private Issue firstIssue;
   @JsonProperty ("id")
   private Integer id;
   @JsonProperty ("image")
   private Image image;
   @JsonProperty ("last_issue")
   private Issue lastIssue;
   @JsonProperty ("name")
   private String name;
   @JsonProperty ("publisher")
   private Publisher publisher;
   @JsonProperty ("site_detail_url")
   private String siteDetailUrl;
   @JsonProperty ("start_year")
   private String startYear;
   @JsonProperty ("resource_type")
   private String resourceType;

   /**
    * @return The aliases
    */
   public Object getAliases() {
      return aliases;
   }

   /**
    * @param aliases The aliases
    */
   public void setAliases(Object aliases) {
      this.aliases = aliases;
   }

   /**
    * @return The apiDetailUrl
    */
   public String getApiDetailUrl() {
      return apiDetailUrl;
   }

   /**
    * @param apiDetailUrl The api_detail_url
    */
   public void setApiDetailUrl(String apiDetailUrl) {
      this.apiDetailUrl = apiDetailUrl;
   }

   /**
    * @return The countOfIssues
    */
   public Integer getCountOfIssues() {
      return countOfIssues;
   }

   /**
    * @param countOfIssues The count_of_issues
    */
   public void setCountOfIssues(Integer countOfIssues) {
      this.countOfIssues = countOfIssues;
   }

   /**
    * @return The dateAdded
    */
   public String getDateAdded() {
      return dateAdded;
   }

   /**
    * @param dateAdded The date_added
    */
   public void setDateAdded(String dateAdded) {
      this.dateAdded = dateAdded;
   }

   /**
    * @return The dateLastUpdated
    */
   public String getDateLastUpdated() {
      return dateLastUpdated;
   }

   /**
    * @param dateLastUpdated The date_last_updated
    */
   public void setDateLastUpdated(String dateLastUpdated) {
      this.dateLastUpdated = dateLastUpdated;
   }

   /**
    * @return The deck
    */
   public Object getDeck() {
      return deck;
   }

   /**
    * @param deck The deck
    */
   public void setDeck(Object deck) {
      this.deck = deck;
   }

   /**
    * @return The description
    */
   public String getDescription() {
      return description;
   }

   /**
    * @param description The description
    */
   public void setDescription(String description) {
      this.description = description;
   }

   /**
    * @return The firstIssue
    */
   public Issue getFirstIssue() {
      return firstIssue;
   }

   /**
    * @param firstIssue The first_issue
    */
   public void setFirstIssue(Issue firstIssue) {
      this.firstIssue = firstIssue;
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
    * @return The image
    */
   @JsonProperty ("image")
   public Image getImage() {
      return image;
   }

   /**
    * @param image The image
    */
   public void setImage(Image image) {
      this.image = image;
   }

   /**
    * @return The lastIssue
    */
   public Issue getLastIssue() {
      return lastIssue;
   }

   /**
    * @param lastIssue The last_issue
    */
   public void setLastIssue(Issue lastIssue) {
      this.lastIssue = lastIssue;
   }

   /**
    * @return The name
    */
   public String getName() {
      return name;
   }

   /**
    * @param name The name
    */
   public void setName(String name) {
      this.name = name;
   }

   /**
    * @return The publisher
    */
   public Publisher getPublisher() {
      return publisher;
   }

   /**
    * @param publisher The publisher
    */
   public void setPublisher(Publisher publisher) {
      this.publisher = publisher;
   }

   /**
    * @return The siteDetailUrl
    */
   public String getSiteDetailUrl() {
      return siteDetailUrl;
   }

   /**
    * @param siteDetailUrl The site_detail_url
    */
   public void setSiteDetailUrl(String siteDetailUrl) {
      this.siteDetailUrl = siteDetailUrl;
   }

   /**
    * @return The startYear
    */
   public String getStartYear() {
      return startYear;
   }

   /**
    * @param startYear The start_year
    */
   public void setStartYear(String startYear) {
      this.startYear = startYear;
   }

   /**
    * @return The resourceType
    */
   public String getResourceType() {
      return resourceType;
   }

   /**
    * @param resourceType The resource_type
    */
   public void setResourceType(String resourceType) {
      this.resourceType = resourceType;
   }
}