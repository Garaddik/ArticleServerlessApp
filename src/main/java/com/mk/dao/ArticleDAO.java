package com.mk.dao;

import java.util.List;

import com.mk.model.Article;
import com.mk.model.ArticleResponse;

/**
 * 
 * @author kirankumar.garaddi
 *
 */
public interface ArticleDAO {

	String createArticle(Article article);

	ArticleResponse deleteArticle(Article article);

	List<Article> getArticles(int scanLimit);

	String updateArticle(Article body);

	Article getArticleDetails(String id);

}
