package de.n3rditorium.mycomiccollection.remote.comicvine;

import android.content.Context;
import android.os.AsyncTask;
import android.text.TextUtils;
import android.util.Log;

import de.n3rditorium.mycomiccollection.models.comicvine.Response;
import de.n3rditorium.mycomiccollection.remote.JacksonConverter;
import retrofit.RestAdapter;
import retrofit.RetrofitError;

/**
 * Created by Kyp on 16.11.14.
 */
public class ComicVine {

   private static interface Properties {
      static final String BASE_URL = "http://www.comicvine.com/api";
      static final String API_KEY = "0da7fb3d7c0b47e8e64a85ae746c99ae8bb6e5e8";
      static final String JSON = "json";
   }

   private static interface Resources {
      static final String VOLUMES = "volumes";
   }

   private static interface FieldList {
      static final String VOLUMES =
            "api_detail_url,start_year,count_of_issues,id,image,name,publisher";
      static final String VOLUME_DETAIL =
            "count_of_issues,id,image,issues,name,publisher,start_year";
   }

   public static interface Callback {

      public void onSuccess(Response response);

      public void onFailure();
   }

   private static ComicVine instance;

   private Context context;

   private ComicService comicService;

   public static ComicVine getInstance(Context context) {
      if (instance == null) {
         instance = new ComicVine(context);
      }
      return instance;
   }

   private boolean loading = false;

   private ComicVine(Context context) {
      this.context = context.getApplicationContext();

      RestAdapter restAdapter = new RestAdapter.Builder().setEndpoint(Properties.BASE_URL)
            .setConverter(new JacksonConverter()).build();
      restAdapter.setLogLevel(RestAdapter.LogLevel.FULL);
      comicService = restAdapter.create(ComicService.class);
   }

   public void searchVolume(final String query, final Callback callback) {
      if (loading) {
         return;
      }
      loading = true;
      new AsyncTask<String, Void, Response>() {

         @Override
         protected Response doInBackground(String... params) {
            String param = params[0];
            if (TextUtils.isEmpty(param)) {
               return null;
            }
            try {
               return comicService
                     .searchForVolume(Properties.API_KEY, Properties.JSON, Resources.VOLUMES, 20,
                           query, FieldList.VOLUMES);
            } catch (RetrofitError e) {
               Log.e(getClass().getSimpleName(), e.getMessage(), e);
            }
            return null;
         }

         @Override
         protected void onPostExecute(Response response) {
            loading = false;
            if (response == null) {
               callback.onFailure();
               return;
            }
            callback.onSuccess(response);
         }
      }.execute(query);
   }

   public void laodVolumeDetails(final Integer volumeId, final Callback callback) {
      if (loading) {
         return;
      }
      loading = true;
      new AsyncTask<Integer, Void, Response>() {

         @Override
         protected Response doInBackground(Integer... params) {
            Integer param = params[0];
            if (param == null) {
               return null;
            }
            try {
               return comicService.loadVolumeDetail(volumeId, Properties.API_KEY, Properties.JSON,
                     FieldList.VOLUME_DETAIL);
            } catch (RetrofitError e) {
               Log.e(getClass().getSimpleName(), e.getMessage(), e);
            }
            return null;
         }

         @Override
         protected void onPostExecute(Response response) {
            loading = false;
            if (response == null) {
               callback.onFailure();
               return;
            }
            callback.onSuccess(response);
         }
      }.execute(volumeId);
   }
}

