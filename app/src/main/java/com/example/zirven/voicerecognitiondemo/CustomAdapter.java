package com.example.zirven.voicerecognitiondemo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by RichaSharma on 7/21/2017.
 */

public class CustomAdapter extends BaseAdapter
{
    LayoutInflater inflate=null;
    Context mycontext;
    ArrayList mylistdata;
    int myimgs[];

    @Override
    public int getCount() {
        return mylistdata.size();
    }
    public CustomAdapter(Context c,ArrayList list,int img[])
    {
        mycontext=c;
        mylistdata=list;
        myimgs=img;

    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        PlaceHolder holder=new PlaceHolder();
        View customview=convertView;


        LayoutInflater layoutInflater= (LayoutInflater) mycontext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        customview= layoutInflater.inflate(R.layout.mylayout,null);


        TextView tv= (TextView) customview.findViewById(R.id.customtextView);
        ImageView im= (ImageView) customview.findViewById(R.id.customimageView);

        holder.appname=tv;
        holder.icons=im;





        holder.appname.setText(mylistdata.get(position).toString());
        holder.icons.setImageResource(myimgs[position]);

        return customview;
    }
}



