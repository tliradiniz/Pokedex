package com.example.PokedexKotlin.model

import com.google.gson.annotations.SerializedName

data class ListTypes (
    @SerializedName("name")       val nameT: String,
    @SerializedName("url")        val urlT: Any
    )