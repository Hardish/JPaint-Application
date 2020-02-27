package model.shapes;


import java.awt.Point;

import model.interfaces.IShape;
import model.persistence.ApplicationState;


public class Rectangle implements IShape {
	


	private Point startPoint;
	private Point endPoint;
	private ApplicationState appState;

	public Rectangle(Point startPoint, Point endPoint, ApplicationState appState) {
		this.startPoint = startPoint;
		this.endPoint =endPoint;
		this.setAppState(appState);
		
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
			if (x >= getULeftX() && x < getULeftX()+getWidth() && y >= getULeftY() && y < getULeftY()+getHeight())
            return true;
	        else
	            return false;

		}





		public ApplicationState getAppState() {
			return appState;
		}





		public void setAppState(ApplicationState appState) {
			this.appState = appState;
		}





		









	    
	    

	  
	   
}