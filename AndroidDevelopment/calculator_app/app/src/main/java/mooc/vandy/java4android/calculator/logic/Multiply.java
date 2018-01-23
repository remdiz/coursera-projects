package mooc.vandy.java4android.calculator.logic;

/**
 * Perform the Multiply operation.
 */
public class Multiply extends Operation{

    /**
     * Calls parent constructor
     * @param first operation argument
     * @param second operation argument
     */
    Multiply(int first, int second) {
        super(first, second);
    }

    @Override
    public String process() {
        return String.valueOf(firstArgument * secondArgument);
    }
}
