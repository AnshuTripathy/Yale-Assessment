/**
* The Line Class contains properties of Line Object.
* I am also implementing the toString and equals method by overriding them.
* 
* @author  Anshuman Tripathy
* @version 1.0
* @date    2017-11-16
*/

package com.yale.concordance;

public class Line {
	private String sentence;   //contains the line string
	private int lineNumber;    //Contains the line number
	
	public Line() {
		
	}
	
	//A line is initialized by taking in both the sentence string and the line number
	public Line(String sentence, int lineNumber) {
		this.sentence = sentence;
		this.lineNumber = lineNumber;
	}
	
	public String getSentence() {
		return this.sentence;
	}
	
	public void setSentence(String sentence) {
		this.sentence = sentence;
	}
	
	public int getLineNumber() {
		return this.lineNumber;
	}

	public void setLineNumber(int lineNumber) {
		this.lineNumber = lineNumber;
	}
	
	@Override
	public boolean equals(Object anotherLine) {
		return this.sentence.equals(((Line)anotherLine).sentence);
	}

	@Override
	public String toString() {
		return "Line [sentence=" + sentence + ", lineNumber=" + lineNumber + "]";
	}
	

}
