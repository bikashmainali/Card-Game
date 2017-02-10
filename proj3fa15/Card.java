package proj3fa15;

/**
 * <p>
 * Title: The Card class
 * </p>
 * <p>
 * Description: This class represents a single playing card.Each card has a suit and a value. 
 * </p>
 * 
 * @author Darci L. Burdge and Bikash Mainali
 */
public class Card
{
	// instance variables
	private int value;
	private String suit;

	/**
	 * Card constructor -- this constructor gets called when an object of the
	 * Card class is instantiated -- based upon the number received it
	 * determines the value and suit of the card
	 * 
	 * @param num
	 *            a number that gets converted to a value between 1 and 13
	 */
	public Card(int num)
	{
		int suitNumber;
		value = num % 13;
		if (value == 0)
			value = 13;
		suitNumber = num / 13;
		if (suitNumber == 0)
			suit = new String("clubs");
		else if (suitNumber == 1)
			suit = new String("diamonds");
		else if (suitNumber == 2)
			suit = new String("hearts");
		else if (suitNumber == 3)
			suit = new String("spades");
		else
			suit = new String("ERROR");
	}

	public static Card createJoker()
	{
		Card aCard = new Card(2);
		aCard.value=14;
		aCard.suit="JOKER";
		return aCard;
	}

	/**
	 * getValue method -- returns what's stored in the instance variable value
	 * 
	 * @return the state of the instance variable value
	 */
	public int getValue()
	{
		return value;
	}

	/**
	 * getSuit method -- returns what's stored in the instance variable suit
	 * 
	 * @return a reference to a String that contains the state of the instance
	 *         variable suit
	 */
	public String getSuit()
	{
		return suit;
	}

	/**
	 * equals method -- Compares the values and suits of two card objects.
	 * 
	 * @param otherCard
	 *            a reference to another Card object
	 * @return true if both cards have the same value and suit; false otherwise
	 */
	public boolean equals(Card otherCard)
	{
		return ( (value == otherCard.value ) && (suit.equals(otherCard.suit) ) );
	}

	/**
	 * toString method -- returns the state of the card object as a string
	 * 
	 * @return a reference to a String object that contains the values stored in
	 *         the instance variables
	 */
	public String toString()
	{
		if (value == 1)
			return (new String("Ace of " + suit) );
		else if (value == 11)
			return (new String("Jack of " + suit) );
		else if (value == 12)
			return (new String("Queen of " + suit) );
		else if (value == 13)
			return (new String("King of " + suit) );
		// to return joker
		else if (value == 14)
			return (new String("JOKER") );
		else
			return (value + " of " + suit );
	}
}