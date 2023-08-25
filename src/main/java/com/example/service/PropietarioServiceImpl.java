package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.repo.IPropietarioRepo;
import com.example.repo.modelo.Propietario;

import jakarta.transaction.Transactional;
import jakarta.transaction.Transactional.TxType;

@Service
public class PropietarioServiceImpl implements IPropietarioService{

	@Autowired
	private IPropietarioRepo iPropietarioRepo;
	
	@Override
	@Transactional(value = TxType.REQUIRES_NEW)
	public Propietario buscarPorId(Integer id) {
		// TODO Auto-generated method stub
		return this.iPropietarioRepo.buscarPorId(id);
	}

	@Override
	@Transactional(value = TxType.MANDATORY)
	public void insertar(Propietario propietario) {
		// TODO Auto-generated method stub
		this.iPropietarioRepo.insertar(propietario);
	}

	@Override
	@Transactional(value = TxType.REQUIRES_NEW)
	public void actualizar(Propietario propietario) {
		// TODO Auto-generated method stub
		this.iPropietarioRepo.actualizar(propietario);
	}

	@Override
	@Transactional(value = TxType.MANDATORY)
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		this.iPropietarioRepo.eliminar(id);
	}

	@Override
	@Transactional(value = TxType.NOT_SUPPORTED)
	public List<Propietario> buscarTodos() {
		// TODO Auto-generated method stub
		return this.iPropietarioRepo.buscarTodos();
	}

	
}
