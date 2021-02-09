//Benjamin Maymir
//maymi001
//9/29/2020
class Polygon {
	private int[] sideLengths; 

	public Polygon(int sides, int ... lengths) { 
		int index = 0; 
		sideLengths = new int[sides]; 
		for (int length: lengths) 
		{ 
			sideLengths[index] = length; 
			index += 1; 
		} 
	} 
			
	public int side(int number) 
	{ 
		return sideLengths[number]; 
	} 
			
	public int perimeter() 
	{ 
		int total = 0; 
		for (int index = 0; index < sideLengths.length; index += 1) 
		{ 
			total += side(index); 
		} 
		return total;
	}
}
class Rectangle extends Polygon{

	public Rectangle(int l,int w) {
		super(4,l,w,l,w);
	}
	public int area() {
		return(side(0)*side(1));
	}
	
}

class Square extends Rectangle{
	public Square(int side) {
		super(side,side);
	}
}
//SHAPES DRIVER. Public tests for the classes RECTANGLE and SQUARE. Comments
//show what each test must print, and how many points it is worth.

class ShapesDriver
{
public static void main(String[] args)
{
Rectangle wreck = new Rectangle(3, 5);

System.out.println(wreck.side(0));      //  3   1 point.
System.out.println(wreck.side(1));      //  5   1 point.
System.out.println(wreck.side(2));      //  3   1 point.
System.out.println(wreck.side(3));      //  5   1 point.
System.out.println(wreck.area());       //  15  1 point.
System.out.println(wreck.perimeter());  //  16  1 point.

Square nerd = new Square(7);

System.out.println(nerd.side(0));       //  7   1 point.
System.out.println(nerd.side(1));       //  7   1 point.
System.out.println(nerd.side(2));       //  7   1 point.
System.out.println(nerd.side(3));       //  7   1 point.
System.out.println(nerd.area());        //  49  1 point.
System.out.println(nerd.perimeter());   //  28  1 point.
}
}
