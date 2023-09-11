package com.mars.back;

import com.mars.back.model.Operation;
import com.mars.back.service.CalculatorService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@AutoConfigureMockMvc
class BackApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private CalculatorService calculatorService;

	@Test
	void contextLoads() {
	}

	@Test
	void testCalculateEndpoint() throws Exception {
		Operation operation = new Operation(1L, 5, 3, "+", 0);
		String operationJson = "{\"operand1\":5,\"operand2\":3,\"operator\":\"+\",\"result\":0}";
		MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post("/calculator/calculate")
						.contentType(MediaType.APPLICATION_JSON)
						.content(operationJson))
				.andExpect(status().isOk())
				.andExpect(content().string("8"))
				.andReturn();
		int expectedResult = 8;
		int calculatedResult = calculatorService.calculate(operation);
		assertEquals(expectedResult, calculatedResult);
	}
}

