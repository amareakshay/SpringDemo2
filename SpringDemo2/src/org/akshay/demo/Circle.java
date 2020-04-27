package org.akshay.demo;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

/*
 * @Component will register this class as a bean and will give it an id of "circle" the first letter will be lowercase
 */
@Component
public class Circle implements Shape, ApplicationEventPublisherAware {

	private Point center;
	@Autowired
	private MessageSource messageSource;
	private ApplicationEventPublisher publisher;

	
	public MessageSource getMessageSource() { return messageSource; }	
	
	public void setMessageSource(MessageSource messageSource) {
	  this.messageSource = messageSource; 
	}
	 

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
		System.out.println(this.messageSource.getMessage("drawing.circle", null, "Default Drawing Circle", null));
		System.out.println(this.messageSource.getMessage("circle.center", new Object[] {center.getX(),center.getY()}, "Default Drawing Circle", null));
		System.out.println(this.messageSource.getMessage("circleGreeting", null, "Default Circle Greetin", null));
		DrawEvent drawEvent=new DrawEvent(this);
		publisher.publishEvent(drawEvent);
	}

	/*
	 * Instead Of defining the post initialisation and pre destroy in the config
	 * xml, we can use java annotations instead
	 */
	@PostConstruct
	public void initializeCircle() {
		System.out.println("Initialising Circle ...");
	}

	@PreDestroy
	public void destroyCircle() {
		System.out.println("Destroying Circle ...");
	}

	@Override
	public void setApplicationEventPublisher(ApplicationEventPublisher publisher) {
		this.publisher=publisher;
	}

}
