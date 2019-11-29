package com.taleb.movieproject.utils

import androidx.room.Database
import androidx.room.RoomDatabase
import com.taleb.movieproject.pojo.MovieDatabaseEntity
import com.taleb.movieproject.repository.dbInteractor.MoviesDAO

@Database(entities = [MovieDatabaseEntity::class], version = 1,exportSchema = false)
abstract class AppDatabase : RoomDatabase() {

    abstract fun moviesDAO():MoviesDAO
}