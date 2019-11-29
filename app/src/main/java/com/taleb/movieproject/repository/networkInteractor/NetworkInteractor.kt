package com.taleb.movieproject.repository.networkInteractor

import com.taleb.movieproject.pojo.MovieSearchResultModel
import com.taleb.movieproject.retrofit.RetrofitMainInterface
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class NetworkInteractor @Inject constructor(private val retrofitInterface: RetrofitMainInterface) {

    fun searchMovieByName(movieName: String): Observable<MovieSearchResultModel> {
        return retrofitInterface.searchMovieByName(movieName)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }

    fun getMovieDetails(movieId: Long): Observable<Any>{
        return retrofitInterface.getMovieDetails(movieId)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }

}