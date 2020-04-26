package org.akshay.demo;


import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;


public class DrawingApplication {

	public static void main(String[] args) {
		//BeanFactory factory = new XmlBeanFactory(new ClassPathResource("spring.xml"));
		/*
		 * When using class path application context the spring.xml needs to be in class path
		 * Hence We need to move it to the classpath in the src folder
		 */
		/*ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		 * Using  Abstract Application Context here so that we can register a shut down hook
		 * which will tell the application context to should down when the main method has been terminated
		 * 
		 * In we applications the context knows when to should down, however in desktop applications like this 
		 * We must explicitly shut down the application context
		*/
		AbstractApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		// Now register shutdown hook
		context.registerShutdownHook();
		System.out.println("Getting the Shape Bean in the Main Application now");
		//Triangle triangle = (Triangle) factory.getBean("triangle");
		
		Shape shape = (Shape) context.getBean("circle");
		
		shape.draw();

	}

}
