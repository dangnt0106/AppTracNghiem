package com.example.app.HanTu;

import android.content.Context;
import android.database.Cursor;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.app.R;

public class HanTuAdapter extends CursorAdapter {
    public HanTuAdapter(Context context, Cursor c, boolean autoRequery) {
        super(context, c, autoRequery);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        final View view= LayoutInflater.from(context).inflate(R.layout.item_list_hantu, parent,false);
        return view;
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {

        LinearLayout linQues= (LinearLayout) view.findViewById(R.id.linHanTu);
        TextView tvHanTu= (TextView) view.findViewById(R.id.tvHanTu);



        if(cursor.getPosition()%2 == 0){
            linQues.setBackgroundColor(Color.parseColor("#FFE2DFDF"));
        }else linQues.setBackgroundColor(Color.parseColor("#ffffff"));

        tvHanTu.setText(cursor.getString(1));
    }
}
