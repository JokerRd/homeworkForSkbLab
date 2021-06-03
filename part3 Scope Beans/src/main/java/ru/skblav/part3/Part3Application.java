package ru.skblav.part3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.skblav.part3.configuration.ConfigurationApp;
import ru.skblav.part3.model.Counter;


// получение бина их контекста
@SpringBootApplication
public class Part3Application {

	public static void main(String[] args) {
		SpringApplication.run(Part3Application.class, args);
		ApplicationContext context = new AnnotationConfigApplicationContext(ConfigurationApp.class);
		Counter counter = context.getBean(Counter.class);
		System.out.println(counter.getCountHandle());
	}

}
