package com.example.repo;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.repo.modelo.Propietario;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import jakarta.transaction.Transactional.TxType;

@Repository
@Transactional
public class PropietarioRepoImpl implements IPropietarioRepo{

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	@Transactional(value = TxType.NOT_SUPPORTED)
	public Propietario buscarPorId(Integer id) {
		// TODO Auto-generated method stub
		return this.entityManager.find(Propietario.class, id);
	}

	@Override
	@Transactional(value = TxType.MANDATORY)
	public void insertar(Propietario propietario) {
		// TODO Auto-generated method stub
		this.entityManager.persist(propietario);
	}

	@Override
	@Transactional(value = TxType.MANDATORY)
	public void actualizar(Propietario propietario) {
		// TODO Auto-generated method stub
		this.entityManager.merge(propietario);
	}

	@Override
	@Transactional(value = TxType.MANDATORY)
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		this.entityManager.remove(this.buscarPorId(id));
	}

	@Override
	@Transactional(value = TxType.NOT_SUPPORTED)
	public List<Propietario> buscarTodos() {
		// TODO Auto-generated method stub
		TypedQuery<Propietario> myQuery = this.entityManager.createQuery("SELECT e FROM Propietario e",Propietario.class);
		return myQuery.getResultList();
	}
}
