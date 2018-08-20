package com.draidi.test1;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.hardware.camera2.CaptureRequest;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.textclassifier.TextSelection;
import android.widget.Button;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class take_photo extends AppCompatActivity {
    static final int REQUEST_IMG_CAPTURE=1;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Button button=(Button)(findViewById(R.id.take_photo_button));

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_take_photo);
        ImageView iv=((ImageView)(findViewById(R.id.myImg)));
        Picasso.get().load("http://192.168.1.108/GradProj/productImages/l3.jpg").into(iv);







        if(!(getPackageManager().hasSystemFeature(PackageManager.FEATURE_CAMERA_ANY)))button.setEnabled(false);
iv.setOnLongClickListener(new View.OnLongClickListener() {
    @Override
    public boolean onLongClick(View view) {
        ImageView iv=((ImageView)(findViewById(R.id.myImg)));
        Bitmap bm=myBitmapImage(iv.getDrawable());

        MediaStore.Images.Media.insertImage(getContentResolver(),bm,"hey","there");
        return true;
    }
});
iv.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        ImageView iv=((ImageView)(findViewById(R.id.myImg)));
        Bitmap bm=myBitmapImage(iv.getDrawable());
        ((ImageView)(findViewById(R.id.imageView2))).setImageBitmap(bm);
        MediaStore.Images.Media.insertImage(getContentResolver(),bm,"hey","there");
    }
});



    }
    public Bitmap myBitmapImage(Drawable img){
        Bitmap img1=((BitmapDrawable)img).getBitmap();
       return img1;
    }
    public void lunch(View view){
        Intent i=new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(i, REQUEST_IMG_CAPTURE);
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if(requestCode==REQUEST_IMG_CAPTURE &&resultCode==RESULT_OK){
            Bundle extra=data.getExtras();
            Bitmap photo=(Bitmap) extra.get("data");
            ((ImageView)(findViewById(R.id.myImg))).setImageBitmap(photo);

        }
    }
}
