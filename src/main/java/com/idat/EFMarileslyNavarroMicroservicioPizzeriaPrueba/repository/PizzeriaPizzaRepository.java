package com.idat.EFMarileslyNavarroMicroservicioPizzeriaPrueba.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.idat.EFMarileslyNavarroMicroservicioPizzeriaPrueba.entity.PizzeriaPizza;

@Repository
public interface PizzeriaPizzaRepository extends JpaRepository<PizzeriaPizza, Integer> {

}
