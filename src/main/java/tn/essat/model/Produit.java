package tn.essat.model;

import java.util.Locale.Category;

public class Produit {
private int id;
private String titre;
private int prix;
private Categorie cat;
public Produit() {
	super();
	// TODO Auto-generated constructor stub
}
public Produit(int id, String titre, int prix, Categorie cat) {
	super();
	this.id = id;
	this.titre = titre;
	this.prix = prix;
	this.cat = cat;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getTitre() {
	return titre;
}
public void setTitre(String titre) {
	this.titre = titre;
}
public int getPrix() {
	return prix;
}
public void setPrix(int prix) {
	this.prix = prix;
}
public Categorie getCat() {
	return cat;
}
public void setCat(Categorie cat) {
	this.cat = cat;
}

}
