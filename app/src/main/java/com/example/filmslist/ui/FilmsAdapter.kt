package com.example.filmslist.ui

import android.graphics.Movie
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.filmslist.R
import com.example.filmslist.dto.Film
import com.squareup.picasso.Picasso


class FilmsAdapter() : RecyclerView.Adapter<FilmsAdapter.FilmViewHolder>() {

    private val filmList: ArrayList<Film> = arrayListOf()

    class FilmViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvFilmTitle = itemView.findViewById<TextView>(R.id.tvTitle)
        val tvFilmSummary = itemView.findViewById<TextView>(R.id.tvSummary)
        val imgFilmPoster = itemView.findViewById<ImageView>(R.id.image)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FilmViewHolder {
        val itemView =
            LayoutInflater.from(parent.context)
                .inflate(R.layout.film_item, parent, false)
        return FilmViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: FilmViewHolder, position: Int) {
        holder.tvFilmTitle.text = filmList[position].title
        holder.tvFilmSummary.text = filmList[position].summary
        Picasso.get()
            .load(filmList[position].posterImageUrl)
            .into(holder.imgFilmPoster)
    }

    fun add(film: Film) {
        filmList.add(film)
        notifyItemInserted(filmList.size - 1)
    }

    fun addAll(moveResults: List<Film>) {
        for (result in moveResults) {
            add(result)
        }
    }

    override fun getItemCount() = filmList.size
}