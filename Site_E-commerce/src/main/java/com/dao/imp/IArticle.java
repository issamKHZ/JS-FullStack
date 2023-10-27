package com.dao.imp;

import java.util.List;

import com.entity.Article;

public interface IArticle {
	public Article save(Article article) ; 
	public List<Article> articlePerName(String name) ; 
	public List<Article> articlePerArtisanName(String name) ; 
	public Article getArticle(long id) ; 
	public List<Article> getArticlePerCat(long idCat) ; 
	public List<Article> getArticlePerArt(long idArt) ; 
	public List<Article> getAllArticles() ; 
	public Article updateArticle(Article a) ; 
	public void deleteArticle(Long id) ; 
	
	

}
