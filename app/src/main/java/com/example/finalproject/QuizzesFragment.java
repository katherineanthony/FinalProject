package com.example.finalproject;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class QuizzesFragment extends Fragment {
    private Button buttonSpellsQuiz;
    private Button buttonCharactersQuiz;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_quizzes, container, false);

        buttonSpellsQuiz = rootView.findViewById(R.id.button_quizMain_spellsQuiz);
        buttonCharactersQuiz = rootView.findViewById(R.id.button_quizMain_charactersQuiz);

        buttonCharactersQuiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment fragment = new SpellQuizFragment();
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.constraintLayout_main_container, fragment).commit();
            }
        });

        buttonSpellsQuiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        return rootView;
    }


}
