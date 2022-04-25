package com.example.filmslist.dto

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class JSONResponse(
    @SerializedName("results")
    @Expose
    var results: List<Result>? = null
)