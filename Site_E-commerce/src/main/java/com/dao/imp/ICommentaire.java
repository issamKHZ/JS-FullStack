package com.dao.imp;

import java.util.List;

import com.entity.Commentaire;


public interface ICommentaire {
	public Commentaire save(Commentaire cat);
	public Commentaire getCommentaire(long id);
	public Commentaire updateCommentaire(Commentaire cat);
	public void deleteCommentaire(long id);
	public List<Commentaire> getAllCommentaires();
	public List<Commentaire> getCommentairesPerArticle(long articleId); 
	public List<Commentaire> getCommentairesPerUser(long articleId) ; 
    public long getNumberOfCommentsOfArticle(long id)  ; 
    

}
