package com.survey.g2mdx.surveyg2m;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class ActivityQ2 extends AppCompatActivity implements View.OnClickListener {
    Spinner spinner1,spinner2,spinner3,spinner4,spinner5,spinner6;
    Spinner spinner7,spinner8,spinner9,spinner10,spinner11,spinner12;
    Spinner spinner13,spinner14,spinner15, spinner16,spinner17,spinner18;

    Button btn_next,btn_prev;
    LinearLayout liner_retail,liner_retail_sub,liner_car,lay_segar;
    LinearLayout lay_segar_drop,lay_segar_drop2,lay_segar_drop3,lay_segar_drop4,lay_segar_drop5,lay_segar_drop6,lay_segar_drop7,lay_segar_drop8,lay_segar_drop9,lay_segar_drop10,lay_segar_drop11,lay_segar_drop12,lay_segar_drop13,lay_segar_drop14,lay_segar_drop15,lay_segar_drop16,lay_segar_drop17,lay_segar_drop18;
    LinearLayout lay_stick,lay_stick_h,lay_molases,lay_ryo;
    Typeface tfont;
    String[] spinnerarray = {"لا توجد ولاعات", "ماركات (بيك او كريكت او كليبر او دى جيب)", "ماركات غير معروفة ( صينى او تركى)"};
    String[] spinnerarray2 = {"مارلبورو","ميرت","ال ام","نكست","كينت","دنهيل","لاكى سترايك","روثمانز","فايسروى","وينستون","دافيدوف","تايم","كارليا","كليوبترا","سجائرمستوردة","اخرى"};
    CheckBox checktbo1,s_check1,s_check2,s_check3,s_check4,s_check5,s_check6,s_check7;
    CheckBox s_check8,s_check9,s_check10,s_check11,s_check12,s_check13,s_check14,s_check15,s_check16,s_check17,s_check18;
    CheckBox checktbo2,checktop3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_surv2_new);
      // Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
       //setSupportActionBar(toolbar);
       // liner1=(LinearLayout)findViewById(R.id.layout_liniar22);
       // liner2=(LinearLayout)findViewById(R.id.layout_liniar23);
       // liner1.setVisibility(View.GONE);
       // liner2.setVisibility(View.GONE);
      //  spinner_out = (Spinner)findViewById(R.id.spinner_outtype);

        //MULTI SELECT SPINNER///////////////////////////////////////////////
        MultiSelectionSpinner multiSelectionSpinner = (MultiSelectionSpinner) findViewById(R.id.mySpinner);
        multiSelectionSpinner.setItems(spinnerarray);
        // multiSelectionSpinner.setSelection(new int[]{2, 6});
        multiSelectionSpinner.setListener(new MultiSelectionSpinner.OnMultipleItemsSelectedListener() {
            @Override
            public void selectedIndices(List<Integer> indices) {

            }

            @Override
            public void selectedStrings(List<String> strings) {
                Toast.makeText(getApplicationContext(), "Kind1 " + strings.toString(), Toast.LENGTH_LONG).show();
            }
        });
        //MULTI SELECT SPINNER///////////////////////////////////////////////

        //MULTI SELECT SPINNER2///////////////////////////////////////////////
        MultiSelectionSpinner multiSelectionSpinner2 = (MultiSelectionSpinner) findViewById(R.id.spinner_mh);
        multiSelectionSpinner2.setItems(spinnerarray2);
        // multiSelectionSpinner.setSelection(new int[]{2, 6});
        multiSelectionSpinner2.setListener(new MultiSelectionSpinner.OnMultipleItemsSelectedListener() {
            @Override
            public void selectedIndices(List<Integer> indices) {

            }

            @Override
            public void selectedStrings(List<String> strings) {
                Toast.makeText(getApplicationContext(), "Kind2 " + strings.toString(), Toast.LENGTH_LONG).show();
            }
        });
        //MULTI SELECT SPINNER2///////////////////////////////////////////////


        //String fontPath = "fonts/DroidKufi-Bold.ttf";
        // String fontPath = "fonts/DroidKufi-Regular.ttf";
        String fontPath = "fonts/DroidNaskh-Regular.ttf";
        //String fontPath = "fonts/TraditionalArabic-Regular.ttf";
        //String fontPath = "fonts/DroidSansArabic.ttf";

        //String fontPath = "fonts/Hacen_Saudi_Arabia.ttf";

        tfont = Typeface.createFromAsset(getBaseContext().getAssets(), fontPath);
        TextView txt_emp=(TextView)findViewById(R.id.txt_emp);
        txt_emp.setTypeface(tfont,Typeface.BOLD);

        checktbo1=(CheckBox)findViewById(R.id.checktbo1);
        checktbo1.setOnClickListener(this);

        checktbo2=(CheckBox)findViewById(R.id.checktob2);
        checktbo2.setOnClickListener(this);

        checktop3=(CheckBox)findViewById(R.id.checktop3);
        checktop3.setOnClickListener(this);



        s_check1=(CheckBox)findViewById(R.id.s_check1);
        s_check1.setOnClickListener(this);

        s_check2=(CheckBox)findViewById(R.id.s_check2);
        s_check2.setOnClickListener(this);

        s_check3=(CheckBox)findViewById(R.id.s_check3);
        s_check3.setOnClickListener(this);

        s_check4=(CheckBox)findViewById(R.id.s_check4);
        s_check4.setOnClickListener(this);

        s_check5=(CheckBox)findViewById(R.id.s_check5);
        s_check5.setOnClickListener(this);

        s_check6=(CheckBox)findViewById(R.id.s_check6);
        s_check6.setOnClickListener(this);

        s_check7=(CheckBox)findViewById(R.id.s_check7);
        s_check7.setOnClickListener(this);

        s_check8=(CheckBox)findViewById(R.id.s_check8);
        s_check8.setOnClickListener(this);

        s_check9=(CheckBox)findViewById(R.id.s_check9);
        s_check9.setOnClickListener(this);

        s_check10=(CheckBox)findViewById(R.id.s_check10);
        s_check10.setOnClickListener(this);

        s_check11=(CheckBox)findViewById(R.id.s_check11);
        s_check11.setOnClickListener(this);

        s_check12=(CheckBox)findViewById(R.id.s_check12);
        s_check12.setOnClickListener(this);

        s_check13=(CheckBox)findViewById(R.id.s_check13);
        s_check13.setOnClickListener(this);
        s_check14=(CheckBox)findViewById(R.id.s_check14);
        s_check14.setOnClickListener(this);
        s_check15=(CheckBox)findViewById(R.id.s_check15);
        s_check15.setOnClickListener(this);
        s_check16=(CheckBox)findViewById(R.id.s_check16);
        s_check16.setOnClickListener(this);

        s_check17=(CheckBox)findViewById(R.id.s_check17);
        s_check17.setOnClickListener(this);

        s_check18=(CheckBox)findViewById(R.id.s_check18);
        s_check18.setOnClickListener(this);

        btn_next=(Button)findViewById(R.id.btnReg);
        btn_next.setOnClickListener(this);

        btn_prev=(Button)findViewById(R.id.btnLogin);
        btn_prev.setOnClickListener(this);




        liner_retail=(LinearLayout)findViewById(R.id.layout_retail);
        liner_retail_sub=(LinearLayout)findViewById(R.id.lay_retail_sub);
        liner_car=(LinearLayout)findViewById(R.id.lay_owner_view);
        lay_segar=(LinearLayout)findViewById(R.id.lay_segar);
        lay_segar_drop=(LinearLayout)findViewById(R.id.lay_segar_drop);
        lay_segar_drop2=(LinearLayout)findViewById(R.id.lay_segar_drop2);
        lay_segar_drop3=(LinearLayout)findViewById(R.id.lay_segar_drop3);
        lay_segar_drop4=(LinearLayout)findViewById(R.id.lay_segar_drop4);
        lay_segar_drop5=(LinearLayout)findViewById(R.id.lay_segar_drop5);
        lay_segar_drop6=(LinearLayout)findViewById(R.id.lay_segar_drop6);
        lay_segar_drop7=(LinearLayout)findViewById(R.id.lay_segar_drop7);
        lay_segar_drop8=(LinearLayout)findViewById(R.id.lay_segar_drop8);
        lay_segar_drop9=(LinearLayout)findViewById(R.id.lay_segar_drop9);
        lay_segar_drop10=(LinearLayout)findViewById(R.id.lay_segar_drop10);
        lay_segar_drop11=(LinearLayout)findViewById(R.id.lay_segar_drop11);
        lay_segar_drop12=(LinearLayout)findViewById(R.id.lay_segar_drop12);
        lay_segar_drop13=(LinearLayout)findViewById(R.id.lay_segar_drop13);
        lay_segar_drop14=(LinearLayout)findViewById(R.id.lay_segar_drop14);
        lay_segar_drop15=(LinearLayout)findViewById(R.id.lay_segar_drop15);
        lay_segar_drop16=(LinearLayout)findViewById(R.id.lay_segar_drop16);
        lay_segar_drop17=(LinearLayout)findViewById(R.id.lay_segar_drop17);
        lay_segar_drop18=(LinearLayout)findViewById(R.id.lay_segar_drop18);
        lay_stick=(LinearLayout)findViewById(R.id.lay_stick);
        lay_stick_h=(LinearLayout)findViewById(R.id.lay_stick_h);
        lay_molases=(LinearLayout)findViewById(R.id.lay_molasses);
        lay_ryo=(LinearLayout)findViewById(R.id.lay_ryo);

        liner_retail.setVisibility(View.GONE);
        liner_retail_sub.setVisibility(View.GONE);
        liner_car.setVisibility(View.GONE);
        lay_segar.setVisibility(View.GONE);
        lay_segar_drop2.setVisibility(View.GONE);
        lay_segar_drop3.setVisibility(View.GONE);
        lay_segar_drop4.setVisibility(View.GONE);
        lay_segar_drop5.setVisibility(View.GONE);
        lay_segar_drop6.setVisibility(View.GONE);
        lay_segar_drop7.setVisibility(View.GONE);
        lay_segar_drop8.setVisibility(View.GONE);
        lay_segar_drop9.setVisibility(View.GONE);
        lay_segar_drop10.setVisibility(View.GONE);
        lay_segar_drop11.setVisibility(View.GONE);
        lay_segar_drop12.setVisibility(View.GONE);
        lay_segar_drop13.setVisibility(View.GONE);
        lay_segar_drop14.setVisibility(View.GONE);
        lay_segar_drop15.setVisibility(View.GONE);
        lay_segar_drop16.setVisibility(View.GONE);
        lay_segar_drop17.setVisibility(View.GONE);
        lay_segar_drop18.setVisibility(View.GONE);
        lay_segar_drop.setVisibility(View.GONE);
        lay_stick.setVisibility(View.GONE);
        lay_stick_h.setVisibility(View.GONE);
        lay_molases.setVisibility(View.GONE);
        lay_ryo.setVisibility(View.GONE);
        List<String> list = new ArrayList<String>();
        list.add("1 to 5 Packs");
        list.add("6 to 10 Packs");
        list.add("11 to 20 Packs");
        list.add("21 to 30 Packs");
        list.add("31 to 50 Packs");
        list.add("51 to 70 Packs");
        list.add("71 to 100 Packs");



        spinner1 = (Spinner)findViewById(R.id.spinner_sp1);
        spinner2 = (Spinner)findViewById(R.id.spinner_sp2);
        spinner3 = (Spinner)findViewById(R.id.spinner_sp3);
        spinner4 = (Spinner)findViewById(R.id.spinner_sp4);
        spinner5 = (Spinner)findViewById(R.id.spinner_sp5);
        spinner6 = (Spinner)findViewById(R.id.spinner_sp6);
        spinner7 = (Spinner)findViewById(R.id.spinner_sp7);
        spinner8 = (Spinner)findViewById(R.id.spinner_sp8);
        spinner9 = (Spinner)findViewById(R.id.spinner_sp9);
        spinner10 = (Spinner)findViewById(R.id.spinner_sp10);
        spinner11 = (Spinner)findViewById(R.id.spinner_sp11);
        spinner12 = (Spinner)findViewById(R.id.spinner_sp12);
        spinner13 = (Spinner)findViewById(R.id.spinner_sp13);
        spinner14 = (Spinner)findViewById(R.id.spinner_sp14);
        spinner15 = (Spinner)findViewById(R.id.spinner_sp15);
        spinner16 = (Spinner)findViewById(R.id.spinner_sp16);
        spinner17 = (Spinner)findViewById(R.id.spinner_sp17);
        spinner18 = (Spinner)findViewById(R.id.spinner_sp18);

       ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, list);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);//(R.layout.outlet_spinner_layout);
        spinner1.setAdapter(dataAdapter);
        spinner2.setAdapter(dataAdapter);
        spinner3.setAdapter(dataAdapter);
        spinner4.setAdapter(dataAdapter);
        spinner5.setAdapter(dataAdapter);
        spinner6.setAdapter(dataAdapter);
        spinner7.setAdapter(dataAdapter);
        spinner8.setAdapter(dataAdapter);
        spinner9.setAdapter(dataAdapter);
        spinner10.setAdapter(dataAdapter);
        spinner11.setAdapter(dataAdapter);
        spinner12.setAdapter(dataAdapter);
        spinner13.setAdapter(dataAdapter);
        spinner14.setAdapter(dataAdapter);
        spinner15.setAdapter(dataAdapter);
        spinner16.setAdapter(dataAdapter);
        spinner17.setAdapter(dataAdapter);
        spinner18.setAdapter(dataAdapter);



        //Group Option One Click
        RadioGroup rg = (RadioGroup) findViewById(R.id.activgr);
        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
        {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId)
            {
                switch(checkedId)
                {
                    case R.id.activ1:
                        // TODO Something
                        liner_retail.setVisibility(View.GONE);
                        liner_retail_sub.setVisibility(View.GONE);
                        liner_car.setVisibility(View.GONE);
                        break;
                    case R.id.activ2:
                        // TODO Something
                        liner_retail.setVisibility(View.GONE);
                        liner_retail_sub.setVisibility(View.VISIBLE);
                        liner_car.setVisibility(View.GONE);
                        break;
                    case R.id.activ3:
                        // TODO Something
                        liner_retail.setVisibility(View.VISIBLE);
                        liner_retail_sub.setVisibility(View.VISIBLE);
                        liner_car.setVisibility(View.GONE);
                        break;

                }
            }
        });

        RadioGroup retailgr = (RadioGroup) findViewById(R.id.retailgr);
        retailgr.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
        {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId)
            {
                switch(checkedId)
                {
                    case R.id.retail1:
                        // TODO Something
                        liner_car.setVisibility(View.VISIBLE);
                        break;
                    case R.id.retail2:
                        // TODO Something
                        liner_car.setVisibility(View.GONE);
                        break;
                }
            }
        });
        RadioGroup stickgr = (RadioGroup) findViewById(R.id.stickgr);
        stickgr.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
        {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId)
            {
                switch(checkedId)
                {
                    case R.id.stickop1:
                        // TODO Something
                        lay_stick_h.setVisibility(View.VISIBLE);
                        break;
                    case R.id.stickop2:
                        // TODO Something
                        lay_stick_h.setVisibility(View.GONE);
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
               // liner1.setVisibility(View.VISIBLE);
                //liner2.setVisibility(View.VISIBLE);
                //Toast.makeText(getApplicationContext(),"You need to restart Go taxi Applicatoin.", Toast.LENGTH_SHORT).show();
                // finish();
                Intent intent = new Intent(getApplicationContext(), ActivityQ3.class);
                //intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                intent.setFlags(Intent.FLAG_ACTIVITY_PREVIOUS_IS_TOP |intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                startActivity(intent);
                break;
            }
            case R.id.btnLogin: {
                // do something for button 2 click
                //Toast.makeText(getApplicationContext(),"You need to restart Go taxi Applicatoin.", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_PREVIOUS_IS_TOP |intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                //intent.setFlags(Intent.FLAG_ACTIVITY_EXCLUDE_FROM_RECENTS);
               // intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
                break;
            }
            case R.id.checktbo1: {
                // do something for button 2 click
                if(checktbo1.isChecked())
                {
                    lay_segar.setVisibility(View.VISIBLE);
                    lay_stick.setVisibility(View.VISIBLE);
                }else
                {
                    lay_segar.setVisibility(View.GONE);
                    lay_stick.setVisibility(View.GONE);
                }
                break;
            }
            case R.id.s_check1: {
                // do something for button 2 click
                if(s_check1.isChecked())
                {
                    lay_segar_drop.setVisibility(View.VISIBLE);
                }else
                {
                    lay_segar_drop.setVisibility(View.GONE);
                }
                break;
            }
            case R.id.s_check2: {
                // do something for button 2 click
                if(s_check2.isChecked())
                {
                    lay_segar_drop2.setVisibility(View.VISIBLE);
                }else
                {
                    lay_segar_drop2.setVisibility(View.GONE);
                }
                break;
            }
            case R.id.s_check3: {
                // do something for button 2 click
                if(s_check3.isChecked())
                {
                    lay_segar_drop3.setVisibility(View.VISIBLE);
                }else
                {
                    lay_segar_drop3.setVisibility(View.GONE);
                }
                break;
            }
            case R.id.s_check4: {
                // do something for button 2 click
                if(s_check4.isChecked())
                {
                    lay_segar_drop4.setVisibility(View.VISIBLE);
                }else
                {
                    lay_segar_drop4.setVisibility(View.GONE);
                }
                break;
            }
            case R.id.s_check5: {
                // do something for button 2 click
                if(s_check5.isChecked())
                {
                    lay_segar_drop5.setVisibility(View.VISIBLE);
                }else
                {
                    lay_segar_drop5.setVisibility(View.GONE);
                }
                break;
            }
            case R.id.s_check6: {
                // do something for button 2 click
                if(s_check6.isChecked())
                {
                    lay_segar_drop6.setVisibility(View.VISIBLE);
                }else
                {
                    lay_segar_drop6.setVisibility(View.GONE);
                }
                break;
            }
            case R.id.s_check7: {
                // do something for button 2 click
                if(s_check7.isChecked())
                {
                    lay_segar_drop7.setVisibility(View.VISIBLE);
                }else
                {
                    lay_segar_drop7.setVisibility(View.GONE);
                }
                break;
            }
            case R.id.s_check8: {
                // do something for button 2 click
                if(s_check8.isChecked())
                {
                    lay_segar_drop8.setVisibility(View.VISIBLE);
                }else
                {
                    lay_segar_drop8.setVisibility(View.GONE);
                }
                break;
            }
            case R.id.s_check9: {
                // do something for button 2 click
                if(s_check9.isChecked())
                {
                    lay_segar_drop9.setVisibility(View.VISIBLE);
                }else
                {
                    lay_segar_drop9.setVisibility(View.GONE);
                }
                break;
            }
            case R.id.s_check10: {
                // do something for button 2 click
                if(s_check10.isChecked())
                {
                    lay_segar_drop10.setVisibility(View.VISIBLE);
                }else
                {
                    lay_segar_drop10.setVisibility(View.GONE);
                }
                break;
            }
            case R.id.s_check11: {
                // do something for button 2 click
                if(s_check11.isChecked())
                {
                    lay_segar_drop11.setVisibility(View.VISIBLE);
                }else
                {
                    lay_segar_drop11.setVisibility(View.GONE);
                }
                break;
            }
            case R.id.s_check12: {
                // do something for button 2 click
                if(s_check12.isChecked())
                {
                    lay_segar_drop12.setVisibility(View.VISIBLE);
                }else
                {
                    lay_segar_drop12.setVisibility(View.GONE);
                }
                break;
            }
            case R.id.s_check13: {
                // do something for button 2 click
                if(s_check13.isChecked())
                {
                    lay_segar_drop13.setVisibility(View.VISIBLE);
                }else
                {
                    lay_segar_drop13.setVisibility(View.GONE);
                }
                break;
            }
            case R.id.s_check14: {
                // do something for button 2 click
                if(s_check14.isChecked())
                {
                    lay_segar_drop14.setVisibility(View.VISIBLE);
                }else
                {
                    lay_segar_drop14.setVisibility(View.GONE);
                }
                break;
            }
            case R.id.s_check15: {
                // do something for button 2 click
                if(s_check15.isChecked())
                {
                    lay_segar_drop15.setVisibility(View.VISIBLE);
                }else
                {
                    lay_segar_drop15.setVisibility(View.GONE);
                }
                break;
            }
            case R.id.s_check16: {
                // do something for button 2 click
                if(s_check16.isChecked())
                {
                    lay_segar_drop16.setVisibility(View.VISIBLE);
                }else
                {
                    lay_segar_drop16.setVisibility(View.GONE);
                }
                break;
            }
            case R.id.s_check17: {
                // do something for button 2 click
                if(s_check17.isChecked())
                {
                    lay_segar_drop17.setVisibility(View.VISIBLE);
                }else
                {
                    lay_segar_drop17.setVisibility(View.GONE);
                }
                break;
            }
            case R.id.s_check18: {
                // do something for button 2 click
                if(s_check18.isChecked())
                {
                    lay_segar_drop18.setVisibility(View.VISIBLE);
                }else
                {
                    lay_segar_drop18.setVisibility(View.GONE);
                }
                break;
            }
            case R.id.checktob2: {
                // do something for button 2 click
                if(checktbo2.isChecked())
                {
                    lay_molases.setVisibility(View.VISIBLE);

                }else
                {
                    lay_molases.setVisibility(View.GONE);

                }
                break;
            }
            case R.id.checktop3: {
                // do something for button 2 click
                if(checktop3.isChecked())
                {
                    lay_ryo.setVisibility(View.VISIBLE);

                }else
                {
                    lay_ryo.setVisibility(View.GONE);

                }
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

   /* @Override
    public void selectedIndices(List<Integer> indices) {
        //Toast.makeText(this, indices.toString()+"HEHEHEHEHEH", Toast.LENGTH_LONG).show();

    }

    @Override
    public void selectedStrings(List<String> strings) {




        Toast.makeText(this, strings.toString(), Toast.LENGTH_LONG).show();

    }*/
}
