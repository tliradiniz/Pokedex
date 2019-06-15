package com.example.PokedexKotlin

import com.google.gson.annotations.SerializedName

data class ListTypes (
    @SerializedName("name")       val nameT: String,
    @SerializedName("url")        val urlT: Any
    )