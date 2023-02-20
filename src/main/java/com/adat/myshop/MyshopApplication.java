package com.adat.myshop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//Anotación que autoconfigura nuestra aplicación (según application.properties)
@SpringBootApplication
public class MyshopApplication {

	public static void main(String[] args) {
		//Comienza a ejecutar Spring, el servidor de Tomcat y tras eso
		//nuestra aplicación.
		SpringApplication.run(MyshopApplication.class, args);
	}

}
