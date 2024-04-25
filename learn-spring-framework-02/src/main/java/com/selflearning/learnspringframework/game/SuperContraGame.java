package com.selflearning.learnspringframework.game;


import org.springframework.stereotype.Component;

@Component
public class SuperContraGame implements GamingConsole{
	public void up() {
		System.out.println("Jump");
	}
	
	public void down() {
		System.out.println("Sit Down");
	}
	
	public void left() {
		System.out.println("Shoot");
	}
	
	public void right() {
		System.out.println("Foward");
	}

}
