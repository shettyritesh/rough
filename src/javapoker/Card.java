package javapoker;

public class Card
{
	private short rank;
	private Suit suit;

	private static String[] ranks  = { "Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King" };

	public static String rankAsString( int __rank ) {
		return ranks[__rank];
	}

	public Card(Suit suit, short rank)
	{
		this.rank=rank;
		this.suit=suit;
	}

	public @Override String toString()
	{
		  return ranks[rank] + " of " + suit.toString();
	}

	public short getRank() {
		 return rank;
	}

	public Suit getSuit() {
		return suit;
	}
}

enum Suit{
	Hearts,Clubs,Spades,Diamond	
}