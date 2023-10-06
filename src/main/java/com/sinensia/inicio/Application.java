package com.sinensia.inicio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * Nuestra clase de confguracion
 * 
 * @author Sergio
 * @see com.sinensia.controller.CursoController
 * @see com.sinensia.controller.InscripcionController
 * @see com.sinensia.service.CursoService
 * @see com.sinensia.service.CursoServiceImpl
 * @see com.sinensia.service.InscripcionService
 * @see com.sinensia.service.InscripcionServiceImpl
 */
@SpringBootApplication(scanBasePackages = { "com.sinensia.controller", "com.sinensia.service" })
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	/**
	 * Creamos nuestro RestTemplate con la anotacion @Bean para poder inyectarlo en
	 * otras partes de la aplicacion
	 * 
	 * @return
	 */
	@Bean
	public RestTemplate template() {
		return new RestTemplate();
	}

}
