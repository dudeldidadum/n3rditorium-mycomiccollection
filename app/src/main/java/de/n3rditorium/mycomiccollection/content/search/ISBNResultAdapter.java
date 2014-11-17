package de.n3rditorium.mycomiccollection.content.search;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import de.n3rditorium.mycomiccollection.R;
import de.n3rditorium.mycomiccollection.models.Item;
import de.n3rditorium.mycomiccollection.models.VolumeInfo;

/**
 * Created by Kyp on 11.11.14.
 */
public class ISBNResultAdapter extends RecyclerView.Adapter<ISBNResultAdapter.ViewHolder> {

   public static class ViewHolder extends RecyclerView.ViewHolder {

      TextView title;
      TextView subtitle;
      TextView meta;
      TextView description;
      RatingBar ratingBar;
      ImageView cover;

      public ViewHolder(View itemView) {
         super(itemView);

         title = (TextView) itemView.findViewById(R.id.txt_title);
         subtitle = (TextView) itemView.findViewById(R.id.txt_subtitle);
         meta = (TextView) itemView.findViewById(R.id.txt_meta);
         description = (TextView) itemView.findViewById(R.id.txt_description);
         cover = (ImageView) itemView.findViewById(R.id.img_cover);
         ratingBar = (RatingBar) itemView.findViewById(R.id.rating);
      }
   }

   private static final String PATTERN_IN_DATE = "yyyy-MM-dd";
   private static final String PATTERN_OUT_DATE = "dd.MM.yyyy";

   private SimpleDateFormat sdfIn = new SimpleDateFormat(PATTERN_IN_DATE);
   private SimpleDateFormat sdfOut = new SimpleDateFormat(PATTERN_OUT_DATE);

   private List<Item> searchResults;

   public ISBNResultAdapter() {
      // nothing to do here
      searchResults = new ArrayList<Item>();
   }

   public void addItems(List<Item> items) {
      this.searchResults = items;
   }

   public void addItem(int position, Item item) {
      if (this.searchResults.contains(item)) {
         return;
      }
      this.searchResults.add(item);
      notifyItemInserted(position);
   }

   private Context context;

   @Override
   public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
      context = viewGroup.getContext();
      View itemView =
            LayoutInflater.from(context).inflate(R.layout.item_search_result, viewGroup, false);

      return new ViewHolder(itemView);
   }

   @Override
   public void onBindViewHolder(ViewHolder viewHolder, int i) {
      Item item = searchResults.get(i);
      if (item == null) {
         return;
      }
      VolumeInfo info = item.getVolumeInfo();
      if (info == null) {
         return;
      }

      viewHolder.title.setText(info.getTitle());
      viewHolder.subtitle.setText(info.getSubtitle());
      viewHolder.description.setText(info.getDescription());
      //      viewHolder.publishDate.setText(item.getVolumeInfo().getPublishedDate());
      //      viewHolder.publisher.setText(item.getVolumeInfo().getPublisher());
      setMeta(viewHolder, info);
      loadCover(viewHolder, info);
      setRating(viewHolder, info);
   }

   private void setRating(ViewHolder viewHolder, VolumeInfo info) {
      Float rating = info.getAverageRating();
      if(rating == null) {
         viewHolder.ratingBar.setVisibility(View.GONE);
         return;
      }
      viewHolder.ratingBar.setVisibility(View.VISIBLE);
      viewHolder.ratingBar.setRating(rating);
   }

   private void loadCover(ViewHolder viewHolder, VolumeInfo info) {
      if (info.getImageLinks() == null) {
         viewHolder.cover.setImageResource(android.R.color.transparent);
         return;
      }
      String imageLink = info.getImageLinks().getThumbnail();
      if (TextUtils.isEmpty(imageLink)) {
         viewHolder.cover.setImageResource(android.R.color.transparent);
         return;
      }
      Picasso.with(context).load(imageLink).into(viewHolder.cover);
   }

   private String getAuthor(VolumeInfo info) {
      List<String> authors = info.getAuthors();
      if (authors == null || authors.isEmpty()) {
         return null;
      }
      return authors.get(0);
   }

   private String getDate(VolumeInfo info) {
      String inDate = info.getPublishedDate();
      if (TextUtils.isEmpty(inDate)) {
         return null;
      }

      if (inDate.length() == 4) {
         return inDate;
      }
      if (inDate.length() != PATTERN_IN_DATE.length()) {
         return null;
      }
      Date date;
      try {
         date = sdfIn.parse(inDate);
      } catch (ParseException e) {
         Log.e(this.getClass().getSimpleName(), e.getMessage(), e);
         return null;
      }
      return sdfOut.format(date);
   }

   private void setMeta(ViewHolder viewHolder, VolumeInfo info) {
      StringBuilder builder = new StringBuilder();

      if (!TextUtils.isEmpty(info.getPublisher())) {
         builder.append(info.getPublisher());
      }
      String author = getAuthor(info);
      if (!TextUtils.isEmpty(author)) {
         if (builder.length() > 0) {
            builder.append(", ");
         }
         builder.append(author);
      }
      String date = getDate(info);
      if (!TextUtils.isEmpty(date)) {
         builder.append(" (");
         builder.append(date);
         builder.append(")");
      }
      viewHolder.meta.setText(builder.toString());
   }

   @Override
   public int getItemCount() {
      return searchResults.size();
   }

   public void clear() {
      this.searchResults.clear();
      notifyDataSetChanged();
   }
}
