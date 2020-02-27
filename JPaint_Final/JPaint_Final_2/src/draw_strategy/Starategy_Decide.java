package draw_strategy;



import java.awt.event.MouseEvent;

import arraylistshape.Linklist;
import model.commands.DrawShapeCommand;
import model.commands.MoveShapeCommand;
import model.commands.SelectShapeCommand;
import model.interfaces.IShape;
import model.persistence.ApplicationState;
import view.gui.PaintCanvas;

public class Starategy_Decide
{
 	private PaintCanvas canvas;
	private ApplicationState appState;


	java.awt.Point startPoint;
	java.awt.Point endPoint;
	private Linklist<IShape> myShapes;
	private Linklist<IShape> clearedShapes;
	private DrawShapeCommand dc;
	private MouseEvent e;
	private SelectShapeCommand dc1;
	
	public Starategy_Decide(ApplicationState appState, java.awt.Point startPoint, java.awt.Point endPoint,PaintCanvas canvas, Linklist<IShape> myShapes, Linklist<IShape> clearedShapes, MouseEvent e) {
		 this.appState = appState;
		 this.startPoint = startPoint;
		 this.endPoint = endPoint;
		 this.canvas = canvas;
		 this.myShapes =myShapes;
		 this.clearedShapes = clearedShapes;
		 this.e = e;
	}

	public void executeShapDraw()
	{
		if (appState.getActiveStartAndEndPointMode().name().equalsIgnoreCase("Draw"))
		{
		   DrawShapeCommand dc = new DrawShapeCommand(startPoint, endPoint, appState,canvas,myShapes,clearedShapes);
		   dc.run();
		}
		else if (appState.getActiveStartAndEndPointMode().name().equalsIgnoreCase("select"))
		{
			SelectShapeCommand dc1 = new SelectShapeCommand(startPoint, endPoint, appState,canvas,myShapes,clearedShapes,e);
			dc1.run();
		}
		else if(appState.getActiveStartAndEndPointMode().name().equalsIgnoreCase("Move"))
		{
			MoveShapeCommand mv1 = new MoveShapeCommand(startPoint, endPoint, appState,canvas,myShapes,clearedShapes,e);
			mv1.run();
		}
	}
}
		 
