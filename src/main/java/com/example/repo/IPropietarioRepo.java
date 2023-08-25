package com.example.repo;

import java.util.List;

import com.example.repo.modelo.Propietario;

public interface IPropietarioRepo {

	public Propietario buscarPorId(Integer id);
	public void insertar (Propietario propietario);
	public void actualizar(Propietario propietario);
	public void eliminar (Integer id);
	public List<Propietario> buscarTodos();
	
}
