package com.mhl.cinemarate.di

import android.content.Context
import com.mhl.cinemarate.R
import com.mhl.cinemarate.repository.imdb.ImdbDataRepository
import com.mhl.cinemarate.repository.imdb.ImdbService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class ImdbModule {

    @Provides
    @Named("ImdbBaseURL")
    fun provideImdbUrl() : String = "https://imdb-api.com/ru/API/"


    @Provides
    @Singleton
    @Named("ImdbRetrofit")
    fun provideRetrofit(@Named("ImdbBaseURL") baseUrl : String) : Retrofit =
        Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()


    @Provides
    @Named("ImdbService")
    @Singleton
    fun provideImdbService(@Named("ImdbRetrofit") retrofit : Retrofit) : ImdbService =
        retrofit.create(ImdbService::class.java)


    @Provides
    @Singleton
    @Named("ImdbRepository")
    fun provideImdbRepository(@Named("ImdbService")imdbService: ImdbService, @ApplicationContext context: Context) : ImdbDataRepository =
        ImdbDataRepository(imdbService, context.getString(R.string.imdb_api_key))

}