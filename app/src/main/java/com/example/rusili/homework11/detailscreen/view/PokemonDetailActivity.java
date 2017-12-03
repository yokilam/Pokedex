package com.example.rusili.homework11.detailscreen.view;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.rusili.homework11.R;
import com.example.rusili.homework11.detailscreen.model.Pokemon;
import com.example.rusili.homework11.detailscreen.model.objects.Stats;
import com.example.rusili.homework11.network.RetrofitFactory;

public class PokemonDetailActivity extends AppCompatActivity{
	private RetrofitFactory.PokemonNetworkListener pokemonNetworkListener;

	private String pokemonName;
	private String id;

	private TextView type1;
	private TextView type2;
	private ProgressBar hpbar;
	private ProgressBar atkbar;
	private ProgressBar spAtkbar;
	private ProgressBar spDefbar;
	private ProgressBar defensebar;
	private ProgressBar speedbar;




	@Override
	public void onCreate (@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.detail_activity_layout);

		Intent intent= getIntent();
		pokemonName = intent.getStringExtra("pokemonName");
		id = intent.getStringExtra("pokemonId");

		type1= findViewById(R.id.pokemon_type1);
		type2= findViewById(R.id.pokemon_type2);

		hpbar = findViewById(R.id.hp_bar);
		atkbar = findViewById(R.id.atk_bar);
		spAtkbar = findViewById(R.id.sp_atk_bar);
		spDefbar = findViewById(R.id.sp_defense_bar);
		defensebar = findViewById(R.id.defense_bar);
		speedbar = findViewById(R.id.speed_bar);

