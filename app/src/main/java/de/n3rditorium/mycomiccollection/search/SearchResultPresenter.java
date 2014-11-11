package de.n3rditorium.mycomiccollection.search;

import android.app.Activity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import de.n3rditorium.mycomiccollection.R;
import de.n3rditorium.mycomiccollection.models.SearchResults;

/**
 * Created by Kyp on 11.11.14.
 */
public class SearchResultPresenter {

   private Activity activity;

   public SearchResultPresenter(Activity activity) {
      this.activity = activity;
   }

   public void populatioResultList(SearchResults results, ViewGroup container) {
      RecyclerView list = (RecyclerView) LayoutInflater.from(activity)
            .inflate(R.layout.group_search_result, container, false);

      RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(activity);
      list.setLayoutManager(layoutManager);

      // specify an adapter (see also next example)
      SearchResultAdapter adapter = new SearchResultAdapter(results.getItems());
      list.setAdapter(adapter);

      container.addView(list, 0);
   }
}
