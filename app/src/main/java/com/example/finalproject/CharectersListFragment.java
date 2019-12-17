package com.example.finalproject;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.google.gson.Gson;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;


public class CharectersListFragment extends Fragment {
    private ListView characterListView;

    private TextView charecterName, house;

    private CharecterAdapter charecterAdapter;

    private List<Charecter> charecterList;

    public static final String TAG = "SpellsListFragment";

    public static final String EXTRA_POSITION = "position";


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // inflate the fragment_pythagorean layout
        View rootView = inflater.inflate(R.layout.fragment_spells_list, container, false);
        // wire widgets using that layout
        // call findViewById on the rootView
        InputStream questionsInputStream = getResources().openRawResource(R.raw.characters);
        String jsonString = readTextFile(questionsInputStream);
        // create a gson object
        Gson gson = new Gson();
        // read your json file into an array of questions
        Charecter[] charecters =  gson.fromJson(jsonString, Charecter[].class);
        // convert your array to a list using the Arrays utility class
        charecterList = Arrays.asList(charecters);
        // verify that it read everything properly
        Log.d(TAG, "onCreate: " + charecterList.toString());
        wireWidgets(rootView);
        setListeners();
        charecterAdapter = new CharecterAdapter(charecterList);
        characterListView.setAdapter(charecterAdapter);
        // return the inflated view
        return rootView;
    }

    private void wireWidgets(View rootView) {
        charecterName = rootView.findViewById(R.id.texView_charecterListFragment_charecterName);
        house = rootView.findViewById(R.id.textView_charecterListFragment_house);
        characterListView = rootView.findViewById(R.id.listView_fragment_charecters);
    }
    private void setListeners(){
        characterListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Charecter charecterClicked = charecterList.get(position);
                Intent listViewClicked = new Intent(CharectersListFragment.this.getContext(), CharecterDetailActivity.class);
                listViewClicked.putExtra(EXTRA_POSITION, charecterClicked);
                startActivity(listViewClicked);
            }
        });
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


    private class CharecterAdapter extends ArrayAdapter<Charecter> {
        private List<Charecter> charecterList1;
        public CharecterAdapter(List<Charecter> charecterList1) {
            //since we're in the HeroListActivity class, we already have the context
            // we're hardcoding in a particular layout, so don't need to put it in the
            // constructer either
            // we'll send a place holder resource to the superclass of -1
            super(CharectersListFragment.this.getContext(), -1, charecterList1);
            this.charecterList1 = charecterList1;
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
            charecterName = convertView.findViewById(R.id.texView_charecterListFragment_charecterName);
            house = convertView.findViewById(R.id.textView_charecterListFragment_house);


            // set values for each widget. use the position parameter variable
            // to get the hero that you need out of the list
            // and set the values for the widgets
            charecterName.setText(charecterList1.get(position).getName());
            house.setText(String.valueOf(charecterList1.get(position).getHouse()));


            //3. return inflated view
            return convertView;

        }
    }
}
