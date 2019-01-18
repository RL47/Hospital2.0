package com.hospitalapp.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.hospitalapp.models.Medico;
import com.hospitalapp.repository.MedicoRepository;
@Controller
public class MedicoController {
	@Autowired
	MedicoRepository mr;
	
	@RequestMapping(value="/cadastrarMedico", method=RequestMethod.GET)
	public String form() {
		return "evento/medico/formMedico";
	}
	@RequestMapping(value="/cadastrarMedico", method=RequestMethod.POST)
	public String form(Medico medico) {
		mr.save(medico);
		return "redirect:/cadastrarMedico";
	}

	@RequestMapping("/medico")
	public ModelAndView listaMedico() {
		ModelAndView mv= new ModelAndView("indexM");
		Iterable<Medico> medicos= mr.findAll();
		mv.addObject("medicos", medicos);
		return mv;
	}
	
    @RequestMapping("/{codigom}")
	public ModelAndView detalhesMedico(@PathVariable("codigom") long codigo) {
		Medico medico= mr.findByCodigo(codigo);
		ModelAndView mv= new ModelAndView("evento/medico/detalhesMedico");
		mv.addObject("medicos", medico);
		return mv;
		}
	
}

