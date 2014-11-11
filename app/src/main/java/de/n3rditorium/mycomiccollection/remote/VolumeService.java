package de.n3rditorium.mycomiccollection.remote;

import de.n3rditorium.mycomiccollection.models.SearchResults;
import retrofit.http.GET;
import retrofit.http.Query;

/**
 * Created by Kyp on 11.11.14.
 */
public interface VolumeService {

   @GET ("/volumes")
   SearchResults searchFor(@Query ("q") String isbn);
}
