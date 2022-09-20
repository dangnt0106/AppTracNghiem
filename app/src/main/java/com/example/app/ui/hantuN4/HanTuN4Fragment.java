package com.example.app.ui.hantuN4;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.app.HanTu.HanTuSlideActivity;
import com.example.app.R;
import com.example.app.ui.TestKanjiN5.Exam;
import com.example.app.ui.TestKanjiN5.ExamAdapter;

import java.util.ArrayList;


public class HanTuN4Fragment extends Fragment {

    GridView gvExam;
    ExamAdapter examAdapter;
    ArrayList<Exam> arr_exam = new ArrayList<Exam>();



    public HanTuN4Fragment() {
        // Required empty public constructor
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_han_tu_n4, container, false);
    }
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        gvExam=(GridView) getActivity().findViewById(R.id.gvExam);
        arr_exam.add(new Exam("Bài 1"));
        arr_exam.add(new Exam("Bài 2"));
        arr_exam.add(new Exam("Bài 3"));
        arr_exam.add(new Exam("Bài 4"));
        arr_exam.add(new Exam("Bài 5"));
        arr_exam.add(new Exam("Bài 6"));
        arr_exam.add(new Exam("Bài 7"));
        arr_exam.add(new Exam("Bài 8"));
        arr_exam.add(new Exam("Bài 9"));
        arr_exam.add(new Exam("Bài 10"));



        examAdapter = new ExamAdapter(getActivity(),arr_exam);
        gvExam.setAdapter(examAdapter);
        gvExam.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent= new Intent(getActivity(), HanTuSlideActivity.class);
                //gui di 1 ds table  mon ma khac so de
                intent.putExtra("num_exam",i+1);
                intent.putExtra("subject","N4");
                intent.putExtra("test","yes");
                startActivity(intent);
            }
        });

    }
}