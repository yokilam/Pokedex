package com.example.rusili.homework11.pokedexActivity.view;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.rusili.homework11.R;
import com.example.rusili.homework11.network.RetrofitFactory;
import com.example.rusili.homework11.pokedexActivity.model.Pokedex;

/**
 * Created by rusi.li on 11/22/17.
 */

public class PokedexFragment extends Fragment {
	private RetrofitFactory.PokedexNetworkListener pokedexNetworkListener;

	@Nullable
	@Override
	public View onCreateView (@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		View view = inflater.inflate();

		getPokedexList();

		return view;
	}

	private void getPokedexList () {
		pokedexNetworkListener = new RetrofitFactory.PokedexNetworkListener() {
			@Override
			public void pokedexCallback (Pokedex pokedex) {
				// TODO: show Pokemon
				// Each pokemon is in the Pokemon_Species object.
			}
		};
		RetrofitFactory.getInstance().setPokedexListener(pokedexNetworkListener);
		RetrofitFactory.getInstance().getPokedex(2);
	}
}
