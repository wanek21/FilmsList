package com.example.filmslist.data

import com.example.filmslist.dto.Film
import com.example.filmslist.dto.Result
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class FilmsRepository @Inject constructor(
    private val remoteApi: RemoteApi
) {

    suspend fun getFilms(): ArrayList<Film>? {
        return withContext(Dispatchers.IO) {
            val jsonResponse = remoteApi.getFilms()
            val response = jsonResponse.execute()
            if(response.isSuccessful) {
                var resultList = response.body()?.results as ArrayList<Result>

                var filmList = arrayListOf<Film>()
                resultList.forEach {
                    filmList.add(Film(
                            title = it.displayTitle,
                            summary = it.summaryShort,
                            imageUrl = it.multimedia.src
                        ))
                }
                filmList
            } else null
        }
    }
}