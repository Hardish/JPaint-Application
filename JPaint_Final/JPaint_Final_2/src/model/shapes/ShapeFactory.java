package model.shapes;



import java.awt.Point;

import model.interfaces.IShape;
import model.persistence.ApplicationState;

public class ShapeFactory {

	private final Point startPoint;
	private final Point endPoint;
	private ApplicationState appState;

	public ShapeFactory(Point startPoint, Point endPoint, ApplicationState appState) {
		this.startPoint = startPoint;
		this.endPoint = endPoint;
		this.appState = appState;
	}
	
	public IShape createShape(Point startPoint, Point endPoint, ApplicationState appState) {
		IShape shape = null;

		if (appState.getActiveShapeType().name().equalsIgnoreCase("ELLIPSE")) {
			shape = new Ellipse(startPoint,endPoint,appState);
		}
		
		if (appState.getActiveShapeType().name().equalsIgnoreCase("RECTANGLE")) {
			shape = new Rectangle(startPoint,endPoint,appState);
		}
		
		if (appState.getActiveShapeType().name().equalsIgnoreCase("TRIANGLE")) {
			shape = new Triangle(startPoint,endPoint,appState);
		}		
		
		return shape;

	}

	}
