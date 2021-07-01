package com.prueba.service;

import java.util.List;

import com.prueba.model.Moneda;

public interface MonedaService {
	
	Moneda createMoneda(Moneda moneda);

	Moneda updateMoneda(Moneda moneda);

	List<Moneda> getAllMoneda();

	Moneda getMonedaById(long monedaId);

}
