package com.example.zirven.voicerecognitiondemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

/**
 * Created by RichaSharma on 7/21/2017.
 */

public class DetailAct extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        Intent intent=getIntent();
        int pos=Integer.parseInt(intent.getStringExtra("pos"));
        TextView textView1=(TextView)findViewById(R.id.textView4);
        getSupportActionBar().setTitle(help.dataList.get(pos));
        TextView dtv= (TextView) findViewById(R.id.destextView);
        dtv.setText(help.description.get(pos));
        TextView textView=(TextView)findViewById(R.id.textView3) ;
        TextView etv= (TextView) findViewById(R.id.exampletextView);
        etv.setText(help.example.get(pos));


    }
}
