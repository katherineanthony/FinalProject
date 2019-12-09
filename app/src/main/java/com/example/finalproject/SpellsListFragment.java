package com.example.finalproject;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link SpellsListFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link SpellsListFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SpellsListFragment extends Fragment {




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // inflate the fragment_pythagorean layout
        View rootView = inflater.inflate(R.layout.fragment_spells_list, container, false);
        // wire widgets using that layout
        // call findViewById on the rootView
        wireWidgets(rootView);

        // set any listeners for said widgets
        setListeners();

        // return the inflated view
        return rootView;
    }

    private void wireWidgets(View rootView) {
    }
    private void setListeners(){}


}
