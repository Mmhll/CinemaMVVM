package com.mhl.cinemarate.di

import android.content.Context
import com.mhl.cinemarate.R
import com.mhl.cinemarate.repository.kinopoisk.KinopoiskDataRepository
import com.mhl.cinemarate.repository.kinopoisk.KinopoiskService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.components.FragmentComponent
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Named
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class KinopoiskModule {

    @Provides
    @Named("KinopoiskBaseURL")
    fun provideKinopoiskUrl() : String = "https://kinopoiskapiunofficial.tech/api/v2.2/films/"

    @Provides
    @Singleton
    @Named("KinopoiskRetrofit")
    fun provideRetrofit(@Named("KinopoiskBaseURL") baseUrl : String) : Retrofit =
        Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    @Provides
    @Singleton
    @Named("KinopoiskService")
    fun provideKinopoiskService(@Named("KinopoiskRetrofit") retrofit : Retrofit) : KinopoiskService =
        retrofit.create(KinopoiskService::class.java)

    @Provides
    @Singleton
    @Named("KinopoiskRepository")
    fun provideKinopoiskRepository(@Named("KinopoiskService") kinopoiskService: KinopoiskService, @ApplicationContext context:Context) : KinopoiskDataRepository =
        KinopoiskDataRepository(kinopoiskService, context.getString(R.string.kinopoisk_key))

}