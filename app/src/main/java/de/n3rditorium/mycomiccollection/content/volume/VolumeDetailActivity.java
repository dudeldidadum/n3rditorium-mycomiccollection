package de.n3rditorium.mycomiccollection.content.volume;

import android.os.Bundle;
import android.widget.Toast;

import de.n3rditorium.mycomiccollection.R;
import de.n3rditorium.mycomiccollection.core.ContentActivity;
import de.n3rditorium.mycomiccollection.models.comicvine.Response;
import de.n3rditorium.mycomiccollection.remote.comicvine.ComicVine;
import de.n3rditorium.mycomiccollection.utils.ComicConstants;

public class VolumeDetailActivity extends ContentActivity implements ComicConstants {

   @Override
   protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.act_home);

      VolumePresenterModel item =
            (VolumePresenterModel) getIntent().getSerializableExtra(Extras.VOLUME);
      setTitle(item.getName());
      ComicVine.getInstance(this).laodVolumeDetails(item.getId(), new ComicVine.Callback() {
         @Override
         public void onSuccess(Response response) {
            Toast.makeText(VolumeDetailActivity.this, "wuhuuuu!!!", Toast.LENGTH_SHORT).show();
         }

         @Override
         public void onFailure() {
            Toast.makeText(VolumeDetailActivity.this, "FOO", Toast.LENGTH_SHORT).show();
         }
      });
   }
}
