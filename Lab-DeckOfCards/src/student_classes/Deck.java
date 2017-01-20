package student_classes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;



public class Deck implements Iterator<Card>, Comparator<Card>
{
	public ArrayList<Card> cards;
	public int pos = 0;
	
	public Deck ()
	{
		cards = new ArrayList<Card>(52);
		for(Suits s: Suits.values())
		{	
			for(Numerals n: Numerals.values())
			{
				cards.add(new Card (s, n));
			}
		}
		
	}
	
	public Deck (Deck otherDeck)
	{
		cards = new ArrayList<Card>();
		for (Card c: otherDeck.cards)
		{
			cards.add(new Card(c.get_suit(), c.get_numeral()));
		}
	}
	
	public Iterator<Card> iterator()
	{
		return cards.iterator();
	}
	
	@Override
	public int compare(Card card1, Card card2) 
	{
		int result = 0;
		Card [] twoCards = {card1, card2};
		// test suit
		for(int i = 1, j = 0; i >= -1 || j <= 1; j++, i-=2)
		{
			if(twoCards[j].get_suit() == Suits.spades)
			{
				result += 400*i;
			}
			else if(twoCards[j].get_suit() == Suits.hearts)
			{
				result += 300*i;
			}
			else if(twoCards[j].get_suit() == Suits.diamonds)
			{
				result += 200*i;
			}
			else if(twoCards[j].get_suit() == Suits.clubs)
			{
				result += 100*i;
			}
		}
		// test numeral
		result+= card1.compareTo(card2);
		return result;
	}
	
	public int size ()
	{
		return cards.size();
	}
	
	public void shuffle ()
	{
		if(this.cards.size() > 1)
		{
			List<Card> shuffle = new ArrayList<Card>();
			
			for(Card c: cards)
			{
				shuffle.add(new Card(c));
			}
			
			Collections.shuffle(shuffle);
			cards = new ArrayList<Card>();
			for(Card c: shuffle)
			{
				cards.add(new Card(c));
			}
		}
	}
	
	public void sort ()
	{
//		ArrayList<Card> tempClubs = new ArrayList<Card>();
//		ArrayList<Card> tempDiamonds = new ArrayList<Card>();
//		ArrayList<Card> tempHearts = new ArrayList<Card>();
//		ArrayList<Card> tempSpades = new ArrayList<Card>();
//		
//		for (Card c: cards)
//		{
//			if(c.get_suit() == Suits.clubs)
//			{
//				tempClubs.add(new Card(c));
//			}
//			else if(c.get_suit() == Suits.diamonds)
//			{
//				tempDiamonds.add(new Card(c));
//			}
//			else if(c.get_suit() == Suits.hearts)
//			{
//				tempHearts.add(new Card(c));
//			}
//			else if(c.get_suit() == Suits.spades)
//			{
//				tempSpades.add(new Card(c));
//			}
//		}
//		
//		List<Card> sortedClubs = new ArrayList<Card>(tempClubs);
//		List<Card> sortedDiamonds = new ArrayList<Card>(tempDiamonds);
//		List<Card> sortedHearts = new ArrayList<Card>(tempHearts);
//		List<Card> sortedSpades = new ArrayList<Card>(tempSpades);
//		
//		List<Card> sortedList = new ArrayList<Card> (tempClubs);
//		Collections.sort(sortedList);
//		
//		Collections.sort(sortedClubs);
//		Collections.sort(sortedDiamonds);
//		Collections.sort(sortedHearts);
//		Collections.sort(sortedSpades);
//		
//		cards = new ArrayList<Card>();
//		
//		for(Card c: sortedClubs)
//		{
//			cards.add(new Card(c));
//		}
//		for(Card c: sortedDiamonds)
//		{
//			cards.add(new Card(c));
//		}
//		for(Card c: sortedHearts)
//		{
//			cards.add(new Card(c));
//		}
//		for(Card c: sortedSpades)
//		{
//			cards.add(new Card(c));
//		}
//		
	}
	
	public String toString()
	{
		String str = "";
		for(Card c: cards)
		{
			str += " " + c.get_numeral() + " of " + c.get_suit();
		}
		return str;
	}
	
	public boolean equals (Object other)
	{
		if(this == null || other == null)
		{
			return false;
		}
		else if(this.cards.size() != ((Deck) other).cards.size())
		{
			return false;
		}
		else
		{
			for(int i = 0; i < this.cards.size(); i++)
			{
				if(compare(this.cards.get(i),(((Deck)other).cards.get(i))) != 0)
				{
					return false;
				}
			}
			return true;
		}
	}

	@Override
	public boolean hasNext() 
	{
		// TODO Auto-generated method stub
		if(pos >= cards.size())
		{
			return false;
		}
		else
		{
			return true;
		}
	}

	@Override
	public Card next() 
	{
		if(!hasNext())
		{
			return null;
		}
		else 
		{
			pos++;
			return cards.get(pos);
		}
	}
	
	@Override
	public void remove() 
	{
		cards.remove(pos);
	}

	
}
