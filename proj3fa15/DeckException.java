package proj3fa15;

/**
 * <p>
 * Title: DeckException class
 * </p>
 * <p>
 * Description: DeckException has just a parameterized constructor and is used
 * when all object of DeckException is created with String types of parameter.
 * </p>
 *
 * @author Bikash Mainali
 */
@SuppressWarnings("serial") 
public class DeckException extends RuntimeException
{

	/**
	 * Initializes an DeckException storing an appropriate message along with
	 * the type of the collection (as specified by the user).
	 */
	public DeckException(String collection)
	{
		super(collection);
	}
}
