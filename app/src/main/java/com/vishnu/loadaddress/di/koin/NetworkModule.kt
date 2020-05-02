package com.vishnu.loadaddress.di.koin

import com.vishnu.loadaddress.BuildConfig
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

val networkModule = module {

    factory { provideLoggingInterceptor() }
    factory { provideHttpClient(get()) }
    factory { provideRetrofitBuilder(get()) }
}

private fun provideRetrofitBuilder(httpClient: OkHttpClient): Retrofit.Builder {
    return Retrofit.Builder()
        .baseUrl("https://digi-api.airtel.in/")
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .client(httpClient)
}

private fun provideHttpClient(loggingInterceptor: HttpLoggingInterceptor): OkHttpClient {
    val httpClient = OkHttpClient.Builder()
    if (BuildConfig.DEBUG) httpClient.addInterceptor(loggingInterceptor)
    return httpClient.build()
}

private fun provideLoggingInterceptor(): HttpLoggingInterceptor {
    val loggingInterceptor = HttpLoggingInterceptor()
    loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
    return loggingInterceptor
}
