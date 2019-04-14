package shapes;

public class Cylinder extends Circle implements ThreeD {
	private double depth;
	
	public Cylinder() {
		this(Shape.DEFAULT_SIZE, Shape.DEFAULT_SIZE);
	}
	
	public Cylinder(double theRadius, double theDepth) {
		super(theRadius);
		depth = theDepth;
		
		setShapeName("Cylinder");
	}
	
	public Cylinder(Circle theCircle, double theDepth) {
		super(theCircle.getRadius());
		depth = theDepth;
		setShapeName("Cylinder");
	}
	
	@Override
	public void setDepth(double theDepth) {
		depth = theDepth;
	}
	
	@Override
	public double getDepth() {
		return depth;
	}
	
	@Override
	public double getSurfaceArea() {
		return ((2 * super.getSurfaceArea()) + (2 * Math.PI * super.getRadius() * depth));
	}

	@Override
	public double getPerimeter() {
		return super.getPerimeter();
	}
	
	@Override
	public double getVolume() {
		return (super.getSurfaceArea() * depth);
	}
	
	public String toString()
	{
		return super.toString() + ", depth = " + getDepth();
	}
	
	public boolean equals(Object o)
	{
		if ((o == null) || (!(o instanceof Cylinder)))
		{
			return false;
		}
		return super.equals(o)
				&& ((Cylinder) o).getDepth() == this.getDepth();
	} 

}
