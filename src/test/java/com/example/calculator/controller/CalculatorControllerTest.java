package com.example.calculator.controller;

import com.example.calculator.service.CalculatorService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(CalculatorController.class)
class CalculatorControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CalculatorService calculatorService;

    @Test
    void testAddEndpoint() throws Exception {
        when(calculatorService.add(5, 3)).thenReturn(8.0);

        mockMvc.perform(get("/api/calculator/add")
                .param("a", "5")
                .param("b", "3"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.result").value(8.0))
                .andExpect(jsonPath("$.operation").value("addition"));
    }

    @Test
    void testSubtractEndpoint() throws Exception {
        when(calculatorService.subtract(10, 4)).thenReturn(6.0);

        mockMvc.perform(get("/api/calculator/subtract")
                .param("a", "10")
                .param("b", "4"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.result").value(6.0))
                .andExpect(jsonPath("$.operation").value("subtraction"));
    }

    @Test
    void testMultiplyEndpoint() throws Exception {
        when(calculatorService.multiply(5, 4)).thenReturn(20.0);

        mockMvc.perform(get("/api/calculator/multiply")
                .param("a", "5")
                .param("b", "4"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.result").value(20.0))
                .andExpect(jsonPath("$.operation").value("multiplication"));
    }

    @Test
    void testDivideEndpoint() throws Exception {
        when(calculatorService.divide(10, 2)).thenReturn(5.0);

        mockMvc.perform(get("/api/calculator/divide")
                .param("a", "10")
                .param("b", "2"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.result").value(5.0))
                .andExpect(jsonPath("$.operation").value("division"));
    }

    @Test
    void testDivideByZeroEndpoint() throws Exception {
        when(calculatorService.divide(10, 0))
                .thenThrow(new ArithmeticException("Division by zero is not allowed"));

        mockMvc.perform(get("/api/calculator/divide")
                .param("a", "10")
                .param("b", "0"))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.error").value("Division by zero is not allowed"));
    }

    @Test
    void testHealthEndpoint() throws Exception {
        mockMvc.perform(get("/api/calculator/health"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.status").value("UP"))
                .andExpect(jsonPath("$.service").value("Calculator API"));
    }
}
