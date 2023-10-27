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
import com.dao.CommandeImp;
import com.dao.StockImp;
import com.dao.UserImp;
import com.dao.imp.IArticle;
import com.dao.imp.IArtisan;
import com.dao.imp.ICategory;
import com.dao.imp.ICommande;
import com.dao.imp.IStock;
import com.dao.imp.IUser;
import com.entity.Article;
import com.entity.Artisan;
import com.entity.Category;
import com.entity.Commande;
import com.entity.Stock;
import com.entity.User;

/**
 * Servlet implementation class UserControlleur
 */

@WebServlet(name="us", urlPatterns = {"/userContreleur","*.us"})
public class UserControlleur extends HttpServlet {
	private static final long serialVersionUID = 1L;
	IUser mUser ;
	IArticle mArticle ; 
	ICategory  mCategory ; 
	IArtisan mArtisan ; 
	IStock mStock ; 
	ICommande mCommande; 

	public void init() throws SecurityException { 
		mUser = new UserImp() ; 
		mArticle = new ArticleImp() ; 
		mCategory = new CategoryImp() ; 
		mArtisan = new ArtisanImp() ; 
		mStock = new StockImp() ; 
		mCommande = new CommandeImp() ; 
		
	}
	


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = request.getServletPath() ; 
		if(path.equals("/register.us")) {
			System.out.println(path);
			request.getRequestDispatcher("/Users/register.jsp").forward(request,response);
			
		}else if(path.equals("/login.us")) {
			request.getRequestDispatcher("/Users/login.jsp").forward(request,response);

		}else if(path.equals("/postregister.us")) {
			User  u = null ; 
			Artisan  a = null ; 
			String username = request.getParameter("username") ; 
			String password = request.getParameter("password") ; 
			String nom = request.getParameter("nom") ; 
			String prenom = request.getParameter("prenom") ; 
			Boolean isArtisan = Boolean.parseBoolean(request.getParameter("isArtisan")) ; 
			System.out.println(isArtisan);
			int age = Integer.parseInt(request.getParameter("age")) ; 
			
			try {
				if(isArtisan) {
					a = mArtisan.save(new Artisan(nom,prenom,username,password,age));
					request.setAttribute("success", "Artisan account created successfully");
					request.getRequestDispatcher("register.us").forward(request, response);
				}
				else {
					u = mUser.save(new User(nom, prenom, username, password));
					request.setAttribute("success", "Custumor account created successfully");
					request.getRequestDispatcher("register.us").forward(request, response);
				}
		    } catch (Exception e) {
		        String errorMessage = "An error occurred while creating the user.";
		        if (e.getCause() instanceof SQLIntegrityConstraintViolationException) {
		            errorMessage = "This email address is already registered.";
		        }
		        request.setAttribute("error", errorMessage);
		        request.getRequestDispatcher("/Users/register.jsp").forward(request, response);
		    }
		}else if(path.equals("/postlogin.us")  && request.getMethod().equals("POST")) {
			User userToLogin = null  ;
			Artisan artisanToLogin = null  ;
			String username = request.getParameter("username") ; 
			String password = request.getParameter("password") ; 
			Boolean isArtisan = Boolean.parseBoolean(request.getParameter("isArtisan")) ; 
			System.out.println(isArtisan);
			System.out.println(password);

			if(!isArtisan)  userToLogin = mUser.getUserPerUsername(username) ; 
			else artisanToLogin = mArtisan.getArtisanPerUsername(username) ;
			
			if(userToLogin!=null && userToLogin.isValid(username, password)) {
				HttpSession session = request.getSession() ; 
				session.setMaxInactiveInterval(60 * 60 * 60);
//    			session.setAttribute("user", userToLogin);
				session.setAttribute("id", userToLogin.getId()) ; 
    			List<Category> categories = mCategory.getAllCategories(); 
    			request.setAttribute("categories", categories) ; 
    			System.out.println(userToLogin.getId());
				request.getRequestDispatcher("/Users/Acceuil.jsp").forward(request,response);
			}else if(artisanToLogin!=null && artisanToLogin.isValid(username, password)) {
				HttpSession session = request.getSession() ;
				session.setMaxInactiveInterval(60 * 60 * 60);
    			session.setAttribute("artisan", artisanToLogin);
    			List<Category> categories = mCategory.getAllCategories() ; 
    			List<Stock> stocks = mStock.getAllStocks() ; 
    			List<Article> articles = mArticle.getArticlePerArt(artisanToLogin.getId()) ; 
    			request.setAttribute("categories", categories); 
    			request.setAttribute("stocks", stocks); 
    			request.setAttribute("articles", articles); 
				request.getRequestDispatcher("/Artisans/dashboard.jsp").forward(request,response);
			}else {
	            String errorMessage = "email/password not found.";
				request.setAttribute("error", errorMessage);
		        request.getRequestDispatcher("/Users/login.jsp").forward(request, response);
			}
		}else if(path.equals("/commande.us")) {
			long idArt = Long.parseLong(request.getParameter("idArticle")) ; 
			long idUser = Long.parseLong(request.getParameter("idUser")) ; 
			User user = mUser.getUser(idUser) ; 
			Article article = mArticle.getArticle(idArt) ; 
			Commande c = new Commande(user,article)  ; 
			c = mCommande.save(c) ; 
			request.setAttribute("commande", c) ;
			response.sendRedirect(request.getContextPath()+"/articles.as?msg=Commande ajouter au panier") ; 
		}else if(path.equals("/articlespercat.us")) {
			long idCat = Long.parseLong(request.getParameter("idCat")) ; 
			List<Article> arts = mArticle.getArticlePerCat(idCat) ; 
			List<Category> cats = mCategory.getAllCategories() ; 
			request.setAttribute("articles", arts) ; 
			request.setAttribute("categories", cats) ; 
	        request.getRequestDispatcher("/Users/articlepercat.jsp").forward(request, response);			
		}else if(path.equals("/logout.us")) {
			HttpSession session = request.getSession() ; 
			session.invalidate() ; 
	        response.sendRedirect(request.getContextPath()+"/login.us") ; 

		}
		
		else{
			response.sendError(Response.SC_NOT_FOUND);		
		}	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
