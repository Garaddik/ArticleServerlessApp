/*
 *  Copyright hubcitix.com to Present
 *  All right reserved
 */

package test;

import com.mk.handler.ArticleHandler;
import com.mk.model.Article;
import com.mk.model.ArticleRequest;
import com.mk.model.ArticleResponse;

public class ArticleTest {

	public static void main(String[] args) {
		ArticleHandler handler = new ArticleHandler();
		ArticleRequest request = new ArticleRequest();
		request.setAction("CreateArticle");
		Article article = new Article();
		article.setTitle("Latest News");
		request.setArticle(article);
		ArticleResponse response = handler.handleRequest(request, null);
		System.out.println(response.getStatus());
	}
}
