package com.test;

import java.util.List;

import com.dao.ArticleImp;
import com.dao.ArtisanImp;
import com.dao.CategoryImp;
import com.dao.CommandeImp;
import com.dao.OrdredProductImp;
import com.dao.StockImp;
import com.dao.UserImp;
import com.dao.imp.IArticle;
import com.dao.imp.IArtisan;
import com.dao.imp.ICategory;
import com.dao.imp.ICommande;
import com.dao.imp.IOrdredProduct;
import com.dao.imp.IStock;
import com.dao.imp.IUser;
import com.entity.Article;
import com.entity.Artisan;
import com.entity.Category;
import com.entity.Commande;
import com.entity.OrdredProduct;
import com.entity.Stock;
import com.entity.User;

public class Test {

	public static void main(String[] args) {
//		IArtisan artisan = new ArtisanImp() ; 
//		Artisan a = artisan.getArtisanPerUsername("taha1") ; 
//		System.out.println(a.getNom());
//		System.out.println(a.getAge());
//		//		IStock s = new StockImp() ; 
//		List<Article> stocks = s.getAllStocks() ; 
//		for (Stock ss : stocks) {
//			System.out.println(ss.getNom());
//		}
		IArticle metier = new ArticleImp() ; 
		List<Article> arts = metier.getArticlePerCat(4) ; 
		for (Article ar : arts) {
			System.out.println(ar.getName());
		}
		
//		
//		
//		List<Article> articles = a.getArticlePerArt(1) ; 
//		for (Article commande : articles) {
//			System.out.println(commande.getName());
//			
//		}
		
//		ICommande icommande = new CommandeImp() ; 
//		List<Commande> cmds = icommande.getAllCommandes() ; 
//		
//		for (Commande c : cmds) {
//			System.out.println(c.getId());
//			System.out.println(c.getArticle().getName());
//			System.out.println("***************");
//		}
//		
//		System.out.println("Deleting....");
//		
//		icommande.deleteCommande(1);
//		
//		for (Commande c : cmds) {
//			System.out.println(c.getId());
//			System.out.println(c.getArticle().getName());
//			System.out.println("***************");
//		}
		
//		IOrdredProduct mIop = new OrdredProductImp() ; 
//		List<OrdredProduct> ops = mIop.getOrdredProductsPerUser(1) ; 
//		for (OrdredProduct op : ops) {
//			System.out.println(op.getArticle().getName());
//		}

		
//		List<Article> arts = a.articlePerName("va") ; 
//		for (Article ar : arts) {
//			System.out.println(ar.getName());
//		}
//		IStock s = new StockImp();
//		ICategory c = new CategoryImp() ; 
//		IArtisan art = new ArtisanImp() ; 
//		Category cat = c.getCategory(1) ; 
//		Artisan artisan = art.getArtisan(1) ; 
//		Article article = new Article("p1", 90, 2, 2, "lalallal",cat,artisan,stock) ;
//		article = a.save(article) ; 
//		System.out.println(article.getQuantite());
		
		
//		List<Commande> commandes = null ; 
//		ICommande c = new CommandeImp() ; 
//		commandes = c.getCommandesPerUser(1) ; 
//		for (Commande commande : commandes) {
//			System.out.println(commande.getId());
//			
//		}

}
}