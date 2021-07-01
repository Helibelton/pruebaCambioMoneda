package com.prueba.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.prueba.model.Moneda;
import com.prueba.service.MonedaService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class MonedaController {
	
	@Autowired
	private MonedaService monedaService;
	
	@GetMapping("/monedas")
	public Mono<ResponseEntity<Flux<Moneda>>> getAllMoneda(){
		List<Moneda> monedas = monedaService.getAllMoneda();
		Flux<Moneda> monedasFlux = Flux.fromIterable(monedas);
		return Mono.just(ResponseEntity.ok()
				.contentType(MediaType.APPLICATION_JSON)
				.body(monedasFlux));
	}
	
	@GetMapping("/monedas/{id}")
	public Mono<ResponseEntity<Moneda>> getProductById(@PathVariable long id){
		Moneda objMon = monedaService.getMonedaById(id);
		return Mono.just(ResponseEntity.ok()
				.contentType(MediaType.APPLICATION_JSON)
				.body(objMon));
	}
	
	@PostMapping("/monedas")
	public Mono<ResponseEntity<Moneda>> createMoneda(@RequestBody Moneda moneda){
		Moneda objMon = this.monedaService.createMoneda(moneda);
		return Mono.just(ResponseEntity.ok()
				.contentType(MediaType.APPLICATION_JSON)
				.body(objMon));
	}
	
	@PutMapping("/monedas/{id}")
	public Mono<ResponseEntity<Moneda>> updateMoneda(@PathVariable long id, @RequestBody Moneda moneda){
		moneda.setId(id);
		Moneda objMon = this.monedaService.updateMoneda(moneda);
		return Mono.just(ResponseEntity.ok()
				.contentType(MediaType.APPLICATION_JSON)
				.body(objMon));
	}

}
