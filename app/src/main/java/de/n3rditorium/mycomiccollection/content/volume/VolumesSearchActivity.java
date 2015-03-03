package de.n3rditorium.mycomiccollection.content.volume;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

import de.n3rditorium.mycomiccollection.R;
import de.n3rditorium.mycomiccollection.content.search.ISBNResultPresenter;
import de.n3rditorium.mycomiccollection.core.ContentActivity;
import de.n3rditorium.mycomiccollection.models.SearchResults;
import de.n3rditorium.mycomiccollection.models.comicvine.Response;
import de.n3rditorium.mycomiccollection.remote.ISBNSearch;
import de.n3rditorium.mycomiccollection.remote.comicvine.ComicVine;

public class VolumesSearchActivity extends ContentActivity {

   /**
    * Used to store the last screen title. For use in {@link #restoreActionBar()}.
    */
   private CharSequence mTitle;

   @Override
   protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.act_home);

      if (presenter != null && presenter.usesRestoredData()) {
         return;
      }
      searchVolumes("Amazing Spider-Man");
   }

   protected void searchVolumes(String query) {
      showLoadingView();
      ComicVine.getInstance(this).searchVolume(query, new ComicVine.Callback() {
         @Override
         public void onSuccess(Response response) {
            hideLoadingView();
            presenter = new VolumesResultPresenter(VolumesSearchActivity.this);
            presenter.onCreate(null);
            presenter.addContent(response);
         }

         @Override
         public void onFailure() {
            hideLoadingView();
            // TODO show error
         }
      });
   }

   @Override
   public boolean onCreateOptionsMenu(Menu menu) {
      if (!mNavigationDrawerFragment.isDrawerOpen()) {
         // Only show items in the action bar relevant to this screen
         // if the drawer is not showing. Otherwise, let the drawer
         // decide what to show in the action bar.
         getMenuInflater().inflate(R.menu.home, menu);
         restoreActionBar();
         return true;
      }
      return super.onCreateOptionsMenu(menu);
   }

   @Override
   public boolean onOptionsItemSelected(MenuItem item) {
      // Handle action bar item clicks here. The action bar will
      // automatically handle clicks on the Home/Up button, so long
      // as you specify a parent activity in AndroidManifest.xml.
      int id = item.getItemId();

      //noinspection SimplifiableIfStatement
      if (id == R.id.action_settings) {
         return true;
      }

      return super.onOptionsItemSelected(item);
   }

   @Override
   protected void onActivityResult(int requestCode, int resultCode, Intent data) {
      IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
      if (result != null) {
         if (result.getContents() == null) {
            Toast.makeText(this, "Cancelled", Toast.LENGTH_LONG).show();
         } else {
            Toast.makeText(this, "Scanned: " + result.getContents(), Toast.LENGTH_LONG).show();
            executeSearchRequest(result.getContents());
         }
      } else {
         // This is important, otherwise the result will not be passed to the fragment
         super.onActivityResult(requestCode, resultCode, data);
      }
   }

   private void executeSearchRequest(String param) {
      ISBNSearch.getInstance(this).searchFor(param, new ISBNSearch.Callback() {

         @Override
         public void onSuccess(SearchResults results) {
            replacePresenter(new ISBNResultPresenter(VolumesSearchActivity.this));
            presenter.addContent(results);
         }

         @Override
         public void onFailure() {
            Toast.makeText(VolumesSearchActivity.this, "onFailure", Toast.LENGTH_SHORT).show();
         }
      });
   }
}
