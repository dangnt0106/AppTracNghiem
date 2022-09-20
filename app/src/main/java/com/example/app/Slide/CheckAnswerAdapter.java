package com.example.app.Slide;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.app.Question.Question;
import com.example.app.R;

import java.util.ArrayList;

public class CheckAnswerAdapter extends BaseAdapter {
    ArrayList lsData;
    LayoutInflater inflater;

    public CheckAnswerAdapter(ArrayList lsData, Context context) {
        this.lsData = lsData;
        inflater=(LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    //Tao phuong thuc chua du lieu 2 textview list answer
    private static class ViewHolder{
        TextView tvNumAns, tvYourAns;
    }

    @Override
    public int getCount() {
        return lsData.size();
    }

    @Override
    public Object getItem(int position) {
        return lsData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Question data=(Question) getItem(position);
        ViewHolder holder;      //Goi phuong thuc chua 2 textview
        if(convertView == null){
            holder =new ViewHolder();
            convertView= inflater.inflate(R.layout.item_gridview_list_answer, null);
            holder.tvNumAns= (TextView) convertView.findViewById(R.id.tvNumAns);
            holder.tvYourAns=(TextView) convertView.findViewById(R.id.tvAnswer);
            convertView.setTag(holder);
        }else {
            holder=(ViewHolder) convertView.getTag();
        }
        int i= position +1;         // cau tra loi
        holder.tvNumAns.setText("Câu "+i+": ");
        holder.tvYourAns.setText(data.getTraloi());
        return convertView;
    }


}
