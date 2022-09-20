package com.example.app.HanTu;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.app.Question.Question;
import com.example.app.R;

import java.util.ArrayList;


public class HanTuSlideFragment extends Fragment {

    ArrayList<HanTu> arr_Ques;
    public static final String ARG_PAGE = "page"; //key vi tri page
    public int mPageNumber; // vị trí trang hiện tại

    TextView tvNum,tvQuestionHanTu,tvHanViet,tvNghia,tvAmOn,tvAmkun;
    public HanTuSlideFragment(){

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(
                R.layout.fragment_han_tu_slide, container, false);

        tvNum = (TextView) rootView.findViewById(R.id.tvNum);
        tvQuestionHanTu = (TextView) rootView.findViewById(R.id.tvQuestionHanTu);
        tvHanViet = (TextView) rootView.findViewById(R.id.tvHanViet);
        tvNghia = (TextView) rootView.findViewById(R.id.tvNghia);
        tvAmOn = (TextView) rootView.findViewById(R.id.tvAmOn);
        tvAmkun = (TextView) rootView.findViewById(R.id.tvAmkun);



        return rootView;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        arr_Ques = new ArrayList<HanTu>();
        HanTuSlideActivity hanTuSlideActivity = (HanTuSlideActivity) getActivity();
        arr_Ques = hanTuSlideActivity.getData();
        mPageNumber = getArguments().getInt(ARG_PAGE);

    }
    public static HanTuSlideFragment create(int pageNumber) {
        HanTuSlideFragment fragment = new HanTuSlideFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_PAGE, pageNumber);
              fragment.setArguments(args);
        return fragment;
    }
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        tvNum.setText("Chữ " + (mPageNumber + 1));
        tvQuestionHanTu.setText(arr_Ques.get(mPageNumber).getKanjj());

        tvHanViet.setText(getItem(mPageNumber).getAmhanviet());
        tvNghia.setText(getItem(mPageNumber).getNghia());
        tvAmOn.setText(getItem(mPageNumber).getAmon());
        tvAmkun.setText(getItem(mPageNumber).getAmkun());

       // imgIcon.setImageResource(getResources().getIdentifier(getItem(mPageNumber).getImage()+"","drawable","com.example.app"));








    }
    //Ham arr_Q.get xuat hien nhieu qua
    public HanTu getItem(int posotion){
        return arr_Ques.get(posotion);
    }
}