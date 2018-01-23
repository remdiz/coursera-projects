package mooc.vandy.java4android.calculator.logic;

abstract class Operation implements OperationInterface{

    final int firstArgument,
                  secondArgument;

    /**
     * Instantiates operation arguments
     * @param first
     * @param second
     */
    Operation(int first, int second) {

        firstArgument = first;
        secondArgument = second;

    }

}
