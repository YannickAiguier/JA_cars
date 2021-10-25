package com.campus.cars;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

//annotation qui combine @Controller (gère les requêtes http) et @ResponseBody (lie la valeur de retour au corps de la réponse http, convertit l'objet renvoyé en JSON) 
@Controller
public class CarController {
	
	private static List<Car> myCars = new ArrayList<Car>();
	static {
		myCars.add(new Car(1, new String("Peugeot"), new String("206"), new String("bleue")));
		myCars.add(new Car(2, new String("Renault"), new String("Clio"), new String("rouge")));
		myCars.add(new Car(3, new String("Ferrari"), new String("Testarossa"), new String("jaune")));
	}
	
	// indique que la méthode répondra à une requête GET
	// équivalent à @RequestMapping(method=RequestMethod.GET,value=...)
	@GetMapping(value={"/"})
	public String index() {
		return "index";
	}
	
	@GetMapping(value={"/cars"})
	public String list(Model model) {
		model.addAttribute("cars", myCars);
		return "carsList";
	}
	
	// indique que la méthode répondra à une requête GET
	@GetMapping(value="/cars/{id}")
	public String show(@PathVariable int id, Model model) {
		for (Car car : myCars) {
			if (car.getId() == id) {
				model.addAttribute("car", car);
			}
		}
		return "car";
	}

}
