/**
* The Word Class contains properties of Word Object.
* I am also implementing the toString and equals method by overriding them.
* I have an arraylist which will hold the line numbers for each word.
* @author  Anshuman Tripathy
* @version 1.0
* @date    2017-11-16
*/

package com.yale.concordance;

import java.util.ArrayList;
import java.util.Arrays;

public class Word {
	
	private String word;  //contains the actual word string.
	private int count;    //contains the number of times the word is repeated in the file.
	private ArrayList<Integer> wordLineIndex;  //contains the line numbers for each word.
	
	public Word() {
		
	}
	
	//Whenever a word is declared it's count is automatically one.
	public Word(String word) {
		this.word=word;
		this.count=1;
	}
	
	public String getWord() {
		return this.word;
	}
	
	public void setWord(String word) {
		this.word = word;
	}

	public ArrayList<Integer> getWordLineIndex() {
		return wordLineIndex;
	}

	public void setWordLineIndex(ArrayList<Integer> wordLineIndex) {
		this.wordLineIndex = wordLineIndex;
	}
	
	public void increaseCount() {
		this.count++;
	}
	
	//This will be used to find the index of the word when it inside the word List.
	@Override
	public boolean equals(Object anotherWord) {
		return this.word.equals(((Word)anotherWord).word);
	}
	
	//Used to display the Word Object in the required format
	@Override
	public String toString() {
		return  this.word + "\t" + this.count + " : " + Arrays.toString(wordLineIndex.toArray());
	}

}
