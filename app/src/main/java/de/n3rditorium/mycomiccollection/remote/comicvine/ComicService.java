package de.n3rditorium.mycomiccollection.remote.comicvine;

import de.n3rditorium.mycomiccollection.models.comicvine.Response;
import retrofit.http.GET;
import retrofit.http.Path;
import retrofit.http.Query;

/**
 * Created by Kyp on 16.11.14.
 */
public interface ComicService {

   @GET ("/search/")
   Response searchForVolume(@Query ("api_key") String apiKey, @Query ("format") String format,
         @Query ("resources") String resources, @Query ("limit") Integer limit,
         @Query ("query") String query, @Query ("field_list") String fields);

   @GET ("/volume/4050-{volume_id}/")
   Response loadVolumeDetail(@Path ("volume_id") Integer volumeId, @Query ("api_key") String apiKey,
         @Query ("format") String format, @Query ("field_list") String fields);
}
