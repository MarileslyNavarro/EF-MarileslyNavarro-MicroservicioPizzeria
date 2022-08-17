package com.idat.EFMarileslyNavarroMicroservicioPizzeriaPrueba.pizz;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import com.idat.EFMarileslyNavarroMicroservicioPizzeriaPrueba.dto.Pizza;

@FeignClient(name="ef-pizza", url="localhost:8090")
public interface OpenFeignPizza {

	@GetMapping("/api/pizza/v1/listar")
	public List<Pizza> listarPizzaSeleccionados();
	
}
