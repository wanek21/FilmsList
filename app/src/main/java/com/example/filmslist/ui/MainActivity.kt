package com.example.filmslist.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.filmslist.R
import com.example.filmslist.log
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val viewModel: MainViewModel by lazy {
        ViewModelProvider(this)[MainViewModel::class.java]
    }

    private var rvFilmList: RecyclerView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.Theme_FilmsList)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvFilmList = findViewById(R.id.rvFilms)
        val linearLayoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        rvFilmList?.layoutManager = linearLayoutManager
        val filmsAdapter = FilmsAdapter()
        rvFilmList?.adapter = filmsAdapter

        rvFilmList?.addOnScrollListener(object : RecyclerView.OnScrollListener() {

            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {

                // check if we reached the end of recycler view
                if(linearLayoutManager.findLastVisibleItemPosition() == linearLayoutManager.itemCount-1){
                    if(viewModel.loading.value != true)
                        viewModel.loadFilms()
                }

                super.onScrolled(recyclerView, dx, dy)
            }
        })

        viewModel.filmList.observe(this) { filmList ->
            if(filmList != null) {
                filmsAdapter.addAll(filmList)
            }
        }
    }
}