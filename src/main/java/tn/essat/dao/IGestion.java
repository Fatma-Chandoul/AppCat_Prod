package tn.essat.dao;

import java.util.List;

import tn.essat.model.Categorie;
import tn.essat.model.Produit;

public interface IGestion {
	public List<Categorie> getAllCategories();
	public List<Produit> getAllProduitsByCategorieID(int id);
	public Categorie getCategorieById(int id);
	public void addProduit(Produit p);

}
