package model.commands;

import java.awt.Point;
import java.awt.event.MouseEvent;

import arraylistshape.Linklist;
import model.interfaces.IShape;
import model.persistence.ApplicationState;
import view.gui.PaintCanvas;

public class MoveShapeCommand implements ICommand{

	private Point startPoint;
	private Point endPoint;
	private ApplicationState appState;
	private PaintCanvas canvas;
	private Linklist<IShape> myShapes;
	private Linklist<IShape> clearedShapes;



	public MoveShapeCommand(Point startPoint, Point endPoint, ApplicationState appState, PaintCanvas canvas,
			Linklist<IShape> myShapes, Linklist<IShape> clearedShapes,MouseEvent e) {
		this.startPoint = startPoint;
		this.endPoint = endPoint;
		this.appState = appState;
		this.canvas = canvas;
		this.myShapes = myShapes;
		this.clearedShapes = clearedShapes;
	}



	@Override
	public void run() 
	{
//		System.out.println(startPoint);
//		System.out.println(endPoint);
		
		
	}

}
