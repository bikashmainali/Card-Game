package proj3fa15;

/**
 * <p>
 * Title: Project 3--Application class
 * </p>
 *
 * <p>
 * Description: Project3App implements all the other class to make the this
 * application work properly. This program checks all the method written in Deck, discardPile and Node 
 * class to make sure all the method works properly.
 * </p>
 *
 * @author Bikash Mainali
 */

public class Proj3App
{
	public static void main(String[] args)
	{
		// new deck created with no joker just 52 cards
		Deck defaultdeck = new Deck();
		System.out.println("New default deck(1 pack with no joker) :");
		System.out.println("----------------------------------------");
		// printing state of deck
		System.out.println(defaultdeck);
		
		// shuffle deck
		defaultdeck.shuffleDeck();
		
		// state of default after shuffle
		System.out.println("Default deck(1 pack with no joker) after shuffle :");
		System.out.println("---------------------------------------------------");
		
		// printing state of deck
		System.out.println(defaultdeck);
		System.out.println("---------------------------------------------------");
		
		// testing isEmpty Method.
		System.out.println("Testing isEmpty method: ");
		System.out.println( (defaultdeck.isEmpty() ) ? "This deck is Empty" : "This deck is NOT Empty");
		System.out.println("---------------------------------------------------");
		
		// testing Cut method
		System.out.println("TESTING CUT METHOD IN DEFAULT FULL DECK");
		Card[] refOfDefDeck = defaultdeck.getCards();
		int cutNumOfDefDeck = defaultdeck.cut();
		int numCardsDefDeck = defaultdeck.getNumCards();
		System.out.println(cutNumOfDefDeck + " Cards were removed from top while cutting the deck." + "\nThat means "
				+ cutNumOfDefDeck
				+ " cards were removed from top and place in the bottom.\nThat should make card previously in "
				+ ( (cutNumOfDefDeck + 1 ) ) + " position, the topmost card in the deck after cutting.");
		System.out.print(refOfDefDeck[numCardsDefDeck - (cutNumOfDefDeck + 1 )].toString());
		System.out.println(" should be the top card of after cutting.");
		System.out.print(refOfDefDeck[numCardsDefDeck - (cutNumOfDefDeck )].toString());
		System.out.println(" should be the bottom card in the deck.");
		System.out.println("\n------------------------");
		System.out.println("State of deck after cutting");
		System.out.println("---------------------------");
		System.out.println(defaultdeck);
		System.out.println("---------------------------------------------------");
		
		//putting card in full deck
		System.out.println("Putting Cards in full deck:");
		Card[] cards = new Card[4];
		cards[0] = new Card(1);
		cards[1] = new Card(4);
		cards[2] = new Card(3);
		cards[3] = new Card(5);
		try
		{
			defaultdeck.putCardsInDeck(cards);
		}
		catch (DeckException e)
		{
			System.out.println(e.getMessage());
		}
		System.out.println("---------------------------------------------------");
		System.out.println("Size of this deck is : " + defaultdeck.getNumCards());
		System.out.println("---------------------------------------------------");
		
		
		////////////////////////////////////////////////////////////////////////////////////
		/////////////// testing of full standard deck complete            //////////////////
		////////////////////////////////////////////////////////////////////////////////////
		
		System.out.println("\nTESTING DEAL CARD METHOD.");
		System.out.println("------------------------");
		
		// generate random number from 1 to numCardsDefDeck-3
		int num = (int) (Math.random() * (numCardsDefDeck - 3 ) ) + 1;
		System.out.println("DEALING CARDS " + num + " TIMES");
		System.out.println("CARD REMAINING SHOULD BE " + (numCardsDefDeck - num ));
		for (int i = 0; i < num; i++)
			System.out.println("\t" + defaultdeck.dealCard());
		System.out.println("\nCARD REMAINING IN THE DEFAULT DECK: ");
		System.out.println("---------------------------");
		System.out.println(defaultdeck);
		System.out.println("---------------------------");
		
		// testing shuffle method in partial deck
		System.out.println("TESTING SHUFFLE METHOD IN PARTIAL DECK");
		defaultdeck.shuffleDeck();
		System.out.println("State of deck after shuffle");
		System.out.println("---------------------------");
		System.out.println(defaultdeck);
		System.out.println("-------------------------------------------");
		
		// testing cut method in partial deck
		System.out.println("TESTING CUT METHOD IN DEFAULT PARTIAL DECK");
		Card[] refOfParDeck = defaultdeck.getCards();
		int cutNumOfParDeck = defaultdeck.cut();
		int numCardsParDeck = defaultdeck.getNumCards();
		System.out.println(cutNumOfParDeck + " Cards were removed from top while cutting the deck." + "\nThat means "
				+ cutNumOfParDeck
				+ " cards were removed from top and place in the bottom.\nThat should make card previously in "
				+ ( (cutNumOfParDeck + 1 ) ) + " position, the topmost card in the deck after cutting.");
		System.out.print(refOfParDeck[numCardsParDeck - (cutNumOfParDeck + 1 )].toString());
		System.out.println(" should be the top card of after cutting.");
		System.out.print(refOfParDeck[numCardsParDeck - (cutNumOfParDeck )].toString());
		System.out.println(" should be the bottom card in the deck.");
		System.out.println("\n----------------------------");
		System.out.println("State of deck after cutting");
		System.out.println("----------------------------");
		System.out.println(defaultdeck);
		System.out.println("---------------------------------------------------");
		
		System.out.println("Testing isEmpty method in partial deck: ");
		System.out.println( (defaultdeck.isEmpty() ) ? "This deck is Empty" : "This deck is NOT Empty");
		System.out.println("---------------------------------------------------");
		System.out.println("testing putCardsInDeck method in partial deck");
		
		//putting cards in partial deck
		System.out.println("Putting Cards in partial deck:");
		Card[] cards2 = new Card[4];
		cards2[0] = new Card(1);
		cards2[1] = new Card(2);
		cards2[2] = new Card(3);
		cards2[3] = new Card(4);
		try
		{
			defaultdeck.putCardsInDeck(cards);
		}
		catch (DeckException e)
		{
			System.out.println(e.getMessage());
		}
		System.out.println("---------------------------------------------------");
		System.out.println("State of deck after inserting cards in deck\n" + defaultdeck);
		
		System.out.println("---------------------------------------------------");
		System.out.println("Size of this deck is : " + defaultdeck.getNumCards());
		System.out.println("---------------------------------------------------");
		////////////////////////////////////////////////////////////////////////////////////
		///////////////        testing of partial deck complete           //////////////////
		////////////////////////////////////////////////////////////////////////////////////
		
		int defDeckSize = defaultdeck.getNumCards();
		System.out.println("DEALING REMAING CARD");
		for (int i = 0; i < defDeckSize; i++)
			System.out.println("\t" + defaultdeck.dealCard());
		
		System.out.println("-----------------------------------");
		System.out.println("NOW NUMBER OF CARDS IN DECK IS : " + defaultdeck.getNumCards());
		System.out.println("-----------------------------------");
		
		System.out.println("\nTesting isEmpty method: ");
		System.out.println( (defaultdeck.isEmpty() ) ? "This deck is Empty" : "This deck is NOT Empty");
		
		try
		{
			System.out.println("\nDEALING CARD IN EMPTY DECK: ");
			System.out.println("-------------------------------------------------------");
			System.out.println("\t" + defaultdeck.dealCard());
		}
		catch (DeckException e)
		{
			System.out.println(e.getMessage());
			System.out.println("-------------------------------------------------------");
		}
		
		
		try
		{
			System.out.println("TESTING CUT METHOD IN EMPTY DECK: ");
			System.out.println("-------------------------------------------------------");
			System.out.println("\t" + defaultdeck.cut());
		}
		catch (DeckException e)
		{
			System.out.println(e.getMessage());
			System.out.println("-------------------------------------------------------");
		}
		
		
		System.out.println("Testing putCardsInDeck method in empty deck2");
		System.out.println("Putting Cards in empty deck2:");
		
		Card[] cards3 = new Card[2];
		cards3[0] = new Card(16);
		cards3[1] = new Card(49);
		defaultdeck.putCardsInDeck(cards3);
		System.out.println(defaultdeck);
		////////////////////////////////////////////////////////////////////////////////////
		/////////////      testing of full standard empty deck complete     ////////////////
		////////////////////////////////////////////////////////////////////////////////////
		// new deck created with no joker just 2 packets cards
		Deck deck2 = new Deck(2 , 0);
		System.out.println("New deck2(2 pack with no joker) :");
		System.out.println("----------------------------------------");
		// printing state of deck
		
		System.out.println(deck2);
		// shuffle deck
		deck2.shuffleDeck();
		
		// state of default after shuffle
		System.out.println("deck2(2 pack with no joker) after shuffle :");
		System.out.println("---------------------------------------------------");
		
		// printing state of deck
		System.out.println(deck2);
		System.out.println("---------------------------------------------------");
		
		// testing isEmpty Method.
		System.out.println("Testing isEmpty method: ");
		System.out.println( (deck2.isEmpty() ) ? "This deck is Empty" : "This deck is NOT Empty");
		System.out.println("---------------------------------------------------");
		
		// testing Cut method
		System.out.println("TESTING CUT METHOD IN DECK2 FULL DECK");
		Card[] refOfDeck2 = deck2.getCards();
		int cutNumOfDeck2 = deck2.cut();
		int numCardsDeck2 = deck2.getNumCards();
		System.out.println(
				cutNumOfDeck2 + " Cards were removed from top while cutting the deck." + "\nThat means " + cutNumOfDeck2
				+ " cards were removed from top and place in the bottom.\nThat should make card previously in "
				+ ( (cutNumOfDeck2 + 1 ) ) + " position, the topmost card in the deck after cutting.");
		System.out.print(refOfDeck2[numCardsDeck2 - (cutNumOfDeck2 + 1 )].toString());
		System.out.println(" should be the top card of after cutting.");
		System.out.print(refOfDeck2[numCardsDeck2 - (cutNumOfDeck2 )].toString());
		System.out.println(" should be the bottom card in the deck.");
		System.out.println("\n------------------------");
		System.out.println("State of deck after cutting");
		System.out.println("---------------------------");
		System.out.println(deck2);
		System.out.println("---------------------------------------------------");
		
		System.out.println("Putting Cards in full deck2:");
		Card[] cards4 = new Card[2];
		cards4[0] = new Card(16);
		cards4[1] = new Card(49);
		try
		{
			deck2.putCardsInDeck(cards4);
		}
		catch (DeckException e)
		{
			System.out.println(e.getMessage());
		}
		
		System.out.println("---------------------------------------------------");
		System.out.println("Size of this deck is : " + deck2.getNumCards());
		System.out.println("---------------------------------------------------");
		
		////////////////////////////////////////////////////////////////////////////////////
		/////////////////         testing of full deck2 complete        ////////////////////
		////////////////////////////////////////////////////////////////////////////////////
		
		System.out.println("\nTESTING DEAL CARD METHOD.");
		System.out.println("------------------------");
		
		// generate random number from 1 to numCardsDefDeck-3
		num = (int) (Math.random() * (numCardsDeck2 - 3 ) ) + 1;
		System.out.println("DEALING CARDS " + num + " TIMES");
		System.out.println("CARD REMAINING SHOULD BE " + (numCardsDeck2 - num ));
		for (int i = 0; i < num; i++)
			System.out.println("\t" + deck2.dealCard());
		System.out.println("\nCARD REMAINING IN THE DEFAULT DECK2: ");
		System.out.println("---------------------------");
		System.out.println(deck2);
		System.out.println("---------------------------");
		
		// testing shuffle method in partial deck
		System.out.println("TESTING SHUFFLE METHOD IN PARTIAL DECK2");
		deck2.shuffleDeck();
		System.out.println("State of deck2 after shuffle");
		System.out.println("---------------------------");
		System.out.println(deck2);
		System.out.println("-------------------------------------------");
		
		// testing cut method in partial deck
		System.out.println("TESTING CUT METHOD IN PARTIAL DECK2");
		Card[] refOfParDeck2 = deck2.getCards();
		int cutNumOfParDeck2 = deck2.cut();
		int numCardsParDeck2 = deck2.getNumCards();
		System.out.println(cutNumOfParDeck2 + " Cards were removed from top while cutting the deck." + "\nThat means "
				+ cutNumOfParDeck2
				+ " cards were removed from top and place in the bottom.\nThat should make card previously in "
				+ ( (cutNumOfParDeck2 + 1 ) ) + " position, the topmost card in the deck after cutting.");
		System.out.print(refOfParDeck2[numCardsParDeck2 - (cutNumOfParDeck2 + 1 )].toString());
		System.out.println(" should be the top card of after cutting.");
		System.out.print(refOfParDeck2[numCardsParDeck2 - (cutNumOfParDeck2 )].toString());
		System.out.println(" should be the bottom card in the deck.");
		System.out.println("\n----------------------------");
		System.out.println("State of deck2 after cutting");
		System.out.println("----------------------------");
		System.out.println(deck2);
		System.out.println("---------------------------------------------------");
		
		System.out.println("Testing isEmpty method in partial deck2: ");
		System.out.println( (deck2.isEmpty() ) ? "This deck is Empty" : "This deck is NOT Empty");
		System.out.println("---------------------------------------------------");
		
		System.out.println("Testing putCardsInDeck method in partial deck2");
		System.out.println("Putting Cards in partial deck2:");
		
		Card[] cards5 = new Card[2];
		cards5[0] = new Card(16);
		cards5[1] = new Card(49);
		try
		{
			deck2.putCardsInDeck(cards5);
		}
		catch (DeckException e)
		{
			System.out.println(e.getMessage());
		}
		
		System.out.println("---------------------------------------------------");
		System.out.println("State of deck after inserting cards in deck2\n" + deck2);
		System.out.println("---------------------------------------------------");
		
		System.out.println("Size of this deck2 is : " + deck2.getNumCards());
		System.out.println("---------------------------------------------------");
		////////////////////////////////////////////////////////////////////////////////////
		///////////////           testing of partial deck2 complete      ///////////////////
		///////////////////////////////////////////////////////////////////////////////////
		int Deck2Size = deck2.getNumCards();
		System.out.println("DEALING REMAING CARD IN DECK2");
		for (int i = 0; i < Deck2Size; i++)
			System.out.println("\t" + deck2.dealCard());
		
		System.out.println("-----------------------------------");
		System.out.println("NOW NUMBER OF CARDS IN DECK2 IS : " + deck2.getNumCards());
		System.out.println("-----------------------------------");
		System.out.println("\nTesting isEmpty method: ");
		System.out.println( (deck2.isEmpty() ) ? "This deck is Empty" : "This deck is NOT Empty");
		try
		{
			System.out.println("\nDEALING CARD IN EMPTY DECK2: ");
			System.out.println("-------------------------------------------------------");
			System.out.println("\t" + deck2.dealCard());
		}
		catch (DeckException e)
		{
			System.out.println(e.getMessage());
			System.out.println("-------------------------------------------------------");
		}
		
		try
		{
			System.out.println("TESTING CUT METHOD IN EMPTY DECK2: ");
			System.out.println("-------------------------------------------------------");
			System.out.println("\t" + deck2.cut());
		}
		catch (DeckException e)
		{
			System.out.println(e.getMessage());
			System.out.println("-------------------------------------------------------");
		}
		
		System.out.println("Testing putCardsInDeck method in empty deck2");
		System.out.println("Putting Cards in empty deck2:");
		
		Card[] cards6 = new Card[2];
		cards6[0] = new Card(16);
		cards6[1] = new Card(49);
		deck2.putCardsInDeck(cards6);
		System.out.println(deck2);
		
		//////////////////////////////////////////////////////////////////////////////////////
		//////////////////////           testing of deck2 complete        ////////////////////
		//////////////////////////////////////////////////////////////////////////////////////
		
		// new deck created with no joker just 2 packets cards
		Deck deck3 = new Deck(2 , 5);
		System.out.println("New deck3(2 pack with 5 joker) :");
		System.out.println("----------------------------------------");
		
		// printing state of deck
		System.out.println(deck3);
		
		// shuffle deck
		deck3.shuffleDeck();
		
		// state of default after shuffle
		System.out.println("deck2(2 pack with no joker) after shuffle :");
		System.out.println("---------------------------------------------------");
		
		// printing state of deck
		System.out.println(deck3);
		System.out.println("---------------------------------------------------");
		
		// testing isEmpty Method.
		System.out.println("Testing isEmpty method: ");
		System.out.println( (deck3.isEmpty() ) ? "This deck is Empty" : "This deck is NOT Empty");
		System.out.println("---------------------------------------------------");
		
		// testing Cut method
		System.out.println("TESTING CUT METHOD IN deck3 FULL DECK");
		Card[] refOfDeck3 = deck3.getCards();
		int cutNumOfDeck3 = deck3.cut();
		int numCardsDeck3 = deck3.getNumCards();
		System.out.println(
				cutNumOfDeck3 + " Cards were removed from top while cutting the deck." + "\nThat means " + cutNumOfDeck3
				+ " cards were removed from top and place in the bottom.\nThat should make card previously in "
				+ ( (cutNumOfDeck3 + 1 ) ) + " position, the topmost card in the deck after cutting.");
		System.out.print(refOfDeck3[numCardsDeck3 - (cutNumOfDeck3 + 1 )].toString());
		System.out.println(" should be the top card of after cutting.");
		System.out.print(refOfDeck3[numCardsDeck3 - (cutNumOfDeck3 )].toString());
		System.out.println(" should be the bottom card in the deck.");
		System.out.println("\n------------------------");
		System.out.println("State of deck after cutting");
		System.out.println("---------------------------");
		System.out.println(deck3);
		System.out.println("---------------------------------------------------");
		Card[] cards7 = new Card[2];
		cards7[0] = new Card(16);
		cards7[1] = new Card(49);
		System.out.println("Putting Cards in full Deck3:");
		try
		{
			deck3.putCardsInDeck(cards7);
		}
		catch (DeckException e)
		{
			System.out.println(e.getMessage());
		}
		
		System.out.println("---------------------------------------------------");
		System.out.println("Size of this deck is : " + deck3.getNumCards());
		System.out.println("---------------------------------------------------");
		
		////////////////////////////////////////////////////////////////////////////////////
		///////////////           testing of full Deck3 complete          //////////////////
		////////////////////////////////////////////////////////////////////////////////////
		
		System.out.println("\nTESTING DEAL CARD METHOD.");
		System.out.println("------------------------");
		// generate random number from 1 to numCardsDefDeck-3
		
		num = (int) (Math.random() * (numCardsDeck3 - 3 ) ) + 1;
		System.out.println("DEALING CARDS " + num + " TIMES");
		System.out.println("CARD REMAINING SHOULD BE " + (numCardsDeck3 - num ));
		
		for (int i = 0; i < num; i++)
			System.out.println("\t" + deck3.dealCard());
		System.out.println("\nCARD REMAINING IN THE DEFAULT deck3: ");
		System.out.println("---------------------------");
		System.out.println(deck3);
		System.out.println("---------------------------");
		
		// testing shuffle method in partial deck
		System.out.println("TESTING SHUFFLE METHOD IN PARTIAL DECK3");
		deck3.shuffleDeck();
		System.out.println("State of deck3 after shuffle");
		System.out.println("---------------------------");
		System.out.println(deck3);
		System.out.println("-------------------------------------------");
		
		// testing cut method in partial deck
		System.out.println("TESTING CUT METHOD IN PARTIAL DECK3");
		Card[] refOfPardeck3 = deck3.getCards();
		int cutNumOfPardeck3 = deck3.cut();
		int numCardsPardeck3 = deck3.getNumCards();
		System.out.println(cutNumOfPardeck3 + " Cards were removed from top while cutting the deck." + "\nThat means "
				+ cutNumOfPardeck3
				+ " cards were removed from top and place in the bottom.\nThat should make card previously in "
				+ ( (cutNumOfPardeck3 + 1 ) ) + " position, the topmost card in the deck after cutting.");
		System.out.print(refOfPardeck3[numCardsPardeck3 - (cutNumOfPardeck3 + 1 )].toString());
		System.out.println(" should be the top card of after cutting.");
		System.out.print(refOfPardeck3[numCardsPardeck3 - (cutNumOfPardeck3 )].toString());
		System.out.println(" should be the bottom card in the deck.");
		System.out.println("\n----------------------------");
		System.out.println("State of deck3 after cutting");
		System.out.println("----------------------------");
		System.out.println(deck3);
		System.out.println("---------------------------------------------------");
		System.out.println("Testing isEmpty method in partial deck3: ");
		System.out.println( (deck3.isEmpty() ) ? "This deck is Empty" : "This deck is NOT Empty");
		System.out.println("---------------------------------------------------");
		System.out.println("Testing putCardsInDeck method in partial deck3");
		System.out.println("Putting Cards in partial deck3:");
		Card[] cards8 = new Card[2];
		cards8[0] = new Card(16);
		cards8[1] = new Card(49);
		try
		{
			deck3.putCardsInDeck(cards8);
		}
		catch (DeckException e)
		{
			System.out.println(e.getMessage());
		}
		System.out.println("---------------------------------------------------");
		System.out.println("State of deck after inserting cards in deck3\n" + deck3);
		System.out.println("---------------------------------------------------");
		System.out.println("Size of this deck3 is : " + deck3.getNumCards());
		System.out.println("---------------------------------------------------");
		////////////////////////////////////////////////////////////////////////////////////
		///////////////         testing of partial deck3 complete         //////////////////
		////////////////////////////////////////////////////////////////////////////////////
		int deck3Size = deck3.getNumCards();
		System.out.println("DEALING REMAING CARD IN DECK3");
		for (int i = 0; i < deck3Size; i++)
			System.out.println("\t" + deck3.dealCard());
		System.out.println("-----------------------------------");
		System.out.println("NOW NUMBER OF CARDS IN deck3 IS : " + deck3.getNumCards());
		System.out.println("-----------------------------------");
		System.out.println("\nTesting isEmpty method: ");
		System.out.println( (deck3.isEmpty() ) ? "This deck is Empty" : "This deck is NOT Empty");
		
		try
		{
			System.out.println("\nDEALING CARD IN EMPTY deck3: ");
			System.out.println("-------------------------------------------------------");
			System.out.println("\t" + deck3.dealCard());
		}
		catch (DeckException e)
		{
			System.out.println(e.getMessage());
			System.out.println("-------------------------------------------------------");
		}
		
		try
		{
			System.out.println("TESTING CUT METHOD IN EMPTY deck3: ");
			System.out.println("-------------------------------------------------------");
			System.out.println("\t" + deck3.cut());
		}
		catch (DeckException e)
		{
			System.out.println(e.getMessage());
			System.out.println("-------------------------------------------------------");
		}
		
		System.out.println("Testing putCardsInDeck method in empty deck3");
		System.out.println("Putting Cards in empty deck3:");
		
		Card[] cards9 = new Card[2];
		cards9[0] = new Card(16);
		cards9[1] = new Card(49);
		
		deck3.putCardsInDeck(cards9);
		System.out.println(deck3);
		
		////////////////////////////////////////////////////////////////////////////////////
		/////////////////                 testing of deck3 complete          ///////////////
		////////////////////////////////////////////////////////////////////////////////////
		// checking DiscardPile class
		System.out.println("\n\tTesting DiscardPile Class\n");
		System.out.println("State of DiscardPile now");
		DiscardPile discardPile = new DiscardPile();
		System.out.println("Adding cards on DiscardPile");
		System.out.println("---------------------------");
		discardPile.addCard(new Card(14));
		System.out.println(new Card(14));
		discardPile.addCard(new Card(10));
		System.out.println(new Card(10));
		discardPile.addCard(new Card(21));
		System.out.println(new Card(21));
		discardPile.addCard(new Card(4));
		System.out.println(new Card(4));
		discardPile.addCard(new Card(51));
		System.out.println(new Card(51));
		System.out.println("----------------\n");
		System.out.println("State of DiscardPile after adding element :");
		System.out.println("-------------------------------------------");
		System.out.println(discardPile.toString());
		try
		{
			System.out.println("Trying to remove more cards from pile than it contains");
			discardPile.removeCards(7);
		}
		catch (DiscardPileException e)
		{
			System.out.println(e.getMessage());
			System.out.println("-------------------------------------------------------------------------------------");
		}
		System.out.println("\nTrying to remove a card from pile");
		System.out.println("----------------------------------");
		System.out.println(discardPile);
		System.out.println("Testing isEmpty method:");
		System.out.println( (discardPile.isEmpty() ) ? "This pile is Empty" : "This pile is NOT Empty");
		System.out.println("\nTesting size method: \nThe size of this pile is " + discardPile.size());
		System.out.println("Trying to remove 3 cards from pile");
		System.out.println("----------------------------------");
		Card[] cardInPile = discardPile.removeCards(3);
		for (int i = 0; i < cardInPile.length; i++)
		{
			System.out.println(cardInPile[i] + " is removed from Pile.");
		}
		System.out.println("\nState of DiscardPile :");
		System.out.println("----------------------");
		System.out.println(discardPile);
		System.out.println("Trying to remove 2 cards from pile");
		discardPile.removeCards(2);
		System.out.println("\nState of pile after removing:");
		System.out.println(discardPile);
		System.out.println("Trying to remove an item from empty pile");
		try
		{
			discardPile.removeCard();
		}
		catch (DiscardPileException e)
		{
			System.out.println(e.getMessage());
		}
	}
}
