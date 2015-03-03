package de.n3rditorium.mycomiccollection.content.search;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import de.n3rditorium.mycomiccollection.R;
import de.n3rditorium.mycomiccollection.core.ContentPresenter;
import de.n3rditorium.mycomiccollection.models.Item;
import de.n3rditorium.mycomiccollection.models.SearchResults;

/**
 * Created by Kyp on 11.11.14.
 */
public class ISBNResultPresenter extends ContentPresenter {

   private static final String EXTRA_RESULTS = "SearchResultPresenter.searchResults";

   private SearchResults results;
   private ISBNResultAdapter adapter;

   public ISBNResultPresenter(ActionBarActivity activity) {
      super(activity);
   }

   @Override
   public void onCreate(Bundle savedInstanceState) {
      setContentView(R.layout.group_search_result);

      if (savedInstanceState != null) {
         results = (SearchResults) savedInstanceState.getSerializable(EXTRA_RESULTS);
      }

      initRecyclerView();
   }

   private void initRecyclerView() {
      RecyclerView recyclerView = (RecyclerView) findViewById(R.id.search_results);
      recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
      adapter = new ISBNResultAdapter();
      if (results != null) {
         adapter.addItems(results.getItems());
      }
      recyclerView.setAdapter(adapter);
   }

   @Override
   public void onSavedInstanceState(Bundle outState) {
      outState.putSerializable(EXTRA_RESULTS, results);
   }

   @Override
   public void addContent(Content content) {
      this.results = (SearchResults) content;
      int i = 0;
      for (Item item : results.getItems()) {
         adapter.addItem(i++, item);
      }
   }

   public void clearContent() {
      results = null;
      adapter.clear();
   }
}
