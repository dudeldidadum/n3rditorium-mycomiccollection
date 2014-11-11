package de.n3rditorium.mycomiccollection;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

import de.n3rditorium.mycomiccollection.models.SearchResults;
import de.n3rditorium.mycomiccollection.remote.ISBNSearch;
import de.n3rditorium.mycomiccollection.search.SearchResultPresenter;

public class MainActivity extends ActionBarActivity {

   @Override
   protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.activity_main);

      Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
      setSupportActionBar(toolbar);
      initFloatAction();
   }

   @Override
   public boolean onCreateOptionsMenu(Menu menu) {
      // Inflate the menu; this adds items to the action bar if it is present.
      getMenuInflater().inflate(R.menu.menu_main, menu);
      return true;
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

   private void initFloatAction() {
      View btnScan = findViewById(R.id.btn_scan);
      btnScan.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
            View searchResults = findViewById(R.id.search_results);
            if(searchResults != null) {
               ViewGroup container = (ViewGroup) findViewById(R.id.container);
               container.removeView(searchResults);
            }
            IntentIntegrator.initiateScan(MainActivity.this);
         }
      });
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
            Toast.makeText(MainActivity.this, "onSuccess", Toast.LENGTH_SHORT).show();

            SearchResultPresenter presenter = new SearchResultPresenter(MainActivity.this);
            presenter.populatioResultList(results, (ViewGroup) findViewById(R.id.container));
         }

         @Override
         public void onFailure() {
            Toast.makeText(MainActivity.this, "onFailure", Toast.LENGTH_SHORT).show();
         }
      });
   }
}
