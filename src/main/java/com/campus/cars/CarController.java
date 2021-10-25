package com.campus.cars;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CarController {
	@GetMapping(value="/cars")
	public String index() {
		return "Liste de toutes les voitures";
	}
	
	@GetMapping(value="/cars/{id}")
	public String show(@PathVariable int id) {
		Car myCar = new Car(id, "Peugeot", "206", "beige");
		return myCar.toString();
	}

}
