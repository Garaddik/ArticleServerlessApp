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
public class UpdateArticle implements RequestAction {

	@Override
	public ArticleResponse handle(ArticleRequest request, Context context) throws BadRequestException, InternalErrorException {
		ArticleDAO dao = DAOFactory.getArticleDAO();
		ArticleResponse responseJson = null;
		if (null != request.getId()) {
			request.getArticle().setId(request.getId());
		}
		String response = dao.updateArticle(request.getArticle());
		if (response != null && response.equalsIgnoreCase("success")) {
			responseJson = new ArticleResponse();
			responseJson.setStatus(200);
			responseJson.setMessage("SUCCESS");
		}
		return responseJson;
	}
}
