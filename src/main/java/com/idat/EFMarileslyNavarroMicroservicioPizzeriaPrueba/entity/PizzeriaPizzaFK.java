package com.idat.EFMarileslyNavarroMicroservicioPizzeriaPrueba.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.Data;

@Data
@Embeddable
public class PizzeriaPizzaFK implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5408560493439074416L;

	@Column(name="id_pizzeria", nullable = false, unique = true)
	private Integer idPizzeria;
	
	@Column(name="id_pizza", nullable = false, unique = true)
	private Integer idPizza;
	
}
