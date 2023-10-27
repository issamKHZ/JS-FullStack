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
import com.dao.StockImp;
import com.dao.imp.IArticle;
import com.dao.imp.ICategory;
import com.dao.imp.IStock;
import com.entity.Article;
import com.entity.Category;
import com.entity.Stock;

/**
 * Servlet implementation clsss ArticleControlleur
 */
@WebServlet(name="ss", urlPatterns = {"/stockContreleur","*.ss"})
public class StockControlleur extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
	IStock sMetier;
	
	public void init() throws SecurityException { 
		sMetier = new StockImp() ; 
	}
	
	
	protected void doGet(HttpServletRequest request,HttpServletResponse response) 
           throws ServletException, IOException {
		
		String path = request.getServletPath() ; 
		if(path.equals("/add.ss")  && request.getMethod().equals("POST")) {
			String name = request.getParameter("name") ; 
			Stock s = sMetier.save(new Stock(name,0)) ; 
			response.sendRedirect(request.getContextPath() + "/dashboard.ars");


		}else if(path.equals("/editStock.ss")) {
			long id= Long.parseLong(request.getParameter("id"));
		    Stock s = sMetier.getStock(id) ; 
		    request.setAttribute("stock", s);
			request.getRequestDispatcher("/Artisans/editStock.jsp").forward(request,response);
	
		}else if(path.equals("/updateStock.ss")) {
			 long id = Long.parseLong(request.getParameter("id"));
			 String name  = request.getParameter("name") ; 
			 Stock stck = new Stock(name,sMetier.getStock(id).getNumberArticles()) ; 
			 stck.setId(id) ; 
			 stck = sMetier.updateStock(stck) ; 
			 response.sendRedirect(request.getContextPath() + "/stocks.ars?msg=Stock modifier");
			
		}
		
		else if(path.equals("/deleteStock.ss")) {
			long id= Long.parseLong(request.getParameter("id"));
			sMetier.deleteStock(id) ; 
			response.sendRedirect(request.getContextPath() + "/stocks.ars?msg=Stock supprimer");
		}
		
		else{
			response.sendError(Response.SC_NOT_FOUND);		
		}	
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}


}