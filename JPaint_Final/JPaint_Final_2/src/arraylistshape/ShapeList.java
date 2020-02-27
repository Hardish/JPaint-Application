package arraylistshape;




import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;

import model.interfaces.IShape;



public class ShapeList
{
	private List<IShape> shapes;
	
	public ShapeList(IShape iShape) {
		this.shapes = new ArrayList<IShape>();
	}
	
	public boolean isEmpty() {
		return shapes.isEmpty();
	}
	
	public void addShape(IShape s) {
		if (s == null)
			throw new IllegalArgumentException();
		
		shapes.add(s);
	}
	
	public List<IShape> GetShapeArrayList() {
		return shapes;
	}
	
	public IShape removeShape() {
		if (shapes.isEmpty())
			throw new EmptyStackException();
		return shapes.remove(shapes.size()-1);
	}
}
