package tn.essat.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import tn.essat.dao.IGestion;
import tn.essat.model.Categorie;
import tn.essat.model.Produit;

@Controller
public class AppCont {
	@Autowired
	IGestion gest;

	public void setGest(IGestion gest) {
		this.gest = gest;
	}

	@GetMapping("/categories")
	public String f1(Model m) {
		List<Categorie> liste = gest.getAllCategories();
		m.addAttribute("liste", liste);
		return "page1";

	}

	@GetMapping("/produits/{id}")
	public String f2(Model m, @PathVariable int id) {
//			@requestParam("id") int id sans id en mapping
		List<Produit> liste = gest.getAllProduitsByCategorieID(id);
		m.addAttribute("liste", liste);

		return "page2";
	}

	@GetMapping("/ajout")
	public String f3(Model m) {
		Produit p = new Produit();
		m.addAttribute("prod", p);
		List <Categorie> cats=gest.getAllCategories();
		m.addAttribute("cats", cats);
		return "page3";
	}

	@PostMapping("/save")
	public String f4(Model m, @ModelAttribute("prod") Produit p) {
		gest.addProduit(p);
		return "redirect:/categories";

	}
}
