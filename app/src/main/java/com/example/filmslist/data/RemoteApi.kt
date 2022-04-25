package com.example.filmslist.data

import com.example.filmslist.dto.JSONResponse
import retrofit2.Call
import retrofit2.http.GET

interface RemoteApi {

    @GET("/svc/movies/v2/reviews/all.json?api-key=FdyNIk29N6orhkzuNNwWKg8Ny9Hpw2x9")
    fun getFilms(): Call<JSONResponse>
}