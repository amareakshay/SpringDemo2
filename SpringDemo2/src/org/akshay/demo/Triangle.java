package org.akshay.demo;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;


// InitializingBean tells the method of Triangle Bean needs to be called when the bean is initialized
//  afterPropertiesSet() will be called immediately after the bean is initialized
public class Triangle implements DisposableBean,InitializingBean,ApplicationContextAware,BeanNameAware {
	
	private String type;
	private Point pointA;
	private Point pointB;
	private Point pointC;
	private ApplicationContext context;
	private String beanName;
	
	public Triangle() {
		System.out.println("Initialising Triangle Bean ...");
	}
	
	public Point getPointA() {
		return pointA;
	}

	public void setPointA(Point pointA) {
		this.pointA = pointA;
	}

	public Point getPointB() {
		return pointB;
	}

	public void setPointB(Point pointB) {
		this.pointB = pointB;
	}

	public Point getPointC() {
		return pointC;
	}

	public void setPointC(Point pointC) {
		this.pointC = pointC;
	}

	public void setType(String type) {
		this.type=type;
	}
	
	public String getType() {
		return type;
	}
	
	public void draw() {
		
		System.out.println("Drawing a Traingle of Type : " + type);
		System.out.println("Point A --> (" + pointA.getX() + "," + pointA.getY() + ")");
		System.out.println("Point B --> (" + pointB.getX() + "," + pointB.getY() + ")");
		System.out.println("Point C --> (" + pointC.getX() + "," + pointC.getY() + ")");
		
	}

	@Override
	public void setApplicationContext(ApplicationContext context) throws BeansException {
		this.context = context;
		System.out.println("Passing application context to Triangle ...");
	}

	@Override
	public void setBeanName(String beanName) {
		this.beanName = beanName;
		System.out.println("Bean Name is : " + beanName);
		
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("Initializing Bean Init method called for Triangle ...");
		
	}
	
	/* Alternatively we can write our own initialization method instead of imlementins spring's interfaces
	 * and we can then in our xml mention initialization method to be called by using the param init-method=myInit()
	 * 
	 * public void myInit(){
	 * 		System.out.println("My Init Method Called ...");
	 * }
	 * 
	 * The same can be done for destroy methods as well, we can define a custom destroy method and then 
	 * add destroy-method=customDestroy() in the bean definition in xml
	 * 
	 */

	@Override
	public void destroy() throws Exception {
		System.out.println("Triangle bean is destroyed now ...");
		
	}

}
