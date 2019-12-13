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

public class EndQuizActivity extends AppCompatActivity {
    private int score;
    private Button buttonPlayAgain;
    private TextView textViewScore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.quiz_end);

        wireWidgets();
        String scoreMessage1 = getString(R.string.scoreMessage1);
        String scoreMessage2 = getString(R.string.scoreMessage2);
        Intent lastIntent = getIntent();
        String SpellQuizFragmen = getIntent().getStringExtra("SPELL_QUIZ_ID");
        if (lastIntent == SpellQuizFragmen) {
            score = lastIntent.getIntExtra(SpellQuizFragment.EXTRA_SCORE, -1);
            textViewScore.setText(scoreMessage1 + score + scoreMessage2);
        }
        else {
            score = lastIntent.getIntExtra(CharactersQuizFragment.EXTRA_SCORE, -1);
            textViewScore.setText(scoreMessage1 + score + scoreMessage2);
        }
        setListoners();
    }

    private void wireWidgets() {

        buttonPlayAgain = findViewById(R.id.button_end_restart);
        textViewScore = findViewById(R.id.textView_end_score);
    }

    private void setListoners() {
        buttonPlayAgain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();

            }
        });
    }
}
