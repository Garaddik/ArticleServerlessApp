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
public class CreateArticle implements RequestAction {

	@Override
	public ArticleResponse handle(ArticleRequest request, Context context) throws BadRequestException, InternalErrorException {

		ArticleResponse responseJson = null;
		ArticleDAO dao = DAOFactory.getArticleDAO();
		String response = dao.createArticle(request.getArticle());
		if (response != null && response.equalsIgnoreCase("success")) {
			responseJson = new ArticleResponse();
			responseJson.setStatus(200);
			responseJson.setMessage("SUCCESS");
		}
		return responseJson;
	}
}
