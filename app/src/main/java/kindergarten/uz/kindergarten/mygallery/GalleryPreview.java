package kindergarten.uz.kindergarten.mygallery;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Base64;
import android.widget.ImageView;

import kindergarten.uz.kindergarten.R;

/**
 * Created by SHAJIB on 25/12/2015.
 */
public class GalleryPreview extends AppCompatActivity {

    ImageView GalleryPreviewImg;
    String path;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.fragment_gallery_preview);
        path = GalleryFragment.str;
        System.out.println("gallery preview "+path);
//        Intent intent = getIntent();
        GalleryPreviewImg = (ImageView) findViewById(R.id.GalleryPreviewImg);
        byte[] b = Base64.decode(path,Base64.DEFAULT);
        Bitmap as = BitmapFactory.decodeByteArray(b,0,b.length);
//        Bitmap b1 = Bitmap.createBitmap(as,50,50, 200,200);
        GalleryPreviewImg.setImageBitmap(as);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();


    }
}
