package com.heptagon.heptagontaskappdemo.di

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.heptagon.heptagontaskappdemo.remote.HetpagonDataService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    private const val BASE_PATH: String = "https://heptagon.tech/"


    /**
     * To convert to and from JSON
     */
    @Provides
    fun provideGson(): Gson = GsonBuilder().create()

    @Provides
    fun provideGsonConverterFactory(gson: Gson): GsonConverterFactory =
        GsonConverterFactory.create(gson)

    @Singleton
    @Provides
    fun providesHttpLoggingInterceptor() = HttpLoggingInterceptor()
        .apply {
            level = HttpLoggingInterceptor.Level.BODY
        }
    @Provides
    fun provideOkHttpClient(httpLoggingInterceptor: HttpLoggingInterceptor): OkHttpClient =
        OkHttpClient()
            .newBuilder()
            .addInterceptor(httpLoggingInterceptor)
            .build()

    @Singleton
    @Provides
    fun provideRetrofit(
        gsonConverterFactory: GsonConverterFactory,
        okHttpClient: OkHttpClient
    ): Retrofit = Retrofit.Builder()
        .baseUrl(BASE_PATH)
        .client(okHttpClient)
        .addConverterFactory(gsonConverterFactory)
        .build()


    @Provides
    fun provideHetpagonDataService(retrofit: Retrofit): HetpagonDataService =
        retrofit.create(HetpagonDataService::class.java)
}