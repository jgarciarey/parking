package com.parking.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.parking.manager.VehiculoManager;

@Controller
public class VehiculoController {
	protected final Log Logger = LogFactory.getLog(getClass());

	@Autowired
	VehiculoManager vehiculoManager;

	@RequestMapping(value = "/vehiculos")
	public ModelAndView getVehiculos() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("listaVehiculos", vehiculoManager.listar());
		mv.setViewName("vehiculos");

		return mv;
	}
}
