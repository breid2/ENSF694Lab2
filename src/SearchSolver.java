/**
 * Class Name: SearchSolver
 * 
 * @author Benjamin Reid
 *
 */
import java.util.Arrays;
public class SearchSolver {
	int[] userArray;
	int userKey;
	
	public SearchSolver(int[] userArray, int userKey) {
		this.userArray = userArray;
		this.userKey = userKey;
		System.out.println("");
		System.out.println("Using Linear Search:");
		//Arrays.sort(userArray);
		long startLinear = System.nanoTime();
		int lin = LinearSearch(userArray, userKey);
		long endLinear = System.nanoTime();
		long timeLinear = endLinear - startLinear;
		if (lin>=0){
			System.out.println("Search key FOUND at index " + lin);
		}
		else {
			System.out.println("Search key NOT FOUND");
		}
		
		System.out.println("");
		System.out.println("Using Interpolation Search:");
		Arrays.sort(userArray);
		long startInter = System.nanoTime();
		int inter = InterpolationSearch(userArray, userKey);
		long endInter = System.nanoTime();
		long timeInter = endInter - startInter;
		if (inter>=0){
			System.out.println("Search key FOUND at index " + inter);
		}
		else {
			System.out.println("Search key NOT FOUND");
		}
		
		System.out.println("");
		System.out.println("Time for linear: " + timeLinear + " nanoseconds."); 
		//Linear is faster since it is better with smaller data sets. The provided example values ran at 4200 nanoseconds 
		//for linear and 8500 nanoseconds for interpolation.
		System.out.println("Time for interpolation: " + timeInter + " nanoseconds.");

	}
	
	public int LinearSearch(int[] userArray, int userKey) {

		for(int i=0; i<(userArray.length); i++) {
			//int keyFound = i; //- removed to increase speed
			if (userArray[i] == userKey) {
				//return keyFound; //- removed to increase speed
				return i;
			}
		}
		int j =-1;
		return j;
		
	}
	
	public int InterpolationSearch(int[] userArray, int userKey) {
		int low = 0, mid, high = userArray.length-1;
		
		while (low <= high)
		{
		int pos = (userKey-userArray[low])/(userArray[high]-userArray[low]);
		mid = low + ((high-low)*pos);
		if(userKey < userArray[mid])
		high = mid - 1;
		else if(userArray[mid] < userKey)
		low = mid + 1;
		else
		return mid; //key FOUND and index returned
		}
		return -1; //key NOT FOUND and -1 returned
	}

}