		initialize();
		TextView name= findViewById(R.id.detail_pokemon_name);
		name.setText(pokemonName);
        TextView pokemonId= findViewById(R.id.region_number);
        pokemonId.setText("# "+ id);
	}

	private void initialize () {
		getPokemonDetails();
	}

	private void getPokemonDetails () {
		pokemonNetworkListener = new RetrofitFactory.PokemonNetworkListener() {
			@Override
			public void pokemonCallback (Pokemon pokemon) {
				//TODO: Display pokemon data

				//Hint: Learn how to use Glide to display an image.
				Glide.with(getApplicationContext())
						.load(pokemon.getSprites().getFront_default())
						.into((ImageView)findViewById(R.id.pokemon_image));

                Log.e("stats", ""+pokemon.getStats()[0].getBase_stat());
                Log.e("types", ""+pokemon.getTypes().length);

                if(pokemon.getTypes().length == 2) {
                    Log.e("type", "Running type 2");
                    changeColor(pokemon.getTypes()[1].getType().getName(),2);
                    changeColor(pokemon.getTypes()[0].getType().getName(),1);
                    type2.setVisibility(TextView.VISIBLE);
                } else {
                    Log.e("type", "Running type 1");
                    changeColor(pokemon.getTypes()[0].getType().getName(),1);
                }

                Log.e("type", ""+pokemon.getTypes()[pokemon.getTypes().length-1].getType().getName());

				Stats[] stats= pokemon.getStats();
				//pokemon.getTypes()[0].getType();


                Log.e("stats", ""+stats.length);

				for (int i=0; i <stats.length; i++) {
					//pokemonStats.setText(pokemon.getStats()[i].getBase_stat());
					Log.e("stats", ""+pokemon.getStats()[i].getStat().getName()+ ": "+ pokemon.getStats()[i].getBase_stat());

					switch (pokemon.getStats()[i].getStat().getName()) {
                        case "speed" :
                            speedbar.setProgress(pokemon.getStats()[i].getBase_stat());
                            Log.e("stats", "speed"+pokemon.getStats()[i].getBase_stat());
                            break;
                        case "special-defense":
                            spDefbar.setProgress(pokemon.getStats()[i].getBase_stat());
                            Log.e("stats", "special-defense"+pokemon.getStats()[i].getBase_stat());
                            break;
                        case "special-attack":
                            spAtkbar.setProgress(pokemon.getStats()[i].getBase_stat());
                            Log.e("stats", "special-attack"+pokemon.getStats()[i].getBase_stat());
                            break;
                        case "defense":
                            defensebar.setProgress(pokemon.getStats()[i].getBase_stat());
                            Log.e("stats", "defense"+pokemon.getStats()[i].getBase_stat());
                            break;
                        case "attack":
                            atkbar.setProgress(pokemon.getStats()[i].getBase_stat());
                            Log.e("stats", "attack"+pokemon.getStats()[i].getBase_stat());
                            break;
                        case "hp":
                            int hp= pokemon.getStats()[i].getBase_stat();
                            hpbar.setProgress(hp);
                            Log.e("stats", "hp"+pokemon.getStats()[i].getBase_stat());
                            break;

                    }
				}
			}
		};
		RetrofitFactory.getInstance().setPokemonNetworkListener(pokemonNetworkListener);
		RetrofitFactory.getInstance().getPokemon(pokemonName);
	}

	private void changeColor(String type, int num) {

	    switch (type) {
            case "bug":
                if (num == 2) {
                    type2.setText("Bug");
                   type2.setBackgroundResource(R.color.bug);
                } else {
                    type1.setBackgroundResource(R.color.bug);
                    type1.setText("Bug");
                }
                break;
            case "dragon":
                if (num == 2) {
                    type2.setText("Dragon");
                    type2.setBackgroundResource(R.color.dragon);
                } else {
                    type1.setBackgroundResource(R.color.dragon);
                    type1.setText("Dragon");
                }
                break;
            case "ice":
                if (num == 2) {
                    type2.setText("Ice");
                    type2.setBackgroundResource(R.color.ice);
                } else {
                    type1.setBackgroundResource(R.color.ice);
                    type1.setText("Ice");
                }
                break;
            case "fighting":
                if (num == 2) {
                    type2.setText("Fighting");
                    type2.setBackgroundResource(R.color.fighting);
                } else {
                    type1.setBackgroundResource(R.color.fighting);
                    type1.setText("Fighting");
                }
                break;
            case "fire":
                if (num == 2) {
                    type2.setText("Fire");
                    type2.setBackgroundResource(R.color.fire);
                } else {
                    type1.setBackgroundResource(R.color.fire);
                    type1.setText("Fire");
                }
                break;
            case "flying":
                if (num == 2) {
                    type2.setText("Flying");
                    type2.setBackgroundResource(R.color.flying);
                } else {
                    type1.setBackgroundResource(R.color.flying);
                    type1.setText("Flying");
                }
                break;
            case "grass":
                if (num == 2) {
                    type2.setText("Grass");
                    type2.setBackgroundResource(R.color.grass);
                } else {
                    type1.setBackgroundResource(R.color.grass);
                    type1.setText("Grass");
                }
                break;
            case "ghost":
                if (num == 2) {
                    type2.setText("Ghost");
                    type2.setBackgroundResource(R.color.ghost);
                } else {
                    type1.setBackgroundResource(R.color.ghost);
                    type1.setText("Ghost");
                }
                break;
            case "ground":
                if (num == 2) {
                    type2.setText("Ground");
                    type2.setBackgroundResource(R.color.ground);
                } else {
                    type1.setBackgroundResource(R.color.ground);
                    type1.setText("Ground");
                }
                break;
            case "electric":
                if (num == 2) {
                    type2.setText("Electric");
                    type2.setBackgroundResource(R.color.electric);
                } else {
                    type1.setBackgroundResource(R.color.electric);
                    type1.setText("Electric");
                }
                break;
            case "normal":
                if (num == 2) {
                    type2.setText("Normal");
                    type2.setBackgroundResource(R.color.normal);
                } else {
                    type1.setBackgroundResource(R.color.normal);
                    type1.setText("Normal");
                }
                break;
            case "poison":
                if (num == 2) {
                    type2.setText("Poison");
                    type2.setBackgroundResource(R.color.poison);
                } else {
                    type1.setBackgroundResource(R.color.poison);
                    type1.setText("Poison");
                }
                break;
            case "psychic":
                if (num == 2) {
                    type2.setText("Psychic");
                    type2.setBackgroundResource(R.color.psychic);
                } else {
                    type1.setBackgroundResource(R.color.psychic);
                    type1.setText("Psychic");
                }
                break;
            case "rock":
                if (num == 2) {
                    type2.setText("Rock");
                    type2.setBackgroundResource(R.color.rock);
                } else {
                    type1.setBackgroundResource(R.color.rock);
                    type1.setText("Rock");
                }
                break;
            case "water":
                if (num == 2) {
                    type2.setText("Water");
                    type2.setBackgroundResource(R.color.water);
                } else {
                    type1.setBackgroundResource(R.color.water);
                    type1.setText("Water");
                }
                break;
        }

    }
}

