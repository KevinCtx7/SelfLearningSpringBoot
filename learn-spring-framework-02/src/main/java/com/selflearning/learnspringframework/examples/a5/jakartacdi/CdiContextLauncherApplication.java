package com.selflearning.learnspringframework.examples.a5.jakartacdi;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import com.selflearning.learnspringframework.game.GameRunner;
import com.selflearning.learnspringframework.game.GamingConsole;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import jakarta.inject.Inject;
import jakarta.inject.Named;

//@Component
@Named
class BusinessService {
	private DataService dataService;



	public DataService getDataService() {
		return dataService;
	}

	//@Autowired
	@Inject
	public void setDataService(DataService dataService) {
		System.out.println("Setter Injection");

		this.dataService = dataService;
	}




	
}

//@Component
@Named
class DataService {
	
}

@Configuration
@ComponentScan
public class CdiContextLauncherApplication {
	
	public static void main(String[] args) {
	
		try(var context = new AnnotationConfigApplicationContext
				(CdiContextLauncherApplication.class)){
			
			System.out.println(context.getBean(BusinessService.class));
			
			
			
		}


	}

}
