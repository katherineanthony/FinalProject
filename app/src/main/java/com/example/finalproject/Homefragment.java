package com.example.finalproject;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.w3c.dom.Text;

public class Homefragment extends Fragment {


    private TextView textView5, textView6, textView7, textView8, textView9;

    public Homefragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_homefragment, container, false);
        textView5 = rootView.findViewById(R.id.textView5);
        textView6 = rootView.findViewById(R.id.textView6);
        textView7 = rootView.findViewById(R.id.textView7);
        textView8 = rootView.findViewById(R.id.textView8);
        textView9 = rootView.findViewById(R.id.textView9);
        return rootView;
    }






}
