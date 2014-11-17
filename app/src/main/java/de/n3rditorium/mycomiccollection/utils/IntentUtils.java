package de.n3rditorium.mycomiccollection.utils;

import android.content.Context;
import android.content.Intent;

import de.n3rditorium.mycomiccollection.content.volume.VolumeDetailActivity;
import de.n3rditorium.mycomiccollection.content.volume.VolumePresenterModel;

public class IntentUtils implements ComicConstants {

   public static Intent buildVolumeDetailIntent(Context context, VolumePresenterModel item) {
      Intent intent = new Intent(context, VolumeDetailActivity.class);
      intent.putExtra(Extras.VOLUME, item);

      return intent;
   }
}
