package com.parking.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.parking.dao.EntradaDAO;
import com.parking.manager.EntradaManager;
import com.parking.manager.VehiculoManager;
import com.parking.model.Entrada;
import com.parking.model.Vehiculo;

@Controller
public class EntradasController {
	protected final Log Logger = LogFactory.getLog(getClass());

	@Autowired
	EntradaManager entradaManager;
	
	@Autowired
	VehiculoManager vehiculoManager;
	
	@Autowired
	EntradaDAO entradaDAO;

	@RequestMapping(value = "/entradas")
	public ModelAndView listEntradas() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("listaEntradas", entradaManager.listar());
		mv.addObject("plazasTotales", entradaManager.getPlazasTotales());
		mv.addObject("plazasDisponibles", entradaManager.getPlazasDisponibles());
		mv.addObject("plazasOcupadas", entradaManager.getPlazasOcupadas());
		mv.setViewName("entradas");

		return mv;
	}
	
	@RequestMapping(value="/searchEntrada", method = RequestMethod.GET)
	public ModelAndView searchEntrada(@RequestParam String matricula) {
		Entrada entrada = entradaManager.getEntrada(matricula);
		 
	    return new ModelAndView("searchEntrada", "matricula", entrada);
	}
	
	@RequestMapping(value = "/addEntrada", method = RequestMethod.GET)
	public ModelAndView newContact(ModelAndView model) {
	    model.addObject("entrada", new Entrada());
	    
	    Map<Integer, String> tiposVehiculo = new HashMap<Integer, String>();
	    for (Vehiculo v: vehiculoManager.listar()) {
	    	tiposVehiculo.put(v.getId_vehiculo(), v.getTipo());
	    }
	    
	    model.addObject("tiposVehiculo", tiposVehiculo);
	    model.setViewName("entradasForm");
	    return model;
	}
	
	@RequestMapping(value = "/saveEntrada", method = RequestMethod.POST)
	public ModelAndView saveEntrada(@ModelAttribute Entrada entrada) {
	    entradaDAO.insertarEntrada(entrada);
	    return new ModelAndView("redirect:/entradas");
	}
	
	@RequestMapping(value = "/editEntrada/{matricula}", method = RequestMethod.GET)
	public ModelAndView editEntrada(@PathVariable String matricula) {
		ModelAndView model = new ModelAndView("entradasForm");
	    Entrada entrada = entradaManager.getEntrada(matricula);
	    Map<String,String> tipoVehiculo = new LinkedHashMap<String,String>();
	    for (Vehiculo v : vehiculoManager.listar()) {
	    	tipoVehiculo.put("vehiculoList", v.getTipo());
	    }
	    
	    model.addObject("entrada", entrada);
	    model.addObject("tiposVehiculo", tipoVehiculo);
	    return model;
	}
	
	@RequestMapping(value = "/deleteEntrada/{matricula}", method = RequestMethod.GET)
	public ModelAndView deleteEntrada(@PathVariable String matricula) {
	    entradaManager.eliminar(matricula);
	    return new ModelAndView("redirect:/entradas");
	}
	
	
	
}
