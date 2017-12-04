package com.survey.g2mdx.surveyg2m;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class GetPicActivity extends AppCompatActivity implements View.OnClickListener {
    Spinner spinner_out;
    Button btn_next,btn_prev,btn_new,btn_sql;
    LinearLayout liner1,liner2;
    private static final int CAMERA_REQUEST = 1888;
    private static final int CAMERA_PIC_REQUEST = 1111;
    private ImageView imageView;
    private final int requestCode = 20;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pic_layout);
      // Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
       //setSupportActionBar(toolbar);
        liner1=(LinearLayout)findViewById(R.id.layout_liniar22);
        liner2=(LinearLayout)findViewById(R.id.layout_liniar23);
        //liner1.setVisibility(View.GONE);
       // liner2.setVisibility(View.GONE);
        spinner_out = (Spinner)findViewById(R.id.spinner_outtype);
        btn_next=(Button)findViewById(R.id.btnReg);

        btn_next.setOnClickListener(this);


        btn_prev=(Button)findViewById(R.id.btnLogin);
        btn_prev.setOnClickListener(this);

        btn_new=(Button)findViewById(R.id.btnnewpic);
        btn_new.setOnClickListener(this);

        btn_sql=(Button)findViewById(R.id.btnsql);
        btn_sql.setOnClickListener(this);

        imageView = (ImageView)this.findViewById(R.id.img_logo);

        List<String> list = new ArrayList<String>();
        list.add("School");
        list.add("Hospital");
        list.add("Park");
        list.add("ShoppingCenter_Mall");

     /*  ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, list);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);//(R.layout.outlet_spinner_layout);
        spinner_out.setAdapter(dataAdapter);*/



        //Group Option One Click
       /* RadioGroup rg = (RadioGroup) findViewById(R.id.radioLang);
        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
        {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId)
            {
                switch(checkedId)
                {
                    case R.id.radioAr:
                        // TODO Something
                        //Toast.makeText(getApplicationContext(),"1",Toast.LENGTH_LONG).show();
                        liner1.setVisibility(View.GONE);
                        liner2.setVisibility(View.GONE);
                        break;
                    case R.id.radioEn:
                        // TODO Something
                       // Toast.makeText(getApplicationContext(),"2",Toast.LENGTH_LONG).show();
                        liner1.setVisibility(View.VISIBLE);
                        liner2.setVisibility(View.VISIBLE);
                        break;

                }
            }
        });*/
        //

        /*FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
   protected void onActivityResult(int requestCode, int resultCode, Intent data) {
       /* if (requestCode == CAMERA_REQUEST && resultCode == Activity.RESULT_OK) {
            Bitmap photo = (Bitmap) data.getExtras().get("data");
            imageView.setImageBitmap(photo);
        }*/

       if (requestCode == CAMERA_REQUEST && resultCode == RESULT_OK)
        {
           Bitmap photo = (Bitmap) data.getExtras().get("data");
           imageView.setImageBitmap(photo);
           MediaStore.Images.Media.insertImage(getContentResolver(), photo,
                  null, null);

          /*ByteArrayOutputStream baos = new ByteArrayOutputStream();
           photo.compress(Bitmap.CompressFormat.JPEG, 100, baos);
           byte[] b = baos.toByteArray();*/

            try {
            File outFile = new File(Environment.getExternalStorageDirectory(), "new-photo-name123.jpg");
            FileOutputStream fos = new FileOutputStream(outFile);
            photo.compress(Bitmap.CompressFormat.JPEG, 100, fos);

            fos.flush();

                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }


            /*File outFile = new File(Environment.getExternalStorageDirectory(), "myname.jpeg");
            FileOutputStream fos = null;
            try {
                fos = new FileOutputStream(outFile);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            photo.compress(Bitmap.CompressFormat.JPEG, 100, fos);
            try {
                fos.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }*/

        }
   }
    protected void onActivityResultNOOUT(int requestCode, int resultCode, Intent data) {
        if (requestCode == CAMERA_PIC_REQUEST) {
            //2
            Bitmap thumbnail = (Bitmap) data.getExtras().get("data");
            imageView.setImageBitmap(thumbnail);
            //3
            ByteArrayOutputStream bytes = new ByteArrayOutputStream();
            thumbnail.compress(Bitmap.CompressFormat.JPEG, 100, bytes);
            //4
            File file = new File(Environment.getExternalStorageDirectory()+File.separator + "image.jpg");
            try {
                file.createNewFile();
                FileOutputStream fo = new FileOutputStream(file);
                //5
                fo.write(bytes.toByteArray());
                fo.close();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

     //  protected void onActivityResult(int requestCode, int resultCode, Intent data) {
     //      super.onActivityResult(requestCode, resultCode, data);
     //      if(this.requestCode == requestCode && resultCode == RESULT_OK){
     //          Bitmap bitmap = (Bitmap)data.getExtras().get("data");

      //         String partFilename = currentDateFormat();
     //          storeCameraPhotoInSDCard(bitmap, partFilename);

               // display the image from SD Card to ImageView Control
     //          String storeFilename = "photo_" + partFilename + ".jpg";
     //          Bitmap mBitmap = getImageFileFromSDCard(storeFilename);
     //          imageView.setImageBitmap(mBitmap);
     //      }
     //  }

    private String currentDateFormat(){
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd_HH_mm_ss");
        String  currentTimeStamp = dateFormat.format(new Date());
        return currentTimeStamp;
    }

    private void storeCameraPhotoInSDCard(Bitmap bitmap, String currentDate){
        File outputFile = new File(Environment.getExternalStorageDirectory(), "photo_" + currentDate + ".jpg");
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(outputFile);
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, fileOutputStream);
            fileOutputStream.flush();
            fileOutputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private Bitmap getImageFileFromSDCard(String filename){
        Bitmap bitmap = null;
        File imageFile = new File(Environment.getExternalStorageDirectory() + filename);
        try {
            FileInputStream fis = new FileInputStream(imageFile);
            bitmap = BitmapFactory.decodeStream(fis);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return bitmap;
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.btnReg: {
                // do something for button 2 click
                //new loginAccess().execute();
                //Intent intent = new Intent (getApplicationContext(), VotingPopoup.class);
                //intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                //startActivity(intent);
               // liner1.setVisibility(View.VISIBLE);
               // liner2.setVisibility(View.VISIBLE);
                //Toast.makeText(getApplicationContext(),"You need to restart Go taxi Applicatoin.", Toast.LENGTH_SHORT).show();
                // finish();
               // Intent intent = new Intent (getApplicationContext(), ActivityQ2.class);
                //intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
               // startActivity(intent);

               // Intent cameraIntent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
                //startActivityForResult(cameraIntent, CAMERA_REQUEST);

              Intent cameraIntent = new Intent(
                        android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
                cameraIntent.putExtra(MediaStore.EXTRA_OUTPUT,
                        MediaStore.Images.Media.EXTERNAL_CONTENT_URI.getPath());
                cameraIntent.putExtra(MediaStore.EXTRA_OUTPUT, "new-photo-name123.jpg");
                startActivityForResult(cameraIntent, CAMERA_REQUEST);


               /* Intent intent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intent, CAMERA_PIC_REQUEST);*/

              //  Intent photoCaptureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
               // startActivityForResult(photoCaptureIntent, requestCode);

                break;
            }
            case R.id.btnLogin: {
                // do something for button 2 click
            //GetPicActivityNew
                Intent intent = new Intent(getApplicationContext(), LocationActivity.class);
               // intent.setFlags(Intent.FLAG_ACTIVITY_PREVIOUS_IS_TOP |intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                //intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                break;
            }
            case R.id.btnnewpic: {
                // do something for button 2 click
                //GetPicActivityNew
                Intent intent = new Intent(getApplicationContext(), PhotoIntentActivity.class);
                // intent.setFlags(Intent.FLAG_ACTIVITY_PREVIOUS_IS_TOP |intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                //intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                break;
            }
            case R.id.btnsql: {
                // do something for button 2 click
                //GetPicActivityNew
                //SQLiteActivity
                //SpinnerMultiActivity
                Intent intent = new Intent(getApplicationContext(), SQLiteActivity.class);
                // intent.setFlags(Intent.FLAG_ACTIVITY_PREVIOUS_IS_TOP |intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                //intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                break;
            }
	        /*case R.id.btnvote_final: {
	            // do something for button 2 click


	            break;
	        }

	        case R.id.btnReg: {

	            break;
	        }*/
            //.... etc
        }
    }
}
