package com.taleb.movieproject.base.di

import com.taleb.movieproject.repository.dbInteractor.MoviesDAO
import com.taleb.movieproject.retrofit.RetrofitMainInterface
import com.taleb.movieproject.retrofit.RetrofitModule
import com.taleb.movieproject.utils.AppDatabase
import dagger.Component
import retrofit2.Retrofit
import javax.inject.Singleton

/**
 *
 * A dagger component to provide retrofit and room
 */
@Singleton
@Component(modules = [RetrofitModule::class, RoomModule::class])
interface DataProvidersComponent {

    fun getRetrofit(): Retrofit

    fun getRetrofitMainInterface(): RetrofitMainInterface

    fun getAppDataBase(): AppDatabase

    fun getMoviesDAO(): MoviesDAO

}