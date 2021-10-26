package com.campus.cars;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

// annotation swagger pour personnaliser le message de descritpion du controller
@Api(description = "API pour les opérations CRUD sur les modèles de voitures")
//annotation qui combine @Controller (gère les requêtes http) et @ResponseBody (lie la valeur de retour au corps de la réponse http, convertit l'objet renvoyé en JSON) 
@Controller
public class CarController {

	// instancie automatiquement un objet de la classe indiquée
	@Autowired
	private CarDao myCars;

	// annotation swagger pour personnaliser la description du end-point
	@ApiOperation(value = "Affiche la liste des modèles de voitures")
	// indique que la méthode répondra à une requête GET
	// équivalent à @RequestMapping(method=RequestMethod.GET,value=...)
	@GetMapping(value = { "/" })
	public String index() {
		return "index";
	}

	@GetMapping(value = { "/modeles" })
	public String list(Model model) {
		model.addAttribute("cars", myCars.findAll());
		return "carsList";
	}

	@ApiOperation(value = "Affiche les caractéristiques d'une voiture d'après son Id")
	// indique que la méthode répondra à une requête GET
	@GetMapping(value = "/modeles/{id}")
	public String show(@PathVariable int id, Model model) {
		model.addAttribute("car", myCars.findCarById(id));
		return "car";
	}

	@ApiOperation(value = "Ajoute un modèle de voiture")
	@PostMapping(value = "/modeles")
	public Car addCar(@RequestBody Car car) {
		return myCars.save(car);
	}

	@ApiOperation(value = "Modifie un modèle de voiture")
	@PutMapping(value = "/modeles/{id}")
	public Car updateCar(@PathVariable int id, @RequestBody Car car) {
		return myCars.update(car, id);
	}

	@ApiOperation(value = "Supprime un modèle de voiture par son Id")
	@DeleteMapping(value = "/modeles/{id}")
	public String deleteCar(@PathVariable int id) {
		myCars.delete(id);
		return "";
	}

}
