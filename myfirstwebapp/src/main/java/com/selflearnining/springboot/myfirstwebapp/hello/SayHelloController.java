package com.selflearnining.springboot.myfirstwebapp.hello;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class SayHelloController {
	
	@RequestMapping("say-hello")
	@ResponseBody
	public String sayHello() {
		return "Hello! What are you learning today?";
	}
	
	@RequestMapping("say-hello-html")
	@ResponseBody
	public String sayHelloHtml() {
		StringBuilder sb =  new StringBuilder();
		sb.append("<html>");
		sb.append("<head>");
		sb.append("<title>My first HTML Page</title>");
		sb.append("</head>");
		sb.append("<body>");
		sb.append("My first HTML page with body");
		sb.append("</body>");
		sb.append("</html>");
		
		return sb.toString();
	}
	
	
	// /say-hello-jsp => SayHelloController - sayHelloJSP method => return back the jsp name "sayHello"
	/* spring.mvc.view.prefix=/WEB-INF/jsp/
	//spring.mvc.view.suffix=.jsp
	@RequestMapping("say-hello-jsp")
	public String sayHelloJsp() {
		return "/WEB-INF/jsp/sayHello.jsp";
	}
	 */
	@RequestMapping("say-hello-jsp")
	public String sayHelloJsp() {
		return "sayHello";
	}


}
