package com.example.PokedexKotlin

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_pokemon_screen.view.*

class PokiListAdp(val pokemonList: List<Pokemon>, val frgMng: FragmentManager) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)
            = PokiListVH(
        LayoutInflater.from(parent.context).inflate(
            R.layout.fragment_pokemon_screen,
            parent,
            false
        )
    )
    override fun getItemCount() = pokemonList.size
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        holder as PokiListVH
        holder.namePoki.setText(pokemonList.get(position).name)
        holder.imagePoki.setOnClickListener(object: View.OnClickListener {
            override fun onClick(v: View?) {
                val stats = ArrayList<String>()
                stats.add(0, "Nome:    ${pokemonList.get(position).name}")
                if (pokemonList.get(position).types.get(0).slot == 2){
                    stats.add(1, "Tipo:    ${pokemonList.get(position).types.get(0).type.nameT}"+"/" + ("${pokemonList.get(position).types.get(1).type.nameT}" ))

                }else{
                    stats.add(1, "Tipo:    ${pokemonList.get(position).types.get(0).type.nameT}")
                }
                stats.add(2, "Altura:  ${(pokemonList.get(position).height.toFloat())/10} m")
                stats.add(3, "Peso:  ${(pokemonList.get(position).weight.toFloat())/10} kg")
                stats.add(4, "HP:      ${pokemonList.get(position).stats.get(5).baseStat}")
                stats.add(5, "Defesa: ${pokemonList.get(position).stats.get(3).baseStat}")
                stats.add(6, "Ataque:  ${pokemonList.get(position).stats.get(4).baseStat}")

                stats.add(7, "Velocidade:   ${pokemonList.get(position).stats.get(0).baseStat}")
                stats.add(8,                     pokemonList.get(position).sprites.frontDefault)
                val args = Bundle()
                args.putStringArrayList("stats", stats)
                val pokiStatsFrg = FragmentPokemonStats()
                pokiStatsFrg.arguments = args
                frgMng.beginTransaction().add(R.id.contentLayout, pokiStatsFrg).addToBackStack("pokiStats").commit()
            }
        })
        Picasso.with(holder.itemView.context)
            .load(pokemonList.get(position).sprites.frontDefault)
            .placeholder(R.drawable.ic_launcher_round)
            .into(holder.imagePoki)
    }
}

class PokiListVH(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val imagePoki = itemView.imagePoki
    val namePoki  = itemView.namePoki
}

