package com.example.app.score;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;

import com.example.app.R;



public class ScoreAdapter extends CursorAdapter{

    public ScoreAdapter(Context context, Cursor c, boolean autoRequery) {
        super(context, c, autoRequery);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        final View view= LayoutInflater.from(context).inflate(R.layout.item_list_score, parent,false);
        return view;
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        TextView tvScore= (TextView) view.findViewById(R.id.tvScore);
        TextView tvName= (TextView) view.findViewById(R.id.tvNameStudent);
        TextView tvDate= (TextView) view.findViewById(R.id.tvDate);
        tvName.setText(cursor.getString(1));
        tvScore.setText(cursor.getFloat(2)+"");
        tvDate.setText(cursor.getString(3));
    }
}
