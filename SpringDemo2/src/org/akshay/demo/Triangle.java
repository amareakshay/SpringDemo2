package org.akshay.demo;

public class Triangle implements Shape {
	
	private String type;
	private Point pointA;
	private Point pointB;
	private Point pointC;
	
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
	
	@Override
	public void draw() {
		
		System.out.println("Drawing a Traingle of Type : " + type);
		System.out.println("Point A --> (" + pointA.getX() + "," + pointA.getY() + ")");
		System.out.println("Point B --> (" + pointB.getX() + "," + pointB.getY() + ")");
		System.out.println("Point C --> (" + pointC.getX() + "," + pointC.getY() + ")");
		
	}

}
