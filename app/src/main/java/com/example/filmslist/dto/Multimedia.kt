package com.example.filmslist.dto

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Multimedia(
    @SerializedName("src")
    @Expose
    val src: String
)
