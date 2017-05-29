package com.mk.action;

import com.amazonaws.services.apigateway.model.BadRequestException;
import com.amazonaws.services.cognitoidentity.model.InternalErrorException;
import com.amazonaws.services.lambda.runtime.Context;
import com.mk.model.ArticleRequest;
import com.mk.model.ArticleResponse;

/**
 * 
 * @author kirankumar.garaddi
 *
 */
public interface RequestAction {
	public ArticleResponse handle(ArticleRequest request, Context context) throws BadRequestException, InternalErrorException;
}
