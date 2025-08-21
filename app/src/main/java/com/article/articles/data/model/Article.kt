package com.article.articles.data.model

import com.google.gson.annotations.SerializedName

data class Source(
    val id: String?,
    val name: String
)

data class Article(
    val source: Source,
    val author: String?,
    val title: String,
    val description: String,
    val url: String,
    @SerializedName("urlToImage")
    val imageUrl: String?,
    val publishedAt: String,
    val content: String?
)

data class NewsApiResponse(
    val status: String,
    val totalResults: Int,
    val articles: List<Article>
)
