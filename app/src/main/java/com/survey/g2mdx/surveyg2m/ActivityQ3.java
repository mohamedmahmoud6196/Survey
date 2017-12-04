package com.survey.g2mdx.surveyg2m;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

public class ActivityQ3 extends AppCompatActivity implements View.OnClickListener {
    Spinner spinner_out;
    Button btn_next,btn_prev;
    LinearLayout lay_comp,lay_compid,lay_compid2,lay_compid3,lay_compid4,lay_retail_sub,lay_liq1,lay_liq2;
    LinearLayout lay_advcomp1,lay_advcomp2,lay_advpos,lay_show;
    CheckBox comp1,comp2,comp3,comp4,smoke1,smoke2;
    CheckBox advop1,advop2,advop3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_surv3_new);
      // Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
       //setSupportActionBar(toolbar);
        //lay_comp=(LinearLayout)findViewById(R.id.lay_comp);
       // liner2=(LinearLayout)findViewById(R.id.layout_liniar23);
        //liner1.setVisibility(View.GONE);
       // liner2.setVisibility(View.GONE);
        comp1=(CheckBox)findViewById(R.id.comp1);
        comp1.setOnClickListener(this);
        comp2=(CheckBox)findViewById(R.id.comp2);
        comp2.setOnClickListener(this);
        comp3=(CheckBox)findViewById(R.id.comp3);
        comp3.setOnClickListener(this);
        comp4=(CheckBox)findViewById(R.id.comp4);
        comp4.setOnClickListener(this);
        smoke1=(CheckBox)findViewById(R.id.smoke1);
        smoke1.setOnClickListener(this);
        smoke2=(CheckBox)findViewById(R.id.smoke2);
        smoke2.setOnClickListener(this);

        advop1=(CheckBox)findViewById(R.id.advop1);
        advop1.setOnClickListener(this);

        advop2=(CheckBox)findViewById(R.id.advop2);
        advop2.setOnClickListener(this);

        advop3=(CheckBox)findViewById(R.id.advop3);
        advop3.setOnClickListener(this);


        lay_comp=(LinearLayout)findViewById(R.id.lay_comp);
        lay_compid=(LinearLayout)findViewById(R.id.lay_compid);
        lay_compid2=(LinearLayout)findViewById(R.id.lay_compid2);
        lay_compid3=(LinearLayout)findViewById(R.id.lay_compid3);
        lay_compid4=(LinearLayout)findViewById(R.id.lay_compid4);
        lay_retail_sub=(LinearLayout)findViewById(R.id.lay_retail_sub);
        lay_liq1=(LinearLayout)findViewById(R.id.lay_liq1);
        lay_liq2=(LinearLayout)findViewById(R.id.lay_liq2);
        lay_advcomp1=(LinearLayout)findViewById(R.id.lay_advcomp1);
        lay_advcomp2=(LinearLayout)findViewById(R.id.lay_advcomp2);
        lay_advpos=(LinearLayout)findViewById(R.id.lay_advpos);
        lay_show=(LinearLayout)findViewById(R.id.lay_show);

        spinner_out = (Spinner)findViewById(R.id.spinner_outtype);
        btn_next=(Button)findViewById(R.id.btnReg);

        btn_next.setOnClickListener(this);


        btn_prev=(Button)findViewById(R.id.btnLogin);
        btn_prev.setOnClickListener(this);

        List<String> list = new ArrayList<String>();
        list.add("School");
        list.add("Hospital");
        list.add("Park");
        list.add("ShoppingCenter_Mall");

        lay_comp.setVisibility(View.GONE);
        lay_compid.setVisibility(View.GONE);
        lay_compid2.setVisibility(View.GONE);
        lay_compid3.setVisibility(View.GONE);
        lay_compid4.setVisibility(View.GONE);
        lay_retail_sub.setVisibility(View.GONE);
        lay_liq1.setVisibility(View.GONE);
        lay_liq2.setVisibility(View.GONE);
        lay_advcomp2.setVisibility(View.GONE);
        lay_advcomp1.setVisibility(View.GONE);

      /* ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, list);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);//(R.layout.outlet_spinner_layout);
        spinner_out.setAdapter(dataAdapter);*/



        //Group Option One Click
        RadioGroup rg = (RadioGroup) findViewById(R.id.srvgr);
        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
        {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId)
            {
                switch(checkedId)
                {
                    case R.id.srvop1:
                        // TODO Something
                        //Toast.makeText(getApplicationContext(),"1",Toast.LENGTH_LONG).show();

                        lay_comp.setVisibility(View.VISIBLE);
                        break;
                    case R.id.srvop2:
                        // TODO Something
                       // Toast.makeText(getApplicationContext(),"2",Toast.LENGTH_LONG).show();

                        lay_comp.setVisibility(View.GONE);
                        lay_compid.setVisibility(View.GONE);
                        lay_compid2.setVisibility(View.GONE);
                        lay_compid3.setVisibility(View.GONE);
                        lay_compid4.setVisibility(View.GONE);
                        break;

                }
            }
        });
        RadioGroup rg2 = (RadioGroup) findViewById(R.id.activgr);
        rg2.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
        {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId)
            {
                switch(checkedId)
                {
                    case R.id.activ1:
                        // TODO Something
                        lay_retail_sub.setVisibility(View.VISIBLE);
                        break;
                    case R.id.activ2:
                        // TODO Something

                        lay_retail_sub.setVisibility(View.GONE);

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

                //Toast.makeText(getApplicationContext(),"You need to restart Go taxi Applicatoin.", Toast.LENGTH_SHORT).show();
                // finish();
               // Intent intent = new Intent (getApplicationContext(), ActivityQ2.class);
                //intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
               // startActivity(intent);

                Intent intent = new Intent(getApplicationContext(), ActivityQ4.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_PREVIOUS_IS_TOP |intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                //intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
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
            case R.id.comp1: {
                // do something for button 2 click
                if(comp1.isChecked())
                {
                    lay_compid.setVisibility(View.VISIBLE);
                }else
                {
                    lay_compid.setVisibility(View.GONE);
                }
                break;
            }
            case R.id.comp2: {
                // do something for button 2 click
                if(comp2.isChecked())
                {
                    lay_compid2.setVisibility(View.VISIBLE);
                }else
                {
                    lay_compid2.setVisibility(View.GONE);
                }
                break;
            }
            case R.id.comp3: {
                // do something for button 2 click
                if(comp3.isChecked())
                {
                    lay_compid3.setVisibility(View.VISIBLE);
                }else
                {
                    lay_compid3.setVisibility(View.GONE);
                }
                break;
            }
            case R.id.comp4: {
                // do something for button 2 click
                if(comp4.isChecked())
                {
                    lay_compid4.setVisibility(View.VISIBLE);
                }else
                {
                    lay_compid4.setVisibility(View.GONE);
                }
                break;
            }
            case R.id.smoke1: {
                // do something for button 2 click
                if(smoke1.isChecked())
                {
                    lay_liq1.setVisibility(View.VISIBLE);
                }else
                {
                    lay_liq1.setVisibility(View.GONE);
                }
                break;
            }
            case R.id.smoke2: {
                // do something for button 2 click
                if(smoke2.isChecked())
                {
                    lay_liq2.setVisibility(View.VISIBLE);
                }else
                {
                    lay_liq2.setVisibility(View.GONE);
                }
                break;
            }
            case R.id.advop1: {
                // do something for button 2 click
                if(advop1.isChecked())
                {
                    lay_advcomp1.setVisibility(View.VISIBLE);
                }else
                {
                    lay_advcomp1.setVisibility(View.GONE);
                }
                break;
            }
            case R.id.advop2: {
                // do something for button 2 click
                if(advop2.isChecked())
                {
                    lay_advcomp2.setVisibility(View.VISIBLE);
                }else
                {
                    lay_advcomp2.setVisibility(View.GONE);
                }
                break;
            }
            case R.id.advop3: {
                // do something for button 2 click
                if(advop3.isChecked())
                {
                    lay_advcomp2.setVisibility(View.GONE);
                    lay_advcomp1.setVisibility(View.GONE);
                    lay_show.setVisibility(View.GONE);
                    lay_advpos.setVisibility(View.GONE);
                }else
                {
                    lay_show.setVisibility(View.VISIBLE);
                    lay_advpos.setVisibility(View.VISIBLE);
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
}
