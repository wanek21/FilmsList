package com.example.filmslist.dto

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Result(
    @SerializedName("display_title")
    @Expose
    val displayTitle: String,

    @SerializedName("summary_short")
    @Expose
    val summaryShort: String,

    @SerializedName("multimedia")
    @Expose
    val multimedia: Multimedia
)
