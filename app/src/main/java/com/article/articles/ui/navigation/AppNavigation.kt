package com.article.articles.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.article.articles.constants.ArticleConstants.ARTICLE
import com.article.articles.constants.ArticleConstants.TITLE
import com.article.articles.constants.ArticleConstants.URL
import com.article.articles.ui.screens.ArticlesScreen
import com.article.articles.ui.screens.WebViewScreen

@Composable
fun AppNavigation(
    navController: NavHostController = rememberNavController()
) {
    NavHost(
        navController = navController,
        startDestination = Screen.Articles.route
    ) {
        composable(route = Screen.Articles.route) {
            ArticlesScreen(
                onArticleClick = { url, title ->
                    navController.navigate(Screen.WebView.createRoute(url, title))
                }
            )
        }
        
        composable(
            route = Screen.WebView.route,
            arguments = listOf(
                navArgument(URL) { type = NavType.StringType },
                navArgument(TITLE) { type = NavType.StringType }
            )
        ) { backStackEntry ->
            val url = backStackEntry.arguments?.getString(URL) ?: ""
            val title = backStackEntry.arguments?.getString(TITLE) ?: ARTICLE
            
            WebViewScreen(
                url = url,
                title = title,
                onBackClick = {
                    navController.popBackStack()
                }
            )
        }
    }
}

sealed class Screen(val route: String) {
    data object Articles : Screen("articles")
    data object WebView : Screen("webview/{url}/{title}") {
        fun createRoute(url: String, title: String): String {
            return "webview/${url.encodeUrl()}/${title.encodeUrl()}"
        }
    }
}

private fun String.encodeUrl(): String {
    return this.replace("/", "%2F")
        .replace(":", "%3A")
        .replace("?", "%3F")
        .replace("&", "%26")
        .replace("=", "%3D")
}
