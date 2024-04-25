package com.selflearning.learnspringframework.examples.a4.postconstructpredestroy;

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

@Component
class SomeClass {
	private SomeDependency someDependency;

	public SomeClass(SomeDependency someDependency) {
		this.someDependency = someDependency;
		System.out.println("Dependencies are ready");
		
	}
	
	@PostConstruct //Call after Dependency injection is done
	public void initialize() {
		someDependency.getReady();
	}
	
	@PreDestroy  //When the instance is removed by the container
	public void cleanup() {
		System.out.println("Cleanup");
	}
	
	
	
}

@Component 
class SomeDependency {

	public void getReady() {
		System.out.println("Some logic using dependency");
		
	}
	
}


@Configuration
@ComponentScan
public class PrePostAnnotationsContextLauncherApplication {
	
	public static void main(String[] args) {
	
		try(var context = new AnnotationConfigApplicationContext
				(PrePostAnnotationsContextLauncherApplication.class)){
			
			//Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
			
			
			
		}


	}

}
