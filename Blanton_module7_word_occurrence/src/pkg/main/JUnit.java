package pkg.main;

//Author Name: Connor Blanton
//Date: 3/20/2022
//Program Name: Blanton_module8_unit_test
//Purpose: JUNIT test for the word occurrence program

import static org.junit.Assert.assertEquals;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.junit.Test;

public class JUnit {

	
	// Init lists for sort test
	static List <Entry<String, Integer>> list = new ArrayList<>();
	static List <Entry<String, Integer>> list2 = new ArrayList<>();
	
	@Test
	public void testCountWords(){
		
		// Init maps
		

		Map<String, Integer> words = new HashMap<>();
		Map<String, Integer> test = new HashMap<>();
		 
		try {

			// Call functions
			Mainchecker.wordCount("macbeth.txt",words);
			Mainchecker.wordCount("macbeth.txt",test);
			
			//Check to see if the maps are equal 
			
			assertEquals("Maps are not equal", words, test);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace(); // Whoops!
		}
		
	}
	
	@Test
	public void testSortMap() {

		// Init maps
		
		Map<String, Integer> words = new HashMap<>();
		Map<String, Integer> test = new HashMap<>();
		 
		try {

			// Replicating the functionality
			
			Mainchecker.wordCount("macbeth.txt", words);
			Mainchecker.wordCount("macbeth.txt", test);
			
			list.addAll(words.entrySet());
			list.sort(Entry.comparingByValue());
			list2.addAll(test.entrySet());
			list2.sort(Entry.comparingByValue());

			// Test
			
			assertEquals("Maps not sorted exactly", list, list2);
				
		} catch (FileNotFoundException e) {
			e.printStackTrace(); // Whoops!
		}
	}
	
}
		
	
