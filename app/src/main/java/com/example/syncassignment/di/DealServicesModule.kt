package com.example.syncassignment.di

import com.example.syncassignment.services.DealApiInterface
import com.example.syncassignment.services.DealServices
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

@Module
class DealServicesModule {

    @Provides
    fun provideDealServices() = DealServices()
}