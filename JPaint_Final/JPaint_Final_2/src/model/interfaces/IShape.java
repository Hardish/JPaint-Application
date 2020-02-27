package model.interfaces;

import java.awt.Point;

import model.persistence.ApplicationState;

public interface IShape {

    	public Point getStartPoint();

	    public void SetstartPoint(Point startPoint);
	    
	    public Point getendPoint();

	    public void setendPoint(Point endPoint);
	    
	    public ApplicationState getAppState() ;





		public void setAppState(ApplicationState appState) ;
	    
		public int getULeftX();
	    

	    public int getULeftY();
	  
	    

	    public int getWidth();
	   

	    public int getHeight();

	    boolean containsPoint(int x, int y);




}
