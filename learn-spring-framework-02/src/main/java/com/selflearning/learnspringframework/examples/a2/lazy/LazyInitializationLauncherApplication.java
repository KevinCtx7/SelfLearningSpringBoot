package com.selflearning.learnspringframework.examples.a2.lazy;

import java.util.Arrays;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import com.selflearning.learnspringframework.game.GameRunner;
import com.selflearning.learnspringframework.game.GamingConsole;

@Component
class ClassA{
	
}

@Component
@Lazy //Intialization is not happened when spring context is startup
//It will be happened when it is used
//Eager -> when spring context startup
class ClassB{
	private ClassA  classA;

	public ClassB(ClassA classA) {
		System.out.println("Im intializing");
		this.classA = classA;
	}
	
	public void doSomething() {
		System.out.println("Im doing something");
	}
	
	
	
}



@ComponentScan
public class LazyInitializationLauncherApplication {
	
	public static void main(String[] args) {
	
		try(var context = new AnnotationConfigApplicationContext
				(LazyInitializationLauncherApplication.class)){
			System.out.println("Context Initiliazation");

			
			
			
		context.getBean(ClassB.class).doSomething();
			
		}


	}

}
