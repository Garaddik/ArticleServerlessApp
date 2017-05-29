package com.mk.action;

import java.util.List;

import com.amazonaws.services.apigateway.model.BadRequestException;
import com.amazonaws.services.cognitoidentity.model.InternalErrorException;
import com.amazonaws.services.lambda.runtime.Context;
import com.mk.config.DynamoDBConfig;
import com.mk.dao.ArticleDAO;
import com.mk.model.Article;
import com.mk.model.ArticleRequest;
import com.mk.model.ArticleResponse;
import com.mk.model.DAOFactory;

/**
 * 
 * @author kirankumar.garaddi
 *
 */
public class ListArticle implements RequestAction {

	@Override
	public ArticleResponse handle(ArticleRequest request, Context context) throws BadRequestException, InternalErrorException {
		ArticleDAO dao = DAOFactory.getArticleDAO();
		ArticleResponse response = null;
		List<Article> articles = dao.getArticles(DynamoDBConfig.SCAN_LIMIT);
		response = new ArticleResponse();
		response.setStatus(200);
		response.setMessage("SUCCESS");
		response.setArticles(articles);
		return response;

	}

}
