package de.n3rditorium.mycomiccollection.content.volume;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import de.n3rditorium.mycomiccollection.R;
import de.n3rditorium.mycomiccollection.core.ContentPresenter;
import de.n3rditorium.mycomiccollection.models.comicvine.Response;
import de.n3rditorium.mycomiccollection.models.comicvine.Result;

/**
 * Created by Kyp on 11.11.14.
 */
public class VolumesResultPresenter extends ContentPresenter {

   private static final String EXTRA_RESULTS = "VolumeResultPresenter.response";

   private Response response;
   private VolumesResultAdapter adapter;

   public VolumesResultPresenter(ActionBarActivity activity) {
      super(activity);
   }

   @Override
   public void onCreate(Bundle savedInstanceState) {
      setContentView(R.layout.group_search_result);

      if (savedInstanceState != null) {
         response = (Response) savedInstanceState.getSerializable(EXTRA_RESULTS);
         restoredData = true;
      }
      initRecyclerView();
   }

   private void initRecyclerView() {
      RecyclerView recyclerView = (RecyclerView) findViewById(R.id.search_results);
      recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
      adapter = new VolumesResultAdapter(getActivity(), response);
      recyclerView.setAdapter(adapter);
   }

   @Override
   public void onSavedInstanceState(Bundle outState) {
      outState.putSerializable(EXTRA_RESULTS, response);
   }

   @Override
   public void addContent(Content content) {
      this.response = (Response) content;
      int i = 0;
      for (Result item : response.getResults()) {
         adapter.addItem(i++, item);
      }
   }

   public void clearContent() {
      response = null;
      adapter.clear();
   }
}
