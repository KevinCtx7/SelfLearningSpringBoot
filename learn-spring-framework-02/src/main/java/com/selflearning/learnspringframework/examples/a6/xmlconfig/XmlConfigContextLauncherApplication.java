package com.selflearning.learnspringframework.examples.a6.xmlconfig;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.selflearning.learnspringframework.game.GameRunner;
import com.selflearning.learnspringframework.game.GamingConsole;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import jakarta.inject.Inject;
import jakarta.inject.Named;


public class XmlConfigContextLauncherApplication {
	
	public static void main(String[] args) {
	
		try(var context = new ClassPathXmlApplicationContext("contextConfiguration.xml")){
			
		
		 Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
		 
		 context.getBean(GameRunner.class).run();
			
			
		}


	}

}
