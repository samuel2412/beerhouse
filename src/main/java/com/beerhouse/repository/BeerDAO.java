package com.beerhouse.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.beerhouse.models.Beer;

@Repository
@Transactional
public class BeerDAO {

	@PersistenceContext
	private EntityManager manager;

	public void gravar(Beer beer) {
		manager.persist(beer);
	}

	public List<Beer> listar() {
		return manager.createQuery("select p from Beer p", Beer.class).getResultList();
	}

	public void atualizar(Beer beer) {
		manager.merge(beer);
	}

	public void remover(Beer beer) {
		manager.remove(beer);
	}

}
