package pkg.main;



//Author Name: Connor Blanton
//Date: 3/6/2022
//Program Name: Blanton_module7_word_occurrence
//Purpose: Count the number of times each word appears in the target

import java.io.File;
import java.io.FileNotFoundException;

import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class Mainchecker extends Application {

	static List <Entry<String, Integer>> list = new ArrayList<>();

	/**
	 * Read the file, enumerate all our words.
	 *
	 * @throws FileNotFoundException If the file does not exist.
	 * 
	 */
	// 
	public static void wordCount(String filename, Map< String, Integer> words) throws FileNotFoundException
	{
	Scanner file=new Scanner (new File(filename));
	while(file.hasNext()){
	String word=file.next();
	Integer count=words.get(word);
	if(count!=null)
	count++;
	else
	count=1;
	words.put(word,count);

	}
	file.close();
	}
	

	/**
	 * Shove the words (by force if necessary) into a list. Sort it so we can get the top 20 at the bottom.
	 *
	 * @throws FileNotFoundException If the file does not exist.
	 * 
	 */
	//
	
	public static void checkWords() throws FileNotFoundException
	{
	Map<String,Integer> words=new HashMap<String, Integer>();
	wordCount("macbeth.txt",words);
	System.out.println(words);
	list.addAll(words.entrySet());
	list.sort(Entry.comparingByValue());
	}

	@Override
	 public void start(Stage primaryStage) throws Exception {
		  checkWords();  // Logic
		 Label l = new Label ("Macbeth Word Counts");
		 TextArea l2 = new TextArea (list.toString());
		 l2.setWrapText(true); 	// Looks less stupid

		 // Define the structure.
		 VBox root = new VBox();
		 root.getChildren().addAll(l,l2);
		 root.setSpacing(5);
		
		 Scene scene = new Scene(root,400,400);
		 
		 primaryStage.setScene(scene);
	   	 primaryStage.setTitle("Word Count");
	   	 primaryStage.show(); // Initialization complete here.
		 
	}
	
	    public static void main(String[] args) throws FileNotFoundException {
	        launch(args); // Go.
	      
	        
	    }	
	
	
}
