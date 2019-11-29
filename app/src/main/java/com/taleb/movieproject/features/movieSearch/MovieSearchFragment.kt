package com.taleb.movieproject.features.movieSearch


import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.taleb.movieproject.R
import com.taleb.movieproject.base.BaseViewModelFactory
import com.taleb.movieproject.base.di.DaggerDataRepositoryComponent
import kotlinx.android.synthetic.main.fragment_movie_search.view.*

/**
 * A simple [Fragment] subclass.
 */
class MovieSearchFragment : Fragment() {

    private lateinit var movieSearchRecyclerView:RecyclerView
    private lateinit var movieSearchRecyclerAdapter : MovieRecyclerAdapter
    private lateinit var viewModel: MovieSearchViewModel
    private lateinit var viewModelFactory: BaseViewModelFactory

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_movie_search, container, false)
        initRecyclerView(view,context!!)
        val dataRepository = DaggerDataRepositoryComponent.create().getDataRepository()
        viewModelFactory = BaseViewModelFactory(dataRepository)
        viewModel = ViewModelProviders.of(this,viewModelFactory).get(MovieSearchViewModel::class.java)

        viewModel.getMovieSearchData().observe(this, Observer {
            movieSearchRecyclerAdapter.setMovieSearchResult(it)
        })

        view.movieSearchButton.setOnClickListener {
            viewModel.searchMovie(view.movieSearchEditText.text.toString())
        }

        return view
    }

    private fun initRecyclerView(view:View, context: Context) {
        movieSearchRecyclerView = view.movieSearchRecyclerView
        movieSearchRecyclerView.layoutManager =
            LinearLayoutManager(context, RecyclerView.VERTICAL, false)
        movieSearchRecyclerAdapter = MovieRecyclerAdapter {
            Toast.makeText(context, "Movie Saved : $it", Toast.LENGTH_LONG).show()
            viewModel.saveMovie(it)
        }
        movieSearchRecyclerView.adapter = movieSearchRecyclerAdapter
    }



}
