package com.taleb.movieproject.features.movieSearch

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.taleb.movieproject.R
import com.taleb.movieproject.pojo.MovieModel
import kotlinx.android.synthetic.main.movie_item_layout.view.*

class MovieItemViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    fun bind(item: MovieModel, onItemClick: (MovieModel)->Unit) {
        itemView.movieTitletextView.text = item.name
        itemView.movieDescTextView.text = "${item.id}"

        Glide.with(itemView)
            .load(item.logoPath)
            .into(itemView.movieIcon)
            .onLoadFailed(itemView.context.getDrawable(R.drawable.movie_default))

        itemView.movieSaveButton.setOnClickListener {
            onItemClick(item)
        }
    }

}