package com.web;

import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Random;

import org.apache.catalina.connector.Response;

import com.dao.ArticleImp;
import com.dao.ArtisanImp;
import com.dao.CategoryImp;
import com.dao.CommandeImp;
import com.dao.CommentaireImp;
import com.dao.OrderDetailImp;
import com.dao.OrdredProductImp;
import com.dao.StockImp;
import com.dao.UserImp;
import com.dao.imp.IArticle;
import com.dao.imp.IArtisan;
import com.dao.imp.ICategory;
import com.dao.imp.ICommande;
import com.dao.imp.ICommentaire;
import com.dao.imp.IOrderDetail;
import com.dao.imp.IOrdredProduct;
import com.dao.imp.IStock;
import com.dao.imp.IUser;
import com.entity.Article;
import com.entity.Artisan;
import com.entity.Category;
import com.entity.Commande;
import com.entity.Commentaire;
import com.entity.OrderDetail;
import com.entity.OrdredProduct;
import com.entity.Stock;
import com.entity.User;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

/**
 * Servlet implementation class ArticleControlleur
 */
@WebServlet(name="as", urlPatterns = {"/articleContreleur","*.as"})
@MultipartConfig // Threshold after which files will be temporarily stored on disk
public class ArticleControlleur extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	IArticle metier ; 
	ICategory categorymetier ; 
	IStock stockMetier ; 
	IArtisan artisanMetier ; 
	ICommande mCommande ; 
	IOrderDetail mIod ; 
	IOrdredProduct mIop; 
	IUser mIuser; 
	ICommentaire mIcmt ; 
	
	
	public void init() throws SecurityException { 
		metier = new ArticleImp() ; 
		categorymetier = new CategoryImp() ; 
		stockMetier = new StockImp() ; 
		artisanMetier = new ArtisanImp() ; 
		mCommande = new CommandeImp() ; 
		mIod = new OrderDetailImp() ; 
		mIop = new OrdredProductImp() ; 
		mIuser = new UserImp() ;
		mIcmt = new CommentaireImp() ; 
	}
	
	
	protected void doGet(HttpServletRequest request,HttpServletResponse response) 
           throws ServletException, IOException {
		
		String path = request.getServletPath() ; 
		if(path.equals("/add.as")) {
			String fileName = null ; 
			String name = request.getParameter("name") ;
			double price = Double.parseDouble(request.getParameter("price"));
			double poids = Double.parseDouble(request.getParameter("poids"));
			int qte = Integer.parseInt(request.getParameter("qte"));
			String details = request.getParameter("details") ; 
			long idCat = Long.parseLong(request.getParameter("idCat")) ; 
			long idStock = Long.parseLong(request.getParameter("idStock")) ; 
			long idArt = Long.parseLong(request.getParameter("idArt")) ; 
			Category cat = categorymetier.getCategory(idCat) ; 
			Stock stock = stockMetier.getStock(idStock) ; 
			Artisan artisan = artisanMetier.getArtisan(idArt) ; 
			try {
				Part image =  request.getPart("image") ; 
				fileName = getFileName(image) ; 
				String uploadPath = "C:/Users/hp/Desktop/eclipse-workspace/ProjectJPA/WebContent/images/"+fileName ; 
				//uploading our selected image in the images folder
				uploadImg(uploadPath,image); 
			}catch(Exception e) {
				String msg = "Erreur dans l'ajout / essayer plud tard" ; 
				System.out.println(e);
				response.sendRedirect(request.getContextPath() + "/dashboard.ars?msg="+msg);

			}
			Article a = metier.save(new Article(name,price,poids,qte,details,fileName,cat,artisan,stock)) ; 
			request.setAttribute("article", a) ; 
			long stockId = a.getStock().getId() ; 
			String stockName = a.getStock().getNom() ; 
			int numbreArticles = a.getStock().getNumberArticles() ; 
			int numbreArticlesUpdated = numbreArticles + 1 ; 
			Stock stuckUpdated = new Stock(stockName,numbreArticlesUpdated); 
			stuckUpdated.setId(stockId) ; 
			stuckUpdated = stockMetier.updateStock(stuckUpdated) ; 
			System.out.println(stuckUpdated.getNumberArticles());
			response.sendRedirect(request.getContextPath() + "/dashboard.ars");
		}else if(path.equals("/articlespercat.as") ) {
			long idCat = Long.parseLong(request.getParameter("idCat")) ; 
			List<Article> arts = metier.getArticlePerCat(idCat) ; 
			request.setAttribute("articles", arts) ; 
	        request.getRequestDispatcher("/Artisans/articlepercat.jsp").forward(request, response);			
			
		}else if(path.equals("/articles.as") ) {
			List<Article> arts = metier.getAllArticles() ; 
			List<Category> cats = categorymetier.getAllCategories() ; 
			request.setAttribute("articles", arts) ; 
			request.setAttribute("categories", cats) ; 
	        request.getRequestDispatcher("/Users/articles.jsp").forward(request, response);			
			
		}else if(path.equals("/home.as")) {
			List<Category> cats = categorymetier.getAllCategories() ; 
			request.setAttribute("categories", cats) ; 
	        request.getRequestDispatcher("/Users/Acceuil.jsp").forward(request, response);			
		}else if(path.equals("/search.as")) {
			String search = request.getParameter("search") ; 
			System.out.println(request.getParameter("search"));
				List<Article> arts = metier.articlePerName(search) ; 
				List<Article> art2 = metier.articlePerArtisanName(search) ; 
			    arts.addAll(art2);
				request.setAttribute("articles", arts) ; 
		        request.getRequestDispatcher("/Users/articles.jsp").forward(request, response);		
			
		}else if(path.equals("/panier.as")) {
				long idUser = Long.parseLong(request.getParameter("idUser")) ; 
				List<Commande> cmds = mCommande.getCommandesPerUser(idUser) ; 
				List<Category> categories = categorymetier.getAllCategories(); 
				request.setAttribute("categories", categories) ; 
				request.setAttribute("cs", cmds) ; 
		        request.getRequestDispatcher("/Users/panier.jsp").forward(request, response);			
		}else if(path.equals("/placdordre.as")) {
			List<Category> categories = categorymetier.getAllCategories(); 
			request.setAttribute("categories", categories) ; 
			request.setAttribute("article", request.getParameter("article")) ; 
			request.setAttribute("qte", request.getParameter("qte")) ; 
			request.setAttribute("idCmd", request.getParameter("idCmd")) ; 
			request.setAttribute("user", request.getSession().getAttribute("id")) ; 
			System.out.println(request.getSession().getAttribute("idCmd"));
	        request.getRequestDispatcher("/Users/placeorder.jsp").forward(request, response);			

			
		}else if (path.equals("/submitorder.as")) {
		    // Retrieve form parameters
		    String address = request.getParameter("address");
		    String phone = request.getParameter("phone");
		    String country = request.getParameter("country");
		    String city = request.getParameter("city");
		    String zip = request.getParameter("zip");
		    int qte = Integer.parseInt(request.getParameter("qte"));
		    long articleId = Long.parseLong(request.getParameter("article"));
		    long userId = Long.parseLong(request.getParameter("user"));
		    long idCmd = Long.parseLong(request.getParameter("idCmd"));

		    // Retrieve article and user from their respective services
		    Article article = metier.getArticle(articleId);
		    User user = mIuser.getUser(userId);

		    // Calculate total amount
		    double total = article.getPrice() * qte;

		    // Create and save order detail
		    OrderDetail od = new OrderDetail(address, phone, country, city, zip);
		    od = mIod.save(od);

		    // Create and save ordered product
		    Date date = new Date();
		    OrdredProduct op = new OrdredProduct(date, generateNumberForOrder(), "ordered", qte, total, user, od, article);
		    op = mIop.save(op);

		    // Update article quantity and delete the command
		    article.setQuantite(article.getQuantite() - qte);
		    metier.updateArticle(article);
		    mCommande.deleteCommande(idCmd);

		    // Generate the PDF dynamically
		    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		    Document document = new Document();

		    try {
		        // Set up PDF writer and document
		        PdfWriter writer = PdfWriter.getInstance(document, outputStream);
		        document.open();

		        // Define font styles
		        Font titleFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 20, BaseColor.DARK_GRAY);
		        Font headingFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 14, BaseColor.BLACK);
		        Font contentFont = FontFactory.getFont(FontFactory.HELVETICA, 12, BaseColor.BLACK);

		        // Add title
		        Paragraph title = new Paragraph("Moroccan Artisanat Facture", titleFont);
		        title.setAlignment(Element.ALIGN_CENTER);
		        title.setSpacingAfter(20);
		        document.add(title);

		        // Add user information
		        Paragraph userInfo = new Paragraph("User Information:", headingFont);
		        userInfo.setSpacingAfter(10);
		        document.add(userInfo);
		        document.add(new Paragraph("Name: " + user.getNom() + user.getPrenom(), contentFont));
		        document.add(new Paragraph("Username : " + user.getUsername(), contentFont));
		        document.add(new Paragraph("Address: " + address, contentFont));
		        document.add(new Paragraph("Phone: " + phone, contentFont));
		        document.add(new Paragraph("Country: " + country, contentFont));
		        document.add(new Paragraph("City: " + city, contentFont));
		        document.add(new Paragraph("Zip: " + zip, contentFont));

		        // Add article information
		        Paragraph articleInfo = new Paragraph("Article Information:", headingFont);
		        articleInfo.setSpacingBefore(20);
		        articleInfo.setSpacingAfter(10);
		        document.add(articleInfo);
		        document.add(new Paragraph("Article Name: " + article.getName(), contentFont));
		        document.add(new Paragraph("Article Price: " + article.getPrice(), contentFont));
		        document.add(new Paragraph("Quantity: " + qte, contentFont));

		        // Add total
		        Paragraph totalInfo = new Paragraph("Total:", headingFont);
		        totalInfo.setSpacingBefore(20);
		        totalInfo.setSpacingAfter(10);
		        document.add(totalInfo);
		        document.add(new Paragraph("In Dirhames: " + total, contentFont));

		        // Add image
		        Image image = Image.getInstance("C:/Users/hp/Desktop/eclipse-workspace/ProjectJPA/WebContent/images/"+article.getImage());
		        image.setAlignment(Element.ALIGN_CENTER);
		        image.scaleToFit(200, 200);
		        document.add(image);

		        document.close();

		        // Set the response headers and content type
		        response.setContentType("application/pdf");
		        response.setHeader("Content-Disposition", "attachment; filename=\"facture.pdf\"");

		        // Write the PDF bytes to the response output stream
		        response.getOutputStream().write(outputStream.toByteArray());
		        response.getOutputStream().flush();
		    } catch (Exception e) {
		        System.out.println(e);
		    }
		
		}else if(path.equals("/deletecommande.as")) {
			long idcmd = Long.parseLong(request.getParameter("idcmd")) ; 
			long idUser = Long.parseLong(request.getParameter("idUser")) ; 
			mCommande.deleteCommande(idcmd) ; 
	        response.sendRedirect(request.getContextPath() + "/panier.as?msg=Commande supprimer&idUser="+idUser);			
		}else if(path.equals("/commenter.as")) {
			long idArticle = Long.parseLong(request.getParameter("idArticle"));
			List<Commentaire> cmts = mIcmt.getCommentairesPerArticle(idArticle) ; 
			Article article = metier.getArticle(idArticle) ; 
			request.setAttribute("article", article); 
			request.setAttribute("comments", cmts) ;
			request.getServletContext().getRequestDispatcher("/Users/commenterArticle.jsp").forward(request, response) ; 
			
		}else if(path.equals("/addcommentaire.as")) {
			long idArticle = Long.parseLong(request.getParameter("idArticle")); 
			long idUser = Long.parseLong(request.getParameter("idUser")) ; 
			String commentaire = request.getParameter("commentaire") ; 
			Article article = metier.getArticle(idArticle) ; 
			User user = mIuser.getUser(idUser) ; 
	        Date dateTime = new Date() ; 
			Commentaire cmt = new Commentaire(commentaire,user,article,dateTime) ; 
			cmt = mIcmt.save(cmt) ;  
			response.sendRedirect(request.getContextPath() + "/articles.as?cmt=commentaire ajouter avec succes") ; 
			
		}else if(path.equals("/articleDetails.as")) {
			long idArticle = Long.parseLong(request.getParameter("idArticle")); 
			Article article = metier.getArticle(idArticle) ; 
			List<Commentaire> cmts = mIcmt.getCommentairesPerArticle(idArticle) ; 
			request.setAttribute("article", article) ; 
			request.setAttribute("commentaires", cmts) ;
			request.getRequestDispatcher("/Users/onearticle.jsp").forward(request,response);
		}
		
		
		else if(path.equals("/update.as") && request.getMethod().equals("POST")) {
			String fileName = null ; 
			String name = request.getParameter("name") ;
			double price = Double.parseDouble(request.getParameter("price"));
			double poids = Double.parseDouble(request.getParameter("poids"));
			int qte = Integer.parseInt(request.getParameter("quantite"));
			String details = request.getParameter("details") ; 
			long idCat = Long.parseLong(request.getParameter("category")) ; 
			long idStock = Long.parseLong(request.getParameter("stock")) ; 
			long idArt = Long.parseLong(request.getParameter("idArtisan")) ; 
			long id = Long.parseLong(request.getParameter("id")) ; 
			Category cat = categorymetier.getCategory(idCat) ; 
			Stock stock = stockMetier.getStock(idStock) ; 
			Artisan artisan = artisanMetier.getArtisan(idArt) ; 
			try {
				Part image =  request.getPart("image") ; 
				fileName = getFileName(image) ; 
				String uploadPath = "C:/Users/hp/Desktop/eclipse-workspace/ProjectJPA/WebContent/images/"+fileName ; 
				//uploading our selected image in the images folder
				uploadImg(uploadPath,image); 
			}catch(Exception e) {
				String msg = "Erreur dans l'ajout / essayer plud tard" ; 
				System.out.println(e);
				response.sendRedirect(request.getContextPath() + "/dashboard.ars?msg="+msg);

			}
			Article a = new Article(name,price,poids,qte,details,fileName,cat,artisan,stock) ; 
			a.setId(id) ; 
			a = metier.updateArticle(a) ; 
			request.setAttribute("article", a) ; 
			response.sendRedirect(request.getContextPath() + "/dashboard.ars");
		}else if(path.equals("/orders.as")) {
			long id = Long.parseLong(request.getParameter("idUser")) ; 
			List<OrdredProduct> ops = mIop.getOrdredProductsPerUser(id) ; 
			List<Category> cats = categorymetier.getAllCategories()  ;
			request.setAttribute("ordredProducts", ops) ; 
			request.setAttribute("categories", cats) ; 
			request.getRequestDispatcher("/Users/ordres.jsp").forward(request,response);

			
		}
		else{
			response.sendError(Response.SC_NOT_FOUND);		
		}	
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	
	private String getFileName(Part part) {
		String contentDisposition = part.getHeader("content-disposition") ; 
		System.out.println("contentDisposition : "+ contentDisposition );
		if(!contentDisposition.contains("filename=")) return null ; 
		int beginIndex = contentDisposition.indexOf("filename=") + 10 ; 
		System.out.println(contentDisposition.indexOf("filename="));
		System.out.println("big index : " + beginIndex );
		int endIndex = contentDisposition.length() - 1 ; 
		System.out.println("end index : " + endIndex );
		return contentDisposition.substring(beginIndex, endIndex) ; 
	}

	private void uploadImg(String path, Part part) {
		try {
			
			FileOutputStream fos = new FileOutputStream(path); 
			InputStream is = part.getInputStream() ; 
			byte[] data = new byte[is.available()] ; 
			is.read(data) ; 
			fos.write(data);
			fos.close(); 
		}catch(Exception e) {
			System.out.println(e);
		}
	}
	
	private int generateNumberForOrder() {
		 Random random = new Random();
	        int min = 99;
	        int max = 9900;
	        int randomNumber = random.nextInt(max - min + 1) + min;
	        
	        return randomNumber ; 
	}
	

}