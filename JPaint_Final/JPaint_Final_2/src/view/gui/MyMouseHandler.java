package view.gui;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import arraylistshape.Linklist;
import draw_strategy.Starategy_Decide;
import model.interfaces.IShape;
import model.persistence.ApplicationState;
import view.interfaces.IGuiWindow;
public class MyMouseHandler extends MouseAdapter implements MouseListener {
	
	private IGuiWindow guiWindow;
	private PaintCanvas canvas;
	private ApplicationState appState;	
	java.awt.Point startPoint;
	java.awt.Point endPoint;
    private Linklist<IShape> myShapes;
    private Linklist<IShape> clearedShapes;  
 
    private IShape currentShapeObject;
	private IShape shapeBeingDragged = null;
	private int prevDragX;
	private int prevDragY;

		
 public MyMouseHandler(IGuiWindow guiWindow, PaintCanvas canvas, ApplicationState appState)
 {
	 this.guiWindow = guiWindow;
     this.canvas = canvas;
     this.appState = appState;
     myShapes = new Linklist<IShape>(); //initialize myShapes dynamic stack
     clearedShapes = new Linklist<IShape>(); //initialize clearedShapes dynamic stack
     currentShapeObject=null;
     
 }

@Override
 public void mousePressed(MouseEvent e) 
{
	 startPoint = e.getPoint();
//	 prevDragX = (int) startPoint.getX();
//     prevDragY = (int) startPoint.getY();
}
     
 
 
 @Override
 public void mouseReleased(MouseEvent e)
 {
	 endPoint = e.getPoint();


	 if (appState.getActiveStartAndEndPointMode().name().equalsIgnoreCase("Draw"))
	 {
	 Starategy_Decide idraw = new Starategy_Decide(appState,startPoint,endPoint, canvas,myShapes,clearedShapes, e);
	 idraw.executeShapDraw();
	 }
	 
//	 else if (appState.getActiveStartAndEndPointMode().name().equalsIgnoreCase("Move"))
//	 {
//	  int x = e.getX();
//      int y = e.getY();
//      if (shapeBeingDragged != null) {
//          shapeBeingDragged.moveBy(x - prevDragX, y - prevDragY);
//          shapeBeingDragged = null;
//          canvas.getGraphics2D().drawRect(prevDragX,prevDragY,shapeBeingDragged.getWidth(),shapeBeingDragged.getHeight()); 
//      }
//	 }
	 
	 
 }
 
 

     public void mouseClicked(MouseEvent e) 
     {
    	 if(appState.getActiveStartAndEndPointMode().name().equalsIgnoreCase("Select"));
    	 {
    		    		 
    		 Starategy_Decide idraw = new Starategy_Decide(appState,startPoint,endPoint, canvas,myShapes,clearedShapes,e);
    		 idraw.executeShapDraw();
    		 
    	 }
    	 
    	
    	 

     }
     
     
     public void mouseDragged(MouseEvent e)
     {
    	 if(appState.getActiveStartAndEndPointMode().name().equalsIgnoreCase("Move"))
    	 {
    		 Starategy_Decide idraw = new Starategy_Decide(appState,startPoint,endPoint, canvas,myShapes,clearedShapes,e);
    		 idraw.executeShapDraw();
    	 }
//    	 {
//    		 int x = e.getX();
//             int y = e.getY();
//             if (shapeBeingDragged != null) 
//             {
//
//				 shapeBeingDragged.moveBy(x - prevDragX, y - prevDragY);
//                 prevDragX = x;
//                 prevDragY = y;
//                 canvas.getGraphics2D().drawRect(prevDragX,prevDragY,shapeBeingDragged.getWidth(),shapeBeingDragged.getHeight());  
//             }
//    	 }
//    	 
//    	 else if(appState.getActiveStartAndEndPointMode().name().equalsIgnoreCase("Draw"))
//    	 {
//    		 canvas.getGraphics2D().drawRect(100,100,500,500); 
//    	 }
   }
     

}
 