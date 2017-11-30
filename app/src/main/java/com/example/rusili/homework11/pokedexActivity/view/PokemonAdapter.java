package com.example.rusili.homework11.pokedexActivity.view;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.rusili.homework11.R;
import com.example.rusili.homework11.pokedexActivity.model.Pokedex;
import com.example.rusili.homework11.pokedexActivity.model.objects.PokemonEntries;

import java.util.List;

/**
 * Created by yokilam on 11/29/17.
 */

public class PokemonAdapter extends RecyclerView.Adapter<PokemonViewHolder>{

    List<PokemonEntries> pokemonEntriesList;

    public PokemonAdapter(List<PokemonEntries> pokemonEntriesList) {
        this.pokemonEntriesList = pokemonEntriesList;
    }

    @Override
    public PokemonViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View childView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.poke_itemview, parent, false);
        return new PokemonViewHolder(childView);
    }

    @Override
    public void onBindViewHolder(PokemonViewHolder holder, int position) {
        holder.bind(pokemonEntriesList.get(position));
    }

    @Override
    public int getItemCount() {
        return pokemonEntriesList.size();
    }
}
