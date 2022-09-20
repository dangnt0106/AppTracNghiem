package com.example.app.ui.TestKanjiN5;


import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;

import com.example.app.MainActivity;
import com.example.app.R;

import com.example.app.Slide.ScreenSlideActivity;

import java.util.ArrayList;


public class TestKanjiN5Fragment extends Fragment {
    GridView gvExam;
    ExamAdapter examAdapter;
    ArrayList<Exam> arr_exam = new ArrayList<Exam>();

    public TestKanjiN5Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_test_kanji_n5, container, false);

        return view;
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        gvExam=(GridView) getActivity().findViewById(R.id.gvExam);
        arr_exam.add(new Exam("Kanji 1"));
        arr_exam.add(new Exam("Kanji 2"));
        arr_exam.add(new Exam("Kanji 3"));
        arr_exam.add(new Exam("Kanji 4"));



        examAdapter = new ExamAdapter(getActivity(),arr_exam);
        gvExam.setAdapter(examAdapter);
        gvExam.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent= new Intent(getActivity(), ScreenSlideActivity.class);
                //gui di 1 ds table  mon ma khac so de
                intent.putExtra("num_exam",i+1);
                intent.putExtra("subject","KanjiN5");
                intent.putExtra("test","yes");
                startActivity(intent);
            }
        });

    }
}
