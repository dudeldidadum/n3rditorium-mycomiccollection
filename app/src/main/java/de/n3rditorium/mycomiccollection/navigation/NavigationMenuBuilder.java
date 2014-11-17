package de.n3rditorium.mycomiccollection.navigation;

import android.content.Context;
import android.content.Intent;
import android.support.v4.util.Pair;

import java.util.ArrayList;
import java.util.List;

import de.n3rditorium.mycomiccollection.HomeActivity;
import de.n3rditorium.mycomiccollection.R;
import de.n3rditorium.mycomiccollection.content.volume.VolumesSearchActivity;

/**
 * Created by Kyp on 14.11.14.
 */
public class NavigationMenuBuilder {

   private static List<Pair<String, Intent>> items;

   public static List<Pair<String, Intent>> build(Context context) {
      if (items == null || items.isEmpty()) {
         fillItems(context);
      }

      return items;
   }

   private static void fillItems(Context context) {
      items = new ArrayList<Pair<String, Intent>>();

      items.add(new Pair(context.getString(R.string.nav_item_collection),
            new Intent(context, VolumesSearchActivity.class)));
      items.add(new Pair(context.getString(R.string.nav_item_wishlist),
            new Intent(context, HomeActivity.class)));
      items.add(new Pair(context.getString(R.string.nav_item_settings),
            new Intent(context, HomeActivity.class)));
   }

   public static String getTitle(int position) {
      return items.get(position).first;
   }

   public static Intent getAction(int position) {
      return items.get(position).second;
   }

   public static int size() {
      return items.size();
   }
}
