package com.example.app.ui.OnTap;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;

import com.example.app.MainActivity;
import com.example.app.R;
import com.example.app.Slide.ScreenSlideActivity;
import com.example.app.ui.TestKanjiN5.Exam;
import com.example.app.ui.TestKanjiN5.ExamAdapter;
import com.example.app.ui.TestKanjiN5.TestKanjiN5Fragment;

public class OnTapFragment extends Fragment {
    Button btnN5,btnN4,btnN3;
    public OnTapFragment() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_on_tap, container, false);
        ((MainActivity) getActivity()).getSupportActionBar().setTitle("Ôn Tập");
        return inflater.inflate(R.layout.fragment_on_tap, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        btnN5 = (Button) view.findViewById(R.id.testN5);
        btnN4 = (Button) view.findViewById(R.id.testN4);
        btnN3 = (Button) view.findViewById(R.id.testN3);

        btnN5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(OnTapFragment.this)
                        .navigate(R.id.action_OnTapFragment_to_TestKanjiN5Fragment);
            }
        });

        btnN4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(OnTapFragment.this)
                        .navigate(R.id.action_OnTapFragment_to_TestKanjiN4Fragment);
            }
        });

        btnN3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(OnTapFragment.this)
                        .navigate(R.id.action_OnTapFragment_to_TestKanjiN3Fragment);
            }
        });

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }



}