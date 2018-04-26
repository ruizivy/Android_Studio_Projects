package com.example.ruiz.cameraapp;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.io.InputStream;

public class MainActivity extends AppCompatActivity {

    Button btnOpen;
    ImageView img;

    Bitmap bmp;
    PackageManager pm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnOpen = (Button)findViewById(R.id.btnOpen);
        btnOpen.setOnClickListener(new ButtonEvent());

        img = (ImageView)findViewById(R.id.image);

        pm = getPackageManager();
       // if(pm.hasSystemFeature(PackageManager.FEATURE_CAMERA)){}
    }

    private class ButtonEvent implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            startActivityForResult(intent , 1);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        InputStream  stream = null;
        if((requestCode == 1) && (resultCode == Activity.RESULT_OK)){
            try{
                if(bmp != null){
                    bmp.recycle();
                }
                stream = getContentResolver().openInputStream(data.getData());

                bmp= BitmapFactory.decodeStream(stream);
                img.setImageBitmap(bmp);

            }catch (Exception ex){}
            finally {
                if(stream != null){
                    try{
                        stream.close();
                    }catch (Exception ex){}
                }
            }
        }
    }
}
