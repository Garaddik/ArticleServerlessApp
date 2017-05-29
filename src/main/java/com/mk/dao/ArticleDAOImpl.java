package com.mk.dao;

import java.util.List;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBScanExpression;
import com.mk.config.DynamoDBConfig;
import com.mk.model.Article;
import com.mk.model.ArticleResponse;

/**
 * @author kirankumar.garaddi
 *
 */
public class ArticleDAOImpl implements ArticleDAO {

	private static ArticleDAOImpl instance = null;

	AmazonDynamoDB client = AmazonDynamoDBClientBuilder.standard().build();

	public static ArticleDAO getInstance() {
		if (instance == null) {
			instance = new ArticleDAOImpl();
		}
		return instance;
	}

	protected DynamoDBMapper getMapper() {
		return new DynamoDBMapper(client);
	}

	@Override
	public String createArticle(Article article) {
		String response = null;
		getMapper().save(article);
		response = "success";
		return response;
	}

	@Override
	public ArticleResponse deleteArticle(Article article) {
		ArticleResponse response = null;
		getMapper().delete(article);
		response = new ArticleResponse();
		response.setStatus(200);
		response.setMessage("SUCCESS");
		return response;
	}

	@Override
	public List<Article> getArticles(int limit) {

		if (limit <= 0 || limit > DynamoDBConfig.SCAN_LIMIT)
			limit = DynamoDBConfig.SCAN_LIMIT;

		DynamoDBScanExpression expression = new DynamoDBScanExpression();
		expression.setLimit(limit);
		return getMapper().scan(Article.class, expression);

	}

	@Override
	public String updateArticle(Article article) {

		String response = null;
		getMapper().save(article);
		response = "success";
		return response;

	}

	@Override
	public Article getArticleDetails(String id) {
		Article article = getMapper().load(Article.class, id);
		return article;
	}
}
