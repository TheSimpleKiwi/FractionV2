/****************************************************/
/*					Driver Class					*/
/* The Driver class contains methods to open the	*/
/* file. Then adds the next line of the file to the	*/
/* array in ObjectList. Then gets the returned,		*/
/* reduced Fraction object and sends it to the		*/
/* FractionCounter class ctor to be handled by the	*/
/* FractionCounter class. Then, finally return the	*/
/* string value of the FractionCounter object		*/
/****************************************************/

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Driver {

	/******************************************/
	/* Class (instance) variable declarations */
	/* Object creations						  */
	/******************************************/
	Scanner dataFileScanner = null;
	private int totalLineCount = 0;
	ObjectList myFractions = new ObjectList();
	Fraction[] fractionList = new Fraction[255];

	public static void main(String[] args){
		Driver driver = new Driver();
		driver.openTheFile();
		driver.addToList();
		driver.populateAndPrint();
		driver.expand();
		driver.closeTheFile();
	}

	public void openTheFile(){
		try {
			dataFileScanner = new Scanner(new FileInputStream("fractions.txt"));
		} catch (FileNotFoundException e) {
			System.out.println("The file was not found");
			System.out.println("Check the directory and make sure fractions.txt is in the correct workspace folder");
		}
	}

	/****************************************************/
	/* Adding each fraction as a String to the object list
	 * This method will check if there is another line,
	 * then add that line to the next position in the array
	 * stored in ObjectList */
	/****************************************************/
	public void addToList(){
		while(dataFileScanner.hasNext()){
			myFractions.add(dataFileScanner.nextLine());
			totalLineCount++;
		}
	}

	/****************************************************/
	/* This method contains a loop that goes over each	*/
	/* Fraction Object in the fractionList then passes	*/
	/* it to the constructor of a new FractionCounter	*/
	/* object. */
	/****************************************************/
	public void populateAndPrint(){
		for(int i=0;i<myFractions.fractionList.length;i++){
			FractionCounter fCounter = new FractionCounter(myFractions.fractionList[i]);	
			//System.out.println(fCounter.toString());
		}
	}

	/****************************************************/
	/* this method will create a new array, set the		*/
	/* size to 1 more than the length of the list of	*/
	/* fractionObjects. Copy the contents of the		*/
	/* original to the new, then set the old to the new	*/
	/* array											*/
	/****************************************************/
	public void expand() {
		Fraction[] newFractionList = new Fraction[fractionList.length + 1];
		System.arraycopy(fractionList, 0, newFractionList, 0, fractionList.length);
		fractionList = newFractionList;
	}

	public int getTotalLineCount(){
		return totalLineCount;
	}

	public void setTotalLineCount(int totalLineCount){
		this.totalLineCount = totalLineCount;
	}
	//we're done, so let's close the file. :)
	public void closeTheFile(){
		dataFileScanner.close();
	}
}