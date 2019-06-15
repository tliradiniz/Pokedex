package com.example.PokedexKotlin

import com.google.gson.annotations.SerializedName

data class Types(
    @SerializedName("slot") val slot: Int,
    @SerializedName("type") val type: ListTypes
)