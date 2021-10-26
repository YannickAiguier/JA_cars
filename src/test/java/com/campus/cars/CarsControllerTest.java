package com.campus.cars;

import static org.assertj.core.api.Assertions.assertThat;

import org.hamcrest.core.IsEqual;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

//@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CarsControllerTest {
	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	public void getAllModelsTest() {
		String body = this.restTemplate.getForObject("/modeles", String.class);
		String result = "[{\"id\":1,\"marque\":\"Peugeot\",\"modele\":\"206\",\"couleur\":\"bleue\"},{\"id\":2,\"marque\":\"Renault\",\"modele\":\"Clio\",\"couleur\":\"rouge\"},{\"id\":3,\"marque\":\"Ferrari\",\"modele\":\"Testarossa\",\"couleur\":\"jaune\"}]";
		assertThat(body).isEqualTo(result);
	}

	@Test
	public void createModelTest() {
		String body = this.restTemplate.postForObject("/modeles", "{\"marque\": \"Citroën\",\"modele\": \"Berlingo\",\"couleur\": \"vert\"}", String.class);
		ResponseEntity<String> response = restTemplate.postForEntity("/modeles", "{\"marque\": \"Citroën\",\"modele\": \"Berlingo\",\"couleur\": \"vert\"}", String.class);
		assertThat(response.getStatusCode().equals(HttpStatus.CREATED));
	}

	@Test
	public void updateModelTest() {

	}

	@Test
	public void getModelTest() {
		String body = this.restTemplate.getForObject("/modeles/1", String.class);
		String result = "{\"id\":1,\"marque\":\"Peugeot\",\"modele\":\"206\",\"couleur\":\"bleue\"}";
		assertThat(body).isEqualTo(result);
	}

	@Test
	public void deleteModelTest() {

	}
}