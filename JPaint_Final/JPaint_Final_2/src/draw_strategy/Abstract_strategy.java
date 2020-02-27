package draw_strategy;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;

import color.ColorSet;
import model.persistence.ApplicationState;
import model.shapes.Point;
import view.gui.PaintCanvas;

public abstract class Abstract_strategy implements IdrawStategy
{

	protected PaintCanvas canvas;
	protected ApplicationState appState;
	protected double y1;
	protected double x2;
	protected double y2;
	protected double x1;
	
	
	public Abstract_strategy(ApplicationState appState, PaintCanvas canvas)
	{
		this.canvas = canvas;
		this.appState = appState;
	}
	
	protected abstract void abstract_draw_filledin(Graphics2D graphics2d, String fillColor, Color c, Point p1);
	protected abstract void abstract_draw_outline(Graphics2D graphics2d, String fillColor, Color c, Point p1);
	protected abstract void abstract_draw_Outline_and_filled_in(Graphics2D graphics2d, String fillColor, Color c, String outerColor, Color c1, Point p1);
	
	public final void doGraphics(double x1, double y1, double x2, double y2)
	{
		Point p1 = new Point(x1,y1,x2,y2);
		Graphics2D g =	canvas.getGraphics2D();
		
		if(appState.getActiveShapeShadingType().name().equalsIgnoreCase("Filled_in"))
		{
			String fillColor = appState.getActivePrimaryColor().name();
			Color c = ColorSet.stringToColor(fillColor);
			g.setColor(c);
			//draw method
			abstract_draw_filledin(g,fillColor,c,p1);

		}
		else if (appState.getActiveShapeShadingType().name().equalsIgnoreCase("Outline"))
		{
			
			g.setStroke(new BasicStroke(4));
			String outerColor = appState.getActiveSecondaryColor().name();
			Color c1 = ColorSet.stringToColor(outerColor);
		    g.setPaint(c1);
		    //draw method
		    abstract_draw_outline(g,outerColor,c1,p1);
	
		}
		else if (appState.getActiveShapeShadingType().name().equalsIgnoreCase("Outline_and_filled_in"))
		{
			String fillColor = appState.getActivePrimaryColor().name();
			Color c = ColorSet.stringToColor(fillColor);
		
			g.setStroke(new BasicStroke(7));
			String outerColor = appState.getActiveSecondaryColor().name();
			Color c1 = ColorSet.stringToColor(outerColor);
		    abstract_draw_Outline_and_filled_in(g,fillColor,c,outerColor,c1,p1);
	
		}
		
	}

	
	
	

}
