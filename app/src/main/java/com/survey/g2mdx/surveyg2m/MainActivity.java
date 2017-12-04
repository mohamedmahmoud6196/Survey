package com.survey.g2mdx.surveyg2m;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener,MultiSelectionSpinner.OnMultipleItemsSelectedListener {
    Spinner spinner_out,spinner_rural,spinner_signage,spinner_size,spinner_street,spinner_area;
    Button btn_next;
    Typeface tfont;
    TextView txtcname,txtaddress,txtcustype,txtdatacoll,txtrural,txtsignage,txtsize,txtcontname,txt_cont_tel_edit;
    TextView txtonwer,txtownername,txtownertel,txtmultiv1,txtmultiv2,txtstreet,txtarea;
    LinearLayout liner1,liner_branch;
    EditText txt_owner_edit,txtbranchname;
    String[] spinnerarray = {"مدرسة", "مسجد", "كنيسة", "مستشفى", "سوق قديم", "عيادة", "جامعة او كلية", "نادى رياضى", "مول او مركز تسوق", "حديقة"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_surv1);
       // Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);

       // getWindow().getDecorView().setLayoutDirection(View.LAYOUT_DIRECTION_RTL);
       // OR PUT IT IN XML DESIGN android:layoutDirection="rtl"
       /* String manufacturer = Build.MANUFACTURER;
        String model = Build.MODEL;
        int version = Build.VERSION.SDK_INT;
        String versionRelease = Build.VERSION.RELEASE;


        Toast.makeText(getApplicationContext(), "manufacturer " + manufacturer
                + " \n model " + model
                + " \n version " + version
                + " \n versionRelease " + versionRelease,Toast.LENGTH_LONG
        ).show();*/


        //String fontPath = "fonts/DroidKufi-Bold.ttf";
       // String fontPath = "fonts/DroidKufi-Regular.ttf";
        //String fontPath = "fonts/DroidNaskh-Regular.ttf";
        //String fontPath = "fonts/TraditionalArabic-Regular.ttf";
        //String fontPath = "fonts/DroidSansArabic.ttf";
        String fontPath = "fonts/Hacen_Saudi_Arabia.ttf";

        tfont = Typeface.createFromAsset(getBaseContext().getAssets(), fontPath);


        //MULTI SELECT SPINNER///////////////////////////////////////////////
        MultiSelectionSpinner multiSelectionSpinner = (MultiSelectionSpinner) findViewById(R.id.mySpinner);
        multiSelectionSpinner.setItems(spinnerarray);
       // multiSelectionSpinner.setSelection(new int[]{2, 6});
        multiSelectionSpinner.setListener(this);
        //MULTI SELECT SPINNER///////////////////////////////////////////////
        spinner_out = (Spinner)findViewById(R.id.spinner_outtype);
        spinner_rural=(Spinner)findViewById(R.id.spinner_rural);
        spinner_signage=(Spinner)findViewById(R.id.spinner_signage);
        spinner_size=(Spinner)findViewById(R.id.spinner_size);
        spinner_street=(Spinner)findViewById(R.id.spinner_street);
        spinner_area=(Spinner)findViewById(R.id.spinner_area);

        liner1=(LinearLayout)findViewById(R.id.lay_owner_view);
        liner_branch=(LinearLayout)findViewById(R.id.lay_branchname);

        btn_next=(Button)findViewById(R.id.btnReg);
        btn_next.setOnClickListener( this);

        txtcname=(TextView)findViewById(R.id.txt_pickup_point) ;
        txtaddress=(TextView)findViewById(R.id.txt_booking_date) ;
        txtcustype=(TextView)findViewById(R.id.txt_drop_point) ;
        txtdatacoll=(TextView)findViewById(R.id.txt_data_collect) ;
        txtrural=(TextView)findViewById(R.id.txt_rural) ;
        txtsignage=(TextView)findViewById(R.id.txt_signage) ;
        txtsize=(TextView)findViewById(R.id.txt_size) ;
        txtcontname=(TextView)findViewById(R.id.txt_cont_name) ;
        txt_cont_tel_edit=(TextView)findViewById(R.id.txt_cont_tel) ;
        txtonwer=(TextView)findViewById(R.id.txt_owner) ;
        txtownername=(TextView)findViewById(R.id.txt_owner_name) ;
        txtownertel=(TextView)findViewById(R.id.txt_owner_tel) ;
        txt_owner_edit=(EditText)findViewById(R.id.txt_owner_edit);
        txtbranchname=(EditText)findViewById(R.id.txt_branch_edit);
        txtmultiv1=(TextView)findViewById(R.id.txt_multi_view) ;
        txtmultiv2=(TextView)findViewById(R.id.txt_multi_name) ;
        txtstreet=(TextView)findViewById(R.id.txt_streev) ;
        txtarea=(TextView)findViewById(R.id.txt_area) ;


        TextView txtbranchv=(TextView)findViewById(R.id.txt_branchv1) ;
        TextView txt_branch_name=(TextView)findViewById(R.id.txt_branch_name) ;

        RadioButton dataop1=(RadioButton)findViewById(R.id.datacol1);
        RadioButton dataop2=(RadioButton)findViewById(R.id.datacol2);
        RadioButton dataop3=(RadioButton)findViewById(R.id.datacol3);
        RadioButton opowner1=(RadioButton)findViewById(R.id.opowner1);
        RadioButton opowner2=(RadioButton)findViewById(R.id.opowner2);


        txtcname.setTypeface(tfont,Typeface.BOLD);
        txtaddress.setTypeface(tfont,Typeface.BOLD);
        txtcustype.setTypeface(tfont,Typeface.BOLD);
        txtdatacoll.setTypeface(tfont,Typeface.BOLD);
        txtrural.setTypeface(tfont,Typeface.BOLD);
        txtsignage.setTypeface(tfont,Typeface.BOLD);
        txtsize.setTypeface(tfont,Typeface.BOLD);
        txtcontname.setTypeface(tfont,Typeface.BOLD);
        txt_cont_tel_edit.setTypeface(tfont,Typeface.BOLD);
        txtonwer.setTypeface(tfont,Typeface.BOLD);
        txtbranchv.setTypeface(tfont,Typeface.BOLD);
        txt_branch_name.setTypeface(tfont,Typeface.BOLD);
        txtownername.setTypeface(tfont,Typeface.BOLD);
        txtownertel.setTypeface(tfont,Typeface.BOLD);
        txtmultiv1.setTypeface(tfont,Typeface.BOLD);
        txtmultiv2.setTypeface(tfont,Typeface.BOLD);
        txtstreet.setTypeface(tfont,Typeface.BOLD);
        txtarea.setTypeface(tfont,Typeface.BOLD);

        dataop1.setTypeface(tfont,Typeface.BOLD);
        dataop2.setTypeface(tfont,Typeface.BOLD);
        dataop3.setTypeface(tfont,Typeface.BOLD);
        opowner1.setTypeface(tfont,Typeface.BOLD);
        opowner2.setTypeface(tfont,Typeface.BOLD);

        liner1.setVisibility(View.GONE);
        liner_branch.setVisibility(View.GONE);

        List<String> list = new ArrayList<String>();
        list.add("كشك");
        list.add("باقله");
        list.add("محل");
        list.add("هايبر");
        list.add("محل سجائر و دخان فقط");


        List<String> list2 = new ArrayList<String>();
        list2.add("حضر");
        list2.add("ريف");

        List<String> list3 = new ArrayList<String>();
        list3.add("عربى");
        list3.add("انجليزى");
        list3.add("اللغتين");
        list3.add("لاتوجد يافطة");

        List<String> list4 = new ArrayList<String>();
        list4.add("اقل من 10");
        list4.add("بين 10 و 20");
        list4.add("بين 20 و 40");
        list4.add("بين 40 و 100 ");
        list4.add("اكتر من 100");

        List<String> list5 = new ArrayList<String>();
        list5.add("شارع رئيسى");
        list5.add("شارع فرعى");
        list5.add("حارة");
        list5.add("طريق سريع");
        list5.add("ميدان");

        List<String> list6 = new ArrayList<String>();
        list6.add("منطقة سكنية");
        list6.add("منطقة صناعية");
        list6.add("منطقة سياحية");


        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, list);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);//(R.layout.outlet_spinner_layout);
        spinner_out.setAdapter(dataAdapter);


        ArrayAdapter<String> dataAdapter2 = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, list2);
        dataAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);//(R.layout.outlet_spinner_layout);
        spinner_rural.setAdapter(dataAdapter2);

        ArrayAdapter<String> dataAdapter3 = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, list3);
        dataAdapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);//(R.layout.outlet_spinner_layout);
        spinner_signage.setAdapter(dataAdapter3);


        ArrayAdapter<String> dataAdapter4 = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, list4);
        dataAdapter4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);//(R.layout.outlet_spinner_layout);
        spinner_size.setAdapter(dataAdapter4);

        ArrayAdapter<String> dataAdapter5 = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, list5);
        dataAdapter5.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);//(R.layout.outlet_spinner_layout);
        spinner_street.setAdapter(dataAdapter5);

        ArrayAdapter<String> dataAdapter6 = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, list6);
        dataAdapter6.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);//(R.layout.outlet_spinner_layout);
        spinner_area.setAdapter(dataAdapter6);



        spinner_out.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {


               // ((TextView) parent.getChildAt(0)).setTextColor(Color.WHITE);
               // ((TextView) parent.getChildAt(0)).setTypeface(tfont,Typeface.BOLD);

                //((TextView) parent.getChildAt(0)).setTextSize(TypedValue.COMPLEX_UNIT_SP,15);

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        //Group Option One Click
        RadioGroup rg = (RadioGroup) findViewById(R.id.opowner_gr);
        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
        {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId)
            {
                switch(checkedId)
                {
                    case R.id.opowner1:
                        // TODO Something
                        //Toast.makeText(getApplicationContext(),"1",Toast.LENGTH_LONG).show();
                        liner1.setVisibility(View.GONE);

                        break;
                    case R.id.opowner2:
                        // TODO Something
                        // Toast.makeText(getApplicationContext(),"2",Toast.LENGTH_LONG).show();
                        liner1.setVisibility(View.VISIBLE);

                      /*  txt_owner_edit.post(new Runnable() {
                            public void run() {
                                txt_owner_edit.requestFocusFromTouch();
                                InputMethodManager lManager = (InputMethodManager).getSystemService(Context.INPUT_METHOD_SERVICE);
                                lManager.showSoftInput(txt_owner_edit, 0);
                            }
                        });*/

                        txt_owner_edit.post(new Runnable() {
                            @Override
                            public void run() {
                                txt_owner_edit.requestFocus();
                               // field.onKeyUp(KeyEvent.KEYCODE_DPAD_CENTER, new KeyEvent(KeyEvent.ACTION_UP, KeyEvent.KEYCODE_DPAD_CENTER));
                            }
                        });

                        break;


                }
            }
        });

        RadioGroup branchgr = (RadioGroup) findViewById(R.id.branchgr);
        branchgr.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
        {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId)
            {
                switch(checkedId)
                {
                    case R.id.branchop1:
                        // TODO Something
                        //Toast.makeText(getApplicationContext(),"1",Toast.LENGTH_LONG).show();
                        liner_branch.setVisibility(View.VISIBLE);

                        txt_owner_edit.post(new Runnable() {
                            @Override
                            public void run() {
                                txtbranchname.requestFocus();
                                // field.onKeyUp(KeyEvent.KEYCODE_DPAD_CENTER, new KeyEvent(KeyEvent.ACTION_UP, KeyEvent.KEYCODE_DPAD_CENTER));
                            }
                        });

                        break;
                    case R.id.branchop2:
                        // TODO Something
                        // Toast.makeText(getApplicationContext(),"2",Toast.LENGTH_LONG).show();
                        liner_branch.setVisibility(View.GONE);

                        break;


                }
            }
        });
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

    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.btnReg: {
                // do something for button 2 click
                //new loginAccess().execute();
                //Intent intent = new Intent (getApplicationContext(), VotingPopoup.class);
                //intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                //startActivity(intent);


               // Toast.makeText(getApplicationContext(),"You need to restart Go taxi Applicatoin.", Toast.LENGTH_SHORT).show();
               // finish();
                Intent intent = new Intent (getApplicationContext(), ActivityQ2.class);
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

    @Override
    public void selectedIndices(List<Integer> indices) {

    }

    @Override
    public void selectedStrings(List<String> strings) {
        Toast.makeText(this, strings.toString(), Toast.LENGTH_LONG).show();
    }
}
