package com.example;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.repo.modelo.Propietario;
import com.example.service.IPropietarioService;

@Controller
@RequestMapping("/propietarios")
public class PropietariosController {

	private static final Logger LOG = Logger.getLogger(PropietariosController.class);

	@Autowired
	private IPropietarioService propietarioService;

	@GetMapping("/buscarTodos")
	public String buscarTodos(Model modelo) {

		LOG.info("Info");
		LOG.error("Info");
		LOG.warn("Info");
		LOG.debug("Info");

		List<Propietario> lista = this.propietarioService.buscarTodos();
		modelo.addAttribute("propietarios", lista);
		return "vistaBuscarTodos";
	}

	// http://localhost:8080/concesionario/propietarios/buscarPorID/1
	@GetMapping("/buscarPorID/{idPropietario}")
	public String buscarPorId(@PathVariable("idPropietario") Integer id, Model modelo) {
		Propietario prop = this.propietarioService.buscarPorId(id);
		modelo.addAttribute("propietario", prop);
		return "vistaBuscarPorID";

	}

	@PutMapping("/actualizar/{idPropietario}")
	public String actualizarPropietario(@PathVariable("idPropietario") Integer id, Propietario propietario) {
		this.propietarioService.actualizar(propietario);
		return "redirect:/propietarios/buscarTodos";
	}

	// http://localhost:8080/concesionario/propietarios/borrar/1
	@DeleteMapping("/borrar/{idPropietario}")
	public String eliminarPorId(@PathVariable("idPropietario") Integer id) {
		this.propietarioService.borrarPorId(id);
		return "redirect:/propietarios/buscarTodos";
	}

	@PostMapping("/guardar")
	public String insertarPropietario(Propietario propietario) {
		this.propietarioService.agregar(propietario);
		return "redirect:/propietarios/buscarTodos";
	}

	// Metodo de pagina de redireccionamiento (metodos de redireccionamiento con
	// GetMapping)
	@GetMapping("/nuevo")
	public String paginaNuevoPropietario(Propietario propietario) {
		return "vistaNuevoPropietario";
	}

}
