package de.n3rditorium.mycomiccollection.search;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import de.n3rditorium.mycomiccollection.R;
import de.n3rditorium.mycomiccollection.models.Item;

/**
 * Created by Kyp on 11.11.14.
 */
public class SearchResultAdapter extends RecyclerView.Adapter<SearchResultAdapter.ViewHolder> {

   public static class ViewHolder extends RecyclerView.ViewHolder {

      TextView title;
      TextView subtitle;
      TextView publishDate;
      TextView publisher;

      public ViewHolder(View itemView) {
         super(itemView);

         title = (TextView) itemView.findViewById(R.id.txt_title);
         subtitle = (TextView) itemView.findViewById(R.id.txt_subtitle);
         publishDate = (TextView) itemView.findViewById(R.id.txt_pub_date);
         publisher = (TextView) itemView.findViewById(R.id.txt_publisher);
      }
   }

   private List<Item> searchResults;

   public SearchResultAdapter(List<Item> searchResults) {
      this.searchResults = searchResults;
   }

   @Override
   public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
      View itemView = LayoutInflater.from(viewGroup.getContext())
            .inflate(R.layout.item_search_result, viewGroup, false);

      return new ViewHolder(itemView);
   }

   @Override
   public void onBindViewHolder(ViewHolder viewHolder, int i) {
      Item item = searchResults.get(i);

      viewHolder.title.setText(item.getVolumeInfo().getTitle());
      viewHolder.subtitle.setText(item.getVolumeInfo().getSubtitle());
      viewHolder.publishDate.setText(item.getVolumeInfo().getPublishedDate());
      viewHolder.publisher.setText(item.getVolumeInfo().getPublisher());
   }

   @Override
   public int getItemCount() {
      return searchResults.size();
   }
}
