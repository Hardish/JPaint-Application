package draw_strategy;

import java.awt.Color;
import java.awt.Graphics2D;

import model.persistence.ApplicationState;
import model.shapes.Point;
import view.gui.PaintCanvas;

public class Traingle_Strategy extends Abstract_strategy {

	public Traingle_Strategy(ApplicationState appState, PaintCanvas canvas)
	{
		super(appState, canvas);
		
	}
    @Override
	public void abstract_draw_filledin(Graphics2D graphics2d, String fillColor, Color c, Point p1) {
		graphics2d.fillPolygon(new int [] {(int) p1.getX1(),(int) p1.getX2(),(int) p1.getX1()},new int [] {(int) p1.getY1(),(int) p1.getY2(),(int) p1.getY2()},3);
		
	}

	@Override
	public void abstract_draw_outline(Graphics2D graphics2d, String fillColor, Color c, Point p1) {
	
		graphics2d.drawPolygon(new int [] {(int) p1.getX1(),(int) p1.getX2(),(int) p1.getX1()},new int [] {(int) p1.getY1(),(int) p1.getY2(),(int) p1.getY2()},3);
	}

	@Override
	public void abstract_draw_Outline_and_filled_in(Graphics2D graphics2d, String fillColor, Color c, String outerColor,
			Color c1, Point p1) {
		 graphics2d.setColor(c);
		 graphics2d.fillPolygon(new int [] {(int) p1.getX1(),(int) p1.getX2(),(int) p1.getX1()},new int [] {(int) p1.getY1(),(int) p1.getY2(),(int) p1.getY2()},3);
		 graphics2d.setPaint(c1);
		 graphics2d.drawPolygon(new int [] {(int) p1.getX1(),(int) p1.getX2(),(int) p1.getX1()},new int [] {(int) p1.getY1(),(int) p1.getY2(),(int) p1.getY2()},3);
		
	}




}
