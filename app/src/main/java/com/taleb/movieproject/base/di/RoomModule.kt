package com.taleb.movieproject.base.di

import androidx.room.Room
import com.taleb.movieproject.base.BaseApplication
import com.taleb.movieproject.repository.dbInteractor.MoviesDAO
import com.taleb.movieproject.utils.AppDatabase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module
class RoomModule(private val baseApplication: BaseApplication) {

    @Singleton
    @Provides
    fun database(): AppDatabase {
        return Room.databaseBuilder(baseApplication.applicationContext, AppDatabase::class.java, "movies.db").build()

    }

    @Singleton
    @Provides
    fun provideMoviesDAO(appDatabase: AppDatabase): MoviesDAO {
        return appDatabase.moviesDAO()
    }

}