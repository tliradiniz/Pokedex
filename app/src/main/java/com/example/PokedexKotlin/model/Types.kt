package com.example.PokedexKotlin.model

import com.google.gson.annotations.SerializedName

data class Types(
    @SerializedName("slot") val slot: String,
    @SerializedName("type") val type: ListTypes
)