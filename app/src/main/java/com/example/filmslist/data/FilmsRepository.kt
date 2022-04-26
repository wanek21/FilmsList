package com.example.filmslist.data

import com.example.filmslist.dto.Film
import com.example.filmslist.dto.Result
import com.example.filmslist.log
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class FilmsRepository @Inject constructor(
    private val remoteApi: RemoteApi
) {

    // for tests
    private val filmsOnPage = 4
    private var currentFilm = 0

    suspend fun getFilms(): ArrayList<Film>? {
        return withContext(Dispatchers.IO) {
            if(currentFilm < 20) {
                val jsonResponse = remoteApi.getFilms()
                val response = jsonResponse.execute()
                if (response.isSuccessful) {
                    var resultList = response.body()?.results as ArrayList<Result>

                    var filmList = arrayListOf<Film>()
                    resultList.forEach {
                        filmList.add(
                            Film(
                                title = it.displayTitle,
                                summary = it.summaryShort,
                                posterImageUrl = it.multimedia.src
                            )
                        )
                    }

                    // for tests
                    val filmsOnCurrentPageList = arrayListOf<Film>()
                    for (i in currentFilm until currentFilm + filmsOnPage) {
                        filmsOnCurrentPageList.add(filmList[i])
                        currentFilm++
                    }
                    filmsOnCurrentPageList
                } else null
            } else null
        }
    }
}