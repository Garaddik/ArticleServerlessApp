package com.mk.model;

/**
 * 
 * @author kirankumar.garaddi
 *
 */
public class ArticleRequest {

	private String action;
	private Article article;
	private String id;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public Article getArticle() {
		return article;
	}

	public void setArticle(Article article) {
		this.article = article;
	}

}
