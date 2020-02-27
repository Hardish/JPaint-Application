package model.commands;

import java.awt.Point;
import java.util.ArrayList;
import java.util.LinkedList;


import arraylistshape.Linklist;
import draw_strategy.Ellipse_Strategy;
import draw_strategy.RECTANGLE_Strategy;
import draw_strategy.Traingle_Strategy;
import model.ShapeType;
import model.interfaces.IShape;
import model.persistence.ApplicationState;
import model.shapes.Rectangle;
import model.shapes.ShapeFactory;

import view.gui.PaintCanvas;

public class DrawShapeCommand implements ICommand {

	private final Point startPoint;
	private final Point endPoint;
	private ApplicationState appState;
	private IShape shape;	
	private PaintCanvas canvas;
	private int size;
	private Linklist<IShape> myShapes;
	private Linklist<IShape> clearedShapes;
	
	public DrawShapeCommand(Point startPoint, Point endPoint, ApplicationState appState, PaintCanvas canvas, Linklist<IShape> myShapes, Linklist<IShape> clearedShapes) {
		this.startPoint = startPoint;
		this.endPoint = endPoint;
		this.appState = appState;
		this.canvas = canvas;
		this.myShapes = myShapes;
		this.clearedShapes = clearedShapes;
	}

	@Override
	public void run() {
		ShapeFactory sf = new ShapeFactory(startPoint, endPoint, appState);
		shape = sf.createShape(startPoint, endPoint, appState);
		
		myShapes.addFront(shape); 	
			

	
		shape = null;
		   size  =	myShapes.size();
		   
		   if(size >= 1)
		      {		
			   DrawingListner drawlistner = new DrawingListner(startPoint, endPoint, appState, canvas, clearedShapes, clearedShapes);
			   drawlistner.update();
		    	 			   
		      }
	  
	}

	
	



}
