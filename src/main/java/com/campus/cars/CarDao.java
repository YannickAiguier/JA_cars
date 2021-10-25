package com.campus.cars;

import java.util.List;
import java.util.ArrayList;

import org.springframework.stereotype.Repository;

@Repository
public class CarDao {

	public static List<Car> cars = new ArrayList<Car>();
	static {
		cars.add(new Car(1, new String("Peugeot"), new String("206"), new String("bleue")));
		cars.add(new Car(2, new String("Renault"), new String("Clio"), new String("rouge")));
		cars.add(new Car(3, new String("Ferrari"), new String("Testarossa"), new String("jaune")));
	}

	public List<Car> findAll() {
		return cars;
	}

	public Car findCarById(int id) {
		for (Car car : cars) {
			if (car.getId() == id) {
				return car;
			}
		}
		return null;
	}

}
