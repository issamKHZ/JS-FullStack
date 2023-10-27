package com.web;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;

import org.apache.catalina.connector.Response;

import com.dao.ArticleImp;
import com.dao.ArtisanImp;
import com.dao.CategoryImp;
import com.dao.StockImp;
import com.dao.UserImp;
import com.dao.imp.IArticle;
import com.dao.imp.IArtisan;
import com.dao.imp.ICategory;
import com.dao.imp.IStock;
import com.dao.imp.IUser;
import com.entity.Article;
import com.entity.Artisan;
import com.entity.Category;
import com.entity.Stock;
import com.entity.User;

/**
 * Servlet implementation class UserControlleur
 */

@WebServlet(name="ars", urlPatterns = {"/artisanContreleur","*.ars"})
public class ArtisanControlleur extends HttpServlet {
	private static final long serialVersionUID = 1L;
	IUser mUser ;
	IArticle mArticle ; 
	ICategory  mCategory ; 
	IArtisan mArtisan ; 
	IStock mStock ; 

	public void init() throws SecurityException { 
		mUser = new UserImp() ; 
		mArticle = new ArticleImp() ; 
		mCategory = new CategoryImp() ; 
		mArtisan = new ArtisanImp() ; 
		mStock = new StockImp() ; 
		
	}
	


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = request.getServletPath() ; 
		if(path.equals("/dashboard.ars")) {
			List<Category> categories = mCategory.getAllCategories() ; 
			List<Stock> stocks = mStock.getAllStocks() ; 
			Artisan artisan = (Artisan) request.getSession().getAttribute("artisan") ; 
			if(artisan == null) response.sendRedirect(request.getContentType() + "/login.us") ; 
			List<Article> articles = mArticle.getArticlePerArt(artisan.getId()) ; 
			request.setAttribute("categories", categories); 
			request.setAttribute("stocks", stocks); 
			request.setAttribute("articles", articles); 
			request.getRequestDispatcher("/Artisans/dashboard.jsp").forward(request,response);
			
		}else if(path.equals("/categories.ars")) {
			List<Category> categories = mCategory.getAllCategories() ; 
			request.setAttribute("categories",categories) ; 
			request.getRequestDispatcher("/Artisans/categories.jsp").forward(request,response);
			
		}else if(path.equals("/stocks.ars")) {
			List<Stock> stocks = mStock.getAllStocks() ; 
			request.setAttribute("stocks",stocks) ; 
			request.getRequestDispatcher("/Artisans/stocks.jsp").forward(request,response);
			
		}else if(path.equals("/articles.ars")) {
			Artisan artisan = (Artisan) request.getSession().getAttribute("artisan") ;
			long idArt = artisan.getId() ; 
			List<Article> articles = mArticle.getArticlePerArt(idArt) ; 
			request.setAttribute("articles", articles) ; 
			request.getRequestDispatcher("/Artisans/articles.jsp").forward(request,response);
			
		}else if(path.equals("/logout.ars")){
			HttpSession session = request.getSession() ; 
			session.invalidate() ; 
			response.sendRedirect(request.getContextPath()+"/login.us");
		}else if(path.equals("/deletearticle.ars")){
			long idArt = Long.parseLong(request.getParameter("id")) ; 
			long idArtisan = Long.parseLong(request.getParameter("idArtisan")) ; 
			Article a = mArticle.getArticle(idArt) ; 
 			long stockId = a.getStock().getId() ; 
			String stockName = a.getStock().getNom() ; 
			int numbreArticles = a.getStock().getNumberArticles() ; 
			int numbreArticlesUpdated = numbreArticles - 1 ; 
			Stock stuckUpdated = new Stock(stockName,numbreArticlesUpdated); 
			stuckUpdated.setId(stockId) ; 
			stuckUpdated = mStock.updateStock(stuckUpdated) ; 
			mArticle.deleteArticle(idArt) ; 
			response.sendRedirect(request.getContextPath()+"/articles.ars?idArt="+idArtisan);
		}else if(path.equals("/editarticle.ars")) {
			long idArt = Long.parseLong(request.getParameter("id")) ; 
			Article article = mArticle.getArticle(idArt) ; 
			List<Category> categories = mCategory.getAllCategories() ; 
			List<Stock> stocks = mStock.getAllStocks() ; 
			request.setAttribute("categories", categories) ; 
			request.setAttribute("stocks", stocks) ; 
			request.setAttribute("article", article) ; 
			request.getRequestDispatcher("/Artisans/editarticle.jsp").forward(request,response);
			
		}
			
		else
			response.sendError(Response.SC_NOT_FOUND);		
		}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
