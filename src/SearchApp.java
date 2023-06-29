/**
 * Class Name: SearchApp
 * 
 * @author Benjamin Reid
 *
 */

public class SearchApp {
	
	private SearchSolver search;
	private InteractiveCLI cli;
	
	public SearchApp() {
		
		cli = new InteractiveCLI(); //Create interactive CLI
	}
	
	public void run() {
		int userNumber; //Initialize variables
		int userKey;
		
		this.cli.prompt("Enter the number of elements in the array: "); //Number of elements from user
		userNumber = this.cli.getKeyboardInteger();
		System.out.println("Enter the elements in the array:");
		int[] userArray = new int[userNumber];
		
		for(int i=0; i<=(userNumber-1); i++) {
			userArray[i] = this.cli.getKeyboardInteger(); //Get all the array elements from user
		}
		
		this.cli.prompt("Enter the search key: "); //Key from user
		userKey = this.cli.getKeyboardInteger();
		
		search = new SearchSolver(userArray, userKey);
	}

	public static void main(String[] args) {
		
		SearchApp app = new SearchApp();
		app.run();
		

	}

}