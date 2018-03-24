/**
 * Project Name: arquetipoweb-model
 * Filename: BaseIntegrationServiceTest.java
 * Copyright (c) INDITEX S.A. 2012
 */

package com.pruebas.common;

import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;



/**
 * <PRE>
 * Nombre de la clase: BaseIntegrationServiceTest
 * Código de proyecto: archetype-model
 * Descripción:
 *  Clase base para la creación de un entorno de ejecución autorizado y configuración básica de los tests.
 * 
 * Fecha de creación: 26/04/2012
 * </PRE>
 * 
 * @author joseff
 */
@ContextConfiguration(locations = { "classpath:appSpring/spring-app.xml",
		"classpath:spring/spring-model.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
@TestExecutionListeners({
		org.springframework.test.context.support.DependencyInjectionTestExecutionListener.class,
		org.springframework.test.context.support.DirtiesContextTestExecutionListener.class })
public class BaseIntegrationTest {

	
	protected static Integer identificadorParaBusqueda;

	@BeforeClass
	public static void generarUsuarioPruebas() {
		
	}

	@BeforeClass
	public static void generarIdentificadorParaBusqueda() {
		identificadorParaBusqueda = Integer.valueOf(1);
	}

}
