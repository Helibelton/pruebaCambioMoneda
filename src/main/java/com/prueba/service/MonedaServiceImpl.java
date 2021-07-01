package com.prueba.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.prueba.exception.ResourceNotFoundException;
import com.prueba.model.Moneda;
import com.prueba.repository.MonedaRepository;

@Service
@Transactional
public class MonedaServiceImpl implements MonedaService {
	
	@Autowired
	private MonedaRepository monedaRepository;

	@Override
	public Moneda createMoneda(Moneda moneda) {
		return monedaRepository.save(moneda);
	}

	@Override
	public Moneda updateMoneda(Moneda moneda) {
		Optional<Moneda> monedaDb = this.monedaRepository.findById(moneda.getId());
		BigDecimal montoFinal;
		if(monedaDb.isPresent()) {
			Moneda monedaUpdate = monedaDb.get();
			monedaUpdate.setId(moneda.getId());
			monedaUpdate.setMonedaorigen(moneda.getMonedaorigen());
			monedaUpdate.setMonedadestino(moneda.getMonedadestino());
			monedaUpdate.setCambio(moneda.getCambio());
			monedaUpdate.setMontoinicial(moneda.getMontoinicial());
			montoFinal = moneda.getMontoinicial().multiply(moneda.getCambio());
			monedaUpdate.setMontofinal(montoFinal);
			monedaRepository.save(monedaUpdate);
			return monedaUpdate;
		}else {
			throw new ResourceNotFoundException("Registro no encontrado con id : " + moneda.getId());
		}	
	}

	@Override
	public List<Moneda> getAllMoneda() {
		return this.monedaRepository.findAll();
	}

	@Override
	public Moneda getMonedaById(long monedaId) {
		
		Optional<Moneda> monedaDb = this.monedaRepository.findById(monedaId);
		
		if(monedaDb.isPresent()) {
			return monedaDb.get();
		}else {
			throw new ResourceNotFoundException("Registro no encontrado con id : " + monedaId);
		}
		
	}

}
