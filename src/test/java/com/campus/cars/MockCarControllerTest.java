package com.campus.cars;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringJUnit4ClassRunner.class)
@WebMvcTest(CarController.class)
public class MockCarControllerTest {

	@Autowired
	private MockMvc mvc;

	@Autowired
	private WebApplicationContext context;

	@MockBean
	private CarRepository myCars;

	@BeforeEach
	public void setup() {
		this.mvc = MockMvcBuilders
				.webAppContextSetup(this.context)
				.build();
	}

	@Test
	public void getCarByIdAPI() throws Exception {
		Mockito.when(myCars.findById(1)).thenReturn(new Car(1, "toto", "", ""));
		Mockito.when(myCars.findById(2)).thenReturn(new Car(2, "titi", "", ""));
		mvc.perform(MockMvcRequestBuilders.get("/modeles/{id}", 1).contentType(MediaType.APPLICATION_JSON))
				.andDo(print())
		.andExpect(status().isOk())
		.andExpect(MockMvcResultMatchers.jsonPath("$.marque").value("toto"));
	}

	@Test
	public void getAllCarsAPI() throws Exception {
		mvc.perform(MockMvcRequestBuilders.get("/modeles").contentType(MediaType.APPLICATION_JSON)).andDo(print());
	}
}
