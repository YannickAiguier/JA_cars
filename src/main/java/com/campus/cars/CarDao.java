package com.campus.cars;

import java.util.List;
import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//indique à Spring qu'il s'agit d'une classe qui gère des données
@Repository
public interface CarDao extends JpaRepository<Car, Integer>{
	
	Car findById(int id);

}
