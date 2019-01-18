package com.hospitalapp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.hospitalapp.models.Paciente;
import com.hospitalapp.repository.PacienteRepository;

@Controller
public class PacienteController {
	@Autowired
	private PacienteRepository pr;
	
	@RequestMapping(value="/cadastrarPaciente", method=RequestMethod.GET)
	public String form() {
		return "evento/formPaciente";
	}
	@RequestMapping(value="/cadastrarPaciente", method=RequestMethod.POST)
	public String form(Paciente paciente) {
		pr.save(paciente);
		return "redirect:/cadastrarPaciente";
	}

	@RequestMapping("/paciente")
	public ModelAndView listaPaciente() {
		ModelAndView mv= new ModelAndView("index");
		Iterable<Paciente> pacientes= pr.findAll();
		mv.addObject("pacientes", pacientes);
		return mv;
	}
	
	@RequestMapping("/{codigo}")
	public ModelAndView detalhesPaciente(@PathVariable("codigo") long codigo) {
		Paciente paciente= pr.findByCodigo(codigo);
		ModelAndView mv= new ModelAndView("evento/detalhesPaciente");
		mv.addObject("pacientes", paciente);
		return mv;
		}
	
}
