package com.example.PokedexKotlin.adapters

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.RecyclerView
import com.example.PokedexKotlin.R
import com.example.PokedexKotlin.fragments.PokiStatsFrg
import com.example.PokedexKotlin.model.Pokemon
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.poki_list_hld.view.*

class PokiListAdp(val pokiList: List<Pokemon>, val frgMng: FragmentManager) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)
            = PokiListVH(LayoutInflater.from(parent.context).inflate(R.layout.poki_list_hld, parent, false))
    override fun getItemCount() = pokiList.size
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        holder as PokiListVH
        holder.namePoki.setText(pokiList.get(position).name)
        holder.imagePoki.setOnClickListener(object: View.OnClickListener {
            override fun onClick(v: View?) {
                val stats = ArrayList<String>()
                stats.add(0, "Name:    ${pokiList.get(position).name}")
                stats.add(1, "Tipo:    ${pokiList.get(position).types.get(0).type.nameT}"+"/" + ("${pokiList.get(position).types.get(1).type.nameT}" ))
                stats.add(2, "Height:  ${pokiList.get(position).height}")
                stats.add(3, "Weight:  ${pokiList.get(position).weight}")
                stats.add(4, "Defense: ${pokiList.get(position).stats.get(3).baseStat}")
                stats.add(5, "Attack:  ${pokiList.get(position).stats.get(4).baseStat}")
                stats.add(6, "HP:      ${pokiList.get(position).stats.get(5).baseStat}")
                stats.add(7, "Speed:   ${pokiList.get(position).stats.get(0).baseStat}")
                stats.add(8,                     pokiList.get(position).sprites.frontDefault)
                val args = Bundle()
                args.putStringArrayList("stats", stats)
                val pokiStatsFrg = PokiStatsFrg()
                pokiStatsFrg.arguments = args
                frgMng.beginTransaction().add(R.id.contentLayout, pokiStatsFrg).addToBackStack("pokiStats").commit()
            }
        })
        Picasso.with(holder.itemView.context)
            .load(pokiList.get(position).sprites.frontDefault)
            .placeholder(R.drawable.ic_launcher_round)
            .into(holder.imagePoki)
    }
}

class PokiListVH(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val imagePoki = itemView.imagePoki
    val namePoki  = itemView.namePoki
}

