package proj3fa15;
/**
 * <p>
 * Title: DiscardPileException class
 * </p>
 * <p>
 * Description: DiscardPileException has just a parameterized constructor and is used
 * when all object of DiscardPileException is created with String types of parameter.
 * </p>
 *
 * @author Bikash Mainali
 */

@SuppressWarnings("serial")
public class DiscardPileException extends RuntimeException
{

	/**
	 * Initializes an DiscardPileException storing an appropriate message
	 * along with the type of the collection (as specified by the user).
	 */
	public DiscardPileException(String collection)
	{
		super("The target element is not in this deck. " + collection);
	}
}
