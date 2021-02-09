import java.util.Arrays;
//Benjamin Maymir maymi001

class BinaryVsLinear
{

  private static int linearSearch(int key, int[] array)
  {
	  int index=0,temp=1;
	  while(array[index]!=key) {
		  temp++;
		  index++;
	  }
	  return(temp);
	  //index holds the location of key in array
  }
  private static int binarySearch(int key, int[] array)
  {
	  if(array.length==1) {
		  return(1);
	  } else {
		  if(array[array.length/2]<=key) {
			  return(1+binarySearch(key,Arrays.copyOfRange(array, array.length/2, array.length)));
		  } else {
			  return(1+binarySearch(key,Arrays.copyOfRange(array,0, array.length/2)));
		  }
	  }

  }

  public static void main(String[] args)
  {
    for (int length = 1; length <= 30; length += 1)
    {
      int[] array = new int[length];
      for (int index = 0; index < length; index += 1)
      {
        array[index] = index;
      }

      double linearTotal = 0.0;
      double binaryTotal = 0.0;
      for (int element = 0; element < length; element += 1)
      {
        linearTotal += linearSearch(element, array);
        binaryTotal += binarySearch(element, array);
      }

      double linearAverage = linearTotal / length;
      double binaryAverage = binaryTotal / length;
      System.out.println(length + " " + linearAverage + " " + binaryAverage);
    }
  }
}
