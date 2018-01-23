package mooc.vandy.java4android.calculator.logic;

import mooc.vandy.java4android.calculator.logic.Add;
import mooc.vandy.java4android.calculator.logic.Divide;
import mooc.vandy.java4android.calculator.logic.Multiply;
import mooc.vandy.java4android.calculator.logic.Subtract;
import mooc.vandy.java4android.calculator.ui.ActivityInterface;

/**
 * Performs an operation selected by the user.
 */
public class Logic implements LogicInterface {
    /**
     * Reference to the Activity output.
     */
    private ActivityInterface mOut;

    /**
     * Operation type
     */
    private final int   ADDITION = 1,
                        SUBTRACTION = 2,
                        MULTIPLICATION = 3,
                        DIVISION = 4;

    /**
     * Constructor initializes the field.
     */
    public Logic(ActivityInterface out){
        mOut = out;
    }

    /**
     * Perform the @a operation on @a argumentOne and @a argumentTwo.
     */
    public void process(int argumentOne,
                        int argumentTwo,
                        int operation){

        Operation currentOp;

        try {

            switch (operation) {
                case ADDITION:
                    currentOp = new Add(argumentOne, argumentTwo);
                    break;
                case DIVISION:
                    currentOp = new Divide(argumentOne, argumentTwo);
                    break;
                case MULTIPLICATION:
                    currentOp = new Multiply(argumentOne, argumentTwo);
                    break;
                case SUBTRACTION:
                    currentOp = new Subtract(argumentOne, argumentTwo);
                    break;
                default:
                    throw new IllegalArgumentException("Unknown operation type: " + operation);
            }

            mOut.print(currentOp.process());

        } catch (IllegalArgumentException e) {
            mOut.print(e.getMessage());
        }

    }
}
