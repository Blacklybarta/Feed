package com.jefpoughon.mphase.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import com.jefpoughon.mphase.R
import com.jefpoughon.mphase.model.Article
import com.jefpoughon.mphase.ui.adapter.ArticleAdapter
import kotlinx.android.synthetic.main.activity_home.*
import kotlinx.android.synthetic.main.content_layout.*
import org.koin.core.KoinComponent

class HomeActivity : AppCompatActivity(), KoinComponent {

    private val presenter = HomePresenter()

    private lateinit var articleAdapter: RecyclerView.Adapter<*>

    private val articles = ArrayList<Article>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        initRecyclerView()
        initSwipe()
        initPresenter()
    }

    override fun onResume() {
        super.onResume()
        initRefreshButton()
    }

    private fun initRecyclerView() {

        val viewManager = LinearLayoutManager(this)
        articleAdapter = ArticleAdapter(articles)

        rv_articles.apply {
            layoutManager = viewManager
            adapter = articleAdapter
        }
    }

    private fun initSwipe() {
        swipeContainer.setOnRefreshListener {
            presenter.loadNews()
        }
    }

    private fun initPresenter() {
        presenter.setUp(this)
        swipeContainer.isRefreshing = true
    }

    private fun initRefreshButton() {
        bottomAppBar.setNavigationOnClickListener {
            presenter.loadNews()
        }
    }

    fun showNetworkError() {
        Snackbar.make(homeLayout, getString(R.string.no_network), Snackbar.LENGTH_SHORT).show()
    }

    fun refresh(data: List<Article>) {
        swipeContainer.isRefreshing = false
        if (data.isEmpty()) {
            Snackbar.make(homeLayout, getString(R.string.no_news), Snackbar.LENGTH_SHORT).show()
        } else {
            articles.addAll(0, data)
            articleAdapter.notifyDataSetChanged()
        }
    }
}
