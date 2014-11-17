package de.n3rditorium.mycomiccollection.content.search;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.widget.TextView;

import de.n3rditorium.mycomiccollection.R;
import de.n3rditorium.mycomiccollection.core.ContentPresenter;

/**
 * Created by Kyp on 16.11.14.
 */
public class EmptyItemPresenter extends ContentPresenter {

   public enum Type implements Content {
      NO_ITEM_ADDED, NO_SCAN_RESULTS, NO_SEARCH_RESULTS
   }

   public EmptyItemPresenter(ActionBarActivity activity) {
      super(activity);
   }

   @Override
   public void onCreate(Bundle savedInstanceState) {
      setContentView(R.layout.empty_card);
   }

   @Override
   public void onSavedInstanceState(Bundle outState) {

   }

   @Override
   public void clearContent() {
      // nothing to do here
   }

   @Override
   public void addContent(Content content) {
      // nothing to do here
      Type type = (Type) content;

      int titleId;
      int subtitleId;
      switch (type) {
         case NO_ITEM_ADDED:
         case NO_SCAN_RESULTS:
         case NO_SEARCH_RESULTS:
         default:
            titleId = R.string.empty_no_items_added_title;
            subtitleId = R.string.empty_no_items_added_message;
      }

      ((TextView) findViewById(R.id.txt_title)).setText(titleId);
      ((TextView) findViewById(R.id.txt_subtitle)).setText(subtitleId);
   }
}
