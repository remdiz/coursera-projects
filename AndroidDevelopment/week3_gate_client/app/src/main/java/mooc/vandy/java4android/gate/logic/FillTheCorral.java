package mooc.vandy.java4android.gate.logic;

import java.util.Random;

import mooc.vandy.java4android.gate.ui.OutputInterface;

/**
 * This class uses your Gate class to fill the corral with snails.  We
 * have supplied you will the code necessary to execute as an app.
 * You must fill in the missing logic below.
 */
public class FillTheCorral {
    /**
     * Reference to the OutputInterface.
     */
    private OutputInterface mOut;

    /**
     * Constructor initializes the field.
     */
    FillTheCorral(OutputInterface out) {
        mOut = out;
    }

    // TODO -- Fill your code in here
    public void setCorralGates(Gate[] gate, Random selectDirection) {

        for (Gate currentGate:
             gate) {
            currentGate.setSwing(selectDirection.nextInt(3) - 1);
        }

    }
    public boolean anyCorralAvailable(Gate[] corral) {

        for (Gate gate :
                corral) {
            if (gate.getSwingDirection() == Gate.IN)
                return true;
        }
        return false;

    }
    public int corralSnails(Gate[] corral, Random rand) {

        int outToPasture = 5,
            counter = 0;
        while (outToPasture > 0) {

            int randSnails = rand.nextInt(outToPasture) + 1,
                gateIdx = rand.nextInt(corral.length);
            Gate gate = corral[gateIdx];
            outToPasture -= gate.thru(randSnails);
            mOut.println(randSnails + " are trying to move through corral " + gateIdx);
            counter++;

        }
        mOut.println("It took " + counter + " attempts to corral all of the snails.");
        return counter;

    }

}
