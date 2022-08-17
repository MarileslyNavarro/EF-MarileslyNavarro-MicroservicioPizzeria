package com.idat.EFMarileslyNavarroMicroservicioPizzeriaPrueba.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.idat.EFMarileslyNavarroMicroservicioPizzeriaPrueba.dto.Pizza;
import com.idat.EFMarileslyNavarroMicroservicioPizzeriaPrueba.entity.Pizzeria;
import com.idat.EFMarileslyNavarroMicroservicioPizzeriaPrueba.entity.PizzeriaPizza;
import com.idat.EFMarileslyNavarroMicroservicioPizzeriaPrueba.entity.PizzeriaPizzaFK;
import com.idat.EFMarileslyNavarroMicroservicioPizzeriaPrueba.pizz.OpenFeignPizza;
import com.idat.EFMarileslyNavarroMicroservicioPizzeriaPrueba.repository.PizzeriaPizzaRepository;
import com.idat.EFMarileslyNavarroMicroservicioPizzeriaPrueba.repository.PizzeriaRepository;

@Service
public class PizzeriaServiceImp implements PizzeriaService {

	@Autowired
	private PizzeriaRepository repositoryPizzeria;
	
	@Autowired
	private PizzeriaPizzaRepository repositoryDetalle;
	
	@Autowired
	private OpenFeignPizza feign;
	
	@Override
	public List<Pizzeria> listar() {
		return repositoryPizzeria.findAll();
	}

	@Override
	public Pizzeria obtenerId(Integer id) {
		return repositoryPizzeria.findById(id).orElse(null);
	}

	@Override
	public void guardar(Pizzeria pizzeria) {
		repositoryPizzeria.save(pizzeria);
	}

	@Override
	public void eliminar(Integer id) {
		repositoryPizzeria.deleteById(id);
	}

	@Override
	public void actualizar(Pizzeria pizzeria) {
		repositoryPizzeria.saveAndFlush(pizzeria);
	}

	@Override
	public void asignarPizzeriaPizza() {
		
		List<Pizza> listado = feign.listarPizzaSeleccionados();
		PizzeriaPizzaFK fk = null;
		PizzeriaPizza detalle = null;

		
		for (Pizza pizza : listado) {
			
			fk = new PizzeriaPizzaFK();
			fk.setIdPizza(pizza.getIdPizza());
			fk.setIdPizzeria(1);
			
			detalle = new PizzeriaPizza();
			detalle.setFk(fk);	
			
			repositoryDetalle.save(detalle);
		}
		
	}

}
