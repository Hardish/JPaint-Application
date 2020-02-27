package model.shapes;

import java.awt.Point;

import model.interfaces.IShape;
import model.persistence.ApplicationState;

public class Triangle implements IShape {
	


	private Point startPoint;
	private Point endPoint;
	private ApplicationState appState;

	public Triangle(Point startPoint, Point endPoint, ApplicationState appState) {
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
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getULeftY() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getWidth() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getHeight() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean containsPoint(int x, int y) {
		int x1 = startPoint.x;
		int y1 = startPoint.y;
		int x2 = endPoint.x;
		int y2 = endPoint.y;
		int x3 = startPoint.x;
		int y3 = endPoint.y;
		
		double A = area (x1, y1, x2, y2, x3, y3);
		  double A1 = area (x, y, x2, y2, x3, y3);
	      
	       /* Calculate area of triangle PAC */ 
	        double A2 = area (x1, y1, x, y, x3, y3);
	      
	       /* Calculate area of triangle PAB */  
	        double A3 = area (x1, y1, x2, y2, x, y);
	        
	       /* Check if sum of A1, A2 and A3 is same as A */
	        return (A == A1 + A2 + A3);
		}


	double area(int x1, int y1, int x2, int y2, int x3, int y3)
	{
		return Math.abs((x1*(y2-y3) + x2*(y3-y1)+
                x3*(y1-y2))/2.0);
	}

	@Override
	public ApplicationState getAppState() {
		// TODO Auto-generated method stub
		return appState;
	}

	@Override
	public void setAppState(ApplicationState appState) {
		this.appState = appState;
		
	}
	

}
