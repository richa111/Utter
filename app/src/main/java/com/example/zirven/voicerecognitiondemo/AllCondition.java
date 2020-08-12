package com.example.zirven.voicerecognitiondemo;

import android.app.DownloadManager;
import android.bluetooth.BluetoothAdapter;
import android.content.ContentUris;
import android.content.Intent;
import android.net.Uri;
import android.provider.AlarmClock;
import android.provider.CalendarContract;
import android.provider.ContactsContract;
import android.provider.MediaStore;
import android.provider.Settings;

/**
 * Created by RichaSharma on 7/5/2017.
 */

public class AllCondition {
    public Intent setAlarm() {
        Intent i = null;

        i = new Intent(AlarmClock.ACTION_SET_ALARM);
        i.putExtra(AlarmClock.EXTRA_MESSAGE, "New Alarm");
        i.putExtra(AlarmClock.EXTRA_HOUR, 10);
        i.putExtra(AlarmClock.EXTRA_MINUTES, 30);


        return i;
    }

    public Intent useCamera() {
        Intent i = null;
        i = new Intent("android.media.action.IMAGE_CAPTURE");
        return i;
    }

    public Intent dialer() {
        Intent i = null;
        i = new Intent(Intent.ACTION_DIAL);
        return i;
    }


    public Intent opensettings() {
        Intent i = null;
        i = new Intent(Settings.ACTION_SETTINGS);
        return i;
    }

    public Intent facebook() {
        Intent i = null;
        i = new Intent("android.intent.category.LAUNCHER");
        i.setClassName("com.facebook.katana", "com.facebook.katana.LoginActivity");
        return i;
    }

    public Intent bluetooth() {
        Intent i = null;
        i = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
        return i;
    }


    public Intent sms() {
        Intent i = null;
        i = new Intent(Intent.ACTION_MAIN);
        i.addCategory(Intent.CATEGORY_APP_MESSAGING);
        return i;
    }
    public Intent contact() {
        Intent i = null;
        i = new Intent(Intent.ACTION_PICK, ContactsContract.Contacts.CONTENT_URI);

        return i;
    }
    public Intent music()
    {
        Intent i=null;
        i=new Intent(MediaStore.INTENT_ACTION_MUSIC_PLAYER);
        return i;
    }

    public Intent gallery()
    {
        Intent i=null;
        i=new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        return i;
    }
    public Intent wifi_open()
    {
        Intent i=null;
        i=new Intent(Settings.ACTION_WIFI_SETTINGS);
        return i;
    }
    public Intent youtube()
    {
        Intent i=null;
        i=new Intent(Intent.ACTION_VIEW);
        i.setPackage("com.google.android.youtube");
        i.setData(Uri.parse("https://www.youtube.com/watch?v=3TKSW_VgVyM"));
        return i;
    }
    public Intent download_folder()
    {
        Intent i=null;
        i=new Intent(DownloadManager.ACTION_VIEW_DOWNLOADS);
        return i;
    }
    public Intent gmail() {
        Intent i = null;
        i = new Intent(Intent.ACTION_VIEW);
        i.setType("plain/text");
        //i.setData(Uri.parse("test@gmail.com"));
        i.setClassName("com.google.android.gm", "com.google.android.gm.composeActivityGmail");
        i.putExtra(Intent.EXTRA_EMAIL, new String[]{"recipient@example.com"});
        i.putExtra(Intent.EXTRA_SUBJECT, "test");
        i.putExtra(Intent.EXTRA_TEXT, "hello. this is a message sent from my demo app :-)");
        return i;
    }
    public Intent aeroplane()
    {
        Intent i=null;
        i= new Intent(Intent.ACTION_AIRPLANE_MODE_CHANGED);

        return i;
    }
    public Intent you_tube() {
        Intent i = null;
        i = new Intent(Intent.ACTION_VIEW);
        i.setPackage("com.google.android.youtube");
        i.setData(Uri.parse("https://www.youtube.com/watch?v=3TKSW-VgVyM"));
        return i;
    }
    public Intent play_store()
    {
        Intent i=null;
        i=new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse("https://play.google.com/store/apps/details?id=my packagename"));

        return i;
    }
    public Intent whatsapp() {
        Intent i = null;
        i = new Intent(Intent.ACTION_SEND);
        i.setType("text/plain");
        i.setPackage("com.whatsapp");
        i.putExtra(Intent.EXTRA_TEXT, "YOUR TEXT");
        return i;
    }
    public Intent maps() {
        String uri = "http://maps.google.com/maps?saddr=";
        Intent i = null;
        i = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
        i.setPackage("com.google.android.apps.maps");
        return i;
    }
    long startMillis;
    public Intent calendar() {


            Uri.Builder builder = CalendarContract.CONTENT_URI.buildUpon();
            builder.appendPath("time");
            ContentUris.appendId(builder, startMillis);
            Intent i = null;
            i = new Intent(Intent.ACTION_VIEW).setData(builder.build());
            return i;
        }
    public Intent chrome() {
        String url = "http://www.example.com";
        Uri uri = Uri.parse("googlechrome://navigate?url=" + url);
        Intent i = null;
        i = new Intent(Intent.ACTION_VIEW, uri);
        i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        return i;
    }
    public Intent calculator() {
        Intent i = null;
        i = new Intent();
        i.setClassName("com.android.calculator2", "com.android.calculator2.Calculator");
        return i;
    }

    public Intent sound_recorder() {
        Intent i = null;
        i = new Intent(MediaStore.Audio.Media.RECORD_SOUND_ACTION);
        return i;
    }

    public Intent location() {
        Intent i = null;
        i = new Intent(android.provider.Settings.ACTION_LOCATION_SOURCE_SETTINGS);
        return i;
    }
    public Intent instagram() {
        Uri uri = Uri.parse("http://instagram.com/_u/xxx");
        Intent likeIng = new Intent(Intent.ACTION_VIEW, uri);
        likeIng.setPackage("com.instagram.android");
        return likeIng;
    }


}
