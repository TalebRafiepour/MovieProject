package com.taleb.movieproject.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.taleb.movieproject.features.movieSearch.MovieSearchViewModel
import com.taleb.movieproject.repository.DataRepository
import javax.inject.Inject

class BaseViewModelFactory @Inject constructor (private val  repository: DataRepository): ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {

        return when {
            modelClass.isAssignableFrom(MovieSearchViewModel::class.java) -> MovieSearchViewModel(repository) as T
            else -> throw IllegalStateException("You haven't provided factory for this ViewModel")
        }
    }
}