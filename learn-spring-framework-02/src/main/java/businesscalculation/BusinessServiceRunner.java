package businesscalculation;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan
public class BusinessServiceRunner {

	public static void main(String[] args) {
		
		try(var context = new AnnotationConfigApplicationContext(BusinessServiceRunner.class)){
			System.out.println(context.getBean(BusinessCalculationService.class).findMax());
			
		}

	}

}
