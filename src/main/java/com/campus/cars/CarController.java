package com.campus.cars;



import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.campus.cars.exceptions.carNotFoundException;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

// annotation swagger pour personnaliser le message de descritpion du controller
@Api(description="API pour les opérations CRUD sur les modèles de voitures")
//annotation qui combine @Controller (gère les requêtes http) et @ResponseBody (lie la valeur de retour au corps de la réponse http, convertit l'objet renvoyé en JSON) 
@RestController
//@Validated
public class CarController {
	
	// instancie automatiquement un objet de la classe indiquée
	@Autowired
	private CarRepository myCars;
	
	// annotation swagger pour personnaliser la description du end-point
	@ApiOperation(value="Affiche la liste des modèles de voitures")
	// indique que la méthode répondra à une requête GET
	// équivalent à @RequestMapping(method=RequestMethod.GET,value=...)
	@GetMapping(value="/modeles")
	public @ResponseBody Iterable<Car> getAllCars() {
		return myCars.findAll();
	}
	
	@ApiOperation(value="Affiche les caractéristiques d'une voiture d'après son Id")
	// indique que la méthode répondra à une requête GET
	@GetMapping(value="/modeles/{id}")
	public Car show(@PathVariable int id) {
		Car car = myCars.findById(id);
		if (car == null) throw new carNotFoundException("La voiture avec l'id " + id + " est INTROUVABLE !");
		return car;
	}
	
	@ApiOperation(value="Ajoute un modèle de voiture")
	@PostMapping(value="/modeles")
	public Car addCar(@Valid @RequestBody Car car) {
		return myCars.save(car);
	}
	
	@ApiOperation(value="Modifie un modèle de voiture")
	@PutMapping(value="/modeles/{id}")
	public Car updateCar(@RequestBody Car car) {
		return myCars.save(car);
	}
	
	@ApiOperation(value="Supprime un modèle de voiture par son Id")
	@DeleteMapping(value="/modeles/{id}")
	public String deleteCar(@PathVariable int id) {		
		myCars.deleteById(id);
		return "";
	}

}
