package com.example.app.ui.HanTu;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.app.MainActivity;
import com.example.app.R;

public class HanTuFragment extends Fragment {
    Button btnN5,btnN4,btnN3;
    public HanTuFragment() {
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
        ((MainActivity) getActivity()).getSupportActionBar().setTitle("Hán Tự");
        return inflater.inflate(R.layout.fragment_han_tu, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        btnN5 = (Button) view.findViewById(R.id.hantuN5);
        btnN4 = (Button) view.findViewById(R.id.hantuN4);
        btnN3 = (Button) view.findViewById(R.id.hantuN3);

        btnN5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(HanTuFragment.this)
                       .navigate(R.id.action_HanTuFragment_to_HanTuN5Fragment);
            }
        });

        btnN4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               NavHostFragment.findNavController(HanTuFragment.this)
                       .navigate(R.id.action_HanTuFragment_to_HanTuN4Fragment);
            }
        });

        btnN3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(HanTuFragment.this)
                        .navigate(R.id.action_HanTuFragment_to_HanTuN3Fragment);
            }
        });
    }
}