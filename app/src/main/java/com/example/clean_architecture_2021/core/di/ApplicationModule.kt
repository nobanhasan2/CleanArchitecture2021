/**
 * Copyright (C) 2020 Fernando Cejas Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.clean_architecture_2021.core.di


import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import com.example.clean_architecture_2021.AndroidApplication
import com.example.clean_architecture_2021.features.login.LoginRepository
import com.example.clean_architecture_2021.util.PreferenceUtil
import com.ihsanbal.logging.LoggingInterceptor
import com.squareup.leakcanary.core.BuildConfig
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.internal.platform.Platform
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.Executors
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class ApplicationModule {

    @Singleton
    @Provides
    fun provideContext(application: AndroidApplication): Context = application.applicationContext
    @Singleton
    @Provides
    fun provideSharePref(context: Context): SharedPreferences = context.getSharedPreferences(PreferenceUtil.NON_BACKED_UP_NAME, Context.MODE_PRIVATE)
    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("http://phantom-srv.kaz.com.bd/CCDB.lb/")
            .client(createClient())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    private fun createClient(): OkHttpClient {
        val okHttpClientBuilder: OkHttpClient.Builder = OkHttpClient.Builder()

        okHttpClientBuilder.addInterceptor { chain -> chain.proceed(chain.request().newBuilder().build()) }
        val loggingInterceptor = LoggingInterceptor.Builder()
            .setLevel(com.ihsanbal.logging.Level.BASIC)
            .log(Platform.INFO)
            .request("Request")
            .response("Response")
            .build()
        okHttpClientBuilder.addInterceptor(loggingInterceptor)

        return okHttpClientBuilder.build()
    }

    @Provides
    @Singleton
    fun provideLoginRepository(dataSource: LoginRepository.Network): LoginRepository = dataSource
}
