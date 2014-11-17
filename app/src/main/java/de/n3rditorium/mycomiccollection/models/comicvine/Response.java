package de.n3rditorium.mycomiccollection.models.comicvine;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import de.n3rditorium.mycomiccollection.core.ContentPresenter;

@JsonInclude (JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties (ignoreUnknown = true)
public class Response implements Serializable, ContentPresenter.Content {

   @JsonProperty ("error")
   private String error;
   @JsonProperty ("limit")
   private Integer limit;
   @JsonProperty ("offset")
   private Integer offset;
   @JsonProperty ("number_of_page_results")
   private Integer numberOfPageResults;
   @JsonProperty ("number_of_total_results")
   private Integer numberOfTotalResults;
   @JsonProperty ("status_code")
   private Integer statusCode;
   @JsonProperty ("results")
   private List<Result> results = new ArrayList<Result>();
   @JsonProperty ("version")
   private String version;

   /**
    * @return The error
    */
   public String getError() {
      return error;
   }

   /**
    * @param error The error
    */
   public void setError(String error) {
      this.error = error;
   }

   /**
    * @return The limit
    */
   public Integer getLimit() {
      return limit;
   }

   /**
    * @param limit The limit
    */
   public void setLimit(Integer limit) {
      this.limit = limit;
   }

   /**
    * @return The offset
    */
   public Integer getOffset() {
      return offset;
   }

   /**
    * @param offset The offset
    */
   public void setOffset(Integer offset) {
      this.offset = offset;
   }

   /**
    * @return The numberOfPageResults
    */
   public Integer getNumberOfPageResults() {
      return numberOfPageResults;
   }

   /**
    * @param numberOfPageResults The number_of_page_results
    */
   public void setNumberOfPageResults(Integer numberOfPageResults) {
      this.numberOfPageResults = numberOfPageResults;
   }

   /**
    * @return The numberOfTotalResults
    */
   public Integer getNumberOfTotalResults() {
      return numberOfTotalResults;
   }

   /**
    * @param numberOfTotalResults The number_of_total_results
    */
   @JsonProperty ("number_of_total_results")
   public void setNumberOfTotalResults(Integer numberOfTotalResults) {
      this.numberOfTotalResults = numberOfTotalResults;
   }

   /**
    * @return The statusCode
    */
   public Integer getStatusCode() {
      return statusCode;
   }

   /**
    * @param statusCode The status_code
    */
   public void setStatusCode(Integer statusCode) {
      this.statusCode = statusCode;
   }

   /**
    * @return The results
    */
   public List<Result> getResults() {
      return results;
   }

   /**
    * @param results The results
    */
   public void setResults(List<Result> results) {
      this.results = results;
   }

   /**
    * @return The version
    */
   public String getVersion() {
      return version;
   }

   /**
    * @param version The version
    */
   public void setVersion(String version) {
      this.version = version;
   }
}