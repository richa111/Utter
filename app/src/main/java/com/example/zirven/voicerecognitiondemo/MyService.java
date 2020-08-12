package com.example.zirven.voicerecognitiondemo;

import android.app.Application;
import android.app.Service;
import android.content.Intent;
import android.net.Uri;
import android.os.IBinder;
import android.speech.RecognizerIntent;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Locale;

import static android.app.Activity.RESULT_OK;

/**
 * Created by RichaSharma on 7/26/2017.
 */

public class MyService extends Service {

    public MyService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        Log.d("Back Services ","Started");
        promptSpeechInput();
        throw new UnsupportedOperationException("Not yet implemented");



    }


    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        Log.d("Back Services ","Started 2");
        promptSpeechInput();
        return super.onStartCommand(intent, flags, startId);
    }
    private final int REQ_CODE_SPEECH_INPUT = 100;

    private void promptSpeechInput() {
        Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,
                RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.getDefault());
        Log.d("Word is", "");
        startActivityForResult(getApplication(),intent,1);


    }

    private void startActivityForResult(Application application, Intent intent, int i1) {
        switch (i1) {
            case REQ_CODE_SPEECH_INPUT: {
                if (i1 == RESULT_OK && null != intent) {

                    ArrayList<String> result = intent
                            .getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
                    //txtSpeechInput.setText(result.get(0));
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
                        Uri webpage=Uri.parse("http://www.google.com?q="+msg);
                        i= new Intent(Intent.ACTION_VIEW,webpage);

                    }


                    startActivity(i);
                }
                break;
            }
        }

    }


    @Override
    public void onDestroy() {
        Log.d("Servies ","Stop");
    }
}
