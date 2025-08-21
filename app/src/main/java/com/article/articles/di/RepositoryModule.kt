package com.article.articles.di

import com.article.articles.data.network.ApiService
import com.article.articles.data.repository.ArticleRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {
    
    @Provides
    @Singleton
    fun provideArticleRepository(
        apiService: ApiService
    ): ArticleRepository {
        return ArticleRepository(apiService)
    }
}
