package de.n3rditorium.mycomiccollection.content.volume;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.graphics.Palette;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;

import com.nvanbenschoten.motion.ParallaxImageView;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;

import de.n3rditorium.mycomiccollection.R;
import de.n3rditorium.mycomiccollection.core.ContentActivity;
import de.n3rditorium.mycomiccollection.utils.BlurTransformation;
import de.n3rditorium.mycomiccollection.utils.ComicConstants;

public class VolumeDetailActivity extends ContentActivity implements ComicConstants {

   public static final String KEY_COLOR_PRIMARY = "key for colorPrimary";
   public static final String KEY_COLOR_PRIMARY_DARK = "key for colorPrimaryDark";

   private int colorPrimary = -1;
   private int colorPrimaryDark = -1;

   ParallaxImageView background;

   @Override
   protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      addContentView();

       background = (ParallaxImageView) findViewById(R.id.img_background);
      Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
      VolumePresenterModel item =
            (VolumePresenterModel) getIntent().getSerializableExtra(Extras.VOLUME);

      if (savedInstanceState != null) {
         toolbar.setAlpha(1.0f);
         colorPrimary =
               savedInstanceState.getInt(KEY_COLOR_PRIMARY, getResources().getColor(R.color.blue));
         colorPrimaryDark = savedInstanceState
               .getInt(KEY_COLOR_PRIMARY_DARK, getResources().getColor(R.color.blue_dark));

         setColors(toolbar);
         Picasso.with(this).load(item.getImageLinks().getThumbUrl())
               .transform(new BlurTransformation(this)).into(background);
      } else {
         toolbar.setAlpha(0.0f);
         if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setStatusBarColor(Color.BLACK);
         }

         Picasso.with(this).load(item.getImageLinks().getThumbUrl())
               .transform(new BlurTransformation(this)).into(new Target() {

            @Override
            public void onBitmapLoaded(Bitmap bitmap, Picasso.LoadedFrom from) {
               handleOnBitmapLoaded(bitmap, background);
            }

            @Override
            public void onBitmapFailed(Drawable errorDrawable) {
               // nothing to do here right now
            }

            @Override
            public void onPrepareLoad(Drawable placeHolderDrawable) {
               // nothing to do here right now
            }
         });
      }

      ImageView cover = (ImageView) findViewById(R.id.img_cover);
      Picasso.with(this).load(item.getImageLinks().getSmallUrl()).into(cover);

      setTitle(item.getName());
      //      ComicVine.getInstance(this).laodVolumeDetails(item.getId(), new ComicVine.Callback() {
      //         @Override
      //         public void onSuccess(Response response) {
      //            Toast.makeText(VolumeDetailActivity.this, "wuhuuuu!!!",
      // Toast.LENGTH_SHORT).show();
      //         }
      //
      //         @Override
      //         public void onFailure() {
      //            Toast.makeText(VolumeDetailActivity.this, "FOO", Toast.LENGTH_SHORT).show();
      //         }
      //      });
   }

   @Override
   protected void onResume() {
      super.onResume();
      background.registerSensorManager();
   }

   @Override
   protected void onPause() {
      super.onPause();
      background.unregisterSensorManager();
   }

   private void handleOnBitmapLoaded(Bitmap bitmap, ImageView background) {
      background.setImageBitmap(bitmap);
      Palette.generateAsync(bitmap, new Palette.PaletteAsyncListener() {
         @Override
         public void onGenerated(Palette palette) {
            colorPrimary = palette.getMutedColor(Color.BLACK);
            colorPrimaryDark = palette.getDarkMutedColor(Color.BLACK);

            Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
            setColors(toolbar);
            toolbar.animate().alpha(1.0f).setDuration(1200).start();
         }
      });
   }

   private void setColors(Toolbar toolbar) {
      toolbar.setBackgroundColor(colorPrimary);
      if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
         getWindow().setStatusBarColor(colorPrimaryDark);
      }
   }

   private void addContentView() {
      setContentView(R.layout.act_volume_details);
   }

   @Override
   public void onSaveInstanceState(Bundle outState) {
      super.onSaveInstanceState(outState);
      outState.putInt(KEY_COLOR_PRIMARY, colorPrimary);
      outState.putInt(KEY_COLOR_PRIMARY_DARK, colorPrimaryDark);
   }
}
