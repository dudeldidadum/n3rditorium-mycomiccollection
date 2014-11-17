package de.n3rditorium.mycomiccollection.navigation;

import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import de.n3rditorium.mycomiccollection.R;

/**
 * Created by Kyp on 11.11.14.
 */
public class NavigationItemAdapter extends RecyclerView.Adapter<NavigationItemAdapter.ViewHolder> {

   public static class ViewHolder extends RecyclerView.ViewHolder {

      TextView title;

      public ViewHolder(View itemView) {
         super(itemView);
         title = (TextView) itemView;
      }
   }

   private Activity activity;
   private View.OnClickListener onClickListener;

   public NavigationItemAdapter(Activity activity) {
      this.activity = activity;
      NavigationMenuBuilder.build(activity.getBaseContext());
   }

   public void setOnClickListener(View.OnClickListener onClickListener) {
      this.onClickListener = onClickListener;
   }

   @Override
   public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
      Context context = viewGroup.getContext();
      View itemView =
            LayoutInflater.from(context).inflate(R.layout.item_navigation, viewGroup, false);

      return new ViewHolder(itemView);
   }

   @Override
   public void onBindViewHolder(ViewHolder viewHolder, final int i) {
      viewHolder.title.setText(NavigationMenuBuilder.getTitle(i));
      viewHolder.title.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
            activity.startActivity(NavigationMenuBuilder.getAction(i));
         }
      });
   }

   @Override
   public int getItemCount() {
      return NavigationMenuBuilder.size();
   }
}
