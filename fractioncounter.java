
public class FractionCounter {

	Fraction fraction = new Fraction();
	private int count = 1;


	FractionCounter(Fraction theFraction){
		fraction = theFraction;

	}

	public boolean compareAndIncrement(Fraction newFraction){
		if(fraction.equals(newFraction)){
			count++;
			return true;
		}else{
			return false;
		}
	}

	public String toString(){
		return this.fraction.getNumerator() + "/" + this.fraction.getDenominator() + " has a count of " + count;
	}
}