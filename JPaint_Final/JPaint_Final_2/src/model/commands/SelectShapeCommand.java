package model.commands;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Stroke;
import java.awt.event.InputEvent;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import arraylistshape.Linklist;
import arraylistshape.ShapeList;
import color.ColorSet;
import model.interfaces.IShape;
import model.persistence.ApplicationState;
import model.shapes.Ellipse;
import model.shapes.Rectangle;
import model.shapes.Triangle;
import view.gui.PaintCanvas;

public class SelectShapeCommand implements ICommand {
	private  Point startPoint;
	private  Point endPoint;
	private ApplicationState appState;
	private IShape shape;	
	private IShape final_shape;
	private PaintCanvas canvas;
	private int a;
	private Linklist<IShape> myShapes;
	private Linklist<IShape> clearedShapes;

	private ShapeList selected_shape;
	private MouseEvent e;
	
	public SelectShapeCommand(Point startPoint, Point endPoint, ApplicationState appState, PaintCanvas canvas,
		Linklist<IShape> myShapes, Linklist<IShape> clearedShapes,MouseEvent e) {
		this.startPoint = startPoint;
		this.endPoint = endPoint;
		this.appState = appState;
		this.canvas = canvas;
		this.myShapes = myShapes;
		this.clearedShapes = clearedShapes;
	
		this.e = e;
	}

