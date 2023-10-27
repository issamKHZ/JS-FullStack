package com.web;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import org.apache.catalina.connector.Response;

import com.dao.ArticleImp;
import com.dao.CategoryImp;
import com.dao.imp.IArticle;
import com.dao.imp.ICategory;
import com.entity.Article;
import com.entity.Category;

/**
 * Servlet implementation clsss ArticleControlleur
 */
@WebServlet(name="cs", urlPatterns = {"/categoryContreleur","*.cs"})
public class CategoryController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	IArticle metier ; 
	ICategory categorymetier ; 
	
	
	public void init() throws SecurityException { 
		metier = new ArticleImp() ; 
		categorymetier = new CategoryImp() ; 
	}
	
	
	protected void doGet(HttpServletRequest request,HttpServletResponse response) 
           throws ServletException, IOException {
		
		String path = request.getServletPath() ; 
		if(path.equals("/home.cs")) {
			request.getRequestDispatcher("/Users/Acceuil.jsp").forward(request,response);
			
		}else if(path.equals("/articles.ss")) {
			List<Article> articles = metier.getAllArticles() ; 
			request.setAttribute("articles", articles) ; 
			request.getRequestDispatcher("/Users/articles.jsp").forward(request,response);

		}else if(path.equals("/searchByName.cs")) {
			String name = request.getParameter("articleName") ; 
			List<Article> articles = metier.articlePerName(name) ; 
			request.setAttribute("articles", articles) ; 
			request.getRequestDispatcher("/Users/articles.jsp").forward(request,response);

			
		}
		else if(path.equals("/saisie.cs")) {
			request.getRequestDispatcher("saisieArticle.jsp").forward(request,response);

		}else if(path.equals("/postcat.cs")  && request.getMethod().equals("POST")) {
			String name = request.getParameter("name") ; 
			String desc = request.getParameter("desc") ; 
			Category a = categorymetier.save(new Category(name,desc)) ; 
			String catCreated = "" ; 
			request.setAttribute("Category created", catCreated) ; 
			response.sendRedirect(request.getContextPath() + "/dashboard.ars");
 

		}else if(path.equals("/categories.cs")) {
			List<Category> categories = categorymetier.getAllCategories() ; 
			request.setAttribute("categories",categories) ; 
			request.getRequestDispatcher("/Artisans/categories.jsp").forward(request,response);
			
		}
		
		
		else if(path.equals("/deleteCategory.cs")) {
			long id= Long.parseLong(request.getParameter("id"));
			categorymetier.deleteCategory(id) ;
			response.sendRedirect(request.getContextPath() + "/categories.ars?msg=Category supprimer");

		     
		}else if(path.equals("/editCategory.cs")) {
			long id= Long.parseLong(request.getParameter("id"));
		    Category c = categorymetier.getCategory(id) ; 
		    request.setAttribute("category", c);
			request.getRequestDispatcher("/Artisans/editCat.jsp").forward(request,response);
		}else if (path.equals("/updateCategory.cs")  ){
			 long id = Long.parseLong(request.getParameter("id"));
			 String name  = request.getParameter("name") ; 
			 String description = request.getParameter("description") ; 
			 Category cat = new Category(name,description) ; 
			 cat.setId(id) ; 
			 cat = categorymetier.updateCategory(cat) ; 
			 response.sendRedirect(request.getContextPath() + "/categories.ars?msg=Category modifier");

		}
		else{
			response.sendError(Response.SC_NOT_FOUND);		
		}	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}