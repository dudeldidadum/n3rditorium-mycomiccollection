package de.n3rditorium.mycomiccollection.core;

import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import de.n3rditorium.mycomiccollection.R;
import de.n3rditorium.mycomiccollection.navigation.NavigationDrawerFragment;

public abstract class ContentActivity extends ActionBarActivity
      implements NavigationDrawerFragment.NavigationDrawerCallbacks {

   protected ContentPresenter presenter;
   protected CharSequence title;
   protected View loadingView;
   /**
    * Fragment managing the behaviors, interactions and presentation of the navigation drawer.
    */
   protected NavigationDrawerFragment mNavigationDrawerFragment;

   @Override
   public void setContentView(int layoutResID) {
      super.setContentView(layoutResID);
      Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
      if (toolbar == null) {
         throw new IllegalArgumentException("Toolbar must not be null");
      }
      setSupportActionBar(toolbar);

      mNavigationDrawerFragment = (NavigationDrawerFragment) getSupportFragmentManager()
            .findFragmentById(R.id.navigation_drawer);
      title = getTitle();
      if (mNavigationDrawerFragment == null) {
         throw new IllegalArgumentException(
               "a NavigationDrawer must be provided in the layout file");
      }
      // Set up the drawer.
      mNavigationDrawerFragment
            .setUp(R.id.navigation_drawer, (DrawerLayout) findViewById(R.id.drawer_layout));

      loadingView = findViewById(R.id.loading_view);
   }

   public void showLoadingView() {
      if(loadingView == null) {
         return;
      }
      loadingView.setVisibility(View.VISIBLE);
   }

   public void hideLoadingView() {
      if(loadingView == null) {
         return;
      }
      loadingView.setVisibility(View.GONE);

   }

   public void replacePresenter(ContentPresenter presenter) {
      this.presenter.removeContent();
      this.presenter = presenter;
      this.presenter.onCreate(null);
   }

   @Override
   public void onNavigationDrawerItemSelected(int position) {
      // update the main content by replacing fragments
   }

   public void restoreActionBar() {
      ActionBar actionBar = getSupportActionBar();
      actionBar.setDisplayShowTitleEnabled(true);
      actionBar.setTitle(title);
   }

   @Override
   public void onSaveInstanceState(Bundle outState) {
      super.onSaveInstanceState(outState);
      if (presenter != null) {
         presenter.onSavedInstanceState(outState);
      }
   }
}
