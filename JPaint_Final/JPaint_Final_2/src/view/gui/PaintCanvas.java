package view.gui;

import view.interfaces.IGuiWindow;
import view.interfaces.IPaintCanvas;

import javax.swing.JComponent;


import model.interfaces.IShape;
import model.persistence.ApplicationState;


import java.awt.*;


public class PaintCanvas extends JComponent implements IPaintCanvas {

	
    public Graphics2D getGraphics2D() {	
        return (Graphics2D)getGraphics();
    }

    
	


	

	
    

}
