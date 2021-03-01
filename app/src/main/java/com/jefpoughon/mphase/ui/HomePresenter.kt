package com.jefpoughon.mphase.ui

import com.jefpoughon.mphase.dao.ArticleService
import com.jefpoughon.mphase.model.Article
import com.jefpoughon.mphase.utils.NetworkUtils
import kotlinx.coroutines.*
import org.koin.core.KoinComponent
import org.koin.core.inject

class HomePresenter : KoinComponent {

    private val articleService: ArticleService by inject()
    private lateinit var homeActivity: HomeActivity

    fun setUp(activity: HomeActivity) {
        homeActivity = activity
        loadNews()
    }

    fun loadNews() {
        if (NetworkUtils.isNetworkConnected()) {
            GlobalScope.launch(Dispatchers.Main) {
                // async task to get articles from API
                val result: Deferred<List<Article>> = GlobalScope.async {
                    articleService.getArticles()
                }
                // get the downloaded articles
                homeActivity.refresh(result.await())
            }
        } else {
            homeActivity.showNetworkError()
        }
    }
}
