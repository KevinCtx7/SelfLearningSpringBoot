package com.selflearning.learnspringframework.examples.a3.prototypevssingleton;

import java.util.Arrays;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.selflearning.learnspringframework.game.GameRunner;
import com.selflearning.learnspringframework.game.GamingConsole;

//It will always get the same instances, Singleton
//Default is singleton
@Component
class NormalClass {
	
}


//It will always create a new Bean
@Scope(value=ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@Component
class PrototypeClass {
	
}

@ComponentScan
public class BeanScopeInitializationLauncherApplication {
	
	public static void main(String[] args) {
	
		try(var context = new AnnotationConfigApplicationContext
				(BeanScopeInitializationLauncherApplication.class)){
			
			System.out.println(context.getBean(NormalClass.class));
			System.out.println(context.getBean(NormalClass.class));
			
			System.out.println(context.getBean(PrototypeClass.class));
			System.out.println(context.getBean(PrototypeClass.class));
			System.out.println(context.getBean(PrototypeClass.class));
			
	
			
		}


	}

}
