package com.pruebas.common;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;



@ContextConfiguration(locations = {"classpath:appSpring/spring-appMock.xml", "classpath:spring/spring-gestor-documental-util.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
@TestExecutionListeners({
    org.springframework.test.context.support.DependencyInjectionTestExecutionListener.class,
    org.springframework.test.context.support.DirtiesContextTestExecutionListener.class,    
    com.pruebas.common.LoggingTestExecutionListener.class
})
public abstract class BaseErrorIntegrationTest {
	

}
