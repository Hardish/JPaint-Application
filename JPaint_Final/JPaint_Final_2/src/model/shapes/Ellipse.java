package model.shapes;

import java.awt.Point;

import model.interfaces.IShape;
import model.persistence.ApplicationState;

public class Ellipse implements IShape {

	private Point startPoint;
	private Point endPoint;
	private ApplicationState appState;

	public Ellipse(Point startPoint, Point endPoint, ApplicationState appState) {
		this.startPoint = startPoint;
		this.endPoint =endPoint;
		this.appState = appState;
	}

	public Point getStartPoint() {
        return startPoint;
    }

    public void SetstartPoint(Point startPoint) {
        this.startPoint = startPoint;
    }

    
    public Point getendPoint() {
        return endPoint;
    }

    public void setendPoint(Point endPoint) {
        this.endPoint = endPoint;
    }

	@Override
	public int getULeftX() {
		return (int) Math.min(startPoint.getX(),endPoint.getX());
	}

	@Override
	public int getULeftY() {
		return (int) Math.min(startPoint.getY(),endPoint.getY());
	}

	@Override
	public int getWidth() {
		 return (int) Math.abs(startPoint.getX()-endPoint.getX());
	}

	@Override
	public int getHeight() {
		return (int) Math.abs(startPoint.getY()-endPoint.getY());
	}

	@Override
	public boolean containsPoint(int x, int y) {
		 double rx = getWidth()/2.0;   // horizontal radius of ellipse
         double ry = getHeight()/2.0;  // vertical radius of ellipse 
         double cx = getULeftX() + rx;   // x-coord of center of ellipse
         double cy = getULeftY() + ry;    // y-coord of center of ellipse
         if ( (ry*(x-cx))*(ry*(x-cx)) + (rx*(y-cy))*(rx*(y-cy)) <= rx*rx*ry*ry )
             return true;
         else
             return false;
     }

	@Override
	public ApplicationState getAppState() {
		
		return appState;
	}

	@Override
	public void setAppState(ApplicationState appState) {
		this.appState = appState;
		
	}
	}

	


	


