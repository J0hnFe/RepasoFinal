package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.repo.IPropietarioRepo;
import com.example.repo.modelo.Propietario;

@Service
public class PropietarioServiceImpl implements IPropietarioService {

	@Autowired
	private IPropietarioRepo propietarioRepo;
	
	@Override
	public void agregar(Propietario p) {
		this.propietarioRepo.insertar(p);
	}

	@Override
	public Propietario buscarPorId(Integer id) {
		return this.propietarioRepo.seleccionarPorId(id);
	}

	@Override
	public void actualizar(Propietario p) {
		this.propietarioRepo.actualizar(p);
	}

	@Override
	public void borrar(Integer id) {
		this.propietarioRepo.eliminar(id);
	}

	@Override
	public List<Propietario> buscarTodos() {
		return this.propietarioRepo.seleccionarTodos();
	}

}
