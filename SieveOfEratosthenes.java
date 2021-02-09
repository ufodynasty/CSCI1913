
class Sieve{
	private boolean[] numbers;
	public Sieve(int max) throws IllegalArgumentException{
		if(max<2) {
			throw new IllegalArgumentException("Sieve size must be at least 2");
		}
		numbers = new boolean[max];
		for(int i=2;i<numbers.length;i++) {
			numbers[i]=true;
		}
	}
	public void findPrimes() {
		for(int i=2;i<Math.sqrt(numbers.length);i++) {
			if(numbers[i]) {
				for(int j=i;j<numbers.length;j++) {
					if(j!=i&&j%i==0) {
						numbers[j]=false;
					}
				}
			}
		}
	}
	public String toString() {
		String temp = "";
		for(int i=0;i<numbers.length;i++) {
			if(numbers[i]) {
				temp +=i+" ";
			}
		}
		return temp;
		
	}

}
//
//SIEVE DRIVER. The Sieve of Eratosthenes.
//
//James B. Moen
//20 Sep 20
//
//Test the SIEVE class, for 30 points total.
//

//SIEVE DRIVER. Run SIEVE on some examples.

class SieveDriver
{

//MAIN. Find some primes.

public static void main(String [] args)
{
Sieve sieve = null;  //  We must initialize SIEVE or Java will cry.

//5 points. This must print "Sieve size must be at least 2." but without the
//quotes.

try
{
  sieve = new Sieve(0);
}
catch (IllegalArgumentException oops)
{
  System.out.println("Sieve size must be at least 2.");
}

//5 points. This must print nothing.

try
{
  sieve = new Sieve(100);
}
catch (IllegalArgumentException oops)
{
  System.out.println("Sieve size must be at least 2.");
}

//10 points. This must print integers from 2 to 99, separated by blanks.

System.out.println(sieve);

//10 points.  This must print the prime numbers between 2 and 99, terminated
//by blanks. They are:
//
//2 3 5 7 11 13 17 19 23 29 31 37 41 43 47 53 59 61 67 71 73 79 83 89 97

sieve.findPrimes();
System.out.println(sieve);
}
}

