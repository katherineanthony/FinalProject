package com.example.finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class CharecterDetailActivity extends AppCompatActivity {

    private TextView house, name, patronus, desc, bloodStatus, wand;
    private ImageView image;
    private Charecter charecter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spell_detail);
        Intent lastIntent = getIntent();
        charecter = lastIntent.getParcelableExtra(CharectersListFragment.EXTRA_POSITION);
        wireWidgets();
        house.setText(charecter.getHouse());
        name.setText(charecter.getName());
        patronus.setText(charecter.getPatronus());
        bloodStatus.setText(charecter.getBloodStatus());
        wand.setText(charecter.getWand());
        desc.setText(charecter.getDesc());
        int resourceImage = getResources().getIdentifier(charecter.getImage(), "drawable", getPackageName());
        image.setImageDrawable(getResources().getDrawable(resourceImage));
    }


    private void wireWidgets() {
        name = findViewById(R.id.textView_charachterDetail_name);
        house = findViewById(R.id.textView_characterDetail_house);
        patronus = findViewById(R.id.textView_characterDetail_patronus);
        desc = findViewById(R.id.textView_characterDetail_description);
        bloodStatus = findViewById(R.id.textView_characterDetail_bloodStatus);
        wand = findViewById(R.id.textView_characterDetail_wand);
        image = findViewById(R.id.imageView_charecterDetail_image);

    }
}
