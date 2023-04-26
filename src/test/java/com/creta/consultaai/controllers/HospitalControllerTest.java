package com.creta.consultaai.controllers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import com.creta.consultaai.controller.HospitalController;
import com.creta.consultaai.service.impl.HospitalServiceImpl;

@WebMvcTest(HospitalController.class)											// configurada
@ActiveProfiles("dev")
public class HospitalControllerTest {
	

}
