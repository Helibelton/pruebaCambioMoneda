package com.prueba.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prueba.model.Moneda;

public interface MonedaRepository extends JpaRepository<Moneda, Long> {

}
