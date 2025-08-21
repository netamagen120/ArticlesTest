package com.article.articles.data.repository

import com.article.articles.constants.ArticleConstants.API_KEY
import com.article.articles.data.model.Article
import com.article.articles.data.network.ApiService
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ArticleRepository @Inject constructor(
    private val apiService: ApiService
) {
    
    suspend fun getTopHeadlines(): List<Article> {
        return try {
            val response = apiService.getTopHeadlines(
                apiKey = API_KEY
            )
            response.articles
        } catch (e: Exception) {
            emptyList()
        }
    }
}
