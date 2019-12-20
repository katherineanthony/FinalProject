package com.example.finalproject;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

import com.google.gson.Gson;

import java.util.List;


public class CharactersQuizFragment extends Fragment {
    public static final String TAG = "SpellQuizFragment";
    private TextView textViewQuestions;
    private Button buttonTrue;
    private Button buttonFalse;
    private int currentQuestion;
    public static final String EXTRA_SCORE = "score";
    public static final String CHARACTER_QUIZ_ID = "CharacterQuizFragment";


    private int score;
    private Quiz quiz;

    //@Override
    //protected void onCreateView(Bundle savedInstanceState) {
    //  super.onCreate(savedInstanceState);


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_spell_quiz, container, false);

        InputStream questionsInputStream = getResources().openRawResource(R.raw.characters_quiz);
        String jsonString = readTextFile(questionsInputStream);
        // create a gson object
        Gson gson = new Gson();
        // read your json file into an array of questions
        Question[] questions =  gson.fromJson(jsonString, Question[].class);
        // convert your array to a list using the Arrays utility class
        List<Question> questionList = Arrays.asList(questions);
        // verify that it read everything properly
        Log.d(TAG, "onCreate: " + questionList.toString());

        quiz = new Quiz(questionList);
        currentQuestion = 0;
        score = 0;



        textViewQuestions = rootView.findViewById(R.id.textView_spellsQuiz_question);
        buttonFalse = rootView.findViewById(R.id.button_spellsQuiz_false);
        buttonTrue = rootView.findViewById(R.id.button_spellsQuiz_true);

        buttonTrue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(quiz.checkAnswer(true, currentQuestion)){
                    score++;
                    Toast.makeText(CharactersQuizFragment.this.getContext(), "\uD83D\uDE00", Toast.LENGTH_SHORT).show();
                }
                else
                    Toast.makeText(CharactersQuizFragment.this.getContext(), "\uD83D\uDE43", Toast.LENGTH_SHORT).show();
                currentQuestion++;
                if(currentQuestion == 10){
                    //go to end screen
                    Intent scoreIntent = new Intent(CharactersQuizFragment.this.getContext(), EndQuizActivity2.class);
                    scoreIntent.putExtra(EXTRA_SCORE, score);
                    startActivity(scoreIntent);
                    score = 0;
                    currentQuestion = 0;
                    textViewQuestions.setText(String.valueOf(quiz.getQuestion(currentQuestion)));
                }
                textViewQuestions.setText(String.valueOf(quiz.getQuestion(currentQuestion)));


            }
        });
        buttonFalse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(quiz.checkAnswer(false, currentQuestion)){
                    score++;
                    Toast.makeText(CharactersQuizFragment.this.getContext(), "\uD83D\uDE00", Toast.LENGTH_SHORT).show();
                }
                else
                    Toast.makeText(CharactersQuizFragment.this.getContext(), "\uD83D\uDE43", Toast.LENGTH_SHORT).show();
                currentQuestion++;
                if(currentQuestion == 10){
                    //go to end screen
                    Intent scoreIntent = new Intent(CharactersQuizFragment.this.getContext(), EndQuizActivity2.class);
                    scoreIntent.putExtra(EXTRA_SCORE, score);
                    startActivity(scoreIntent);
                    score = 0;
                    currentQuestion = 0;
                    textViewQuestions.setText(String.valueOf(quiz.getQuestion(currentQuestion)));
                }
                textViewQuestions.setText(String.valueOf(quiz.getQuestion(currentQuestion)));


            }
        });
        return rootView;
    }
    public String readTextFile(InputStream inputStream) {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

        byte buf[] = new byte[1024];
        int len;
        try {
            while ((len = inputStream.read(buf)) != -1) {
                outputStream.write(buf, 0, len);
            }
            outputStream.close();
            inputStream.close();
        } catch (IOException e) {

        }
        return outputStream.toString();
    }


}