	@Override
	public void run() {
		// we need to go throw all the members present in current selectio of mouse screen
		
		if(startPoint != null || endPoint != null && startPoint.equals(endPoint))
		{
			Graphics2D g = canvas.getGraphics2D();
		    Stroke dashed = new BasicStroke(3, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 0, new float[]{9}, 0);
	        g.setStroke(dashed);


				ArrayList<IShape> shapeArray = myShapes.getArray();
		        for ( int counter=shapeArray.size()-1; counter>=0; counter-- )
		        {
		       
		        	if(shapeArray.get(counter) instanceof Rectangle)
		        	{
		        		
		        		if(shapeArray.get(counter).containsPoint(startPoint.x, endPoint.y))
		        			{
			        		g.drawRect(shapeArray.get(counter).getULeftX(), shapeArray.get(counter).getULeftY(), shapeArray.get(counter).getWidth(), shapeArray.get(counter).getHeight());
			        		selected_shape = new ShapeList(shapeArray.get(counter));
			        		selected_shape.addShape(shapeArray.get(counter));
		
			        		
			        		// to change the color by right click
			        		 if ((e.getModifiers() & InputEvent.BUTTON3_MASK) != 0)
			        		 {
			        			if(shapeArray.get(counter).getAppState().getActiveShapeShadingType().name().equalsIgnoreCase("Outline_and_filled_in"))
			        			 //if(appState.getActiveShapeShadingType().name().equalsIgnoreCase("Outline_and_filled_in"))
			        				{
			        					String fillColor = appState.getActiveSecondaryColor().name();
			        					Color c = ColorSet.stringToColor(fillColor);
			        					g.setColor(c);
			        					g.fillRect(shapeArray.get(counter).getULeftX(), shapeArray.get(counter).getULeftY(), shapeArray.get(counter).getWidth(), shapeArray.get(counter).getHeight());
			        				
			        					g.setStroke(new BasicStroke(4));
			        					String outerColor = appState.getActivePrimaryColor().name();
			        					Color c21 = ColorSet.stringToColor(outerColor);
			        				    g.setPaint(c21);
			        					g.drawRect(shapeArray.get(counter).getULeftX(), shapeArray.get(counter).getULeftY(), shapeArray.get(counter).getWidth(), shapeArray.get(counter).getHeight());
			        				    break;
			        				}
			            		
			        		 }
			        		 
			        		 
		        	}
		        		

		        		
		        }
		        	
		        	if(shapeArray.get(counter) instanceof Ellipse)
		        	{
		        		if(shapeArray.get(counter).containsPoint(startPoint.x, endPoint.y))
		        		{
	        		        g.drawOval(shapeArray.get(counter).getULeftX(), shapeArray.get(counter).getULeftY(), shapeArray.get(counter).getWidth(), shapeArray.get(counter).getHeight());
	        		    	selected_shape = new ShapeList(shapeArray.get(counter));
			        		selected_shape.addShape(shapeArray.get(counter));
			        		
			        		 if ((e.getModifiers() & InputEvent.BUTTON3_MASK) != 0)
			        		 {
			        			 if(appState.getActiveShapeShadingType().name().equalsIgnoreCase("Outline_and_filled_in"))
			        			 {
			        			    String fillColor = appState.getActiveSecondaryColor().name();
			        				Color c = ColorSet.stringToColor(fillColor);
			        				g.setColor(c);
			        				g.fillOval(shapeArray.get(counter).getULeftX(), shapeArray.get(counter).getULeftY(), shapeArray.get(counter).getWidth(), shapeArray.get(counter).getHeight());
			        				g.setStroke(new BasicStroke(4));
			        				String outerColor = appState.getActivePrimaryColor().name();
			        				Color c1 = ColorSet.stringToColor(outerColor);
			        			    g.setPaint(c1);
			        				g.drawOval(shapeArray.get(counter).getULeftX(), shapeArray.get(counter).getULeftY(), shapeArray.get(counter).getWidth(), shapeArray.get(counter).getHeight());
			        		 }
			        		 }
		        		}
	        		
		        	}
		        	if(shapeArray.get(counter) instanceof Triangle)
		        	{
		        		if(shapeArray.get(counter).containsPoint(startPoint.x, endPoint.y))
		        		{
		        			
		        			   g.drawPolygon(new int [] {(int) shapeArray.get(counter).getStartPoint().x,
		        						(int) shapeArray.get(counter).getendPoint().x,
		        						(int) shapeArray.get(counter).getStartPoint().x},
		        						new int [] {(int) shapeArray.get(counter).getStartPoint().y,
		        								(int) shapeArray.get(counter).getendPoint().y,
		        								(int) shapeArray.get(counter).getendPoint().y},3);
	        		    	selected_shape = new ShapeList(shapeArray.get(counter));
			        		selected_shape.addShape(shapeArray.get(counter));
			        		
			        		 if ((e.getModifiers() & InputEvent.BUTTON3_MASK) != 0)
			        		 {
			        			 if(appState.getActiveShapeShadingType().name().equalsIgnoreCase("Outline_and_filled_in"))
			        			 {
			        			    String fillColor = appState.getActiveSecondaryColor().name();
			        				Color c = ColorSet.stringToColor(fillColor);
			        				g.setColor(c);

			        				
			        				g.fillPolygon(new int [] {(int) shapeArray.get(counter).getStartPoint().x,
			        						(int) shapeArray.get(counter).getendPoint().x,
			        						(int) shapeArray.get(counter).getStartPoint().x},
			        						new int [] {(int) shapeArray.get(counter).getStartPoint().y,
			        								(int) shapeArray.get(counter).getendPoint().y,
			        								(int) shapeArray.get(counter).getendPoint().y},3);
			        			
			        				g.setStroke(new BasicStroke(4));
			        				String outerColor = appState.getActivePrimaryColor().name();
			        				Color c1 = ColorSet.stringToColor(outerColor);
			        			    g.setPaint(c1);
			        			    g.drawPolygon(new int [] {(int) shapeArray.get(counter).getStartPoint().x,
			        						(int) shapeArray.get(counter).getendPoint().x,
			        						(int) shapeArray.get(counter).getStartPoint().x},
			        						new int [] {(int) shapeArray.get(counter).getStartPoint().y,
			        								(int) shapeArray.get(counter).getendPoint().y,
			        								(int) shapeArray.get(counter).getendPoint().y},3);
			        		 }
			        		 }
		        		}
		        		else
		        		{
		        			//we are not clicking on shapes, hence it should not do anything but
		        			// due to some code error we can change the state of primary and 
		        			// secondary color 
		        		}
		        	}
		        	
		        	
		        }

				
  		
		}
		
		

		

	}

}
