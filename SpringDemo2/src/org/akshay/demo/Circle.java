package org.akshay.demo;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/*
 * @Component will register this class as a bean and will give it an id of "circle" the first letter will be lowercase
 */
@Component
public class Circle implements Shape {
	
	private Point center; 

	public Point getCenter() {
		return center;
	}
	
	@Autowired
	@Qualifier("circleRelated")
	public void setCenter(Point center) {
		this.center = center;
	}

	@Override
	public void draw() {
		System.out.println("Drawing a Circle");
		System.out.println("Center is : (" + center.getX() +"," + center.getY() + ")");
	}

	/*
	 * Instead Of defining the post initialisation and pre destroy in the config xml, we can use java annotations instead 
	 */
	@PostConstruct
	public void initializeCircle() {
		System.out.println("Initialising Circle ...");
	}
	
	@PreDestroy
	public void destroyCircle() {
		System.out.println("Destroying Circle ...");
	}
	
}
