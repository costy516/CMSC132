package student_classes;

public class Card 
{
	private Suits suit;
	private Numerals numeral;
	
	public Card (Suits aSuit, Numerals aNumeral)
	{
		suit = aSuit;
		numeral = aNumeral;
	}
	
	public Card (Card aCard)
	{
		suit = aCard.get_suit();
		numeral = aCard.get_numeral();
	}
	
	public Suits get_suit()
	{
		return this.suit;
	}
	
	public Numerals get_numeral()
	{
		return this.numeral;
	}
	
	public String toString()
	{
		return (""+numeral);
	}
	
	public int compareTo (Card otherCard)
	{
		return (this.helperNum() - otherCard.helperNum());
	}
	
	public boolean equals (Object other)
	{
		if(other == null)
		{
			return false;
		}
		else if (this.compareTo(((Card) other)) == 0)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public int helperNum()
	{
		if(this.get_numeral() == Numerals.deuce)
		{
			return 1;
		}
		else if(this.get_numeral() == Numerals.three)
		{
			return 2;
		}
		else if(this.get_numeral() == Numerals.four)
		{
			return 3;
		}
		else if(this.get_numeral() == Numerals.five)
		{
			return 4;
		}
		else if(this.get_numeral() == Numerals.six)
		{
			return 5;
		}
		else if(this.get_numeral() == Numerals.seven)
		{
			return 6;
		}
		else if(this.get_numeral() == Numerals.eight)
		{
			return 7;
		}
		else if(this.get_numeral() == Numerals.nine)
		{
			return 8;
		}
		else if(this.get_numeral() == Numerals.ten)
		{
			return 9;
		}
		else if(this.get_numeral() == Numerals.jack)
		{
			return 10;
		}
		else if(this.get_numeral() == Numerals.queen)
		{
			return 11;
		}
		else if(this.get_numeral() == Numerals.king)
		{
			return 12;
		}
		else
		{
			return 13;
		}
	}
}
