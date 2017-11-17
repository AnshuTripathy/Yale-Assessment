/**
* This is the Main Application.
* This is where I'm passing the file name as an argument.
* 
* @author  Anshuman Tripathy
* @version 1.0
* @date    2017-11-16
*/

package com.yale.concordance;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ConcordanceApp {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		
		//Checking if the fileName is provided as an argument.
		if(args.length!=1) {
			System.out.println("Missing or Incorrect Argument. Please provide a Single File Name as an Argument.");
			System.exit(0);
		}
		
		//Checking if the proper fileName is provided as an argument.
		File sourceFile = new File(args[0]);
		if(!sourceFile.exists()) {
			System.out.println("A file with that name does not exist. Please provide a Valid File. "
					           + "Kindly also make sure that the .txt file extension is mentioned");
			System.exit(1);
		}
		
		//creating an Object of the Class which holds the business logic.
		Concordance concObj = new Concordance();
		
		System.out.println("Word" + "\t" + "Frequency" + " : " + "Line Number(s)");
		
		//starting operation.
		concObj.startConcordance(sourceFile.getName());

	}

}
