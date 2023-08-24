package com.example.service;

import java.util.List;

import com.example.repo.modelo.Propietario;

public interface IPropietarioService {

	public void agregar(Propietario p);
	public Propietario buscarPorId(Integer id);
	public void actualizar(Propietario p);
	public void borrar(Integer id);
	public List<Propietario> buscarTodos();
	
}
