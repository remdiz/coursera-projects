package mooc.vandy.java4android.calculator.logic;

/**
 * Perform the Subtract operation.
 */
public class Subtract extends Operation{

    /**
     * Calls parent constructor
     * @param first operation argument
     * @param second operation argument
     */
    Subtract(int first, int second) {
        super(first, second);
    }

    @Override
    public String process() {
        return String.valueOf(firstArgument - secondArgument);
    }
}
