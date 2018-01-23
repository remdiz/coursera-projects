package mooc.vandy.java4android.calculator.logic;

/**
 * Perform the Add operation.
 */
public class Add extends Operation {


    /**
     * Calls parent constructor
     * @param first operation argument
     * @param second operation argument
     */
    public Add(int first, int second) {

        super(first, second);

    }

    @Override
    public String process() {
        return String.valueOf(firstArgument + secondArgument);
    }
}
