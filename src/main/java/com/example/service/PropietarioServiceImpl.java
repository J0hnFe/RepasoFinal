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
	private IPropietarioRepo propietarioRepo;
	
	@Override
//	@Transactional(value = TxType.REQUIRES_NEW)
	public Propietario buscarPorId(Integer id) {
		return this.propietarioRepo.buscarPorId(id);
	}

	@Override
//	@Transactional(value = TxType.MANDATORY)
	public void agregar(Propietario p) {
		this.propietarioRepo.insertar(p);
	}

	@Override
	@Transactional(value = TxType.REQUIRED)
	public void actualizar(Propietario p) {
		this.propietarioRepo.actualizar(p);
	}

	@Override
//	@Transactional(value = TxType.MANDATORY)
	public void borrarPorId(Integer id) {
		this.propietarioRepo.eliminar(id);
	}

	@Override
//	@Transactional(value = TxType.NOT_SUPPORTED)
	public List<Propietario> buscarTodos() {
		return this.propietarioRepo.buscarTodos();
	}

}
