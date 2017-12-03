package com.example.rusili.homework11.pokedexActivity.view;

import android.content.Intent;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.rusili.homework11.R;
import com.example.rusili.homework11.detailscreen.view.PokemonDetailActivity;


import com.example.rusili.homework11.pokedexActivity.model.Pokedex;
import com.example.rusili.homework11.pokedexActivity.model.objects.PokemonEntries;

import org.w3c.dom.Text;

/**
 * Created by yokilam on 11/29/17.
 */

public class PokemonViewHolder extends RecyclerView.ViewHolder {

    private TextView pokemonName;
    private TextView idNumber;

    private ImageView sprite;
    private CardView cardView;


    public PokemonViewHolder(View itemView) {
        super(itemView);
        pokemonName= itemView.findViewById(R.id.name_view);

        idNumber= itemView.findViewById(R.id.pokemon_id_view);
        sprite = itemView.findViewById(R.id.rv_pokemon_image);
        cardView= itemView.findViewById(R.id.card_view);

        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), PokemonDetailActivity.class);
                intent.putExtra("pokemonName", pokemonName.getText().toString());
                intent.putExtra("pokemonId", idNumber.getText().toString());
                Log.d("pokemonid", idNumber.getText().toString());
                view.getContext().startActivity(intent);

            }
        });
    }

    public void bind(PokemonEntries pokemonEntries) {
        pokemonName.setText(pokemonEntries.getPokemon_species().getName());

        idNumber.setText(String.valueOf(pokemonEntries.getEntry_number()));

        StringBuilder stringBuilder = new StringBuilder("https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/");
        stringBuilder.append(pokemonEntries.getEntry_number()).append(".png");

        Glide.with(itemView)
                .load(stringBuilder.toString())
                .into(sprite);


    }
}
