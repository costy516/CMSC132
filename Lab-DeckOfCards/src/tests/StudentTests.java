package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import student_classes.Card;
import student_classes.Deck;
import student_classes.Numerals;
import student_classes.Suits;

public class StudentTests {
	
	@Test
	public void testget_numeral()
	{
		Card card1 = new Card(Suits.clubs, Numerals.deuce);
		Card card2 = new Card (Suits.diamonds, Numerals.king);
		Card card3 = new Card (Suits.spades, Numerals.jack);
		assertTrue(card1.get_numeral() == (Numerals.deuce));
		assertFalse(card2.get_numeral() != (Numerals.king));
		assertTrue(card3.get_numeral() == (Numerals.jack));
		
	}
	
	@Test
	public void testget_suit()
	{
		Card card1 = new Card(Suits.clubs, Numerals.deuce);
		Card card2 = new Card (Suits.diamonds, Numerals.king);
		Card card3 = new Card (Suits.spades, Numerals.jack);
		assertTrue(card1.get_suit() == (Suits.clubs));
		assertFalse(card2.get_suit() != (Suits.diamonds));
		assertTrue(card3.get_suit() == (Suits.spades));
	}
	
	@Test
	public void testCompareTo()
	{
		Card card1 = new Card(Suits.clubs, Numerals.deuce);
		Card card2 = new Card (Suits.diamonds, Numerals.king);
		Card card3 = new Card(Suits.diamonds, Numerals.deuce);
		Card card4 = new Card(Suits.diamonds, Numerals.ten);
		assertTrue(card1.compareTo(card2) <= 0);
		assertTrue(card1.compareTo(card3) == 0);
		assertTrue(card4.compareTo(card1) >= 0);
	}
	
	@Test
	public void testEquals()
	{
		Card card1 = new Card(Suits.clubs, Numerals.deuce);
		Card card2 = new Card (Suits.diamonds, Numerals.king);
		Card card3 = new Card(Suits.clubs, Numerals.deuce);
		assertFalse(card1.equals(card2));
		assertTrue(card1.equals(card3));
	}
	
	@Test
	public void testCardCopyConstructor()
	{
		Card card1 = new Card(Suits.clubs, Numerals.deuce);
		Card card2 = new Card(card1);
		assertTrue(card1.equals(card2));
		assertFalse(card1 == (card2));
	}
	
	@Test
	public void testNext()
	{
		Deck deck1 = new Deck();
		Card card1 = new Card (Suits.clubs, Numerals.three);
		Card card2 = new Card (Suits.clubs, Numerals.deuce);
		assertTrue(deck1.next().equals(card1));
		assertFalse(deck1.next().equals(card2));
	}
	
	@Test
	public void testToStringDeck()
	{
		Deck deck1 = new Deck();
		assertTrue(deck1.toString().substring(0, 15).equals(" deuce of clubs"));
	}
	
	@Test
	public void testSort()
	{
		Deck deck1 = new Deck();
		Deck deck2 = new Deck (deck1);
		deck1.shuffle();
		deck1.sort();
		assertTrue(deck1.next().compareTo(deck2.next()) == 0);
		assertTrue(deck1.cards.size() == deck2.cards.size());
	}
	
	@Test
	public void testShuffle()
	{
		Deck deck1 = new Deck();
		Deck deck2 = new Deck(deck1);
		deck1.shuffle();
		assertFalse(deck1.equals(deck2));
		assertTrue(deck1.cards.size() == deck2.cards.size());
	}

	@Test
	public void testCompare()
	{
		Deck deck1 = new Deck();
		assertTrue(deck1.compare(deck1.cards.get(0), deck1.cards.get(1)) == -1);
		assertTrue(deck1.compare(deck1.cards.get(0), deck1.cards.get(13)) == -100);
	}
}
