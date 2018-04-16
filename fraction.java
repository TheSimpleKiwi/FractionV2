public class Fraction {

	private int numerator;
	private int denominator;

	public Fraction(){
		this.numerator = 0;
		this.denominator = 1;
	}
	
	/****************************************************/
	/* the ctor takes in the numerator and denominator  */
	/* then sets them to the numerator and denominator  */
	/* of this class and runs them through the gcd      */
	/* then reduces the fraction, and sets the reduced  */
	/* numerator and denominator to the numerator and   */
	/* denominator of this class to be used by          */
	/* FractionCounter                                  */
	/****************************************************/
	public Fraction(int numerator, int denominator){	
		int [] fractionHolder = new int[2];
		fractionHolder = reduce(numerator,denominator);
		this.numerator = fractionHolder[0];
		this.denominator = fractionHolder[1];
	}
	
	//the gcd forumla
	static int gcd(int numerator, int denominator)
	{
	  while(numerator!=0 && denominator!=0) 
	  {
	     int c = denominator;
	     denominator = numerator % denominator;
	     numerator = c;
	  }
	  return numerator+denominator; 
	}
	
	/****************************************************/
	/* takes numerator and denominator values from ctor */
	/* finds applies numerator and denominator to gcd   */
	/* */
	/****************************************************/
	public int[] reduce(int numerator, int denominator){
		int gcd = gcd(numerator, denominator);
		int[] reducedFractions = new int[2];
		int reducedNumerator = numerator/gcd;
		int reducedDenominator = denominator/gcd;
		reducedFractions[0] = reducedNumerator;
		reducedFractions[1] = reducedDenominator;
		return reducedFractions;
	}
	
	public boolean equals(Fraction other){
		return (getNumerator() == (other.getNumerator())
				&& getDenominator() == (other.getDenominator()));
	}

	public String toString(){
		return this.getNumerator() + "/" + this.getDenominator();
	}

	//getters
	public int getNumerator() {	return numerator;	}
	public int getDenominator() {	return denominator;	}

	//setters
	public void setNumerator(int numerator) {	this.numerator = numerator;	}
	public void setDenominator(int denominator) {	this.denominator = denominator;	}
}