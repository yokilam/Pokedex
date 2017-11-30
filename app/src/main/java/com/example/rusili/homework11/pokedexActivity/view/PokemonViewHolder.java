package com.example.rusili.homework11.pokedexActivity.view;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.rusili.homework11.R;
import com.example.rusili.homework11.pokedexActivity.model.Pokedex;
import com.example.rusili.homework11.pokedexActivity.model.objects.PokemonEntries;

import org.w3c.dom.Text;

/**
 * Created by yokilam on 11/29/17.
 */

public class PokemonViewHolder extends RecyclerView.ViewHolder {

    private TextView pokemonName;
    private TextView idNumber;

    public PokemonViewHolder(View itemView) {
        super(itemView);
        pokemonName= itemView.findViewById(R.id.name_view);

        pokemonName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), PokemonMainActivity.class);
                intent.putExtra("pokemonName", pokemonName.getText().toString());
                v.getContext().startActivity(intent);
            }
        });
    }

    public void bind(PokemonEntries pokemonEntries) {
        pokemonName.setText(pokemonEntries.getPokemon_species().getName());
    }
}
