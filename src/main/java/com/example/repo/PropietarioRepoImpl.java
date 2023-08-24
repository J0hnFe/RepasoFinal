package com.example.repo;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.repo.modelo.Propietario;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class PropietarioRepoImpl implements IPropietarioRepo{

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public void insertar(Propietario p) {
		this.entityManager.persist(p);
	}

	@Override
	public Propietario seleccionarPorId(Integer id) {
		return this.entityManager.find(Propietario.class, id);
	}

	@Override
	public void actualizar(Propietario p) {
		this.entityManager.merge(p);
	}

	@Override
	public List<Propietario> seleccionarTodos() {
		String jpql = "SELECT p FROM Propietario p";
		TypedQuery<Propietario> query = this.entityManager.createQuery(jpql, Propietario.class);
		return query.getResultList();
	}

	@Override
	public void eliminar(Integer id) {
		Propietario pAux = this.seleccionarPorId(id);
		this.entityManager.remove(pAux);
	}

}
