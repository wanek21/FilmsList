package com.example.filmslist.data

import com.example.filmslist.BuildConfig
import com.example.filmslist.dto.JSONResponse
import retrofit2.Call
import retrofit2.http.GET

interface RemoteApi {

    @GET("/svc/movies/v2/reviews/all.json?api-key=${BuildConfig.API_KEY}")
    fun getFilms(): Call<JSONResponse>
}