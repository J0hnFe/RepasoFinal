package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.repo.modelo.Propietario;
import com.example.service.IPropietarioService;

@Controller
@RequestMapping("/propietarios") //indica que el metodo anotado se ejecutara cuando se realice una solicitud HTTP a la ruta
public class PropietarioController {
	
	@Autowired
	private IPropietarioService propietarioService;
	
	//http://localhost:8080/concesionario/propietarios/buscarTodos
	@GetMapping("/buscarTodos")
	public String buscarTodos(Model model) {
		
		List<Propietario> lista = this.propietarioService.buscarTodos();
		model.addAttribute("propietarios", lista);
		return "vistaBuscarTodos"; //nombre de la vista html
		
	}
	//http://localhost:8080/concesionario/propietarios/buscarPorId/1
	@GetMapping("/buscarPorId/{idPropietario}")
	public String buscarPorId(@PathVariable("idPropietario") Integer id, Model model) {
		Propietario p = this.propietarioService.buscarPorId(id);
		model.addAttribute("propietario", p);
		return "vistaBuscarPorId";
	}
	
	//http://localhost:8080/concesionario/propietarios/actualizar
	@PutMapping("/actualizar/{idPropietario}")
	public String actualizarPropietario(@PathVariable("idPropietario") Integer id, Propietario propietario) {
		this.propietarioService.actualizar(propietario);
		return "redirect:/propietarios/buscarTodos";
	}

}
