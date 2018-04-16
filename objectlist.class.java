import java.util.Arrays;

public class ObjectList {

	private int numFractions = 0;
	private String[] listOfFractions = new String[100];
	Fraction[] fractionList = new Fraction[255];

	/****************************************************/
	/* Add the line from the file to the next index of  */
	/* the array. */
	/****************************************************/
	public void add(String f) {
		listOfFractions[numFractions++] = f;
	}
	
	/****************************************************/
	/* This method creates a string array that will     */
	/* contain two elements - the left and right side of*/
	/* the fraction. The numerator and denominator are  */
	/* sent to the ctor of Fraction. */
	/****************************************************/
	public Fraction[] repopulateArray(){
		String[] splitFractions = new String[2];
		for(int i=0;i<numFractions;i++){
			splitFractions = listOfFractions[i].split("/");
			Fraction theFraction = new Fraction (Integer.parseInt(splitFractions[0]), Integer.parseInt(splitFractions[1]));
			fractionList[i] = theFraction;
		}
		return fractionList;
	}
	
	public String toString(){
		return Arrays.toString(fractionList);
	}
	
	public void expand() {
	    Fraction[] newFractionList = new Fraction[fractionList.length + 1];
	    System.arraycopy(fractionList, 0, newFractionList, 0, fractionList.length);
	    fractionList = newFractionList;
	}
	
	public Fraction[] getFractionList(){
		return fractionList;
	}
	
	public void setFractionList(Fraction[] fractionList){
		this.fractionList = fractionList;
	}
	
	public int getNumFractions(){
		return numFractions;
	}
	
	public void setNumFractions(int numFractions){
		this.numFractions = numFractions;
	}
}