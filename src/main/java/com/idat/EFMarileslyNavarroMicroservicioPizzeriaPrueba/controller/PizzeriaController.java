package com.idat.EFMarileslyNavarroMicroservicioPizzeriaPrueba.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.idat.EFMarileslyNavarroMicroservicioPizzeriaPrueba.entity.Pizzeria;
import com.idat.EFMarileslyNavarroMicroservicioPizzeriaPrueba.service.PizzeriaService;

@Controller
@RequestMapping("/api/pizzeria/v1")
public class PizzeriaController {

	@Autowired
	private PizzeriaService service;
	
	@GetMapping("/listar")
	public @ResponseBody List<Pizzeria> listar() {
		return service.listar();
	}
	
	@GetMapping("/listar/{id}")
	public @ResponseBody Pizzeria obtener(@PathVariable Integer id) {
		return service.obtenerId(id);
	}

	@PostMapping("/guardar")
	public ResponseEntity<Void> guardar(@RequestBody Pizzeria pizzeria) {
		service.guardar(pizzeria);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	@PutMapping("/actualizar")
	public @ResponseBody void actualizar(@RequestBody Pizzeria pizzeria) {
		service.actualizar(pizzeria);
	}
	
	@DeleteMapping("/eliminar/{id}")
	public @ResponseBody void eliminar(@PathVariable Integer id) {
		service.eliminar(id);
	}
	
	@GetMapping("/asignar")
	public @ResponseBody void asignarPizzeriaPizza() {
		service.asignarPizzeriaPizza();
	}
	
}
