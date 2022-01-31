package pkg.main;

//Author Name: Connor Blanton
//Date: 1/30/2021
//Program Name: Blanton_SpellCheck
//Purpose: spell checking

// import
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;


public class SpellChecker {
	// Initialization of Variables
	private ArrayList dict;
	private ArrayList compared;
	private ArrayList unknown;
	public SpellChecker() {
		// Skeleton
		dict = new ArrayList();
		compared = new ArrayList();
		unknown = new ArrayList(); }

	
	public void loadDict(String fileName) {
		BufferedReader reader;
		FileReader freader;
		String holder;
		
		try {
			//Initialize variables and readers
			freader = new FileReader(fileName);
			reader = new BufferedReader(freader);
			holder = reader.readLine();
			
			
			//Building the data
			while (holder != null) {
				
				dict.add(holder);
				holder = reader.readLine();
		
			} 
		}
		//Failsafes
		 catch (FileNotFoundException e) {
			System.out.println("ERROR: That file cannot be found.");
			System.exit(1);} 
		 catch (IOException e) {
			System.out.println("ERROR: The file may be locked or corrupt. It cannot be read from properly.");
			System.exit(2);
		} 
}

	public void loadComp(String fileName) {
		BufferedReader reader;
		FileReader freader;
		String holder;
		
		try {
		
			freader = new FileReader(fileName);
			reader = new BufferedReader(freader);
			holder = reader.readLine();
			
			
			//Building the data again
			while (holder != null) {
				
				compared.add(holder);
				holder = reader.readLine();
		
			} 
		}
		//Failsafes
		 catch (FileNotFoundException e) {
			System.out.println("ERROR: That file cannot be found.");
			System.exit(1);} 
		 catch (IOException e) {
			System.out.println("ERROR: The file may be locked or corrupt. It cannot be read from properly.");
			System.exit(2);
		} 
}	
	
	
	public static void main(String args[]) {
		//Initialize the checker.
		BufferedReader input;
		SpellChecker check = new SpellChecker();
		// Sentinel. Necessary to avoid robot uprising.
		int COUNT = 0;
		input = new BufferedReader(new InputStreamReader(System.in));
	
		
			// ask the user for a 2 Files to import.
	 try {
			System.out.print("Please enter a comparison file. >> ");
			check.loadComp(input.readLine());
			System.out.print("Please enter a dictionary file. >> ");
			check.loadDict(input.readLine());
			// This is where the magic happens.
			while(COUNT < check.dict.size()) {
			if(check.compared.get(COUNT).equals(check.dict.get(COUNT))){
				System.out.println("Good word found"); // Good word
			}
			
			else {
				check.unknown.add(check.compared.get(COUNT)); // Bad word, go to unknown!
			}
		
			COUNT = COUNT + 1; //SENTINEL creeps closer to the robot to keep it in line.
			}
			
			
			COUNT = 0; // Reset the SENTINEL to check unknown and start spitting out gibberish.
			while(COUNT < check.unknown.size()) {
				System.out.println("Unknown words follow. Please correct in document.");
					System.out.println(check.unknown.get(COUNT)); // Gibberish
					COUNT = COUNT + 1; // I just love saying SENTINEL
				}
	 }
	 
	
	 
			// Jury-Rigged Failsafe
			catch (FileNotFoundException e) {
				System.out.println("ERROR: That file cannot be found.");
				System.exit(1);
				} 
			 catch (IOException e) {
				System.out.println("ERROR: The file may be locked or corrupt. It cannot be read from properly.");
				System.exit(2);
			} 

	}
	
}
		
// EOF: seriously, there's no code left!	
			
		
		
	

