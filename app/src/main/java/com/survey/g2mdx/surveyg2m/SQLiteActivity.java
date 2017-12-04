package com.survey.g2mdx.surveyg2m;

import android.app.Activity;
import android.media.MediaScannerConnection;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.widget.Button;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.util.List;


public class SQLiteActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.photo_layout);
        
        final DatabaseHandler db = new DatabaseHandler(this);

        /**
         * CRUD Operations
         * */
        // Inserting Contacts
        Log.d("Insert: ", "Inserting ..");
        db.addContact(new Contact("AHMED", "9100000000"));
        db.addContact(new Contact("Mahmoud", "9199999999"));
        db.addContact(new Contact("Sayed", "9522222222"));
        db.addContact(new Contact("OSAMA", "9533333333"));
        db.addContact(new Contact("اسامه", "953333344444443"));

       final Button btn_sql=(Button)findViewById(R.id.btnIntend);



       /* runOnUiThread(new Runnable() {

            @Override
            public void run() {
                final Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        //add your code here
                        for(int i=0;i<1000;i++)
                        {
                            db.addContact(new Contact("اسامه", "953333344444443"));
                            btn_sql.setText(String.valueOf(i)+" MY LOOP");
                        }
                    }
                }, 1000);

            }
        });*/


        // Reading all contacts
        Log.d("Reading: ", "Reading all contacts..");
        List<Contact> contacts = db.getAllContacts();
 
       /* for (Contact cn : contacts) {
            String log = "Id: "+cn.getID()+" ,Name: " + cn.getName() + " ,Phone: " + cn.getPhoneNumber();
                // Writing Contacts to log
        Log.d("Name: ", log);
            Toast.makeText(getApplicationContext(),log, Toast.LENGTH_LONG).show();

        
        }*/
       // exportDB();
        exportDB();
    }
    private void exportDB(){





        File mediaStorageDir = new File(Environment.getExternalStorageDirectory(), "MydataBK");

        if (!mediaStorageDir.exists()) {
            if (!mediaStorageDir.mkdirs()) {
                Log.d("App", "failed to create directory");
            }
        }
       // File sd = Environment.getExternalStorageDirectory();
        File data = Environment.getDataDirectory();
        FileChannel source=null;
        FileChannel destination=null;
        String currentDBPath = "/data/"+ "com.survey.g2mdx.surveyg2m" +"/databases/"+"contactsManager";
        String backupDBPath = "contactsManager";
        File currentDB = new File(data, currentDBPath);
        //File backupDB = new File(sd, backupDBPath);
        File backupDB = new File(mediaStorageDir, backupDBPath);

        MediaScannerConnection.scanFile(this, new String[] {backupDB.toString()}, null, null);
        try {
            source = new FileInputStream(currentDB).getChannel();
            destination = new FileOutputStream(backupDB).getChannel();
            destination.transferFrom(source, 0, source.size());
            source.close();
            destination.close();
            Toast.makeText(this, "DB Exported!", Toast.LENGTH_LONG).show();
        } catch(IOException e) {
            e.printStackTrace();
            Toast.makeText(this, "DB EROOOOR!" +e.getMessage() , Toast.LENGTH_LONG).show();
        }
    }
}