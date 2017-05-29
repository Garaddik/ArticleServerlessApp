package com.mk.handler;

import com.amazonaws.services.apigateway.model.BadRequestException;
import com.amazonaws.services.cognitoidentity.model.InternalErrorException;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.mk.action.ArticleDetails;
import com.mk.action.CreateArticle;
import com.mk.action.DeleteArticle;
import com.mk.action.ListArticle;
import com.mk.action.RequestAction;
import com.mk.action.UpdateArticle;
import com.mk.model.ArticleRequest;
import com.mk.model.ArticleResponse;

/**
 * 
 * Lambda function to handle Article CRUD operation.
 * 
 * @author kirankumar.garaddi
 *
 */
public class ArticleHandler implements RequestHandler<ArticleRequest, ArticleResponse> {

	@Override
	public ArticleResponse handleRequest(ArticleRequest input, Context context) throws BadRequestException, InternalErrorException {
		RequestAction action = null;
		ArticleResponse response = null;

		if (input == null || input.getAction() == null || input.getAction().trim().equals("")) {
			context.getLogger().log("Invald inputObj, could not find action parameter");
			throw new BadRequestException("Could not find action value in request");
		}
		switch (input.getAction()) {
		case "CreateArticle":
			action = new CreateArticle();
			break;
		case "DeleteArticle":

			action = new DeleteArticle();
			break;
		case "ListArticle":
			action = new ListArticle();
			break;
		case "UpdateArticle":
			action = new UpdateArticle();
			break;
		case "fetchArticleDetails":
			action = new ArticleDetails();
			break;
		default:
			context.getLogger().log("Invald inputObj, could not find action parameters");
			throw new BadRequestException("Could not find action value in request");
		}
		response = action.handle(input, context);
		return response;
	}
}
