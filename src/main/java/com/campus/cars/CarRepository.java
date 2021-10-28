package com.campus.cars;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarRepository extends JpaRepository<Car, Integer> {

	Car findById(int id);
	
	Car findByMarqueAndModele(String marque, String modele);
}
