package com.example.finalproject;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.google.gson.Gson;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;


public class SpellsListFragment extends Fragment {

private ListView spellsListView;

private TextView spellName, spellType;

private SpellAdapter spellAdapter;

private List<Spell> spellsList;

public static final String TAG = "SpellsListFragment";


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // inflate the fragment_pythagorean layout
        View rootView = inflater.inflate(R.layout.fragment_spells_list, container, false);
        // wire widgets using that layout
        // call findViewById on the rootView
        InputStream questionsInputStream = getResources().openRawResource(R.raw.spells);
        String jsonString = readTextFile(questionsInputStream);
        // create a gson object
        Gson gson = new Gson();
        // read your json file into an array of questions
        Spell[] spells =  gson.fromJson(jsonString, Spell[].class);
        // convert your array to a list using the Arrays utility class
        spellsList = Arrays.asList(spells);
        // verify that it read everything properly
        Log.d(TAG, "onCreate: " + spellsList.toString());
        wireWidgets(rootView);
        setListeners();
        spellAdapter = new SpellAdapter(spellsList);
        spellsListView.setAdapter(spellAdapter);
        // return the inflated view
        return rootView;
    }

    private void wireWidgets(View rootView) {
        spellName = rootView.findViewById(R.id.textView_spell_name);
        spellType = rootView.findViewById(R.id.textView_spell_type);
        spellsListView = rootView.findViewById(R.id.list_view_spell);
    }
    private void setListeners(){}
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


    private class SpellAdapter extends ArrayAdapter<Spell> {
        private List<Spell> spellList;
        public SpellAdapter(List<Spell> heroesList) {
            //since we're in the HeroListActivity class, we already have the context
            // we're hardcoding in a particular layout, so don't need to put it in the
            // constructer either
            // we'll send a place holder resource to the superclass of -1
            super(SpellsListFragment.this.getContext(), -1, spellsList);
            this.spellList = heroesList;
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

        @Override
        public View getView(int position, View convertView, ViewGroup parent){
            // 1. inflate layout
            LayoutInflater inflater = getLayoutInflater();
            if(convertView == null){
                convertView = inflater.inflate(R.layout.item_spell, parent, false);
            }
            // 2. wire widgets & link the hero to those widgets
            spellName = convertView.findViewById(R.id.textView_spell_name);
            spellType = convertView.findViewById(R.id.textView_spell_type);
           

            // set values for each widget. use the position parameter variable
            // to get the hero that you need out of the list
            // and set the values for the widgets
            spellName.setText(spellList.get(position).getName());
            spellType.setText(String.valueOf(spellList.get(position).getType()));


            //3. return inflated view
            return convertView;

        }
    }


}
