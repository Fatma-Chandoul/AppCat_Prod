package tn.essat.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import tn.essat.model.Categorie;
import tn.essat.model.Produit;

@Repository
public class GestionImp implements IGestion {
	
	
@Autowired
@Qualifier("dataSource")
DataSource dat;
public void setDat(DataSource dat) {
	this.dat=dat;
}
	public List<Categorie> getAllCategories() {
		List<Categorie> liste=null;
		try {
			liste=new ArrayList<Categorie>();
			Connection cnx= dat.getConnection();
			PreparedStatement pr= cnx.prepareStatement("select * from categorie");
			ResultSet rs=pr.executeQuery();
			while(rs.next()) {
				Categorie c=new Categorie(rs.getInt("id"),rs.getString("titre"));
				liste.add(c);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return liste;
			}

	public List<Produit> getAllProduitsByCategorieID(int id) {
		List<Produit> liste=null;
		try {
			liste=new ArrayList<Produit>();
			Connection cnx=dat.getConnection();
			PreparedStatement pr= cnx.prepareStatement("select * from produit where cat_id=? ");
			pr.setInt(1, id);
			ResultSet rs=pr.executeQuery();
			while(rs.next()) {
				Produit p=new Produit(rs.getInt("id"),rs.getString("titre"),rs.getInt("prix"),this.getCategorieById(rs.getInt("cat_id")));
				liste.add(p);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return liste;
	}

	public Categorie getCategorieById(int id) {
Categorie cat=null;

try {
	Connection cnx= dat.getConnection();
	PreparedStatement pr= cnx.prepareStatement("select * from Categorie where id=?");
	pr.setInt(1, id);
	ResultSet rs=pr.executeQuery();
	while(rs.next()) {
		 cat=new Categorie(rs.getInt("id"),rs.getString("titre"));
	}
} catch (Exception e) {
	// TODO: handle exception
}
return cat;
	}

	public void addProduit(Produit p) {
try {
	Connection cnx= dat.getConnection();
	PreparedStatement pr= cnx.prepareStatement("insert into produit values (null,?,?,?)");
	pr.setString(1, p.getTitre());
	pr.setInt(2, p.getPrix());
	pr.setInt(3, p.getCat().getId());
	pr.executeUpdate();

}catch(Exception e) {
		
}
	}

}
