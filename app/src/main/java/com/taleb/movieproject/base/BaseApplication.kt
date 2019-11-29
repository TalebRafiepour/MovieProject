package com.taleb.movieproject.base

import android.app.Application
import com.orhanobut.logger.AndroidLogAdapter
import com.orhanobut.logger.Logger
import com.taleb.movieproject.base.di.DaggerDataProvidersComponent
import com.taleb.movieproject.base.di.DataProvidersComponent
import com.taleb.movieproject.base.di.RoomModule

class BaseApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        Logger.addLogAdapter(AndroidLogAdapter())

        component = DaggerDataProvidersComponent.builder().roomModule(RoomModule(this)).build()

    }

    companion object {
        private lateinit var component: DataProvidersComponent


        /**
         * Provides DataProvidersComponent
         */
        fun getDataProviderComponent(): DataProvidersComponent {
            return component
        }

    }
}