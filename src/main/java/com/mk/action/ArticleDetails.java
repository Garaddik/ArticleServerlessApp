package com.mk.action;

import com.amazonaws.services.apigateway.model.BadRequestException;
import com.amazonaws.services.cognitoidentity.model.InternalErrorException;
import com.amazonaws.services.lambda.runtime.Context;
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
public class ArticleDetails implements RequestAction {

	@Override
	public ArticleResponse handle(ArticleRequest request, Context context) throws BadRequestException, InternalErrorException {

		ArticleResponse response = new ArticleResponse();

		Article article = null;

		ArticleDAO dao = DAOFactory.getArticleDAO();

		article = dao.getArticleDetails(request.getId());

		response.setArticle(article);
		response.setStatus(200);

		return response;
	}
}
