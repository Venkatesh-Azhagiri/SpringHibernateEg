package com.spring.dependency.injection;

public class Drawing {
	public Shape shape;
	
	public Drawing(Shape shape){
		this.shape = shape;
	}
	
	public void drawTheShape(){
		shape.draw();
	}

}
