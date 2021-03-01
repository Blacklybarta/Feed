package com.jefpoughon.mphase.di

import com.jefpoughon.mphase.dao.ArticleService
import com.jefpoughon.mphase.common.HEROKUAPP_BASE_URL
import okhttp3.OkHttpClient
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory

val appModule by lazy {
    module {

        single {
            val retrofit = Retrofit.Builder().apply {
                client(OkHttpClient.Builder().build())
                baseUrl(HEROKUAPP_BASE_URL)
                addConverterFactory(ScalarsConverterFactory.create())
                addConverterFactory(GsonConverterFactory.create())
            }.build()

            retrofit.create(ArticleService::class.java)
        }
    }
}
