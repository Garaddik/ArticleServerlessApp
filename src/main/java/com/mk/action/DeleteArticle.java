package com.mk.action;

import com.amazonaws.services.apigateway.model.BadRequestException;
import com.amazonaws.services.cognitoidentity.model.InternalErrorException;
import com.amazonaws.services.lambda.runtime.Context;
import com.mk.dao.ArticleDAO;
import com.mk.model.ArticleRequest;
import com.mk.model.ArticleResponse;
import com.mk.model.DAOFactory;

/**
 * 
 * @author kirankumar.garaddi
 *
 */
public class DeleteArticle implements RequestAction {

	@Override
	public ArticleResponse handle(ArticleRequest request, Context context) throws BadRequestException, InternalErrorException {
		ArticleDAO dao = DAOFactory.getArticleDAO();

		ArticleResponse response = dao.deleteArticle(request.getArticle());

		return response;
	}

}
