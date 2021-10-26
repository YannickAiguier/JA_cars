package com.campus.cars;

import java.util.List;
import java.util.ArrayList;

import org.springframework.stereotype.Repository;

//indique à Spring qu'il s'agit d'une classe qui gère des données
@Repository
public class CarDao {

	// Création d'une liste d'objets Car pour simuler une base de données
	private List<Car> cars = new ArrayList<Car>();

	public CarDao() {
		cars.add(new Car(1, new String("Peugeot"), new String("206"), new String("bleue")));
		cars.add(new Car(2, new String("Renault"), new String("Clio"), new String("rouge")));
		cars.add(new Car(3, new String("Ferrari"), new String("Testarossa"), new String("jaune")));
	}

	// retourne toutes les voitures dans la liste
	public List<Car> findAll() {
		return cars;
	}

	// retourne la voiture correspondant à id, sinon retourne null
	public Car findCarById(int id) {
		for (Car car : cars) {
			if (car.getId() == id) {
				return car;
			}
		}
		return null;
	}

	public Car save(Car car) {
		Car tmpCar = new Car(getLastId()+1, car.getMarque(), car.getModele(), car.getCouleur());
		cars.add(tmpCar);
		return tmpCar;
	}

	public Car update(Car car, int id) {
		int index = -1;
		car.setId(id);
		for (Car myCar : cars) {
			if (myCar.getId() == id) {
				index = cars.indexOf(myCar);
				break;
			}
		}
		if (index != -1) {
			cars.set(index, car);
			return car;
		}
		return null;
	}

	public void delete(int id) {
		for (Car myCar : cars) {
			if (myCar.getId() == id) {
				cars.remove(myCar);
				break;
			}
		}
	}
	
	private int getLastId() {
		return (cars.get(cars.size() - 1).getId());
	}

}
