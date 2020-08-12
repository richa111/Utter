package com.example.zirven.voicerecognitiondemo;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Locale;

public class Main extends AppCompatActivity {

    private TextView txtSpeechInput;
    private ImageButton btnSpeak;
    private final int REQ_CODE_SPEECH_INPUT = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        startService(new Intent(this, MyService.class));
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        txtSpeechInput = (TextView) findViewById(R.id.txtSpeechInput);
        btnSpeak = (ImageButton) findViewById(R.id.btnSpeak);
        // hide the action bar
      //  getActionBar().hide();
        btnSpeak.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                promptSpeechInput();
            }
        });
    }
    /**
     * Showing google speech input dialog
     * */
    private void promptSpeechInput() {
        Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,
                RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.getDefault());

        try {
            startActivityForResult(intent, REQ_CODE_SPEECH_INPUT);
        } catch (ActivityNotFoundException a) {
            Toast.makeText(getApplicationContext(),
                    getString(R.string.speech_not_supported),
                    Toast.LENGTH_SHORT).show();
        }
    }

    /**
     * Receiving speech input
     * */
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        switch (requestCode) {
            case REQ_CODE_SPEECH_INPUT: {
                if (resultCode == RESULT_OK && null != data) {

                    ArrayList<String> result = data
                            .getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
                    txtSpeechInput.setText(result.get(0));
                    System.out.println(" - "+result.get(0));
                    String msg = result.get(0);
                    msg = msg.toLowerCase();
                    Intent i = null;
                    AllCondition cond = new AllCondition();
                    Log.d("Input speech ", msg);


                    if(msg.contains("alarm"))
                    {
                        i = cond.setAlarm();
                    }
                    else if(msg.contains("call"))
                    {
                        i = cond.dialer();

                    }
                    else if(msg.contains("camera"))
                    {
                        i = cond.useCamera();

                    }
                    else if(msg.contains("settings"))
                    {
                        i = cond.opensettings();

                    }
                    else if(msg.contains("facebook"))
                    {
                        i = cond.facebook();

                    }
                    else if(msg.contains("bluetooth"))
                    {
                        i = cond.bluetooth();

                    }

                    else if(msg.contains("message"))
                    {
                        i=cond.sms();
                    }
                    else if (msg.contains("contact"))
                    {
                        i = cond.contact();
                    }
                    else if (msg.contains("music"))
                    {
                        i = cond.music();
                    }
                    else if (msg.contains("gallery"))
                    {
                        i = cond.gallery();
                    }
                    else if (msg.contains("wi-fi") )
                    {
                        i = cond.wifi_open();
                    }
                    else if (msg.contains("youtube"))
                    {
                        i = cond.youtube();
                    }

                    else if (msg.contains("open downloads"))
                    {
                        i = cond.download_folder();
                    }
                    else if (msg.contains("gmail"))
                    {
                        i = cond.gmail();
                    }
                    else if(msg.contains("airplane mode"))
                    {
                        i = cond.aeroplane();

                    }
                    else if(msg.contains("play store"))
                    {
                        i = cond.play_store();

                    }
                    else if(msg.contains("whatsapp"))
                    {
                        i = cond.whatsapp();

                    }
                    else if(msg.contains("maps"))
                    {
                        i = cond.maps();

                    }
                    else if(msg.contains("calendar"))
                    {
                        i = cond.calendar();
                    }

                    else if(msg.contains("chrome"))
                    {
                        i = cond.chrome();

                    }
                    else if(msg.contains("calculator"))
                    {
                        i = cond.calculator();

                    }

                    else if(msg.contains("location"))
                    {
                        i = cond.location();

                    }
                    else if(msg.contains("instagram"))
                    {
                        i = cond.instagram();

                    }
                    else
                    {
                        Toast.makeText(getBaseContext(),"msg",Toast.LENGTH_SHORT) ;
                        Uri webpage=Uri.parse("http://www.google.com?#q="+msg);
                         i= new Intent(Intent.ACTION_VIEW,webpage);

                    }


                    startActivity(i);
                }
                break;
            }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }
@Override
    public boolean onOptionsItemSelected(MenuItem item)
    {

        int id= item.getItemId();
        if(id==R.id.action_settings)
        {
         Intent in =new Intent(Main.this,help.class);
            startActivity(in);
            return true;
        }
        return true;
    }

}