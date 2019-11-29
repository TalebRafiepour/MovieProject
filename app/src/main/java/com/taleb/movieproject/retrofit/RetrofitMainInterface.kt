package com.taleb.movieproject.retrofit

import com.taleb.movieproject.pojo.MovieSearchResultModel
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query


interface RetrofitMainInterface {

    @GET("search/company?api_key=d68cdc90928ad6e92d9d6d7491aa13eb")
    fun searchMovieByName(@Query("query") movieName: String): Observable<MovieSearchResultModel>

    @GET("movie/{movie_id}?api_key=d68cdc90928ad6e92d9d6d7491aa13eb")
    fun getMovieDetails(@Path("movie_id") movieId: Long):Observable<Any>
}
