package model.commands;

import java.awt.Point;

import arraylistshape.Linklist;
import draw_strategy.Ellipse_Strategy;
import draw_strategy.RECTANGLE_Strategy;
import draw_strategy.Traingle_Strategy;
import draw_strategy.Ellipse_Strategy;
import model.interfaces.IShape;
import model.persistence.ApplicationState;
import view.gui.PaintCanvas;

public class DrawingListner 
{
	private Point startPoint;
	private Point endPoint;
	private ApplicationState appState;
	private PaintCanvas canvas;
	private Linklist<IShape> myShapes;
	private Linklist<IShape> clearedShapes;

	public DrawingListner(Point startPoint, Point endPoint, ApplicationState appState, PaintCanvas canvas, Linklist<IShape> myShapes, Linklist<IShape> clearedShapes)
	{	
		this.startPoint = startPoint;
		this.endPoint = endPoint;
		this.appState = appState;
		this.canvas = canvas;
		this.myShapes = myShapes;
		this.clearedShapes = clearedShapes;
	
	}
	
	public void update() 
	{
		if(appState.getActiveShapeType().name().equalsIgnoreCase("RECTANGLE"))
		{
			
			RECTANGLE_Strategy rect = new RECTANGLE_Strategy(appState,canvas);
			rect.doGraphics(startPoint.getX(),startPoint.getY(), endPoint.getX(),endPoint.getY());
		}
		if(appState.getActiveShapeType().name().equalsIgnoreCase("ELLIPSE"))
		 {

			Ellipse_Strategy ellipse = new Ellipse_Strategy(appState,canvas);
			ellipse.doGraphics(startPoint.getX(),startPoint.getY(), endPoint.getX(),endPoint.getY());
			
			
		 }
		 
		 if(appState.getActiveShapeType().name().equalsIgnoreCase("TRIANGLE"))
		 {

			 Traingle_Strategy traingle = new Traingle_Strategy(appState,canvas);
			 traingle.doGraphics(startPoint.getX(),startPoint.getY(), endPoint.getX(),endPoint.getY());
		 }
	}
}
