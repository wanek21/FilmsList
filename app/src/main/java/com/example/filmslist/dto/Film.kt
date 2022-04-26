package com.example.filmslist.dto

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Film(
    @SerializedName("display_title")
    @Expose
    val title: String,

    @SerializedName("summary_short")
    @Expose
    val summary: String,

    @SerializedName("display_title")
    @Expose
    val posterImageUrl: String
)