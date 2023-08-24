package com.example.repo;

import java.util.List;

import com.example.repo.modelo.Propietario;

public interface IPropietarioRepo {

	public void insertar(Propietario p);
	public Propietario seleccionarPorId(Integer id);
	public void actualizar(Propietario p);
	public void eliminar(Integer id);
	public List<Propietario> seleccionarTodos();
	
}
