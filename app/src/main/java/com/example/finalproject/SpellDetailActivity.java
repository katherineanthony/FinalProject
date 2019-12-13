package com.example.finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class SpellDetailActivity extends AppCompatActivity {
    private TextView name, effect, type, counterSpell;
    private Spell spell;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spell_detail);
        Intent lastIntent = getIntent();
        spell = lastIntent.getParcelableExtra(SpellsListFragment.EXTRA_POSITION);
        wireWidgets();
        effect.setText(spell.getEffect());
        name.setText(spell.getName());
        type.setText(spell.getType());
        counterSpell.setText(spell.getCounterSpell());

    }

    private void wireWidgets() {
        name = findViewById(R.id.textView_spellDescription_spellName);
        effect = findViewById(R.id.textView_spellDetail_effectText);
        type = findViewById(R.id.textView_spellDetail_typeText);
        counterSpell = findViewById(R.id.textView_spellDetail_counterSpellText);

    }
}
