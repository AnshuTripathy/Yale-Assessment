/**
* This Class contains the business logic of the Application.
* I'm storing distinct word objects in an arraylist and increasing their count if 
* it is added to the list again.
* 
* I'm storing the lines into another arraylist.
* Finally I'm doing a check between word and line lists to see which words fall in which line.
* 
* @author  Anshuman Tripathy
* @version 1.0
* @date    2017-11-16
*/

package com.yale.concordance;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;


public class Concordance {
	
	//this will hold line number
	private static int count=1;
	
	public static final String REGEX_PATTERN="[^a-zA-Z'-]|(?<!\\w)-(?!\\w)|(?<!\\w)'(?!\\w)|(?<!\\w).(?!\\w)";
	
	public static final String SPLIT_PATTERN="[/\\\\ ,.]";
	
	//Creating lists for storing word and line Objects
	private ArrayList<Word> wordList;
	private ArrayList<Line> lineList;
	
	
	public Concordance() {
		wordList = new ArrayList<Word>();
		lineList = new ArrayList<Line>();
	}
	
	public void scanLines(String fileName) throws FileNotFoundException, IOException {
		
		Scanner scan = new Scanner(new File(fileName));
		while(scan.hasNextLine()) {
			//converting all characters in a line to lower case. Also passing the line count.
			Line line = new Line(scan.nextLine().toLowerCase(),count);
			 
		    //adding the lines to arraylist one by one.
			lineList.add(line);  
			
			    //splitting the line into an array of words by forward slash, backward slash, whitespace, comma and period.
				String[] words = line.getSentence().split(SPLIT_PATTERN);
				
				//Iterating through all the words inside the word array which we got from splitting line.
				for( String w : words) {
					
					//Performing a Regex check for counting hyphenated words as a single word and 
					//allowing words with apostrophes.
					String wordString = w.replaceAll(REGEX_PATTERN, "");
					
					//performing a check on the word to make sure it is not empty or null
					if(wordString!=null && !wordString.isEmpty()) {
					    
						//Creating a new word instance with the validated string.
						Word word = new Word(wordString);
						
						//checking to see if the word already exists in the word array list.
						//if it does we increment the count for that word. Otherwise add it to list.
						int wordIndex = wordList.indexOf(word);
						if(wordIndex==-1) {
						wordList.add(word);
					} else {
						wordList.get(wordIndex).increaseCount();
					}
					
					}
					
				}
				
				//incrementing line count for every hasNextLine()
				count++;
			} 
		
		scan.close();
	}
	
	//Function to calculate the line numbers for each word in the list.
	public void defineWordIndexes(ArrayList<Word> wordList, ArrayList<Line> lineList) {
		 
		 for(Word w : wordList) {
			 ArrayList<Integer> indexList = new ArrayList<Integer>();
			 for(int i=0; i<lineList.size(); i++) {
				 
				 //Checking to see if each word in the word list occurs in lines present in the line list.
				 //if it does I am adding the index incremented by 1 to the indexList array list.
				 if(lineList.get(i).getSentence().contains(w.getWord())) {
					 indexList.add(i+1);
				 }
			 }
			 //I'm setting list of indexes we got into each word object in the word list.
			 w.setWordLineIndex(indexList);
		 }
	}
	
	public void startConcordance(String fileName) throws FileNotFoundException, IOException {
		
		scanLines(fileName);
		
		//Sorting the word list alphabetically using comparator.
		Collections.sort(wordList, new WordComparator());
		
		//computing line numbers for each word.
		defineWordIndexes(wordList, lineList);
	
		//printing the wordlist
		printConcordance();
	}
	
	public void printConcordance() {
		
		//printing every word in the word list.
		for(int i=0;i<wordList.size();i++) {
			System.out.println(wordList.get(i));
		}
	}

}
