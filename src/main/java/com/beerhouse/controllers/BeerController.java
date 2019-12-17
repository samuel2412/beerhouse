package com.beerhouse.controllers;

import java.net.URI;
import java.util.List;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.beerhouse.models.Beer;
import com.beerhouse.repository.BeerRepository;

@RestController
@RequestMapping("/beers")
public class BeerController {

	
	@Autowired BeerRepository beerRepo;
	
	//gets
	@GetMapping
	public List<Beer> getBeers() {
		return beerRepo.findAll();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Beer> detalheBeer(@PathVariable Long id) {
		Beer beer = beerRepo.findOne(id);
		if (beer != null) {
			return ResponseEntity.ok(beer);
		}
		return ResponseEntity.notFound().build();
	}
	
	//post
	@PostMapping
	@Transactional
	public ResponseEntity<Beer> cadastrar(@RequestBody Beer beer, UriComponentsBuilder uriBuilder) {

		beerRepo.save(beer);

		URI uri = uriBuilder.path("/beers/{id}").buildAndExpand(beer.getId()).toUri();

		return ResponseEntity.created(uri).body(beer);
	}
	
	//put
	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<Beer> atualizar(@PathVariable Long id, @RequestBody @Valid Beer form) {
		Beer aux = beerRepo.findOne(id);
		if (aux != null) {
			Beer beer = form.atualizar(id, beerRepo);
			return ResponseEntity.ok(beer);
		}
		return ResponseEntity.notFound().build();	
		
	}
	
	//delete
	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<Beer> excluir(@PathVariable Long id) {
		Beer beer = beerRepo.findOne(id);
		if (beer != null) {
			beerRepo.delete(id);
			return ResponseEntity.ok().build();
		}
		return ResponseEntity.notFound().build();	
		
	}
	
}
