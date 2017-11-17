/**
* This is the Comparator Class.
* Used to sort words alphabetically.
* 
* @author  Anshuman Tripathy
* @version 1.0
* @date    2017-11-16
*/

package com.yale.concordance;

import java.util.Comparator;

public class WordComparator implements Comparator<Word> {

	@Override
	public int compare(Word w1, Word w2) {
		
		return w1.getWord().compareToIgnoreCase(w2.getWord());
	}

}
