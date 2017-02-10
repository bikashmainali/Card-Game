package proj3fa15;

/**
 * <p>
 * Title: The DiscardPile class
 * </p>
 * <p>
 * Description: This class represent a node that contains cards. we can add,
 * remove cards and remove a card from pile according to user choice
 * </p>
 * 
 * @author Bikash Mainali
 */
public class DiscardPile
{
	// instance variable
	private Node cardInPile;

	
	/**
	 * default DiscardPile constructor- this just assign a cardInPile null. Node is not created yet.
	 */
	public DiscardPile()
	{
		cardInPile = null;
	}

	/**
	 * addCard method - add card to be stored on top of the discard pile
	 * 
	 * @param acard
	 *            is a reference pointing to the card object in the memory.
	 */
	public void addCard(Card acard)
	{
		Node temp = cardInPile;
		cardInPile = new Node(acard , temp);
	}

	/**
	 * removeCard method - remove a card from the top of the pile.
	 * 
	 * @return the card that is just removed from the pile.
	 */
	public Card removeCard()
	{
		if (cardInPile == null)
		{
			throw new DiscardPileException("PILE IS EMPTY");
		}
		else
		{
			Node temp = cardInPile;
			cardInPile = cardInPile.getNext();
			return temp.getItem();
		}
	}

	/**
	 * removes the number of cards that is sent. If the pile contains less card
	 * than sent number then it throws exception.
	 * 
	 * @param num number of cards to be removed
	 * @return all the card that is removed from the pile.
	 */
	public Card[] removeCards(int num)
	{
		Card[] tempCard = new Card[num];
		if (num <= size())
		{
			for (int i = 0; i < num; i++)
			{
				tempCard[i] = cardInPile.getItem();
				cardInPile = cardInPile.getNext();
			}
		}
		else
		{
			throw new DiscardPileException("This deck does not contain " + num + " numbers of card.");
		}
		return tempCard;
	}

	/**
	 * return the number of size of the pile.
	 * 
	 * @return number of cards in the pile.
	 */
	public int size()
	{
		int counter = 0;
		Node temp = cardInPile;
		while (temp != null)
		{
			counter++;
			temp = temp.getNext();
		}
		return counter;
	}

	/**
	 * if the pile is empty then returns true else return false
	 * 
	 * @return true if pile is empty, false if pile is full.
	 */
	public boolean isEmpty()
	{
		return cardInPile.getItem() == null;
	}

	/**
	 * toString -- returns the state of the deck as a string
	 * 
	 * @return a string containing the cards currently in the deck
	 */
	public String toString()
	{
		String str = "";
		Node temp = cardInPile;
		int counter = 1;
		while (temp != null)
		{
			str = str + "Card at " + (counter ) + " Node: " + temp.getItem().toString() + "\n";
			temp = temp.getNext();
			counter++;
		}
		return str;
	}
}
