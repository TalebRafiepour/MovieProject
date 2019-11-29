package com.taleb.movieproject.base.di

import com.taleb.movieproject.base.BaseViewModelFactory
import com.taleb.movieproject.repository.DataRepository
import dagger.Component

@Component
interface DataRepositoryComponent {

    fun getDataRepository(): DataRepository

    fun getBaseViewModel(): BaseViewModelFactory
}