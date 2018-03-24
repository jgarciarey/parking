package com.pruebas.common;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.TestContext;
import org.springframework.test.context.support.AbstractTestExecutionListener;

// TODO: Auto-generated Javadoc
/**
 * 
 * <PRE>
 * Nombre de la clase: LoggingTestExecutionListener
 * Código de proyecto: archetype-model
 * Descripción:
 *  Listener para incluir informacion sobre inicio y fin de tests.
 *
 * Fecha de creación: 26/04/2012
 * </PRE>
 * @author joseff
 */
public class LoggingTestExecutionListener extends AbstractTestExecutionListener {
    
    /** The log. */
    private static Logger log = LoggerFactory.getLogger(LoggingTestExecutionListener.class);

    /**
     * sentencias a ejecutar despues del metodo.
     *
     * @param testContext contexto
     */
    @Override
    public void afterTestMethod(TestContext testContext) {        
        
        if (log.isDebugEnabled()) {
            log.debug("Fin metodo test: " + testContext.getTestMethod().getName());
        }
    }

    /**
     * sentencias a ejecutar antes del metodo.
     *
     * @param testContext contexto
     */
    @Override
    public void beforeTestMethod(TestContext testContext){
       
        if (log.isDebugEnabled()) {
            log.debug("Inicio metodo test: " + testContext.getTestMethod().getName());
        }
    }
    
}