class Zillion {
	private int[] var;
	public Zillion(int size) {
		var = new int [size];
	}
	public void increment() {
		var[0] ++;
		checkTens(0);
	}
	private void checkTens(int point) {
		if(point<var.length&&var[point]==10) {
			var[point]-=10;
			if(point+1<var.length)
				var[point+1]++;
			checkTens(point+1);
		}
	}
	public String toString() {
		String temp = "";
		int i = var.length;
		while(i-->0) {
			temp += var[i];
		}
		return temp;
		
	}

	public static void main(String[] args) {
		Zillion z = new Zillion(2);    System.out.println(z);  //  00  2 points    
		z.increment();    System.out.println(z);  //  01  2 points    
		z.increment();    System.out.println(z);  //  02  2 points    
		z.increment();
		z.increment();
		z.increment();
		z.increment();
		z.increment();
		z.increment();
		z.increment();
		z.increment();
		System.out.println(z);  //  10  2 points    
		z.increment();
		System.out.println(z);  //  11  2 points    
		z = new Zillion(4);
		System.out.println(z);  //  0000  2 points    
		for (int j = 1; j <= 999; j += 1)    {
			z.increment();    
			}    
		System.out.println(z);  //  0999  2 points    
		z.increment();
		System.out.println(z);  //  1000  2 points    
		for (int j = 1; j <= 999; j += 1)    {      z.increment();    }    System.out.println(z);  //  1999  2 points    
		z.increment();    
		System.out.println(z);  //  2000  2 points    
		for (int j = 1; j <= 7999; j += 1)    {      
			z.increment();    
			}    
		System.out.println(z);  //  9999  2 points    
		z.increment();
			System.out.println(z);  //  0000  2 points    
			z.increment();    
			System.out.println(z);  //  0001  1 point
	}

}