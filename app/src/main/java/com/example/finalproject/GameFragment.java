package com.example.finalproject;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class GameFragment extends Fragment {

    private ImageView snapeFace1;
    private ImageView snapeFace2;
    private ImageView snapeFace3;
    private ImageView snapeFace4;
    private ImageView snapeFace5;
    private ImageView snapeFace6;
    private ImageView snapeFace7;
    private ImageView snapeFace8;

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
        and then we need to
        */

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
