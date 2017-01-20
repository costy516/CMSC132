package student_classes;
/**
 * A streamlined (simplified) implementation of a class
 * that represents non-negative rational numbers. Recall that 
 * a rational number is an object that contains two integers,
 * call them a and b, such that a/b and b not equal 0.
 * <br>
 * <ul>
 * <li>This implementation needs to support comparability as well
 * as the basic four arithmetic operators, +,-,* and /.</li> 
 * <li>
 * In addition, the <code>Rational</code> class must override
 * the <code>equals</code>, the <code>toString()</code>, and
 * the <code>hashCode</code> methods.</li>
 * </ul>
 * 
 * @author UMD CS Department.
 *
 */
public class Rational implements Comparable<Rational> 
{
	private int num, denom;
	
	public Rational(int num, int denom)
	{
		if(num < 0 || denom < 0)
		{
			this.num = 0;
			this.denom = 0;
		}
		else
		{
			this.num = num;
			this.denom = denom;
		}
	}
	public Rational(Rational copy)
	{
		this.num = copy.getNumerator();
		this.denom = copy.getDenominator();
	}
	public int getDenominator() {
		return denom;
	}
	public int getNumerator() {
		return num;
	}
	public Rational plus(Rational other)
	{
		if(this.denom == other.denom)
		{
			return new Rational(this.num+other.num, this.denom);
		}
		return new Rational((this.num*other.denom)+(other.num*this.denom), this.denom*other.denom);
	}
	public Rational diff(Rational other)
	{
		if((this.num*other.denom)-(other.num*this.denom) < 0 || this.denom <= 0 || other.denom <= 0 || this.num < 0 || other.num < 0) 
		{
			return new Rational(0,0);
		}
		else if(this.denom == other.denom)
		{
			return new Rational(this.num-other.num, this.denom);
		}
		return new Rational((this.num*other.denom)-(other.num*this.denom), this.denom*other.denom);
	}
	public Rational mult(Rational other)
	{
		return new Rational(this.num*other.num, this.denom*other.denom);
	}
	public Rational divide(Rational other)
	{
		if(this.denom*other.num <= 0)
		{
			return new Rational (0,0);
		}
		return new Rational(this.num*other.denom, this.denom*other.num);
	}
	public String toString()
	{
		return (getNumerator() + "/" + getDenominator());
	}
	public int hashCode()
	{
		return this.reduced().toString().hashCode();
	}
	@Override
	public boolean equals(Object other)
	{
		if(this == null & other == null)
		{
			return true;
		}
		if(this == null || other == null)
		{
			return false;
		}
		if(this.getClass() != other.getClass())
		{
			return false;
		}
		if(this.getNumerator() == 0 && ((Rational) other).getNumerator() == 0)
		{
			return true;
		}
		Rational tempThis = this.reduced();
		Rational tempOther = ((Rational)other).reduced();
		if(tempThis.getNumerator() == tempOther.getNumerator() && tempThis.getDenominator() == tempOther.getDenominator())
		{
			return true;
		}
		return false;
	}
	@Override
	public int compareTo(Rational o) {
		if(this.equals(o))
		{
			return 0;
		}
		else if ((this.num/this.denom) < (o.getNumerator()/o.getDenominator()))
		{
			return -1;
		}
		else
		{
			return 1;
		}
	}
	
	private Rational reduced()
	{
		if(this.num == this.denom)
		{
			return new Rational(1,1);
		}
		boolean reduced = false;
		int tempNum = num;
		int tempDenom = denom;
		int min = (this.num < this.denom)?(this.num):(this.denom);
		
		for(int i = min; i > 1; i--)
		{
			if(tempNum%i == 0 && tempDenom%i == 0)
			{
				reduced = true;
				tempNum /= i;
				tempDenom /= i;
			}
		}
		if(reduced)
		{
			new Rational(tempNum,tempDenom).reduced();
		}
		return new Rational(tempNum, tempDenom);
	}

}
