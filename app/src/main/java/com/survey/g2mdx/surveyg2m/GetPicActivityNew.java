package com.survey.g2mdx.surveyg2m;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.net.Uri;
import android.os.AsyncTask;
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
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class GetPicActivityNew extends AppCompatActivity implements View.OnClickListener , LocationListener {
    Spinner spinner_out;
    Button btn_next,btn_prev;
    LinearLayout liner1,liner2;
    private static final int CAMERA_REQUEST = 1888;
    private static final int CAMERA_PIC_REQUEST = 1111;
    private ImageView imageView;
    private final int requestCode = 20;

    final static int CAPTURE_IMAGE_ACTIVITY_REQUEST_CODE = 1;

    private String provider;
    Uri imageUri                      = null;

    public  static ImageView showImg  = null;
    GetPicActivityNew CameraActivity;

    private LocationManager locationManager;

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

        imageView = (ImageView)this.findViewById(R.id.img_logo);

        List<String> list = new ArrayList<String>();
        list.add("School");
        list.add("Hospital");
        list.add("Park");
        list.add("ShoppingCenter_Mall");



        Criteria criteria = new Criteria();
       provider = locationManager.getBestProvider(criteria, false);
       //Location location = locationManager.getLastKnownLocation(provider);

        // Initialize the location fields
      /*  if (location != null) {
            System.out.println("Provider " + provider + " has been selected.");
            onLocationChanged(location);
        } else {
           // latituteField.setText("Location not available");
            //longitudeField.setText("Location not available");
        }*/

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
   protected void onActivityResultOK(int requestCode, int resultCode, Intent data) {
       /* if (requestCode == CAMERA_REQUEST && resultCode == Activity.RESULT_OK) {
            Bitmap photo = (Bitmap) data.getExtras().get("data");
            imageView.setImageBitmap(photo);
        }*/

       if (requestCode == CAMERA_REQUEST && resultCode == RESULT_OK)
        {
           Bitmap photo = (Bitmap) data.getExtras().get("data");
           imageView.setImageBitmap(photo);
         //  MediaStore.Images.Media.insertImage(getContentResolver(), photo,
             //     null, null);

           // MediaStore.Images.Media.insertImage(getContentResolver(), photo,
            //       null, null);





            String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
            String imageFileName = "Image_" + timeStamp + "_";

            String extStorageDirectory = Environment.getExternalStorageDirectory().toString();
            OutputStream outStream = null;
            // String temp = null;
            File file = new File(extStorageDirectory, imageFileName+".png");


           // File mediaFile = new File(mediaStorageDir.getPath() + File.separator   + "IMG_" + timeStamp + ".jpg");

            try {
                outStream = new FileOutputStream(file);
                photo.compress(Bitmap.CompressFormat.PNG, 100, outStream);
                outStream.flush();
                outStream.close();

            } catch (Exception e) {
                e.printStackTrace();

            }




          /*ByteArrayOutputStream baos = new ByteArrayOutputStream();
           photo.compress(Bitmap.CompressFormat.JPEG, 100, baos);
           byte[] b = baos.toByteArray();*/

           /* try {
            File outFile = new File(Environment.getExternalStorageDirectory(), "new-photo-name123.jpg");
            FileOutputStream fos = new FileOutputStream(outFile);
            photo.compress(Bitmap.CompressFormat.JPEG, 100, fos);

            fos.flush();

                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }*/


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
    protected void onActivityResult777777777777777777777(int requestCode, int resultCode, Intent data) {
        if (requestCode == CAMERA_PIC_REQUEST) {
            //2
            Bitmap thumbnail = (Bitmap) data.getExtras().get("data");
            imageView.setImageBitmap(thumbnail);
            //3
            ByteArrayOutputStream bytes = new ByteArrayOutputStream();
            thumbnail.compress(Bitmap.CompressFormat.JPEG, 100, bytes);
            //4
            File file = new File(Environment.getExternalStorageDirectory()+File.separator + "OSimage.jpg");
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
    protected void onActivityResult( int requestCode, int resultCode, Intent data)
    {
        if ( requestCode == CAPTURE_IMAGE_ACTIVITY_REQUEST_CODE) {

            if ( resultCode == RESULT_OK) {

                /*********** Load Captured Image And Data Start ****************/

                String imageId = convertImageUriToFile( imageUri,CameraActivity);


                //  Create and excecute AsyncTask to load capture image

                new LoadImagesFromSDCard().execute(""+imageId);

                /*********** Load Captured Image And Data End ****************/


            } else if ( resultCode == RESULT_CANCELED) {

                Toast.makeText(this, " Picture was not taken ", Toast.LENGTH_SHORT).show();
            } else {

                Toast.makeText(this, " Picture was not taken ", Toast.LENGTH_SHORT).show();
            }
        }
    }


    /************ Convert Image Uri path to physical path **************/

    public static String convertImageUriToFile ( Uri imageUri, Activity activity )  {

        Cursor cursor = null;
        int imageID = 0;

        try {

            /*********** Which columns values want to get *******/
            String [] proj={
                    MediaStore.Images.Media.DATA,
                    MediaStore.Images.Media._ID,
                    MediaStore.Images.Thumbnails._ID,
                    MediaStore.Images.ImageColumns.ORIENTATION
            };

            cursor = activity.managedQuery(

                    imageUri,         //  Get data for specific image URI
                    proj,             //  Which columns to return
                    null,             //  WHERE clause; which rows to return (all rows)
                    null,             //  WHERE clause selection arguments (none)
                    null              //  Order-by clause (ascending by name)

            );

            //  Get Query Data

            int columnIndex = cursor.getColumnIndexOrThrow(MediaStore.Images.Media._ID);
            int columnIndexThumb = cursor.getColumnIndexOrThrow(MediaStore.Images.Thumbnails._ID);
            int file_ColumnIndex = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);

            //int orientation_ColumnIndex = cursor.
            //    getColumnIndexOrThrow(MediaStore.Images.ImageColumns.ORIENTATION);

            int size = cursor.getCount();

            /*******  If size is 0, there are no images on the SD Card. *****/

            if (size == 0) {


               // imageDetails.setText("No Image");
            }
            else
            {

                int thumbID = 0;
                if (cursor.moveToFirst()) {

                    /**************** Captured image details ************/

                    /*****  Used to show image on view in LoadImagesFromSDCard class ******/
                    imageID     = cursor.getInt(columnIndex);

                    thumbID     = cursor.getInt(columnIndexThumb);

                    String Path = cursor.getString(file_ColumnIndex);

                    //String orientation =  cursor.getString(orientation_ColumnIndex);

                    String CapturedImageDetails = " CapturedImageDetails : \n\n"
                            +" ImageID :"+imageID+"\n"
                            +" ThumbID :"+thumbID+"\n"
                            +" Path :"+Path+"\n";

                    // Show Captured Image detail on activity
                   // imageDetails.setText( CapturedImageDetails );

                }
            }
        } finally {
            if (cursor != null) {
                cursor.close();
            }
        }

        // Return Captured Image ImageID ( By this ImageID Image will load from sdcard )

        return ""+imageID;
    }

    @Override
    public void onLocationChanged(Location location) {
        int lat = (int) (location.getLatitude());
        int lng = (int) (location.getLongitude());
    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {

    }

    @Override
    public void onProviderEnabled(String provider) {

    }

    @Override
    public void onProviderDisabled(String provider) {

    }


    /**
     * Async task for loading the images from the SD card.
     *
     * @author Android Example
     *
     */

    // Class with extends AsyncTask class

    public class LoadImagesFromSDCard  extends AsyncTask<String, Void, Void> {

        private ProgressDialog Dialog = new ProgressDialog(GetPicActivityNew.this);

        Bitmap mBitmap;

        protected void onPreExecute() {
            /****** NOTE: You can call UI Element here. *****/

            // Progress Dialog
            Dialog.setMessage(" Loading image from Sdcard..");
            Dialog.show();
        }


        // Call after onPreExecute method
        protected Void doInBackground(String... urls) {

            Bitmap bitmap = null;
            Bitmap newBitmap = null;
            Uri uri = null;


            try {

                /**  Uri.withAppendedPath Method Description
                 * Parameters
                 *    baseUri  Uri to append path segment to
                 *    pathSegment  encoded path segment to append
                 * Returns
                 *    a new Uri based on baseUri with the given segment appended to the path
                 */

                uri = Uri.withAppendedPath(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, "" + urls[0]);

                /**************  Decode an input stream into a bitmap. *********/
                bitmap = BitmapFactory.decodeStream(getContentResolver().openInputStream(uri));

                if (bitmap != null) {

                    /********* Creates a new bitmap, scaled from an existing bitmap. ***********/

                    newBitmap = Bitmap.createScaledBitmap(bitmap, 170, 170, true);

                    bitmap.recycle();

                    if (newBitmap != null) {

                        mBitmap = newBitmap;
                    }
                }
            } catch (IOException e) {
                // Error fetching image, try to recover

                /********* Cancel execution of this task. **********/
                cancel(true);
            }

            return null;
        }


        protected void onPostExecute(Void unused) {

            // NOTE: You can call UI Element here.

            // Close progress dialog
            Dialog.dismiss();

            if(mBitmap != null)
            {
                // Set Image to ImageView

                showImg.setImageBitmap(mBitmap);
            }

        }

    }
    protected void onActivityResultNO(int requestCode, int resultCode, Intent data) {
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

                //LASTLASTLAST
             /*Intent cameraIntent = new Intent(
                        MediaStore.ACTION_IMAGE_CAPTURE);
                cameraIntent.putExtra(MediaStore.EXTRA_OUTPUT,
                        MediaStore.Images.Media.EXTERNAL_CONTENT_URI.getPath());
                cameraIntent.putExtra(MediaStore.EXTRA_OUTPUT, "new-photo-name123.jpg");
                startActivityForResult(cameraIntent, CAMERA_REQUEST);*/


                //LASTLASTLAST

/*************************** Camera Intent Start ************************/

                // Define the file-name to save photo taken by Camera activity

                String fileName = "Camera_Example.jpg";

                // Create parameters for Intent with filename

                ContentValues values = new ContentValues();

                values.put(MediaStore.Images.Media.TITLE, fileName);

                values.put(MediaStore.Images.Media.DESCRIPTION,"Image capture by camera");

                // imageUri is the current activity attribute, define and save it for later usage

                imageUri = getContentResolver().insert(
                        MediaStore.Images.Media.EXTERNAL_CONTENT_URI, values);

                /**** EXTERNAL_CONTENT_URI : style URI for the "primary" external storage volume. ****/


                // Standard Intent action that can be sent to have the camera
                // application capture an image and return it.

                Intent intent = new Intent( MediaStore.ACTION_IMAGE_CAPTURE );

                intent.putExtra(MediaStore.EXTRA_OUTPUT, imageUri);

                intent.putExtra(MediaStore.EXTRA_VIDEO_QUALITY, 1);

                startActivityForResult( intent, CAPTURE_IMAGE_ACTIVITY_REQUEST_CODE);

                /*************************** Camera Intent End ************************/

               /* Intent intent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intent, CAMERA_PIC_REQUEST);*/

              //  Intent photoCaptureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
               // startActivityForResult(photoCaptureIntent, requestCode);












                //**********************************************************

                //**********************************************************


                break;
            }
            case R.id.btnLogin: {
                // do something for button 2 click

                Intent intent = new Intent(getApplicationContext(), ActivityQ2.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_PREVIOUS_IS_TOP |intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
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
