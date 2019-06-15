package com.example.PokedexKotlin

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.fragment_pokemon_stat.*

class FragmentPokemonStats : Fragment() {
    private lateinit var rvList: RecyclerView

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?)
            = inflater.inflate(R.layout.fragment_pokemon_stat, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val imagePoki: ImageView = imagePokiStat
        recyclerCreate()
        val stats = arguments!!.getStringArrayList("stats")
        val imgUrl = stats.get(8)
        stats.removeAt(8)
        recyclerViewStat.adapter = PokiStatsAdp(stats, imgUrl, imagePoki)
    }

    fun recyclerCreate() {
        val linearLayoutManager = LinearLayoutManager(context)
        rvList = recyclerViewStat
        rvList.layoutManager = linearLayoutManager
        rvList.setHasFixedSize(true)
    }
}