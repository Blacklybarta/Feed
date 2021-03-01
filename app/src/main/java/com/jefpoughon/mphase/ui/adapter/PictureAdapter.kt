package com.jefpoughon.mphase.ui.adapter

import android.text.format.DateFormat
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.jefpoughon.mphase.R
import com.jefpoughon.mphase.extension.toChip
import com.jefpoughon.mphase.extension.toCompleteUrl
import com.jefpoughon.mphase.model.Article
import com.jefpoughon.mphase.utils.DatePatternUtils
import com.jefpoughon.mphase.utils.DateUtils
import com.jefpoughon.mphase.utils.StringUtils
import kotlinx.android.synthetic.main.article_row.view.*

class ArticleAdapter(private val articles: List<Article>) :
    RecyclerView.Adapter<ArticleAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ViewHolder(parent.inflate(R.layout.article_row))

    override fun onBindViewHolder(holder: ViewHolder, position: Int) =
        holder.bind(articles[position])

    override fun getItemCount() = articles.size

    private fun ViewGroup.inflate(layoutRes: Int): View {
        return LayoutInflater.from(context).inflate(layoutRes, this, false)
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(article: Article) = with(itemView) {
            chip_tags.removeAllViews()

            Glide.with(this)
                .load(article.thumbnail.toCompleteUrl())
                .fitCenter()
                .into(img_article)

            article.tags.forEach {
                chip_tags.addView(it.toChip(context))
            }

            tv_clock.text = DateUtils.formatDateByDeviceFormat(
                StringUtils.fromIso8601DateStringToTimestamp(article.publishedAt) ?: 0,
                DatePatternUtils.buildDeviceFormatPattern(DateFormat.is24HourFormat(context))
            )
            tv_title_article.text = article.title
        }
    }
}
