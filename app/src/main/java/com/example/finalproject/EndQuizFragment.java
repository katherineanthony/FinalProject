package com.example.finalproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

public class EndQuizFragment extends Fragment {
    private int score;
    private Button buttonPlayAgain;
    private TextView textViewScore;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.quiz_end, container, false);

        buttonPlayAgain = rootView.findViewById(R.id.button_end_restart);
        textViewScore = rootView.findViewById(R.id.textView_end_score);

        private void setListoners () {
            buttonPlayAgain.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    finish();

                }
            });
        }
    }
}
