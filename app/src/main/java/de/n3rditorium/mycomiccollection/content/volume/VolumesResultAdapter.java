package de.n3rditorium.mycomiccollection.content.volume;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import de.n3rditorium.mycomiccollection.R;
import de.n3rditorium.mycomiccollection.models.comicvine.Response;
import de.n3rditorium.mycomiccollection.models.comicvine.Result;
import de.n3rditorium.mycomiccollection.utils.IntentUtils;

public class VolumesResultAdapter extends RecyclerView.Adapter<VolumesResultAdapter.ViewHolder> {

   public static class ViewHolder extends RecyclerView.ViewHolder {

      View view;
      ImageView cover;
      TextView name;
      TextView issueCount;
      TextView publisher;

      public ViewHolder(View itemView) {
         super(itemView);
         view = itemView;
         cover = (ImageView) itemView.findViewById(R.id.img_cover);
         name = (TextView) itemView.findViewById(R.id.txt_name);
         publisher = (TextView) itemView.findViewById(R.id.txt_publisher);
      }
   }

   private List<Result> results;
   private Activity activity;

   public VolumesResultAdapter(Activity activity, Response response) {
      if (response != null) {
         this.results = response.getResults();
      }
   }

   public void addItems(List<Result> results) {
      this.results = results;
   }

   public void addItem(int position, Result item) {
      if (results == null) {
         results = new ArrayList<Result>();
      }
      if (this.results.contains(item)) {
         return;
      }
      this.results.add(item);
      notifyItemInserted(position);
   }

   @Override
   public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
      View itemView = LayoutInflater.from(activity).inflate(R.layout.item_volume, viewGroup, false);

      return new ViewHolder(itemView);
   }

   @Override
   public void onBindViewHolder(ViewHolder viewHolder, int position) {
      final Result result = results.get(position);
      if (result == null) {
         return;
      }

      viewHolder.view.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
            activity.startActivity(IntentUtils.buildVolumeDetailIntent(activity,
                  VolumePresenterModel
                        .buildPresenterModel(result.getId(), result.getName(), result.getImage())));
         }
      });
      Picasso.with(activity).load(result.getImage().getSuperUrl()).into(viewHolder.cover);
      viewHolder.name.setText(result.getName());
      viewHolder.publisher.setText(result.getPublisher().getName());
   }

   @Override
   public int getItemCount() {
      if (results == null) {
         return 0;
      }
      return results.size();
   }

   public void clear() {
      this.results.clear();
      notifyDataSetChanged();
   }
}
