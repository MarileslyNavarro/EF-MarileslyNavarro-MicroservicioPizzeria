package com.idat.EFMarileslyNavarroMicroservicioPizzeriaPrueba.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.idat.EFMarileslyNavarroMicroservicioPizzeriaPrueba.entity.Pizzeria;


@Repository
public interface PizzeriaRepository extends JpaRepository<Pizzeria, Integer> {

}
