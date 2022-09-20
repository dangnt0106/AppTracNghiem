package com.example.app.HanTu;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.app.Question.DataBase;

import java.util.ArrayList;

public class HanTuController {
    private DataBase dbHelper;

    public HanTuController(Context context) {
        dbHelper= new DataBase(context);
    }

    //Lấy danh sách chữ
    public ArrayList<HanTu> getKanji(int bai, String trinhdo){
        ArrayList<HanTu> lsData= new ArrayList<HanTu>();
        SQLiteDatabase db= dbHelper.getReadableDatabase();
        Cursor cursor= db.rawQuery("SELECT * FROM kanjiTH WHERE bai = '"+bai+"' AND trinhdo='"+trinhdo+"' ORDER BY random()",null);
        cursor.moveToFirst();
        do {
            HanTu item;
            item= new HanTu(cursor.getInt(0), cursor.getString(1),cursor.getString(2),cursor.getString(3),
                    cursor.getString(4),cursor.getString(5),cursor.getString(6),  cursor.getInt(7));
            lsData.add(item);
        }while (cursor.moveToNext());
        return lsData;
    }
}
