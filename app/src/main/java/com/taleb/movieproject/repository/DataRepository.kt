package com.taleb.movieproject.repository

import com.taleb.movieproject.base.BaseApplication
import com.taleb.movieproject.pojo.MovieDatabaseEntity
import com.taleb.movieproject.pojo.MovieSearchResultModel
import com.taleb.movieproject.repository.dbInteractor.MoviesDAO
import com.taleb.movieproject.repository.di.DaggerDataProviderComponent
import com.taleb.movieproject.repository.networkInteractor.NetworkInteractor
import io.reactivex.Completable
import io.reactivex.Observable
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class DataRepository @Inject constructor() {

    private var network: NetworkInteractor
    private var database:MoviesDAO

    init {
        val component = DaggerDataProviderComponent.builder()
            .dataProvidersComponent(BaseApplication.getDataProviderComponent()).build()

        network = component.getNetworkInteractor()
        database = component.getDbInteractor()
    }

    fun searchMovieByName(movieName: String): Observable<MovieSearchResultModel> {
        return network.searchMovieByName(movieName)
    }

    fun getMovieDetails(movieId: Long): Observable<Any> {
        return network.getMovieDetails(movieId)
    }

    fun getAllSavedMovies(): Single<List<MovieDatabaseEntity>> {
        return database.getAllMovies()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }

    fun saveMovie(movieDatabaseEntity: MovieDatabaseEntity): Completable {
        return database.saveMovie(movieDatabaseEntity)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }

    fun doesMovieExists(movieId: Long): Single<Boolean> {
        return database.doesMovieExists(movieId)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }

    fun removeMovie(movieId: Long): Completable {
        return database.removeMovie(movieId)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }
}