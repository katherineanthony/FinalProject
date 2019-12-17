package com.example.finalproject;

import android.os.Bundle;
import android.os.SystemClock;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.List;

public class GameFragment extends Fragment {

    private ImageView snapeFace1;
    private ImageView snapeFace2;
    private ImageView snapeFace3;
    private ImageView snapeFace4;
    private ImageView snapeFace5;
    private ImageView snapeFace6;
    private ImageView snapeFace7;
    private ImageView snapeFace8;
    private ImageView[] snapes;
    private TextView scoreText;
    private Button play;
    private Chronometer timer;
    private int scoreInt;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_game, container, false);
        wireWidgets(rootView);

        /*
        we want, once they press start, there to be snapes that appear at random.
        so we need to make a button, and then run the activity?
        so we need to make a new activity?
        so that the program will run and do certain  things, so its not just all within the button
        being clicked.
        */
        snapes = new ImageView[] { snapeFace1, snapeFace2, snapeFace3,
                snapeFace4, snapeFace5, snapeFace6, snapeFace7, snapeFace8};

        snapeFace1.setVisibility(View.INVISIBLE);
        snapeFace2.setVisibility(View.INVISIBLE);
        snapeFace3.setVisibility(View.INVISIBLE);
        snapeFace4.setVisibility(View.INVISIBLE);
        snapeFace5.setVisibility(View.INVISIBLE);
        snapeFace6.setVisibility(View.INVISIBLE);
        snapeFace7.setVisibility(View.INVISIBLE);
        snapeFace8.setVisibility(View.INVISIBLE);
        scoreText.setVisibility(View.INVISIBLE);
        play.setVisibility(View.VISIBLE);
        scoreText.setVisibility(View.INVISIBLE);

        timer.setOnChronometerTickListener(new Chronometer.OnChronometerTickListener() {
            @Override
            public void onChronometerTick(Chronometer chronometer) {
                int x = (int)(Math.random() * 8);
                snapes[x].setVisibility(View.VISIBLE);
            }
        });


        return container;
    }

    private void wireWidgets(View rootView) {
        snapeFace1 = rootView.findViewById(R.id.imageView_fraggame_snape1);
        snapeFace2 = rootView.findViewById(R.id.imageView_fraggame_snape2);
        snapeFace3 = rootView.findViewById(R.id.imageView_fraggame_snape3);
        snapeFace4 = rootView.findViewById(R.id.imageView_fraggame_snape4);
        snapeFace5 = rootView.findViewById(R.id.imageView_fraggame_snape5);
        snapeFace6 = rootView.findViewById(R.id.imageView_fraggame_snape6);
        snapeFace7 = rootView.findViewById(R.id.imageView_fraggame_snape7);
        snapeFace8 = rootView.findViewById(R.id.imageView_fraggame_snape8);
    }
}
