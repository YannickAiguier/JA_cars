package com.campus.cars;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CarController {
	
	@Autowired
	private CarDao myCars;
	
	@GetMapping(value="/cars")
	public List<Car> index() {
		return myCars.findAll();
	}
	
	@GetMapping(value="/cars/{id}")
	public Car show(@PathVariable int id) {
		return myCars.findCarById(id);
	}

}
