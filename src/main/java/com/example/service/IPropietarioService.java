package com.example.service;

import java.util.List;

import com.example.repo.modelo.Propietario;

public interface IPropietarioService {

	public Propietario buscarPorId(Integer id);
	public void insertar (Propietario propietario);
	public void actualizar(Propietario propietario);
	public void eliminar (Integer id);
	public List<Propietario> buscarTodos();
	
}
