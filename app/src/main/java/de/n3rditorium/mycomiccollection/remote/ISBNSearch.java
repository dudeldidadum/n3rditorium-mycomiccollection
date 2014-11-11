package de.n3rditorium.mycomiccollection.remote;

import android.content.Context;
import android.os.AsyncTask;
import android.text.TextUtils;
import android.util.Log;

import de.n3rditorium.mycomiccollection.models.SearchResults;
import retrofit.RestAdapter;
import retrofit.RetrofitError;

public class ISBNSearch {

   public static interface Callback {

      public void onSuccess(SearchResults results);

      public void onFailure();
   }
   private static final String GOOGLE_APIS = "https://www.googleapis.com/books/v1";
   private static ISBNSearch instance;

   private Context context;
   private VolumeService volumeService;
   private boolean loading = false;

   public static ISBNSearch getInstance(Context context) {
      if (instance == null) {
         instance = new ISBNSearch(context);
      }
      return instance;
   }

   private ISBNSearch(Context context) {
      this.context = context.getApplicationContext();

      RestAdapter restAdapter = new RestAdapter.Builder().setEndpoint(GOOGLE_APIS).build();
      volumeService = restAdapter.create(VolumeService.class);
   }

   public void searchFor(final String isbn, final Callback callback) {
      if(loading) {
         return;
      }
      loading = true;
      new AsyncTask<String, Void, SearchResults>() {

         @Override
         protected SearchResults doInBackground(String... params) {
            String param = params[0];
            if (TextUtils.isEmpty(param)) {
               return null;
            }
            try {
               return volumeService.searchFor(isbn);
            } catch (RetrofitError e) {
               Log.e(getClass().getSimpleName(), e.getMessage(), e);
            }
            return null;
         }

         @Override
         protected void onPostExecute(SearchResults searchResults) {
            loading = false;
            if (searchResults == null) {
               callback.onFailure();
               return;
            }
            callback.onSuccess(searchResults);
         }
      }.execute(isbn);
   }
}
