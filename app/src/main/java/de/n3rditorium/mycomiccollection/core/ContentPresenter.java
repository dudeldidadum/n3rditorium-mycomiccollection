package de.n3rditorium.mycomiccollection.core;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import de.n3rditorium.mycomiccollection.R;

public abstract class ContentPresenter {

   public static interface Content {
      // empty interface to
   }

   protected boolean restoredData = false;
   private ActionBarActivity activity;
   protected ViewGroup contentContainer;
   protected View contentView;

   public ContentPresenter(ActionBarActivity activity) {
      this.activity = activity;
      this.contentContainer = (ViewGroup) activity.findViewById(R.id.content_container);
   }

   public abstract void onCreate(Bundle savedInstanceState);

   public abstract void onSavedInstanceState(Bundle outState);

   protected String getString(int resId) {
      return activity.getString(resId);
   }

   protected Resources getResources() {
      return activity.getResources();
   }

   protected void setTitle(int titleId) {
      activity.setTitle(titleId);
   }

   protected void setContentView(int layoutId) {
      contentView = LayoutInflater.from(activity).inflate(layoutId, contentContainer, false);
      contentContainer.addView(contentView, 0);
   }

   protected View findViewById(int viewId) {
      return contentView.findViewById(viewId);
   }

   protected View findViewWithTag(Object tag) {
      return contentView.findViewWithTag(tag);
   }

   protected Context getContext() {
      return activity.getBaseContext();
   }

   public void removeContent() {
      if (contentContainer == null) {
         return;
      }
      int childCount = contentContainer.getChildCount();
      for (int i = 0; i < childCount; ++i) {
         View child = contentContainer.getChildAt(i);
         if (child.getId() == R.id.toolbar) {
            continue;
         }
         contentContainer.removeView(child);
      }
   }

   public ActionBarActivity getActivity() {
      return activity;
   }

   public boolean usesRestoredData() {
      return restoredData;
   }

   public abstract void clearContent();

   public abstract void addContent(Content content);
}
