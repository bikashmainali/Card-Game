package proj3fa15;

/**
 * <p>
 * Title: The Deck class
 * </p>
 * <p>
 * Description: This class represents a Deck of playing cards. Size of the deck
 * depends on the default or parameterized constructor . It gets created in
 * order and then must be shuffled to randomize the order of the cards. Cards
 * are dealt from the top of the deck.
 * </p>
 * 
 * @author Darci L. Burdge and Bikash Mainali
 */
public class Deck
{
	// instance variables
	private Card[] cards;
	private int numCards;
	private int decksize;

	/**
	 * default constructor which creates the deck of 52 cards (without Jokers)
	 * in order
	 */
	public Deck()
	{
		decksize = 52;
		numCards = 52;
		cards = new Card[numCards];
		for (int i = 0; i < cards.length; i++)
		{
			cards[i] = new Card(i);
		}
	}

	/**
	 * parameterized constructor - create the number of deck with number of
	 * packet requested. It also can create joker.
	 * 
	 * @param numOfDeck
	 *            - number of packet is used to create number of 52 cards each.
	 * @param numOfJoker
	 *            - number of joker
	 */
	public Deck(int numOfDeck, int numOfJoker)
	{
		numCards = 52 * numOfDeck + numOfJoker;
		decksize = numCards;
		int counter = 0;
		int lastIndToStore = 0;
		cards = new Card[numCards];
		while (counter < numOfDeck)
		{
			for (int i = lastIndToStore; i < lastIndToStore + 52; i++)
			{
				cards[i] = new Card(i - (52 * counter ));
			}
			lastIndToStore += 52;
			counter++;
		}
		for (int i = 0; i < numOfJoker; i++)
		{
			cards[lastIndToStore + i] = Card.createJoker();
		}
	}

	/**
	 * shuffleDeck method -- places the cards in the deck in a random order
	 */
	public void shuffleDeck()
	{
		Card temp;
		int ran1, ran2;
		for (int i = 0; i < 100; i++)
		{
			ran1 = (int) (Math.random() * numCards );
			ran2 = (int) (Math.random() * numCards );
			temp = cards[ran1];
			cards[ran1] = cards[ran2];
			cards[ran2] = temp;
		}
	}

	/**
	 * dealCard -- deals the top card from the deck and decreases the number of
	 * cards in the deck by 1
	 * 
	 * @return a reference to the Card being dealt
	 */
	public Card dealCard()
	{
		if (numCards > 0)
		{
			Card temp = cards[numCards - 1];
			numCards--;
			return temp;
		}
		else
		{
			throw new DeckException("No more card remaining in this deck. Deck is empty now.");
		}
	}

	/**
	 * cut method - is removes number of cards from top of the deck and place
	 * that card on the bottom of the deck.
	 * 
	 * @return - return the number of cards removed from the top of the deck.
	 */
	public int cut()
	{
		int number;
		if (!isEmpty())
		{
			Card[] temp = new Card[decksize];
			number = (int) (Math.random() * (numCards - 1 ) + 1 );
			for (int i = 0; i < number; i++)
			{
				temp[i] = cards[numCards - number + i];
			}
			for (int j = 0; j < numCards - number; j++)
			{
				temp[j + number] = this.cards[j];
			}
			cards = temp;
		}
		else
		{
			throw new DeckException("Deck is empty now");
		}
		return number;
	}

	/**
	 * isEmpty method - check if the deck is empty or not
	 * 
	 * @return return true if the deck is and does not contain any card. If deck
	 *         is full return false.
	 */
	public boolean isEmpty()
	{
		if (numCards <= 0)
		{
			return true;
		}
		return false;
	}

	/**
	 * putCardsInDeck - put the cards back to the deck if space is available in
	 * the deck. else throw exception.
	 * 
	 * @param c
	 *            - the reference of the cards array. it contains cards to be
	 *            place in the deck.
	 */
	public void putCardsInDeck(Card[] crd)
	{
		if ((numCards + crd.length) < decksize)
		{
			int valofCardArr = crd.length;

			Card[] temp = new Card[decksize];
			int i;
			for (i = 0; i < crd.length; i++)
			{
				temp[i] = crd[i];
				crd[i] = null;
				numCards++;
			}

			for (int j = 0; j < numCards-valofCardArr; j++)
			{
				temp[i+j] = cards[j];
			}
			for (int j = 0; j < temp.length; j++)
			{
				cards[j] = temp[j];
			}
		}
		else
		{
			throw new DeckException("There is no space to put these cards in the deck.");
		}
	}

	/**
	 * returns the number of cards in the deck.
	 * 
	 * @return number of cards in the deck as int.
	 */
	public int getNumCards()
	{
		return numCards;
	}


	/**
	 * getCards method -- this return the reference pointing to the deck cards.
	 * It is used for debugging in cut method. To make sure that the cut method
	 * works properly.
	 * 
	 * @return the reference pointing to the deck cards.
	 */
	public Card[] getCards()
	{
		return cards;
	}

	/**
	 * toString -- returns the state of the deck as a string
	 * 
	 * @return a string containing the cards currently in the deck
	 */
	public String toString()
	{
		String temp = new String();
		for (int i = (numCards-1); i >= 0; i--)
		{
			temp = temp + "Card " + (numCards-i) + ": " + cards[i].toString() + "\n";
		}
		return temp;
	}
}
