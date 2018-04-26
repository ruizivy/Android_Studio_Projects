package com.example.ruiz.qrcode;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.RectF;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.onbarcode.barcode.android.AndroidColor;
import com.onbarcode.barcode.android.IBarcode;
import com.onbarcode.barcode.android.QRCode;

import java.io.File;
import java.io.FileOutputStream;


public class MainActivity extends AppCompatActivity {

    QRCode grGenerate;
    EditText etText;
    Button btn_generate , btn_save;
    ImageView img;
    Bitmap bmp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        grGenerate =  new QRCode();
        etText = (EditText)findViewById(R.id.Edittext1);

        btn_generate = (Button)findViewById(R.id.btnGenerate);
        btn_generate.setOnClickListener(new ButtonHandler());
        btn_save = (Button)findViewById(R.id.btnSave);
        btn_save.setOnClickListener(new ButtonHandler());

        img = (ImageView)findViewById(R.id.image);
        img.setDrawingCacheEnabled(true);

    }
    public class ButtonHandler implements View.OnClickListener{
        @Override
        public void onClick(View view) {
            if(btn_generate == view){

                grGenerate.setData(etText.getText().toString());
                grGenerate.setDataMode(QRCode.M_AUTO);
                grGenerate.setVersion(10);
                grGenerate.setEci(QRCode.ECL_L);
                grGenerate.setUom(IBarcode.UOM_PIXEL);
                grGenerate.setX(3f);
                grGenerate.setLeftMargin(15f);
                grGenerate.setRightMargin(15f);
                grGenerate.setTopMargin(15f);
                grGenerate.setBottomMargin(15f);
                grGenerate.setResolution(500);
                grGenerate.setForeColor(AndroidColor.black);
                grGenerate.setBackColor(AndroidColor.white);

                RectF bound =new RectF(60, 60, 0,0);
                bmp = Bitmap.createBitmap(300, 300, Bitmap.Config.ARGB_8888);
                Canvas canvas = new Canvas(bmp);

                try{
                    grGenerate.drawBarcode(canvas , bound);

                }catch (Exception ex){

                }
                img.setImageBitmap(bmp);
            }else if(btn_save == view){

                String path = Environment.getExternalStorageDirectory() + "/myQRPic.jpg";
                File imgLocation = new File(path);
                try{
                    FileOutputStream fos = new FileOutputStream(imgLocation);
                    bmp.compress(Bitmap.CompressFormat.JPEG, 100 , fos);
                    SaveIT(path);
                }catch (Exception ex){

                }
            }
        }
    }
    private  void SaveIT(String path){
        Intent intent= new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE);
        File f = new File(path);
        Uri uri =  Uri.fromFile(f);
        intent.setData(uri);
        this.sendBroadcast(intent);
    }
}
