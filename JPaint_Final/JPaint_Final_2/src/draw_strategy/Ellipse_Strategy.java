package draw_strategy;



import java.awt.Color;
import java.awt.Graphics2D;

import model.persistence.ApplicationState;
import model.shapes.Point;
import view.gui.PaintCanvas;

public class Ellipse_Strategy  extends Abstract_strategy
{
	public Ellipse_Strategy(ApplicationState appState, PaintCanvas canvas)
	{
		super(appState, canvas);
		
	}
	
	public void abstract_draw_filledin(Graphics2D graphics2d, String fillColor, Color c, Point p1) {
		graphics2d.fillOval(p1.getULeftX(), p1.getULeftY(), p1.getWidth(), p1.getHeight());
		
	}

	public void abstract_draw_outline(Graphics2D graphics2d, String fillColor, Color c, Point p1) {
		graphics2d.drawOval(p1.getULeftX(), p1.getULeftY(), p1.getWidth(), p1.getHeight());
		
	}


	public void abstract_draw_Outline_and_filled_in(Graphics2D graphics2d, String fillColor, Color c, String outerColor,
			Color c1, Point p1) {
		 graphics2d.setColor(c);
		 graphics2d.fillOval(p1.getULeftX(), p1.getULeftY(), p1.getWidth(), p1.getHeight());
		 graphics2d.setPaint(c1);
		 graphics2d.drawOval(p1.getULeftX(), p1.getULeftY(), p1.getWidth(), p1.getHeight());
	}























































	
	
	
	
	
	
	
	
	

}
