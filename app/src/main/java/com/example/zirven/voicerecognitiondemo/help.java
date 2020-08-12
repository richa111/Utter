package com.example.zirven.voicerecognitiondemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import java.util.ArrayList;

/**
 * Created by RichaSharma on 7/21/2017.
 */

public class help  extends AppCompatActivity {

    static ArrayList<String> dataList;
    static ArrayList<String> description=new ArrayList<>();
    static ArrayList<String> example=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help);
        dataList=new ArrayList<>();
        dataList.add("Alarm");
        dataList.add("Bluetooth");
        dataList.add("Chrome");
        dataList.add("Calender");
        dataList.add("Calculater");
        dataList.add("Contacts");
        dataList.add("Dialer");
        dataList.add("Downloads");
        dataList.add("Facebook");
        dataList.add("Gallery");
        dataList.add("Instagram");
        dataList.add("Location");
        dataList.add("Maps");
        dataList.add("Messages");
        dataList.add("Music");
        dataList.add("Playstore");
        dataList.add("Settings");
        dataList.add("Whatsapp");
        dataList.add("Wifi");
        dataList.add("Youtube");
        description.add("To set an alarm within the next 24 hours");
        description.add("To Open Bluetooth Settings");
        description.add("The google chrome web browser is based on the open source chromium project");
        description.add("Create a new calender entry based on th date & time that you give");
        description.add("To perform calculations use calculators ");
        description.add("It contains all the details of contacts");
        description.add("To make a direct call by number");
        description.add("This folder contains all the downloaded items ");
        description.add("A social networking app");
        description.add("Shows images and all album");
        description.add("A photo sharing application ");
        description.add("To get the location  ");
        description.add("Get turn-by-turn directions to an address ");
        description.add("Send text message to someone ");
        description.add("Play the requested song or artist");
        description.add("Install the different  application in your mobile");
        description.add("To change different settings of mobile");
        description.add("Whatsapp messenger is a cross-platform instant messaging application");
        description.add("wifi ");
        description.add("youtube is used to play videos online");
        example.add("set alarm for 6 in morning");
        example.add("turn On/OFF Bluetooth ");
        example.add("search on google chrome");
        example.add("set a reminder for a meeting with joe ");
        example.add("open calaculator ");
        example.add("show contacts");
        example.add("call joe");
        example.add("open downloads");
        example.add("open facebook");
        example.add("show gallery");
        example.add("open instagram");
        example.add("open maps");
        example.add("direction to the hardware store");
        example.add("send a message ");
        example.add("play music");
        example.add("open playstore");
        example.add("open settings");
        example.add("open whatsapp");
        example.add("turn on/off wi-fi");
        example.add("YouTube channel for all music and video and behind the scenes action");
        int imgs[]={R.drawable.pic1,R.drawable.pic2,R.drawable.pic3,R.drawable.p4,R.drawable.p5,R.drawable.p6,
                R.drawable.p7,R.drawable.p8,R.drawable.p9,R.drawable.p10,R.drawable.p11,R.drawable.p12,
                R.drawable.p13,R.drawable.p14,R.drawable.p15,R.drawable.p16,R.drawable.p17,R.drawable.p18,
                R.drawable.p19,R.drawable.p20};
        CustomAdapter customAdapter=new CustomAdapter(this,dataList,imgs);

        ArrayAdapter adapter = new ArrayAdapter<String>(this, R.layout.activity_main2, dataList);

        ListView listView = (ListView) findViewById(R.id.my_list);
        listView.setAdapter(customAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent intent=new Intent(help.this,DetailAct.class);
                intent.putExtra("pos",""+position);
                startActivity(intent);
            }
        });

    }


}
