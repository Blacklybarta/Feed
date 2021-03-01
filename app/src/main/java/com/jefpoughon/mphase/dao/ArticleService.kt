package com.jefpoughon.mphase.dao

import com.jefpoughon.mphase.model.Article
import com.jefpoughon.mphase.common.HEROKUAPP_BEARER_TOKEN
import retrofit2.http.GET
import retrofit2.http.Header

interface ArticleService {

    @GET("/articles")
    suspend fun getArticles(@Header("Authorization") authHeader: String = HEROKUAPP_BEARER_TOKEN): List<Article>
}
