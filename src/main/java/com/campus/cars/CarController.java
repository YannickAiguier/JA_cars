package com.campus.cars;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

//annotation qui combine @Controller (gère les requêtes http) et @ResponseBody (lie la valeur de retour au corps de la réponse http, convertit l'objet renvoyé en JSON) 
@RestController
public class CarController {
	
	// instancie automatiquement un objet de la classe indiquée
	@Autowired
	private CarDao myCars;
	
	// indique que la méthode répondra à une requête GET
	// équivalent à @RequestMapping(method=RequestMethod.GET,value=...)
	@GetMapping(value="/cars")
	public List<Car> index() {
		return myCars.findAll();
	}
	
	// indique que la méthode répondra à une requête GET
	@GetMapping(value="/cars/{id}")
	public Car show(@PathVariable int id) {
		return myCars.findCarById(id);
	}

}
