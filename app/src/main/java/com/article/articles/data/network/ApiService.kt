package com.article.articles.data.network

import com.article.articles.constants.ArticleConstants.BBC_NEWS
import com.article.articles.data.model.NewsApiResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("v2/top-headlines")
    suspend fun getTopHeadlines(
        @Query("sources") sources: String = BBC_NEWS,
        @Query("apiKey") apiKey: String,
        @Query("page") page: Int = 1,
        @Query("pageSize") pageSize: Int = 20
    ): NewsApiResponse
}
