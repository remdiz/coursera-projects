package mooc.vandy.java4android.calculator.logic;

/**
 * Perform the Divide operation.
 */
public class Divide extends Operation{

    /**
     * Calls parent constructor
     * @param first operation argument
     * @param second operation argument
     */
    Divide(int first, int second) {
        super(first, second);
        if (second == 0)
            throw new IllegalArgumentException("Division by zero");

    }

    @Override
    public String process() {
        int result = firstArgument / secondArgument,
            remainder = firstArgument % secondArgument;
        return String.valueOf(result) + " R: " + String.valueOf(remainder);
    }
}
