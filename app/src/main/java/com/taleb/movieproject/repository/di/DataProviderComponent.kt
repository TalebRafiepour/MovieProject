package com.taleb.movieproject.repository.di

import com.taleb.movieproject.base.di.DataProvidersComponent
import com.taleb.movieproject.repository.dbInteractor.MoviesDAO
import com.taleb.movieproject.repository.networkInteractor.NetworkInteractor
import com.taleb.movieproject.utils.CustomScope
import dagger.Component

/**
 * This class provides network and database classes for the repository class
 */
@CustomScope
@Component(dependencies = [DataProvidersComponent::class])
interface DataProviderComponent {

    /**
     * Provides network interactor for project by Dagger
     */
    fun getNetworkInteractor(): NetworkInteractor

    /**
     * Provides room db interactor by Dagger for project
     */
    fun getDbInteractor(): MoviesDAO
}