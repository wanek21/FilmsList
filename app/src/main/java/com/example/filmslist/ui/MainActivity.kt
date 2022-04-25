package com.example.filmslist.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import com.example.filmslist.R
import com.example.filmslist.log
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val viewModel: MainViewModel by lazy {
        ViewModelProvider(this)[MainViewModel::class.java]
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.Theme_FilmsList)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel.filmList.observe(this) { filmList ->
            log("count films: ${filmList.size}")
        }
    }
}